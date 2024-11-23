package com.kekecreations.arts_and_crafts.fabric.core.platform;

import com.kekecreations.arts_and_crafts.core.platform.services.PlatformHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;


public class FabricPlatformHelper implements PlatformHelper {

    @Override
    public String getPlatformName() {
        return "fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public String getEnvironmentName() {
        return PlatformHelper.super.getEnvironmentName();
    }

    @Override
    public <T extends BlockEntity> BlockEntityType<T> createBlockEntity(PlatformHelper.BlockEntitySupplier<T> blockEntitySupplier, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(blockEntitySupplier::create, blocks).build();
    }

}
