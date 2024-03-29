package com.kekecreations.arts_and_crafts.core.mixin;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockSetType.class)
public interface BlockSetTypeMixin {


    @Invoker
    static BlockSetType invokeRegister(BlockSetType blockSetType) {
        throw new AssertionError();
    }
}
