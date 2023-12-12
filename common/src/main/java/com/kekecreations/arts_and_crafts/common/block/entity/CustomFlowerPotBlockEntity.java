package com.kekecreations.arts_and_crafts.common.block.entity;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CustomFlowerPotBlockEntity extends BlockEntity {

    BlockState plant = Blocks.AIR.defaultBlockState();



    public CustomFlowerPotBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(KekeBlockEntityTypes.CUSTOM_FLOWER_POT.get(), blockPos, blockState);
    }


    public void setPlant(BlockState value) {
        this.plant = value;
        if (this.getLevel() != null && !this.getLevel().isClientSide) {
            this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_CLIENTS);
            this.setChanged();
        }
    }

    public BlockState getPlant() {
        return this.plant;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundTag = super.getUpdateTag();
        compoundTag.put("Plant", NbtUtils.writeBlockState(this.plant));
        return compoundTag;
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.plant = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), compoundTag.getCompound("Plant"));
    }
    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.put("Plant", NbtUtils.writeBlockState(this.plant));
    }
}
