package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class DyedDecoratedPotBlock extends DecoratedPotBlock {

    private final DyeColor dyeColor;

    public DyedDecoratedPotBlock(DyeColor colour, Properties properties) {
        super(properties);
        this.dyeColor = colour;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        DyedDecoratedPotBlockEntity customDecoratedPotBlockEntity = new DyedDecoratedPotBlockEntity(blockPos, blockState);
        customDecoratedPotBlockEntity.setDyeColor(this.dyeColor.getId());
        return customDecoratedPotBlockEntity;
    }
}
