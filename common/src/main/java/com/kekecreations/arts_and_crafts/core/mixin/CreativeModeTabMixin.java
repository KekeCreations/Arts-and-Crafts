package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreativeModeTab.class)
public class CreativeModeTabMixin {


    @Shadow
    private final Component displayName;

    public CreativeModeTabMixin(Component displayName) {
        this.displayName = displayName;
    }


    @Inject(method = "shouldDisplay", at = @At("HEAD"), cancellable = true)
    public void shouldDisplay(CallbackInfoReturnable<Boolean> cir) {
        if (displayName.equals(Component.translatable("tab." + ArtsAndCrafts.MOD_ID + ".configurable_tab"))) {
            cir.setReturnValue(Services.CONFIG.isCreativeModeTabEnabled());
        }
    }
}
