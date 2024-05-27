package com.kekecreations.arts_and_crafts.core.fabric;

import com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class ArtsAndCraftsItemGroupEvents {


    public static void add() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(event -> {
            event.addAfter(Blocks.PINK_GLAZED_TERRACOTTA, KekeBlocks.TERRACOTTA_SHINGLES.get());
            event.addAfter(KekeBlocks.TERRACOTTA_SHINGLES.get(), KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
            event.addAfter(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get());
            event.addAfter(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), KekeBlocks.TERRACOTTA_SHINGLE_WALL.get());


            event.addAfter(KekeBlocks.getChalk(DyeColor.PINK.getId()), KekeBlocks.SOAPSTONE.get());
            event.addAfter(KekeBlocks.SOAPSTONE.get(), KekeBlocks.SOAPSTONE_STAIRS.get());
            event.addAfter(KekeBlocks.SOAPSTONE_STAIRS.get(), KekeBlocks.SOAPSTONE_SLAB.get());
            event.addAfter(KekeBlocks.SOAPSTONE_SLAB.get(), KekeBlocks.SOAPSTONE_WALL.get());

            event.addAfter(KekeBlocks.SOAPSTONE_WALL.get(), KekeBlocks.POLISHED_SOAPSTONE.get());
            event.addAfter(KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get());
            event.addAfter(KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get(), KekeBlocks.POLISHED_SOAPSTONE_SLAB.get());
            event.addAfter(KekeBlocks.POLISHED_SOAPSTONE_SLAB.get(), KekeBlocks.POLISHED_SOAPSTONE_WALL.get());

            event.addAfter(KekeBlocks.POLISHED_SOAPSTONE_WALL.get(), KekeBlocks.SOAPSTONE_BRICKS.get());
            event.addAfter(KekeBlocks.SOAPSTONE_BRICKS.get(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get());
            event.addAfter(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get());
            event.addAfter(KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), KekeBlocks.SOAPSTONE_BRICK_WALL.get());

            event.addAfter(Blocks.PINK_STAINED_GLASS_PANE, KekeBlocks.PLASTER.get());

            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                event.addAfter(Items.PINK_BANNER, KekeBlocks.getChalk(colours.getId()));
                event.addAfter(Items.PINK_CANDLE, KekeBlocks.getDyedFlowerPot(colours.getId()));
                event.addAfter(KekeBlocks.getDyedFlowerPot(DyeColor.PINK.getId()), KekeBlocks.getDyedDecoratedPot(colours.getId()));

                event.addAfter(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), KekeBlocks.getDyedTerracottaShingles(colours.getId()));
                event.addAfter(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()));
                event.addAfter(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()));
                event.addAfter(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()));

                event.addAfter(KekeBlocks.SOAPSTONE_BRICK_WALL.get(), KekeBlocks.getDyedSoapstone(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneStairs(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneStairs(colours.getId()), KekeBlocks.getDyedSoapstoneSlab(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneSlab(colours.getId()), KekeBlocks.getDyedSoapstoneWall(colours.getId()));

                event.addAfter(KekeBlocks.getDyedSoapstoneWall(colours.getId()), KekeBlocks.getDyedPolishedSoapstone(colours.getId()));
                event.addAfter(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()));
                event.addAfter(KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()));
                event.addAfter(KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()));

                event.addAfter(KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()), KekeBlocks.getDyedSoapstoneBricks(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()));

                event.addAfter(KekeBlocks.getDyedSoapstoneBrickWall(DyeColor.PINK.getId()), KekeBlocks.getDyedMudBricks(colours.getId()));
                event.addAfter(KekeBlocks.getDyedMudBricks(colours.getId()), KekeBlocks.getDyedMudBrickStairs(colours.getId()));
                event.addAfter(KekeBlocks.getDyedMudBrickStairs(colours.getId()), KekeBlocks.getDyedMudBrickSlab(colours.getId()));
                event.addAfter(KekeBlocks.getDyedMudBrickSlab(colours.getId()), KekeBlocks.getDyedMudBrickWall(colours.getId()));

                event.addAfter(KekeBlocks.PLASTER.get(), KekeBlocks.getDyedPlaster(colours.getId()));
            }
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(event -> {
            event.accept(KekeBlocks.getChalk(DyeColor.WHITE.getId()));
            event.accept(KekeBlocks.SOAPSTONE.get());
            event.accept(KekeBlocks.GYPSUM.get());
            event.addAfter(Blocks.ACACIA_LOG, KekeBlocks.CORK_LOG.get());
            event.addAfter(Blocks.ACACIA_LEAVES, KekeBlocks.CORK_LEAVES.get());
            event.addAfter(Blocks.ACACIA_SAPLING, KekeBlocks.CORK_SAPLING.get());
            event.addAfter(Items.LILY_PAD, KekeItems.LOTUS_PISTILS.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(event -> {
            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                event.addAfter(Items.MUSIC_DISC_RELIC, KekeItems.getChalkStick(colours.getId()));
                event.addAfter(KekeItems.getChalkStick(DyeColor.PINK.getId()), KekeItems.getPaintBrush(colours.getId()));
            }
            event.addAfter(KekeItems.getPaintBrush(DyeColor.PINK.getId()), KekeItems.BLEACHDEW_PAINTBRUSH.get());
            event.addAfter(Items.ACACIA_CHEST_BOAT, KekeItems.CORK_BOAT.get());
            event.addAfter(KekeItems.CORK_BOAT.get(), KekeItems.CORK_CHEST_BOAT.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(event -> {
            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                event.addAfter(Items.FLOWER_POT, KekeBlocks.getDyedFlowerPot(colours.getId()));
                event.addAfter(Items.DECORATED_POT, KekeBlocks.getDyedDecoratedPot(colours.getId()));
            }
            event.addAfter(Items.ACACIA_HANGING_SIGN, KekeItems.CORK_SIGN.get());
            event.addAfter(KekeItems.CORK_SIGN.get(), KekeItems.CORK_HANGING_SIGN.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(event -> {
            event.addAfter(Blocks.ACACIA_BUTTON, KekeBlocks.CORK_LOG.get());
            event.addAfter(KekeBlocks.CORK_LOG.get(), KekeBlocks.CORK_WOOD.get());
            event.addAfter(KekeBlocks.CORK_WOOD.get(), KekeBlocks.STRIPPED_CORK_LOG.get());
            event.addAfter(KekeBlocks.STRIPPED_CORK_LOG.get(), KekeBlocks.STRIPPED_CORK_WOOD.get());
            event.addAfter(KekeBlocks.STRIPPED_CORK_WOOD.get(), KekeBlocks.CORK.get());
            event.addAfter(KekeBlocks.CORK.get(), KekeBlocks.SMOOTH_CORK.get());
            event.addAfter(KekeBlocks.SMOOTH_CORK.get(), KekeBlocks.CORK_PLANKS.get());
            event.addAfter(KekeBlocks.CORK_PLANKS.get(), KekeBlocks.CORK_STAIRS.get());
            event.addAfter(KekeBlocks.CORK_STAIRS.get(), KekeBlocks.CORK_SLAB.get());
            event.addAfter(KekeBlocks.CORK_SLAB.get(), KekeBlocks.CORK_FENCE.get());
            event.addAfter(KekeBlocks.CORK_FENCE.get(), KekeBlocks.CORK_FENCE_GATE.get());
            event.addAfter(KekeBlocks.CORK_FENCE_GATE.get(), KekeBlocks.CORK_DOOR.get());
            event.addAfter(KekeBlocks.CORK_DOOR.get(), KekeBlocks.CORK_TRAPDOOR.get());
            event.addAfter(KekeBlocks.CORK_TRAPDOOR.get(), KekeBlocks.CORK_PRESSURE_PLATE.get());
            event.addAfter(KekeBlocks.CORK_PRESSURE_PLATE.get(), KekeBlocks.CORK_BUTTON.get());

            event.addAfter(Blocks.MUD_BRICK_WALL, KekeBlocks.GYPSUM.get());
            event.addAfter(KekeBlocks.GYPSUM.get(), KekeBlocks.GYPSUM_STAIRS.get());
            event.addAfter(KekeBlocks.GYPSUM_STAIRS.get(), KekeBlocks.GYPSUM_SLAB.get());
            event.addAfter(KekeBlocks.GYPSUM_SLAB.get(), KekeBlocks.GYPSUM_WALL.get());
            event.addAfter(KekeBlocks.GYPSUM_WALL.get(), KekeBlocks.POLISHED_GYPSUM.get());
            event.addAfter(KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM_STAIRS.get());
            event.addAfter(KekeBlocks.POLISHED_GYPSUM_STAIRS.get(), KekeBlocks.POLISHED_GYPSUM_SLAB.get());
            event.addAfter(KekeBlocks.POLISHED_GYPSUM_SLAB.get(), KekeBlocks.POLISHED_GYPSUM_WALL.get());
            event.addAfter(KekeBlocks.POLISHED_GYPSUM_WALL.get(), KekeBlocks.GYPSUM_BRICKS.get());
            event.addAfter(KekeBlocks.GYPSUM_BRICKS.get(), KekeBlocks.GYPSUM_BRICK_STAIRS.get());
            event.addAfter(KekeBlocks.GYPSUM_BRICK_STAIRS.get(), KekeBlocks.GYPSUM_BRICK_SLAB.get());
            event.addAfter(KekeBlocks.GYPSUM_BRICK_SLAB.get(), KekeBlocks.GYPSUM_BRICK_WALL.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(event -> {
            event.addAfter(Items.SNORT_POTTERY_SHERD, KekeItems.ROLL_POTTERY_SHERD.get());
            event.addAfter(KekeItems.ROLL_POTTERY_SHERD.get(), KekeItems.RUINED_POTTERY_SHERD.get());
            event.addAfter(KekeItems.RUINED_POTTERY_SHERD.get(), KekeItems.FINALE_POTTERY_SHERD.get());
            event.addAfter(KekeItems.FINALE_POTTERY_SHERD.get(), KekeItems.GATEWAY_POTTERY_SHERD.get());
            event.addAfter(Items.PINK_DYE, KekeItems.BLEACHDEW.get());
        });
    }
}