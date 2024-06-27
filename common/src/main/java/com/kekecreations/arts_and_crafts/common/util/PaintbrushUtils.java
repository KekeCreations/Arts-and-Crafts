package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.core.mixin.DecoratedPotBlockEntityAccessor;
import com.kekecreations.arts_and_crafts.core.registry.ACRegistries;
import com.kekecreations.arts_and_crafts.core.registry.ACSounds;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PaintbrushUtils {


    public static void setPotDecorations(Level level, BlockPos pos, DecoratedPotBlockEntity.Decorations decorations) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof DyedDecoratedPotBlockEntity dyedPot) {
            dyedPot.setDecoration(decorations);
        } else if (blockEntity instanceof DecoratedPotBlockEntityAccessor decoratedPot) {
            decoratedPot.setDecorations(decorations);
        }
    }

    @Nullable
    public static Block getFinalBlock(RegistryAccess access, BlockState state, ItemStack stack) {
        Optional<PaintbrushPalette> optionalPalette = access.registryOrThrow(ACRegistries.PAINTBRUSH_PALETTE).stream().filter(
                searchPalette -> searchPalette.blocks().contains(state.getBlockHolder())
        ).findFirst();
        if (optionalPalette.isEmpty()) return null;

        PaintbrushPalette palette = optionalPalette.get();
        Holder<Block> holder = palette.mappings().get(stack.getItemHolder());

        if (holder.unwrapKey().isEmpty()) return null;
        
        return access.registryOrThrow(Registries.BLOCK).getOrThrow(holder.unwrapKey().get());
    }

    public static void damagePaintbrushWhenPainting(Level level, Player player, ItemStack itemStack, BlockState blockState, BlockPos pos, InteractionHand hand) {
        if (!player.getAbilities().instabuild) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
            }
            blockState.getBlock().setPlacedBy(level, pos, blockState, player, itemStack);
            itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
            if (itemStack.isEmpty()) {
                ItemStack itemStack2 = new ItemStack(Items.BRUSH);
                itemStack2.setTag(itemStack.getTag());
                player.setItemInHand(hand, itemStack2);
            }

        }

    }
    public static void paintbrushItemEvents(Level level, BlockState state, BlockPos pos, Player player, ItemStack itemStack, InteractionHand hand) {
        level.playSound(null, pos, ACSounds.PAINT_WITH_PAINTBRUSH.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
        level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, state));
        player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
        damagePaintbrushWhenPainting(level, player, itemStack, state, pos, hand);
    }

    public static void paintBlock(Level level, BlockState blockStateToPlace, BlockPos pos, Player player, ItemStack itemStack, InteractionHand hand) {
        BlockState blockState = level.getBlockState(pos);
        level.setBlockAndUpdate(pos, blockStateToPlace.getBlock().withPropertiesOf(blockState));
        paintbrushItemEvents(level, blockState, pos, player, itemStack,  hand);
    }

    public static void paintBed(Level level, BlockState blockStateToPlace, BlockPos pos, Player player, ItemStack itemStack, InteractionHand hand) {
        BlockState blockState = level.getBlockState(pos);
        if (blockState.getValue(BlockStateProperties.BED_PART) == BedPart.FOOT) {
            level.setBlockAndUpdate(pos.relative(blockState.getValue(BlockStateProperties.HORIZONTAL_FACING)), Blocks.AIR.defaultBlockState());
            level.setBlockAndUpdate(pos, blockStateToPlace
                    .setValue(BlockStateProperties.HORIZONTAL_FACING, blockState.getValue(BlockStateProperties.HORIZONTAL_FACING))
                    .setValue(BlockStateProperties.BED_PART, BedPart.FOOT)
                    .setValue(BlockStateProperties.OCCUPIED, blockState.getValue(BlockStateProperties.OCCUPIED)));
            level.setBlockAndUpdate(pos.relative(blockState.getValue(BlockStateProperties.HORIZONTAL_FACING)), blockStateToPlace
                    .setValue(BlockStateProperties.HORIZONTAL_FACING, blockState.getValue(BlockStateProperties.HORIZONTAL_FACING))
                    .setValue(BlockStateProperties.BED_PART, BedPart.HEAD)
                    .setValue(BlockStateProperties.OCCUPIED, blockState.getValue(BlockStateProperties.OCCUPIED)));
        } else {
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            level.setBlockAndUpdate(pos, blockStateToPlace
                    .setValue(BlockStateProperties.HORIZONTAL_FACING, blockState.getValue(BlockStateProperties.HORIZONTAL_FACING))
                    .setValue(BlockStateProperties.BED_PART, BedPart.HEAD)
                    .setValue(BlockStateProperties.OCCUPIED, blockState.getValue(BlockStateProperties.OCCUPIED)));
            level.setBlockAndUpdate(pos.relative(blockState.getValue(BlockStateProperties.HORIZONTAL_FACING), -1), blockStateToPlace
                    .setValue(BlockStateProperties.HORIZONTAL_FACING, blockState.getValue(BlockStateProperties.HORIZONTAL_FACING))
                    .setValue(BlockStateProperties.BED_PART, BedPart.FOOT)
                    .setValue(BlockStateProperties.OCCUPIED, blockState.getValue(BlockStateProperties.OCCUPIED)));
        }
        itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(hand));
        level.playSound(null, pos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
        level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, blockState));
    }
}
