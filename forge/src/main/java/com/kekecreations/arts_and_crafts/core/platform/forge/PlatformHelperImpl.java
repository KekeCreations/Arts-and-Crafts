package com.kekecreations.arts_and_crafts.core.platform.forge;

import com.kekecreations.arts_and_crafts.core.platform.PlatformHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class PlatformHelperImpl {

    public static <T extends BlockEntity> BlockEntityType<T> createBlockEntity(PlatformHelper.BlockEntitySupplier<T> blockEntitySupplier, Block... blocks) {
        return BlockEntityType.Builder.of(blockEntitySupplier::create, blocks).build(null);
    }
}
