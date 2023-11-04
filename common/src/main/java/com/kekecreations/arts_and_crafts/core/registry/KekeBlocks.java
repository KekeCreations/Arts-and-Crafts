package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.core.misc.RegistryHelper;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class KekeBlocks {

    public static final RegistrySupplier<Block> BLUE_CHALK = RegistryHelper.BLOCKS.register("blue_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_CHALK_ITEM = RegistryHelper.ITEMS.register("blue_chalk", () -> new BlockItem(BLUE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIGHT_BLUE_CHALK = RegistryHelper.BLOCKS.register("light_blue_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_CHALK_ITEM = RegistryHelper.ITEMS.register("light_blue_chalk", () -> new BlockItem(LIGHT_BLUE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));

    public static final RegistrySupplier<Block> WHITE_CHALK = RegistryHelper.BLOCKS.register("white_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_CHALK_ITEM = RegistryHelper.ITEMS.register("white_chalk", () -> new BlockItem(WHITE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));

    public static final RegistrySupplier<Block> CREAM_CHALK = RegistryHelper.BLOCKS.register("cream_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CREAM_CHALK_ITEM = RegistryHelper.ITEMS.register("cream_chalk", () -> new BlockItem(CREAM_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));



    public static void register() {
        RegistryHelper.BLOCKS.register();
        RegistryHelper.ITEMS.register();
    }
}
