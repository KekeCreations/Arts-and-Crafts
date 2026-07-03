package com.kekecreations.arts_and_crafts.core.mixin;

import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DecoratedPotBlockEntity.class)
public interface DecoratedPotBlockEntityAccessor {


    @Accessor(value = "decorations")
    void setDecorations(PotDecorations decorations);
}
