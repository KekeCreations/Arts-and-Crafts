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
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BedBlock.class)
public class BedBlockMixin {

    @Inject(method = "use", at = @At(value= "HEAD"), cancellable = true)
    public void arts_and_crafts_use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult, CallbackInfoReturnable<InteractionResult> cir) {
        if (ArtsAndCraftsCommonConfig.CAN_PAINT_BED.get()) {
            ItemStack itemStack = player.getItemInHand(interactionHand);
            if (!level.isClientSide()) {
                if (itemStack.getItem() instanceof PaintBrushItem paintBrushItem) {
                    if (level.getBlockState(blockPos).getBlock() instanceof BedBlock bedBlock && bedBlock.getColor() != paintBrushItem.getDyeColor()) {
                        PaintbrushUtils.paintBed(level, ArtsAndCraftsDyedBlockLists.getDyedBed(paintBrushItem.getDyeColor().getId()).defaultBlockState(), blockPos, player, itemStack, interactionHand);
                        cir.setReturnValue(InteractionResult.SUCCESS);
                    }
                }
            }
        }
    }
}
