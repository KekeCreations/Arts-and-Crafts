package com.kekecreations.arts_and_crafts.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.fabric.core.misc.KekeItemGroupEvents;
import net.fabricmc.api.ModInitializer;

public class ArtsAndCraftsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ArtsAndCrafts.init();
        KekeItemGroupEvents.add();
    }
}
