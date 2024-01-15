package com.kekecreations.arts_and_crafts.core.misc;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public enum NaturalDyeColor implements StringRepresentable
{
    WHITE(0, "tara", 0xF9FFFE,MapColor.SNOW, 0xF0F0F0, 0xFFFFFF),
    ORANGE(1, "quebracho", 16351261, MapColor.COLOR_ORANGE, 15435844, 16738335),
    MAGENTA(2, "hibiscus", 13061821, MapColor.COLOR_MAGENTA, 12801229, 0xFF00FF),
    LIGHT_BLUE(3, "cerulean", 3847130, MapColor.COLOR_LIGHT_BLUE, 6719955, 10141901),
    YELLOW(4, "marigold", 16701501, MapColor.COLOR_YELLOW, 14602026, 0xFFFF00),
    LIME(5, "henna", 8439583, MapColor.COLOR_LIGHT_GREEN, 4312372, 0xBFFF00),
    PINK(6, "rose", 15961002, MapColor.COLOR_PINK, 14188952, 16738740),
    GRAY(7, "tyrian", 4673362, MapColor.COLOR_GRAY, 0x434343, 0x808080),
    LIGHT_GRAY(8, "onion", 0x9D9D97, MapColor.COLOR_LIGHT_GRAY, 0xABABAB, 0xD3D3D3),
    CYAN(9, "aquamarine", 1481884, MapColor.COLOR_CYAN, 2651799, 65535),
    PURPLE(10, "alkanet", 8991416, MapColor.COLOR_PURPLE, 8073150, 10494192),
    BLUE(11, "woad", 3949738, MapColor.COLOR_BLUE, 2437522, 255),
    BROWN(12, "sequoia", 8606770, MapColor.COLOR_BROWN, 5320730, 9127187),
    GREEN(13, "yerba", 6192150, MapColor.COLOR_GREEN, 3887386, 65280),
    RED(14, "madder", 11546150, MapColor.COLOR_RED, 11743532, 0xFF0000),
    BLACK(15, "lac", 0x1D1D21, MapColor.COLOR_BLACK, 0x1E1B1B, 0);

    private static final IntFunction<NaturalDyeColor> BY_ID;
    public static final StringRepresentable.EnumCodec<NaturalDyeColor> CODEC;
    private final int id;
    private final String name;
    private final MapColor mapColor;
    private final float[] textureDiffuseColors;
    private final int fireworkColor;
    private final int textColor;

    private NaturalDyeColor(int j, String string2, int k, MapColor mapColor, int l, int m) {
        this.id = j;
        this.name = string2;
        this.mapColor = mapColor;
        this.textColor = m;
        int n = (k & 0xFF0000) >> 16;
        int o = (k & 0xFF00) >> 8;
        int p = (k & 0xFF) >> 0;
        this.textureDiffuseColors = new float[]{(float)n / 255.0f, (float)o / 255.0f, (float)p / 255.0f};
        this.fireworkColor = l;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float[] getTextureDiffuseColors() {
        return this.textureDiffuseColors;
    }

    public MapColor getMapColor() {
        return this.mapColor;
    }

    public int getFireworkColor() {
        return this.fireworkColor;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public static NaturalDyeColor byId(int i) {
        return BY_ID.apply(i);
    }

    @Nullable
    @Contract(value="_,!null->!null;_,null->_")
    public static NaturalDyeColor byName(String string, @Nullable NaturalDyeColor dyeColor) {
        NaturalDyeColor dyeColor2 = CODEC.byName(string);
        return dyeColor2 != null ? dyeColor2 : dyeColor;
    }


    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    static {
        BY_ID = ByIdMap.continuous(NaturalDyeColor::getId, NaturalDyeColor.values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        CODEC = StringRepresentable.fromEnum(NaturalDyeColor::values);
    }
}
