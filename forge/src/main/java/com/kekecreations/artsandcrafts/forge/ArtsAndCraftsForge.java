package com.kekecreations.artsandcrafts.forge;

import dev.architectury.platform.forge.EventBuses;
import com.kekecreations.artsandcrafts.ArtsAndCrafts;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArtsAndCrafts.MOD_ID)
public class ArtsAndCraftsForge {
    public ArtsAndCraftsForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(ArtsAndCrafts.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ArtsAndCrafts.init();
    }
}
