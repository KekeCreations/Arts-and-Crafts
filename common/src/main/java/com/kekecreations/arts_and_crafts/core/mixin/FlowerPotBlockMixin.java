package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
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

    @Inject(method = "use", at = @At("TAIL"))
    public void arts_and_crafts_use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult $$5, CallbackInfoReturnable<InteractionResult> cir) {
        if (ArtsAndCraftsCommonConfig.CAN_PAINT_FLOWER_POTS.get()) {
            ItemStack itemStack = player.getItemInHand(interactionHand);
            for (DyeColor colours : DyeColor.values()) {
                if (itemStack.getItem() == KekeItems.getPaintBrush(colours.getId())) {
                    PaintbrushUtils.paintBlock(level, ArtsAndCraftsDyedBlockLists.getDyedFlowerPot(colours.getId()).defaultBlockState(), blockPos, player, itemStack, interactionHand);
                    player.swing(interactionHand);
                }
            }
        }
    }
}
