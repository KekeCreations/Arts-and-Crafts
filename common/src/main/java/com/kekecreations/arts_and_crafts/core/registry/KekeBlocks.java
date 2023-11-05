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
    public static final RegistrySupplier<Block> CREAM_CHALK = RegistryHelper.BLOCKS.register("cream_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CREAM_CHALK_ITEM = RegistryHelper.ITEMS.register("cream_chalk", () -> new BlockItem(CREAM_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> CRIMSON_CHALK = RegistryHelper.BLOCKS.register("crimson_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
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


    public static final RegistrySupplier<Block> WHITE_CHALK = RegistryHelper.BLOCKS.register("white_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_CHALK_ITEM = RegistryHelper.ITEMS.register("white_chalk", () -> new BlockItem(WHITE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));






    public static void register() {
        RegistryHelper.BLOCKS.register();
        RegistryHelper.ITEMS.register();
    }
}
