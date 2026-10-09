package com.kekecreations.arts_and_crafts.client.renderer.tile.state;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.ACBedBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.function.Consumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.renderer.blockentity.state.BedRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

public class ACBedBER implements BlockEntityRenderer<ACBedBlockEntity, BedRenderState> {
    private final MaterialSet materials;
    private final Model.Simple headModel;
    private final Model.Simple footModel;

    public ACBedBER(BlockEntityRendererProvider.Context context) {
        this(context.materials(), context.entityModelSet());
    }

    public ACBedBER(SpecialModelRenderer.BakingContext context) {
        this(context.materials(), context.entityModelSet());
    }

    public ACBedBER(MaterialSet materials, EntityModelSet modelSet) {
        this.materials = materials;
        this.headModel = new Model.Simple(modelSet.bakeLayer(ModelLayers.BED_HEAD), RenderTypes::entitySolid);
        this.footModel = new Model.Simple(modelSet.bakeLayer(ModelLayers.BED_FOOT), RenderTypes::entitySolid);
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild(
                "left_leg",
                CubeListBuilder.create().texOffs(50, 6).addBox(0.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F),
                PartPose.rotation((float) (Math.PI / 2), 0.0F, (float) (Math.PI / 2))
        );
        partdefinition.addOrReplaceChild(
                "right_leg",
                CubeListBuilder.create().texOffs(50, 18).addBox(-16.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F),
                PartPose.rotation((float) (Math.PI / 2), 0.0F, (float) Math.PI)
        );
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition createFootLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild(
                "left_leg",
                CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F),
                PartPose.rotation((float) (Math.PI / 2), 0.0F, 0.0F)
        );
        partdefinition.addOrReplaceChild(
                "right_leg",
                CubeListBuilder.create().texOffs(50, 12).addBox(-16.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F),
                PartPose.rotation((float) (Math.PI / 2), 0.0F, (float) (Math.PI * 3.0 / 2.0))
        );
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public BedRenderState createRenderState() {
        return new BedRenderState();
    }

    public void extractRenderState(
            ACBedBlockEntity p_445886_, BedRenderState p_447090_, float p_446336_, Vec3 p_445891_, ModelFeatureRenderer.@Nullable CrumblingOverlay p_446152_
    ) {
        BlockEntityRenderer.super.extractRenderState(p_445886_, p_447090_, p_446336_, p_445891_, p_446152_);
        p_447090_.color = p_445886_.getColor();
        p_447090_.facing = p_445886_.getBlockState().getValue(BedBlock.FACING);
        p_447090_.isHead = p_445886_.getBlockState().getValue(BedBlock.PART) == BedPart.HEAD;
        if (p_445886_.getLevel() != null) {
            DoubleBlockCombiner.NeighborCombineResult<? extends BedBlockEntity> neighborcombineresult = DoubleBlockCombiner.combineWithNeigbour(
                    BlockEntityType.BED,
                    BedBlock::getBlockType,
                    BedBlock::getConnectedDirection,
                    ChestBlock.FACING,
                    p_445886_.getBlockState(),
                    p_445886_.getLevel(),
                    p_445886_.getBlockPos(),
                    (p_112202_, p_112203_) -> false
            );
            p_447090_.lightCoords = neighborcombineresult.apply(new BrightnessCombiner<>()).get(p_447090_.lightCoords);
        }
    }

    public void submit(BedRenderState p_445609_, PoseStack p_439782_, SubmitNodeCollector p_439369_, CameraRenderState p_451216_) {
        Material material = new Material(Sheets.BED_SHEET,  ArtsAndCrafts.id("entity/bed/bleached"));
        this.submitPiece(
                p_439782_,
                p_439369_,
                p_445609_.isHead ? this.headModel : this.footModel,
                p_445609_.facing,
                material,
                p_445609_.lightCoords,
                OverlayTexture.NO_OVERLAY,
                false,
                p_445609_.breakProgress,
                0
        );
    }

    public void submitSpecial(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, int packedOverlay, Material material, int outlineColor) {
        this.submitPiece(poseStack, nodeCollector, this.headModel, Direction.SOUTH, material, packedLight, packedOverlay, false, null, outlineColor);
        this.submitPiece(poseStack, nodeCollector, this.footModel, Direction.SOUTH, material, packedLight, packedOverlay, true, null, outlineColor);
    }

    private void submitPiece(
            PoseStack poseStack,
            SubmitNodeCollector nodeCollector,
            Model.Simple model,
            Direction direction,
            Material material,
            int packedLight,
            int packedOverlay,
            boolean isFeet,
            ModelFeatureRenderer.@Nullable CrumblingOverlay crumblingOverlay,
            int outlineColor
    ) {
        poseStack.pushPose();
        preparePose(poseStack, isFeet, direction);
        nodeCollector.submitModel(
                model,
                Unit.INSTANCE,
                poseStack,
                material.renderType(RenderTypes::entitySolid),
                packedLight,
                packedOverlay,
                -1,
                this.materials.get(material),
                outlineColor,
                crumblingOverlay
        );
        poseStack.popPose();
    }

    private static void preparePose(PoseStack poseStack, boolean isFeet, Direction direction) {
        poseStack.translate(0.0F, 0.5625F, isFeet ? -1.0F : 0.0F);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F + direction.toYRot()));
        poseStack.translate(-0.5F, -0.5F, -0.5F);
    }

    public void getExtents(Consumer<Vector3fc> output) {
        PoseStack posestack = new PoseStack();
        preparePose(posestack, false, Direction.SOUTH);
        this.headModel.root().getExtentsForGui(posestack, output);
        posestack.setIdentity();
        preparePose(posestack, true, Direction.SOUTH);
        this.footModel.root().getExtentsForGui(posestack, output);
    }
}
