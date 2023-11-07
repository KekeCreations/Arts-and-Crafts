package com.kekecreations.arts_and_crafts.client.renderer.entity.layers;

import com.kekecreations.arts_and_crafts.common.entity.CustomDyeSheep;
import com.kekecreations.arts_and_crafts.core.registry.KekeDyeColours;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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

@Environment(value= EnvType.CLIENT)
public class CustomDyeSheepFurLayer extends RenderLayer<CustomDyeSheep, SheepModel<CustomDyeSheep>> {
    private static final ResourceLocation SHEEP_FUR_LOCATION = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
    private final SheepFurModel<CustomDyeSheep> model;

    public CustomDyeSheepFurLayer(RenderLayerParent<CustomDyeSheep, SheepModel<CustomDyeSheep>> renderLayerParent, EntityModelSet entityModelSet) {
        super(renderLayerParent);
        this.model = new SheepFurModel(entityModelSet.bakeLayer(ModelLayers.SHEEP_FUR));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CustomDyeSheep sheep, float f, float g, float h, float j, float k, float l) {
        float u;
        float t;
        float s;
        if (sheep.isSheared()) {
            return;
        }
        if (sheep.isInvisible()) {
            Minecraft minecraft = Minecraft.getInstance();
            boolean bl = minecraft.shouldEntityAppearGlowing(sheep);
            if (bl) {
                ((SheepModel)this.getParentModel()).copyPropertiesTo(this.model);
                this.model.prepareMobModel(sheep, f, g, h);
                this.model.setupAnim(sheep, f, g, j, k, l);
                VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.outline(SHEEP_FUR_LOCATION));
                this.model.renderToBuffer(poseStack, vertexConsumer, i, LivingEntityRenderer.getOverlayCoords(sheep, 0.0f), 0.0f, 0.0f, 0.0f, 1.0f);
            }
            return;
        }
        if (sheep.hasCustomName() && "jeb_".equals(sheep.getName().getString())) {
            int m = 25;
            int n = sheep.tickCount / 25 + sheep.getId();
            int o = KekeDyeColours.values().length;
            int p = n % o;
            int q = (n + 1) % o;
            float r = ((float)(sheep.tickCount % 25) + h) / 25.0f;
            float[] fs = CustomDyeSheep.getColorArray(KekeDyeColours.byId(p));
            float[] gs = CustomDyeSheep.getColorArray(KekeDyeColours.byId(q));
            s = fs[0] * (1.0f - r) + gs[0] * r;
            t = fs[1] * (1.0f - r) + gs[1] * r;
            u = fs[2] * (1.0f - r) + gs[2] * r;
        } else {
            float[] hs = CustomDyeSheep.getColorArray(sheep.getColour());
            s = hs[0];
            t = hs[1];
            u = hs[2];
        }
        coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, SHEEP_FUR_LOCATION, poseStack, multiBufferSource, i, sheep, f, g, j, k, l, h, s, t, u);
    }
}

