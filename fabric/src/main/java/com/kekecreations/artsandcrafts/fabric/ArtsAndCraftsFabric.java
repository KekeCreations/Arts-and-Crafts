package com.kekecreations.artsandcrafts.fabric;

import com.kekecreations.artsandcrafts.ArtsAndCrafts;
import net.fabricmc.api.ModInitializer;

public class ArtsAndCraftsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ArtsAndCrafts.init();
    }
}
