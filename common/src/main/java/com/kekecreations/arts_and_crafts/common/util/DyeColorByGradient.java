package com.kekecreations.arts_and_crafts.common.util;

import net.minecraft.util.StringRepresentable;

public enum DyeColorByGradient implements StringRepresentable {
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