package com.kekecreations.arts_and_crafts.core.fabric.registry;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ACFlammableAndStrippableBlocks {



    public static void register() {
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.CORK_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.CORK_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.STRIPPED_CORK_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.STRIPPED_CORK_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.CORK_PLANKS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.CORK_STAIRS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.CORK_SLAB.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.CORK_FENCE.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.CORK_FENCE_GATE.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ACBlocks.CORK_LEAVES.get(), 30, 60);
        StrippableBlockRegistry.register(ACBlocks.CORK_LOG.get(), ACBlocks.STRIPPED_CORK_LOG.get());
        StrippableBlockRegistry.register(ACBlocks.CORK_WOOD.get(), ACBlocks.STRIPPED_CORK_WOOD.get());
    }
}
