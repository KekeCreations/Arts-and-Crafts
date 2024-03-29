package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {


    @Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
    private void arts_and_crafts_isValid(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        var $this = BlockEntityType.class.cast(this);
        if ($this == BlockEntityType.SIGN) {
            if (state.is(KekeBlocks.CORK_SIGN.get())) {
                cir.setReturnValue(true);
            }
            if (state.is(KekeBlocks.CORK_WALL_SIGN.get())) {
                cir.setReturnValue(true);
            }
        }
        if ($this == BlockEntityType.HANGING_SIGN) {
            if (state.is(KekeBlocks.CORK_HANGING_SIGN.get())) {
                cir.setReturnValue(true);
            }
            if (state.is(KekeBlocks.CORK_WALL_HANGING_SIGN.get())) {
                cir.setReturnValue(true);
            }
        }
    }
}
