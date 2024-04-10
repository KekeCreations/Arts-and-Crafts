package com.kekecreations.arts_and_crafts.common.block;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.common.item.ChalkStickItem;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockStateProperties;
import com.kekecreations.arts_and_crafts.common.util.ChalkUtils;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ChalkDustBlock extends MultifaceBlock {

    private static final Map<DyeColor, ChalkDustBlock> BLOCK_BY_COLOR = Maps.newEnumMap(DyeColor.class);
    private final DyeColor dyeColor;
    private static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION;

    public static final int MAX_STATE = 32;

    public static final IntegerProperty CHALK_DUST_STATES = KekeBlockStateProperties.CHALK_PATTERN;

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    public ChalkDustBlock(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getChalkDustProperty(), 0));
        this.registerDefaultState(ChalkDustBlock.getDefaultDirectionState(this.stateDefinition));
        this.dyeColor = dyeColor;
        BLOCK_BY_COLOR.put(dyeColor, this);
    }

    protected IntegerProperty getChalkDustProperty() {
        return CHALK_DUST_STATES;
    }

    public int getMaxState() {
        return MAX_STATE;
    }

    public int getChalkDustStates(BlockState blockState) {
        return blockState.getValue(this.getChalkDustProperty());
    }
    public final boolean isMaxState(BlockState blockState) {
        return this.getChalkDustStates(blockState) >= this.getMaxState();
    }

    @Override
    public InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        RandomSource random = level.getRandom();
        if (player.isCrouching() && player.getItemInHand(interactionHand).isEmpty()) {
            ChalkUtils.spawnChalkParticle(level, blockPos.getX() + 0.5D, blockPos.getY() + 0.2D, blockPos.getZ() + 0.5D, getDyeColor());
            level.setBlockAndUpdate(blockPos, ChalkUtils.changeChalkDustState(blockState, player, 1));
            level.playSound(player, blockPos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.2F + 0.9F);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        ItemStack itemStack = new ItemStack(KekeItems.getChalkStick(this.dyeColor.getId()));
        if (itemStack.getItem() instanceof ChalkStickItem chalkStickItem) {
            chalkStickItem.setChalkPattern(itemStack, getChalkDustStates(blockState));
        }
        return itemStack;
    }


    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
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
}
