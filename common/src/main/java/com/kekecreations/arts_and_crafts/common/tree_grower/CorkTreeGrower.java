package com.kekecreations.arts_and_crafts.common.tree_grower;

import com.kekecreations.arts_and_crafts.core.registry.KekeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CorkTreeGrower extends AbstractTreeGrower {
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean bl) {
        return KekeFeatures.TreeFeatures.CORK_TREE;
    }
}