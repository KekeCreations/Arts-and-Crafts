package com.kekecreations.arts_and_crafts.client.renderer.tile.state;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.EnumSet;
import java.util.Optional;
import java.util.function.Consumer;

import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity.WobbleStyle;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

public class DyedDecoratedPotBER implements BlockEntityRenderer<DyedDecoratedPotBlockEntity, DyedDecoratedPotRenderState> {
    public static final ModelLayerLocation BASE = new ModelLayerLocation(ArtsAndCrafts.id("base"), "main");
    public static final ModelLayerLocation SIDE = new ModelLayerLocation(ArtsAndCrafts.id("side"), "main");
    private final MaterialSet materials;
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
    private static final float WOBBLE_AMPLITUDE = 0.125F;

    public DyedDecoratedPotBER(BlockEntityRendererProvider.Context context) {
        this(context.entityModelSet(), context.materials());
    }

    public DyedDecoratedPotBER(SpecialModelRenderer.BakingContext context) {
        this(context.entityModelSet(), context.materials());
    }

    public DyedDecoratedPotBER(EntityModelSet modelSet, MaterialSet materials) {
        this.materials = materials;
        ModelPart modelpart = modelSet.bakeLayer(ModelLayers.DECORATED_POT_BASE);
        this.neck = modelpart.getChild("neck");
        this.top = modelpart.getChild("top");
        this.bottom = modelpart.getChild("bottom");
        ModelPart modelpart1 = modelSet.bakeLayer(ModelLayers.DECORATED_POT_SIDES);
        this.frontSide = modelpart1.getChild("front");
        this.backSide = modelpart1.getChild("back");
        this.leftSide = modelpart1.getChild("left");
        this.rightSide = modelpart1.getChild("right");
    }

