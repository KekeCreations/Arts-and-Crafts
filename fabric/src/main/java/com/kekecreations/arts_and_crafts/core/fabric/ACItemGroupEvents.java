package com.kekecreations.arts_and_crafts.core.fabric;

import com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class ACItemGroupEvents {


    public static void add() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(event -> {
            event.addAfter(Blocks.PINK_GLAZED_TERRACOTTA, ACBlocks.TERRACOTTA_SHINGLES.get());
            event.addAfter(ACBlocks.TERRACOTTA_SHINGLES.get(), ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
            event.addAfter(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), ACBlocks.TERRACOTTA_SHINGLE_SLAB.get());
            event.addAfter(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get(), ACBlocks.TERRACOTTA_SHINGLE_WALL.get());


            event.addAfter(ACBlocks.getChalk(DyeColor.PINK.getId()), ACBlocks.SOAPSTONE.get());
            event.addAfter(ACBlocks.SOAPSTONE.get(), ACBlocks.SOAPSTONE_STAIRS.get());
            event.addAfter(ACBlocks.SOAPSTONE_STAIRS.get(), ACBlocks.SOAPSTONE_SLAB.get());
            event.addAfter(ACBlocks.SOAPSTONE_SLAB.get(), ACBlocks.SOAPSTONE_WALL.get());

            event.addAfter(ACBlocks.SOAPSTONE_WALL.get(), ACBlocks.POLISHED_SOAPSTONE.get());
            event.addAfter(ACBlocks.POLISHED_SOAPSTONE.get(), ACBlocks.POLISHED_SOAPSTONE_STAIRS.get());
            event.addAfter(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get(), ACBlocks.POLISHED_SOAPSTONE_SLAB.get());
            event.addAfter(ACBlocks.POLISHED_SOAPSTONE_SLAB.get(), ACBlocks.POLISHED_SOAPSTONE_WALL.get());

            event.addAfter(ACBlocks.POLISHED_SOAPSTONE_WALL.get(), ACBlocks.SOAPSTONE_BRICKS.get());
            event.addAfter(ACBlocks.SOAPSTONE_BRICKS.get(), ACBlocks.SOAPSTONE_BRICK_STAIRS.get());
            event.addAfter(ACBlocks.SOAPSTONE_BRICK_STAIRS.get(), ACBlocks.SOAPSTONE_BRICK_SLAB.get());
            event.addAfter(ACBlocks.SOAPSTONE_BRICK_SLAB.get(), ACBlocks.SOAPSTONE_BRICK_WALL.get());

            event.addAfter(Blocks.PINK_STAINED_GLASS_PANE, ACBlocks.PLASTER.get());

            event.addBefore(Blocks.WHITE_WOOL, ACBlocks.BLEACHED_WOOL.get());
            event.addBefore(Blocks.WHITE_CARPET, ACBlocks.BLEACHED_CARPET.get());
            event.addBefore(Blocks.WHITE_CONCRETE, ACBlocks.BLEACHED_CONCRETE.get());
            event.addBefore(Blocks.WHITE_CONCRETE_POWDER, ACBlocks.BLEACHED_CONCRETE_POWDER.get());
            event.addBefore(Blocks.WHITE_GLAZED_TERRACOTTA, ACBlocks.GLAZED_TERRACOTTA.get());
            event.addBefore(Blocks.WHITE_BED, ACItems.BLEACHED_BED.get());

            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                event.addAfter(Items.PINK_BANNER, ACBlocks.getChalk(colours.getId()));
                event.addAfter(Items.PINK_CANDLE, ACBlocks.getDyedFlowerPot(colours.getId()));
                event.addAfter(ACBlocks.getDyedFlowerPot(DyeColor.PINK.getId()), ACBlocks.getDyedDecoratedPot(colours.getId()));

                event.addAfter(ACBlocks.TERRACOTTA_SHINGLE_WALL.get(), ACBlocks.getDyedTerracottaShingles(colours.getId()));
                event.addAfter(ACBlocks.getDyedTerracottaShingles(colours.getId()), ACBlocks.getDyedTerracottaShingleStairs(colours.getId()));
                event.addAfter(ACBlocks.getDyedTerracottaShingleStairs(colours.getId()), ACBlocks.getDyedTerracottaShingleSlab(colours.getId()));
                event.addAfter(ACBlocks.getDyedTerracottaShingleSlab(colours.getId()), ACBlocks.getDyedTerracottaShingleWall(colours.getId()));

                event.addAfter(ACBlocks.SOAPSTONE_BRICK_WALL.get(), ACBlocks.getDyedSoapstone(colours.getId()));
                event.addAfter(ACBlocks.getDyedSoapstone(colours.getId()), ACBlocks.getDyedSoapstoneStairs(colours.getId()));
                event.addAfter(ACBlocks.getDyedSoapstoneStairs(colours.getId()), ACBlocks.getDyedSoapstoneSlab(colours.getId()));
                event.addAfter(ACBlocks.getDyedSoapstoneSlab(colours.getId()), ACBlocks.getDyedSoapstoneWall(colours.getId()));

                event.addAfter(ACBlocks.getDyedSoapstoneWall(colours.getId()), ACBlocks.getDyedPolishedSoapstone(colours.getId()));
                event.addAfter(ACBlocks.getDyedPolishedSoapstone(colours.getId()), ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()));
                event.addAfter(ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()));
                event.addAfter(ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()));

                event.addAfter(ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()), ACBlocks.getDyedSoapstoneBricks(colours.getId()));
                event.addAfter(ACBlocks.getDyedSoapstoneBricks(colours.getId()), ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
                event.addAfter(ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()), ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()));
                event.addAfter(ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()), ACBlocks.getDyedSoapstoneBrickWall(colours.getId()));

                event.addAfter(ACBlocks.getDyedSoapstoneBrickWall(DyeColor.PINK.getId()), ACBlocks.getDyedMudBricks(colours.getId()));
                event.addAfter(ACBlocks.getDyedMudBricks(colours.getId()), ACBlocks.getDyedMudBrickStairs(colours.getId()));
                event.addAfter(ACBlocks.getDyedMudBrickStairs(colours.getId()), ACBlocks.getDyedMudBrickSlab(colours.getId()));
                event.addAfter(ACBlocks.getDyedMudBrickSlab(colours.getId()), ACBlocks.getDyedMudBrickWall(colours.getId()));

                event.addAfter(ACBlocks.PLASTER.get(), ACBlocks.getDyedPlaster(colours.getId()));
            }
            event.addBefore(ACBlocks.getChalk(DyeColor.WHITE.getId()), ACBlocks.BLEACHED_CHALK.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(event -> {
            event.accept(ACBlocks.getChalk(DyeColor.WHITE.getId()));
            event.accept(ACBlocks.SOAPSTONE.get());
            event.accept(ACBlocks.GYPSUM.get());
            event.addAfter(Blocks.ACACIA_LOG, ACBlocks.CORK_LOG.get());
            event.addAfter(Blocks.ACACIA_LEAVES, ACBlocks.CORK_LEAVES.get());
            event.addAfter(Blocks.ACACIA_SAPLING, ACBlocks.CORK_SAPLING.get());
            event.addAfter(Items.LILY_PAD, ACItems.LOTUS_PISTILS.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(event -> {
            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                event.addAfter(Items.MUSIC_DISC_RELIC, ACItems.getChalkStick(colours.getId()));
                event.addAfter(ACItems.getChalkStick(DyeColor.PINK.getId()), ACItems.getPaintBrush(colours.getId()));
            }
            event.addBefore(ACItems.getPaintBrush(DyeColor.WHITE.getId()), ACItems.BLEACHDEW_PAINTBRUSH.get());
            event.addBefore(ACItems.getChalkStick(DyeColor.WHITE.getId()), ACItems.BLEACHED_CHALK_STICK.get());
            event.addAfter(Items.ACACIA_CHEST_BOAT, ACItems.CORK_BOAT.get());
            event.addAfter(ACItems.CORK_BOAT.get(), ACItems.CORK_CHEST_BOAT.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(event -> {
            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                event.addAfter(Items.FLOWER_POT, ACBlocks.getDyedFlowerPot(colours.getId()));
                event.addAfter(Items.DECORATED_POT, ACBlocks.getDyedDecoratedPot(colours.getId()));
            }
            event.addAfter(Items.ACACIA_HANGING_SIGN, ACItems.CORK_SIGN.get());
            event.addAfter(ACItems.CORK_SIGN.get(), ACItems.CORK_HANGING_SIGN.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(event -> {
            event.addAfter(Blocks.ACACIA_BUTTON, ACBlocks.CORK_LOG.get());
            event.addAfter(ACBlocks.CORK_LOG.get(), ACBlocks.CORK_WOOD.get());
            event.addAfter(ACBlocks.CORK_WOOD.get(), ACBlocks.STRIPPED_CORK_LOG.get());
            event.addAfter(ACBlocks.STRIPPED_CORK_LOG.get(), ACBlocks.STRIPPED_CORK_WOOD.get());
            event.addAfter(ACBlocks.STRIPPED_CORK_WOOD.get(), ACBlocks.CORK.get());
            event.addAfter(ACBlocks.CORK.get(), ACBlocks.SMOOTH_CORK.get());
            event.addAfter(ACBlocks.SMOOTH_CORK.get(), ACBlocks.CORK_PLANKS.get());
            event.addAfter(ACBlocks.CORK_PLANKS.get(), ACBlocks.CORK_STAIRS.get());
            event.addAfter(ACBlocks.CORK_STAIRS.get(), ACBlocks.CORK_SLAB.get());
            event.addAfter(ACBlocks.CORK_SLAB.get(), ACBlocks.CORK_FENCE.get());
            event.addAfter(ACBlocks.CORK_FENCE.get(), ACBlocks.CORK_FENCE_GATE.get());
            event.addAfter(ACBlocks.CORK_FENCE_GATE.get(), ACBlocks.CORK_DOOR.get());
            event.addAfter(ACBlocks.CORK_DOOR.get(), ACBlocks.CORK_TRAPDOOR.get());
            event.addAfter(ACBlocks.CORK_TRAPDOOR.get(), ACBlocks.CORK_PRESSURE_PLATE.get());
            event.addAfter(ACBlocks.CORK_PRESSURE_PLATE.get(), ACBlocks.CORK_BUTTON.get());

            event.addAfter(Blocks.MUD_BRICK_WALL, ACBlocks.GYPSUM.get());
            event.addAfter(ACBlocks.GYPSUM.get(), ACBlocks.GYPSUM_STAIRS.get());
            event.addAfter(ACBlocks.GYPSUM_STAIRS.get(), ACBlocks.GYPSUM_SLAB.get());
            event.addAfter(ACBlocks.GYPSUM_SLAB.get(), ACBlocks.GYPSUM_WALL.get());
            event.addAfter(ACBlocks.GYPSUM_WALL.get(), ACBlocks.POLISHED_GYPSUM.get());
            event.addAfter(ACBlocks.POLISHED_GYPSUM.get(), ACBlocks.POLISHED_GYPSUM_STAIRS.get());
            event.addAfter(ACBlocks.POLISHED_GYPSUM_STAIRS.get(), ACBlocks.POLISHED_GYPSUM_SLAB.get());
            event.addAfter(ACBlocks.POLISHED_GYPSUM_SLAB.get(), ACBlocks.POLISHED_GYPSUM_WALL.get());
            event.addAfter(ACBlocks.POLISHED_GYPSUM_WALL.get(), ACBlocks.GYPSUM_BRICKS.get());
            event.addAfter(ACBlocks.GYPSUM_BRICKS.get(), ACBlocks.GYPSUM_BRICK_STAIRS.get());
            event.addAfter(ACBlocks.GYPSUM_BRICK_STAIRS.get(), ACBlocks.GYPSUM_BRICK_SLAB.get());
            event.addAfter(ACBlocks.GYPSUM_BRICK_SLAB.get(), ACBlocks.GYPSUM_BRICK_WALL.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(event -> {
            event.addAfter(Items.PRIZE_POTTERY_SHERD, ACItems.ROLL_POTTERY_SHERD.get());
            event.addBefore(Items.FRIEND_POTTERY_SHERD, ACItems.FINALE_POTTERY_SHERD.get());
            event.addAfter(Items.FRIEND_POTTERY_SHERD, ACItems.GATEWAY_POTTERY_SHERD.get());
            event.addBefore(Items.ANGLER_POTTERY_SHERD, ACItems.RUINED_POTTERY_SHERD.get());
            event.addBefore(ACItems.RUINED_POTTERY_SHERD.get(), ACItems.POTTERY_SHERD.get());
            event.addBefore(Items.WHITE_DYE, ACItems.BLEACHDEW.get());
        });
    }
}