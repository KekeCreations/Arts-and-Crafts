package com.kekecreations.arts_and_crafts.core.platform.fabric;

import com.kekecreations.arts_and_crafts.core.platform.PlatformHelper;
import com.kekecreations.arts_and_crafts.core.fabric.registry.KekeFabricBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PlatformHelperImpl {

    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntity(PlatformHelper.BlockEntitySupplier<T> blockEntitySupplier, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(blockEntitySupplier::create, blocks).build();
    }

    public static Block corkPlanks() {
        return KekeFabricBlocks.CORK_PLANKS.get();
    }
}
