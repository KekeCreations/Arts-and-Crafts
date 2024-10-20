package com.kekecreations.arts_and_crafts.fabric.core.registry;

import com.kekecreations.arts_and_crafts.common.entity.ACSheep;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ACFabricRegistries {



    public static void register() {
        //FLAMMABLE
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

        //STRIPPABLE
        StrippableBlockRegistry.register(ACBlocks.CORK_LOG.get(), ACBlocks.STRIPPED_CORK_LOG.get());
        StrippableBlockRegistry.register(ACBlocks.CORK_WOOD.get(), ACBlocks.STRIPPED_CORK_WOOD.get());


        //COMPOSTING
        CompostingChanceRegistry.INSTANCE.add(ACBlocks.CORK_SAPLING.get(), 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ACBlocks.CORK_LEAVES.get(), 0.3F);

        //ATTRIBUTE
        FabricDefaultAttributeRegistry.register(ACEntityTypes.SHEEP.get(), ACSheep.createAttributes());
    }
}
