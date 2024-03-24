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
        }
        return DecoratedPotPatterns.getResourceKey(item);
    }
}