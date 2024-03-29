package com.kekecreations.arts_and_crafts.core.fabric.registry;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class KekeFabricFlammableAndStrippableBlocks {



    public static void register() {
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.CORK_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.CORK_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.STRIPPED_CORK_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.STRIPPED_CORK_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.CORK_PLANKS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.CORK_STAIRS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.CORK_SLAB.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.CORK_FENCE.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.CORK_FENCE_GATE.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(KekeBlocks.CORK_LEAVES.get(), 30, 60);
        StrippableBlockRegistry.register(KekeBlocks.CORK_LOG.get(), KekeBlocks.STRIPPED_CORK_LOG.get());
        StrippableBlockRegistry.register(KekeBlocks.CORK_WOOD.get(), KekeBlocks.STRIPPED_CORK_WOOD.get());
    }
}
