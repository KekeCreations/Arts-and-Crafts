package com.kekecreations.arts_and_crafts.core.fabric.platform;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.services.RegistryHelper;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

import java.util.function.Supplier;

public class FabricRegistryHelper implements RegistryHelper {

    @Override
    public Supplier<SoundEvent> registerSound(String id) {
        var location = ArtsAndCrafts.id(id);
        var soundEvent = Registry.register(BuiltInRegistries.SOUND_EVENT, location, SoundEvent.createVariableRangeEvent(location));
        return () -> soundEvent;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlockWithItem(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, ArtsAndCrafts.id(id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, ArtsAndCrafts.id(id), new BlockItem(block, new Item.Properties()));
        return () -> block;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, ArtsAndCrafts.id(id), blockSupplier.get());
        return () -> block;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> itemSupplier) {
        var item = Registry.register(BuiltInRegistries.ITEM, ArtsAndCrafts.id(id), itemSupplier.get());
        return () -> item;
    }

    @Override
    public Supplier<DecoratedPotPattern> registerDecoratedPotPattern(String id, Supplier<DecoratedPotPattern> decoratedPotPatternSupplier) {
        var decoratedPotPattern = Registry.register(BuiltInRegistries.DECORATED_POT_PATTERN, ArtsAndCrafts.id(id), decoratedPotPatternSupplier.get());
        return () -> decoratedPotPattern;
    }

    @Override
    public <T extends EntityType<?>> Supplier<T> registerEntityType(String id, Supplier<T> entitySupplier) {
        var entityType = Registry.register(BuiltInRegistries.ENTITY_TYPE, ArtsAndCrafts.id(id), entitySupplier.get());
        return () -> entityType;
    }

    @Override
    public <T extends BlockEntityType<?>> Supplier<T> registerBlockEntityType(String id, Supplier<T> blockEntitySupplier) {
        var blockEntityType = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ArtsAndCrafts.id(id), blockEntitySupplier.get());
        return () -> blockEntityType;
    }

    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String id, Supplier<T> recipeSupplier) {
        var recipeSerializer = Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ArtsAndCrafts.id(id), recipeSupplier.get());
        return () -> recipeSerializer;
    }

    @Override
    public <T> Supplier<DataComponentType<T>> registerDataComponent(String id, Supplier<DataComponentType<T>> dataSupplier) {
        var dataComponent = Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, ArtsAndCrafts.id(id), dataSupplier.get());
        return () -> dataComponent;
    }

    @Override
    public Supplier<SimpleParticleType> registerParticle(String id) {
        var particleType = Registry.register(BuiltInRegistries.PARTICLE_TYPE, ArtsAndCrafts.id(id), FabricParticleTypes.simple());
        return () -> particleType;
    }
}
