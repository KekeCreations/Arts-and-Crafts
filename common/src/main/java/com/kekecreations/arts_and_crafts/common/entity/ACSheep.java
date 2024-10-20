package com.kekecreations.arts_and_crafts.common.entity;

import java.util.*;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Shearable;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.TransientCraftingContainer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import org.jetbrains.annotations.Nullable;

public class ACSheep extends Animal implements Shearable {
    private static final int EAT_ANIMATION_TICKS = 40;
    private static final EntityDataAccessor<Byte> DATA_WOOL_ID;
    public static HashMap<Integer, Block> ITEM_BY_DYE = new HashMap<>();
    //private static final Map<DyeColor, float[]> COLORARRAY_BY_COLOR;
    public static HashMap<Integer, float[]> COLORARRAY_BY_COLOR;
    private int eatAnimationTick;
    private EatBlockGoal eatBlockGoal;
    private static final ResourceLocation BLEACHED_SHEEP_LOOT_TABLE = new ResourceLocation(ArtsAndCrafts.MOD_ID,"entities/sheep/bleached");

    public static float[] createSheepColor(int dyeColor) {
        if (dyeColor == -1) {
            return new float[]{0.843F, 0.773F, 0.604F};
        }
        else if (dyeColor == DyeColor.WHITE.getId()) {
            return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
        } else {
            float[] fs = DyeColor.byId(dyeColor).getTextureDiffuseColors();
            return new float[]{fs[0] * 0.75F, fs[1] * 0.75F, fs[2] * 0.75F};
        }
    }

    /*
    public static float[] getColorArray(DyeColor dyeColor) {
        return (float[])COLORARRAY_BY_COLOR.get(dyeColor);
    }

     */

    public ACSheep(EntityType<? extends ACSheep> entityType, Level level) {
        super(entityType, level);
    }

