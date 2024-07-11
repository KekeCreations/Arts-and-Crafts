package com.kekecreations.arts_and_crafts.core.forge.common;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.minecraft.world.level.block.Block;

import static net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES;

public class ACCompostables {

    public static void register() {
        addCompostable(0.3F, ACBlocks.CORK_SAPLING.get());
        addCompostable(0.3F, ACBlocks.CORK_LEAVES.get());
    }

    private static void addCompostable(float pChance, Block pItem) {
        COMPOSTABLES.put(pItem.asItem(), pChance);
    }
}
