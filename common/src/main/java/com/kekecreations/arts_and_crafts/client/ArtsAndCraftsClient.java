package com.kekecreations.arts_and_crafts.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ArtsAndCraftsClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        registerRenderers();
    }

    public static void registerRenderers() {
    }
}
