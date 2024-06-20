package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.misc.ACBlockStateProperties;
import com.kekecreations.arts_and_crafts.core.registry.ACDataComponents;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;

public class ChalkDustBlock extends DirectionalBlock {

    private static final VoxelShape UP_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    private static final VoxelShape DOWN_AABB = Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape WEST_AABB = Block.box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape EAST_AABB = Block.box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
    private static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
    private static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);

    public static final BooleanProperty GLOW;

    private final Integer dyeColor;

    public static final int MAX_STATE = 32;

    public static final IntegerProperty CHALK_DUST_STATES = ACBlockStateProperties.CHALK_PATTERN;

    public int getDyeColor() {
        return this.dyeColor;
    }

    public ChalkDustBlock(Integer dyeColor, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getChalkDustProperty(), 0).setValue(FACING, Direction.SOUTH).setValue(GLOW, false));
        this.dyeColor = dyeColor;
    }

    protected IntegerProperty getChalkDustProperty() {
        return CHALK_DUST_STATES;
    }

    public int getMaxState() {
        return MAX_STATE;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (!level.isClientSide()) {
            if (!blockState.getValue(GLOW)) {
                if (itemStack.is(Items.GLOW_INK_SAC)) {
                    level.setBlockAndUpdate(pos, blockState.setValue(GLOW, true));
                    level.playSound(null, pos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (!player.isCreative()) {
                        itemStack.setCount(itemStack.getCount() - 1);
                    }
                    return ItemInteractionResult.sidedSuccess(true);
                }
            }
        }
        return ItemInteractionResult.FAIL;
    }

    public int getChalkDustStates(BlockState blockState) {
        return blockState.getValue(this.getChalkDustProperty());
    }
    public final boolean isMaxState(BlockState blockState) {
        return this.getChalkDustStates(blockState) >= this.getMaxState();
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull LevelReader levelReader, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        ItemStack itemStack = new ItemStack(ACItems.getChalkStick(this.dyeColor));
        if (itemStack.has(ACDataComponents.CHALK_PATTERN.get()) && Screen.hasControlDown()) {
            itemStack.set(ACDataComponents.CHALK_PATTERN.get(), getChalkDustStates(blockState));
        }
        return itemStack;
    }


    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(CHALK_DUST_STATES);
        builder.add(FACING);
        builder.add(GLOW);
    }

    @Override
    public VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Block.box(0, 0, 0, 0, 0, 0);
    }

    @Override
    public VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return getShape(state);
    }

    public static boolean canAttachTo(BlockGetter p_153830_, Direction p_153831_, BlockPos p_153832_, BlockState p_153833_) {
        return Block.isFaceFull(p_153833_.getBlockSupportShape(p_153830_, p_153832_), p_153831_.getOpposite()) || Block.isFaceFull(p_153833_.getCollisionShape(p_153830_, p_153832_), p_153831_.getOpposite());
    }

    public boolean canSurvive(BlockState state, @NotNull LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos blockpos = pos.relative(direction);
        return canAttachTo(level, direction, blockpos, level.getBlockState(blockpos));
    }

    public boolean isValidStateForPlacement(BlockGetter p_221572_, BlockState p_221573_, BlockPos p_221574_, Direction p_221575_) {
        if ((!p_221573_.is(this))) {
            BlockPos blockpos = p_221574_.relative(p_221575_);
            return canAttachTo(p_221572_, p_221575_, blockpos, p_221572_.getBlockState(blockpos));
        } else {
            return false;
        }
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


    public BlockState getStateForPlacement(BlockState blockState, BlockGetter level, BlockPos blockPos, Direction direction) {
        if (!this.isValidStateForPlacement(level, blockState, blockPos, direction) || blockState.is(this)) {
            return null;
        } else {
            return this.defaultBlockState().setValue(FACING, direction.getOpposite());
        }
    }

    public boolean canBeReplaced(BlockState p_153848_, BlockPlaceContext p_153849_) {
        return true;
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
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        return direction == state.getValue(FACING).getOpposite() && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    public static final MapCodec<ChalkDustBlock> CODEC = RecordCodecBuilder.mapCodec(($$0) -> {
        return $$0.group(Codec.INT.fieldOf("dyecolor").forGetter(($$0x) -> {
            return $$0x.dyeColor;
        }), propertiesCodec()).apply($$0, ChalkDustBlock::new);
    });

    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return CODEC;
    }


    static {
        GLOW = BooleanProperty.create("glow");
    }
}
