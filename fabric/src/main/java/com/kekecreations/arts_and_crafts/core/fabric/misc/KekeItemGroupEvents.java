package com.kekecreations.arts_and_crafts.core.fabric.misc;

import com.kekecreations.arts_and_crafts.common.util.DyeColorByGradient;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import com.kekecreations.arts_and_crafts.core.fabric.registry.KekeFabricBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class KekeItemGroupEvents {


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

            event.addAfter(KekeBlocks.getDyedSoapstoneWall(DyeColor.PINK.getId()), KekeBlocks.SOAPSTONE_BRICKS.get());
            event.addAfter(KekeBlocks.SOAPSTONE_BRICKS.get(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get());
            event.addAfter(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get());
            event.addAfter(KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), KekeBlocks.SOAPSTONE_BRICK_WALL.get());

            for (DyeColorByGradient colours : DyeColorByGradient.values()) {
                event.addAfter(Items.PINK_BANNER, KekeBlocks.getChalk(colours.getId()));
                event.addAfter(Items.PINK_CANDLE, KekeBlocks.getDyedFlowerPot(colours.getId()));

                event.addAfter(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), KekeBlocks.getDyedTerracottaShingles(colours.getId()));
                event.addAfter(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()));
                event.addAfter(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()));
                event.addAfter(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()));

                event.addAfter(KekeBlocks.SOAPSTONE_WALL.get(), KekeBlocks.getDyedSoapstone(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneStairs(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneStairs(colours.getId()), KekeBlocks.getDyedSoapstoneSlab(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneSlab(colours.getId()), KekeBlocks.getDyedSoapstoneWall(colours.getId()));

                event.addAfter(KekeBlocks.SOAPSTONE_BRICK_WALL.get(), KekeBlocks.getDyedSoapstoneBricks(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()));
                event.addAfter(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()));
            }
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(event -> {
            event.accept(KekeBlocks.getChalk(DyeColor.WHITE.getId()));
            event.accept(KekeBlocks.SOAPSTONE.get());
            event.addAfter(Blocks.ACACIA_LOG, KekeFabricBlocks.CORK_LOG.get());
            event.addAfter(Blocks.ACACIA_LEAVES, KekeFabricBlocks.CORK_LEAVES.get());
            event.addAfter(Blocks.ACACIA_SAPLING, KekeBlocks.CORK_SAPLING.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(event -> {
            for (DyeColorByGradient colours : DyeColorByGradient.values()) {
                event.addAfter(Items.MUSIC_DISC_RELIC, KekeItems.getChalkStick(colours.getId()));
            }
            event.addAfter(Items.ACACIA_CHEST_BOAT, KekeItems.CORK_BOAT.get());
            event.addAfter(KekeItems.CORK_BOAT.get(), KekeItems.CORK_CHEST_BOAT.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(event -> {
            for (DyeColorByGradient colours : DyeColorByGradient.values()) {
                event.addAfter(Items.FLOWER_POT, KekeBlocks.getDyedFlowerPot(colours.getId()));
                event.addAfter(Items.DECORATED_POT, KekeBlocks.getDyedDecoratedPot(colours.getId()));
            }
            event.addAfter(Items.ACACIA_HANGING_SIGN, KekeItems.CORK_SIGN.get());
            event.addAfter(KekeItems.CORK_SIGN.get(), KekeItems.CORK_HANGING_SIGN.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(event -> {
            event.addAfter(Blocks.ACACIA_BUTTON, KekeFabricBlocks.CORK_LOG.get());
            event.addAfter(KekeFabricBlocks.CORK_LOG.get(), KekeFabricBlocks.CORK_WOOD.get());
            event.addAfter(KekeFabricBlocks.CORK_WOOD.get(), KekeFabricBlocks.STRIPPED_CORK_LOG.get());
            event.addAfter(KekeFabricBlocks.STRIPPED_CORK_LOG.get(), KekeFabricBlocks.STRIPPED_CORK_WOOD.get());
            event.addAfter(KekeFabricBlocks.STRIPPED_CORK_WOOD.get(), KekeBlocks.CORK.get());
            event.addAfter(KekeBlocks.CORK.get(), KekeBlocks.SMOOTH_CORK.get());
            event.addAfter(KekeBlocks.SMOOTH_CORK.get(), KekeFabricBlocks.CORK_PLANKS.get());
            event.addAfter(KekeFabricBlocks.CORK_PLANKS.get(), KekeFabricBlocks.CORK_STAIRS.get());
            event.addAfter(KekeFabricBlocks.CORK_STAIRS.get(), KekeFabricBlocks.CORK_SLAB.get());
            event.addAfter(KekeFabricBlocks.CORK_SLAB.get(), KekeFabricBlocks.CORK_FENCE.get());
            event.addAfter(KekeFabricBlocks.CORK_FENCE.get(), KekeFabricBlocks.CORK_FENCE_GATE.get());
            event.addAfter(KekeFabricBlocks.CORK_FENCE_GATE.get(), KekeBlocks.CORK_DOOR.get());
            event.addAfter(KekeBlocks.CORK_DOOR.get(), KekeBlocks.CORK_TRAPDOOR.get());
            event.addAfter(KekeBlocks.CORK_TRAPDOOR.get(), KekeBlocks.CORK_PRESSURE_PLATE.get());
            event.addAfter(KekeBlocks.CORK_PRESSURE_PLATE.get(), KekeBlocks.CORK_BUTTON.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(event -> {
            event.addAfter(Items.SNORT_POTTERY_SHERD, KekeItems.ROLL_POTTERY_SHERD.get());
        });

    }
}
