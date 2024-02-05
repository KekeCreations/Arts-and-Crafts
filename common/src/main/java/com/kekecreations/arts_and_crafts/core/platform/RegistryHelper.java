package com.kekecreations.arts_and_crafts.core.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class RegistryHelper {


    @ExpectPlatform
    public static <T extends Item> java.util.function.Supplier<T> registerItem(String id, java.util.function.Supplier<T> itemSupplier) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Block> java.util.function.Supplier<T> registerBlockWithItem(String id, java.util.function.Supplier<T> blockSupplier) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Block> java.util.function.Supplier<T> registerBlock(String id, java.util.function.Supplier<T> blockSupplier) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Supplier<SimpleParticleType> registerParticle(String id) {
        throw new AssertionError();
    }


    @ExpectPlatform
    public static <T extends Entity>Supplier<EntityType<T>> registerEntityType(String id, Supplier<EntityType<T>> entitySupplier) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends BlockEntity>Supplier<BlockEntityType<T>> registerBlockEntityType(String id, Supplier<BlockEntityType<T>> blockEntityTypeSupplier) {
        throw new AssertionError();
    }

}
