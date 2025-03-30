package com.kekecreations.arts_and_crafts.fabric.core.mixin;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrushableBlockEntity.class)
public class BrushableBlockEntityMixin {

    @Shadow
    private ItemStack item;

    @Inject(method = "dropContent", at = @At(value = "HEAD"))
    private void arts_and_crafts$brush(Player player, CallbackInfo ci) {
        if (Services.CONFIG.aprilFools2025()) {
            if (player.getRandom().nextFloat() < 0.1F) {
                item = ACItems.SUS_POTTERY_SHERD.get().getDefaultInstance();
            } else if (player.getRandom().nextFloat() < 0.1F) {
                item = ACItems.VICTORY_POTTERY_SHERD.get().getDefaultInstance();
            }
        }

    }
}
