package com.kekecreations.arts_and_crafts.core.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.common.util.ACTags;
import com.kekecreations.arts_and_crafts.core.fabric.common.event.ACItemGroupEvents;
import com.kekecreations.arts_and_crafts.core.fabric.core.registry.ACFabricRegistries;
import com.kekecreations.arts_and_crafts.core.fabric.common.event.ACLootTableEvents;
import com.kekecreations.arts_and_crafts.core.registry.ACRegistries;
import com.kekecreations.arts_and_crafts.core.registry.ACFeatures;
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
        ACItemGroupEvents.add();
        ACFabricRegistries.register();
        ACLootTableEvents.modifyVanillaLootTables();
        createBiomeModifications();
        DynamicRegistries.register(ACRegistries.PAINTBRUSH_PALETTE, PaintbrushPalette.CODEC);
    }

    public void createBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, ACFeatures.PlacedFeatures.CORK_TREE);

        BiomeModifications.addFeature(BiomeSelectors.tag(ACTags.BiomeTags.SOAPSTONE_CAN_GENERATE_IN), GenerationStep.Decoration.UNDERGROUND_ORES, ACFeatures.PlacedFeatures.SOAPSTONE_PATCH);

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN), GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ACFeatures.PlacedFeatures.CHALK_PATCH);

        BiomeModifications.addFeature(BiomeSelectors.tag(ACTags.BiomeTags.GYPSUM_CAN_GENERATE_IN), GenerationStep.Decoration.UNDERGROUND_DECORATION, ACFeatures.PlacedFeatures.GYPSUM_PATCH);
    }
}
