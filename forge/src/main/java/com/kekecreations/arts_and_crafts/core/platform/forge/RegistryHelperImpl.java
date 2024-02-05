package com.kekecreations.arts_and_crafts.core.platform.forge;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class RegistryHelperImpl {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArtsAndCrafts.MOD_ID);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ArtsAndCrafts.MOD_ID);


    public static <T extends Entity>Supplier<EntityType<T>> registerEntityType(String id, Supplier<EntityType<T>> entitySupplier) {
        return ENTITY_TYPES.register(id, entitySupplier);
    }

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

    public static Supplier<SimpleParticleType> registerParticle(String id) {
        return PARTICLE_TYPES.register(id, () -> new SimpleParticleType(false));
    }

    public static <T extends BlockEntity>Supplier<BlockEntityType<T>> registerBlockEntityType(String id, Supplier<BlockEntityType<T>> blockEntityTypeSupplier) {
        return BLOCK_ENTITY_TYPES.register(id, blockEntityTypeSupplier);
    }

}
