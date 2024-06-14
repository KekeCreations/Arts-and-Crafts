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


    //DYED POT BASES
    //BLACK
    public static final ResourceKey<String> BLACK_DECORATED_POT_BASE = create("black_decorated_pot_base");

    //BLUE
    public static final ResourceKey<String> BLUE_DECORATED_POT_BASE = create("blue_decorated_pot_base");

    //BROWN
    public static final ResourceKey<String> BROWN_DECORATED_POT_BASE = create("brown_decorated_pot_base");

    //CYAN
    public static final ResourceKey<String> CYAN_DECORATED_POT_BASE = create("cyan_decorated_pot_base");

    //GRAY
    public static final ResourceKey<String> GRAY_DECORATED_POT_BASE = create("gray_decorated_pot_base");

    //GREEN
    public static final ResourceKey<String> GREEN_DECORATED_POT_BASE = create("green_decorated_pot_base");

    //LIGHT_BLUE
    public static final ResourceKey<String> LIGHT_BLUE_DECORATED_POT_BASE = create("light_blue_decorated_pot_base");

    //LIGHT_GRAY
    public static final ResourceKey<String> LIGHT_GRAY_DECORATED_POT_BASE = create("light_gray_decorated_pot_base");

    //LIME
    public static final ResourceKey<String> LIME_DECORATED_POT_BASE = create("lime_decorated_pot_base");

    //MAGENTA
    public static final ResourceKey<String> MAGENTA_DECORATED_POT_BASE = create("magenta_decorated_pot_base");

    //ORANGE
    public static final ResourceKey<String> ORANGE_DECORATED_POT_BASE = create("orange_decorated_pot_base");

    //PINK
    public static final ResourceKey<String> PINK_DECORATED_POT_BASE = create("pink_decorated_pot_base");

    //PURPLE
    public static final ResourceKey<String> PURPLE_DECORATED_POT_BASE = create("purple_decorated_pot_base");

    //RED
    public static final ResourceKey<String> RED_DECORATED_POT_BASE = create("red_decorated_pot_base");

    //WHITE
    public static final ResourceKey<String> WHITE_DECORATED_POT_BASE = create("white_decorated_pot_base");

    //YELLOW
    public static final ResourceKey<String> YELLOW_DECORATED_POT_BASE = create("yellow_decorated_pot_base");



    private static ResourceKey<String> create(String string) {
        return ResourceKey.create(Registries.DECORATED_POT_PATTERNS, ArtsAndCrafts.id(string));
    }

    public static void register() {
    }
}
