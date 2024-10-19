package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class DyedDecoratedPotBlockItem extends BlockItem {
    public DyedDecoratedPotBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.CONFIG.areDyedDecoratedPotsEnabled();
    }
}
