package com.kekecreations.arts_and_crafts.fabric.client;

import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.client.renderer.bewlr.ArtsAndCraftsBEWLR;
import com.kekecreations.arts_and_crafts.client.renderer.tile.ACBedBER;
import com.kekecreations.arts_and_crafts.client.renderer.tile.DyedDecoratedPotBER;
import com.kekecreations.arts_and_crafts.client.renderer.entity.ACBoatRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.tile.DyedFlowerPotBER;
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
        registerRenderers();
        registerModelLayers();


        ClientPlayNetworking.registerGlobalReceiver(FabricConfig.PACKET_ID, (config, context) -> {
            ArtsAndCraftsFabric.setConfig(config);
        });
    }


    public static void registerBlockLayers() {
        for (DyeColor colours : DyeColor.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getChalkDust(colours.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedPlaster(colours.getId()), RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.getDyedFlowerPot(colours.getId()), RenderType.cutout());
        }
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.CORK_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.POTTED_CORK_SAPLING.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.PLASTER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.LOTUS_FLOWER.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.BLEACHED_CHALK_DUST.get(), RenderType.cutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(ACBlocks.CRIMSON_HANGING_FLOWER_POT.get(), RenderType.cutout());
    }


    public static void registerParticleFactories() {
        for (DyeColor colours : DyeColor.values()) {
            ParticleFactoryRegistry.getInstance().register(ACParticles.getChalkDrawParticle(colours.getId()), ChalkDustParticle.Factory::new);
        }
        ParticleFactoryRegistry.getInstance().register(ACParticles.BLEACHED_CHALK_DRAW.get(), ChalkDustParticle.Factory::new);
    }

    static ArtsAndCraftsBEWLR artsAndCraftsBlockEntityWithoutLevelRenderer = new ArtsAndCraftsBEWLR();
    public static void registerRenderers() {
        EntityRendererRegistry.register(ACEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        EntityRendererRegistry.register(ACEntityTypes.BOAT.get(), context -> new ACBoatRenderer(context, false));
        EntityRendererRegistry.register(ACEntityTypes.CHEST_BOAT.get(), context -> new ACBoatRenderer(context, true));
        BlockEntityRendererRegistry.register(ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), DyedDecoratedPotBER::new);
        BlockEntityRendererRegistry.register(ACEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), ACBedBER::new);
        BlockEntityRendererRegistry.register(ACEntityTypes.CUSTOM_FLOWER_POT_BLOCK_ENTITY.get(), DyedFlowerPotBER::new);
        for (DyeColor colour : DyeColor.values()) {
            if (colour.getId() <= 15) {
                BuiltinItemRendererRegistry.INSTANCE.register(ACBlocks.getDyedDecoratedPot(colour.getId()).asItem(), artsAndCraftsBlockEntityWithoutLevelRenderer::renderByItem);
            }
        }
        BuiltinItemRendererRegistry.INSTANCE.register(ACBlocks.BLEACHED_BED.get().asItem(), artsAndCraftsBlockEntityWithoutLevelRenderer::renderByItem);
    }
    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(ACBoatRenderer.BOAT, BoatModel::createBodyModel);
        EntityModelLayerRegistry.registerModelLayer(ACBoatRenderer.CHEST_BOAT, ChestBoatModel::createBodyModel);
    }

}
