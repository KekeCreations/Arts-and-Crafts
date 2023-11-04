package com.kekecreations.artsandcrafts.core.misc;

import com.kekecreations.artsandcrafts.ExampleMod;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RegistryHelper {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ExampleMod.MOD_ID, Registries.BLOCK);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ExampleMod.MOD_ID, Registries.ITEM);

}
