package com.kekecreations.arts_and_crafts.forge.client;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.client.renderer.entity.CustomDyeSheepRenderer;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@Mod.EventBusSubscriber(modid = ArtsAndCrafts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {


    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entity Renderers
        event.registerEntityRenderer(KekeEntityTypes.CUSTOM_DYE_SHEEP.get(), CustomDyeSheepRenderer::new);

    }


}
