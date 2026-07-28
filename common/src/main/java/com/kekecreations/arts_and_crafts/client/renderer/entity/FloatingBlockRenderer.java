package com.kekecreations.arts_and_crafts.client.renderer.entity;

import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.FallingBlockRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

public class FloatingBlockRenderer extends EntityRenderer<FloatingBlockEntity, FallingBlockRenderState> {

    public FloatingBlockRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5F;
    }

    public boolean shouldRender(FloatingBlockEntity floatingBlockEntity, Frustum frustum, double d, double e, double f) {
        if (!super.shouldRender(floatingBlockEntity, frustum, d, e, f)) {
            return false;
        } else {
            return floatingBlockEntity.getBlockState() != floatingBlockEntity.level().getBlockState(floatingBlockEntity.blockPosition());
        }
    }

    public void submit(FallingBlockRenderState fallingBlockRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        BlockState blockState = fallingBlockRenderState.movingBlockRenderState.blockState;
        if (blockState.getRenderShape() == RenderShape.MODEL) {
            poseStack.pushPose();
            poseStack.translate((double)-0.5F, (double)0.0F, (double)-0.5F);
            submitNodeCollector.submitMovingBlock(poseStack, fallingBlockRenderState.movingBlockRenderState);
            poseStack.popPose();
            super.submit(fallingBlockRenderState, poseStack, submitNodeCollector, cameraRenderState);
        }
    }

    public FallingBlockRenderState createRenderState() {
        return new FallingBlockRenderState();
    }

    public void extractRenderState(FloatingBlockEntity floatingBlockEntity, FallingBlockRenderState fallingBlockRenderState, float f) {
        super.extractRenderState(floatingBlockEntity, fallingBlockRenderState, f);
        BlockPos blockPos = BlockPos.containing(floatingBlockEntity.getX(), floatingBlockEntity.getBoundingBox().maxY, floatingBlockEntity.getZ());
        fallingBlockRenderState.movingBlockRenderState.randomSeedPos = floatingBlockEntity.getStartPos();
        fallingBlockRenderState.movingBlockRenderState.blockPos = blockPos;
        fallingBlockRenderState.movingBlockRenderState.blockState = floatingBlockEntity.getBlockState();
        fallingBlockRenderState.movingBlockRenderState.biome = floatingBlockEntity.level().getBiome(blockPos);
        fallingBlockRenderState.movingBlockRenderState.level = floatingBlockEntity.level();
    }
}
