package com.kekecreations.arts_and_crafts.common.util;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;

public class ArtsAndCraftsDyedBlockLists {

    public static HashMap<StringRepresentable, Block> DYED_TERRACOTTA = new HashMap<>();
    public static HashMap<StringRepresentable, Block> DYED_BANNER = new HashMap<>();



    public static void registerLists() {
        terracottaList();
        bannerList();
    }

    public static void bannerList() {
        DYED_BANNER.put(DyeColor.WHITE, Blocks.WHITE_BANNER);
        DYED_BANNER.put(DyeColor.ORANGE, Blocks.ORANGE_BANNER);
        DYED_BANNER.put(DyeColor.MAGENTA, Blocks.MAGENTA_BANNER);
        DYED_BANNER.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_BANNER);
        DYED_BANNER.put(DyeColor.YELLOW, Blocks.YELLOW_BANNER);
        DYED_BANNER.put(DyeColor.LIME, Blocks.LIME_BANNER);
        DYED_BANNER.put(DyeColor.PINK, Blocks.PINK_BANNER);
        DYED_BANNER.put(DyeColor.GRAY, Blocks.GRAY_BANNER);
        DYED_BANNER.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_BANNER);
        DYED_BANNER.put(DyeColor.CYAN, Blocks.CYAN_BANNER);
        DYED_BANNER.put(DyeColor.PURPLE, Blocks.PURPLE_BANNER);
        DYED_BANNER.put(DyeColor.BLUE, Blocks.BLUE_BANNER);
        DYED_BANNER.put(DyeColor.BROWN, Blocks.BROWN_BANNER);
        DYED_BANNER.put(DyeColor.GREEN, Blocks.GREEN_BANNER);
        DYED_BANNER.put(DyeColor.RED, Blocks.RED_BANNER);
        DYED_BANNER.put(DyeColor.BLACK, Blocks.BLACK_BANNER);
    }

    public static void terracottaList() {
        DYED_TERRACOTTA.put(DyeColor.WHITE, Blocks.WHITE_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.ORANGE, Blocks.ORANGE_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.MAGENTA, Blocks.MAGENTA_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.YELLOW, Blocks.YELLOW_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.LIME, Blocks.LIME_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.PINK, Blocks.PINK_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.GRAY, Blocks.GRAY_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.CYAN, Blocks.CYAN_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.PURPLE, Blocks.PURPLE_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.BLUE, Blocks.BLUE_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.BROWN, Blocks.BROWN_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.GREEN, Blocks.GREEN_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.RED, Blocks.RED_TERRACOTTA);
        DYED_TERRACOTTA.put(DyeColor.BLACK, Blocks.BLACK_TERRACOTTA);
    }


    public static Block getDyedBanner(int colours) {
        return DYED_BANNER.get(DyeColor.byId(colours));
    }

    public static Block getDyedTerracotta(int colours) {
        return DYED_TERRACOTTA.get(DyeColor.byId(colours));
    }
}
