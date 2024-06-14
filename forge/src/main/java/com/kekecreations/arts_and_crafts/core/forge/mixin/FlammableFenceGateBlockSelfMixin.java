package com.kekecreations.arts_and_crafts.core.forge.mixin;

import com.kekecreations.arts_and_crafts.common.block.ACFlammableFenceGateBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ACFlammableFenceGateBlock.class)
public class FlammableFenceGateBlockSelfMixin extends FenceGateBlock {


    public FlammableFenceGateBlockSelfMixin(Properties p_273352_, WoodType p_273340_) {
        super(p_273352_, p_273340_);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }
    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 20;
    }
}
