package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ACChestBoat extends ChestBoat implements ACBoatAccessor {

    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);
    @Nullable
    private ResourceLocation lootTable;
    private long lootTableSeed;

    private static final EntityDataAccessor<Integer> DATA_ID_BOAT_WOOD_TYPE = SynchedEntityData.defineId(ACChestBoat.class, EntityDataSerializers.INT);


    public ACChestBoat(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public ACChestBoat(Level level, double x, double y, double z) {
        this(ACEntityTypes.CHEST_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_BOAT_WOOD_TYPE, ACBoat.WoodType.OAK.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putString("wood_type", getBoatWoodType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("wood_type", Tag.TAG_STRING)) {
            this.entityData.set(DATA_ID_BOAT_WOOD_TYPE, ACBoat.WoodType.byName(nbt.getString("wood_type")).ordinal());
        }
    }

    @Override
    public Item getDropItem() {
        return switch (ACBoat.WoodType.byId(this.entityData.get(DATA_ID_BOAT_WOOD_TYPE))) {
            case OAK -> Items.OAK_CHEST_BOAT;
            case CORK -> ACItems.CORK_CHEST_BOAT.get();
        };
    }

    public void setBoatWoodType(ACBoat.WoodType type) {
        this.entityData.set(DATA_ID_BOAT_WOOD_TYPE, type.ordinal());
    }

    public ACBoat.WoodType getBoatWoodType() {
        return ACBoat.WoodType.byId(this.entityData.get(DATA_ID_BOAT_WOOD_TYPE));
    }

}
