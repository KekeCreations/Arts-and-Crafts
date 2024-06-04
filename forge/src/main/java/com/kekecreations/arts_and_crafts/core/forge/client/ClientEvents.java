package com.kekecreations.arts_and_crafts.core.forge.client;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.client.renderer.tile.CustomBedBER;
import com.kekecreations.arts_and_crafts.client.renderer.tile.DyedDecoratedPotBER;
import com.kekecreations.arts_and_crafts.client.renderer.entity.CustomBoatRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@Mod.EventBusSubscriber(modid = ArtsAndCrafts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entity Renderers
        event.registerEntityRenderer(KekeEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        event.registerEntityRenderer(KekeEntityTypes.BOAT.get(), context -> new CustomBoatRenderer(context, false));
        event.registerEntityRenderer(KekeEntityTypes.CHEST_BOAT.get(), context -> new CustomBoatRenderer(context, true));
        event.registerBlockEntityRenderer(KekeEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), DyedDecoratedPotBER::new);
        event.registerBlockEntityRenderer(KekeEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), CustomBedBER::new);
    }
    @SubscribeEvent
    public static void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CustomBoatRenderer.BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(CustomBoatRenderer.CHEST_BOAT, ChestBoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent registerParticleProvidersEvent) {
        for (DyeColor colours : DyeColor.values()) {
            registerParticleProvidersEvent.registerSpriteSet(KekeParticles.getChalkDrawParticle(colours), ChalkDustParticle.Factory::new);
        }
        registerParticleProvidersEvent.registerSpriteSet(KekeParticles.BLEACHED_CHALK_DRAW.get(), ChalkDustParticle.Factory::new);
    }
    @SubscribeEvent
    public static void registerBlockColours(RegisterColorHandlersEvent.Block registerColorHandlersEvent) {
        for (DyeColor colours : DyeColor.values()) {
            registerColorHandlersEvent.register((blockState, blockAndTintGetter, blockPos, i) -> {
                if (blockAndTintGetter == null || blockPos == null) {
                    return GrassColor.getDefaultColor();
                }
                return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
            }, KekeBlocks.getDyedPottedFern(colours));
        }
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        for (DyeColor colours : DyeColor.values()) {
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getChalkDust(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCrimsonFungus(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCrimsonRoots(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedWarpedFungus(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedWarpedRoots(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedOakSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedSpruceSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedBirchSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedAcaciaSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedJungleSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCherrySapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedDarkOakSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedMangrovePropagule(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedFern(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedDandelion(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedPoppy(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedBlueOrchid(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedAllium(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedAzureBluet(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedRedTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedOrangeTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedWhiteTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedPinkTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedOxeyeDaisy(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCornflower(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedLilyOfTheValley(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedWitherRose(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedRedMushroom(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedBrownMushroom(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedDeadBush(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCactus(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedBamboo(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedAzalea(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedFloweringAzalea(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedTorchFlower(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCorkSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPlaster(colours.getId()), RenderType.cutout());
        }
        ItemBlockRenderTypes.setRenderLayer(KekeBlocks.CORK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(KekeBlocks.POTTED_CORK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(KekeBlocks.PLASTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(KekeBlocks.LOTUS_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(KekeBlocks.BLEACHED_CHALK_DUST.get(), RenderType.cutout());
    }


}
