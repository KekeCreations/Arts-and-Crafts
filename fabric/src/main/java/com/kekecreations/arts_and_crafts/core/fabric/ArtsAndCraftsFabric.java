package com.kekecreations.arts_and_crafts.core.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.config.Config;
import com.kekecreations.arts_and_crafts.core.fabric.common.event.ACItemGroupEvents;
import com.kekecreations.arts_and_crafts.core.fabric.core.registry.ACFabricRegistries;
import com.kekecreations.arts_and_crafts.core.fabric.common.event.ACLootTableEvents;
import com.kekecreations.arts_and_crafts.core.registry.ACRegistries;
import com.kekecreations.arts_and_crafts.core.registry.ACFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

import static com.kekecreations.arts_and_crafts.ArtsAndCrafts.SYNC_CONFIG_PACKET;
import static com.kekecreations.arts_and_crafts.ArtsAndCrafts.config;

public class ArtsAndCraftsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ArtsAndCrafts.init();
        config();
        ACItemGroupEvents.add();
        ACFabricRegistries.register();
        ACLootTableEvents.modifyVanillaLootTables();
        createBiomeModifications();
        DynamicRegistries.register(ACRegistries.PAINTBRUSH_PALETTE, PaintbrushPalette.CODEC);
    }

    public void createBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, ACFeatures.PlacedFeatures.CORK_TREE);
        BiomeModifications.addFeature(BiomeSelectors.tag(ArtsAndCraftsTags.BiomeTags.SOAPSTONE_CAN_GENERATE_IN), GenerationStep.Decoration.UNDERGROUND_ORES, ACFeatures.PlacedFeatures.SOAPSTONE_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN), GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ACFeatures.PlacedFeatures.CHALK_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.tag(ArtsAndCraftsTags.BiomeTags.GYPSUM_CAN_GENERATE_IN), GenerationStep.Decoration.UNDERGROUND_DECORATION, ACFeatures.PlacedFeatures.GYPSUM_PATCH);
    }


    public void config() {
        ResourceManagerHelper.get(PackType.SERVER_DATA)
                .registerReloadListener(new SimpleSynchronousResourceReloadListener() {
                    @Override
                    public ResourceLocation getFabricId() {
                        return ResourceLocation.tryBuild(ArtsAndCrafts.MOD_ID, "config");
                    }

                    @Override
                    public void onResourceManagerReload(ResourceManager manager) {
                        config = Config.load();
                    }
                });

        ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((player, joined) -> {
            var buf = PacketByteBufs.create();
            config.writeToClient(buf);
            ServerPlayNetworking.send(player, SYNC_CONFIG_PACKET, buf);
            if (Config.lastError != null) {
                player.displayClientMessage(Component.literal("[Arts & Crafts]: ")
                        .append(Config.lastError).withStyle(ChatFormatting.RED),
                        false);
            }
        });
    }
}
