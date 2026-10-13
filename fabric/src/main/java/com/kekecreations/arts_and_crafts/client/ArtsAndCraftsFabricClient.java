package com.kekecreations.arts_and_crafts.client;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.ArtsAndCraftsFabric;
import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.tile.DyedDecoratedPotSpecialRenderer;
import com.kekecreations.arts_and_crafts.client.renderer.tile.state.ACBedBER;
import com.kekecreations.arts_and_crafts.client.renderer.tile.state.DyedDecoratedPotBER;
import com.kekecreations.arts_and_crafts.client.renderer.tile.state.DyedFlowerPotBER;
import com.kekecreations.arts_and_crafts.common.entity.ACBedBlockEntity;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.entity.DyedFlowerPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.kekecreations.arts_and_crafts.core.config.FabricConfig;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.fabricmc.fabric.impl.client.rendering.EntityRendererRegistryImpl;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ArtsAndCraftsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerRenderers();
        registerParticleFactories();
        registerModelLayers();


        ClientPlayNetworking.registerGlobalReceiver(FabricConfig.PACKET_ID, (config, context) -> {
            ArtsAndCraftsFabric.setConfig(config);
        });
    }

    public static void registerParticleFactories() {
        for (DyeColor colours : DyeColor.values()) {
            ParticleProviderRegistry.getInstance().register(ACParticles.getChalkDrawParticle(colours.getId()), ChalkDustParticle.Factory::new);
        }
        ParticleProviderRegistry.getInstance().register(ACParticles.getChalkDrawParticle(-1), ChalkDustParticle.Factory::new);
    }

    public static void registerRenderers() {
        EntityRendererRegistryImpl.register((EntityType<? extends FloatingBlockEntity>) ACEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        BlockEntityRenderers.register((BlockEntityType<? extends DyedDecoratedPotBlockEntity>) ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), DyedDecoratedPotBER::new);
        BlockEntityRenderers.register((BlockEntityType<? extends ACBedBlockEntity>) ACEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), ACBedBER::new);
        BlockEntityRenderers.register((BlockEntityType<? extends DyedFlowerPotBlockEntity>) ACEntityTypes.DYED_FLOWER_POT_BLOCK_ENTITY.get(), DyedFlowerPotBER::new);
        SpecialModelRenderers.ID_MAPPER.put(ArtsAndCrafts.id("dyed_decorated_pot"), DyedDecoratedPotSpecialRenderer.Unbaked.MAP_CODEC);

        EntityRendererRegistryImpl.register((EntityType<? extends Boat>) ACEntityTypes.CORK_BOAT.get(), ctx -> new BoatRenderer(ctx, ACModelLayers.CORK_BOAT));
        EntityRendererRegistryImpl.register((EntityType<? extends Boat>) ACEntityTypes.CORK_CHEST_BOAT.get(), ctx -> new BoatRenderer(ctx, ACModelLayers.CORK_CHEST_BOAT));
    }

    public static void registerModelLayers() {
        ModelLayerRegistry.registerModelLayer(DyedDecoratedPotBER.BASE, DyedDecoratedPotBER::createBaseLayer);
        ModelLayerRegistry.registerModelLayer(DyedDecoratedPotBER.SIDE, DyedDecoratedPotBER::createSidesLayer);
        ModelLayerRegistry.registerModelLayer(ACModelLayers.CORK_BOAT, BoatModel::createBoatModel);
        ModelLayerRegistry.registerModelLayer(ACModelLayers.CORK_CHEST_BOAT, BoatModel::createChestBoatModel);
    }
}
