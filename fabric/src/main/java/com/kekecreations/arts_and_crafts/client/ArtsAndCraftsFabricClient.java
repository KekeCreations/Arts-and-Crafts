package com.kekecreations.arts_and_crafts.client;

import com.kekecreations.arts_and_crafts.ArtsAndCraftsFabric;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.kekecreations.arts_and_crafts.core.config.FabricConfig;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;

public class ArtsAndCraftsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockLayers();
        registerRenderers();


        ClientPlayNetworking.registerGlobalReceiver(FabricConfig.PACKET_ID, (config, context) -> {
            ArtsAndCraftsFabric.setConfig(config);
        });
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

    public static void registerRenderers() {
        EntityRendererRegistry.register((EntityType<? extends FloatingBlockEntity>) ACEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        //EntityRendererRegistry.register(ACEntityTypes.BOAT.get(), context -> new ACBoatRenderer(context, false));
        //EntityRendererRegistry.register(ACEntityTypes.CHEST_BOAT.get(), context -> new ACBoatRenderer(context, true));
        //BlockEntityRendererRegistry.register(ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), DyedDecoratedPotBER::new);
        //BlockEntityRendererRegistry.register(ACEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), ACBedBER::new);
        for (DyeColor colour : DyeColor.values()) {
            if (colour.getId() <= 15) {
                //BuiltinItemRendererRegistry.INSTANCE.register(ACBlocks.getDyedDecoratedPot(colour.getId()).asItem(), artsAndCraftsBlockEntityWithoutLevelRenderer::renderByItem);
            }
        }
        //BuiltinItemRendererRegistry.INSTANCE.register(ACBlocks.BLEACHED_BED.get().asItem(), artsAndCraftsBlockEntityWithoutLevelRenderer::renderByItem);
    }
}
