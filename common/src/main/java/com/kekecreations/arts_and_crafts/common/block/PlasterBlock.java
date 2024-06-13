package com.kekecreations.arts_and_crafts.common.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;

public class PlasterBlock extends DirectionalBlock implements SimpleWaterloggedBlock {

    private final DyeColor dyeColor;

    public static final BooleanProperty WATERLOGGED;

    private static final VoxelShape DOWN_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0);
    private static final VoxelShape UP_AABB = Block.box(0.0, 12.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape EAST_AABB = Block.box(12.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape WEST_AABB = Block.box(0.0, 0.0, 0.0, 4.0, 16.0, 16.0);
    private static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 12.0, 16.0, 16.0, 16.0);
    private static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 4.0);

    public PlasterBlock(DyeColor dyeColor, Properties $$0) {
        super($$0);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.SOUTH).setValue(WATERLOGGED, false));
        this.dyeColor = dyeColor;
    }

    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, WATERLOGGED);
    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }


    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos blockpos = blockPlaceContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        return Arrays.stream(blockPlaceContext.getNearestLookingDirections()).map((p_153865_) -> {
            return this.getStateForPlacement(blockstate, level, blockpos, p_153865_);
        }).filter(Objects::nonNull).findFirst().orElse((BlockState) null);
    }

    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getShape(state);
    }

    public VoxelShape getShape(BlockState state) {
        Direction direction = state.getValue(FACING);
        return switch (direction) {
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            case EAST -> EAST_AABB;
            case WEST -> WEST_AABB;
            case DOWN -> DOWN_AABB;
            case UP -> UP_AABB;
        };
    }

    public BlockState getStateForPlacement(BlockState blockState, BlockGetter level, BlockPos blockPos, Direction direction) {
        FluidState $$3 = level.getFluidState(blockPos);
        return this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, $$3.getType() == Fluids.WATER);
    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }

    public static final MapCodec<PlasterBlock> CODEC = RecordCodecBuilder.mapCodec(($$0) -> {
        return $$0.group(DyeColor.CODEC.fieldOf("dyecolor").forGetter(($$0x) -> {
            return $$0x.dyeColor;
        }), propertiesCodec()).apply($$0, PlasterBlock::new);
    });

    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return CODEC;
    }
}
