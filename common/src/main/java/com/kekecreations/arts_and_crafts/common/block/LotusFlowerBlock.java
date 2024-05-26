package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class LotusFlowerBlock extends WaterlilyBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty SHEARED;

    public LotusFlowerBlock(Properties $$0) {
        super($$0);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), 0).setValue(FACING, Direction.NORTH).setValue(SHEARED, false));
    }

    protected IntegerProperty getAgeProperty() {
        return AGE;
    }
    public int getMaxAge() {
        return 3;
    }

    public int getAge(BlockState p_52306_) {
        return p_52306_.getValue(this.getAgeProperty());
    }

    public BlockState getStateForAge(int $$0) {
        return (BlockState)this.defaultBlockState().setValue(this.getAgeProperty(), $$0);
    }

    public final boolean isMaxAge(BlockState $$0) {
        return this.getAge($$0) >= this.getMaxAge();
    }

    protected static float getGrowthSpeed(ServerLevel level) {
        float growthSpeed = 0.5F;

        if (level.getDayTime() >= 13000 && level.getDayTime() <= 23000) {
            growthSpeed = 1.0F;
        }
        return growthSpeed;
    }

    public void randomTick(BlockState $$0, ServerLevel $$1, BlockPos $$2, RandomSource $$3) {
        if (!$$0.getValue(SHEARED)) {
            int $$4 = this.getAge($$0);
            if ($$4 < this.getMaxAge()) {
                float $$5 = getGrowthSpeed($$1);
                if ($$3.nextInt((int) (25.0F / $$5) + 1) == 0) {
                    $$1.setBlock($$2, this.getStateForAge($$4 + 1), 2);
                }
            }
        }
    }
    protected int getBonemealAgeIncrease(Level $$0) {
        return Mth.nextInt($$0.random, 1, 2);
    }
    public void growCrops(Level $$0, BlockPos $$1, BlockState $$2) {
        int $$3 = this.getAge($$2) + this.getBonemealAgeIncrease($$0);
        int $$4 = this.getMaxAge();
        if ($$3 > $$4) {
            $$3 = $$4;
        }

        $$0.setBlock($$1, this.getStateForAge($$3).setValue(FACING, $$2.getValue(FACING)), 2);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return !blockState.getValue(SHEARED) && !isMaxAge(blockState);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return !blockState.getValue(SHEARED) && !isMaxAge(blockState);
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        this.growCrops(serverLevel, blockPos, blockState);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!level.isClientSide()) {
            if (itemStack.is(Items.SHEARS)) {
                BlockState blockStateToPlace = KekeBlocks.LOTUS_FLOWER.get().defaultBlockState();
                level.setBlockAndUpdate(blockPos, blockStateToPlace.setValue(SHEARED, true).setValue(BlockStateProperties.AGE_3, blockState.getValue(BlockStateProperties.AGE_3)).setValue(BlockStateProperties.HORIZONTAL_FACING, blockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
                if (!player.getAbilities().instabuild) {
                    itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(interactionHand));
                }
                return InteractionResult.SUCCESS;
            }
            else if (itemStack.isEmpty()) {
                if (isMaxAge(blockState) && !blockState.getValue(SHEARED)) {
                    //LOOT
                    ItemStack bleachdew = KekeItems.BLEACHDEW.get().getDefaultInstance();
                    ItemStack lotusPistils = KekeItems.LOTUS_PISTILS.get().getDefaultInstance();
                    bleachdew.setCount(Mth.nextInt(level.random, 1, 2));
                    lotusPistils.setCount(Mth.nextInt(level.random, 0, 2));
                    ItemEntity bleachdewItemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY() + 0.3F, blockPos.getZ(), bleachdew);
                    ItemEntity lotusPistilsItemEntity = new ItemEntity(level, blockPos.getX(), blockPos.getY() + 0.3F, blockPos.getZ(), lotusPistils);
                    level.addFreshEntity(bleachdewItemEntity);
                    level.addFreshEntity(lotusPistilsItemEntity);
                    //SET CROP BACK TO 1
                    BlockState blockStateToPlace = KekeBlocks.LOTUS_FLOWER.get().defaultBlockState();
                    level.setBlockAndUpdate(blockPos, blockStateToPlace.setValue(SHEARED, blockState.getValue(SHEARED)).setValue(BlockStateProperties.AGE_3, 1).setValue(BlockStateProperties.HORIZONTAL_FACING, blockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.FAIL;
    }

    public ItemStack getCloneItemStack(BlockGetter $$0, BlockPos $$1, BlockState $$2) {
        return KekeItems.LOTUS_PISTILS.get().getDefaultInstance();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(SHEARED, false).setValue(AGE, 0).setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(AGE);
        blockStateBuilder.add(FACING);
        blockStateBuilder.add(SHEARED);
    }
    static {
        SHEARED = BooleanProperty.create("sheared");
    }
}
