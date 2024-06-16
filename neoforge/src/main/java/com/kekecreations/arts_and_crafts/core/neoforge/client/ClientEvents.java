package com.kekecreations.arts_and_crafts.core.neoforge.client;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.client.renderer.entity.ACBoatRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.tile.ACBedBER;
import com.kekecreations.arts_and_crafts.client.renderer.tile.DyedDecoratedPotBER;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACParticles;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@EventBusSubscriber(modid = ArtsAndCrafts.MOD_ID, bus= EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entity Renderers
        event.registerEntityRenderer(ACEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        event.registerEntityRenderer(ACEntityTypes.BOAT.get(), context -> new ACBoatRenderer(context, false));
        event.registerEntityRenderer(ACEntityTypes.CHEST_BOAT.get(), context -> new ACBoatRenderer(context, true));
        event.registerBlockEntityRenderer(ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), DyedDecoratedPotBER::new);
        event.registerBlockEntityRenderer(ACEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), ACBedBER::new);
    }
    @SubscribeEvent
    public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ACBoatRenderer.BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(ACBoatRenderer.CHEST_BOAT, ChestBoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent registerParticleProvidersEvent) {
        for (DyeColor colours : DyeColor.values()) {
            registerParticleProvidersEvent.registerSpriteSet(ACParticles.getChalkDrawParticle(colours.getId()), ChalkDustParticle.Factory::new);
        }
        registerParticleProvidersEvent.registerSpriteSet(ACParticles.BLEACHED_CHALK_DRAW.get(), ChalkDustParticle.Factory::new);
    }
    @SubscribeEvent
    public static void registerBlockColours(RegisterColorHandlersEvent.Block registerColorHandlersEvent) {
        for (DyeColor colours : DyeColor.values()) {
            registerColorHandlersEvent.register((blockState, blockAndTintGetter, blockPos, i) -> {
                if (blockAndTintGetter == null || blockPos == null) {
                    return GrassColor.getDefaultColor();
                }
                return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
            }, ACBlocks.getDyedPottedFern(colours));
        }
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        for (DyeColor colours : DyeColor.values()) {
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getChalkDust(colours.getId()), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCrimsonFungus(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCrimsonRoots(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedWarpedFungus(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedWarpedRoots(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedOakSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedSpruceSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedBirchSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedAcaciaSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedJungleSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCherrySapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedDarkOakSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedMangrovePropagule(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedFern(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedDandelion(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedPoppy(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedBlueOrchid(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedAllium(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedAzureBluet(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedRedTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedOrangeTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedWhiteTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedPinkTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedOxeyeDaisy(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCornflower(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedLilyOfTheValley(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedWitherRose(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedRedMushroom(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedBrownMushroom(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedDeadBush(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCactus(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedBamboo(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedAzalea(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedFloweringAzalea(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedTorchFlower(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCorkSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPlaster(colours.getId()), RenderType.cutout());
        }
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.CORK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.POTTED_CORK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.PLASTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.LOTUS_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.BLEACHED_CHALK_DUST.get(), RenderType.cutout());
    }


}
