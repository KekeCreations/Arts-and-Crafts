package com.kekecreations.arts_and_crafts.client.renderer.atlas;

import com.google.common.base.Suppliers;
import com.kekecreations.arts_and_crafts.core.registry.ACSpriteSources;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import net.minecraft.client.renderer.texture.SpriteContents;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSourceType;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.client.renderer.texture.atlas.sources.LazyLoadedImage;
import net.minecraft.client.resources.metadata.animation.AnimationMetadataSection;
import net.minecraft.client.resources.metadata.animation.FrameSize;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.FastColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ACPalettedPermutations implements SpriteSource {
    static final Logger LOGGER = LogUtils.getLogger();
    public static final Codec<ACPalettedPermutations> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(Codec.list(SpriteSources.CODEC).fieldOf("sources").forGetter((palettedPermutations) -> {
            return palettedPermutations.sources;
        }), ResourceLocation.CODEC.fieldOf("palette_key").forGetter((palettedPermutations) -> {
            return palettedPermutations.paletteKey;
        }), Codec.unboundedMap(Codec.STRING, ResourceLocation.CODEC).fieldOf("permutations").forGetter((palettedPermutations) -> {
            return palettedPermutations.permutations;
        })).apply(instance, ACPalettedPermutations::new);
    });
    private final List<SpriteSource> sources;
    private final Map<String, ResourceLocation> permutations;
    private final ResourceLocation paletteKey;

    private ACPalettedPermutations(List<SpriteSource> list, ResourceLocation resourceLocation, Map<String, ResourceLocation> map) {
        this.sources = list;
        this.permutations = map;
        this.paletteKey = resourceLocation;
    }

    public void run(@NotNull ResourceManager resourceManager, SpriteSource.@NotNull Output output) {
        Supplier<int[]> supplier = Suppliers.memoize(() -> {
            return loadPaletteEntryFromImage(resourceManager, this.paletteKey);
        });
        Map<String, Supplier<IntUnaryOperator>> map = new HashMap();
        this.permutations.forEach((string, resourceLocationx) -> {
            map.put(string, Suppliers.memoize(() -> {
                return createPaletteMapping((int[])supplier.get(), loadPaletteEntryFromImage(resourceManager, resourceLocationx));
            }));
        });
        HashMap<ResourceLocation, SpriteSource.SpriteSupplier> sourceOutputMap = new HashMap<>();
        Output sourceOutput = new Output() {
            @Override
            public void add(@NotNull ResourceLocation location, @NotNull SpriteSupplier spriteSupplier) {
                SpriteSource.SpriteSupplier supplier = sourceOutputMap.put(location, spriteSupplier);
                if (supplier != null) {
                    supplier.discard();
                }
            }
            @Override
            public void removeAll(@NotNull Predicate<ResourceLocation> predicate) {
                Iterator<Map.Entry<ResourceLocation, SpriteSupplier>> iterator = sourceOutputMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<ResourceLocation, SpriteSource.SpriteSupplier> entry = iterator.next();
                    if (predicate.test(entry.getKey())) {
                        entry.getValue().discard();
                        iterator.remove();
                    }
                }
            }
        };
        for (Iterator<SpriteSource> it = this.sources.iterator(); it.hasNext(); ) {
            SpriteSource source = it.next();
            source.run(resourceManager, sourceOutput);
        }
        for (Iterator<ResourceLocation> it = sourceOutputMap.keySet().iterator(); it.hasNext(); ) {
            ResourceLocation resourceLocation = it.next();
            ResourceLocation resourceLocation2 = TEXTURE_ID_CONVERTER.idToFile(resourceLocation);
            Optional<Resource> optional = resourceManager.getResource(resourceLocation2);
            if (optional.isEmpty()) {
                LOGGER.warn("Unable to find texture {}", resourceLocation2);
            } else {
                LazyLoadedImage lazyLoadedImage = new LazyLoadedImage(resourceLocation2, (Resource)optional.get(), map.size());
                Iterator var10 = map.entrySet().iterator();

                while(var10.hasNext()) {
                    Map.Entry<String, Supplier<IntUnaryOperator>> entry = (Map.Entry)var10.next();
                    ResourceLocation resourceLocation3 = resourceLocation.withSuffix("_" + (String)entry.getKey());
                    output.add(resourceLocation3, new ACPalettedSpriteSupplier(lazyLoadedImage, (Supplier)entry.getValue(), resourceLocation3));
                }
            }
        }
    }

    private static IntUnaryOperator createPaletteMapping(int[] is, int[] js) {
        if (js.length != is.length) {
            LOGGER.warn("Palette mapping has different sizes: {} and {}", is.length, js.length);
            throw new IllegalArgumentException();
        } else {
            Int2IntMap int2IntMap = new Int2IntOpenHashMap(js.length);

            for(int i = 0; i < is.length; ++i) {
                int j = is[i];
                if (FastColor.ABGR32.alpha(j) != 0) {
                    int2IntMap.put(FastColor.ABGR32.transparent(j), js[i]);
                }
            }

            return (ix) -> {
                int j = FastColor.ABGR32.alpha(ix);
                if (j == 0) {
                    return ix;
                } else {
                    int k = FastColor.ABGR32.transparent(ix);
                    int l = int2IntMap.getOrDefault(k, FastColor.ABGR32.opaque(k));
                    int m = FastColor.ABGR32.alpha(l);
                    return FastColor.ABGR32.color(j * m / 255, l);
                }
            };
        }
    }

    public static int[] loadPaletteEntryFromImage(ResourceManager resourceManager, ResourceLocation resourceLocation) {
        Optional<Resource> optional = resourceManager.getResource(TEXTURE_ID_CONVERTER.idToFile(resourceLocation));
        if (optional.isEmpty()) {
            LOGGER.error("Failed to load palette image {}", resourceLocation);
            throw new IllegalArgumentException();
        } else {
            try {
                InputStream inputStream = ((Resource)optional.get()).open();

                int[] var5;
                try {
                    NativeImage nativeImage = NativeImage.read(inputStream);

                    try {
                        var5 = nativeImage.getPixelsRGBA();
                    } catch (Throwable var9) {
                        if (nativeImage != null) {
                            try {
                                nativeImage.close();
                            } catch (Throwable var8) {
                                var9.addSuppressed(var8);
                            }
                        }

                        throw var9;
                    }

                    if (nativeImage != null) {
                        nativeImage.close();
                    }
                } catch (Throwable var10) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable var7) {
                            var10.addSuppressed(var7);
                        }
                    }

                    throw var10;
                }

                if (inputStream != null) {
                    inputStream.close();
                }

                return var5;
            } catch (Exception var11) {
                Exception exception = var11;
                LOGGER.error("Couldn't load texture {}", resourceLocation, exception);
                throw new IllegalArgumentException();
            }
        }
    }

    public SpriteSourceType type() {
        return ACSpriteSources.PALETTED_PERMUTATIONS;
    }

    static record ACPalettedSpriteSupplier(LazyLoadedImage baseImage, Supplier<IntUnaryOperator> paletteSupplier, ResourceLocation permutationLocation) implements SpriteSource.SpriteSupplier {


        ACPalettedSpriteSupplier(LazyLoadedImage baseImage, Supplier<IntUnaryOperator> paletteSupplier, ResourceLocation permutationLocation) {
            this.baseImage = baseImage;
            this.paletteSupplier = paletteSupplier;
            this.permutationLocation = permutationLocation;
        }

        @Nullable
        public SpriteContents get() {
            SpriteContents var2;
            try {
                NativeImage nativeImage = this.baseImage.get().mappedCopy((IntUnaryOperator)this.paletteSupplier.get());
                var2 = new SpriteContents(this.permutationLocation, new FrameSize(nativeImage.getWidth(), nativeImage.getHeight()), nativeImage, AnimationMetadataSection.EMPTY);
                return var2;
            } catch (IllegalArgumentException | IOException var6) {
                Exception exception = var6;
                ACPalettedPermutations.LOGGER.error("unable to apply palette to {}", this.permutationLocation, exception);
                var2 = null;
            } finally {
                this.baseImage.release();
            }

            return var2;
        }

        public void discard() {
            this.baseImage.release();
        }

        public LazyLoadedImage baseImage() {
            return this.baseImage;
        }

        public Supplier<IntUnaryOperator> palette() {
            return this.paletteSupplier;
        }

        public ResourceLocation permutationLocation() {
            return this.permutationLocation;
        }
    }
}
