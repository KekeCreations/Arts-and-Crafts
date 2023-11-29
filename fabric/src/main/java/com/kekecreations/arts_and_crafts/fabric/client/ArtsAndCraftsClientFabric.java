package com.kekecreations.arts_and_crafts.fabric.client;

import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class ArtsAndCraftsClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerBlockLayers();
    }


    public static void registerBlockLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.WHITE_CHALK_DUST.get(), RenderType.cutout());
    }


    public static void registerParticleFactories() {
        //ParticleFactoryRegistry.getInstance().register(KekeParticles.CHALK_DRAW.get(), ChalkDustParticle.Factory::new);
    }
}
