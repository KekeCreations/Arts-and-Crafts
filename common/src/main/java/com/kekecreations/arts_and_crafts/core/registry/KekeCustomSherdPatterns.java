package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

public class KekeCustomSherdPatterns {

    public static final ResourceKey<String> ROLL_POTTERY_PATTERN = create("roll_pottery_pattern");


    //DYED POTS PATTERNS
    //BLACK
    public static final ResourceKey<String> BLACK_DECORATED_POT_BASE = create("black_decorated_pot_base");
    public static final ResourceKey<String> BLACK_DECORATED_POT_SIDE = create("black_decorated_pot_side");
    public static final ResourceKey<String> BLACK_ROLL_POTTERY_PATTERN = create("black_roll_pottery_pattern");

    //BLUE
    public static final ResourceKey<String> BLUE_DECORATED_POT_BASE = create("blue_decorated_pot_base");
    public static final ResourceKey<String> BLUE_DECORATED_POT_SIDE = create("blue_decorated_pot_side");
    public static final ResourceKey<String> BLUE_ROLL_POTTERY_PATTERN = create("blue_roll_pottery_pattern");

    //BROWN
    public static final ResourceKey<String> BROWN_DECORATED_POT_BASE = create("brown_decorated_pot_base");
    public static final ResourceKey<String> BROWN_DECORATED_POT_SIDE = create("brown_decorated_pot_side");
    public static final ResourceKey<String> BROWN_ROLL_POTTERY_PATTERN = create("brown_roll_pottery_pattern");

    //CYAN
    public static final ResourceKey<String> CYAN_DECORATED_POT_BASE = create("cyan_decorated_pot_base");
    public static final ResourceKey<String> CYAN_DECORATED_POT_SIDE = create("cyan_decorated_pot_side");
    public static final ResourceKey<String> CYAN_ROLL_POTTERY_PATTERN = create("cyan_roll_pottery_pattern");

    //GRAY
    public static final ResourceKey<String> GRAY_DECORATED_POT_BASE = create("gray_decorated_pot_base");
    public static final ResourceKey<String> GRAY_DECORATED_POT_SIDE = create("gray_decorated_pot_side");
    public static final ResourceKey<String> GRAY_ROLL_POTTERY_PATTERN = create("gray_roll_pottery_pattern");

    //GREEN
    public static final ResourceKey<String> GREEN_DECORATED_POT_BASE = create("green_decorated_pot_base");
    public static final ResourceKey<String> GREEN_DECORATED_POT_SIDE = create("green_decorated_pot_side");
    public static final ResourceKey<String> GREEN_ROLL_POTTERY_PATTERN = create("green_roll_pottery_pattern");

    //LIGHT_BLUE
    public static final ResourceKey<String> LIGHT_BLUE_DECORATED_POT_BASE = create("light_blue_decorated_pot_base");
    public static final ResourceKey<String> LIGHT_BLUE_DECORATED_POT_SIDE = create("light_blue_decorated_pot_side");
    public static final ResourceKey<String> LIGHT_BLUE_ROLL_POTTERY_PATTERN = create("light_blue_roll_pottery_pattern");

    //LIGHT_GRAY
    public static final ResourceKey<String> LIGHT_GRAY_DECORATED_POT_BASE = create("light_gray_decorated_pot_base");
    public static final ResourceKey<String> LIGHT_GRAY_DECORATED_POT_SIDE = create("light_gray_decorated_pot_side");
    public static final ResourceKey<String> LIGHT_GRAY_ROLL_POTTERY_PATTERN = create("light_gray_roll_pottery_pattern");

    //LIME
    public static final ResourceKey<String> LIME_DECORATED_POT_BASE = create("lime_decorated_pot_base");
    public static final ResourceKey<String> LIME_DECORATED_POT_SIDE = create("lime_decorated_pot_side");
    public static final ResourceKey<String> LIME_ROLL_POTTERY_PATTERN = create("lime_roll_pottery_pattern");

    //MAGENTA
    public static final ResourceKey<String> MAGENTA_DECORATED_POT_BASE = create("magenta_decorated_pot_base");
    public static final ResourceKey<String> MAGENTA_DECORATED_POT_SIDE = create("magenta_decorated_pot_side");
    public static final ResourceKey<String> MAGENTA_ROLL_POTTERY_PATTERN = create("magenta_roll_pottery_pattern");

    //ORANGE
    public static final ResourceKey<String> ORANGE_DECORATED_POT_BASE = create("orange_decorated_pot_base");
    public static final ResourceKey<String> ORANGE_DECORATED_POT_SIDE = create("orange_decorated_pot_side");
    public static final ResourceKey<String> ORANGE_ROLL_POTTERY_PATTERN = create("orange_roll_pottery_pattern");

    //PINK
    public static final ResourceKey<String> PINK_DECORATED_POT_BASE = create("pink_decorated_pot_base");
    public static final ResourceKey<String> PINK_DECORATED_POT_SIDE = create("pink_decorated_pot_side");
    public static final ResourceKey<String> PINK_ROLL_POTTERY_PATTERN = create("pink_roll_pottery_pattern");

    //PURPLE
    public static final ResourceKey<String> PURPLE_DECORATED_POT_BASE = create("purple_decorated_pot_base");
    public static final ResourceKey<String> PURPLE_DECORATED_POT_SIDE = create("purple_decorated_pot_side");
    public static final ResourceKey<String> PURPLE_ROLL_POTTERY_PATTERN = create("purple_roll_pottery_pattern");

    //RED
    public static final ResourceKey<String> RED_DECORATED_POT_BASE = create("red_decorated_pot_base");
    public static final ResourceKey<String> RED_DECORATED_POT_SIDE = create("red_decorated_pot_side");
    public static final ResourceKey<String> RED_ROLL_POTTERY_PATTERN = create("red_roll_pottery_pattern");

    //WHITE
    public static final ResourceKey<String> WHITE_DECORATED_POT_BASE = create("white_decorated_pot_base");
    public static final ResourceKey<String> WHITE_DECORATED_POT_SIDE = create("white_decorated_pot_side");
    public static final ResourceKey<String> WHITE_ROLL_POTTERY_PATTERN = create("white_roll_pottery_pattern");

    //YELLOW
    public static final ResourceKey<String> YELLOW_DECORATED_POT_BASE = create("yellow_decorated_pot_base");
    public static final ResourceKey<String> YELLOW_DECORATED_POT_SIDE = create("yellow_decorated_pot_side");
    public static final ResourceKey<String> YELLOW_ROLL_POTTERY_PATTERN = create("yellow_roll_pottery_pattern");





    private static ResourceKey<String> create(String string) {
        return ResourceKey.create(Registries.DECORATED_POT_PATTERNS, ArtsAndCrafts.id(string));
    }

    public static void register() {
    }
}
