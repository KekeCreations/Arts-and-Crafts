package com.kekecreations.arts_and_crafts.core.registry;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public enum KekeDyeColours implements StringRepresentable
{
    WHITE(0, "white", 0xF9FFFE, MapColor.SNOW, 0xF0F0F0, 0xFFFFFF),
    TAN(1, "tan", 16777129, MapColor.RAW_IRON, 16777129, 16777129),
    TURQUOISE(2, "turquoise", 31688, MapColor.WARPED_WART_BLOCK, 31688, 36040),
    CRIMSON(3, "crimson", 16711779, MapColor.CRIMSON_NYLIUM, 16711779, 16711779),
    CREAM(4, "cream", 16777089, MapColor.TERRACOTTA_YELLOW, 16777089, 16777118),
    OLIVE(5, "olive", 53798, MapColor.EMERALD, 53798, 7787046),
    PINE(6, "pine", 32256, MapColor.COLOR_LIGHT_GREEN, 32256, 38656);

    private static final IntFunction<KekeDyeColours> BY_ID;
    private static final Int2ObjectOpenHashMap<KekeDyeColours> BY_FIREWORK_COLOR;
    public static final StringRepresentable.EnumCodec<KekeDyeColours> CODEC;
    private final int id;
    private final String name;
    private final MapColor mapColor;
    private final float[] textureDiffuseColors;
    private final int fireworkColor;
    private final int textColor;

    private KekeDyeColours(int j, String string2, int k, MapColor mapColor, int l, int m) {
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

    public static KekeDyeColours byId(int i) {
        return BY_ID.apply(i);
    }

    @Nullable
    @Contract(value="_,!null->!null;_,null->_")
    public static KekeDyeColours byName(String string, @Nullable KekeDyeColours dyeColor) {
        KekeDyeColours dyeColor2 = CODEC.byName(string);
        return dyeColor2 != null ? dyeColor2 : dyeColor;
    }

    @Nullable
    public static KekeDyeColours byFireworkColor(int i) {
        return BY_FIREWORK_COLOR.get(i);
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    static {
        BY_ID = ByIdMap.continuous(KekeDyeColours::getId, KekeDyeColours.values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        BY_FIREWORK_COLOR = new Int2ObjectOpenHashMap<KekeDyeColours>(Arrays.stream(KekeDyeColours.values()).collect(Collectors.toMap(dyeColor -> dyeColor.fireworkColor, dyeColor -> dyeColor)));
        CODEC = StringRepresentable.fromEnum(KekeDyeColours::values);
    }
}

