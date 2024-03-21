package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.core.registry.KekeCustomSherdPatterns;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotPatterns.class)
public abstract class DecoratedPotPatternsMixin {

    @Shadow
    @Nullable
    public static ResourceKey<String> getResourceKey(Item arg) {
        return null;
    }

    @Inject(method = "getResourceKey", at = @At("RETURN"), cancellable = true)
    private static void arts_and_crafts_addedPatterns(Item item, CallbackInfoReturnable<ResourceKey<String>> cir) {

        if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
            cir.setReturnValue(KekeCustomSherdPatterns.ROLL);
        }
    }

    @Inject(method = "bootstrap", at = @At("TAIL"))
    private static void bootstrap(Registry<String> registry, CallbackInfoReturnable<String> cir) {
        Registry.register(registry, KekeCustomSherdPatterns.ROLL, "roll_pottery_pattern");
    }
}
