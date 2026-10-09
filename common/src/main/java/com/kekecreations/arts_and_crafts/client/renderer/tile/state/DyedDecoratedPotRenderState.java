package com.kekecreations.arts_and_crafts.client.renderer.tile.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import org.jspecify.annotations.Nullable;

public class DyedDecoratedPotRenderState extends BlockEntityRenderState {
    public float yRot;
    public DecoratedPotBlockEntity.@Nullable WobbleStyle wobbleStyle;
    public float wobbleProgress;
    public PotDecorations decorations;
    public Direction direction;
    public DyeColor dyeColour;

    public DyedDecoratedPotRenderState() {
        this.decorations = PotDecorations.EMPTY;
        this.direction = Direction.NORTH;
        this.dyeColour = DyeColor.WHITE;
    }
}

