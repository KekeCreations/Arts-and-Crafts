package com.kekecreations.arts_and_crafts.core.forge.mixin;

import com.kekecreations.arts_and_crafts.common.block.FlammableLeavesBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(FlammableLeavesBlock.class)
public class FlammableLeavesBlockSelfMixin extends LeavesBlock  {

    public FlammableLeavesBlockSelfMixin(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }
    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 30;
    }
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 60;
    }
}
