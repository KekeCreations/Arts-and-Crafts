package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

public class KekeCustomSherdPatterns {

    public static final ResourceKey<String> ROLL = create("roll_pottery_pattern");

    private static ResourceKey<String> create(String string) {
        return ResourceKey.create(Registries.DECORATED_POT_PATTERNS, ArtsAndCrafts.id(string));
    }

    public static void register() {
    }
}
