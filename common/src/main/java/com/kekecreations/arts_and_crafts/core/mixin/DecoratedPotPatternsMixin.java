package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.core.registry.ACCustomSherdPatterns;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotPatterns.class)
public abstract class DecoratedPotPatternsMixin {


    @Inject(method = "getResourceKey", at = @At("RETURN"), cancellable = true)
    private static void arts_and_crafts_addedPatterns(Item item, CallbackInfoReturnable<ResourceKey<String>> cir) {

        if (item == ACItems.ROLL_POTTERY_SHERD.get()) {
            cir.setReturnValue(ACCustomSherdPatterns.ROLL_POTTERY_PATTERN);
        }
        if (item == ACItems.RUINED_POTTERY_SHERD.get()) {
            cir.setReturnValue(ACCustomSherdPatterns.RUINED_POTTERY_PATTERN);
        }
        if (item == ACItems.FINALE_POTTERY_SHERD.get()) {
            cir.setReturnValue(ACCustomSherdPatterns.FINALE_POTTERY_PATTERN);
        }
        if (item == ACItems.GATEWAY_POTTERY_SHERD.get()) {
            cir.setReturnValue(ACCustomSherdPatterns.GATEWAY_POTTERY_PATTERN);
        }
        if (item == ACItems.POTTERY_SHERD.get()) {
            cir.setReturnValue(ACCustomSherdPatterns.POTTERY_PATTERN);
        }
    }

    @Inject(method = "bootstrap", at = @At("TAIL"))
    private static void arts_and_crafts_bootstrap(Registry<String> registry, CallbackInfoReturnable<String> cir) {
        //NORMAL
        Registry.register(registry, ACCustomSherdPatterns.POTTERY_PATTERN, "pottery_pattern");
        Registry.register(registry, ACCustomSherdPatterns.ROLL_POTTERY_PATTERN, "roll_pottery_pattern");
        Registry.register(registry, ACCustomSherdPatterns.RUINED_POTTERY_PATTERN, "ruined_pottery_pattern");
        Registry.register(registry, ACCustomSherdPatterns.FINALE_POTTERY_PATTERN, "finale_pottery_pattern");
        Registry.register(registry, ACCustomSherdPatterns.GATEWAY_POTTERY_PATTERN, "gateway_pottery_pattern");
    }
}