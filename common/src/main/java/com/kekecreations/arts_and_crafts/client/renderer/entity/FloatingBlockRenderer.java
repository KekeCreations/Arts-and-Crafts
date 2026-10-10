package com.kekecreations.arts_and_crafts.client.renderer.entity;

import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.FallingBlockRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
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

    public void extractRenderState(FloatingBlockEntity entity, FallingBlockRenderState state, float f) {
        super.extractRenderState(entity, state, f);
        BlockPos pos = BlockPos.containing(entity.getX(), entity.getBoundingBox().maxY, entity.getZ());
        state.movingBlockRenderState.randomSeedPos = entity.getStartPos();
        state.movingBlockRenderState.blockPos = pos;
        state.movingBlockRenderState.blockState = entity.getBlockState();
        Level level = entity.level();
        if (level instanceof ClientLevel clientLevel) {
            state.movingBlockRenderState.biome = clientLevel.getBiome(pos);
            state.movingBlockRenderState.cardinalLighting = clientLevel.cardinalLighting();
            state.movingBlockRenderState.lightEngine = clientLevel.getLightEngine();
        }
    }
}
