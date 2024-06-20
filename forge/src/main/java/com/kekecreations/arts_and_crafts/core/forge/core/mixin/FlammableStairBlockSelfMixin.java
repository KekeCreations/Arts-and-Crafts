package com.kekecreations.arts_and_crafts.core.forge.core.mixin;

import com.kekecreations.arts_and_crafts.common.block.ACFlammableStairBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ACFlammableStairBlock.class)
public class FlammableStairBlockSelfMixin extends StairBlock {


    public FlammableStairBlockSelfMixin(BlockState p_56862_, Properties p_56863_) {
        super(p_56862_, p_56863_);
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
