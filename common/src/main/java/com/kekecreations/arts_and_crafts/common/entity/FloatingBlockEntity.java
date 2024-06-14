package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.common.block.Floatable;
import com.kekecreations.arts_and_crafts.common.block.FloatingBlock;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.CrashReportCategory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Predicate;

public class FloatingBlockEntity extends Entity {
    private static final Logger LOGGER = LogUtils.getLogger();
    private BlockState blockState = ACBlocks.CORK.get().defaultBlockState();
    public int time;
    public boolean dropItem = true;
    private boolean cancelDrop;
    private boolean hurtEntities;
    private int fallDamageMax = 40;
    private float fallDamagePerDistance;
    @Nullable
    public CompoundTag blockData;
    protected static final EntityDataAccessor<BlockPos> DATA_START_POS = SynchedEntityData.defineId(FloatingBlockEntity.class, EntityDataSerializers.BLOCK_POS);


    public FloatingBlockEntity(EntityType<? extends FloatingBlockEntity> entityType, Level level) {
        super(entityType, level);
    }

    private FloatingBlockEntity(Level level, double d, double e, double f, BlockState blockState) {
        this(ACEntityTypes.FLOATING_BLOCK.get(), level);
        this.blockState = blockState;
        this.blocksBuilding = true;
        this.setPos(d, e, f);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = d;
        this.yo = e;
        this.zo = f;
        this.setStartPos(this.blockPosition());
    }

    public static FloatingBlockEntity floating(Level level, BlockPos blockPos, BlockState blockState) {
        FloatingBlockEntity floatingBlockEntity = new FloatingBlockEntity(level, (double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, blockState.hasProperty(BlockStateProperties.WATERLOGGED) ? (BlockState)blockState.setValue(BlockStateProperties.WATERLOGGED, false) : blockState);
        level.setBlock(blockPos, blockState.getFluidState().createLegacyBlock(), 3);
        level.addFreshEntity(floatingBlockEntity);
        return floatingBlockEntity;
    }

    public static boolean canCollide(Entity entity) {
        return (entity.canBeCollidedWith() || entity.isPushable());
    }

    @Override
    public boolean canCollideWith(Entity entity) {
        return FloatingBlockEntity.canCollide(entity);
    }
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    private void moveCollidedEntities(List<Entity> pEntities) {
        for (Entity entity : pEntities) {
            entity.move(MoverType.PISTON, this.getDeltaMovement().add(0, 0.3, 0));
        }
    }
    private void moveCollidedEntitiesToTheSurface(List<Entity> pEntities) {
        for (Entity entity : pEntities) {
            entity.move(MoverType.PISTON, this.getDeltaMovement().add(0, 1, 0));
        }
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    public void setStartPos(BlockPos blockPos) {
        this.entityData.set(DATA_START_POS, blockPos);
    }

    public BlockPos getStartPos() {
        return this.entityData.get(DATA_START_POS);
    }

    @Override
    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.NONE;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_START_POS, BlockPos.ZERO);
    }

    @Override
    public boolean isPickable() {
        return !this.isRemoved();
    }

