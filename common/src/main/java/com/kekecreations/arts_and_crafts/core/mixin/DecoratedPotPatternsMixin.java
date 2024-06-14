package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.ACDecoratedPotPatterns;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(DecoratedPotPatterns.class)
public class DecoratedPotPatternsMixin {
    @Unique
    private static final Map<Item, ResourceKey<DecoratedPotPattern>> ITEM_TO_PATTERN = Map.of(
            KekeItems.POTTERY_SHERD.get(), ACDecoratedPotPatterns.POTTERY_PATTERN,
            KekeItems.ROLL_POTTERY_SHERD.get(), ACDecoratedPotPatterns.ROLL_POTTERY_PATTERN,
            KekeItems.RUINED_POTTERY_SHERD.get(), ACDecoratedPotPatterns.RUINED_POTTERY_PATTERN,
            KekeItems.FINALE_POTTERY_SHERD.get(), ACDecoratedPotPatterns.FINALE_POTTERY_PATTERN,
            KekeItems.GATEWAY_POTTERY_SHERD.get(), ACDecoratedPotPatterns.GATEWAY_POTTERY_PATTERN
    );

    @Inject(method = "getPatternFromItem", at = @At("HEAD"), cancellable = true)
    private static void getPatternFromItem(Item item, CallbackInfoReturnable<ResourceKey<DecoratedPotPattern>> cir) {
        ArtsAndCrafts.LOG.info("Yo I'm being injected");
        if (ITEM_TO_PATTERN.containsKey(item)) {
            cir.setReturnValue(ITEM_TO_PATTERN.get(item));
        }
    }
}
