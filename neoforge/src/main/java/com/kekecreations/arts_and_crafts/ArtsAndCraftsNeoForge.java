package com.kekecreations.arts_and_crafts;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ArtsAndCrafts.MOD_ID)
public class ArtsAndCraftsNeoForge {

    public ArtsAndCraftsNeoForge(IEventBus eventBus) {
        ArtsAndCrafts.init();

    }
}