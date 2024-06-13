package com.kekecreations.arts_and_crafts.client.renderer.tile;

import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.util.DyedDecoratedPotUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraft.world.level.block.entity.PotDecorations;

import java.util.Objects;
import java.util.Optional;

public class DyedDecoratedPotBER implements BlockEntityRenderer<DyedDecoratedPotBlockEntity> {
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

    public DyedDecoratedPotBER(BlockEntityRendererProvider.Context context) {
        this.baseMaterial = Objects.requireNonNull(Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.BASE));
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


    public void render(DyedDecoratedPotBlockEntity decoratedPotBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        DyeColor colour = decoratedPotBlockEntity.getDyeColor();
        if (DyedDecoratedPotUtils.getDecoratedPotBase(colour) != null) {
            this.baseMaterial = DyedDecoratedPotUtils.getDecoratedPotBase(colour);
        }
        poseStack.pushPose();
        Direction direction = decoratedPotBlockEntity.getDirection();
        poseStack.translate(0.5, 0.0, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - direction.toYRot()));
        poseStack.translate(-0.5, 0.0, -0.5);
        DyedDecoratedPotBlockEntity.WobbleStyle wobbleStyle = decoratedPotBlockEntity.lastWobbleStyle;
        if (wobbleStyle != null && decoratedPotBlockEntity.getLevel() != null) {
            float g = ((float)(decoratedPotBlockEntity.getLevel().getGameTime() - decoratedPotBlockEntity.wobbleStartedAtTick) + f) / (float)wobbleStyle.duration;
            if (g >= 0.0F && g <= 1.0F) {
                float h;
                float k;
                if (wobbleStyle == DyedDecoratedPotBlockEntity.WobbleStyle.POSITIVE) {
                    h = 0.015625F;
                    k = g * 6.2831855F;
                    float l = -1.5F * (Mth.cos(k) + 0.5F) * Mth.sin(k / 2.0F);
                    poseStack.rotateAround(Axis.XP.rotation(l * 0.015625F), 0.5F, 0.0F, 0.5F);
                    float m = Mth.sin(k);
                    poseStack.rotateAround(Axis.ZP.rotation(m * 0.015625F), 0.5F, 0.0F, 0.5F);
                } else {
                    h = Mth.sin(-g * 3.0F * 3.1415927F) * 0.125F;
                    k = 1.0F - g;
                    poseStack.rotateAround(Axis.YP.rotation(h * k), 0.5F, 0.0F, 0.5F);
                }
            }
        }
        VertexConsumer vertexConsumer = this.baseMaterial.buffer(multiBufferSource, RenderType::entitySolid);
        this.neck.render(poseStack, vertexConsumer, i, j);
        this.top.render(poseStack, vertexConsumer, i, j);
        this.bottom.render(poseStack, vertexConsumer, i, j);
        PotDecorations decorations = decoratedPotBlockEntity.getDecorations();
        if (decorations.front().isPresent()) {
            this.renderSide(this.frontSide, poseStack, multiBufferSource, i, j, decorations.front().get(), decoratedPotBlockEntity);
        } else {
            this.renderSide(this.frontSide, poseStack, multiBufferSource, i, j, Items.BRICK, decoratedPotBlockEntity);
        }
        if (decorations.back().isPresent()) {
            this.renderSide(this.backSide, poseStack, multiBufferSource, i, j, decorations.back().get(), decoratedPotBlockEntity);
        } else {
            this.renderSide(this.backSide, poseStack, multiBufferSource, i, j, Items.BRICK, decoratedPotBlockEntity);
        }
        if (decorations.left().isPresent()) {
            this.renderSide(this.leftSide, poseStack, multiBufferSource, i, j, decorations.left().get(), decoratedPotBlockEntity);
        } else {
            this.renderSide(this.leftSide, poseStack, multiBufferSource, i, j, Items.BRICK, decoratedPotBlockEntity);
        }
        if (decorations.right().isPresent()) {
            this.renderSide(this.rightSide, poseStack, multiBufferSource, i, j, decorations.right().get(), decoratedPotBlockEntity);
        } else {
            this.renderSide(this.rightSide, poseStack, multiBufferSource, i, j, Items.BRICK, decoratedPotBlockEntity);
        }
        poseStack.popPose();
    }

    private void renderSide(ModelPart modelPart, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, Item item, DyedDecoratedPotBlockEntity pot) {
        Minecraft instance = Minecraft.getInstance();
        TextureAtlas textureAtlas = instance.getModelManager().getAtlas(Sheets.DECORATED_POT_SHEET);
        TextureAtlasSprite sprite =  textureAtlas.getSprite(renderMaterial(pot, item));
        VertexConsumer vertex = sprite.wrap(multiBufferSource.getBuffer(RenderType.entitySolid(Sheets.DECORATED_POT_SHEET)));
        modelPart.render(poseStack, vertex, i, j);
    }
    private ResourceLocation renderMaterial(DyedDecoratedPotBlockEntity potEntity, Item item) {
        ResourceKey<String> patternKey = DecoratedPotPatterns.getResourceKey(item);
        if (patternKey != null) {
            return patternKey.location().withPath(path -> "entity/decorated_pot/" + path + "_" + potEntity.getDyeColor().getName());
        } else {
            //return Objects.requireNonNull(DecoratedPotPatterns.getResourceKey(Items.BRICK)).location();
            return new ResourceLocation("entity/decorated_pot/decorated_pot_side_" + potEntity.getDyeColor().getName());
        }
    }
}