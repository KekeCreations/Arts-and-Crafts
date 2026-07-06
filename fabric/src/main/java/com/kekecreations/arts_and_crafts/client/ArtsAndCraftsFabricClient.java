package com.kekecreations.arts_and_crafts.client;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.item.DyeColor;

public class ArtsAndCraftsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockLayers();

    }

    public static void registerBlockLayers() {
        for (DyeColor colours : DyeColor.values()) {
            BlockRenderLayerMap.putBlock(ACBlocks.getChalkDust(colours.getId()), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedCrimsonFungus(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedCrimsonRoots(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedWarpedFungus(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedWarpedRoots(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedOakSapling(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedSpruceSapling(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedBirchSapling(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedAcaciaSapling(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedJungleSapling(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedCherrySapling(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedDarkOakSapling(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedMangrovePropagule(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedFern(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedDandelion(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedPoppy(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedBlueOrchid(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedAllium(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedAzureBluet(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedRedTulip(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedOrangeTulip(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedWhiteTulip(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedPinkTulip(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedOxeyeDaisy(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedCornflower(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedLilyOfTheValley(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedWitherRose(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedRedMushroom(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedBrownMushroom(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedDeadBush(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedCactus(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedBamboo(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedAzalea(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedFloweringAzalea(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedTorchFlower(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPottedCorkSapling(colours), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedPlaster(colours.getId()), ChunkSectionLayer.CUTOUT);
            BlockRenderLayerMap.putBlock(ACBlocks.getDyedFlowerPot(colours.getId()), ChunkSectionLayer.CUTOUT);
        }
        BlockRenderLayerMap.putBlock(ACBlocks.CORK_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ACBlocks.POTTED_CORK_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ACBlocks.PLASTER.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ACBlocks.LOTUS_FLOWER.get(), ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ACBlocks.BLEACHED_CHALK_DUST.get(), ChunkSectionLayer.CUTOUT);
        //BlockRenderLayerMap.putBlock(ACBlocks.CRIMSON_HANGING_FLOWER_POT.get(), ChunkSectionLayer.CUTOUT);
    }
}
