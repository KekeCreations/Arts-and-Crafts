package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockStateProperties;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ChalkUtils {

    public static int getChalkPatternFromChalkDust(BlockState blockState) {
        return blockState.getValue(KekeBlockStateProperties.CHALK_DUST_23);
    }

    public static void spawnChalkParticle(Level level, double x, double y, double z, DyeColor colours) {
        level.addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        level.addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        level.addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        level.addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
    }

    public static BlockState changeChalkDustState(BlockState blockState, Player player, int k) {
        if (blockState.getBlock() instanceof ChalkDustBlock chalkDust) {
            if (!player.isCrouching()) {
                if (chalkDust.isMaxState(blockState)) {
                    return blockState.setValue(KekeBlockStateProperties.CHALK_DUST_23, 0)
                            .setValue(BlockStateProperties.UP, blockState.getValue(BlockStateProperties.UP))
                            .setValue(BlockStateProperties.DOWN, blockState.getValue(BlockStateProperties.DOWN))
                            .setValue(BlockStateProperties.WEST, blockState.getValue(BlockStateProperties.WEST))
                            .setValue(BlockStateProperties.EAST, blockState.getValue(BlockStateProperties.EAST))
                            .setValue(BlockStateProperties.NORTH, blockState.getValue(BlockStateProperties.NORTH))
                            .setValue(BlockStateProperties.SOUTH, blockState.getValue(BlockStateProperties.SOUTH));
                } else {
                    return blockState.setValue(KekeBlockStateProperties.CHALK_DUST_23, chalkDust.getChalkDustStates(blockState) + (k))
                            .setValue(BlockStateProperties.UP, blockState.getValue(BlockStateProperties.UP))
                            .setValue(BlockStateProperties.DOWN, blockState.getValue(BlockStateProperties.DOWN))
                            .setValue(BlockStateProperties.WEST, blockState.getValue(BlockStateProperties.WEST))
                            .setValue(BlockStateProperties.EAST, blockState.getValue(BlockStateProperties.EAST))
                            .setValue(BlockStateProperties.NORTH, blockState.getValue(BlockStateProperties.NORTH))
                            .setValue(BlockStateProperties.SOUTH, blockState.getValue(BlockStateProperties.SOUTH));
                }
            } else {
                if (chalkDust.getChalkDustStates(blockState) != 0) {
                    return blockState.setValue(KekeBlockStateProperties.CHALK_DUST_23, chalkDust.getChalkDustStates(blockState) - (k))
                            .setValue(BlockStateProperties.UP, blockState.getValue(BlockStateProperties.UP))
                            .setValue(BlockStateProperties.DOWN, blockState.getValue(BlockStateProperties.DOWN))
                            .setValue(BlockStateProperties.WEST, blockState.getValue(BlockStateProperties.WEST))
                            .setValue(BlockStateProperties.EAST, blockState.getValue(BlockStateProperties.EAST))
                            .setValue(BlockStateProperties.NORTH, blockState.getValue(BlockStateProperties.NORTH))
                            .setValue(BlockStateProperties.SOUTH, blockState.getValue(BlockStateProperties.SOUTH));
                } else {
                    return blockState.setValue(KekeBlockStateProperties.CHALK_DUST_23, 23)
                            .setValue(BlockStateProperties.UP, blockState.getValue(BlockStateProperties.UP))
                            .setValue(BlockStateProperties.DOWN, blockState.getValue(BlockStateProperties.DOWN))
                            .setValue(BlockStateProperties.WEST, blockState.getValue(BlockStateProperties.WEST))
                            .setValue(BlockStateProperties.EAST, blockState.getValue(BlockStateProperties.EAST))
                            .setValue(BlockStateProperties.NORTH, blockState.getValue(BlockStateProperties.NORTH))
                            .setValue(BlockStateProperties.SOUTH, blockState.getValue(BlockStateProperties.SOUTH));
                }
            }
        }
        return blockState;
    }
}
