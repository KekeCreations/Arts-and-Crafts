package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

import java.util.Map;
import java.util.function.Supplier;

public class ACDecoratedPotPatterns {
    public static final ResourceKey<DecoratedPotPattern> POTTERY_PATTERN = createKey("pottery_pattern");
    public static final ResourceKey<DecoratedPotPattern> ROLL_POTTERY_PATTERN = createKey("roll_pottery_pattern");
    public static final ResourceKey<DecoratedPotPattern> RUINED_POTTERY_PATTERN = createKey("ruined_pottery_pattern");
    public static final ResourceKey<DecoratedPotPattern> FINALE_POTTERY_PATTERN = createKey("finale_pottery_pattern");
    public static final ResourceKey<DecoratedPotPattern> GATEWAY_POTTERY_PATTERN = createKey("gateway_pottery_pattern");

    public static void registerPotPatterns() {
        register("pottery_pattern");
        register("roll_pottery_pattern");
        register("ruined_pottery_pattern");
        register("finale_pottery_pattern");
        register("gateway_pottery_pattern");
    }

    private static Supplier<DecoratedPotPattern> register(String name) {
        return Services.REGISTRY.registerDecoratedPotPattern(name, () -> new DecoratedPotPattern(ArtsAndCrafts.id(name)));
    }

    private static ResourceKey<DecoratedPotPattern> createKey(String name) {
        return ResourceKey.create(Registries.DECORATED_POT_PATTERN, ArtsAndCrafts.id(name));
    }
}
