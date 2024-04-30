package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.common.item.PaintBrushItem;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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
public class ShulkerBoxBlockMixin {

    @Inject(method = "use", at = @At(value= "INVOKE", target = "net/minecraft/world/level/Level.getBlockEntity (Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/entity/BlockEntity;"), cancellable = true)
    public void arts_and_crafts_use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult, CallbackInfoReturnable<InteractionResult> cir) {
        if (ArtsAndCraftsCommonConfig.CAN_PAINT_SHULKER_BOX.get()) {
            List<ItemStack> itemList = new ArrayList<ItemStack>();
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof ShulkerBoxBlockEntity shulkerBE) {
                for (int i = 0; i < shulkerBE.getContainerSize(); ++i) {
                    itemList.add(shulkerBE.getItem(i));
                }

            }
            ItemStack itemStack = player.getItemInHand(interactionHand);
            ShulkerBoxBlock $this = (ShulkerBoxBlock)(Object)this;
            if (itemStack.getItem() instanceof PaintBrushItem paintBrushItem && $this.getColor() != paintBrushItem.getDyeColor()) {
                PaintbrushUtils.paintShulkerBox(level, ArtsAndCraftsDyedBlockLists.getDyedShulkerBox(paintBrushItem.getDyeColor().getId()).defaultBlockState(), blockPos, player, itemStack, interactionHand);
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
