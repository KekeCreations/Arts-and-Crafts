package com.kekecreations.arts_and_crafts.fabric.client;

import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.GrassColor;

@Environment(EnvType.CLIENT)
public class ArtsAndCraftsClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerBlockLayers();
        registerParticleFactories();
        registerBlockColours();
        registerRenderers();
    }


    public static void registerBlockLayers() {
        for (DyeColor colours : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getChalkDust(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedCrimsonFungus(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedCrimsonRoots(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedWarpedFungus(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedWarpedRoots(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedOakSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedSpruceSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedBirchSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedAcaciaSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedJungleSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedCherrySapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedDarkOakSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedMangrovePropagule(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedFern(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedDandelion(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedPoppy(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedBlueOrchid(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedAllium(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedAzureBluet(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedRedTulip(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedOrangeTulip(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedWhiteTulip(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedPinkTulip(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedOxeyeDaisy(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedCornflower(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedLilyOfTheValley(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedWitherRose(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedRedMushroom(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedBrownMushroom(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedDeadBush(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedCactus(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedBamboo(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedAzalea(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedFloweringAzalea(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedTorchFlower(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.CORK_SAPLING.get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.POTTED_CORK_SAPLING.get(), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedCorkSapling(colours), RenderType.cutout());
        }
    }


    public static void registerParticleFactories() {
        for (DyeColor colours : DyeColor.values()) {
            ParticleFactoryRegistry.getInstance().register(KekeParticles.getChalkDrawParticle(colours), ChalkDustParticle.Factory::new);
        }
    }

    public static void registerBlockColours() {
        for (DyeColor colours : DyeColor.values()) {
            ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> {
                if (blockAndTintGetter == null || blockPos == null) {
                    return GrassColor.getDefaultColor();
                }
                return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
            }, KekeBlocks.getDyedPottedFern(colours));
        }
    }
    public static void registerRenderers() {
        EntityRendererRegistry.register(KekeEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
    }

}
