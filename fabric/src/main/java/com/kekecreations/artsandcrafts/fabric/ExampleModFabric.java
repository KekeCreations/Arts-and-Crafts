package com.kekecreations.artsandcrafts.fabric;

import com.kekecreations.artsandcrafts.ExampleMod;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleMod.init();
    }
}
