package com.kekecreations.arts_and_crafts.common.block;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.common.item.PaintbrushItem;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class ACFlowerPotBlock extends Block {

    private static final Map<Block, Block> WHITE_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> ORANGE_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> MAGENTA_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> LIGHT_BLUE_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> YELLOW_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> LIME_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> PINK_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> GRAY_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> LIGHT_GRAY_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> CYAN_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> PURPLE_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> BLUE_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> BROWN_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> GREEN_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> RED_POTTED_BY_CONTENT = Maps.newHashMap();
    private static final Map<Block, Block> BLACK_POTTED_BY_CONTENT = Maps.newHashMap();
    private final Block content;
    private final DyeColor colour;

    public static final float AABB_SIZE = 3.0f;
    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);


    public ACFlowerPotBlock(Block block, DyeColor dyeColor, Properties properties) {
        super(properties);
        this.content = block;
        this.colour = dyeColor;
        switch (this.colour) {
            case WHITE -> WHITE_POTTED_BY_CONTENT.put(block, this);
            case ORANGE -> ORANGE_POTTED_BY_CONTENT.put(block, this);
            case MAGENTA -> MAGENTA_POTTED_BY_CONTENT.put(block, this);
            case LIGHT_BLUE -> LIGHT_BLUE_POTTED_BY_CONTENT.put(block, this);
            case YELLOW -> YELLOW_POTTED_BY_CONTENT.put(block, this);
            case LIME -> LIME_POTTED_BY_CONTENT.put(block, this);
            case PINK -> PINK_POTTED_BY_CONTENT.put(block, this);
            case GRAY -> GRAY_POTTED_BY_CONTENT.put(block, this);
            case LIGHT_GRAY -> LIGHT_GRAY_POTTED_BY_CONTENT.put(block, this);
            case CYAN -> CYAN_POTTED_BY_CONTENT.put(block, this);
            case PURPLE -> PURPLE_POTTED_BY_CONTENT.put(block, this);
            case BLUE -> BLUE_POTTED_BY_CONTENT.put(block, this);
            case BROWN -> BROWN_POTTED_BY_CONTENT.put(block, this);
            case GREEN -> GREEN_POTTED_BY_CONTENT.put(block, this);
            case RED -> RED_POTTED_BY_CONTENT.put(block, this);
            case BLACK -> BLACK_POTTED_BY_CONTENT.put(block, this);
        }
    }

    private boolean isEmpty() {
        return this.content == Blocks.AIR;
    }


    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        Item item = itemStack.getItem();
        Block block = Blocks.AIR;
        if (item instanceof BlockItem blockItem) {
            switch (this.colour) {
                case WHITE -> block = WHITE_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case ORANGE -> block = ORANGE_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case MAGENTA -> block = MAGENTA_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case LIGHT_BLUE -> block = LIGHT_BLUE_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case YELLOW -> block = YELLOW_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case LIME -> block = LIME_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case PINK -> block = PINK_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case GRAY -> block = GRAY_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case LIGHT_GRAY -> block = LIGHT_GRAY_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case CYAN -> block = CYAN_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case PURPLE -> block = PURPLE_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case BLUE -> block = BLUE_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case BROWN -> block = BROWN_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case GREEN -> block = GREEN_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case RED -> block = RED_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
                case BLACK -> block = BLACK_POTTED_BY_CONTENT.getOrDefault(blockItem.getBlock(), Blocks.AIR);
            }
        }
        if (!level.isClientSide()) {
            if (itemStack.getItem() instanceof PaintbrushItem) {
                Block finalBlock = PaintbrushUtils.getFinalBlock(level.registryAccess(), blockState, itemStack);
                if (finalBlock != null && finalBlock != blockState.getBlock()) {
                    PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), blockPos, player, itemStack, interactionHand);
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }

        BlockState blockState2 = block.defaultBlockState();
        if (blockState2.isAir()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else if (!this.isEmpty()) {
            return ItemInteractionResult.CONSUME;
        } else {
            level.setBlock(blockPos, blockState2, 3);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
            player.awardStat(Stats.POT_FLOWER);
            itemStack.consume(1, player);
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
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

            level.setBlock(blockPos, Blocks.FLOWER_POT.defaultBlockState(), 3);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
            return InteractionResult.sidedSuccess(level.isClientSide);
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
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        if (this.isEmpty()) {
            return super.getCloneItemStack(levelReader, blockPos, blockState);
        }
        return new ItemStack(this.content);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    public Block getContent() {
        return this.content;
    }

    @Override
    public boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }


}
