package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

public class ACCustomSherdPatterns {

    public static final ResourceKey<String> POTTERY_PATTERN = create("pottery_pattern");
    public static final ResourceKey<String> ROLL_POTTERY_PATTERN = create("roll_pottery_pattern");
    public static final ResourceKey<String> RUINED_POTTERY_PATTERN = create("ruined_pottery_pattern");
    public static final ResourceKey<String> FINALE_POTTERY_PATTERN = create("finale_pottery_pattern");
    public static final ResourceKey<String> GATEWAY_POTTERY_PATTERN = create("gateway_pottery_pattern");

    private static ResourceKey<String> create(String string) {
        return ResourceKey.create(Registries.DECORATED_POT_PATTERNS, ArtsAndCrafts.id(string));
    }

    public static void register() {
    }
}
