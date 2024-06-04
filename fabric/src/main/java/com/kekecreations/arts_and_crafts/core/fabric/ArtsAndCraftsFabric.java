package com.kekecreations.arts_and_crafts.core.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import com.kekecreations.arts_and_crafts.core.fabric.registry.KekeFabricFlammableAndStrippableBlocks;
import com.kekecreations.arts_and_crafts.core.fabric.util.ArtsAndCraftsFabricLootModifiers;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsRegistries;
import com.kekecreations.arts_and_crafts.core.registry.KekeFeatures;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.fml.config.ModConfig;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ArtsAndCraftsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ForgeConfigRegistry.INSTANCE.register(ArtsAndCrafts.MOD_ID, ModConfig.Type.COMMON, ArtsAndCraftsCommonConfig.SPEC, "arts_and_crafts-common.toml");

        ArtsAndCrafts.init();
        ArtsAndCraftsItemGroupEvents.add();
        KekeFabricFlammableAndStrippableBlocks.register();
        ArtsAndCraftsFabricLootModifiers.modifyVanillaLootTables();
        createBiomeModifications();
        DynamicRegistries.registerSynced(ArtsAndCraftsRegistries.PAINTBRUSH_PALETTE, PaintbrushPalette.CODEC);
    }

    public void createBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, KekeFeatures.PlacedFeatures.CORK_TREE);

        BiomeModifications.addFeature(BiomeSelectors.tag(ArtsAndCraftsTags.BiomeTags.SOAPSTONE_CAN_GENERATE_IN), GenerationStep.Decoration.UNDERGROUND_ORES, KekeFeatures.PlacedFeatures.SOAPSTONE_PATCH);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN), GenerationStep.Decoration.TOP_LAYER_MODIFICATION, KekeFeatures.PlacedFeatures.CHALK_PATCH);

        BiomeModifications.addFeature(BiomeSelectors.tag(ArtsAndCraftsTags.BiomeTags.GYPSUM_CAN_GENERATE_IN), GenerationStep.Decoration.UNDERGROUND_DECORATION, KekeFeatures.PlacedFeatures.GYPSUM_PATCH);
    }
}
