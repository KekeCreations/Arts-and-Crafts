package com.kekecreations.arts_and_crafts.client;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.tile.DyedDecoratedPotSpecialRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.tile.state.ACBedBER;
import com.kekecreations.arts_and_crafts.client.renderer.tile.state.DyedDecoratedPotBER;
import com.kekecreations.arts_and_crafts.common.entity.ACBedBlockEntity;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACParticles;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.RegisterSpecialModelRendererEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@EventBusSubscriber(modid = ArtsAndCrafts.MOD_ID,  value = Dist.CLIENT)
public class ClientEvents {


    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ACModelLayers.CORK_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(ACModelLayers.CORK_CHEST_BOAT, BoatModel::createChestBoatModel);
        event.registerLayerDefinition(DyedDecoratedPotBER.BASE, DyedDecoratedPotBER::createBaseLayer);
        event.registerLayerDefinition(DyedDecoratedPotBER.SIDE, DyedDecoratedPotBER::createSidesLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entity Renderers
        event.registerEntityRenderer((EntityType<? extends FloatingBlockEntity>) ACEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        event.registerEntityRenderer((EntityType<? extends AbstractBoat>) ACEntityTypes.CORK_BOAT.get(), context -> new BoatRenderer(context, ACModelLayers.CORK_BOAT));
        event.registerEntityRenderer((EntityType<? extends AbstractBoat>) ACEntityTypes.CORK_CHEST_BOAT.get(), context -> new BoatRenderer(context, ACModelLayers.CORK_CHEST_BOAT));
        event.registerBlockEntityRenderer((BlockEntityType<? extends DyedDecoratedPotBlockEntity>) ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), DyedDecoratedPotBER::new);
        event.registerBlockEntityRenderer((BlockEntityType<? extends ACBedBlockEntity>) ACEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), ACBedBER::new);
    }

    @SubscribeEvent
    public static void registerSpecialRenderers(RegisterSpecialModelRendererEvent event) {
        event.register(ArtsAndCrafts.id("dyed_decorated_pot"), DyedDecoratedPotSpecialRenderer.Unbaked.MAP_CODEC
        );
    }

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent registerParticleProvidersEvent) {
        for (DyeColor colours : DyeColor.values()) {
            registerParticleProvidersEvent.registerSpriteSet(ACParticles.getChalkDrawParticle(colours.getId()), ChalkDustParticle.Factory::new);
        }
        registerParticleProvidersEvent.registerSpriteSet(ACParticles.getChalkDrawParticle(-1), ChalkDustParticle.Factory::new);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        for (DyeColor colours : DyeColor.values()) {
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getChalkDust(colours.getId()), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCrimsonFungus(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCrimsonRoots(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedWarpedFungus(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedWarpedRoots(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedOakSapling(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedSpruceSapling(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedBirchSapling(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedAcaciaSapling(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedJungleSapling(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCherrySapling(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedDarkOakSapling(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedMangrovePropagule(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedFern(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedDandelion(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedPoppy(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedBlueOrchid(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedAllium(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedAzureBluet(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedRedTulip(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedOrangeTulip(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedWhiteTulip(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedPinkTulip(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedOxeyeDaisy(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCornflower(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedLilyOfTheValley(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedWitherRose(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedRedMushroom(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedBrownMushroom(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedDeadBush(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCactus(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedBamboo(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedAzalea(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedFloweringAzalea(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedTorchFlower(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPottedCorkSapling(colours), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedPlaster(colours.getId()), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(ACBlocks.getDyedFlowerPot(colours.getId()), ChunkSectionLayer.CUTOUT);
        }
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.CORK_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.POTTED_CORK_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.PLASTER.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.LOTUS_FLOWER.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(ACBlocks.BLEACHED_CHALK_DUST.get(), ChunkSectionLayer.CUTOUT);
        //ItemBlockRenderTypes.setRenderLayer(ACBlocks.CRIMSON_HANGING_FLOWER_POT.get(), RenderType.cutout());
    }
}
