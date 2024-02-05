package com.kekecreations.arts_and_crafts.core.platform.fabric;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class RegistryHelperImpl {


    public static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> itemSupplier) {
        var item = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), itemSupplier.get());
        return () -> item;
    }
    public static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), blockSupplier.get());
        return () -> block;
    }

    public static <T extends Block> Supplier<T> registerBlockWithItem(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), new BlockItem(block, new Item.Properties()));
        return () -> block;
    }

    public static Supplier<SimpleParticleType> registerParticle(String id) {
        var particleType = Registry.register(BuiltInRegistries.PARTICLE_TYPE, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), FabricParticleTypes.simple());
        return () -> particleType;
    }
    public static <T extends Entity>Supplier<EntityType<T>> registerEntityType(String id, Supplier<EntityType<T>> entitySupplier) {
        var entityType = Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), entitySupplier.get());
        return () -> entityType;
    }

    public static <T extends BlockEntity>Supplier<BlockEntityType<T>> registerBlockEntityType(String id, Supplier<BlockEntityType<T>> blockEntityTypeSupplier) {
        var blockEntityType = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), blockEntityTypeSupplier.get());
        return () -> blockEntityType;
    }


}
