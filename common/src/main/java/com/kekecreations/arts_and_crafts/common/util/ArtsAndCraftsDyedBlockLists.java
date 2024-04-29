package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;

public class ArtsAndCraftsDyedBlockLists {

    public static HashMap<StringRepresentable, Block> DYED_TERRACOTTA = new HashMap<>();
    public static HashMap<StringRepresentable, Block> DYED_GLAZED_TERRACOTTA = new HashMap<>();
    public static HashMap<StringRepresentable, Block> DYED_WOOL = new HashMap<>();



    public static void registerLists() {
        terracottaList();
        glazedTerracottaList();
        woolList();
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

    public static void glazedTerracottaList() {
        DYED_GLAZED_TERRACOTTA.put(DyeColor.WHITE, Blocks.WHITE_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.ORANGE, Blocks.ORANGE_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.MAGENTA, Blocks.MAGENTA_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.YELLOW, Blocks.YELLOW_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.LIME, Blocks.LIME_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.PINK, Blocks.PINK_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.GRAY, Blocks.GRAY_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.CYAN, Blocks.CYAN_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.PURPLE, Blocks.PURPLE_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.BLUE, Blocks.BLUE_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.BROWN, Blocks.BROWN_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.GREEN, Blocks.GREEN_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.RED, Blocks.RED_GLAZED_TERRACOTTA);
        DYED_GLAZED_TERRACOTTA.put(DyeColor.BLACK, Blocks.BLACK_GLAZED_TERRACOTTA);
    }

    public static void woolList() {
        DYED_WOOL.put(DyeColor.WHITE, Blocks.WHITE_WOOL);
        DYED_WOOL.put(DyeColor.ORANGE, Blocks.ORANGE_WOOL);
        DYED_WOOL.put(DyeColor.MAGENTA, Blocks.MAGENTA_WOOL);
        DYED_WOOL.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        DYED_WOOL.put(DyeColor.YELLOW, Blocks.YELLOW_WOOL);
        DYED_WOOL.put(DyeColor.LIME, Blocks.LIME_WOOL);
        DYED_WOOL.put(DyeColor.PINK, Blocks.PINK_WOOL);
        DYED_WOOL.put(DyeColor.GRAY, Blocks.GRAY_WOOL);
        DYED_WOOL.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        DYED_WOOL.put(DyeColor.CYAN, Blocks.CYAN_WOOL);
        DYED_WOOL.put(DyeColor.PURPLE, Blocks.PURPLE_WOOL);
        DYED_WOOL.put(DyeColor.BLUE, Blocks.BLUE_WOOL);
        DYED_WOOL.put(DyeColor.BROWN, Blocks.BROWN_WOOL);
        DYED_WOOL.put(DyeColor.GREEN, Blocks.GREEN_WOOL);
        DYED_WOOL.put(DyeColor.RED, Blocks.RED_WOOL);
        DYED_WOOL.put(DyeColor.BLACK, Blocks.BLACK_WOOL);
    }


    public static Block getDyedTerracotta(int colours) {
        return DYED_TERRACOTTA.get(DyeColor.byId(colours));
    }

    public static Block getDyedGlazedTerracotta(int colours) {
        return DYED_GLAZED_TERRACOTTA.get(DyeColor.byId(colours));
    }

    public static Block getDyedWool(int colours) {
        return DYED_WOOL.get(DyeColor.byId(colours));
    }
}
