package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.common.item.PaintbrushItem;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ShulkerBoxBlock.class)
public class ShulkerBoxBlockMixin extends Block {

    public ShulkerBoxBlockMixin(Properties $$0) {
        super($$0);
    }
    @Override
    public ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide()) {
            if (itemStack.getItem() instanceof PaintbrushItem) {
                Block finalBlock = PaintbrushUtils.getFinalBlock(level.registryAccess(), blockState, itemStack);
                if (finalBlock != null && finalBlock != blockState.getBlock()) {
                    List<ItemStack> itemList = new ArrayList<ItemStack>();
                    BlockEntity blockEntity = level.getBlockEntity(blockPos);
                    if (blockEntity instanceof ShulkerBoxBlockEntity shulkerBE) {
                        for (int i = 0; i < shulkerBE.getContainerSize(); ++i) {
                            itemList.add(shulkerBE.getItem(i));
                        }
                    }
                    PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), blockPos, player, itemStack, interactionHand);
                    BlockEntity newBlockEntity = level.getBlockEntity(blockPos);
                    if (newBlockEntity instanceof ShulkerBoxBlockEntity newShulkerBE) {
                        for (int i = 0; i < newShulkerBE.getContainerSize(); ++i) {
                            newShulkerBE.setItem(i, itemList.get(i));
                        }
                    }
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }
        return ItemInteractionResult.FAIL;
    }

    /*
    @Inject(method = "useWithoutItem(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;", at = @At(value= "TAIL"), cancellable = true)
    public void arts_and_crafts_use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult, CallbackInfoReturnable<InteractionResult> cir) {
        if (!level.isClientSide()) {
            ItemStack itemStack = player.getItemInHand(interactionHand);
            if (itemStack.getItem() instanceof PaintbrushItem) {
                Block finalBlock = PaintbrushUtils.getFinalBlock(level.registryAccess(), blockState, itemStack);
                if (finalBlock != null && finalBlock != blockState.getBlock()) {
                    List<ItemStack> itemList = new ArrayList<ItemStack>();
                    BlockEntity blockEntity = level.getBlockEntity(blockPos);
                    if (blockEntity instanceof ShulkerBoxBlockEntity shulkerBE) {
                        for (int i = 0; i < shulkerBE.getContainerSize(); ++i) {
                            itemList.add(shulkerBE.getItem(i));
                        }
                    }
                    PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), blockPos, player, itemStack, interactionHand);
                    BlockEntity newBlockEntity = level.getBlockEntity(blockPos);
                    if (newBlockEntity instanceof ShulkerBoxBlockEntity newShulkerBE) {
                        for (int i = 0; i < newShulkerBE.getContainerSize(); ++i) {
                            newShulkerBE.setItem(i, itemList.get(i));
                        }
                    }
                    cir.setReturnValue(InteractionResult.SUCCESS);
                }
            }
        }
    }

     */
}
