package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsRegistries;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PaintbrushItem extends Item {

    private final DyeColor dyeColor;

    public PaintbrushItem(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    public boolean isValidRepairItem(@NotNull ItemStack stack, ItemStack repairCandidate) {
        return repairCandidate.is(DyeItem.byColor(this.getDyeColor()));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();
        BlockState blockState = level.getBlockState(pos);
        InteractionHand hand = context.getHand();
        BlockEntity blockEntity = context.getLevel().getBlockEntity(pos);

        Block finalBlock = PaintbrushUtils.getFinalBlock(level.registryAccess(), blockState, itemStack);

        if (!level.isClientSide() && finalBlock != null && finalBlock != blockState.getBlock()) {
            if (blockEntity instanceof DyedDecoratedPotBlockEntity dyedDecoratedPotBlockEntity) {
                DecoratedPotBlockEntity.Decorations oldDecorations = dyedDecoratedPotBlockEntity.getDecorations();
                PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), pos, player, itemStack, hand);
                PaintbrushUtils.setPotDecorations(level, pos, oldDecorations);
                return InteractionResult.SUCCESS;
            } else if (blockEntity instanceof DecoratedPotBlockEntity decoratedPotBlockEntity) {
                DecoratedPotBlockEntity.Decorations oldDecorations = decoratedPotBlockEntity.getDecorations();
                PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), pos, player, itemStack, hand);
                PaintbrushUtils.setPotDecorations(level, pos, oldDecorations);
                return InteractionResult.SUCCESS;
            }

            level.setBlockAndUpdate(pos, finalBlock.defaultBlockState());
            PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), pos, player, itemStack, hand);
            return InteractionResult.SUCCESS;



            /*
            if (paintbrushDyeColour == null) {
                for (DyeColor colour : DyeColor.values()) {
                    //SOAPSTONE
                    if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && blockState.is(KekeBlocks.getDyedSoapstone(colour.getId()))) {
                        PaintbrushUtils.paintBlock(level, KekeBlocks.SOAPSTONE.get().defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && blockState.is(KekeBlocks.getDyedSoapstoneSlab(colour.getId()))) {
                        PaintbrushUtils.paintSlab(level, KekeBlocks.SOAPSTONE_SLAB.get().defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && blockState.is(KekeBlocks.getDyedSoapstoneStairs(colour.getId()))) {
                        PaintbrushUtils.paintStairs(level, KekeBlocks.SOAPSTONE_STAIRS.get().defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && blockState.is(KekeBlocks.getDyedSoapstoneWall(colour.getId()))) {
                        PaintbrushUtils.paintWall(level, KekeBlocks.SOAPSTONE_WALL.get().defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    }
                }
            } else {
                for (DyeColor colour : DyeColor.values()) {
                    if (colour != paintbrushDyeColour) {
                        //SOAPSTONE
                        if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedSoapstone(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE.get()))) {
                            PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedSoapstone(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedSoapstoneSlab(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_SLAB.get()))) {
                            PaintbrushUtils.paintSlab(level, KekeBlocks.getDyedSoapstoneSlab(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedSoapstoneStairs(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_STAIRS.get()))) {
                            PaintbrushUtils.paintStairs(level, KekeBlocks.getDyedSoapstoneStairs(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedSoapstoneWall(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_WALL.get()))) {
                            PaintbrushUtils.paintWall(level, KekeBlocks.getDyedSoapstoneWall(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        //SOAPSTONE BRICKS
                        if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE_BRICKS.get() && (blockState.is(KekeBlocks.getDyedSoapstoneBricks(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_BRICKS.get()))) {
                            PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedSoapstoneBricks(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE_BRICKS.get() && (blockState.is(KekeBlocks.getDyedSoapstoneBrickSlab(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_BRICK_SLAB.get()))) {
                            PaintbrushUtils.paintSlab(level, KekeBlocks.getDyedSoapstoneBrickSlab(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE_BRICKS.get() && (blockState.is(KekeBlocks.getDyedSoapstoneBrickStairs(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get()))) {
                            PaintbrushUtils.paintStairs(level, KekeBlocks.getDyedSoapstoneBrickStairs(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_SOAPSTONE_BRICKS.get() && (blockState.is(KekeBlocks.getDyedSoapstoneBrickWall(colour.getId())) || blockState.is(KekeBlocks.SOAPSTONE_BRICK_WALL.get()))) {
                            PaintbrushUtils.paintWall(level, KekeBlocks.getDyedSoapstoneBrickWall(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        //POLISHED SOAPSTONE
                        if (ArtsAndCraftsCommonConfig.CAN_PAINT_POLISHED_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedPolishedSoapstone(colour.getId())) || blockState.is(KekeBlocks.POLISHED_SOAPSTONE.get()))) {
                            PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedPolishedSoapstone(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_POLISHED_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedPolishedSoapstoneSlab(colour.getId())) || blockState.is(KekeBlocks.POLISHED_SOAPSTONE_SLAB.get()))) {
                            PaintbrushUtils.paintSlab(level, KekeBlocks.getDyedPolishedSoapstoneSlab(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_POLISHED_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedPolishedSoapstoneStairs(colour.getId())) || blockState.is(KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get()))) {
                            PaintbrushUtils.paintStairs(level, KekeBlocks.getDyedPolishedSoapstoneStairs(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_POLISHED_SOAPSTONE.get() && (blockState.is(KekeBlocks.getDyedPolishedSoapstoneWall(colour.getId())) || blockState.is(KekeBlocks.POLISHED_SOAPSTONE_WALL.get()))) {
                            PaintbrushUtils.paintWall(level, KekeBlocks.getDyedPolishedSoapstoneWall(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        //TERRACOTTA
                        if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA.get() && (blockState.is(ArtsAndCraftsDyedBlockLists.getDyedTerracotta(colour.getId())) || blockState.is(Blocks.TERRACOTTA))) {
                            PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedTerracotta(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_GLAZED_TERRACOTTA.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedGlazedTerracotta(colour.getId()))) {
                            BlockState paintedBlockState = ArtsAndCraftsDyedBlockLists.getDyedGlazedTerracotta(paintbrushDyeColour.getId()).defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, blockState.getValue(BlockStateProperties.HORIZONTAL_FACING));
                            PaintbrushUtils.paintBlock(level, paintedBlockState, pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA_SHINGLES.get() && (blockState.is(KekeBlocks.getDyedTerracottaShingles(colour.getId())) || blockState.is(KekeBlocks.TERRACOTTA_SHINGLES.get()))) {
                            PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedTerracottaShingles(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA_SHINGLES.get() && (blockState.is(KekeBlocks.getDyedTerracottaShingleSlab(colour.getId())) || blockState.is(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get()))) {
                            PaintbrushUtils.paintSlab(level, KekeBlocks.getDyedTerracottaShingleSlab(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA_SHINGLES.get() && (blockState.is(KekeBlocks.getDyedTerracottaShingleStairs(colour.getId())) || blockState.is(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get()))) {
                            PaintbrushUtils.paintStairs(level, KekeBlocks.getDyedTerracottaShingleStairs(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA_SHINGLES.get() && (blockState.is(KekeBlocks.getDyedTerracottaShingleWall(colour.getId())) || blockState.is(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get()))) {
                            PaintbrushUtils.paintWall(level, KekeBlocks.getDyedTerracottaShingleWall(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        //WOOL
                        else if (ArtsAndCraftsCommonConfig.CAN_PAINT_WOOL.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedWool(colour.getId()))) {
                            PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedWool(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CARPET.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedCarpet(colour.getId()))) {
                            PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedCarpet(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        //MUD BRICKS
                        else if (ArtsAndCraftsCommonConfig.CAN_PAINT_MUD_BRICKS.get() && (blockState.is(KekeBlocks.getDyedMudBricks(colour.getId())) || blockState.is(Blocks.MUD_BRICKS))) {
                            PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedMudBricks(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_MUD_BRICKS.get() && (blockState.is(KekeBlocks.getDyedMudBrickSlab(colour.getId())) || blockState.is(Blocks.MUD_BRICK_SLAB))) {
                            PaintbrushUtils.paintSlab(level, KekeBlocks.getDyedMudBrickSlab(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_MUD_BRICKS.get() && (blockState.is(KekeBlocks.getDyedMudBrickStairs(colour.getId())) || blockState.is(Blocks.MUD_BRICK_STAIRS))) {
                            PaintbrushUtils.paintStairs(level, KekeBlocks.getDyedMudBrickStairs(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_MUD_BRICKS.get() && (blockState.is(KekeBlocks.getDyedMudBrickWall(colour.getId())) || blockState.is(Blocks.MUD_BRICK_WALL))) {
                            PaintbrushUtils.paintWall(level, KekeBlocks.getDyedMudBrickWall(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        //CONCRETE
                        else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CONCRETE.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedConcrete(colour.getId()))) {
                            PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedConcrete(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CONCRETE_POWDER.get() && blockState.is(ArtsAndCraftsDyedBlockLists.getDyedConcretePowder(colour.getId()))) {
                            PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedConcretePowder(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        //CHALK
                        else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CHALK.get() && blockState.is(KekeBlocks.getChalk(colour.getId()))) {
                            PaintbrushUtils.paintBlock(level, KekeBlocks.getChalk(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_CHALK_DUST.get() && blockState.is(KekeBlocks.getChalkDust(colour))) {
                            PaintbrushUtils.paintChalkDust(level, KekeBlocks.getChalkDust(paintbrushDyeColour).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        //PLASTER
                        else if (ArtsAndCraftsCommonConfig.CAN_PAINT_PLASTER.get() && (blockState.is(KekeBlocks.getDyedPlaster(colour.getId())) || blockState.is(KekeBlocks.PLASTER.get()))) {
                            PaintbrushUtils.paintPlaster(level, KekeBlocks.getDyedPlaster(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        }
                        //GLASS
                        else if (ArtsAndCraftsCommonConfig.CAN_PAINT_GLASS.get() && (blockState.is(ArtsAndCraftsDyedBlockLists.getDyedGlass(colour.getId())) || blockState.is(Blocks.GLASS))) {
                            PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedGlass(paintbrushDyeColour.getId()).defaultBlockState(), pos, player, itemStack, hand);
                            return InteractionResult.SUCCESS;
                        } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_GLASS_PANES.get() && (blockState.is(ArtsAndCraftsDyedBlockLists.getDyedGlassPanes(colour.getId())) || blockState.is(Blocks.GLASS_PANE))) {
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
            */
        }
        return InteractionResult.FAIL;
    }
}
