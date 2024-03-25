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
            cir.setReturnValue(KekeCustomSherdPatterns.ROLL_POTTERY_PATTERN);
        }
    }

    @Inject(method = "bootstrap", at = @At("TAIL"))
    private static void bootstrap(Registry<String> registry, CallbackInfoReturnable<String> cir) {
        //NORMAL
        Registry.register(registry, KekeCustomSherdPatterns.ROLL_POTTERY_PATTERN, "roll_pottery_pattern");
        //BLACK
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_DECORATED_POT_BASE, "black_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_DECORATED_POT_SIDE, "black_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_ROLL_POTTERY_PATTERN, "black_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_ANGLER_POTTERY_PATTERN, "black_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_ARCHER_POTTERY_PATTERN, "black_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_ARMS_UP_POTTERY_PATTERN, "black_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_BLADE_POTTERY_PATTERN, "black_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_BREWER_POTTERY_PATTERN, "black_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_BURN_POTTERY_PATTERN, "black_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLACK_DANGER_POTTERY_PATTERN, "black_danger_pottery_pattern");
        //BLUE
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_DECORATED_POT_BASE, "blue_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_DECORATED_POT_SIDE, "blue_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_ROLL_POTTERY_PATTERN, "blue_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_ANGLER_POTTERY_PATTERN, "blue_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_ARCHER_POTTERY_PATTERN, "blue_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_ARMS_UP_POTTERY_PATTERN, "blue_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_BLADE_POTTERY_PATTERN, "blue_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_BREWER_POTTERY_PATTERN, "blue_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_BURN_POTTERY_PATTERN, "blue_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BLUE_DANGER_POTTERY_PATTERN, "blue_danger_pottery_pattern");
        //BROWN
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_DECORATED_POT_BASE, "brown_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_DECORATED_POT_SIDE, "brown_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_ROLL_POTTERY_PATTERN, "brown_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_ANGLER_POTTERY_PATTERN, "brown_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_ARCHER_POTTERY_PATTERN, "brown_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_ARMS_UP_POTTERY_PATTERN, "brown_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_BLADE_POTTERY_PATTERN, "brown_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_BREWER_POTTERY_PATTERN, "brown_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_BURN_POTTERY_PATTERN, "brown_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.BROWN_DANGER_POTTERY_PATTERN, "brown_danger_pottery_pattern");
        //CYAN
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_DECORATED_POT_BASE, "cyan_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_DECORATED_POT_SIDE, "cyan_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_ROLL_POTTERY_PATTERN, "cyan_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_ANGLER_POTTERY_PATTERN, "cyan_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_ARCHER_POTTERY_PATTERN, "cyan_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_ARMS_UP_POTTERY_PATTERN, "cyan_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_BLADE_POTTERY_PATTERN, "cyan_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_BREWER_POTTERY_PATTERN, "cyan_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_BURN_POTTERY_PATTERN, "cyan_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.CYAN_DANGER_POTTERY_PATTERN, "cyan_danger_pottery_pattern");
        //GRAY
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_DECORATED_POT_BASE, "gray_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_DECORATED_POT_SIDE, "gray_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_ROLL_POTTERY_PATTERN, "gray_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_ANGLER_POTTERY_PATTERN, "gray_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_ARCHER_POTTERY_PATTERN, "gray_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_ARMS_UP_POTTERY_PATTERN, "gray_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_BLADE_POTTERY_PATTERN, "gray_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_BREWER_POTTERY_PATTERN, "gray_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_BURN_POTTERY_PATTERN, "gray_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GRAY_DANGER_POTTERY_PATTERN, "gray_danger_pottery_pattern");
        //GREEN
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_DECORATED_POT_BASE, "green_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_DECORATED_POT_SIDE, "green_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_ROLL_POTTERY_PATTERN, "green_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_ANGLER_POTTERY_PATTERN, "green_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_ARCHER_POTTERY_PATTERN, "green_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_ARMS_UP_POTTERY_PATTERN, "green_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_BLADE_POTTERY_PATTERN, "green_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_BREWER_POTTERY_PATTERN, "green_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_BURN_POTTERY_PATTERN, "green_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.GREEN_DANGER_POTTERY_PATTERN, "green_danger_pottery_pattern");
        //LIGHT_BLUE
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_DECORATED_POT_BASE, "light_blue_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_DECORATED_POT_SIDE, "light_blue_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_ROLL_POTTERY_PATTERN, "light_blue_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_ANGLER_POTTERY_PATTERN, "light_blue_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_ARCHER_POTTERY_PATTERN, "light_blue_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_ARMS_UP_POTTERY_PATTERN, "light_blue_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_BLADE_POTTERY_PATTERN, "light_blue_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_BREWER_POTTERY_PATTERN, "light_blue_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_BURN_POTTERY_PATTERN, "light_blue_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_BLUE_DANGER_POTTERY_PATTERN, "light_blue_danger_pottery_pattern");
        //LIGHT_GRAY
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_DECORATED_POT_BASE, "light_gray_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_DECORATED_POT_SIDE, "light_gray_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_ROLL_POTTERY_PATTERN, "light_gray_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_ANGLER_POTTERY_PATTERN, "light_gray_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_ARCHER_POTTERY_PATTERN, "light_gray_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_ARMS_UP_POTTERY_PATTERN, "light_gray_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_BLADE_POTTERY_PATTERN, "light_gray_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_BREWER_POTTERY_PATTERN, "light_gray_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_BURN_POTTERY_PATTERN, "light_gray_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIGHT_GRAY_DANGER_POTTERY_PATTERN, "light_gray_danger_pottery_pattern");
        //LIME
        Registry.register(registry, KekeCustomSherdPatterns.LIME_DECORATED_POT_BASE, "lime_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.LIME_DECORATED_POT_SIDE, "lime_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.LIME_ROLL_POTTERY_PATTERN, "lime_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIME_ANGLER_POTTERY_PATTERN, "lime_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIME_ARCHER_POTTERY_PATTERN, "lime_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIME_ARMS_UP_POTTERY_PATTERN, "lime_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIME_BLADE_POTTERY_PATTERN, "lime_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIME_BREWER_POTTERY_PATTERN, "lime_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIME_BURN_POTTERY_PATTERN, "lime_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.LIME_DANGER_POTTERY_PATTERN, "lime_danger_pottery_pattern");
        //MAGENTA
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_DECORATED_POT_BASE, "magenta_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_DECORATED_POT_SIDE, "magenta_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_ROLL_POTTERY_PATTERN, "magenta_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_ANGLER_POTTERY_PATTERN, "magenta_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_ARCHER_POTTERY_PATTERN, "magenta_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_ARMS_UP_POTTERY_PATTERN, "magenta_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_BLADE_POTTERY_PATTERN, "magenta_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_BREWER_POTTERY_PATTERN, "magenta_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_BURN_POTTERY_PATTERN, "magenta_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.MAGENTA_DANGER_POTTERY_PATTERN, "magenta_danger_pottery_pattern");
        //ORANGE
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_DECORATED_POT_BASE, "orange_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_DECORATED_POT_SIDE, "orange_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_ROLL_POTTERY_PATTERN, "orange_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_ANGLER_POTTERY_PATTERN, "orange_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_ARCHER_POTTERY_PATTERN, "orange_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_ARMS_UP_POTTERY_PATTERN, "orange_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_BLADE_POTTERY_PATTERN, "orange_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_BREWER_POTTERY_PATTERN, "orange_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_BURN_POTTERY_PATTERN, "orange_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.ORANGE_DANGER_POTTERY_PATTERN, "orange_danger_pottery_pattern");
        //PINK
        Registry.register(registry, KekeCustomSherdPatterns.PINK_DECORATED_POT_BASE, "pink_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.PINK_DECORATED_POT_SIDE, "pink_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.PINK_ROLL_POTTERY_PATTERN, "pink_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PINK_ANGLER_POTTERY_PATTERN, "pink_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PINK_ARCHER_POTTERY_PATTERN, "pink_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PINK_ARMS_UP_POTTERY_PATTERN, "pink_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PINK_BLADE_POTTERY_PATTERN, "pink_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PINK_BREWER_POTTERY_PATTERN, "pink_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PINK_BURN_POTTERY_PATTERN, "pink_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PINK_DANGER_POTTERY_PATTERN, "pink_danger_pottery_pattern");
        //PURPLE
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_DECORATED_POT_BASE, "purple_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_DECORATED_POT_SIDE, "purple_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_ROLL_POTTERY_PATTERN, "purple_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_ANGLER_POTTERY_PATTERN, "purple_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_ARCHER_POTTERY_PATTERN, "purple_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_ARMS_UP_POTTERY_PATTERN, "purple_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_BLADE_POTTERY_PATTERN, "purple_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_BREWER_POTTERY_PATTERN, "purple_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_BURN_POTTERY_PATTERN, "purple_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.PURPLE_DANGER_POTTERY_PATTERN, "purple_danger_pottery_pattern");
        //RED
        Registry.register(registry, KekeCustomSherdPatterns.RED_DECORATED_POT_BASE, "red_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.RED_DECORATED_POT_SIDE, "red_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.RED_ROLL_POTTERY_PATTERN, "red_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.RED_ANGLER_POTTERY_PATTERN, "red_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.RED_ARCHER_POTTERY_PATTERN, "red_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.RED_ARMS_UP_POTTERY_PATTERN, "red_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.RED_BLADE_POTTERY_PATTERN, "red_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.RED_BREWER_POTTERY_PATTERN, "red_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.RED_BURN_POTTERY_PATTERN, "red_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.RED_DANGER_POTTERY_PATTERN, "red_danger_pottery_pattern");
        //WHITE
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_DECORATED_POT_BASE, "white_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_DECORATED_POT_SIDE, "white_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_ROLL_POTTERY_PATTERN, "white_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_ANGLER_POTTERY_PATTERN, "white_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_ARCHER_POTTERY_PATTERN, "white_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_ARMS_UP_POTTERY_PATTERN, "white_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_BLADE_POTTERY_PATTERN, "white_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_BREWER_POTTERY_PATTERN, "white_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_BURN_POTTERY_PATTERN, "white_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.WHITE_DANGER_POTTERY_PATTERN, "white_danger_pottery_pattern");
        //YELLOW
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_DECORATED_POT_BASE, "yellow_decorated_pot_base");
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_DECORATED_POT_SIDE, "yellow_decorated_pot_side");
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_ROLL_POTTERY_PATTERN, "yellow_roll_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_ANGLER_POTTERY_PATTERN, "yellow_angler_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_ARCHER_POTTERY_PATTERN, "yellow_archer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_ARMS_UP_POTTERY_PATTERN, "yellow_arms_up_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_BLADE_POTTERY_PATTERN, "yellow_blade_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_BREWER_POTTERY_PATTERN, "yellow_brewer_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_BURN_POTTERY_PATTERN, "yellow_burn_pottery_pattern");
        Registry.register(registry, KekeCustomSherdPatterns.YELLOW_DANGER_POTTERY_PATTERN, "yellow_danger_pottery_pattern");
    }
}
