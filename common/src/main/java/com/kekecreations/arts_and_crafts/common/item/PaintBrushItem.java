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
                    //SOAPSTONE
                    if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedSoapstone(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE.get()))) {
                        PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedSoapstone(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedSoapstoneSlab(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_SLAB.get()))) {
                        PaintbrushUtils.paintSlab(level, KekeBlocks.getDyedSoapstoneSlab(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedSoapstoneStairs(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_STAIRS.get()))) {
                        PaintbrushUtils.paintStairs(level, KekeBlocks.getDyedSoapstoneStairs(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedSoapstoneWall(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_WALL.get()))) {
                        PaintbrushUtils.paintWall(level, KekeBlocks.getDyedSoapstoneWall(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    //SOAPSTONE BRICKS
                    if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE_BRICKS.get() && (blockState.is(KekeBlocks.getDyedSoapstoneBricks(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_BRICKS.get()))) {
                        PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedSoapstoneBricks(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE_BRICKS.get() && (blockState.is(KekeBlocks.getDyedSoapstoneBrickSlab(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_BRICK_SLAB.get()))) {
                        PaintbrushUtils.paintSlab(level, KekeBlocks.getDyedSoapstoneBrickSlab(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE_BRICKS.get() && (blockState.is(KekeBlocks.getDyedSoapstoneBrickStairs(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get()))) {
                        PaintbrushUtils.paintStairs(level, KekeBlocks.getDyedSoapstoneBrickStairs(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE_BRICKS.get() && (blockState.is(KekeBlocks.getDyedSoapstoneBrickWall(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_BRICK_WALL.get()))) {
                        PaintbrushUtils.paintWall(level, KekeBlocks.getDyedSoapstoneBrickWall(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    //POLISHED SOAPSTONE
                    if (ArtsAndCraftsCommonConfig.CAN_PAINT_POLISHED_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedPolishedSoapstone(colour.getId())) || blockState.is(KekeBlocks.POLISHED_SOAPSTONE.get()))) {
                        PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedPolishedSoapstone(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_POLISHED_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedPolishedSoapstoneSlab(colour.getId())) || blockState.is(KekeBlocks.POLISHED_SOAPSTONE_SLAB.get()))) {
                        PaintbrushUtils.paintSlab(level, KekeBlocks.getDyedPolishedSoapstoneSlab(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_POLISHED_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedPolishedSoapstoneStairs(colour.getId())) || blockState.is(KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get()))) {
                        PaintbrushUtils.paintStairs(level, KekeBlocks.getDyedPolishedSoapstoneStairs(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_POLISHED_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedPolishedSoapstoneWall(colour.getId())) || blockState.is(KekeBlocks.POLISHED_SOAPSTONE_WALL.get()))) {
                        PaintbrushUtils.paintWall(level, KekeBlocks.getDyedPolishedSoapstoneWall(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
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
                    //CONCRETE
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CONCRETE.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedConcrete(colour.getId()))) {
                        PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedConcrete(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CONCRETE_POWDER.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedConcretePowder(colour.getId()))) {
                        PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedConcretePowder(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    //CHALK
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CHALK.get() && blockState.is(KekeBlocks.getChalk(colour.getId()))) {
                        PaintbrushUtils.paintBlock(level, KekeBlocks.getChalk(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CHALK_DUST.get() && blockState.is(KekeBlocks.getChalkDust(colour))) {
                        PaintbrushUtils.paintChalkDust(level, KekeBlocks.getChalkDust(paintbrushDyeColour).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    //GLASS
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_GLASS.get() && (blockState.is(ArtsAndCraftsDyedBlockLists.getDyedGlass(colour.getId())) || blockState.is(Blocks.GLASS))) {
                        PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedGlass(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_GLASS_PANES.get() && (blockState.is(ArtsAndCraftsDyedBlockLists.getDyedGlassPanes(colour.getId())) || blockState.is(Blocks.GLASS_PANE))) {
                        PaintbrushUtils.paintGlassPane(level, ArtsAndCraftsDyedBlockLists.getDyedGlassPanes(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                    //CANDLES
                    else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CANDLES.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedCandles(colour.getId()))) {
                        PaintbrushUtils.paintCandles(level, ArtsAndCraftsDyedBlockLists.getDyedCandles(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
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
