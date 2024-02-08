package com.kekecreations.arts_and_crafts.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.fabric.misc.KekeItemGroupEvents;
import com.kekecreations.arts_and_crafts.fabric.registry.KekeFabricBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ArtsAndCraftsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ArtsAndCrafts.init();
        KekeItemGroupEvents.add();
        KekeFabricBlocks.register();
    }


}
