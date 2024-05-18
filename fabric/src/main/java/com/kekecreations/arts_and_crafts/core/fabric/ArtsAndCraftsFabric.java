package com.kekecreations.arts_and_crafts.core.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import com.kekecreations.arts_and_crafts.core.fabric.registry.KekeFabricFlammableAndStrippableBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeFeatures;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.fml.config.ModConfig;

public class ArtsAndCraftsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ForgeConfigRegistry.INSTANCE.register(ArtsAndCrafts.MOD_ID, ModConfig.Type.COMMON, ArtsAndCraftsCommonConfig.SPEC, "arts_and_crafts-common.toml");



        ArtsAndCrafts.init();
        ArtsAndCraftsItemGroupEvents.add();
        KekeFabricFlammableAndStrippableBlocks.register();
        createBiomeModifications();
    }



    public void createBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, KekeFeatures.PlacedFeatures.CORK_TREE);

        BiomeModifications.addFeature(BiomeSelectors.tag(ArtsAndCraftsTags.BiomeTags.SOAPSTONE_CAN_GENERATE_IN), GenerationStep.Decoration.UNDERGROUND_ORES, KekeFeatures.PlacedFeatures.SOAPSTONE_PATCH);
    }


}
