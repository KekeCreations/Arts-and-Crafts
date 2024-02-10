package com.kekecreations.arts_and_crafts.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeFeatures;
import com.kekecreations.arts_and_crafts.fabric.misc.KekeItemGroupEvents;
import com.kekecreations.arts_and_crafts.fabric.registry.KekeFabricBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ArtsAndCraftsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ArtsAndCrafts.init();
        KekeItemGroupEvents.add();
        KekeFabricBlocks.register();
        createBiomeModifications();
    }



    public void createBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, KekeFeatures.PlacedFeatures.CORK_TREE);

    }


}