    public static LayerDefinition createBaseLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubedeformation = new CubeDeformation(0.2F);
        CubeDeformation cubedeformation1 = new CubeDeformation(-0.1F);
        partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, 17.0F, 4.0F, 8.0F, 3.0F, 8.0F, cubedeformation1).texOffs(0, 5).addBox(5.0F, 20.0F, 5.0F, 6.0F, 1.0F, 6.0F, cubedeformation), PartPose.offsetAndRotation(0.0F, 37.0F, 16.0F, (float)Math.PI, 0.0F, 0.0F));
        CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(-14, 13).addBox(0.0F, 0.0F, 0.0F, 14.0F, 0.0F, 14.0F);
        partdefinition.addOrReplaceChild("top", cubelistbuilder, PartPose.offsetAndRotation(1.0F, 16.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("bottom", cubelistbuilder, PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public static LayerDefinition createSidesLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, 0.0F, 0.0F, 14.0F, 16.0F, 0.0F, EnumSet.of(Direction.NORTH));
        partdefinition.addOrReplaceChild("back", cubelistbuilder, PartPose.offsetAndRotation(15.0F, 16.0F, 1.0F, 0.0F, 0.0F, (float)Math.PI));
        partdefinition.addOrReplaceChild("left", cubelistbuilder, PartPose.offsetAndRotation(1.0F, 16.0F, 1.0F, 0.0F, (-(float)Math.PI / 2F), (float)Math.PI));
        partdefinition.addOrReplaceChild("right", cubelistbuilder, PartPose.offsetAndRotation(15.0F, 16.0F, 15.0F, 0.0F, ((float)Math.PI / 2F), (float)Math.PI));
        partdefinition.addOrReplaceChild("front", cubelistbuilder, PartPose.offsetAndRotation(1.0F, 16.0F, 15.0F, (float)Math.PI, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 16, 16);
    }



    private static Material getSideMaterial(Optional<Item> item, DyeColor dyeColor) {
        if (item.isEmpty()) {
            Material material = new Material(Sheets.DECORATED_POT_SHEET, Identifier.withDefaultNamespace("entity/decorated_pot/decorated_pot_side_" + dyeColor.getName()));
            if (material != null) {
                return material;
            }
        } else {
            ResourceKey<DecoratedPotPattern> patternKey = DecoratedPotPatterns.getPatternFromItem(item.get());
            Material material = new Material(Sheets.DECORATED_POT_SHEET, patternKey.identifier().withPath(path -> "entity/decorated_pot/" + path.replace("_pottery_pattern", "") + "_pottery_pattern_" + dyeColor.getName()));
            if (material != null) {
                return material;
            }
        }
        return Sheets.DECORATED_POT_SIDE;
    }

    private static Material getBaseMaterial(DyeColor colour) {
        Material material = new Material(Sheets.DECORATED_POT_SHEET, Identifier.withDefaultNamespace("entity/decorated_pot/decorated_pot_base_" + colour.getName()));
        if (material != null) {
            return material;
        }
        return Sheets.DECORATED_POT_BASE;
    }

    public DyedDecoratedPotRenderState createRenderState() {
        return new DyedDecoratedPotRenderState();
    }

    public void extractRenderState(DyedDecoratedPotBlockEntity dyedDecoratedPot, DyedDecoratedPotRenderState renderState, float partialTick, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(dyedDecoratedPot, renderState, partialTick, cameraPosition, crumblingOverlay);
        renderState.decorations = dyedDecoratedPot.getDecorations();
        renderState.direction = dyedDecoratedPot.getDirection();
        renderState.dyeColour = dyedDecoratedPot.getDyeColor();
        DyedDecoratedPotBlockEntity.WobbleStyle decoratedpotblockentity$wobblestyle = dyedDecoratedPot.lastWobbleStyle;
        if (decoratedpotblockentity$wobblestyle != null && dyedDecoratedPot.getLevel() != null) {
            renderState.wobbleProgress = ((float)(dyedDecoratedPot.getLevel().getGameTime() - dyedDecoratedPot.wobbleStartedAtTick) + partialTick) / (float)decoratedpotblockentity$wobblestyle.duration;
        } else {
            renderState.wobbleProgress = 0.0F;
        }

    }

    public void submit(DyedDecoratedPotRenderState state, PoseStack poseStack, SubmitNodeCollector node, CameraRenderState camRenderState) {
        poseStack.pushPose();
        Direction direction = state.direction;
        poseStack.translate((double)0.5F, (double)0.0F, (double)0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - direction.toYRot()));
        poseStack.translate((double)-0.5F, (double)0.0F, (double)-0.5F);
        if (state.wobbleProgress >= 0.0F && state.wobbleProgress <= 1.0F) {
            if (state.wobbleStyle == WobbleStyle.POSITIVE) {
                float f = 0.015625F;
                float f1 = state.wobbleProgress * ((float)Math.PI * 2F);
                float f2 = -1.5F * (Mth.cos((double)f1) + 0.5F) * Mth.sin((double)(f1 / 2.0F));
                poseStack.rotateAround(Axis.XP.rotation(f2 * 0.015625F), 0.5F, 0.0F, 0.5F);
                float f3 = Mth.sin((double)f1);
                poseStack.rotateAround(Axis.ZP.rotation(f3 * 0.015625F), 0.5F, 0.0F, 0.5F);
            } else {
                float f4 = Mth.sin((double)(-state.wobbleProgress * 3.0F * (float)Math.PI)) * 0.125F;
                float f5 = 1.0F - state.wobbleProgress;
                poseStack.rotateAround(Axis.YP.rotation(f4 * f5), 0.5F, 0.0F, 0.5F);
            }
        }

        this.submit(poseStack, node, state.lightCoords, OverlayTexture.NO_OVERLAY, state.decorations, state.dyeColour,  0);
        poseStack.popPose();
    }

    public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, int packedOverlay, PotDecorations decorations, DyeColor dyeColor, int outlineColor) {
        RenderType rendertype = Sheets.DECORATED_POT_BASE.renderType(RenderTypes::entitySolid);
        TextureAtlasSprite textureatlassprite = this.materials.get(getBaseMaterial(dyeColor));
        nodeCollector.submitModelPart(this.neck, poseStack, rendertype, packedLight, packedOverlay, textureatlassprite, false, false, -1, (ModelFeatureRenderer.CrumblingOverlay)null, outlineColor);
        nodeCollector.submitModelPart(this.top, poseStack, rendertype, packedLight, packedOverlay, textureatlassprite, false, false, -1, (ModelFeatureRenderer.CrumblingOverlay)null, outlineColor);
        nodeCollector.submitModelPart(this.bottom, poseStack, rendertype, packedLight, packedOverlay, textureatlassprite, false, false, -1, (ModelFeatureRenderer.CrumblingOverlay)null, outlineColor);
        Material material = getSideMaterial(decorations.front(), dyeColor);
        nodeCollector.submitModelPart(this.frontSide, poseStack, material.renderType(RenderTypes::entitySolid), packedLight, packedOverlay, this.materials.get(material), false, false, -1, (ModelFeatureRenderer.CrumblingOverlay)null, outlineColor);
        Material material1 = getSideMaterial(decorations.back(), dyeColor);
        nodeCollector.submitModelPart(this.backSide, poseStack, material1.renderType(RenderTypes::entitySolid), packedLight, packedOverlay, this.materials.get(material1), false, false, -1, (ModelFeatureRenderer.CrumblingOverlay)null, outlineColor);
        Material material2 = getSideMaterial(decorations.left(), dyeColor);
        nodeCollector.submitModelPart(this.leftSide, poseStack, material2.renderType(RenderTypes::entitySolid), packedLight, packedOverlay, this.materials.get(material2), false, false, -1, (ModelFeatureRenderer.CrumblingOverlay)null, outlineColor);
        Material material3 = getSideMaterial(decorations.right(), dyeColor);
        nodeCollector.submitModelPart(this.rightSide, poseStack, material3.renderType(RenderTypes::entitySolid), packedLight, packedOverlay, this.materials.get(material3), false, false, -1, (ModelFeatureRenderer.CrumblingOverlay)null, outlineColor);
    }

    public void getExtents(Consumer<Vector3fc> output) {
        PoseStack posestack = new PoseStack();
        this.neck.getExtentsForGui(posestack, output);
        this.top.getExtentsForGui(posestack, output);
        this.bottom.getExtentsForGui(posestack, output);
    }

    public AABB getRenderBoundingBox(DyedDecoratedPotBlockEntity blockEntity) {
        BlockPos pos = blockEntity.getBlockPos();
        return new AABB((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)pos.getX() + (double)1.0F, (double)pos.getY() + 1.3, (double)pos.getZ() + (double)1.0F);
    }
}

