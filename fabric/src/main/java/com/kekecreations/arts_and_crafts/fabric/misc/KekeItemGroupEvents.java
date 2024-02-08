package com.kekecreations.arts_and_crafts.fabric.misc;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import com.kekecreations.arts_and_crafts.fabric.registry.KekeFabricBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
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
            event.addAfter(Blocks.ACACIA_LOG, KekeFabricBlocks.CORK_LOG.get());
            event.addAfter(Blocks.ACACIA_LEAVES, KekeFabricBlocks.CORK_LEAVES.get());
            event.addAfter(Blocks.ACACIA_SAPLING, KekeBlocks.CORK_SAPLING.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(event -> {
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeItems.getChalkStick(colours));
            }
            event.addAfter(Items.ACACIA_CHEST_BOAT, KekeItems.CORK_BOAT.get());
            event.addAfter(KekeItems.CORK_BOAT.get(), KekeItems.CORK_CHEST_BOAT.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(event -> {
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeBlocks.getDyedFlowerPot(colours));
            }
            event.addAfter(Items.ACACIA_HANGING_SIGN, KekeItems.CORK_SIGN.get());
            event.addAfter(KekeItems.CORK_SIGN.get(), KekeItems.CORK_HANGING_SIGN.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(event -> {
            event.accept(KekeBlocks.SOAPSTONE_BRICKS.get());
            event.accept(KekeBlocks.SOAPSTONE_BRICK_SLAB.get());
            event.accept(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get());
            event.accept(KekeBlocks.SOAPSTONE_BRICK_WALL.get());



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

    }
}
