package com.kekecreations.arts_and_crafts.client;

import com.kekecreations.arts_and_crafts.client.renderer.entity.CustomDyeSheepRenderer;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
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
        EntityRendererRegistry.register(KekeEntityTypes.CUSTOM_DYE_SHEEP, CustomDyeSheepRenderer::new);
    }
}
