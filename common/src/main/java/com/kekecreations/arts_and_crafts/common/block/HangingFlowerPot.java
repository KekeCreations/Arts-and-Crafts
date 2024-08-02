package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.misc.ACBlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class HangingFlowerPot extends Block {

    public static final BooleanProperty PLANK;

    public static final DirectionProperty FACING;


    public HangingFlowerPot(Properties $$0) {
        super($$0);
        this.registerDefaultState(this.stateDefinition.any().setValue(PLANK, true).setValue(FACING, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(PLANK);
        blockStateBuilder.add(FACING);
    }

    static {
        PLANK = ACBlockStateProperties.PLANK;
        FACING = BlockStateProperties.HORIZONTAL_FACING;
    }
}
