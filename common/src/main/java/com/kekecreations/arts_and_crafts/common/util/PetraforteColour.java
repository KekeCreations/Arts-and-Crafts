package com.kekecreations.arts_and_crafts.common.util;

import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

public enum PetraforteColour implements StringRepresentable {
    BEIGE(0, "beige", MapColor.SAND),
    HAZEL(1, "hazel", MapColor.SAND),
    IVORY(2, "ivory", MapColor.WOOL),
    JET(3, "jet", MapColor.COLOR_GRAY),
    MARLOT(4, "marlot", MapColor.COLOR_PINK),
    OCHRE(5, "ochre", MapColor.COLOR_YELLOW),
    UMBER(6, "umber", MapColor.COLOR_LIGHT_GRAY),
    VERDANT(7, "verdant", MapColor.CLAY);

    private static final IntFunction<PetraforteColour> BY_ID = ByIdMap.continuous(PetraforteColour::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StringRepresentable.EnumCodec<PetraforteColour> CODEC = StringRepresentable.fromEnum(PetraforteColour::values);
    private final int id;
    private final String name;
    private final MapColor colour;

    private PetraforteColour(int j, String string2, MapColor colour) {
        this.id = j;
        this.name = string2;
        this.colour = colour;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


    public MapColor getMapColor() {
        return this.colour;
    }

    public static PetraforteColour byId(int i) {
        return BY_ID.apply(i);
    }

    @Nullable
    @Contract("_,!null->!null;_,null->_")
    public static PetraforteColour byName(String string, @Nullable PetraforteColour dyeColor) {
        PetraforteColour dyeColor2 = CODEC.byName(string);
        return dyeColor2 != null ? dyeColor2 : dyeColor;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}