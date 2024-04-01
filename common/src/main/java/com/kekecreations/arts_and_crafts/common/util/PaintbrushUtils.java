package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class PaintbrushUtils {

    public static BlockState placePotStatesFromAnotherBlock(BlockState blockState, BlockState oldState) {
        return blockState
                .setValue(BlockStateProperties.HORIZONTAL_FACING, oldState.getValue(BlockStateProperties.HORIZONTAL_FACING))
                .setValue(BlockStateProperties.CRACKED, oldState.getValue(BlockStateProperties.CRACKED))
                .setValue(BlockStateProperties.WATERLOGGED, oldState.getValue(BlockStateProperties.WATERLOGGED));
    }

    public static void setPotDecorations(Level level, BlockPos pos, DecoratedPotBlockEntity.Decorations decorations) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof DyedDecoratedPotBlockEntity dyedPot) {
            dyedPot.setDecoration(decorations);
        }
    }

    public static Block getDyedTerracotta(DyeColor dyeColor) {
        switch(dyeColor) {
            case BLACK -> {
                return Blocks.BLACK_TERRACOTTA;
            }
            case BLUE -> {
                return Blocks.BLUE_TERRACOTTA;
            }
            case BROWN -> {
                return Blocks.BROWN_TERRACOTTA;
            }
            case CYAN -> {
                return Blocks.CYAN_TERRACOTTA;
            }
            case GRAY -> {
                return Blocks.GRAY_TERRACOTTA;
            }
            case GREEN -> {
                return Blocks.GREEN_TERRACOTTA;
            }
            case LIGHT_BLUE -> {
                return Blocks.LIGHT_BLUE_TERRACOTTA;
            }
            case LIGHT_GRAY -> {
                return Blocks.LIGHT_GRAY_TERRACOTTA;
            }
            case LIME -> {
                return Blocks.LIME_TERRACOTTA;
            }
            case MAGENTA -> {
                return Blocks.MAGENTA_TERRACOTTA;
            }
            case ORANGE -> {
                return Blocks.ORANGE_TERRACOTTA;
            }
            case PINK -> {
                return Blocks.PINK_TERRACOTTA;
            }
            case PURPLE -> {
                return Blocks.PURPLE_TERRACOTTA;
            }
            case RED -> {
                return Blocks.RED_TERRACOTTA;
            }
            case WHITE -> {
                return Blocks.WHITE_TERRACOTTA;
            }
            case YELLOW -> {
                return Blocks.YELLOW_TERRACOTTA;
            }
            default -> {
                return Blocks.TERRACOTTA;
            }
        }
    }
}
