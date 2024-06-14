package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

public class ACDecoratedPotPatterns {
    public static final ResourceKey<DecoratedPotPattern> POTTERY_PATTERN = createKey("empty");
    public static final ResourceKey<DecoratedPotPattern> ROLL_POTTERY_PATTERN = createKey("roll");
    public static final ResourceKey<DecoratedPotPattern> RUINED_POTTERY_PATTERN = createKey("ruined");
    public static final ResourceKey<DecoratedPotPattern> FINALE_POTTERY_PATTERN = createKey("finale");
    public static final ResourceKey<DecoratedPotPattern> GATEWAY_POTTERY_PATTERN = createKey("gateway");


    public static void registerPotPatterns() {
    }

    public static DecoratedPotPattern register(Registry<DecoratedPotPattern> registry, ResourceKey<DecoratedPotPattern> resourceKey, String string) {
        return (DecoratedPotPattern)Registry.register(registry, resourceKey, new DecoratedPotPattern(ArtsAndCrafts.id(string)));
    }

    private static ResourceKey<DecoratedPotPattern> createKey(String name) {
        return ResourceKey.create(Registries.DECORATED_POT_PATTERN, ArtsAndCrafts.id(name));
    }
}
