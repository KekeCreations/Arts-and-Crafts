package com.kekecreations.arts_and_crafts.client.renderer.tile.state;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.ACBedBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import com.mojang.math.Transformation;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
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
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.core.Direction;
import net.minecraft.util.Unit;
import net.minecraft.util.Util;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

public class ACBedBER implements BlockEntityRenderer<ACBedBlockEntity, BedRenderState> {
    private static final Map<Direction, Transformation> TRANSFORMATIONS = Util.makeEnumMap(Direction.class, ACBedBER::createModelTransform);
    private static final Set<Direction> VISIBLE_LEG_FACES;
    private final SpriteGetter sprites;
    private final Model.Simple headModel;
    private final Model.Simple footModel;

    public ACBedBER(BlockEntityRendererProvider.Context context) {
        this(context.sprites(), context.entityModelSet());
    }

    public ACBedBER(SpecialModelRenderer.BakingContext context) {
        this(context.sprites(), context.entityModelSet());
    }

    public ACBedBER(SpriteGetter sprites, EntityModelSet entityModelSet) {
        this.sprites = sprites;
        this.headModel = new Model.Simple(entityModelSet.bakeLayer(ModelLayers.BED_HEAD), RenderTypes::entitySolid);
        this.footModel = new Model.Simple(entityModelSet.bakeLayer(ModelLayers.BED_FOOT), RenderTypes::entitySolid);
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        Set<Direction> visibleBodyFaces = Util.allOfEnumExcept(Direction.UP);
        root.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F, visibleBodyFaces), PartPose.ZERO);
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 6).addBox(0.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F, VISIBLE_LEG_FACES), PartPose.rotation(((float)Math.PI / 2F), 0.0F, ((float)Math.PI / 2F)));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 18).addBox(-16.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F, VISIBLE_LEG_FACES), PartPose.rotation(((float)Math.PI / 2F), 0.0F, (float)Math.PI));
        return LayerDefinition.create(mesh, 64, 64);
    }

    public static LayerDefinition createFootLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        Set<Direction> visibleBodyFaces = Util.allOfEnumExcept(Direction.DOWN);
        root.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F, visibleBodyFaces), PartPose.ZERO);
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F, VISIBLE_LEG_FACES), PartPose.rotation(((float)Math.PI / 2F), 0.0F, 0.0F));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 12).addBox(-16.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F, VISIBLE_LEG_FACES), PartPose.rotation(((float)Math.PI / 2F), 0.0F, ((float)Math.PI * 1.5F)));
        return LayerDefinition.create(mesh, 64, 64);
    }

    public BedRenderState createRenderState() {
        return new BedRenderState();
    }

    public void extractRenderState(ACBedBlockEntity blockEntity, BedRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.color = blockEntity.getColor();
        state.facing = (Direction)blockEntity.getBlockState().getValue(BedBlock.FACING);
        state.part = (BedPart)blockEntity.getBlockState().getValue(BedBlock.PART);
        if (blockEntity.getLevel() != null) {
            DoubleBlockCombiner.NeighborCombineResult<? extends BedBlockEntity> combineResult = DoubleBlockCombiner.combineWithNeigbour(BlockEntityType.BED, BedBlock::getBlockType, BedBlock::getConnectedDirection, ChestBlock.FACING, blockEntity.getBlockState(), blockEntity.getLevel(), blockEntity.getBlockPos(), (levelAccessor, blockPos) -> false);
            state.lightCoords = ((Int2IntFunction)combineResult.apply(new BrightnessCombiner())).get(state.lightCoords);
        }

    }

    public void submit(BedRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        SpriteId sprite = new SpriteId(Sheets.BED_SHEET, ArtsAndCrafts.id("bed/bleached"));
        poseStack.pushPose();
        poseStack.mulPose(modelTransform(state.facing));
        this.submitPiece(state.part, sprite, poseStack, submitNodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, state.breakProgress, 0);
        poseStack.popPose();
    }

    public void submitPiece(BedPart part, SpriteId sprite, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, int overlayCoords, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress, int outlineColor) {
        Model.Simple model = this.getPieceModel(part);
        submitNodeCollector.submitModel(model, Unit.INSTANCE, poseStack, lightCoords, overlayCoords, -1, sprite, this.sprites, outlineColor, breakProgress);
    }

    private Model.Simple getPieceModel(BedPart part) {
        Model.Simple var10000;
        switch (part) {
            case HEAD -> var10000 = this.headModel;
            case FOOT -> var10000 = this.footModel;
            default -> throw new MatchException((String)null, (Throwable)null);
        }

        return var10000;
    }

    private static Transformation createModelTransform(Direction direction) {
        return new Transformation((new Matrix4f()).translation(0.0F, 0.5625F, 0.0F).rotate(Axis.XP.rotationDegrees(90.0F)).rotateAround(Axis.ZP.rotationDegrees(180.0F + direction.toYRot()), 0.5F, 0.5F, 0.5F));
    }

    public static Transformation modelTransform(Direction direction) {
        return (Transformation)TRANSFORMATIONS.get(direction);
    }

    public void getExtents(BedPart part, Consumer<Vector3fc> output) {
        PoseStack poseStack = new PoseStack();
        this.getPieceModel(part).root().getExtentsForGui(poseStack, output);
    }

    static {
        VISIBLE_LEG_FACES = Util.allOfEnumExcept(Direction.DOWN);
    }
}
