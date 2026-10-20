package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.DyedFlowerPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.init.ACTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
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
import org.jetbrains.annotations.Nullable;

public class DyedFlowerPotBlock extends BaseEntityBlock {

    protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);

    public static final MapCodec<DyedFlowerPotBlock> CODEC = simpleCodec(DyedFlowerPotBlock::new);

    public DyedFlowerPotBlock(Properties properties) {
        super(properties);
    }

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
    protected float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0F;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = itemStack.getItem();
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (item instanceof BlockItem blockItem) {
            if (blockEntity instanceof DyedFlowerPotBlockEntity dyedFlowerPotBlockEntity) {
                if (dyedFlowerPotBlockEntity.getStoredPlant().isEmpty()) {
                    Block block = blockItem.getBlock();
                    if (block instanceof SaplingBlock ||
                            block instanceof FlowerBlock ||
                            block instanceof RootsBlock ||
                            block instanceof MushroomBlock ||
                            itemStack.is(ACTags.ItemTags.CAN_BE_POTTED)) {
                        dyedFlowerPotBlockEntity.setStoredPlant(item.getDefaultInstance());
                        itemStack.consumeAndReturn(1, player);
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }
        }
        return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof DyedFlowerPotBlockEntity dyedFlowerPotBlockEntity) {
            if (!dyedFlowerPotBlockEntity.getStoredPlant().isEmpty()) {
                //get default instance of itemstack or it bugs out at 3?
                if (!player.addItem(dyedFlowerPotBlockEntity.getStoredPlant().getItem().getDefaultInstance())) {
                    player.drop(dyedFlowerPotBlockEntity.getStoredPlant().getItem().getDefaultInstance(), false);
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

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
        if (blockEntity instanceof DyedFlowerPotBlockEntity potBlockEntity) {
            ItemEntity item = EntityType.ITEM.create(level);
            if (item != null && !potBlockEntity.getStoredPlant().isEmpty()) {
                item.setItem(potBlockEntity.getStoredPlant());
                item.setPos(pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5);
                level.addFreshEntity(item);
            }
        }
    }


}
