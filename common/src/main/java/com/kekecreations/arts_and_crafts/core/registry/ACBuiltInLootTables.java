package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ACBuiltInLootTables {
    private static final Set<ResourceKey<LootTable>> LOCATIONS = new HashSet();
    private static final Set<ResourceKey<LootTable>> IMMUTABLE_LOCATIONS;
    public static final ResourceKey<LootTable> LOTUS_FLOWER_HARVEST = ACBuiltInLootTables.register("gameplay/lotus_flower_harvest");


    private static ResourceKey<LootTable> register(String $$0) {
        return register(ResourceKey.create(Registries.LOOT_TABLE, ArtsAndCrafts.id($$0)));
    }

    private static ResourceKey<LootTable> register(ResourceKey<LootTable> $$0) {
        if (LOCATIONS.add($$0)) {
            return $$0;
        } else {
            throw new IllegalArgumentException(String.valueOf($$0.location()) + " is already a registered built-in loot table");
        }
    }
    static {
        IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);
    }

    public static Set<ResourceKey<LootTable>> all() {
        return IMMUTABLE_LOCATIONS;
    }
}
