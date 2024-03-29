package com.kekecreations.arts_and_crafts.client.renderer.entity;

import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

public class FloatingBlockRenderer extends EntityRenderer<FloatingBlockEntity> {
    private final BlockRenderDispatcher dispatcher;

    public FloatingBlockRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5f;
        this.dispatcher = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(FloatingBlockEntity fallingBlockEntity, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        BlockState blockState = fallingBlockEntity.getBlockState();
        if (blockState.getRenderShape() != RenderShape.MODEL) {
            return;
        }
        Level level = fallingBlockEntity.level();
        if (blockState == level.getBlockState(fallingBlockEntity.blockPosition()) || blockState.getRenderShape() == RenderShape.INVISIBLE) {
            return;
        }
        poseStack.pushPose();
        BlockPos blockPos = BlockPos.containing(fallingBlockEntity.getX(), fallingBlockEntity.getBoundingBox().maxY, fallingBlockEntity.getZ());
        poseStack.translate(-0.5, 0.0, -0.5);
        this.dispatcher.getModelRenderer().tesselateBlock(level, this.dispatcher.getBlockModel(blockState), blockState, blockPos, poseStack, multiBufferSource.getBuffer(ItemBlockRenderTypes.getMovingBlockRenderType(blockState)), false, RandomSource.create(), blockState.getSeed(fallingBlockEntity.getStartPos()), OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(fallingBlockEntity, f, g, poseStack, multiBufferSource, i);
    }

    @Override
    public ResourceLocation getTextureLocation(FloatingBlockEntity fallingBlockEntity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}