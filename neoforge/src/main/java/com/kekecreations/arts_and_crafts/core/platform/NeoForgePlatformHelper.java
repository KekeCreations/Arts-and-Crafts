package com.kekecreations.arts_and_crafts.core.platform;

import com.kekecreations.arts_and_crafts.core.platform.services.IPlatformHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public <T extends BlockEntity> BlockEntityType<T> createBlockEntity(BlockEntitySupplier<T> blockEntitySupplier, Block... blocks) {
        return new BlockEntityType<>(blockEntitySupplier::create, blocks);
    }
}