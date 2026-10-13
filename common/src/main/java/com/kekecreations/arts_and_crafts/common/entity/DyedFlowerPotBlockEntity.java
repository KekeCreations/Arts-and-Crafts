package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class DyedFlowerPotBlockEntity extends BlockEntity {

    public static final Codec<Item> CODEC = BuiltInRegistries.ITEM
            .byNameCodec();

    private Item storedPlant = Items.AIR;


    public DyedFlowerPotBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(ACEntityTypes.DYED_FLOWER_POT_BLOCK_ENTITY.get(),  worldPosition, blockState);
    }


    public Item getStoredPlant() {
        return storedPlant;
    }

    public void setStoredPlant(Item storedPlant) {
        this.storedPlant = storedPlant;
    }
    public void resetStoredPlant() {
        this.storedPlant = Items.AIR;
    }

    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.store("plant", DyedFlowerPotBlockEntity.CODEC, this.storedPlant);
    }

    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.storedPlant = input.read("plant", DyedFlowerPotBlockEntity.CODEC).orElse(Items.AIR);
    }
}
