package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.common.block.ACBedBlock;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ACBedBlockEntity extends BlockEntity {

    private DyeColor color;

    public ACBedBlockEntity(BlockPos $$0, BlockState $$1) {
        super(ACEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), $$0, $$1);
        this.color = ((ACBedBlock)$$1.getBlock()).getColor();
    }

    public ACBedBlockEntity(BlockPos $$0, BlockState $$1, DyeColor $$2) {
        super(ACEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), $$0, $$1);
        this.color = $$2;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public DyeColor getColor() {
        return this.color;
    }

    public void setColor(DyeColor $$0) {
        this.color = $$0;
    }
}
