package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.core.registry.ACDecoratedPotPatterns;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotPatterns.class)
public class DecoratedPotPatternsMixin {

    @Inject(method = "getPatternFromItem", at = @At("HEAD"), cancellable = true)
    private static void getPatternFromItem(Item item, CallbackInfoReturnable<ResourceKey<DecoratedPotPattern>> cir) {
        if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
            cir.setReturnValue(ACDecoratedPotPatterns.ROLL_POTTERY_PATTERN);
        }
        if (item == KekeItems.RUINED_POTTERY_SHERD.get()) {
            cir.setReturnValue(ACDecoratedPotPatterns.RUINED_POTTERY_PATTERN);
        }
        if (item == KekeItems.FINALE_POTTERY_SHERD.get()) {
            cir.setReturnValue(ACDecoratedPotPatterns.FINALE_POTTERY_PATTERN);
        }
        if (item == KekeItems.GATEWAY_POTTERY_SHERD.get()) {
            cir.setReturnValue(ACDecoratedPotPatterns.GATEWAY_POTTERY_PATTERN);
        }
        if (item == KekeItems.POTTERY_SHERD.get()) {
            cir.setReturnValue(ACDecoratedPotPatterns.POTTERY_PATTERN);
        }
    }

    @Inject(method = "bootstrap", at = @At("TAIL"))
    private static void arts_and_crafts_bootstrap(Registry<DecoratedPotPattern> registry, CallbackInfoReturnable<String> cir) {
        //NORMAL
        ACDecoratedPotPatterns.register(registry, ACDecoratedPotPatterns.POTTERY_PATTERN, "empty_pottery_pattern");
        ACDecoratedPotPatterns.register(registry, ACDecoratedPotPatterns.ROLL_POTTERY_PATTERN, "roll_pottery_pattern");
        ACDecoratedPotPatterns.register(registry, ACDecoratedPotPatterns.RUINED_POTTERY_PATTERN, "ruined_pottery_pattern");
        ACDecoratedPotPatterns.register(registry, ACDecoratedPotPatterns.FINALE_POTTERY_PATTERN, "finale_pottery_pattern");
        ACDecoratedPotPatterns.register(registry, ACDecoratedPotPatterns.GATEWAY_POTTERY_PATTERN, "gateway_pottery_pattern");
    }
}
