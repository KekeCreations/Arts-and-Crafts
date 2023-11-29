package com.kekecreations.arts_and_crafts.core.platform.forge;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class RegistryHelperImpl {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArtsAndCrafts.MOD_ID);



    public static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> blockSupplier) {
        return BLOCKS.register(id, blockSupplier);
    }

    public static <T extends Block>Supplier<T> registerBlockWithItem(String id, Supplier<T> blockSupplier) {
        var block = BLOCKS.register(id, blockSupplier);
        ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> itemSupplier) {
        return ITEMS.register(id, itemSupplier);
    }





}
