package com.kekecreations.arts_and_crafts.core.registry;

import com.google.common.collect.Sets;
import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class ArtsAndCraftsBuiltInLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);
    public static final ResourceLocation EMPTY = new ResourceLocation("empty");
    public static final ResourceLocation LOTUS_FLOWER_HARVEST = ArtsAndCraftsBuiltInLootTables.register("gameplay/lotus_flower_harvest");


    private static ResourceLocation register(String string) {
        return ArtsAndCraftsBuiltInLootTables.register(ArtsAndCrafts.id(string));
    }

    private static ResourceLocation register(ResourceLocation resourceLocation) {
        if (LOCATIONS.add(resourceLocation)) {
            return resourceLocation;
        }
        throw new IllegalArgumentException(resourceLocation + " is already a registered built-in loot table");
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}
