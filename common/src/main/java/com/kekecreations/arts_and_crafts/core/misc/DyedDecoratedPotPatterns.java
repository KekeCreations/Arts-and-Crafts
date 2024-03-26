package com.kekecreations.arts_and_crafts.core.misc;

import com.kekecreations.arts_and_crafts.core.registry.KekeCustomSherdPatterns;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.jetbrains.annotations.Nullable;

public class DyedDecoratedPotPatterns {

    public DyedDecoratedPotPatterns() {
    }

    @Nullable
    public static Material getDecoratedPotBase(DyeColor colour) {
        if (colour == DyeColor.BLACK) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.BLACK_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.BLUE) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.BLUE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.BROWN) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.BROWN_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.CYAN) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.CYAN_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.GRAY) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.GRAY_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.GREEN) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.GREEN_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.LIGHT_BLUE) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.LIGHT_BLUE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.LIGHT_GRAY) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.LIGHT_GRAY_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.LIME) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.LIME_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.MAGENTA) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.MAGENTA_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.ORANGE) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.ORANGE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.PINK) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.PINK_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.PURPLE) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.PURPLE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.RED) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.RED_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.WHITE) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.WHITE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.YELLOW) {
            return Sheets.getDecoratedPotMaterial(KekeCustomSherdPatterns.YELLOW_DECORATED_POT_BASE);
        }
        return Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.BASE);
    }


    @Nullable
    public static ResourceKey<String> getResourceKey(Item item, DyeColor colour) {
        if (colour == DyeColor.BLACK) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.BLACK_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.BLACK_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLACK_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.BLUE) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.BLUE_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.BLUE_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BLUE_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.BROWN) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.BROWN_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.BROWN_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.BROWN_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.CYAN) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.CYAN_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.CYAN_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.CYAN_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.GRAY) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.GRAY_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.GRAY_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GRAY_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.GREEN) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.GREEN_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.GREEN_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.GREEN_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.LIGHT_BLUE) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_BLUE_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.LIGHT_GRAY) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIGHT_GRAY_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.LIME) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.LIME_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.LIME_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.LIME_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.MAGENTA) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.MAGENTA_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.MAGENTA_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.MAGENTA_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.ORANGE) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.ORANGE_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.ORANGE_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.ORANGE_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.PINK) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.PINK_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.PINK_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PINK_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.PURPLE) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.PURPLE_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.PURPLE_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.PURPLE_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.RED) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.RED_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.RED_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.RED_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.WHITE) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.WHITE_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.WHITE_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.WHITE_SNORT_POTTERY_PATTERN;
            }
        }
        if (colour == DyeColor.YELLOW) {
            if (item == Items.BRICK) {
                return KekeCustomSherdPatterns.YELLOW_DECORATED_POT_SIDE;
            }
            else if (item == KekeItems.ROLL_POTTERY_SHERD.get()) {
                return KekeCustomSherdPatterns.YELLOW_ROLL_POTTERY_PATTERN;
            }
            else if (item == Items.ANGLER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_ANGLER_POTTERY_PATTERN;
            }
            else if (item == Items.ARCHER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_ARCHER_POTTERY_PATTERN;
            }
            else if (item == Items.ARMS_UP_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_ARMS_UP_POTTERY_PATTERN;
            }
            else if (item == Items.BLADE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_BLADE_POTTERY_PATTERN;
            }
            else if (item == Items.BREWER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_BREWER_POTTERY_PATTERN;
            }
            else if (item == Items.BURN_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_BURN_POTTERY_PATTERN;
            }
            else if (item == Items.DANGER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_DANGER_POTTERY_PATTERN;
            }
            else if (item == Items.EXPLORER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_EXPLORER_POTTERY_PATTERN;
            }
            else if (item == Items.FRIEND_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_FRIEND_POTTERY_PATTERN;
            }
            else if (item == Items.HEART_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_HEART_POTTERY_PATTERN;
            }
            else if (item == Items.HEARTBREAK_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_HEARTBREAK_POTTERY_PATTERN;
            }
            else if (item == Items.HOWL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_HOWL_POTTERY_PATTERN;
            }
            else if (item == Items.MINER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_MINER_POTTERY_PATTERN;
            }
            else if (item == Items.MOURNER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_MOURNER_POTTERY_PATTERN;
            }
            else if (item == Items.PLENTY_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_PLENTY_POTTERY_PATTERN;
            }
            else if (item == Items.PRIZE_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_PRIZE_POTTERY_PATTERN;
            }
            else if (item == Items.SHEAF_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_SHEAF_POTTERY_PATTERN;
            }
            else if (item == Items.SHELTER_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_SHELTER_POTTERY_PATTERN;
            }
            else if (item == Items.SKULL_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_SKULL_POTTERY_PATTERN;
            }
            else if (item == Items.SNORT_POTTERY_SHERD) {
                return KekeCustomSherdPatterns.YELLOW_SNORT_POTTERY_PATTERN;
            }
        }
        return DecoratedPotPatterns.getResourceKey(item);
    }
}