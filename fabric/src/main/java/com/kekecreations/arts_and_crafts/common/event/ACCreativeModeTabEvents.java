package com.kekecreations.arts_and_crafts.common.event;

import com.kekecreations.arts_and_crafts.common.util.PietraforteColour;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.jinxedlib.core.util.JinxedCreativeCategoryHelper;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class ACCreativeModeTabEvents {


    public static void add() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(event -> {
            event.insertAfter(Blocks.PINK_GLAZED_TERRACOTTA, ACBlocks.TERRACOTTA_SHINGLES.get());
            event.insertAfter(ACBlocks.TERRACOTTA_SHINGLES.get(), ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
            event.insertAfter(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), ACBlocks.TERRACOTTA_SHINGLE_SLAB.get());
            event.insertAfter(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get(), ACBlocks.TERRACOTTA_SHINGLE_WALL.get());


            event.insertAfter(ACBlocks.getChalk(DyeColor.PINK.getId()), ACBlocks.SOAPSTONE.get());
            event.insertAfter(ACBlocks.SOAPSTONE.get(), ACBlocks.SOAPSTONE_STAIRS.get());
            event.insertAfter(ACBlocks.SOAPSTONE_STAIRS.get(), ACBlocks.SOAPSTONE_SLAB.get());
            event.insertAfter(ACBlocks.SOAPSTONE_SLAB.get(), ACBlocks.SOAPSTONE_WALL.get());

            event.insertAfter(ACBlocks.SOAPSTONE_WALL.get(), ACBlocks.POLISHED_SOAPSTONE.get());
            event.insertAfter(ACBlocks.POLISHED_SOAPSTONE.get(), ACBlocks.POLISHED_SOAPSTONE_STAIRS.get());
            event.insertAfter(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get(), ACBlocks.POLISHED_SOAPSTONE_SLAB.get());
            event.insertAfter(ACBlocks.POLISHED_SOAPSTONE_SLAB.get(), ACBlocks.POLISHED_SOAPSTONE_WALL.get());

            event.insertAfter(ACBlocks.POLISHED_SOAPSTONE_WALL.get(), ACBlocks.SOAPSTONE_BRICKS.get());
            event.insertAfter(ACBlocks.SOAPSTONE_BRICKS.get(), ACBlocks.SOAPSTONE_BRICK_STAIRS.get());
            event.insertAfter(ACBlocks.SOAPSTONE_BRICK_STAIRS.get(), ACBlocks.SOAPSTONE_BRICK_SLAB.get());
            event.insertAfter(ACBlocks.SOAPSTONE_BRICK_SLAB.get(), ACBlocks.SOAPSTONE_BRICK_WALL.get());

            event.insertAfter(Blocks.PINK_STAINED_GLASS_PANE, ACBlocks.PLASTER.get());

            event.insertBefore(Blocks.WHITE_WOOL, ACBlocks.BLEACHED_WOOL.get());
            event.insertBefore(Blocks.WHITE_CARPET, ACBlocks.BLEACHED_CARPET.get());
            event.insertBefore(Blocks.WHITE_CONCRETE, ACBlocks.BLEACHED_CONCRETE.get());
            event.insertBefore(Blocks.WHITE_CONCRETE_POWDER, ACBlocks.BLEACHED_CONCRETE_POWDER.get());
            event.insertBefore(Blocks.WHITE_GLAZED_TERRACOTTA, ACBlocks.GLAZED_TERRACOTTA.get());
            event.insertBefore(Blocks.WHITE_BED, ACItems.BLEACHED_BED.get());

            for (DyeColor colours : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                event.insertAfter(Items.PINK_BANNER, ACBlocks.getChalk(colours.getId()));
                event.insertAfter(ACBlocks.getChalk(colours.getId()), ACBlocks.getChalkStairs(colours.getId()));
                event.insertAfter(ACBlocks.getChalkStairs(colours.getId()), ACBlocks.getChalkSlab(colours.getId()));
                event.insertAfter(ACBlocks.getChalkSlab(colours.getId()), ACBlocks.getChalkWall(colours.getId()));
                event.insertAfter(Items.PINK_CANDLE, ACBlocks.getDyedFlowerPot(colours.getId()));
                event.insertAfter(ACBlocks.getDyedFlowerPot(DyeColor.PINK.getId()), ACBlocks.getDyedDecoratedPot(colours.getId()));

                event.insertAfter(ACBlocks.TERRACOTTA_SHINGLE_WALL.get(), ACBlocks.getDyedTerracottaShingles(colours.getId()));
                event.insertAfter(ACBlocks.getDyedTerracottaShingles(colours.getId()), ACBlocks.getDyedTerracottaShingleStairs(colours.getId()));
                event.insertAfter(ACBlocks.getDyedTerracottaShingleStairs(colours.getId()), ACBlocks.getDyedTerracottaShingleSlab(colours.getId()));
                event.insertAfter(ACBlocks.getDyedTerracottaShingleSlab(colours.getId()), ACBlocks.getDyedTerracottaShingleWall(colours.getId()));

                event.insertAfter(ACBlocks.SOAPSTONE_BRICK_WALL.get(), ACBlocks.getDyedSoapstone(colours.getId()));
                event.insertAfter(ACBlocks.getDyedSoapstone(colours.getId()), ACBlocks.getDyedSoapstoneStairs(colours.getId()));
                event.insertAfter(ACBlocks.getDyedSoapstoneStairs(colours.getId()), ACBlocks.getDyedSoapstoneSlab(colours.getId()));
                event.insertAfter(ACBlocks.getDyedSoapstoneSlab(colours.getId()), ACBlocks.getDyedSoapstoneWall(colours.getId()));

                event.insertAfter(ACBlocks.getDyedSoapstoneWall(colours.getId()), ACBlocks.getDyedPolishedSoapstone(colours.getId()));
                event.insertAfter(ACBlocks.getDyedPolishedSoapstone(colours.getId()), ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()));
                event.insertAfter(ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()));
                event.insertAfter(ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()));

                event.insertAfter(ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()), ACBlocks.getDyedSoapstoneBricks(colours.getId()));
                event.insertAfter(ACBlocks.getDyedSoapstoneBricks(colours.getId()), ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
                event.insertAfter(ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()), ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()));
                event.insertAfter(ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()), ACBlocks.getDyedSoapstoneBrickWall(colours.getId()));

                event.insertAfter(ACBlocks.getDyedSoapstoneBrickWall(DyeColor.PINK.getId()), ACBlocks.getDyedMudBricks(colours.getId()));
                event.insertAfter(ACBlocks.getDyedMudBricks(colours.getId()), ACBlocks.getDyedMudBrickStairs(colours.getId()));
                event.insertAfter(ACBlocks.getDyedMudBrickStairs(colours.getId()), ACBlocks.getDyedMudBrickSlab(colours.getId()));
                event.insertAfter(ACBlocks.getDyedMudBrickSlab(colours.getId()), ACBlocks.getDyedMudBrickWall(colours.getId()));

                event.insertAfter(ACBlocks.PLASTER.get(), ACBlocks.getDyedPlaster(colours.getId()));
            }
            event.insertBefore(ACBlocks.getChalk(DyeColor.WHITE.getId()), ACBlocks.BLEACHED_CHALK.get());
            event.insertAfter(ACBlocks.BLEACHED_CHALK.get(), ACBlocks.BLEACHED_CHALK_STAIRS.get());
            event.insertAfter(ACBlocks.BLEACHED_CHALK_STAIRS.get(), ACBlocks.BLEACHED_CHALK_SLAB.get());
            event.insertAfter(ACBlocks.BLEACHED_CHALK_SLAB.get(), ACBlocks.BLEACHED_CHALK_WALL.get());
            for (PietraforteColour colour : PietraforteColour.values()) {
                event.insertAfter(ACBlocks.getDyedMudBrickWall(DyeColor.PINK.getId()), ACBlocks.getPietraforte(colour));
                event.insertAfter(ACBlocks.getPietraforte(colour), ACBlocks.getPietraforteStairs(colour));
                event.insertAfter(ACBlocks.getPietraforteStairs(colour), ACBlocks.getPietraforteSlab(colour));
                event.insertAfter(ACBlocks.getPietraforteSlab(colour), ACBlocks.getPietraforteWall(colour));

                event.insertAfter(ACBlocks.getPietraforteWall(colour), ACBlocks.getCobbledPietraforte(colour));
                event.insertAfter(ACBlocks.getCobbledPietraforte(colour), ACBlocks.getCobbledPietraforteStairs(colour));
                event.insertAfter(ACBlocks.getCobbledPietraforteStairs(colour), ACBlocks.getCobbledPietraforteSlab(colour));
                event.insertAfter(ACBlocks.getCobbledPietraforteSlab(colour), ACBlocks.getCobbledPietraforteWall(colour));

                event.insertAfter(ACBlocks.getCobbledPietraforteWall(colour), ACBlocks.getChiseledPietraforte(colour));

                event.insertAfter(ACBlocks.getChiseledPietraforte(colour), ACBlocks.getPietraforteBricks(colour));
                event.insertAfter(ACBlocks.getPietraforteBricks(colour), ACBlocks.getPietraforteBrickStairs(colour));
                event.insertAfter(ACBlocks.getPietraforteBrickStairs(colour), ACBlocks.getPietraforteBrickSlab(colour));
                event.insertAfter(ACBlocks.getPietraforteBrickSlab(colour), ACBlocks.getPietraforteBrickWall(colour));

                event.insertAfter(ACBlocks.getPietraforteBrickWall(colour), ACBlocks.getPietrafortePillar(colour));

                event.insertAfter(ACBlocks.getPietrafortePillar(colour), ACBlocks.getSmoothPietraforte(colour));
                event.insertAfter(ACBlocks.getSmoothPietraforte(colour), ACBlocks.getSmoothPietraforteStairs(colour));
                event.insertAfter(ACBlocks.getSmoothPietraforteStairs(colour), ACBlocks.getSmoothPietraforteSlab(colour));
                event.insertAfter(ACBlocks.getSmoothPietraforteSlab(colour), ACBlocks.getSmoothPietraforteWall(colour));

                event.insertAfter(ACBlocks.getSmoothPietraforteWall(colour), ACBlocks.getCutPietraforte(colour));
                event.insertAfter(ACBlocks.getCutPietraforte(colour), ACBlocks.getCutPietraforteStairs(colour));
                event.insertAfter(ACBlocks.getCutPietraforteStairs(colour), ACBlocks.getCutPietraforteSlab(colour));
                event.insertAfter(ACBlocks.getCutPietraforteSlab(colour), ACBlocks.getCutPietraforteWall(colour));
            }
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(event -> {
            event.accept(ACBlocks.getChalk(DyeColor.WHITE.getId()));
            event.accept(ACBlocks.SOAPSTONE.get());
            event.accept(ACBlocks.GYPSUM.get());
            event.insertAfter(Blocks.ACACIA_LOG, ACBlocks.CORK_LOG.get());
            event.insertAfter(Blocks.ACACIA_LEAVES, ACBlocks.CORK_LEAVES.get());
            event.insertAfter(Blocks.ACACIA_SAPLING, ACBlocks.CORK_SAPLING.get());
            event.insertAfter(Items.LILY_PAD, ACItems.LOTUS_PISTILS.get());
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(event -> {
            for (DyeColor colours : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                event.insertAfter(Items.TNT_MINECART, ACItems.getChalkStick(colours.getId()));
                event.insertAfter(Items.BRUSH, ACItems.getPaintBrush(colours.getId()));
            }
            event.insertBefore(ACItems.getPaintBrush(DyeColor.WHITE.getId()), ACItems.BLEACHDEW_PAINTBRUSH.get());
            event.insertBefore(ACItems.getChalkStick(DyeColor.WHITE.getId()), ACItems.BLEACHED_CHALK_STICK.get());
            event.insertAfter(Items.ACACIA_CHEST_BOAT, ACItems.CORK_BOAT.get());
            event.insertAfter(ACItems.CORK_BOAT.get(), ACItems.CORK_CHEST_BOAT.get());
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(event -> {
            for (DyeColor colours : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                event.insertAfter(Items.FLOWER_POT, ACBlocks.getDyedFlowerPot(colours.getId()));
                event.insertAfter(Items.DECORATED_POT, ACBlocks.getDyedDecoratedPot(colours.getId()));
            }
            event.insertAfter(Items.ACACIA_HANGING_SIGN, ACItems.CORK_SIGN.get());
            event.insertAfter(ACItems.CORK_SIGN.get(), ACItems.CORK_HANGING_SIGN.get());
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(event -> {
            event.insertAfter(Blocks.ACACIA_BUTTON, ACBlocks.CORK_LOG.get());
            event.insertAfter(ACBlocks.CORK_LOG.get(), ACBlocks.CORK_WOOD.get());
            event.insertAfter(ACBlocks.CORK_WOOD.get(), ACBlocks.STRIPPED_CORK_LOG.get());
            event.insertAfter(ACBlocks.STRIPPED_CORK_LOG.get(), ACBlocks.STRIPPED_CORK_WOOD.get());
            event.insertAfter(ACBlocks.STRIPPED_CORK_WOOD.get(), ACBlocks.CORK.get());
            event.insertAfter(ACBlocks.CORK.get(), ACBlocks.SMOOTH_CORK.get());
            event.insertAfter(ACBlocks.SMOOTH_CORK.get(), ACBlocks.CORK_PLANKS.get());
            event.insertAfter(ACBlocks.CORK_PLANKS.get(), ACBlocks.CORK_STAIRS.get());
            event.insertAfter(ACBlocks.CORK_STAIRS.get(), ACBlocks.CORK_SLAB.get());
            event.insertAfter(ACBlocks.CORK_SLAB.get(), ACBlocks.CORK_FENCE.get());
            event.insertAfter(ACBlocks.CORK_FENCE.get(), ACBlocks.CORK_FENCE_GATE.get());
            event.insertAfter(ACBlocks.CORK_FENCE_GATE.get(), ACBlocks.CORK_DOOR.get());
            event.insertAfter(ACBlocks.CORK_DOOR.get(), ACBlocks.CORK_TRAPDOOR.get());
            event.insertAfter(ACBlocks.CORK_TRAPDOOR.get(), ACBlocks.CORK_PRESSURE_PLATE.get());
            event.insertAfter(ACBlocks.CORK_PRESSURE_PLATE.get(), ACBlocks.CORK_BUTTON.get());

            event.insertAfter(Blocks.MUD_BRICK_WALL, ACBlocks.GYPSUM.get());
            event.insertAfter(ACBlocks.GYPSUM.get(), ACBlocks.GYPSUM_STAIRS.get());
            event.insertAfter(ACBlocks.GYPSUM_STAIRS.get(), ACBlocks.GYPSUM_SLAB.get());
            event.insertAfter(ACBlocks.GYPSUM_SLAB.get(), ACBlocks.GYPSUM_WALL.get());
            event.insertAfter(ACBlocks.GYPSUM_WALL.get(), ACBlocks.POLISHED_GYPSUM.get());
            event.insertAfter(ACBlocks.POLISHED_GYPSUM.get(), ACBlocks.POLISHED_GYPSUM_STAIRS.get());
            event.insertAfter(ACBlocks.POLISHED_GYPSUM_STAIRS.get(), ACBlocks.POLISHED_GYPSUM_SLAB.get());
            event.insertAfter(ACBlocks.POLISHED_GYPSUM_SLAB.get(), ACBlocks.POLISHED_GYPSUM_WALL.get());
            event.insertAfter(ACBlocks.POLISHED_GYPSUM_WALL.get(), ACBlocks.GYPSUM_BRICKS.get());
            event.insertAfter(ACBlocks.GYPSUM_BRICKS.get(), ACBlocks.GYPSUM_BRICK_STAIRS.get());
            event.insertAfter(ACBlocks.GYPSUM_BRICK_STAIRS.get(), ACBlocks.GYPSUM_BRICK_SLAB.get());
            event.insertAfter(ACBlocks.GYPSUM_BRICK_SLAB.get(), ACBlocks.GYPSUM_BRICK_WALL.get());
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(event -> {
            event.insertAfter(Items.PRIZE_POTTERY_SHERD, ACItems.ROLL_POTTERY_SHERD.get());
            event.insertBefore(Items.FRIEND_POTTERY_SHERD, ACItems.FINALE_POTTERY_SHERD.get());
            event.insertAfter(Items.FRIEND_POTTERY_SHERD, ACItems.GATEWAY_POTTERY_SHERD.get());
            event.insertBefore(Items.ANGLER_POTTERY_SHERD, ACItems.RUINED_POTTERY_SHERD.get());
            event.insertBefore(ACItems.RUINED_POTTERY_SHERD.get(), ACItems.POTTERY_SHERD.get());
            //POT AFTER PLENTY
            event.insertBefore(Items.WHITE_DYE, ACItems.BLEACHDEW.get());
        });
    }
}
