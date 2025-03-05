package com.kekecreations.arts_and_crafts.neoforge.core.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class NeoForgeConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue ENABLE_DYED_FLOWER_POTS;
    public static final ModConfigSpec.BooleanValue ENABLE_CHALK_STICKS;
    public static final ModConfigSpec.BooleanValue ENABLE_DYED_DECORATED_POTS;
    public static final ModConfigSpec.BooleanValue ENABLE_CREATIVE_MODE_TAB;
    public static final ModConfigSpec.BooleanValue BLEACHABLE_SHEEP;


    static {
        BUILDER.push("Arts & Crafts Config");

        BUILDER.comment("Setting these values to false will disable features using the vanilla isEnabled method");
        BUILDER.comment("It is recommended to create a new world after changing the config!");
        BUILDER.push("Features");

        ENABLE_DYED_FLOWER_POTS = BUILDER
                .comment("Allows flower pots to be dyed when true. Default value: true")
                .define("enableDyedFlowerPots", true);

        ENABLE_CHALK_STICKS = BUILDER
                .comment("Should chalk sticks be enabled? Default value: true")
                .define("enableChalkSticks", true);

        ENABLE_DYED_DECORATED_POTS = BUILDER
                .comment("Allows decorated pots to be dyed when true. Default value: true")
                .define("enableDyedDecoratedPots", true);

        ENABLE_CREATIVE_MODE_TAB = BUILDER
                .comment("When true adds a new creative mode tab full of Arts & Crafts features!")
                .define("enableCreativeModeTab", false);

        BLEACHABLE_SHEEP = BUILDER
                .comment("Allows the player to bleach sheep  (Yirmiri wanted this really bad for some reason)")
                .define("bleachableSheep", false);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
