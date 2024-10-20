package com.kekecreations.arts_and_crafts.client.renderer.entity;

import com.kekecreations.arts_and_crafts.client.model.ACSheepModel;
import com.kekecreations.arts_and_crafts.client.renderer.entity.layer.ACSheepFurLayer;
import com.kekecreations.arts_and_crafts.common.entity.ACSheep;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ACSheepRenderer extends MobRenderer<ACSheep, ACSheepModel<ACSheep>> {
    private static final ResourceLocation SHEEP_LOCATION = new ResourceLocation("textures/entity/sheep/sheep.png");

    public ACSheepRenderer(EntityRendererProvider.Context context) {
        super(context, new ACSheepModel<>(context.bakeLayer(ModelLayers.SHEEP)), 0.7F);
        this.addLayer(new ACSheepFurLayer(this, context.getModelSet()));
    }

    public ResourceLocation getTextureLocation(ACSheep sheep) {
        return SHEEP_LOCATION;
    }
}
