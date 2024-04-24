package com.kekecreations.arts_and_crafts.common.block;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class CustomFlowerPotBlock extends Block {

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


    public CustomFlowerPotBlock(Block block, DyeColor dyeColor, Properties properties) {
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


    @Override
    public InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        boolean bl2;
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Item item = itemStack.getItem();
        BlockState blockState2 = Blocks.AIR.defaultBlockState();

        switch (this.colour) {
            case WHITE -> blockState2 = (item instanceof BlockItem ? WHITE_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case ORANGE -> blockState2 = (item instanceof BlockItem ? ORANGE_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case MAGENTA -> blockState2 = (item instanceof BlockItem ? MAGENTA_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case LIGHT_BLUE -> blockState2 = (item instanceof BlockItem ? LIGHT_BLUE_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case YELLOW -> blockState2 = (item instanceof BlockItem ? YELLOW_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case LIME -> blockState2 = (item instanceof BlockItem ? LIME_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case PINK -> blockState2 = (item instanceof BlockItem ? PINK_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case GRAY -> blockState2 = (item instanceof BlockItem ? GRAY_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case LIGHT_GRAY -> blockState2 = (item instanceof BlockItem ? LIGHT_GRAY_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case CYAN -> blockState2 = (item instanceof BlockItem ? CYAN_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case PURPLE -> blockState2 = (item instanceof BlockItem ? PURPLE_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case BLUE -> blockState2 = (item instanceof BlockItem ? BLUE_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case BROWN -> blockState2 = (item instanceof BlockItem ? BROWN_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case GREEN -> blockState2 = (item instanceof BlockItem ? GREEN_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case RED -> blockState2 = (item instanceof BlockItem ? RED_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
            case BLACK -> blockState2 = (item instanceof BlockItem ? BLACK_POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
        }
        boolean bl = blockState2.is(Blocks.AIR);
        if (bl != (bl2 = this.isEmpty())) {
            if (bl2) {
                level.setBlock(blockPos, blockState2, 3);
                player.awardStat(Stats.POT_FLOWER);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
            } else {
                ItemStack itemStack2 = new ItemStack(this.content);
                if (itemStack.isEmpty()) {
                    player.setItemInHand(interactionHand, itemStack2);
                } else if (!player.addItem(itemStack2)) {
                    player.drop(itemStack2, false);
                }
                level.setBlock(blockPos, KekeBlocks.getDyedFlowerPot(this.colour.getId()).defaultBlockState(), 3);
            }
            level.gameEvent((Entity)player, GameEvent.BLOCK_CHANGE, blockPos);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        if (ArtsAndCraftsCommonConfig.CAN_PAINT_FLOWER_POTS.get()) {
            for (DyeColor colours : DyeColor.values()) {
                if (colours != this.colour && itemStack.getItem() == KekeItems.getPaintBrush(colours.getId())) {
                    PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedFlowerPot(colours.getId()).defaultBlockState(), blockPos, player, itemStack, interactionHand);
                    player.swing(interactionHand);
                }
            }
        }
        return InteractionResult.CONSUME;
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
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        if (this.isEmpty()) {
            return super.getCloneItemStack(blockGetter, blockPos, blockState);
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
    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return false;
    }


}
