package com.kekecreations.arts_and_crafts.fabric.core.datagen.client;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlockFamilies;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import com.kekecreations.arts_and_crafts.fabric.core.misc.KekeModelTemplates;
import com.kekecreations.arts_and_crafts.fabric.core.misc.KekeTextureMapping;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

public class ArtsAndCraftsModelProvider extends FabricModelProvider {
    public ArtsAndCraftsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        for (DyeColor colours : DyeColor.values()) {
            KekeModelTemplates kekeModelTemplates = new KekeModelTemplates();
            //this.createEmptyFlowerPot(KekeBlocks.getFlowerPots(colours), BlockModelGenerators.TintState.NOT_TINTED, blockStateModelGenerator);
            blockStateModelGenerator.createTrivialBlock(KekeBlocks.getDyedFlowerPot(colours), KekeTextureMapping.flower_pot(KekeBlocks.getDyedFlowerPot(colours)), KekeModelTemplates.FLOWER_POT);

            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedOakSapling(colours), "oak_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedSpruceSapling(colours), "spruce_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedBirchSapling(colours), "birch_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedJungleSapling(colours), "jungle_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedAcaciaSapling(colours), "acacia_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedCherrySapling(colours), "cherry_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedDarkOakSapling(colours), "dark_oak_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedMangrovePropagule(colours, KekeBlocks.getDyedPottedMangrovePropagule(colours), "mangrove_propagule", kekeModelTemplates, blockStateModelGenerator);


            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedCrimsonFungus(colours), "crimson_fungus", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedCrimsonRoots(colours), "crimson_roots_pot", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedWarpedFungus(colours), "warped_fungus", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedWarpedRoots(colours), "warped_roots_pot", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);

            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedFern(colours), "fern", KekeModelTemplates.TintState.TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedDandelion(colours), "dandelion", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedPoppy(colours), "poppy", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedBlueOrchid(colours), "blue_orchid", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedAllium(colours), "allium", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedAzureBluet(colours), "azure_bluet", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedRedTulip(colours), "red_tulip", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedOrangeTulip(colours), "orange_tulip", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedWhiteTulip(colours), "white_tulip", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedPinkTulip(colours), "pink_tulip", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);

        }


        KekeBlockFamilies.getFamilies().filter(BlockFamily::shouldGenerateModel).forEach(family -> blockStateModelGenerator.family(family.getBaseBlock()).generateFor((BlockFamily)family));

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        for(DyeColor colours : DyeColor.values()) {
            itemModelGenerator.generateFlatItem(KekeItems.getChalkStick(colours), ModelTemplates.FLAT_HANDHELD_ITEM);
            itemModelGenerator.generateFlatItem(KekeBlocks.getDyedFlowerPot(colours).asItem(), ModelTemplates.FLAT_ITEM);
        }
        //itemModelGenerator.generateFlatItem(KekeItems.WHITE_CHALK_STICK.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    public final void createCustomPottedFlowerPot(DyeColor dyeColor, Block block, String string, KekeModelTemplates.TintState tintState, BlockModelGenerators blockModelGenerators) {
        //blockModelGenerators.createCrossBlockWithDefaultItem(block, tintState);
        TextureMapping textureMapping = KekeTextureMapping.customPottedPlant(dyeColor, string);
        ResourceLocation resourceLocation = tintState.getCrossPot().create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(blockModelGenerators.createSimpleBlock(block, resourceLocation));
    }

    public final void createCustomPottedMangrovePropagule(DyeColor dyeColor, Block block, String string, KekeModelTemplates tintState, BlockModelGenerators blockModelGenerators) {
        //blockModelGenerators.createCrossBlockWithDefaultItem(block, tintState);
        TextureMapping textureMapping = KekeTextureMapping.customMangrovePropagulePottedPlant(dyeColor, string);
        ResourceLocation resourceLocation = tintState.getPottedMangrovePropagule().create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(blockModelGenerators.createSimpleBlock(block, resourceLocation));
    }
}
