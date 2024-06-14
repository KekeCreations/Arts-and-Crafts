package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.core.registry.ACCustomSherdPatterns;
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
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.BLACK_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.BLUE) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.BLUE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.BROWN) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.BROWN_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.CYAN) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.CYAN_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.GRAY) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.GRAY_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.GREEN) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.GREEN_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.LIGHT_BLUE) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.LIGHT_BLUE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.LIGHT_GRAY) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.LIGHT_GRAY_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.LIME) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.LIME_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.MAGENTA) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.MAGENTA_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.ORANGE) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.ORANGE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.PINK) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.PINK_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.PURPLE) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.PURPLE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.RED) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.RED_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.WHITE) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.WHITE_DECORATED_POT_BASE);
        }
        if (colour == DyeColor.YELLOW) {
            return Sheets.getDecoratedPotMaterial(ACCustomSherdPatterns.YELLOW_DECORATED_POT_BASE);
        }
        return Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.BASE);
    }
}