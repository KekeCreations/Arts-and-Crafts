package com.kekecreations.arts_and_crafts.client.renderer.tile.state;

import com.kekecreations.arts_and_crafts.common.entity.DyedFlowerPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.mojang.blaze3d.vertex.PoseStack;
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
            if (state.storedPlant == Items.CRIMSON_ROOTS || state.storedPlant == Items.WARPED_ROOTS
                    || state.storedPlant == Items.BAMBOO || state.storedPlant == Items.CACTUS
                    || state.storedPlant == Items.AZALEA || state.storedPlant == Items.FLOWERING_AZALEA) {
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
                this.blockRenderer.update(state.displayBlock, ACBlocks.CRIMSON_ROOTS_PLANT.get().defaultBlockState(), BlockDisplayContext.create());
            } else if (state.storedPlant == Items.WARPED_ROOTS) {
                this.blockRenderer.update(state.displayBlock, ACBlocks.WARPED_ROOTS_PLANT.get().defaultBlockState(), BlockDisplayContext.create());
            } else if (state.storedPlant == Items.BAMBOO) {
                this.blockRenderer.update(state.displayBlock, ACBlocks.BAMBOO_PLANT.get().defaultBlockState(), BlockDisplayContext.create());
            } else if (state.storedPlant == Items.CACTUS) {
                this.blockRenderer.update(state.displayBlock, ACBlocks.CACTUS_PLANT.get().defaultBlockState(), BlockDisplayContext.create());
            } else if (state.storedPlant == Items.AZALEA) {
                this.blockRenderer.update(state.displayBlock, ACBlocks.AZALEA_PLANT.get().defaultBlockState(), BlockDisplayContext.create());
            } else if (state.storedPlant == Items.FLOWERING_AZALEA) {
                this.blockRenderer.update(state.displayBlock, ACBlocks.FLOWERING_AZALEA_PLANT.get().defaultBlockState(), BlockDisplayContext.create());
            } else if (state.storedPlant instanceof BlockItem blockItem) {
                this.blockRenderer.update(state.displayBlock, blockItem.getBlock().defaultBlockState(), BlockDisplayContext.create());
            }
        }
    }

    @Override
    public int getViewDistance() {
        return 128;
    }
}
