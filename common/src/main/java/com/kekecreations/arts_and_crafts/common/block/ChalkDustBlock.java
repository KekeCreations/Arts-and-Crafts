package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.core.misc.KekeBlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ChalkDustBlock extends MultifaceBlock {
    private static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION;

    public static final int MAX_STATE = 23;

    public static final IntegerProperty CHALK_DUST_STATES = KekeBlockStateProperties.CHALK_DUST_23;

    public ChalkDustBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(this.getChalkDustProperty(), 0));
        this.registerDefaultState(ChalkDustBlock.getDefaultDirectionState(this.stateDefinition));
    }

    protected IntegerProperty getChalkDustProperty() {
        return CHALK_DUST_STATES;
    }

    public int getMaxState() {
        return 23;
    }

    public int getChalkDustStates(BlockState blockState) {
        return blockState.getValue(this.getChalkDustProperty());
    }
    public BlockState getStateForDust(int i) {
        return this.defaultBlockState().setValue(this.getChalkDustProperty(), i);
    }
    public final boolean isMaxState(BlockState blockState) {
        return this.getChalkDustStates(blockState) >= this.getMaxState();
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(CHALK_DUST_STATES);
    }

    @Nullable
    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }

    private static BlockState getDefaultDirectionState(StateDefinition<Block, BlockState> stateDefinition) {
        BlockState blockState = stateDefinition.any();
        for (BooleanProperty booleanProperty : PROPERTY_BY_DIRECTION.values()) {
            if (!blockState.hasProperty(booleanProperty)) continue;
            blockState = (BlockState)blockState.setValue(booleanProperty, false);
        }
        return blockState;
    }

    public BlockState changeState(BlockState blockState, Player player, int k) {
        if (this.isMaxState(blockState) && !player.isCrouching()) {
            return blockState.setValue(CHALK_DUST_STATES, 0)
                    .setValue(BlockStateProperties.UP, blockState.getValue(BlockStateProperties.UP))
                    .setValue(BlockStateProperties.DOWN, blockState.getValue(BlockStateProperties.DOWN))
                    .setValue(BlockStateProperties.WEST, blockState.getValue(BlockStateProperties.WEST))
                    .setValue(BlockStateProperties.EAST, blockState.getValue(BlockStateProperties.EAST))
                    .setValue(BlockStateProperties.NORTH, blockState.getValue(BlockStateProperties.NORTH))
                    .setValue(BlockStateProperties.SOUTH, blockState.getValue(BlockStateProperties.SOUTH));
        }
        if (this.getChalkDustStates(blockState) == 0 && player.isCrouching()) {
            return blockState.setValue(CHALK_DUST_STATES, 23)
                    .setValue(BlockStateProperties.UP, blockState.getValue(BlockStateProperties.UP))
                    .setValue(BlockStateProperties.DOWN, blockState.getValue(BlockStateProperties.DOWN))
                    .setValue(BlockStateProperties.WEST, blockState.getValue(BlockStateProperties.WEST))
                    .setValue(BlockStateProperties.EAST, blockState.getValue(BlockStateProperties.EAST))
                    .setValue(BlockStateProperties.NORTH, blockState.getValue(BlockStateProperties.NORTH))
                    .setValue(BlockStateProperties.SOUTH, blockState.getValue(BlockStateProperties.SOUTH));
        } else {
            return blockState.setValue(CHALK_DUST_STATES, this.getChalkDustStates(blockState) + (k))
                    .setValue(BlockStateProperties.UP, blockState.getValue(BlockStateProperties.UP))
                    .setValue(BlockStateProperties.DOWN, blockState.getValue(BlockStateProperties.DOWN))
                    .setValue(BlockStateProperties.WEST, blockState.getValue(BlockStateProperties.WEST))
                    .setValue(BlockStateProperties.EAST, blockState.getValue(BlockStateProperties.EAST))
                    .setValue(BlockStateProperties.NORTH, blockState.getValue(BlockStateProperties.NORTH))
                    .setValue(BlockStateProperties.SOUTH, blockState.getValue(BlockStateProperties.SOUTH));
        }
    }
}
