package com.kekecreations.arts_and_crafts.client.renderer.entity;

import com.kekecreations.arts_and_crafts.client.renderer.entity.layers.CustomDyeSheepFurLayer;
import com.kekecreations.arts_and_crafts.common.entity.CustomDyeSheep;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(value= EnvType.CLIENT)
public class CustomDyeSheepRenderer extends MobRenderer<CustomDyeSheep, SheepModel<CustomDyeSheep>> {
    private static final ResourceLocation SHEEP_LOCATION = new ResourceLocation("textures/entity/sheep/sheep.png");

    public CustomDyeSheepRenderer(EntityRendererProvider.Context context) {
        super(context, new SheepModel(context.bakeLayer(ModelLayers.SHEEP)), 0.7f);
        this.addLayer(new CustomDyeSheepFurLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(CustomDyeSheep sheep) {
        return SHEEP_LOCATION;
    }
}
