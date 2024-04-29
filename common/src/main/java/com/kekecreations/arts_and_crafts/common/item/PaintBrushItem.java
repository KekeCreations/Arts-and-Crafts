package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class PaintBrushItem extends Item {

    private final DyeColor dyeColor;

    public PaintBrushItem(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos pos = useOnContext.getClickedPos();
        Player player = useOnContext.getPlayer();
        ItemStack itemStack = useOnContext.getItemInHand();
        DyeColor paintbrushDyeColour = this.getDyeColor();
        BlockState blockState = level.getBlockState(pos);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        InteractionHand hand = useOnContext.getHand();


        if (!level.isClientSide()) {
            for (DyeColor colour : DyeColor.values()) {
                if (colour != paintbrushDyeColour) {
                    //TERRACOTTA
                    if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA.get() && (blockState.is(ArtsAndCraftsDyedBlockLists.getDyedTerracotta(colour.getId())) || blockState.is(Blocks.TERRACOTTA))) {
                        PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedTerracotta(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_GLAZED_TERRACOTTA.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedGlazedTerracotta(colour.getId()))) {
                        BlockState paintedBlockState = ArtsAndCraftsDyedBlockLists.getDyedGlazedTerracotta(paintbrushDyeColour.getId()).defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, blockState.getValue(BlockStateProperties.HORIZONTAL_FACING));
                        PaintbrushUtils.paintBlock(level, paintedBlockState, pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA_SHINGLES.get() && (blockState.is(KekeBlocks.getDyedTerracottaShingles(colour.getId())) || blockState.is(KekeBlocks.TERRACOTTA_SHINGLES.get()))) {
                        PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedTerracottaShingles(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA_SHINGLES.get() && (blockState.is(KekeBlocks.getDyedTerracottaShingleSlab(colour.getId())) || blockState.is(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get()))) {
                        PaintbrushUtils.paintSlab(level, KekeBlocks.getDyedTerracottaShingleSlab(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA_SHINGLES.get() && (blockState.is(KekeBlocks.getDyedTerracottaShingleStairs(colour.getId())) || blockState.is(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get()))) {
                        PaintbrushUtils.paintStairs(level, KekeBlocks.getDyedTerracottaShingleStairs(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA_SHINGLES.get() && (blockState.is(KekeBlocks.getDyedTerracottaShingleWall(colour.getId())) || blockState.is(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get()))) {
                        PaintbrushUtils.paintWall(level, KekeBlocks.getDyedTerracottaShingleWall(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    //WOOL
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_WOOL.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedWool(colour.getId()))) {
                        PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedWool(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    //POTS
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_DECORATED_POTS.get() && (blockState.is(KekeBlocks.getDyedDecoratedPot(colour.getId())) || blockState.is(Blocks.DECORATED_POT))) {
                        PaintbrushUtils.paintDecoratedPot(level, blockEntity, pos, player, itemStack, hand, paintbrushDyeColour);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
