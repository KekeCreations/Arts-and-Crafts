package com.kekecreations.arts_and_crafts.client.renderer.tile;

import com.kekecreations.arts_and_crafts.client.renderer.tile.state.DyedDecoratedPotBER;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.PotDecorations;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.function.Consumer;

public class DyedDecoratedPotSpecialRenderer implements SpecialModelRenderer<PotDecorations> {
    private final DyedDecoratedPotBER decoratedPotRenderer;
    private final DyeColor colour;

    public DyedDecoratedPotSpecialRenderer(DyedDecoratedPotBER decoratedPotRenderer, DyeColor colour) {
        this.decoratedPotRenderer = decoratedPotRenderer;
        this.colour = colour;
    }

    public @Nullable PotDecorations extractArgument(ItemStack stack) {
        return stack.get(DataComponents.POT_DECORATIONS);
    }

    public void submit(
            @Nullable PotDecorations decorations,
            ItemDisplayContext ctx,
            PoseStack stack,
            SubmitNodeCollector node,
            int light,
            int overlay,
            boolean bool,
            int outline
    ) {
        this.decoratedPotRenderer.submit(stack, node, light, overlay, Objects.requireNonNullElse(decorations, PotDecorations.EMPTY), this.colour, outline);
    }

    @Override
    public void getExtents(Consumer<Vector3fc> consumer) {
        this.decoratedPotRenderer.getExtents(consumer);
    }

    public record Unbaked(DyeColor colour) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<DyedDecoratedPotSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec(
                instance -> instance.group(DyeColor.CODEC.fieldOf("colour").forGetter(DyedDecoratedPotSpecialRenderer.Unbaked::colour))
                        .apply(instance, DyedDecoratedPotSpecialRenderer.Unbaked::new)
        );

        @Override
        public MapCodec<DyedDecoratedPotSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(SpecialModelRenderer.BakingContext ctx) {
            return new DyedDecoratedPotSpecialRenderer(new DyedDecoratedPotBER(ctx), this.colour);
        }
    }
}

