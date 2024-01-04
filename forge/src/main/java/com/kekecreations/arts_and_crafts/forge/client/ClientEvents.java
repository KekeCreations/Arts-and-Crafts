package com.kekecreations.arts_and_crafts.forge.client;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.client.particle.ChalkDustParticle;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@Mod.EventBusSubscriber(modid = ArtsAndCrafts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {



    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent registerParticleProvidersEvent) {
        for (DyeColor colours : DyeColor.values()) {
            registerParticleProvidersEvent.registerSpriteSet(KekeParticles.getChalkDrawParticle(colours), ChalkDustParticle.Factory::new);
        }
    }
    @SubscribeEvent
    public static void registerBlockColours(RegisterColorHandlersEvent.Block registerColorHandlersEvent) {
        for (DyeColor colours : DyeColor.values()) {
            registerColorHandlersEvent.register((blockState, blockAndTintGetter, blockPos, i) -> {
                if (blockAndTintGetter == null || blockPos == null) {
                    return GrassColor.getDefaultColor();
                }
                return BiomeColors.getAverageGrassColor(blockAndTintGetter, blockPos);
            }, KekeBlocks.getDyedPottedFern(colours));
        }
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        for (DyeColor colours : DyeColor.values()) {
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getChalkDust(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCrimsonFungus(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCrimsonRoots(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedWarpedFungus(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedWarpedRoots(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedOakSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedSpruceSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedBirchSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedAcaciaSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedJungleSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCherrySapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedDarkOakSapling(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedMangrovePropagule(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedFern(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedDandelion(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedPoppy(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedBlueOrchid(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedAllium(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedAzureBluet(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedRedTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedOrangeTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedWhiteTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedPinkTulip(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedOxeyeDaisy(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCornflower(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedLilyOfTheValley(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedWitherRose(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedRedMushroom(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedBrownMushroom(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedDeadBush(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedCactus(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedBamboo(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedAzalea(colours), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(KekeBlocks.getDyedPottedFloweringAzalea(colours), RenderType.cutout());
        }
    }


}
