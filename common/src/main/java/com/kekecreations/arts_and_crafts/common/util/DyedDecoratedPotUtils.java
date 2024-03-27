package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.core.registry.KekeCustomSherdPatterns;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.jetbrains.annotations.Nullable;

public class DyedDecoratedPotUtils {

    public DyedDecoratedPotUtils() {
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
}