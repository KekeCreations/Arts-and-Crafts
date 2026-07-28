package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;


public class FloatingBlock extends Block implements Floatable {
    public FloatingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        level.scheduleTick(blockPos, this, this.getDelayAfterPlace());
    }

    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        scheduledTickAccess.scheduleTick(pos, this, this.getDelayAfterPlace());
        return super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!FloatingBlock.isInWater(serverLevel.getBlockState(blockPos.above()))) {
            return;
        }
        FloatingBlockEntity floatingBlockEntity = FloatingBlockEntity.floating(serverLevel, blockPos, blockState);
        this.float2(floatingBlockEntity);
    }

    protected void float2(FloatingBlockEntity floatingBlockEntity) {
    }

    protected int getDelayAfterPlace() {
        return 2;
    }

    public static boolean isInWater(BlockState blockState) {
        return blockState.getFluidState().is(FluidTags.WATER) && !(blockState.getBlock() instanceof SimpleWaterloggedBlock);
    }
    public static boolean isNotInWater(BlockState blockState) {
        return !(blockState.getFluidState().is(FluidTags.WATER)) || blockState.getBlock() instanceof SimpleWaterloggedBlock;
    }
}


