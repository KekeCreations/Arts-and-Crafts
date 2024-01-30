package com.kekecreations.arts_and_crafts.fabric.core.misc;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;

public class KekeItemGroupEvents {


    public static void add() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(event -> {
            event.accept(KekeBlocks.TERRACOTTA_SHINGLES.get());
            event.accept(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get());
            event.accept(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
            event.accept(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get());
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeBlocks.getDyedTerracottaShingles(colours));
                event.accept(KekeBlocks.getDyedTerracottaShingleSlab(colours));
                event.accept(KekeBlocks.getDyedTerracottaShingleStairs(colours));
                event.accept(KekeBlocks.getDyedTerracottaShingleWall(colours));

                event.accept(KekeBlocks.getChalk(colours));

                event.accept(KekeBlocks.getDyedSoapstone(colours));
                event.accept(KekeBlocks.getDyedSoapstoneSlab(colours));
                event.accept(KekeBlocks.getDyedSoapstoneStairs(colours));
                event.accept(KekeBlocks.getDyedSoapstoneWall(colours));

                event.accept(KekeBlocks.getDyedSoapstoneBricks(colours));
                event.accept(KekeBlocks.getDyedSoapstoneBrickSlab(colours));
                event.accept(KekeBlocks.getDyedSoapstoneBrickStairs(colours));
                event.accept(KekeBlocks.getDyedSoapstoneBrickWall(colours));

                event.accept(KekeBlocks.getDyedFlowerPot(colours));
            }
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(event -> {
            event.accept(KekeBlocks.getChalk(DyeColor.WHITE));
            event.accept(KekeBlocks.SOAPSTONE.get());
            event.accept(KekeBlocks.SOAPSTONE_SLAB.get());
            event.accept(KekeBlocks.SOAPSTONE_STAIRS.get());
            event.accept(KekeBlocks.SOAPSTONE_WALL.get());
            event.accept(KekeBlocks.CORK_LOG.get());
            event.addAfter(Blocks.FLOWERING_AZALEA_LEAVES, KekeBlocks.CORK_LEAVES.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(event -> {
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeItems.getChalkStick(colours));
            }
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(event -> {
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeBlocks.getDyedFlowerPot(colours));
            }
            event.accept(KekeItems.CORK_SIGN.get());
            event.accept(KekeItems.CORK_HANGING_SIGN.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(event -> {
            event.accept(KekeBlocks.SOAPSTONE_BRICKS.get());
            event.accept(KekeBlocks.SOAPSTONE_BRICK_SLAB.get());
            event.accept(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get());
            event.accept(KekeBlocks.SOAPSTONE_BRICK_WALL.get());
            event.accept(KekeBlocks.CORK_BUTTON.get());
            event.accept(KekeBlocks.CORK_FENCE.get());
            event.accept(KekeBlocks.CORK_FENCE_GATE.get());
            event.accept(KekeBlocks.CORK_PLANKS.get());
            event.accept(KekeBlocks.CORK_SLAB.get());
            event.accept(KekeBlocks.CORK_STAIRS.get());
            event.accept(KekeBlocks.CORK_WOOD.get());
            event.accept(KekeBlocks.STRIPPED_CORK_WOOD.get());
            event.accept(KekeBlocks.CORK_LOG.get());
            event.accept(KekeBlocks.STRIPPED_CORK_LOG.get());
            event.accept(KekeBlocks.CORK_DOOR.get());
            event.accept(KekeBlocks.CORK_TRAPDOOR.get());
            event.accept(KekeBlocks.CORK_PRESSURE_PLATE.get());
            event.accept(KekeBlocks.CORK.get());
            event.accept(KekeBlocks.SMOOTH_CORK.get());
        });

    }
}
