package com.kekecreations.arts_and_crafts.client.renderer.entity.layer;

import com.kekecreations.arts_and_crafts.client.model.ACSheepFurModel;
import com.kekecreations.arts_and_crafts.client.model.ACSheepModel;
import com.kekecreations.arts_and_crafts.common.entity.ACSheep;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.SheepFurModel;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;

public class ACSheepFurLayer extends RenderLayer<ACSheep, ACSheepModel<ACSheep>> {
    private static final ResourceLocation SHEEP_FUR_LOCATION = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
    private final ACSheepFurModel<ACSheep> model;

    public ACSheepFurLayer(RenderLayerParent<ACSheep, ACSheepModel<ACSheep>> renderLayerParent, EntityModelSet entityModelSet) {
        super(renderLayerParent);
        this.model = new ACSheepFurModel(entityModelSet.bakeLayer(ModelLayers.SHEEP_FUR));
    }

    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, ACSheep sheep, float f, float g, float h, float j, float k, float l) {
        if (!sheep.isSheared()) {
            if (sheep.isInvisible()) {
                Minecraft minecraft = Minecraft.getInstance();
                boolean bl = minecraft.shouldEntityAppearGlowing(sheep);
                if (bl) {
                    ((ACSheepModel)this.getParentModel()).copyPropertiesTo(this.model);
                    this.model.prepareMobModel(sheep, f, g, h);
                    this.model.setupAnim(sheep, f, g, j, k, l);
                    VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.outline(SHEEP_FUR_LOCATION));
                    this.model.renderToBuffer(poseStack, vertexConsumer, i, LivingEntityRenderer.getOverlayCoords(sheep, 0.0F), 0.0F, 0.0F, 0.0F, 1.0F);
                }

            } else {
                float s;
                float t;
                float u;
                if (sheep.hasCustomName() && "jeb_".equals(sheep.getName().getString())) {
                    boolean m = true;
                    int n = sheep.tickCount / 25 + sheep.getId();
                    int o = DyeColor.values().length;
                    int p = n % o;
                    int q = (n + 1) % o;
                    float r = ((float)(sheep.tickCount % 25) + h) / 25.0F;
                    //float[] fs = Sheep.getColorArray(DyeColor.byId(p));
                    //float[] gs = Sheep.getColorArray(DyeColor.byId(q));
                    float[] fs = Sheep.getColorArray(DyeColor.byId(p));
                    float[] gs = Sheep.getColorArray(DyeColor.byId(q));
                    s = fs[0] * (1.0F - r) + gs[0] * r;
                    t = fs[1] * (1.0F - r) + gs[1] * r;
                    u = fs[2] * (1.0F - r) + gs[2] * r;
                } else {
                    //float[] hs = Sheep.getColorArray(sheep.getColor());
                    float[] hs = ACSheep.createSheepColor(sheep.getColor());
                    s = hs[0];
                    t = hs[1];
                    u = hs[2];
                }

                coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, SHEEP_FUR_LOCATION, poseStack, multiBufferSource, i, sheep, f, g, j, k, l, h, s, t, u);
            }
        }
    }
}
