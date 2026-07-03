package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.item.PaintbrushItem;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;

public class ACFlowerPotBlock extends Block {

    public static final HashMap<DyeColor, HashMap<Block, Block>> POTTED_MAPS = new HashMap();

    static {
        for (DyeColor colour : DyeColor.values()) {
            POTTED_MAPS.put(colour, new HashMap<Block, Block>());
        }
    }
    private final Block content;
    private final DyeColor colour;

    public static final float AABB_SIZE = 3.0f;
    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);


    public ACFlowerPotBlock(Block block, DyeColor dyeColor, Properties properties) {
        super(properties);
        this.content = block;
        this.colour = dyeColor;
        POTTED_MAPS.get(colour).put(block, this);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.CONFIG.areDyedFlowerPotsEnabled();
    }

    private boolean isEmpty() {
        return this.content == Blocks.AIR;
    }

    public void addPotManuallyNonStatic(DyeColor colour, Block plantBlockItem, Block pottedBlock) {
        POTTED_MAPS.get(colour).put(plantBlockItem, pottedBlock);
    }

    public static void addPotManually(DyeColor colour, Block plantBlockItem, Block pottedBlock) {
        POTTED_MAPS.get(colour).put(plantBlockItem, pottedBlock);
    }


    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        Item item = itemStack.getItem();
        Block block = Blocks.AIR;

        if (item instanceof BlockItem) {
            block = POTTED_MAPS.get(this.colour).getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR);
        }
        if (!level.isClientSide()) {
            if (itemStack.getItem() instanceof PaintbrushItem) {
                Block finalBlock = PaintbrushUtils.getFinalBlock(level.registryAccess(), blockState, itemStack);
                if (finalBlock != null && finalBlock != blockState.getBlock()) {
                    PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), blockPos, player, itemStack, interactionHand);
                    return InteractionResult.SUCCESS;
                }
            }
        }

        BlockState blockState2 = block.defaultBlockState();
        if (blockState2.isAir()) {
            return InteractionResult.PASS;
        } else if (!this.isEmpty()) {
            return InteractionResult.CONSUME;
        } else {
            level.setBlock(blockPos, blockState2, 3);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
            player.awardStat(Stats.POT_FLOWER);
            itemStack.consume(1, player);
            return InteractionResult.SUCCESS;
        }
    }

    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (this.isEmpty()) {
            return InteractionResult.CONSUME;
        } else {
            ItemStack itemStack = new ItemStack(this.content);
            if (!player.addItem(itemStack)) {
                player.drop(itemStack, false);
            }

            level.setBlock(blockPos, ACBlocks.getDyedFlowerPot(this.colour.getId()).defaultBlockState(), 3);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        if (this.isEmpty()) {
            return super.getCloneItemStack(level, pos, state, includeData);
        }
        return new ItemStack(this.content);
    }

    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        return direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    public Block getContent() {
        return this.content;
    }

    @Override
    public boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }


}
