package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class DyedFlowerPotBlockItem extends BlockItem {
    public DyedFlowerPotBlockItem(Block $$0, Properties $$1) {
        super($$0, $$1);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.CONFIG.areDyedFlowerPotsEnabled();
    }
}
