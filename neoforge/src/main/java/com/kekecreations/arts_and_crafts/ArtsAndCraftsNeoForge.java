package com.kekecreations.arts_and_crafts;


import com.kekecreations.arts_and_crafts.core.config.NeoForgeConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(ArtsAndCrafts.MOD_ID)
public class ArtsAndCraftsNeoForge {

    public ArtsAndCraftsNeoForge(IEventBus eventBus,  ModContainer modContainer) {
        ArtsAndCrafts.init();
        modContainer.registerConfig(ModConfig.Type.COMMON, NeoForgeConfig.SPEC);

    }
}