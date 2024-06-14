package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ACFeatures {

    public static class ConfiguredFeatures {
        public static final ResourceKey<ConfiguredFeature<?, ?>> CORK_TREE = createKey("cork_tree");

        public static final ResourceKey<ConfiguredFeature<?, ?>> SOAPSTONE_PATCH = createKey("soapstone_patch");

        public static final ResourceKey<ConfiguredFeature<?, ?>> CHALK_PATCH = createKey("chalk_patch");

        public static final ResourceKey<ConfiguredFeature<?, ?>> GYPSUM_PATCH = createKey("gypsum_patch");



        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, ArtsAndCrafts.id(name));
        }
    }

    public static class PlacedFeatures {

        public static final ResourceKey<PlacedFeature> CORK_TREE = createKey("cork_tree");

        public static final ResourceKey<PlacedFeature> SOAPSTONE_PATCH = createKey("soapstone_patch");

        public static final ResourceKey<PlacedFeature> CHALK_PATCH = createKey("chalk_patch");
        public static final ResourceKey<PlacedFeature> GYPSUM_PATCH = createKey("gypsum_patch");


        public static ResourceKey<PlacedFeature> createKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, ArtsAndCrafts.id(name));
        }
    }
}
