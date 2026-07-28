package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.common.block.Floatable;
import com.kekecreations.arts_and_crafts.common.block.FloatingBlock;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.CrashReportCategory;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Predicate;

public class FloatingBlockEntity extends Entity {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final BlockState DEFAULT_BLOCK_STATE;
    private static final int DEFAULT_TIME = 0;
    private static final float DEFAULT_FALL_DAMAGE_PER_DISTANCE = 0.0F;
    private static final int DEFAULT_MAX_FALL_DAMAGE = 40;
    private static final boolean DEFAULT_DROP_ITEM = true;
    private static final boolean DEFAULT_CANCEL_DROP = false;
    private BlockState blockState;
    public int time;
    public boolean dropItem;
    private boolean cancelDrop;
    private boolean hurtEntities;
    private int fallDamageMax;
    private float fallDamagePerDistance;
    public @org.jspecify.annotations.Nullable CompoundTag blockData;
    public boolean forceTickAfterTeleportToDuplicate;
    protected static final EntityDataAccessor<BlockPos> DATA_START_POS;

    public FloatingBlockEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.blockState = DEFAULT_BLOCK_STATE;
        this.time = 0;
        this.dropItem = false;
        this.cancelDrop = false;
        this.fallDamageMax = 40;
        this.fallDamagePerDistance = 0.0F;
    }

    private FloatingBlockEntity(Level level, double x, double y, double z, BlockState state) {
        this(ACEntityTypes.FLOATING_BLOCK.get(), level);
        this.blockState = state;
        this.blocksBuilding = true;
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
        this.setStartPos(this.blockPosition());
    }

    public static FloatingBlockEntity floating(Level level, BlockPos pos, BlockState blockState) {
        FloatingBlockEntity floatingBlockEntity = new FloatingBlockEntity(level, (double)pos.getX() + (double)0.5F, (double)pos.getY(), (double)pos.getZ() + (double)0.5F, blockState.hasProperty(BlockStateProperties.WATERLOGGED) ? (BlockState)blockState.setValue(BlockStateProperties.WATERLOGGED, false) : blockState);
        level.setBlock(pos, blockState.getFluidState().createLegacyBlock(), 3);
        level.addFreshEntity(floatingBlockEntity);
        return floatingBlockEntity;
    }

    public boolean isAttackable() {
        return false;
    }

    public final boolean hurtServer(ServerLevel level, DamageSource damageSource, float amount) {
        if (!this.isInvulnerableToBase(damageSource)) {
            this.markHurt();
        }

        return false;
    }

    public void setStartPos(BlockPos startPos) {
        this.entityData.set(DATA_START_POS, startPos);
    }

    public BlockPos getStartPos() {
        return (BlockPos)this.entityData.get(DATA_START_POS);
    }

    protected Entity.MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(DATA_START_POS, BlockPos.ZERO);
    }

    public boolean isPickable() {
        return !this.isRemoved();
    }

    protected double getDefaultGravity() {
        return 0.04;
    }

    @Override
    public boolean canCollideWith(Entity entity) {
        return true;
    }

    @Override
    public boolean canBeCollidedWith(@Nullable Entity entity) {
        return true;
    }

    private void moveCollidedEntities(List<Entity> pEntities) {
        for (Entity entity : pEntities) {
            entity.move(MoverType.SELF, this.getDeltaMovement().add(0, 0.3, 0));
        }
    }
    private void moveCollidedEntitiesToTheSurface(List<Entity> pEntities) {
        for (Entity entity : pEntities) {
            entity.move(MoverType.PISTON, this.getDeltaMovement().add(0, 1, 0));
        }
    }

    public void tick() {
        if (this.blockState.isAir()) {
            this.discard();
            return;
        }
        this.move(MoverType.SELF, this.getDeltaMovement());
        BlockPos blockPos = this.blockPosition();
        ++this.time;
        if (!this.level().isClientSide()) {
            if (FloatingBlock.isInWater(this.level().getBlockState(blockPos.above())) && this.getDeltaMovement().y() < 0.15) {
                this.setDeltaMovement(this.getDeltaMovement().add(0, 0.1, 0));
                this.moveCollidedEntities(this.level().getEntities(this, this.getBoundingBox().inflate(0.10D), EntitySelector.NO_CREATIVE_OR_SPECTATOR));
            }
            if (FloatingBlock.isNotInWater(this.level().getBlockState(blockPos.above()))) {
                this.moveCollidedEntitiesToTheSurface(this.level().getEntities(this, this.getBoundingBox().inflate(0.10D), EntitySelector.NO_CREATIVE_OR_SPECTATOR));
                this.setDeltaMovement(0, 0, 0);
                this.level().setBlock(blockPos, blockState, 3);
                this.discard();
            }
        }
    }

    public boolean causeFallDamage(double fallDistance, float damageMultiplier, DamageSource damageSource) {
        if (!this.hurtEntities) {
            return false;
        } else {
            int i = Mth.ceil(fallDistance - (double)1.0F);
            if (i < 0) {
                return false;
            } else {
                Predicate<Entity> predicate = EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
                Block var9 = this.blockState.getBlock();
                DamageSource var10000;
                if (var9 instanceof Floatable) {
                    Floatable floatable = (Floatable) var9;
                    var10000 = floatable.getFallDamageSource(this);
                } else {
                    var10000 = this.damageSources().fallingBlock(this);
                }

                DamageSource damageSource2 = var10000;
                float f = (float)Math.min(Mth.floor((float)i * this.fallDamagePerDistance), this.fallDamageMax);
                this.level().getEntities(this, this.getBoundingBox(), predicate).forEach((entity) -> entity.hurt(damageSource2, f));
                boolean bl = this.blockState.is(BlockTags.ANVIL);
                if (bl && f > 0.0F && this.random.nextFloat() < 0.05F + (float)i * 0.05F) {
                    BlockState blockState = AnvilBlock.damage(this.blockState);
                    if (blockState == null) {
                        this.cancelDrop = true;
                    } else {
                        this.blockState = blockState;
                    }
                }

                return false;
            }
        }
    }

    protected void addAdditionalSaveData(ValueOutput output) {
        output.store("BlockState", BlockState.CODEC, this.blockState);
        output.putInt("Time", this.time);
        output.putBoolean("DropItem", this.dropItem);
        output.putBoolean("HurtEntities", this.hurtEntities);
        output.putFloat("FallHurtAmount", this.fallDamagePerDistance);
        output.putInt("FallHurtMax", this.fallDamageMax);
        if (this.blockData != null) {
            output.store("TileEntityData", CompoundTag.CODEC, this.blockData);
        }

        output.putBoolean("CancelDrop", this.cancelDrop);
    }

    protected void readAdditionalSaveData(ValueInput input) {
        this.blockState = (BlockState)input.read("BlockState", BlockState.CODEC).orElse(DEFAULT_BLOCK_STATE);
        this.time = input.getIntOr("Time", 0);
        boolean bl = this.blockState.is(BlockTags.ANVIL);
        this.hurtEntities = input.getBooleanOr("HurtEntities", bl);
        this.fallDamagePerDistance = input.getFloatOr("FallHurtAmount", 0.0F);
        this.fallDamageMax = input.getIntOr("FallHurtMax", 40);
        this.dropItem = input.getBooleanOr("DropItem", true);
        this.blockData = (CompoundTag)input.read("TileEntityData", CompoundTag.CODEC).orElse((CompoundTag) null);
        this.cancelDrop = input.getBooleanOr("CancelDrop", false);
    }

    public void setHurtsEntities(float fallDamagePerDistance, int fallDamageMax) {
        this.hurtEntities = true;
        this.fallDamagePerDistance = fallDamagePerDistance;
        this.fallDamageMax = fallDamageMax;
    }

    public void disableDrop() {
        this.cancelDrop = true;
    }

    public boolean displayFireAnimation() {
        return false;
    }

    public void fillCrashReportCategory(CrashReportCategory category) {
        super.fillCrashReportCategory(category);
        category.setDetail("Immitating BlockState", this.blockState.toString());
    }

    public BlockState getBlockState() {
        return this.blockState;
    }

    protected Component getTypeName() {
        return Component.translatable("entity.arts_and_crafts.floating_block", new Object[]{this.blockState.getBlock().getName()});
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity entity) {
        return new ClientboundAddEntityPacket(this, entity, Block.getId(this.getBlockState()));
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        this.blockState = Block.stateById(packet.getData());
        this.blocksBuilding = true;
        double d = packet.getX();
        double e = packet.getY();
        double f = packet.getZ();
        this.setPos(d, e, f);
        this.setStartPos(this.blockPosition());
    }

    public @Nullable Entity teleport(TeleportTransition teleportTransition) {
        ResourceKey<Level> resourceKey = teleportTransition.newLevel().dimension();
        ResourceKey<Level> resourceKey2 = this.level().dimension();
        boolean bl = (resourceKey2 == Level.END || resourceKey == Level.END) && resourceKey2 != resourceKey;
        Entity entity = super.teleport(teleportTransition);
        this.forceTickAfterTeleportToDuplicate = entity != null && bl;
        return entity;
    }

    static {
        DEFAULT_BLOCK_STATE = ACBlocks.CORK.get().defaultBlockState();
        DATA_START_POS = SynchedEntityData.defineId(FloatingBlockEntity.class, EntityDataSerializers.BLOCK_POS);
    }
}