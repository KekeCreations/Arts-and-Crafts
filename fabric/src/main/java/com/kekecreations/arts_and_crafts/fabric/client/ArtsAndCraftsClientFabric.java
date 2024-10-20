package com.kekecreations.arts_and_crafts.fabric.client;

import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.client.renderer.bewlr.ArtsAndCraftsBEWLR;
import com.kekecreations.arts_and_crafts.client.renderer.tile.ACBedBER;
import com.kekecreations.arts_and_crafts.client.renderer.tile.DyedDecoratedPotBER;
import com.kekecreations.arts_and_crafts.client.renderer.entity.ACBoatRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.core.registry.ACSpriteSources;
import com.kekecreations.arts_and_crafts.fabric.ArtsAndCraftsFabric;
import com.kekecreations.arts_and_crafts.fabric.core.config.FabricConfig;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
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
        registerModelLayers();
        ACSpriteSources.register();


        ClientPlayNetworking.registerGlobalReceiver(ArtsAndCraftsFabric.SYNC_CONFIG_PACKET, (client, handler, buf, responseSender) -> {
            ArtsAndCraftsFabric.setConfig(FabricConfig.readFromServer(buf));
        });
    }


    public static void registerBlockLayers() {
        for (DyeColor colours : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getChalkDust(colours.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedCrimsonFungus(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedCrimsonRoots(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedWarpedFungus(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedWarpedRoots(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedOakSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedSpruceSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedBirchSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedAcaciaSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedJungleSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedCherrySapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedDarkOakSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedMangrovePropagule(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedFern(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedDandelion(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedPoppy(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedBlueOrchid(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedAllium(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedAzureBluet(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedRedTulip(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedOrangeTulip(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedWhiteTulip(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedPinkTulip(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedOxeyeDaisy(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedCornflower(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedLilyOfTheValley(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedWitherRose(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedRedMushroom(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedBrownMushroom(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedDeadBush(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedCactus(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedBamboo(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedAzalea(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedFloweringAzalea(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedTorchFlower(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPottedCorkSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPlaster(colours.getId()), RenderType.cutout());
        }
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.CORK_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.POTTED_CORK_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.PLASTER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.LOTUS_FLOWER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.BLEACHED_CHALK_DUST.get(), RenderType.cutout());
    }


    public static void registerParticleFactories() {
        for (DyeColor colours : DyeColor.values()) {
            ParticleFactoryRegistry.getInstance().register(ACParticles.getChalkDrawParticle(colours.getId()), ChalkDustParticle.Factory::new);
        }
        ParticleFactoryRegistry.getInstance().register(ACParticles.BLEACHED_CHALK_DRAW.get(), ChalkDustParticle.Factory::new);
    }

    public static void registerBlockColours() {
        for (DyeColor colours : DyeColor.values()) {
            ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> {
                if (blockAndTintGetter == null || blockPos == null) {
                    return GrassColor.getDefaultColor();
                }
                return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
            }, ACBlocks.getDyedPottedFern(colours));
        }
    }
    static ArtsAndCraftsBEWLR artsAndCraftsBlockEntityWithoutLevelRenderer = new ArtsAndCraftsBEWLR();
    public static void registerRenderers() {
        EntityRendererRegistry.register(ACEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        EntityRendererRegistry.register(ACEntityTypes.BOAT.get(), context -> new ACBoatRenderer(context, false));
        EntityRendererRegistry.register(ACEntityTypes.CHEST_BOAT.get(), context -> new ACBoatRenderer(context, true));
        BlockEntityRendererRegistry.register(ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), DyedDecoratedPotBER::new);
        BlockEntityRendererRegistry.register(ACEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), ACBedBER::new);
        for (DyeColor colours : DyeColor.values()) {
            BuiltinItemRendererRegistry.INSTANCE.register(ACBlocks.getDyedDecoratedPot(colours.getId()).asItem(), artsAndCraftsBlockEntityWithoutLevelRenderer::renderByItem);
        }
        BuiltinItemRendererRegistry.INSTANCE.register(ACBlocks.BLEACHED_BED.get().asItem(), artsAndCraftsBlockEntityWithoutLevelRenderer::renderByItem);
    }
    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(ACBoatRenderer.BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(ACBoatRenderer.CHEST_BOAT, ChestBoatModel::createBodyModel);
    }

}
