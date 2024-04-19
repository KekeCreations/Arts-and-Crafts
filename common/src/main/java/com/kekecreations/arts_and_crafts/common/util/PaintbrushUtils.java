package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;

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
    public static void damagePaintbrushWhenPainting(Level level, Player player, ItemStack itemStack, BlockState blockState, BlockPos pos, InteractionHand hand) {
        if (!player.getAbilities().instabuild) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
            }
            blockState.getBlock().setPlacedBy(level, pos, blockState, player, itemStack);
            itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
        }

    }

    public static void paintBlock(Level level, BlockState blockStateToPlace, BlockPos pos, Player player, ItemStack itemStack, InteractionHand hand) {
        BlockState blockState = level.getBlockState(pos);
        level.setBlockAndUpdate(pos, blockStateToPlace);
        level.playSound(null, pos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
        level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, blockState));
        damagePaintbrushWhenPainting(level, player, itemStack, blockState, pos, hand);
    }
    public static void paintDecoratedPot(Level level, BlockEntity blockEntity, BlockPos pos, Player player, ItemStack itemStack, InteractionHand hand, DyeColor paintbrushDyeColour) {
        BlockState blockState = level.getBlockState(pos);
        RandomSource randomSource = level.getRandom();
        if (blockEntity instanceof DyedDecoratedPotBlockEntity dyedDecoratedPotBlockEntity) {
            DecoratedPotBlockEntity.Decorations oldDecorations = dyedDecoratedPotBlockEntity.getDecorations();
            DyedDecoratedPotBlock placedPot = (DyedDecoratedPotBlock) KekeBlocks.getDyedDecoratedPot(paintbrushDyeColour.getId());
            level.setBlockAndUpdate(pos, PaintbrushUtils.placePotStatesFromAnotherBlock(placedPot.defaultBlockState(), blockState));
            PaintbrushUtils.setPotDecorations(level, pos, oldDecorations);
        }
        else if (blockEntity instanceof DecoratedPotBlockEntity decoratedPotBlockEntity) {
            DecoratedPotBlockEntity.Decorations oldDecorations = decoratedPotBlockEntity.getDecorations();
            DyedDecoratedPotBlock placedPot = (DyedDecoratedPotBlock) KekeBlocks.getDyedDecoratedPot(paintbrushDyeColour.getId());
            level.setBlockAndUpdate(pos, PaintbrushUtils.placePotStatesFromAnotherBlock(placedPot.defaultBlockState(), blockState));
            PaintbrushUtils.setPotDecorations(level, pos, oldDecorations);
        }
        level.playSound(null, pos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.2F + 0.9F);
        level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, blockState));
        damagePaintbrushWhenPainting(level, player, itemStack, blockState, pos, hand);
    }

    public static Block getDyedWool(DyeColor dyeColor) {
        switch (dyeColor) {
            case BLACK -> {
                return Blocks.BLACK_WOOL;
            }
            case BLUE -> {
                return Blocks.BLUE_WOOL;
            }
            case BROWN -> {
                return Blocks.BROWN_WOOL;
            }
            case CYAN -> {
                return Blocks.CYAN_WOOL;
            }
            case GRAY -> {
                return Blocks.GRAY_WOOL;
            }
            case GREEN -> {
                return Blocks.GREEN_WOOL;
            }
            case LIGHT_BLUE -> {
                return Blocks.LIGHT_BLUE_WOOL;
            }
            case LIGHT_GRAY -> {
                return Blocks.LIGHT_GRAY_WOOL;
            }
            case LIME -> {
                return Blocks.LIME_WOOL;
            }
            case MAGENTA -> {
                return Blocks.MAGENTA_WOOL;
            }
            case ORANGE -> {
                return Blocks.ORANGE_WOOL;
            }
            case PINK -> {
                return Blocks.PINK_WOOL;
            }
            case PURPLE -> {
                return Blocks.PURPLE_WOOL;
            }
            case RED -> {
                return Blocks.RED_WOOL;
            }
            case WHITE -> {
                return Blocks.WHITE_WOOL;
            }
            case YELLOW -> {
                return Blocks.YELLOW_WOOL;
            }
            default -> {
                return Blocks.WHITE_WOOL;
            }
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
