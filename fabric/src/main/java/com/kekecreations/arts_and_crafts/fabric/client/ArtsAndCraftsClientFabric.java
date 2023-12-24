package com.kekecreations.arts_and_crafts.fabric.client;

import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.client.renderer.block.CustomFlowerPotRenderer;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlockEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.item.DyeColor;

@Environment(EnvType.CLIENT)
public class ArtsAndCraftsClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerBlockLayers();
        registerParticleFactories();
        registerRenderers();
    }


    public static void registerBlockLayers() {
        for (DyeColor colours : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getChalkDust(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedOakSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedCrimsonFungus(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedCrimsonRoots(colours), RenderType.cutout());
        }
        //BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.POTTED_CACTUS.get(), RenderType.cutout());
    }


    public static void registerParticleFactories() {
        for (DyeColor colours : DyeColor.values()) {
            ParticleFactoryRegistry.getInstance().register(KekeParticles.getChalkDrawParticle(colours), ChalkDustParticle.Factory::new);
        }
        //ParticleFactoryRegistry.getInstance().register(KekeParticles.CHALK_DRAW.get(), ChalkDustParticle.Factory::new);
    }

    public static void registerRenderers() {
        BlockEntityRenderers.register(KekeBlockEntityTypes.CUSTOM_FLOWER_POT.get(), CustomFlowerPotRenderer::new);
    }
}
