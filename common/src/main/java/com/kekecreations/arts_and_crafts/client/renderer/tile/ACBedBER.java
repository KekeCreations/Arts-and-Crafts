package com.kekecreations.arts_and_crafts.client.renderer.tile;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.ACBedBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;

public class ACBedBER implements BlockEntityRenderer<ACBedBlockEntity> {
    private final ModelPart headRoot;
    private final ModelPart footRoot;

    public ACBedBER(BlockEntityRendererProvider.Context context) {
        this.headRoot = context.bakeLayer(ModelLayers.BED_HEAD);
        this.footRoot = context.bakeLayer(ModelLayers.BED_FOOT);
    }

    @Override
    public void render(ACBedBlockEntity bedBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        Material material = new Material(Sheets.BED_SHEET, ResourceLocation.withDefaultNamespace("entity/bed/red"));
        if (bedBlockEntity.getColor() == DyeColor.WHITE) {
            material = new Material(Sheets.BED_SHEET, ArtsAndCrafts.id("entity/bed/bleached"));
        }
        Level level = bedBlockEntity.getLevel();
        if (level != null) {
            BlockState blockState = bedBlockEntity.getBlockState();
            DoubleBlockCombiner.NeighborCombineResult<BedBlockEntity> neighborCombineResult = DoubleBlockCombiner.combineWithNeigbour(BlockEntityType.BED, BedBlock::getBlockType, BedBlock::getConnectedDirection, ChestBlock.FACING, blockState, level, bedBlockEntity.getBlockPos(), (levelAccessor, blockPos) -> false);
            int k = ((Int2IntFunction) neighborCombineResult.apply(new BrightnessCombiner())).get(i);
            this.renderPiece(poseStack, multiBufferSource, blockState.getValue(BedBlock.PART) == BedPart.HEAD ? this.headRoot : this.footRoot, blockState.getValue(BedBlock.FACING), material, k, j, false);
        } else {
            this.renderPiece(poseStack, multiBufferSource, this.headRoot, Direction.SOUTH, material, i, j, false);
            this.renderPiece(poseStack, multiBufferSource, this.footRoot, Direction.SOUTH, material, i, j, true);
        }
    }

    private void renderPiece(PoseStack poseStack, MultiBufferSource multiBufferSource, ModelPart modelPart, Direction direction, Material material, int i, int j, boolean bl) {
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.5625f, bl ? -1.0f : 0.0f);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
        poseStack.translate(0.5f, 0.5f, 0.5f);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0f + direction.toYRot()));
        poseStack.translate(-0.5f, -0.5f, -0.5f);
        VertexConsumer vertexConsumer = material.buffer(multiBufferSource, RenderType::entitySolid);
        modelPart.render(poseStack, vertexConsumer, i, j);
        poseStack.popPose();
    }
}

