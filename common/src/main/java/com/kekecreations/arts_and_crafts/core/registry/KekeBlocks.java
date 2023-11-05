package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.core.misc.RegistryHelper;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class KekeBlocks {

    //BLOCKS ARE IN ORDER WITH TEXTURE FILE NAMES
    public static final RegistrySupplier<Block> BLACK_CHALK = RegistryHelper.BLOCKS.register("black_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLACK_CHALK_ITEM = RegistryHelper.ITEMS.register("black_chalk", () -> new BlockItem(BLACK_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> BLUE_CHALK = RegistryHelper.BLOCKS.register("blue_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_CHALK_ITEM = RegistryHelper.ITEMS.register("blue_chalk", () -> new BlockItem(BLUE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> BROWN_CHALK = RegistryHelper.BLOCKS.register("brown_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BROWN_CHALK_ITEM = RegistryHelper.ITEMS.register("brown_chalk", () -> new BlockItem(BROWN_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> CREAM_CHALK = RegistryHelper.BLOCKS.register("cream_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(KekeDyeColours.CREAM.getMapColor()).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CREAM_CHALK_ITEM = RegistryHelper.ITEMS.register("cream_chalk", () -> new BlockItem(CREAM_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> CRIMSON_CHALK = RegistryHelper.BLOCKS.register("crimson_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(KekeDyeColours.CRIMSON.getMapColor()).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CRIMSON_CHALK_ITEM = RegistryHelper.ITEMS.register("crimson_chalk", () -> new BlockItem(CRIMSON_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> CYAN_CHALK = RegistryHelper.BLOCKS.register("cyan_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CYAN_CHALK_ITEM = RegistryHelper.ITEMS.register("cyan_chalk", () -> new BlockItem(CYAN_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> GRAY_CHALK = RegistryHelper.BLOCKS.register("gray_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GRAY_CHALK_ITEM = RegistryHelper.ITEMS.register("gray_chalk", () -> new BlockItem(GRAY_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> GREEN_CHALK = RegistryHelper.BLOCKS.register("green_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GREEN_CHALK_ITEM = RegistryHelper.ITEMS.register("green_chalk", () -> new BlockItem(GREEN_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIGHT_BLUE_CHALK = RegistryHelper.BLOCKS.register("light_blue_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_CHALK_ITEM = RegistryHelper.ITEMS.register("light_blue_chalk", () -> new BlockItem(LIGHT_BLUE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIGHT_GRAY_CHALK = RegistryHelper.BLOCKS.register("light_gray_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_CHALK_ITEM = RegistryHelper.ITEMS.register("light_gray_chalk", () -> new BlockItem(LIGHT_GRAY_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIME_CHALK = RegistryHelper.BLOCKS.register("lime_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIME_CHALK_ITEM = RegistryHelper.ITEMS.register("lime_chalk", () -> new BlockItem(LIME_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> MAGENTA_CHALK = RegistryHelper.BLOCKS.register("magenta_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> MAGENTA_CHALK_ITEM = RegistryHelper.ITEMS.register("magenta_chalk", () -> new BlockItem(MAGENTA_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> OLIVE_CHALK = RegistryHelper.BLOCKS.register("olive_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(KekeDyeColours.OLIVE.getMapColor()).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> OLIVE_CHALK_ITEM = RegistryHelper.ITEMS.register("olive_chalk", () -> new BlockItem(OLIVE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> ORANGE_CHALK = RegistryHelper.BLOCKS.register("orange_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> ORANGE_CHALK_ITEM = RegistryHelper.ITEMS.register("orange_chalk", () -> new BlockItem(ORANGE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> PINE_CHALK = RegistryHelper.BLOCKS.register("pine_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(KekeDyeColours.PINE.getMapColor()).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINE_CHALK_ITEM = RegistryHelper.ITEMS.register("pine_chalk", () -> new BlockItem(PINE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> PINK_CHALK = RegistryHelper.BLOCKS.register("pink_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINK_CHALK_ITEM = RegistryHelper.ITEMS.register("pink_chalk", () -> new BlockItem(PINK_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> PURPLE_CHALK = RegistryHelper.BLOCKS.register("purple_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PURPLE_CHALK_ITEM = RegistryHelper.ITEMS.register("purple_chalk", () -> new BlockItem(PURPLE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> RED_CHALK = RegistryHelper.BLOCKS.register("red_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> RED_CHALK_ITEM = RegistryHelper.ITEMS.register("red_chalk", () -> new BlockItem(RED_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> TAN_CHALK = RegistryHelper.BLOCKS.register("tan_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(KekeDyeColours.TAN.getMapColor()).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> TAN_CHALK_ITEM = RegistryHelper.ITEMS.register("tan_chalk", () -> new BlockItem(TAN_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> TURQUOISE_CHALK = RegistryHelper.BLOCKS.register("turquoise_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(KekeDyeColours.TURQUOISE.getMapColor()).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> TURQUOISE_CHALK_ITEM = RegistryHelper.ITEMS.register("turquoise_chalk", () -> new BlockItem(TURQUOISE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> WHITE_CHALK = RegistryHelper.BLOCKS.register("white_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_CHALK_ITEM = RegistryHelper.ITEMS.register("white_chalk", () -> new BlockItem(WHITE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> YELLOW_CHALK = RegistryHelper.BLOCKS.register("yellow_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> YELLOW_CHALK_ITEM = RegistryHelper.ITEMS.register("yellow_chalk", () -> new BlockItem(YELLOW_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));



    public static void register() {
        RegistryHelper.BLOCKS.register();
        RegistryHelper.ITEMS.register();
    }
}
