package com.kekecreations.arts_and_crafts.common.util;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DyedPotUtils {


    public static Block getDyedPotParticle(DyeColor colour) {
        switch (colour) {
            case LIGHT_GRAY -> {
                return Blocks.LIGHT_GRAY_TERRACOTTA;
            }
            case MAGENTA -> {
                return Blocks.MAGENTA_TERRACOTTA;
            }
            case YELLOW -> {
                return Blocks.YELLOW_TERRACOTTA;
            }
            case PURPLE -> {
                return Blocks.PURPLE_TERRACOTTA;
            }
            case ORANGE -> {
                return Blocks.ORANGE_TERRACOTTA;
            }
            case GREEN -> {
                return Blocks.GREEN_TERRACOTTA;
            }
            case BROWN -> {
                return Blocks.BROWN_TERRACOTTA;
            }
            case BLACK -> {
                return Blocks.BLACK_TERRACOTTA;
            }
            case PINK -> {
                return Blocks.PINK_TERRACOTTA;
            }
            case LIME -> {
                return Blocks.LIME_TERRACOTTA;
            }
            case GRAY -> {
                return Blocks.GRAY_TERRACOTTA;
            }
            case CYAN -> {
                return Blocks.CYAN_TERRACOTTA;
            }
            case BLUE -> {
                return Blocks.BLUE_TERRACOTTA;
            }
            case WHITE -> {
                return Blocks.WHITE_TERRACOTTA;
            }
            case RED -> {
                return Blocks.RED_TERRACOTTA;
            }
            case LIGHT_BLUE -> {
                return Blocks.LIGHT_BLUE_TERRACOTTA;
            }
            default -> {
                return Blocks.TERRACOTTA;
            }
        }
    }
}
