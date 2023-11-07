package com.kekecreations.arts_and_crafts.core.misc;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class RegistryHelper {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ArtsAndCrafts.MOD_ID, Registries.BLOCK);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ArtsAndCrafts.MOD_ID, Registries.ITEM);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ArtsAndCrafts.MOD_ID, Registries.ENTITY_TYPE);


}
