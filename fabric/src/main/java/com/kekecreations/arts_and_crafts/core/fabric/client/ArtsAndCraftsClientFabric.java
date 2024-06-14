package com.kekecreations.arts_and_crafts.core.fabric.client;

import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.client.renderer.bewlr.ArtsAndCraftsBEWLR;
import com.kekecreations.arts_and_crafts.client.renderer.tile.CustomBedBER;
import com.kekecreations.arts_and_crafts.client.renderer.tile.DyedDecoratedPotBER;
import com.kekecreations.arts_and_crafts.client.renderer.entity.CustomBoatRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
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
    }


    public static void registerBlockLayers() {
        for (DyeColor colours : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getChalkDust(colours.getId()), RenderType.cutout());
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
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPottedCorkSapling(colours), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.getDyedPlaster(colours.getId()), RenderType.cutout());
        }
        BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.CORK_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.POTTED_CORK_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.PLASTER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.LOTUS_FLOWER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(KekeBlocks.BLEACHED_CHALK_DUST.get(), RenderType.cutout());
    }


    public static void registerParticleFactories() {
        for (DyeColor colours : DyeColor.values()) {
            ParticleFactoryRegistry.getInstance().register(KekeParticles.getChalkDrawParticle(colours.getId()), ChalkDustParticle.Factory::new);
        }
        ParticleFactoryRegistry.getInstance().register(KekeParticles.BLEACHED_CHALK_DRAW.get(), ChalkDustParticle.Factory::new);
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
    static ArtsAndCraftsBEWLR artsAndCraftsBlockEntityWithoutLevelRenderer = new ArtsAndCraftsBEWLR();
    public static void registerRenderers() {
        EntityRendererRegistry.register(KekeEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        EntityRendererRegistry.register(KekeEntityTypes.BOAT.get(), context -> new CustomBoatRenderer(context, false));
        EntityRendererRegistry.register(KekeEntityTypes.CHEST_BOAT.get(), context -> new CustomBoatRenderer(context, true));
        BlockEntityRendererRegistry.register(KekeEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), DyedDecoratedPotBER::new);
        BlockEntityRendererRegistry.register(KekeEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), CustomBedBER::new);
        for (DyeColor colours : DyeColor.values()) {
            //BuiltinItemRendererRegistry.INSTANCE.register(KekeBlocks.getDyedDecoratedPot(colours.getId()).asItem(), artsAndCraftsBlockEntityWithoutLevelRenderer::renderByItem);
        }
        BuiltinItemRendererRegistry.INSTANCE.register(KekeBlocks.BLEACHED_BED.get().asItem(), artsAndCraftsBlockEntityWithoutLevelRenderer::renderByItem);
    }
    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(CustomBoatRenderer.BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(CustomBoatRenderer.CHEST_BOAT, ChestBoatModel::createBodyModel);
    }

}
