package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface Floatable {
    default public void onLand(Level level, BlockPos blockPos, BlockState blockState, BlockState blockState2, FloatingBlockEntity floatingBlockEntity) {
    }

    default public void onBrokenAfterFall(Level level, BlockPos blockPos, FloatingBlockEntity floatingBlockEntity) {
    }

    default public DamageSource getFallDamageSource(Entity entity) {
        return entity.damageSources().fallingBlock(entity);
    }
}