    protected void registerGoals() {
        this.eatBlockGoal = new EatBlockGoal(this);
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0, Sheep.class));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1, Ingredient.of(new ItemLike[]{Items.WHEAT}), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, this.eatBlockGoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    protected void customServerAiStep() {
        this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
        super.customServerAiStep();
    }

    public void aiStep() {
        if (this.level().isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }

        super.aiStep();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8.0)
                .add(Attributes.MOVEMENT_SPEED, 0.23000000417232513);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_WOOL_ID, (byte)0);
    }

    public ResourceLocation getDefaultLootTable() {
        if (this.isSheared()) {
            return this.getType().getDefaultLootTable();
        } else {
            ResourceLocation lootTable;
            if (this.getColor() == -1) {
                return BLEACHED_SHEEP_LOOT_TABLE;
            }
            switch (DyeColor.byId(this.getColor())) {
                case WHITE -> lootTable = BuiltInLootTables.SHEEP_WHITE;
                case ORANGE -> lootTable = BuiltInLootTables.SHEEP_ORANGE;
                case MAGENTA -> lootTable = BuiltInLootTables.SHEEP_MAGENTA;
                case LIGHT_BLUE -> lootTable = BuiltInLootTables.SHEEP_LIGHT_BLUE;
                case YELLOW -> lootTable = BuiltInLootTables.SHEEP_YELLOW;
                case LIME -> lootTable = BuiltInLootTables.SHEEP_LIME;
                case PINK -> lootTable = BuiltInLootTables.SHEEP_PINK;
                case GRAY -> lootTable = BuiltInLootTables.SHEEP_GRAY;
                case LIGHT_GRAY -> lootTable = BuiltInLootTables.SHEEP_LIGHT_GRAY;
                case CYAN -> lootTable = BuiltInLootTables.SHEEP_CYAN;
                case PURPLE -> lootTable = BuiltInLootTables.SHEEP_PURPLE;
                case BLUE -> lootTable = BuiltInLootTables.SHEEP_BLUE;
                case BROWN -> lootTable = BuiltInLootTables.SHEEP_BROWN;
                case GREEN -> lootTable = BuiltInLootTables.SHEEP_GREEN;
                case RED -> lootTable = BuiltInLootTables.SHEEP_RED;
                case BLACK -> lootTable = BuiltInLootTables.SHEEP_BLACK;
                default -> throw new IncompatibleClassChangeError();
            }
            return lootTable;
        }
    }

    public void handleEntityEvent(byte b) {
        if (b == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(b);
        }

    }

    public float getHeadEatPositionScale(float f) {
        if (this.eatAnimationTick <= 0) {
            return 0.0F;
        } else if (this.eatAnimationTick >= 4 && this.eatAnimationTick <= 36) {
            return 1.0F;
        } else {
            return this.eatAnimationTick < 4 ? ((float)this.eatAnimationTick - f) / 4.0F : -((float)(this.eatAnimationTick - 40) - f) / 4.0F;
        }
    }

    public float getHeadEatAngleScale(float f) {
        if (this.eatAnimationTick > 4 && this.eatAnimationTick <= 36) {
            float g = ((float)(this.eatAnimationTick - 4) - f) / 32.0F;
            return 0.62831855F + 0.21991149F * Mth.sin(g * 28.7F);
        } else {
            return this.eatAnimationTick > 0 ? 0.62831855F : this.getXRot() * 0.017453292F;
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(Items.SHEARS)) {
            if (!this.level().isClientSide && this.readyForShearing()) {
                this.shear(SoundSource.PLAYERS);
                this.gameEvent(GameEvent.SHEAR, player);
                itemStack.hurtAndBreak(1, player, (playerx) -> {
                    playerx.broadcastBreakEvent(interactionHand);
                });
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.CONSUME;
            }
        } else if (itemStack.getItem() instanceof DyeItem dyeItem) {
            if (this.isAlive() && !this.isSheared()) {
                if (this.getColor() != dyeItem.getDyeColor().getId()) {
                    this.level().playSound(player, this, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
                    if (!player.level().isClientSide) {
                        this.setColorFromDyeItem(dyeItem.getDyeColor().getId());
                        itemStack.shrink(1);
                    }
                    return InteractionResult.sidedSuccess(player.level().isClientSide);
                }
            }
        }
        return super.mobInteract(player, interactionHand);
    }

    public void shear(SoundSource soundSource) {
        this.level().playSound((Player)null, this, SoundEvents.SHEEP_SHEAR, soundSource, 1.0F, 1.0F);
        this.setSheared(true);
        int i = 1 + this.random.nextInt(3);

        for(int j = 0; j < i; ++j) {
            ItemEntity itemEntity = this.spawnAtLocation((ItemLike)ITEM_BY_DYE.get(this.getColor()), 1);
            if (itemEntity != null) {
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F), (double)(this.random.nextFloat() * 0.05F), (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)));
            }
        }

    }

    public boolean readyForShearing() {
        return this.isAlive() && !this.isSheared() && !this.isBaby();
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("Sheared", this.isSheared());
        compoundTag.putByte("Color", (byte)this.getColor());
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setSheared(compoundTag.getBoolean("Sheared"));
        this.setColor(compoundTag.getByte("Color"));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SHEEP_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.SHEEP_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SHEEP_DEATH;
    }

    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        this.playSound(SoundEvents.SHEEP_STEP, 0.15F, 1.0F);
    }

    public int getColor() {
        return this.entityData.get(DATA_WOOL_ID);
    }

    public void setColor(int dyeColor) {
        byte b = (Byte)this.entityData.get(DATA_WOOL_ID);
        this.entityData.set(DATA_WOOL_ID, (byte)(b & 240 | dyeColor));
    }
    public void setColorFromDyeItem(int dyeColor) {
        this.entityData.set(DATA_WOOL_ID, (byte) dyeColor);
    }

    public boolean isSheared() {
        //return ((Byte)this.entityData.get(DATA_WOOL_ID) & 16) != 0;
        return false;
    }

    public void setSheared(boolean bl) {
        byte b = (Byte)this.entityData.get(DATA_WOOL_ID);
        if (bl) {
            this.entityData.set(DATA_WOOL_ID, (byte)(b | 16));
        } else {
            this.entityData.set(DATA_WOOL_ID, (byte)(b & -17));
        }

    }

    public static int getRandomSheepColor(RandomSource randomSource) {
        int i = randomSource.nextInt(100);
        if (i < 5) {
            return DyeColor.BLACK.getId();
        } else if (i < 10) {
            return DyeColor.GRAY.getId();
        } else if (i < 15) {
            return DyeColor.LIGHT_GRAY.getId();
        } else if (i < 18) {
            return DyeColor.BROWN.getId();
        } else {
            return randomSource.nextInt(500) == 0 ? DyeColor.PINK.getId() : DyeColor.WHITE.getId();
        }
    }

    @Nullable
    public Animal getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        Sheep sheep = EntityType.SHEEP.create(serverLevel);
        if (sheep != null) {
            sheep.setColor(this.getOffspringColor(this, (Animal) ageableMob));
        }

        return sheep;
    }

    public void ate() {
        super.ate();
        this.setSheared(false);
        if (this.isBaby()) {
            this.ageUp(60);
        }

    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        this.setColor(-1);
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    private DyeColor getOffspringColor(Animal animal, Animal animal2) {
        DyeColor dyeColor = DyeColor.byId(((ACSheep) animal).getColor());
        DyeColor dyeColor2 = DyeColor.byId(((ACSheep)animal2).getColor());
        CraftingContainer craftingContainer = makeContainer(dyeColor, dyeColor2);
        Optional var10000 = this.level().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, craftingContainer, this.level()).map((craftingRecipe) -> {
            return craftingRecipe.assemble(craftingContainer, this.level().registryAccess());
        }).map(ItemStack::getItem);
        var10000 = var10000.filter(DyeItem.class::isInstance);
        /*
        return (DyeColor) var10000.map(DyeItem.class::cast).map(DyeItem::getDyeColor).orElseGet(() -> {
            return this.level().random.nextBoolean() ? dyeColor : dyeColor2;
        });
         */
        return this.level().random.nextBoolean() ? dyeColor : dyeColor2;
    }

    private static CraftingContainer makeContainer(DyeColor dyeColor, DyeColor dyeColor2) {
        CraftingContainer craftingContainer = new TransientCraftingContainer(new AbstractContainerMenu((MenuType)null, -1) {
            public ItemStack quickMoveStack(Player player, int i) {
                return ItemStack.EMPTY;
            }

            public boolean stillValid(Player player) {
                return false;
            }
        }, 2, 1);
        craftingContainer.setItem(0, new ItemStack(DyeItem.byColor(dyeColor)));
        craftingContainer.setItem(1, new ItemStack(DyeItem.byColor(dyeColor2)));
        return craftingContainer;
    }

    protected float getStandingEyeHeight(Pose pose, EntityDimensions entityDimensions) {
        return 0.95F * entityDimensions.height;
    }

    static {
        DATA_WOOL_ID = SynchedEntityData.defineId(ACSheep.class, EntityDataSerializers.BYTE);
        ITEM_BY_DYE.put(DyeColor.WHITE.getId(), Blocks.WHITE_WOOL);
        ITEM_BY_DYE.put(DyeColor.ORANGE.getId(), Blocks.ORANGE_WOOL);
        ITEM_BY_DYE.put(DyeColor.MAGENTA.getId(), Blocks.MAGENTA_WOOL);
        ITEM_BY_DYE.put(DyeColor.LIGHT_BLUE.getId(), Blocks.LIGHT_BLUE_WOOL);
        ITEM_BY_DYE.put(DyeColor.YELLOW.getId(), Blocks.YELLOW_WOOL);
        ITEM_BY_DYE.put(DyeColor.LIME.getId(), Blocks.LIME_WOOL);
        ITEM_BY_DYE.put(DyeColor.PINK.getId(), Blocks.PINK_WOOL);
        ITEM_BY_DYE.put(DyeColor.GRAY.getId(), Blocks.GRAY_WOOL);
        ITEM_BY_DYE.put(DyeColor.LIGHT_GRAY.getId(), Blocks.LIGHT_GRAY_WOOL);
        ITEM_BY_DYE.put(DyeColor.CYAN.getId(), Blocks.CYAN_WOOL);
        ITEM_BY_DYE.put(DyeColor.PURPLE.getId(), Blocks.PURPLE_WOOL);
        ITEM_BY_DYE.put(DyeColor.BLUE.getId(), Blocks.BLUE_WOOL);
        ITEM_BY_DYE.put(DyeColor.BROWN.getId(), Blocks.BROWN_WOOL);
        ITEM_BY_DYE.put(DyeColor.GREEN.getId(), Blocks.GREEN_WOOL);
        ITEM_BY_DYE.put(DyeColor.RED.getId(), Blocks.RED_WOOL);
        ITEM_BY_DYE.put(DyeColor.BLACK.getId(), Blocks.BLACK_WOOL);
        ITEM_BY_DYE.put(-1, ACBlocks.BLEACHED_WOOL.get());
        /*
        COLORARRAY_BY_COLOR = Maps.newEnumMap((Map)Arrays.stream(DyeColor.values()).collect(Collectors.toMap((dyeColor) -> {
            return dyeColor.intValue();
        }, ACSheep::createSheepColor)));
         */
        for (DyeColor colour : DyeColor.values()) {
          //  COLORARRAY_BY_COLOR.put(colour.getId(), ACSheep::createSheepColor())
        }
    }
}
