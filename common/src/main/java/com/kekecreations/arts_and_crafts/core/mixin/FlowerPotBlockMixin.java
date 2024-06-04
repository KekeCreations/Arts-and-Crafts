package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.common.item.PaintbrushItem;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlowerPotBlock.class)
public class FlowerPotBlockMixin {

    @Inject(method = "use", at = @At("TAIL"), cancellable = true)
    public void arts_and_crafts_use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult $$5, CallbackInfoReturnable<InteractionResult> cir) {
        if (ArtsAndCraftsCommonConfig.CAN_PAINT_FLOWER_POTS.get()) {
            ItemStack itemStack = player.getItemInHand(interactionHand);
            if (itemStack.getItem() instanceof PaintbrushItem paintBrushItem) {
                PaintbrushUtils.paintBlock(level, KekeBlocks.getDyedFlowerPot(paintBrushItem.getDyeColor().getId()).defaultBlockState(), blockPos, player, itemStack, interactionHand);
                cir.setReturnValue(InteractionResult.SUCCESS);
            }
        }
    }
}
