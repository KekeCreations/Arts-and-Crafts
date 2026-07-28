package com.kekecreations.arts_and_crafts.client;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.client.renderer.entity.FloatingBlockRenderer;
import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@EventBusSubscriber(modid = ArtsAndCrafts.MOD_ID,  value = Dist.CLIENT)
public class ClientEvents {


    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entity Renderers
        event.registerEntityRenderer((EntityType<? extends FloatingBlockEntity>) ACEntityTypes.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        //event.registerEntityRenderer(ACEntityTypes.BOAT.get(), context -> new ACBoatRenderer(context, false));
        //event.registerEntityRenderer(ACEntityTypes.CHEST_BOAT.get(), context -> new ACBoatRenderer(context, true));
        //event.registerBlockEntityRenderer(ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), DyedDecoratedPotBER::new);
        //event.registerBlockEntityRenderer(ACEntityTypes.CUSTOM_BED_BLOCK_ENTITY.get(), ACBedBER::new);
    }
}
