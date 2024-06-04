package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.CustomBedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CustomBedBlock extends BedBlock {
    public CustomBedBlock(DyeColor dyeColor, Properties $$1) {
        super(dyeColor, $$1);
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos $$0, @NotNull BlockState $$1) {
        return new CustomBedBlockEntity($$0, $$1, this.getColor());
    }
}
