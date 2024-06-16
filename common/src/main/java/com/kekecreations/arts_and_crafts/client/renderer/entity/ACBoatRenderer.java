package com.kekecreations.arts_and_crafts.client.renderer.entity;

import com.google.common.collect.ImmutableMap;
import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.ACBoat;
import com.kekecreations.arts_and_crafts.common.entity.ACChestBoat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.WaterPatchModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import org.joml.Quaternionf;

import java.util.Map;
import java.util.stream.Stream;


public class ACBoatRenderer extends EntityRenderer<Boat> {
    public static final ModelLayerLocation BOAT = new ModelLayerLocation(ArtsAndCrafts.id("boat"), "main");
    public static final ModelLayerLocation CHEST_BOAT = new ModelLayerLocation(ArtsAndCrafts.id("chest_boat"), "main");

    private final Map<ACBoat.WoodType, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public ACBoatRenderer(EntityRendererProvider.Context context, boolean chestBoat) {
        super(context);

        this.boatResources = Stream.of(ACBoat.WoodType.values()).collect(ImmutableMap.toImmutableMap(type -> {
            return type;
        }, type -> {
            return Pair.of(getTextureLocation(type, chestBoat), createBoatModel(context, type, chestBoat));
        }));
    }

    public void render(Boat boat, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        matrixStack.pushPose();
        matrixStack.translate(0.0F, 0.375F, 0.0F);
        matrixStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        float f = (float)boat.getHurtTime() - partialTicks;
        float g = boat.getDamage() - partialTicks;
        if (g < 0.0F) {
            g = 0.0F;
        }

        if (f > 0.0F) {
            matrixStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(f) * f * g / 10.0F * (float)boat.getHurtDir()));
        }

        float h = boat.getBubbleAngle(partialTicks);
        if (!Mth.equal(h, 0.0F)) {
            matrixStack.mulPose((new Quaternionf()).setAngleAxis(boat.getBubbleAngle(partialTicks) * 0.017453292F, 1.0F, 0.0F, 1.0F));
        }

        Pair<ResourceLocation, ListModel<Boat>> pair = this.getBoatPair(boat);
        ResourceLocation resourceLocation = pair.getFirst();
        ListModel<Boat> listModel = pair.getSecond();
        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        matrixStack.mulPose(Axis.YP.rotationDegrees(90.0F));
        listModel.setupAnim(boat, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = buffer.getBuffer(listModel.renderType(resourceLocation));
        listModel.renderToBuffer(matrixStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        if (!boat.isUnderWater()) {
            VertexConsumer vertexConsumer2 = buffer.getBuffer(RenderType.waterMask());
            if (listModel instanceof WaterPatchModel waterPatchModel) {
                waterPatchModel.waterPatch().render(matrixStack, vertexConsumer2, packedLight, OverlayTexture.NO_OVERLAY);
            }
        }

        matrixStack.popPose();
        super.render(boat, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context context, ACBoat.WoodType type, boolean chestBoat) {
        ModelPart modelPart = context.bakeLayer(chestBoat ? CHEST_BOAT : BOAT);

        return chestBoat ? new ChestBoatModel(modelPart) : new BoatModel(modelPart);
    }

    private static ResourceLocation getTextureLocation(ACBoat.WoodType type, boolean chestBoat) {
        //ResourceLocation location = SketchBuiltInRegistries.BOAT_TYPE.getKey(type);

        String path = chestBoat ? "textures/entity/chest_boat/" + type.name().toLowerCase() + ".png" : "textures/entity/boat/" + type.name().toLowerCase() + ".png";
        return ArtsAndCrafts.id(path);
    }

    public ResourceLocation getTextureLocation(Boat boat) {
        return this.getBoatPair(boat).getFirst();
    }

    private Pair<ResourceLocation, ListModel<Boat>> getBoatPair(Boat boat) {
        if (boat instanceof ACBoat customBoat) {
            return boatResources.get(customBoat.getBoatWoodType());
        }
        if (boat instanceof ACChestBoat customBoat) {
            return boatResources.get(customBoat.getBoatWoodType());
        }
        return boatResources.get(ACBoat.WoodType.CORK);
    }
}