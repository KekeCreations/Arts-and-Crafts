package com.kekecreations.arts_and_crafts.core.platform.services;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface RegistryHelper {

    <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> entry);

    Supplier<SoundEvent> registerSound(String id);


    <T extends Block> Supplier<T> registerBlockWithItem(String id, java.util.function.Supplier<T> blockSupplier);

    <T extends Block> Supplier<T> registerBlock(String id, java.util.function.Supplier<T> blockSupplier);



    Supplier<SimpleParticleType> registerParticle(String id);


}
