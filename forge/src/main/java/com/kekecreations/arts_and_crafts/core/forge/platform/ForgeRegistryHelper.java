package com.kekecreations.arts_and_crafts.core.forge.platform;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.services.RegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ForgeRegistryHelper implements RegistryHelper {

    private static final RegistryMap registryMap = new RegistryMap();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArtsAndCrafts.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ArtsAndCrafts.MOD_ID);


    @Override
    public <T> Supplier<T> register(Registry<? super T> registry, String name, Supplier<T> entry) {
        return registryMap.register(registry, name, entry);
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
    public Supplier<SimpleParticleType> registerParticle(String id) {
        return PARTICLE_TYPES.register(id, () -> new SimpleParticleType(false));
    }



    private static class RegistryMap {

        private final Map<ResourceLocation, DeferredRegister<?>> registries = new HashMap<>();

        @SuppressWarnings({"unchecked", "rawtypes"})
        private <T> RegistryObject<T> register(Registry<? super T> registry, String name, Supplier<T> entry) {
            DeferredRegister<T> reg = (DeferredRegister<T>)registries.computeIfAbsent(registry.key().location(), (key) -> {
                ForgeRegistry forgeReg = RegistryManager.ACTIVE.getRegistry(key);

                if(forgeReg == null)
                    return null;

                DeferredRegister<T> defReg = DeferredRegister.create(forgeReg, ArtsAndCrafts.MOD_ID);
                defReg.register(FMLJavaModLoadingContext.get().getModEventBus());

                return defReg;
            });

            return reg != null ? reg.register(name, entry) : null;
        }

    }

}
