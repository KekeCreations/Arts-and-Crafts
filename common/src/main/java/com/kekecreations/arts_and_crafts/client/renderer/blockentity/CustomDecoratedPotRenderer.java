package com.kekecreations.arts_and_crafts.client.renderer.blockentity;

import com.kekecreations.arts_and_crafts.common.entity.CustomDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.misc.DyedDecoratedPotPatterns;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeCustomSherdPatterns;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Objects;

@Environment(EnvType.CLIENT)
public class CustomDecoratedPotRenderer implements BlockEntityRenderer<CustomDecoratedPotBlockEntity> {
    private static final String NECK = "neck";
    private static final String FRONT = "front";
    private static final String BACK = "back";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";
    private static final String TOP = "top";
    private static final String BOTTOM = "bottom";
    private final ModelPart neck;
    private final ModelPart frontSide;
    private final ModelPart backSide;
    private final ModelPart leftSide;
    private final ModelPart rightSide;
    private final ModelPart top;
    private final ModelPart bottom;
    private Material baseMaterial;

    public CustomDecoratedPotRenderer(BlockEntityRendererProvider.Context context) {
        this.baseMaterial = (Material) Objects.requireNonNull(Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.BASE));
        ModelPart modelPart = context.bakeLayer(ModelLayers.DECORATED_POT_BASE);
        this.neck = modelPart.getChild("neck");
        this.top = modelPart.getChild("top");
        this.bottom = modelPart.getChild("bottom");
        ModelPart modelPart2 = context.bakeLayer(ModelLayers.DECORATED_POT_SIDES);
        this.frontSide = modelPart2.getChild("front");
        this.backSide = modelPart2.getChild("back");
        this.leftSide = modelPart2.getChild("left");
        this.rightSide = modelPart2.getChild("right");
    }

    public static LayerDefinition createBaseLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeDeformation cubeDeformation = new CubeDeformation(0.2F);
        CubeDeformation cubeDeformation2 = new CubeDeformation(-0.1F);
        partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, 17.0F, 4.0F, 8.0F, 3.0F, 8.0F, cubeDeformation2).texOffs(0, 5).addBox(5.0F, 20.0F, 5.0F, 6.0F, 1.0F, 6.0F, cubeDeformation), PartPose.offsetAndRotation(0.0F, 37.0F, 16.0F, 3.1415927F, 0.0F, 0.0F));
        CubeListBuilder cubeListBuilder = CubeListBuilder.create().texOffs(-14, 13).addBox(0.0F, 0.0F, 0.0F, 14.0F, 0.0F, 14.0F);
        partDefinition.addOrReplaceChild("top", cubeListBuilder, PartPose.offsetAndRotation(1.0F, 16.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("bottom", cubeListBuilder, PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 32, 32);
    }

    public static LayerDefinition createSidesLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        CubeListBuilder cubeListBuilder = CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, 0.0F, 0.0F, 14.0F, 16.0F, 0.0F, EnumSet.of(Direction.NORTH));
        partDefinition.addOrReplaceChild("back", cubeListBuilder, PartPose.offsetAndRotation(15.0F, 16.0F, 1.0F, 0.0F, 0.0F, 3.1415927F));
        partDefinition.addOrReplaceChild("left", cubeListBuilder, PartPose.offsetAndRotation(1.0F, 16.0F, 1.0F, 0.0F, -1.5707964F, 3.1415927F));
        partDefinition.addOrReplaceChild("right", cubeListBuilder, PartPose.offsetAndRotation(15.0F, 16.0F, 15.0F, 0.0F, 1.5707964F, 3.1415927F));
        partDefinition.addOrReplaceChild("front", cubeListBuilder, PartPose.offsetAndRotation(1.0F, 16.0F, 15.0F, 3.1415927F, 0.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 16, 16);
    }

    @Nullable
    private static Material getMaterial(DyeColor colour, Item item) {
        Material material = Sheets.getDecoratedPotMaterial(DyedDecoratedPotPatterns.getResourceKey(item, colour));
        if (material == null) {
            material = Sheets.getDecoratedPotMaterial(DyedDecoratedPotPatterns.getResourceKey(Items.BRICK, colour));
        }

        return material;
    }

    public void render(CustomDecoratedPotBlockEntity decoratedPotBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        /*
        BlockState blockState = Objects.requireNonNull(decoratedPotBlockEntity.getLevel()).getBlockState(decoratedPotBlockEntity.getBlockPos());
        for (DyeColor colours : DyeColor.values()) {
            if (blockState.is(KekeBlocks.getDyedDecoratedPot(colours))) {
                this.baseMaterial = (Material) Objects.requireNonNull(DyedDecoratedPotPatterns.getDecoratedPotBase(colours));
            }
        }
        poseStack.pushPose();
        Direction direction = decoratedPotBlockEntity.getDirection();
        poseStack.translate(0.5, 0.0, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - direction.toYRot()));
        poseStack.translate(-0.5, 0.0, -0.5);
        VertexConsumer vertexConsumer = this.baseMaterial.buffer(multiBufferSource, RenderType::entitySolid);
        this.neck.render(poseStack, vertexConsumer, i, j);
        this.top.render(poseStack, vertexConsumer, i, j);
        this.bottom.render(poseStack, vertexConsumer, i, j);
        CustomDecoratedPotBlockEntity.Decorations decorations = decoratedPotBlockEntity.getDecorations();
        this.renderSide(this.frontSide, poseStack, multiBufferSource, i, j, getMaterial(decorations.front(), blockState), blockState);
        this.renderSide(this.backSide, poseStack, multiBufferSource, i, j, getMaterial(decorations.back(), blockState), blockState);
        this.renderSide(this.leftSide, poseStack, multiBufferSource, i, j, getMaterial(decorations.left(), blockState), blockState);
        this.renderSide(this.rightSide, poseStack, multiBufferSource, i, j, getMaterial(decorations.right(), blockState), blockState);
        poseStack.popPose();

         */
        for (DyeColor colours : DyeColor.values()) {
            if (decoratedPotBlockEntity.getDyeColor() == colours) {
                this.baseMaterial = (Material) Objects.requireNonNull(DyedDecoratedPotPatterns.getDecoratedPotBase(colours));
            }
        }
        DyeColor colour = decoratedPotBlockEntity.getDyeColor();
        poseStack.pushPose();
        Direction direction = decoratedPotBlockEntity.getDirection();
        poseStack.translate(0.5, 0.0, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - direction.toYRot()));
        poseStack.translate(-0.5, 0.0, -0.5);
        VertexConsumer vertexConsumer = this.baseMaterial.buffer(multiBufferSource, RenderType::entitySolid);
        this.neck.render(poseStack, vertexConsumer, i, j);
        this.top.render(poseStack, vertexConsumer, i, j);
        this.bottom.render(poseStack, vertexConsumer, i, j);
        CustomDecoratedPotBlockEntity.Decorations decorations = decoratedPotBlockEntity.getDecorations();
        this.renderSide(this.frontSide, poseStack, multiBufferSource, i, j, getMaterial(colour, decorations.front()), colour);
        this.renderSide(this.backSide, poseStack, multiBufferSource, i, j, getMaterial(colour, decorations.back()), colour);
        this.renderSide(this.leftSide, poseStack, multiBufferSource, i, j, getMaterial(colour, decorations.left()), colour);
        this.renderSide(this.rightSide, poseStack, multiBufferSource, i, j, getMaterial(colour, decorations.right()), colour);
        poseStack.popPose();
    }

    private void renderSide(ModelPart modelPart, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, @Nullable Material material, DyeColor colour) {
        if (material == null) {
            material = getMaterial(colour, Items.BRICK);
        }

        if (material != null) {
            modelPart.render(poseStack, material.buffer(multiBufferSource, RenderType::entitySolid), i, j);
        }

    }
}