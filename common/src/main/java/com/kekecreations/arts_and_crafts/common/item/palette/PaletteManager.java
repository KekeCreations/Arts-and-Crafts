package com.kekecreations.arts_and_crafts.common.item.palette;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PaletteManager extends SimpleJsonResourceReloadListener {
    public static final PaletteManager INSTANCE = new PaletteManager();
    private static final Gson GSON = (new GsonBuilder()).create();

    private List<PaintBrushPalette> registry;

    public PaletteManager() {
        super(GSON, "paintbrush_palette");
        this.registry = List.of();
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> data, ResourceManager resourceManager, ProfilerFiller profiler) {
        List<PaintBrushPalette> registryBuilder = Lists.newArrayList();
        data.forEach((location, element) -> {
            try {
                Pair<PaintBrushPalette, JsonElement> result = PaintBrushPalette.CODEC.decode(JsonOps.INSTANCE, element).getOrThrow(false, s -> {});
                PaintBrushPalette palette = result.getFirst();

                if (palette.requiredMod().isEmpty() || Services.PLATFORM.isModLoaded(palette.requiredMod().get())) {
                    registryBuilder.add(palette);
                }
            }
            catch (Exception e) {
                ArtsAndCrafts.LOG.error("Failed to parse custom paintbrush palette {}: {}", location, e.getMessage());
            }
        });
        this.registry = registryBuilder;
    }

    @Nullable
    public Block get(Level level, BlockState state, DyeColor color) {
        Optional<PaintBrushPalette> optionalPalette = registry.stream().filter(
                searchPalette -> searchPalette.blocks().contains(state.getBlockHolder())
        ).findFirst();
        if (optionalPalette.isEmpty()) return null;

        PaintBrushPalette palette = optionalPalette.get();
        Holder<Block> holder = palette.palette().get(color);

        if (holder.unwrapKey().isPresent()) {
            Block finalBlock = level.registryAccess().registryOrThrow(Registries.BLOCK).get(holder.unwrapKey().get());

            if (state.getBlock() != finalBlock) {
                return finalBlock;
            }
        }
        return null;
    }
}
