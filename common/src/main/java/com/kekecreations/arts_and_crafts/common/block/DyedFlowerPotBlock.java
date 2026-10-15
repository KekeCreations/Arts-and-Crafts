package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.DyedFlowerPotBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class DyedFlowerPotBlock extends BaseEntityBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);

    public DyedFlowerPotBlock(Properties properties) {
        super(properties);
    }

    public static final MapCodec<DyedFlowerPotBlock> CODEC = simpleCodec(DyedFlowerPotBlock::new);

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
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
    protected @NonNull InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = itemStack.getItem();
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (item instanceof BlockItem blockItem) {
            if (blockEntity instanceof DyedFlowerPotBlockEntity dyedFlowerPotBlockEntity) {
                if (dyedFlowerPotBlockEntity.getStoredPlant() == Items.AIR) {
                    if (blockItem.getBlock() instanceof SaplingBlock || blockItem.getBlock() instanceof FlowerBlock) {
                        itemStack.consume(1, player);
                        dyedFlowerPotBlockEntity.setStoredPlant(blockItem);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof DyedFlowerPotBlockEntity dyedFlowerPotBlockEntity) {
            if (dyedFlowerPotBlockEntity.getStoredPlant() != Items.AIR) {

                if (!player.addItem(dyedFlowerPotBlockEntity.getStoredPlant().asItem().getDefaultInstance())) {
                    player.drop(dyedFlowerPotBlockEntity.getStoredPlant().asItem().getDefaultInstance(), false);
                }
                dyedFlowerPotBlockEntity.resetStoredPlant();

                return InteractionResult.SUCCESS;
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        DyedFlowerPotBlockEntity blockEntity = new DyedFlowerPotBlockEntity(blockPos, blockState);
        return blockEntity;
    }
}
