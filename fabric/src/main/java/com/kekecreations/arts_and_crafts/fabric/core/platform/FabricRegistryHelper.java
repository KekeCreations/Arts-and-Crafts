package com.kekecreations.arts_and_crafts.fabric.core.platform;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.services.RegistryHelper;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class FabricRegistryHelper implements RegistryHelper {

    @Override
    public <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> entry) {
        T value = entry.get();
        Registry.register(registry, ArtsAndCrafts.id(name), value);
        return () -> value;
    }

    public Supplier<SoundEvent> registerSound(String id) {
        var location = new ResourceLocation(ArtsAndCrafts.MOD_ID, id);
        var soundEvent = Registry.register(BuiltInRegistries.SOUND_EVENT, location, SoundEvent.createVariableRangeEvent(location));
        return () -> soundEvent;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlockWithItem(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), blockSupplier.get());
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), new BlockItem(block, new Item.Properties()));
        return () -> block;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> blockSupplier) {
        var block = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), blockSupplier.get());
        return () -> block;
    }

    @Override
    public Supplier<SimpleParticleType> registerParticle(String id) {
        var particleType = Registry.register(BuiltInRegistries.PARTICLE_TYPE, new ResourceLocation(ArtsAndCrafts.MOD_ID, id), FabricParticleTypes.simple());
        return () -> particleType;
    }
}
