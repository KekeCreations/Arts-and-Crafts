package com.kekecreations.arts_and_crafts.core.forge.platform;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.services.RegistryHelper;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.function.Supplier;

public class ForgeRegistryHelper implements RegistryHelper {


    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, ArtsAndCrafts.MOD_ID);

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<DecoratedPotPattern> DECORATED_POT_PATTERNS = DeferredRegister.create(Registries.DECORATED_POT_PATTERN, ArtsAndCrafts.MOD_ID);

    public Supplier<SoundEvent> registerSound(String id) {
        return SOUNDS.register(id, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, id)));
    }


    @Override
    public <T extends Block> Supplier<T> registerBlockWithItem(String id, Supplier<T> blockSupplier) {
        var block = BLOCKS.register(id, blockSupplier);
        ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> blockSupplier) {
        return BLOCKS.register(id, blockSupplier);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> itemSupplier) {
        return ITEMS.register(id, itemSupplier);
    }

    @Override
    public Supplier<DecoratedPotPattern> registerDecoratedPotPattern(String id, Supplier<DecoratedPotPattern> decoratedPotPatternSupplier) {
        return DECORATED_POT_PATTERNS.register(id, decoratedPotPatternSupplier);
    }

    @Override
    public <T extends EntityType<?>> Supplier<T> registerEntityType(String id, Supplier<T> itemSupplier) {
        return ENTITY_TYPES.register(id, itemSupplier);
    }
    @Override
    public <T extends BlockEntityType<?>> Supplier<T> registerBlockEntityType(String id, Supplier<T> itemSupplier) {
        return BLOCK_ENTITY_TYPES.register(id, itemSupplier);
    }
    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String id, Supplier<T> itemSupplier) {
        return RECIPE_SERIALIZER.register(id, itemSupplier);
    }

    @Override
    public <T> Supplier<DataComponentType<T>> registerDataComponent(String id, Supplier<DataComponentType<T>> dataSupplier) {
        return DATA_COMPONENT_TYPES.register(id, dataSupplier);
    }

    @Override
    public Supplier<SimpleParticleType> registerParticle(String id) {
        return PARTICLE_TYPES.register(id, () -> new SimpleParticleType(false));
    }
}
