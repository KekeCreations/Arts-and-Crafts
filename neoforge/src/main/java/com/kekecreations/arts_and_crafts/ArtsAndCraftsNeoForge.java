package com.kekecreations.arts_and_crafts;


import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.core.config.NeoForgeConfig;
import com.kekecreations.arts_and_crafts.core.registry.ACRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

@Mod(ArtsAndCrafts.MOD_ID)
public class ArtsAndCraftsNeoForge {

    public ArtsAndCraftsNeoForge(IEventBus eventBus,  ModContainer modContainer) {
        ArtsAndCrafts.init();
        modContainer.registerConfig(ModConfig.Type.COMMON, NeoForgeConfig.SPEC);
        eventBus.addListener(this::datapackRegistry);

    }

    public void datapackRegistry(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(ACRegistries.PAINTBRUSH_PALETTE, PaintbrushPalette.CODEC);
    }
}