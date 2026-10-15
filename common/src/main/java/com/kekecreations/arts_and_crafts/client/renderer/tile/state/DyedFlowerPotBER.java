package com.kekecreations.arts_and_crafts.client.renderer.tile.state;

import com.kekecreations.arts_and_crafts.common.entity.DyedFlowerPotBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.block.model.BlockDisplayContext;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
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
            if (state.storedPlant == Items.CRIMSON_ROOTS) {
                poseStack.pushPose();
                poseStack.translate(0.0F, 0F, 0.0F);
                modelRenderState.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
                poseStack.popPose();
            } else {
                poseStack.pushPose();
                poseStack.scale(0.75F, 0.75F, 0.75F);
                poseStack.translate(0.15F, 0.35F, 0.15F);
                modelRenderState.submit(poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
                poseStack.popPose();
            }
        }

        poseStack.popPose();
    }

    @Override
    public void extractRenderState(DyedFlowerPotBlockEntity blockEntity, DyedFlowerPotRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.storedPlant = blockEntity.getStoredPlant();
        state.blockPos = blockEntity.getBlockPos();

        if (state.storedPlant != null) {
            if (state.storedPlant == Items.CRIMSON_ROOTS) {
                //Create a block that is always disabled with potted crimson roots model without default pot
                this.blockRenderer.update(state.displayBlock, Blocks.POTTED_CRIMSON_ROOTS.defaultBlockState(), BlockDisplayContext.create());
            } else if (state.storedPlant instanceof BlockItem blockItem) {
                this.blockRenderer.update(state.displayBlock, blockItem.getBlock().defaultBlockState(), BlockDisplayContext.create());
            }
        }
    }
}