    @Override
    public void tick() {
        if (this.blockState.isAir()) {
            this.discard();
            return;
        }
        Block block = this.blockState.getBlock();
        BlockHitResult blockHitResult;
        this.move(MoverType.SELF, this.getDeltaMovement());
        BlockPos blockPos = this.blockPosition();
        ++this.time;
        if (!this.level().isClientSide) {
            if (FloatingBlock.isInWater(this.level().getBlockState(blockPos.above())) && this.getDeltaMovement().y() < 0.2) {
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

    @Override
    public boolean causeFallDamage(float f, float g, DamageSource damageSource) {
        DamageSource damageSource2;
        if (!this.hurtEntities) {
            return false;
        }
        int i = Mth.ceil(f - 1.0f);
        if (i < 0) {
            return false;
        }
        Predicate<Entity> predicate = EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
        Block block = this.blockState.getBlock();
        if (block instanceof Floatable) {
            Floatable floatable = (Floatable)((Object)block);
            damageSource2 = floatable.getFallDamageSource(this);
        } else {
            damageSource2 = this.damageSources().fallingBlock(this);
        }
        DamageSource damageSource22 = damageSource2;
        float h = Math.min(Mth.floor((float)i * this.fallDamagePerDistance), this.fallDamageMax);
        this.level().getEntities(this, this.getBoundingBox(), predicate).forEach(entity -> entity.hurt(damageSource22, h));
        boolean bl = this.blockState.is(BlockTags.ANVIL);
        if (bl && h > 0.0f && this.random.nextFloat() < 0.05f + (float)i * 0.05f) {
            BlockState blockState = AnvilBlock.damage(this.blockState);
            if (blockState == null) {
                this.cancelDrop = true;
            } else {
                this.blockState = blockState;
            }
        }
        return false;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.put("BlockState", NbtUtils.writeBlockState(this.blockState));
        compoundTag.putInt("Time", this.time);
        compoundTag.putBoolean("DropItem", this.dropItem);
        compoundTag.putBoolean("HurtEntities", this.hurtEntities);
        compoundTag.putFloat("FallHurtAmount", this.fallDamagePerDistance);
        compoundTag.putInt("FallHurtMax", this.fallDamageMax);
        if (this.blockData != null) {
            compoundTag.put("TileEntityData", this.blockData);
        }
        compoundTag.putBoolean("CancelDrop", this.cancelDrop);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        this.blockState = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), compoundTag.getCompound("BlockState"));
        this.time = compoundTag.getInt("Time");
        if (compoundTag.contains("HurtEntities", 99)) {
            this.hurtEntities = compoundTag.getBoolean("HurtEntities");
            this.fallDamagePerDistance = compoundTag.getFloat("FallHurtAmount");
            this.fallDamageMax = compoundTag.getInt("FallHurtMax");
        } else if (this.blockState.is(BlockTags.ANVIL)) {
            this.hurtEntities = true;
        }
        if (compoundTag.contains("DropItem", 99)) {
            this.dropItem = compoundTag.getBoolean("DropItem");
        }
        if (compoundTag.contains("TileEntityData", 10)) {
            this.blockData = compoundTag.getCompound("TileEntityData");
        }
        this.cancelDrop = compoundTag.getBoolean("CancelDrop");
        if (this.blockState.isAir()) {
            this.blockState = Blocks.SAND.defaultBlockState();
        }
    }

    public void setHurtsEntities(float f, int i) {
        this.hurtEntities = true;
        this.fallDamagePerDistance = f;
        this.fallDamageMax = i;
    }

    public void disableDrop() {
        this.cancelDrop = true;
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }

    @Override
    public void fillCrashReportCategory(CrashReportCategory crashReportCategory) {
        super.fillCrashReportCategory(crashReportCategory);
        crashReportCategory.setDetail("Immitating BlockState", this.blockState.toString());
    }

    public BlockState getBlockState() {
        return this.blockState;
    }

    @Override
    protected Component getTypeName() {
        return Component.translatable("entity.minecraft.falling_block_type", this.blockState.getBlock().getName());
    }

    @Override
    public boolean onlyOpCanSetNbt() {
        return true;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this, Block.getId(this.getBlockState()));
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket clientboundAddEntityPacket) {
        super.recreateFromPacket(clientboundAddEntityPacket);
        this.blockState = Block.stateById(clientboundAddEntityPacket.getData());
        this.blocksBuilding = true;
        double d = clientboundAddEntityPacket.getX();
        double e = clientboundAddEntityPacket.getY();
        double f = clientboundAddEntityPacket.getZ();
        this.setPos(d, e, f);
        this.setStartPos(this.blockPosition());
    }
}