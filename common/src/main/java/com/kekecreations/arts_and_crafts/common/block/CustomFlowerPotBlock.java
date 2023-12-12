package com.kekecreations.arts_and_crafts.common.block;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.common.block.entity.CustomFlowerPotBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class CustomFlowerPotBlock extends Block implements EntityBlock {

    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }


    private static final Map<DyeColor, CustomFlowerPotBlock> ITEM_BY_COLOR = Maps.newEnumMap(DyeColor.class);
    private final DyeColor dyeColor;

    public CustomFlowerPotBlock(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
        ITEM_BY_COLOR.put(dyeColor, this);

    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    public static CustomFlowerPotBlock byColour(DyeColor dyeColor) {
        return ITEM_BY_COLOR.get(dyeColor);
    }





    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Item item = itemStack.getItem();


        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof CustomFlowerPotBlockEntity customFlowerPotBlockEntity) {
            if (item instanceof BlockItem blockItem) {
                Block block = blockItem.getBlock();
                if (block instanceof SaplingBlock saplingBlock && customFlowerPotBlockEntity.getPlant() == Blocks.AIR.defaultBlockState()) {
                    customFlowerPotBlockEntity.setPlant(saplingBlock.defaultBlockState());
                    if (!player.isCreative()) {
                        player.setItemInHand(interactionHand, ItemStack.EMPTY);
                    }
                } else {
                    return InteractionResult.FAIL;
                }
            }
            if (itemStack.isEmpty() && customFlowerPotBlockEntity.getPlant() != Blocks.AIR.defaultBlockState()) {
                ItemStack plantItemStack = customFlowerPotBlockEntity.getPlant().getBlock().asItem().getDefaultInstance();
                player.addItem(plantItemStack);
                customFlowerPotBlockEntity.setPlant(Blocks.AIR.defaultBlockState());
            }

            System.out.println(customFlowerPotBlockEntity.getPlant());
        }
        return InteractionResult.SUCCESS;
    }



    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Override
    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return false;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CustomFlowerPotBlockEntity(blockPos, blockState);
    }
}
