package com.kekecreations.arts_and_crafts.core.mixin;

import net.minecraft.client.renderer.entity.layers.LlamaDecorLayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LlamaDecorLayer.class)
public class LlamaDecorLayerMixin {


    /*   1.20.5+ stuff seems this doesn't work in 1.20.1

    @ModifyExpressionValue(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Llama;FFFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/horse/Llama;isTraderLlama()Z"))
    private boolean arts_and_crafts_isTraderLlama(boolean original, @Local(argsOnly = true) Llama llama) {
        if (llama.getItemBySlot(EquipmentSlot.CHEST).is(KekeBlocks.BLEACHED_CARPET.get().asItem())) {
            return true;
        }
        return original;
    }

    @ModifyVariable(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Llama;FFFFFF)V", at = @At(value = "STORE", ordinal = 1))
    private ResourceLocation arts_and_crafts_customLlamaTexture(ResourceLocation original, @Local(argsOnly = true) Llama llama) {
        if (llama.getItemBySlot(EquipmentSlot.CHEST).is(KekeBlocks.BLEACHED_CARPET.get().asItem())) {
            return new ResourceLocation("textures/entity/llama/decor/white.png");
        }
        return original;
    }

     */
}
