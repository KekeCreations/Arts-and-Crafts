package com.kekecreations.arts_and_crafts;

import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.core.config.FabricConfig;
import com.kekecreations.arts_and_crafts.core.registry.ACRegistries;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;

public class ArtsAndCraftsFabric implements ModInitializer {

    //Config stuff
    public static FabricConfig config;
    public static FabricConfig getConfig() {
        return config;
    }
    public static void setConfig(FabricConfig config) {
        ArtsAndCraftsFabric.config = config;
    }

    @Override
    public void onInitialize() {
        config();
        ArtsAndCrafts.init();
        DynamicRegistries.register(ACRegistries.PAINTBRUSH_PALETTE, PaintbrushPalette.CODEC);
    }

    public void config() {
        PayloadTypeRegistry.playS2C().register(FabricConfig.PACKET_ID, FabricConfig.PACKET_CODEC);

        ResourceManagerHelper.get(PackType.SERVER_DATA)
                .registerReloadListener(new SimpleSynchronousResourceReloadListener() {
                    @Override
                    public Identifier getFabricId() {
                        return ArtsAndCrafts.id("config");
                    }
                    @Override
                    public void onResourceManagerReload(ResourceManager manager) {
                        config = FabricConfig.load();
                    }
                });

        ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((player, joined) -> {
            ServerPlayNetworking.send(player, config);
            if (FabricConfig.lastError != null) {
                player.displayClientMessage(Component.literal("[Arts & Crafts]: ")
                        .append(FabricConfig.lastError).withStyle(ChatFormatting.RED), false);
            }
        });
    }
}
