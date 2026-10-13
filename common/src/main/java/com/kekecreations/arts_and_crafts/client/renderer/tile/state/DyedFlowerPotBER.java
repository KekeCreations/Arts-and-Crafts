package com.kekecreations.arts_and_crafts.client.renderer.tile.state;

import com.kekecreations.arts_and_crafts.common.entity.DyedFlowerPotBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class DyedFlowerPotBER implements BlockEntityRenderer<DyedFlowerPotBlockEntity, DyedFlowerPotRenderState> {
    private final BlockModelResolver blockRenderer;

    public DyedFlowerPotBER(BlockEntityRendererProvider.Context context) {
        blockRenderer = context.blockModelResolver();
    }


    @Override
    public DyedFlowerPotRenderState createRenderState() {
        return new DyedFlowerPotRenderState();
    }

    @Override
    public void submit(DyedFlowerPotRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        BlockModelRenderState modelRenderState = state.displayBlock;
        if (!modelRenderState.isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.0F, 0.6875F, -0.75F);
            poseStack.mulPose(Axis.XP.rotationDegrees(20.0F));
            poseStack.mulPose(Axis.YP.rotationDegrees(45.0F));
            poseStack.translate(0.25F, 0.1875F, 0.25F);
            float s = 0.5F;
            poseStack.scale(-0.5F, -0.5F, 0.5F);
            poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
            modelRenderState.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            poseStack.popPose();
        }

        poseStack.popPose();
    }

    @Override
    public void extractRenderState(DyedFlowerPotBlockEntity blockEntity, DyedFlowerPotRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.storedPlant = blockEntity.getStoredPlant();

        if (state.storedPlant != null) {
            if (state.storedPlant instanceof BlockItem blockItem) {
                this.blockRenderer.update(state.displayBlock, blockItem.getBlock().defaultBlockState(), BlockDisplayContext.create());
            }
        }
    }
}
