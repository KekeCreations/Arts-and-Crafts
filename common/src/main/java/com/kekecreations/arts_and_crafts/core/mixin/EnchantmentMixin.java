package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    private void arts_and_crafts_removePaintBrushes(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        for (DyeColor colours : DyeColor.values()) {
            if (stack.is(ACItems.getPaintBrush(colours.getId()))) cir.setReturnValue(false);
        }
    }
}