package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
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

public class CustomChestBoat extends ChestBoat implements CustomBoatAccessor {

    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);
    @Nullable
    private ResourceLocation lootTable;
    private long lootTableSeed;

    private static final EntityDataAccessor<Integer> DATA_ID_BOAT_WOOD_TYPE = SynchedEntityData.defineId(CustomChestBoat.class, EntityDataSerializers.INT);


    public CustomChestBoat(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public CustomChestBoat(Level level, double x, double y, double z) {
        this(KekeEntityTypes.CHEST_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_BOAT_WOOD_TYPE, CustomBoat.WoodType.OAK.ordinal());
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
            this.entityData.set(DATA_ID_BOAT_WOOD_TYPE, CustomBoat.WoodType.byName(nbt.getString("wood_type")).ordinal());
        }
    }

    @Override
    public Item getDropItem() {
        return switch (CustomBoat.WoodType.byId(this.entityData.get(DATA_ID_BOAT_WOOD_TYPE))) {
            case OAK -> Items.OAK_CHEST_BOAT;
            case CORK -> KekeItems.CORK_CHEST_BOAT.get();
        };
    }

    public void setBoatWoodType(CustomBoat.WoodType type) {
        this.entityData.set(DATA_ID_BOAT_WOOD_TYPE, type.ordinal());
    }

    public CustomBoat.WoodType getBoatWoodType() {
        return CustomBoat.WoodType.byId(this.entityData.get(DATA_ID_BOAT_WOOD_TYPE));
    }

}
