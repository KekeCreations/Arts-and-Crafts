package com.kekecreations.arts_and_crafts.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.fabricmc.api.ModInitializer;

public class ArtsAndCraftsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ArtsAndCrafts.init();
    }
}
