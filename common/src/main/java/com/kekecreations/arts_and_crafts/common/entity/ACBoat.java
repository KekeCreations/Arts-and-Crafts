package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.IntFunction;

public class ACBoat extends Boat implements ACBoatAccessor {
    private static final EntityDataAccessor<Integer> DATA_ID_BOAT_WOOD_TYPE = SynchedEntityData.defineId(ACBoat.class, EntityDataSerializers.INT);

    public ACBoat(EntityType<? extends Boat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public ACBoat(Level level, double x, double y, double z) {
        this(ACEntityTypes.BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_BOAT_WOOD_TYPE, WoodType.OAK.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {
        nbt.putString("wood_type", getBoatWoodType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {
        if (nbt.contains("wood_type", Tag.TAG_STRING)) {
            this.entityData.set(DATA_ID_BOAT_WOOD_TYPE, ACBoat.WoodType.byName(nbt.getString("wood_type")).ordinal());
        }
    }

    @Override
    public Item getDropItem() {
        return switch (ACBoat.WoodType.byId(this.entityData.get(DATA_ID_BOAT_WOOD_TYPE))) {
            case OAK -> Items.OAK_BOAT;
            case CORK -> ACItems.CORK_BOAT.get();
        };
    }

    public void setBoatWoodType(ACBoat.WoodType type) {
        this.entityData.set(DATA_ID_BOAT_WOOD_TYPE, type.ordinal());
    }

    public ACBoat.WoodType getBoatWoodType() {
        return WoodType.byId(this.entityData.get(DATA_ID_BOAT_WOOD_TYPE));
    }

    public enum WoodType implements StringRepresentable {
        OAK(Blocks.OAK_PLANKS, "oak"),
        CORK(ACBlocks.CORK_PLANKS.get(), "cork");

        private final String name;
        private final Block planks;

        public static final StringRepresentable.EnumCodec<ACBoat.WoodType> CODEC;
        private static final IntFunction<ACBoat.WoodType> BY_ID;
        WoodType(Block block, String name) {
            this.name = name;
            this.planks = block;
        }
        @Override
        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static ACBoat.WoodType byId(int i) {
            return BY_ID.apply(i);
        }

        public static ACBoat.WoodType byName(String string) {
            return CODEC.byName(string, OAK);
        }

        static {
            CODEC = StringRepresentable.fromEnum(ACBoat.WoodType::values);
            BY_ID = ByIdMap.continuous(Enum::ordinal, ACBoat.WoodType.values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        }
    }

}
