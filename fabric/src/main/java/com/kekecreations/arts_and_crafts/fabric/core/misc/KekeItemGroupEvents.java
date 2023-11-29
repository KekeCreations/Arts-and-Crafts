package com.kekecreations.arts_and_crafts.fabric.core.misc;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;

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
                event.accept(KekeBlocks.getChalkSlab(colours));
                event.accept(KekeBlocks.getChalkStairs(colours));
                event.accept(KekeBlocks.getChalkWall(colours));
            }
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(event -> {
            event.accept(KekeBlocks.getChalk(DyeColor.WHITE));
        });




    }
}
