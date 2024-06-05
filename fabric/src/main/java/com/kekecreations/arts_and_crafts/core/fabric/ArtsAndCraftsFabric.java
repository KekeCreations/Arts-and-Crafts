package com.kekecreations.arts_and_crafts.core.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.fabric.registry.KekeFabricFlammableAndStrippableBlocks;
import com.kekecreations.arts_and_crafts.core.fabric.util.ArtsAndCraftsFabricLootModifiers;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsRegistries;
import com.kekecreations.arts_and_crafts.core.registry.KekeFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ArtsAndCraftsFabric implements ModInitializer {
    @Override
    public void onInitialize() {

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
