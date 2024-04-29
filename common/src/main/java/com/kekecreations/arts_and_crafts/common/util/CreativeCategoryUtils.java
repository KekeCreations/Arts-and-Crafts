package com.kekecreations.arts_and_crafts.common.util;

import net.minecraft.world.item.DyeColor;

import java.util.ArrayList;

public class CreativeCategoryUtils {

    public static ArrayList<DyeColor> colourOrder = new ArrayList<DyeColor>();

    /**
     * This method allows you to add a custom dye to the colour order in the creative category (after adding a custom dye to this list the blocks should appear in the creative category)
     *
     * @param  color a vanilla or modded dye
     * @param  index where it places the colour in the list
     */
    public static void addDyeToColourOrder(DyeColor color, int index) {
        colourOrder.add(index, color);
    }
    public static void addVanillaDyesToColourOrder() {
        colourOrder.add(DyeColor.PINK);
        colourOrder.add(DyeColor.MAGENTA);
        colourOrder.add(DyeColor.PURPLE);
        colourOrder.add(DyeColor.BLUE);
        colourOrder.add(DyeColor.LIGHT_BLUE);
        colourOrder.add(DyeColor.CYAN);
        colourOrder.add(DyeColor.GREEN);
        colourOrder.add(DyeColor.LIME);
        colourOrder.add(DyeColor.YELLOW);
        colourOrder.add(DyeColor.ORANGE);
        colourOrder.add(DyeColor.RED);
        colourOrder.add(DyeColor.BROWN);
        colourOrder.add(DyeColor.BLACK);
        colourOrder.add(DyeColor.GRAY);
        colourOrder.add(DyeColor.LIGHT_GRAY);
        colourOrder.add(DyeColor.WHITE);
    }
}
