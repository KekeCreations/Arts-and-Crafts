package com.kekecreations.arts_and_crafts.client.renderer.block;

import com.kekecreations.arts_and_crafts.common.block.entity.CustomFlowerPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

public class CustomFlowerPotRenderer implements BlockEntityRenderer<CustomFlowerPotBlockEntity> {
    private final BlockRenderDispatcher blockRenderer;
    private final ModelManager modelManager;



    public CustomFlowerPotRenderer(BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
        this.modelManager = blockRenderer.getBlockModelShaper().getModelManager();
    }




    @Override
    public void render(CustomFlowerPotBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        ModelBlockRenderer.enableCaching();
        poseStack.pushPose();


        //poseStack.translate(0.125F, 0.25F, 0.125F);
        //poseStack.scale(0.75F, 0.75F, 0.75F);

        BlockState blockState = blockEntity.getPlant();


        if (blockEntity.getPlant().getBlock() instanceof SaplingBlock || blockEntity.getPlant().getBlock() instanceof FlowerBlock) {
            poseStack.translate(0.125F, 0.25F, 0.125F);
            poseStack.scale(0.75F, 0.75F, 0.75F);
        } else {
            //poseStack.translate(0F, 0.3F, 0F);
        }
        int color = Minecraft.getInstance().getBlockColors().getColor(blockState, blockEntity.getLevel(), blockEntity.getBlockPos(), 0);
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;

        int light = LevelRenderer.getLightColor(Objects.requireNonNull(blockEntity.getLevel()), blockEntity.getBlockPos());
        this.blockRenderer.getModelRenderer().renderModel(poseStack.last(), multiBufferSource.getBuffer(ItemBlockRenderTypes.getRenderType(blockState, true)), blockState, blockRenderer.getBlockModel(blockState), red, green, blue, light, OverlayTexture.NO_OVERLAY);

        //this.blockRenderer.renderSingleBlock(blockState, poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY);



        poseStack.popPose();
        ModelBlockRenderer.clearCache();
    }
}
