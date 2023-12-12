package com.kekecreations.arts_and_crafts.client.renderer.block;

import com.kekecreations.arts_and_crafts.common.block.entity.CustomFlowerPotBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;

public class CustomFlowerPotRenderer implements BlockEntityRenderer<CustomFlowerPotBlockEntity> {

    private final BlockRenderDispatcher blockRenderer;



    public CustomFlowerPotRenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }





    @Override
    public void render(CustomFlowerPotBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        ModelBlockRenderer.enableCaching();
        poseStack.pushPose();

        poseStack.translate(0.125F, 0.25F, 0.125F);
        poseStack.scale(0.75F, 0.75F, 0.75F);


        this.blockRenderer.renderSingleBlock(blockEntity.getPlant(), poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();
        ModelBlockRenderer.clearCache();
    }
}
