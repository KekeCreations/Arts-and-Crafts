package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.item.PaintbrushItem;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
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

    public void addPotManuallyNonStatic(DyeColor colour, Block plantBlockItem, Block pottedBlock) {
        POTTED_MAPS.get(colour).put(plantBlockItem, pottedBlock);
    }

    public static void addPotManually(DyeColor colour, Block plantBlockItem, Block pottedBlock) {
        POTTED_MAPS.get(colour).put(plantBlockItem, pottedBlock);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.CONFIG.areDyedFlowerPotsEnabled();
    }

    private boolean isEmpty() {
        return this.content == Blocks.AIR;
    }


    @Override
    public InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        boolean bl2;
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Item item = itemStack.getItem();
        BlockState blockState2 = (item instanceof BlockItem ? POTTED_MAPS.get(this.colour).getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();

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
                level.setBlock(blockPos, ACBlocks.getDyedFlowerPot(this.colour.getId()).defaultBlockState(), 3);
            }
            level.gameEvent((Entity)player, GameEvent.BLOCK_CHANGE, blockPos);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        if (!level.isClientSide()) {
            if (itemStack.getItem() instanceof PaintbrushItem) {
                if (player.isCrouching()) {
                    Block finalBlock = PaintbrushUtils.getFinalBlock(level.registryAccess(), blockState, itemStack);
                    if (finalBlock != null && finalBlock != blockState.getBlock()) {
                        PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), blockPos, player, itemStack, interactionHand);
                        return InteractionResult.SUCCESS;
                    }
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
