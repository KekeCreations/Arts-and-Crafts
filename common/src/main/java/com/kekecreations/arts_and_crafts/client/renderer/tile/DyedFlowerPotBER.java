package com.kekecreations.arts_and_crafts.client.renderer.tile;

import com.kekecreations.arts_and_crafts.common.entity.DyedFlowerPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class DyedFlowerPotBER implements BlockEntityRenderer<DyedFlowerPotBlockEntity> {

    private final BlockRenderDispatcher blockRenderer;

    public DyedFlowerPotBER(BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }


    @Override
    public void render(DyedFlowerPotBlockEntity dyedFlowerPotBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        poseStack.pushPose();
        Item storedPlant = dyedFlowerPotBlockEntity.getStoredPlant().getItem();
        if (storedPlant instanceof BlockItem blockItem) {
            if (storedPlant == Items.CRIMSON_ROOTS) {
                renderCustomPlantModel(ACBlocks.CRIMSON_ROOTS_PLANT.get(), poseStack, multiBufferSource, i);
            } else if (storedPlant == Items.WARPED_ROOTS) {
                renderCustomPlantModel(ACBlocks.WARPED_ROOTS_PLANT.get(), poseStack, multiBufferSource, i);
            } else if (storedPlant == Items.BAMBOO) {
                renderCustomPlantModel(ACBlocks.BAMBOO_PLANT.get(), poseStack, multiBufferSource, i);
            } else if (storedPlant == Items.AZALEA) {
                renderCustomPlantModel(ACBlocks.AZALEA_PLANT.get(), poseStack, multiBufferSource, i);
            } else if (storedPlant == Items.FLOWERING_AZALEA) {
                renderCustomPlantModel(ACBlocks.FLOWERING_AZALEA_PLANT.get(), poseStack, multiBufferSource, i);
            } else if (storedPlant == Items.CACTUS) {
                renderCustomPlantModel(ACBlocks.CACTUS_PLANT.get(), poseStack, multiBufferSource, i);
            } else {
                poseStack.pushPose();
                poseStack.scale(0.75F, 0.75F, 0.75F);
                poseStack.translate(0.15F, 0.35F, 0.15F);
                blockRenderer.renderSingleBlock(blockItem.getBlock().defaultBlockState(), poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY);
                poseStack.popPose();
            }
        }
        poseStack.popPose();
    }

    private void renderCustomPlantModel(Block block, PoseStack poseStack, MultiBufferSource multiBufferSource, int lightCoords) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 0F, 0.0F);
        blockRenderer.renderSingleBlock(block.defaultBlockState(), poseStack, multiBufferSource, lightCoords, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }

    @Override
    public int getViewDistance() {
        return 128;
    }
}
