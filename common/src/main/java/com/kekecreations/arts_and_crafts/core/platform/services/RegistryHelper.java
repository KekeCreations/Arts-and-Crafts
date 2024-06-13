package com.kekecreations.arts_and_crafts.core.platform.services;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public interface RegistryHelper {


    Supplier<SoundEvent> registerSound(String id);


    <T extends Block> Supplier<T> registerBlockWithItem(String id, java.util.function.Supplier<T> blockSupplier);

    <T extends Block> Supplier<T> registerBlock(String id, java.util.function.Supplier<T> blockSupplier);

    <T extends Item> Supplier<T> registerItem(String id, java.util.function.Supplier<T> itemSupplier);

    <T extends EntityType<?>> Supplier<T> registerEntityType(String id, java.util.function.Supplier<T> entitySupplier);

    <T extends BlockEntityType<?>> Supplier<T> registerBlockEntityType(String id, java.util.function.Supplier<T> blockEntitySupplier);

    <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String id, java.util.function.Supplier<T> recipeSupplier);

    <T> Supplier<DataComponentType<T>> registerDataComponent(String id, java.util.function.Supplier<DataComponentType<T>> dataSupplier);



    Supplier<SimpleParticleType> registerParticle(String id);

}
