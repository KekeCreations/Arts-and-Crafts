package com.kekecreations.arts_and_crafts.core.misc;

import net.minecraft.util.StringRepresentable;

public enum DyeColorByGradient implements StringRepresentable {
    /*
    WHITE(0, "white"),
    LIGHT_GRAY(8, "light_gray"),
    GRAY(7, "gray"),
    BLACK(15, "black"),
    BROWN(12, "brown"),
    RED(14, "red"),
    ORANGE(1, "orange"),
    YELLOW(4, "yellow"),
    LIME(5, "lime"),
    GREEN(13, "green"),
    CYAN(9, "cyan"),
    LIGHT_BLUE(3, "light_blue"),
    BLUE(11, "blue"),
    PURPLE(10, "purple"),
    MAGENTA(2, "magenta"),
    PINK(6, "pink");

     */
    PINK(6, "pink"),
    MAGENTA(2, "magenta"),
    PURPLE(10, "purple"),
    BLUE(11, "blue"),
    LIGHT_BLUE(3, "light_blue"),
    CYAN(9, "cyan"),
    GREEN(13, "green"),
    LIME(5, "lime"),
    YELLOW(4, "yellow"),
    ORANGE(1, "orange"),
    RED(14, "red"),
    BROWN(12, "brown"),
    BLACK(15, "black"),
    GRAY(7, "gray"),
    LIGHT_GRAY(8, "light_gray"),
    WHITE(0, "white");


    private final int id;
    private final String name;

    private DyeColorByGradient(int j, String string2) {
        this.id = j;
        this.name = string2;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}