package com.kekecreations.arts_and_crafts.core.platform.services;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

import java.util.function.Supplier;

public interface RegistryHelper {
    Supplier<SoundEvent> registerSound(String id);

    <T extends Block> Supplier<T> registerBlockWithItem(String id, Supplier<T> blockSupplier);

    <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> blockSupplier);

    <T extends Item> Supplier<T> registerItem(String id, Supplier<T> itemSupplier);

    Supplier<DecoratedPotPattern> registerDecoratedPotPattern(String id, Supplier<DecoratedPotPattern> decoratedPotPatternSupplier);

    <T extends EntityType<?>> Supplier<T> registerEntityType(String id, Supplier<T> entitySupplier);

    <T extends BlockEntityType<?>> Supplier<T> registerBlockEntityType(String id, Supplier<T> blockEntitySupplier);

    <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String id, Supplier<T> recipeSupplier);

    <T> Supplier<DataComponentType<T>> registerDataComponent(String id, Supplier<DataComponentType<T>> dataSupplier);

    Supplier<SimpleParticleType> registerParticle(String id);
}
