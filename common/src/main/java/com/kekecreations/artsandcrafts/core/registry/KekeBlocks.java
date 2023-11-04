package com.kekecreations.artsandcrafts.core.registry;

import com.kekecreations.artsandcrafts.core.misc.RegistryHelper;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class KekeBlocks {

    public static final RegistrySupplier<Block> BLUE_CHALK = RegistryHelper.BLOCKS.register("blue_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_CHALK_ITEM = RegistryHelper.ITEMS.register("blue_chalk", () -> new BlockItem(BLUE_CHALK.get(), new Item.Properties()));
    public static final RegistrySupplier<Block> LIGHT_BLUE_CHALK = RegistryHelper.BLOCKS.register("light_blue_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_CHALK_ITEM = RegistryHelper.ITEMS.register("light_blue_chalk", () -> new BlockItem(LIGHT_BLUE_CHALK.get(), new Item.Properties()));



    public static void register() {
        RegistryHelper.BLOCKS.register();
        RegistryHelper.ITEMS.register();
    }
}
