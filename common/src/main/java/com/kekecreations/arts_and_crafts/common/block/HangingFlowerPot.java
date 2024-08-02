package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.misc.ACBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingFlowerPot extends Block {

    public static final BooleanProperty PLANK;

    public static final DirectionProperty FACING;

    private static final VoxelShape FLOWER_POT_SHAPE = Block.box(3.0, 1.0, 3.0, 13.0, 6.0, 13.0);
    private static final VoxelShape PLANK_SHAPE_EAST_AND_WEST = Block.box(7.0, 14.0, 0.0, 9.0, 16.0, 16.0);
    private static final VoxelShape PLANK_SHAPE_NORTH_AND_SOUTH = Block.box(0.0, 14.0, 7.0, 16.0, 16.0, 9.0);
    private static final VoxelShape AABB_EAST_AND_WEST;
    private static final VoxelShape AABB_NORTH_AND_SOUTH;

    public HangingFlowerPot(Properties $$0) {
        super($$0);
        this.registerDefaultState(this.stateDefinition.any().setValue(PLANK, true).setValue(FACING, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(PLANK);
        blockStateBuilder.add(FACING);
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter $$1, BlockPos $$2, CollisionContext $$3) {
        if (blockState.getValue(ACBlockStateProperties.PLANK)) {
            if (blockState.getValue(FACING) == Direction.EAST || blockState.getValue(FACING) == Direction.WEST) {
                return AABB_EAST_AND_WEST;
            }
            if (blockState.getValue(FACING) == Direction.NORTH || blockState.getValue(FACING) == Direction.SOUTH) {
                return AABB_NORTH_AND_SOUTH;
            }
        }
        return FLOWER_POT_SHAPE;
    }

    static {
        PLANK = ACBlockStateProperties.PLANK;
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        AABB_EAST_AND_WEST = Shapes.or(PLANK_SHAPE_EAST_AND_WEST, new VoxelShape[]{FLOWER_POT_SHAPE});
        AABB_NORTH_AND_SOUTH = Shapes.or(PLANK_SHAPE_NORTH_AND_SOUTH, new VoxelShape[]{FLOWER_POT_SHAPE});
    }
}
