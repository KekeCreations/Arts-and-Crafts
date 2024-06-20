package com.kekecreations.arts_and_crafts.core.neoforge.core.mixin;

import com.kekecreations.arts_and_crafts.common.block.ACFlammableSlabBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ACFlammableSlabBlock.class)
public class FlammableSlabBlockSelfMixin extends SlabBlock {

    public FlammableSlabBlockSelfMixin(Properties p_49795_) {
        super(p_49795_);
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
