package com.kekecreations.arts_and_crafts.core.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ArtsAndCraftsCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;


    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_WOOL;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_TERRACOTTA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_GLAZED_TERRACOTTA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_TERRACOTTA_SHINGLES;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_DECORATED_POTS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_FLOWER_POTS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_CONCRETE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_CONCRETE_POWDER;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_CHALK;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_CHALK_DUST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> CAN_PAINT_CANDLES;




    static {
        BUILDER.push("Arts And Crafts Config");

        BUILDER.comment("Settings For Paintbrushes");
        BUILDER.push("Paintbrush Options");
        CAN_PAINT_WOOL = BUILDER
                .comment("Do you want paintbrushes to be able to paint wool?")
                .define("Paintbrushes Can Paint Wool", true);

        CAN_PAINT_TERRACOTTA = BUILDER
                .comment("Do you want paintbrushes to be able to paint terracotta?")
                .define("Paintbrushes Can Paint Terracotta", true);

        CAN_PAINT_GLAZED_TERRACOTTA = BUILDER
                .comment("Do you want paintbrushes to be able to paint glazed terracotta?")
                .define("Paintbrushes Can Paint Glazed Terracotta", true);

        CAN_PAINT_TERRACOTTA_SHINGLES = BUILDER
                .comment("Do you want paintbrushes to be able to paint terracotta shingles?")
                .define("Paintbrushes Can Paint Terracotta Shingles", true);

        CAN_PAINT_DECORATED_POTS = BUILDER
                .comment("Do you want paintbrushes to be able to paint decorated pots?")
                .define("Paintbrushes Can Paint Decorated Pots", true);

        CAN_PAINT_FLOWER_POTS = BUILDER
                .comment("Do you want paintbrushes to be able to paint flower pots?")
                .define("Paintbrushes Can Paint Flower Pots", true);

        CAN_PAINT_CONCRETE = BUILDER
                .comment("Do you want paintbrushes to be able to paint concrete?")
                .define("Paintbrushes Can Paint Concrete", true);

        CAN_PAINT_CONCRETE_POWDER = BUILDER
                .comment("Do you want paintbrushes to be able to paint concrete powder?")
                .define("Paintbrushes Can Paint Concrete Powder", true);

        CAN_PAINT_CHALK = BUILDER
                .comment("Do you want paintbrushes to be able to paint chalk?")
                .define("Paintbrushes Can Paint Chalk", true);

        CAN_PAINT_CHALK_DUST = BUILDER
                .comment("Do you want paintbrushes to be able to paint chalk dust?")
                .define("Paintbrushes Can Paint Chalk Dust", true);

        CAN_PAINT_CANDLES = BUILDER
                .comment("Do you want paintbrushes to be able to paint candles?")
                .define("Paintbrushes Can Paint Candles", true);




        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
