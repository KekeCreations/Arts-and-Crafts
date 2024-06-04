package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.entity.layers.LlamaDecorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.horse.Llama;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LlamaDecorLayer.class)
public class LlamaDecorLayerMixin {

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

/*
    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/horse/Llama;FFFFFF)V",
            at = @At(value = "HEAD"), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void arts_and_crafts_render(PoseStack $$0, MultiBufferSource $$1, int $$2, Llama llama, float $$4, float $$5, float $$6, float $$7, float $$8, float $$9, CallbackInfo ci, ResourceLocation resourceLocation, DyeColor dyeColor) {
        System.out.println(llama.getSlot(1).get());
        System.out.println(llama.getSlot(0).get());
        //resourceLocation = ArtsAndCrafts.id("textures/entity/llama/bleached");

    }

 */
}
