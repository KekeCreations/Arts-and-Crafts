package com.kekecreations.arts_and_crafts.forge.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ForgeConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ENABLE_DYED_FLOWER_POTS;
    public static final ForgeConfigSpec.BooleanValue ENABLE_CHALK_STICKS;


    static {
        BUILDER.push("Arts & Crafts Config");

        BUILDER.comment("Setting these values to false will disable features using the vanilla isEnabled method");
        BUILDER.comment("It is recommended to create a new world after changing the config!");
        BUILDER.push("Features");
        ENABLE_DYED_FLOWER_POTS = BUILDER
                .comment("Allows flower pots to be dyed when true. Default value: true")
                .define(" ENABLE_DYED_FLOWER_POTS", true);

        ENABLE_CHALK_STICKS = BUILDER
                .comment("Should Chalk Sticks be enabled? Default value: true")
                .define(" ENABLE_CHALK_STICKS", true);


        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
