package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.common.misc.ACBlockStateProperties;
import com.kekecreations.arts_and_crafts.core.registry.ACParticles;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ChalkUtils {

    public static int getChalkPatternFromChalkDust(BlockState blockState) {
        return blockState.getValue(ACBlockStateProperties.CHALK_PATTERN);
    }

    public static void spawnChalkParticle(Level level, double x, double y, double z, Integer colours) {
        level.addParticle(ACParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        level.addParticle(ACParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        level.addParticle(ACParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        level.addParticle(ACParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
    }

    public static BlockState changeChalkDustState(BlockState blockState, Player player, int k) {
        if (blockState.getBlock() instanceof ChalkDustBlock chalkDust) {
            if (!player.isCrouching()) {
                if (chalkDust.isMaxState(blockState)) {
                    return blockState.setValue(ACBlockStateProperties.CHALK_PATTERN, 0)
                            .setValue(BlockStateProperties.FACING, blockState.getValue(BlockStateProperties.FACING));
                } else {
                    return blockState.setValue(ACBlockStateProperties.CHALK_PATTERN, chalkDust.getChalkDustStates(blockState) + (k))
                            .setValue(BlockStateProperties.FACING, blockState.getValue(BlockStateProperties.FACING));
                }
            } else {
                if (chalkDust.getChalkDustStates(blockState) != 0) {
                    return blockState.setValue(ACBlockStateProperties.CHALK_PATTERN, chalkDust.getChalkDustStates(blockState) - (k))
                            .setValue(BlockStateProperties.FACING, blockState.getValue(BlockStateProperties.FACING));
                } else {
                    return blockState.setValue(ACBlockStateProperties.CHALK_PATTERN, 32)
                            .setValue(BlockStateProperties.FACING, blockState.getValue(BlockStateProperties.FACING));
                }
            }
        }
        return blockState;
    }
}
