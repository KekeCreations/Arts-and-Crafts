package com.kekecreations.arts_and_crafts.core.fabric.datagen.client;

import com.kekecreations.arts_and_crafts.core.fabric.misc.KekeBlockFamilies;
import com.kekecreations.arts_and_crafts.core.fabric.misc.KekeModelTemplates;
import com.kekecreations.arts_and_crafts.core.fabric.misc.KekeTextureMapping;
import com.kekecreations.arts_and_crafts.core.fabric.registry.KekeFabricFlammableAndStrippableBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ArtsAndCraftsModelProvider extends FabricModelProvider {
    public ArtsAndCraftsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        for (DyeColor colours : DyeColor.values()) {
            KekeModelTemplates kekeModelTemplates = new KekeModelTemplates();
            blockStateModelGenerator.createTrivialBlock(KekeBlocks.getDyedFlowerPot(colours.getId()), KekeTextureMapping.flower_pot(KekeBlocks.getDyedFlowerPot(colours.getId())), KekeModelTemplates.FLOWER_POT);
            blockStateModelGenerator.createTrivialCube(KekeBlocks.getChalk(colours.getId()));

            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedOakSapling(colours), "oak_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedSpruceSapling(colours), "spruce_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedBirchSapling(colours), "birch_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedJungleSapling(colours), "jungle_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedAcaciaSapling(colours), "acacia_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedCherrySapling(colours), "cherry_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedDarkOakSapling(colours), "dark_oak_sapling", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedMangrovePropagule(colours, KekeBlocks.getDyedPottedMangrovePropagule(colours), "mangrove_propagule", kekeModelTemplates, blockStateModelGenerator);
            this.createCustomPottedFlowerPotWithPrefix(colours, KekeBlocks.getDyedPottedCorkSapling(colours), KekeBlocks.CORK_SAPLING.get(), KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);


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
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedOxeyeDaisy(colours), "oxeye_daisy", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedCornflower(colours), "cornflower", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedLilyOfTheValley(colours), "lily_of_the_valley", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedWitherRose(colours), "wither_rose", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedRedMushroom(colours), "red_mushroom", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedBrownMushroom(colours), "brown_mushroom", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedDeadBush(colours), "dead_bush", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);
            this.createCustomPottedCactus(colours, KekeBlocks.getDyedPottedCactus(colours), "cactus", kekeModelTemplates, blockStateModelGenerator);
            this.createCustomPottedBamboo(colours, KekeBlocks.getDyedPottedBamboo(colours), "bamboo", kekeModelTemplates, blockStateModelGenerator);
            this.createCustomPottedAzalea(colours, KekeBlocks.getDyedPottedAzalea(colours), "potted_azalea_bush", kekeModelTemplates, blockStateModelGenerator);
            this.createCustomPottedAzalea(colours, KekeBlocks.getDyedPottedFloweringAzalea(colours), "potted_flowering_azalea_bush", kekeModelTemplates, blockStateModelGenerator);
            this.createCustomPottedFlowerPot(colours, KekeBlocks.getDyedPottedTorchFlower(colours), "torchflower", KekeModelTemplates.TintState.NOT_TINTED, blockStateModelGenerator);

        }

        //DYED DECORATED POTS
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("white_decorated_pot"), Blocks.WHITE_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.WHITE.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("orange_decorated_pot"), Blocks.ORANGE_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.ORANGE.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("magenta_decorated_pot"), Blocks.MAGENTA_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.MAGENTA.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("light_blue_decorated_pot"), Blocks.LIGHT_BLUE_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.LIGHT_BLUE.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("yellow_decorated_pot"), Blocks.YELLOW_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.YELLOW.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("lime_decorated_pot"), Blocks.LIME_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.LIME.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("pink_decorated_pot"), Blocks.PINK_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.PINK.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("gray_decorated_pot"), Blocks.GRAY_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.GRAY.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("light_gray_decorated_pot"), Blocks.LIGHT_GRAY_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.LIGHT_GRAY.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("cyan_decorated_pot"), Blocks.CYAN_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.CYAN.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("purple_decorated_pot"), Blocks.PURPLE_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.PURPLE.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("blue_decorated_pot"), Blocks.BLUE_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.BLUE.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("brown_decorated_pot"), Blocks.BROWN_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.BROWN.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("green_decorated_pot"), Blocks.GREEN_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.GREEN.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("red_decorated_pot"), Blocks.RED_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.RED.getId()));
        blockStateModelGenerator.blockEntityModels(ModelLocationUtils.decorateBlockModelLocation("black_decorated_pot"), Blocks.BLACK_TERRACOTTA).createWithoutBlockItem(KekeBlocks.getDyedDecoratedPot(DyeColor.BLACK.getId()));



        blockStateModelGenerator.woodProvider(KekeBlocks.CORK_LOG.get()).logWithHorizontal(KekeBlocks.CORK_LOG.get()).wood(KekeBlocks.CORK_WOOD.get());
        blockStateModelGenerator.woodProvider(KekeBlocks.STRIPPED_CORK_LOG.get()).logWithHorizontal(KekeBlocks.STRIPPED_CORK_LOG.get()).wood(KekeBlocks.STRIPPED_CORK_WOOD.get());
        blockStateModelGenerator.createHangingSign(KekeBlocks.STRIPPED_CORK_LOG.get(), KekeBlocks.CORK_HANGING_SIGN.get(), KekeBlocks.CORK_WALL_HANGING_SIGN.get());
        blockStateModelGenerator.createTrivialCube(KekeBlocks.CORK.get());
        blockStateModelGenerator.createTrivialCube(KekeBlocks.SMOOTH_CORK.get());
        blockStateModelGenerator.createTrivialCube(KekeBlocks.CORK_LEAVES.get());
        blockStateModelGenerator.createPlant(KekeBlocks.CORK_SAPLING.get(), KekeBlocks.POTTED_CORK_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);

        KekeBlockFamilies.getFamilies().filter(BlockFamily::shouldGenerateModel).forEach(family -> blockStateModelGenerator.family(family.getBaseBlock()).generateFor((BlockFamily)family));

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        for(DyeColor colours : DyeColor.values()) {
            itemModelGenerator.generateFlatItem(KekeItems.getChalkStick(colours.getId()), ModelTemplates.FLAT_HANDHELD_ITEM);
            itemModelGenerator.generateFlatItem(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(KekeBlocks.getDyedDecoratedPot(colours.getId()).asItem(), KekeModelTemplates.DECORATED_POT_ITEM);
            itemModelGenerator.generateFlatItem(KekeItems.getPaintBrush(colours.getId()), ModelTemplates.FLAT_HANDHELD_ITEM);
        }
        itemModelGenerator.generateFlatItem(KekeItems.CORK_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(KekeItems.CORK_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(KekeItems.ROLL_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(KekeItems.POT_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(KekeItems.IMPOSTER_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
    }

    public final void createCustomPottedFlowerPot(DyeColor dyeColor, Block block, String string, KekeModelTemplates.TintState tintState, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = KekeTextureMapping.customPottedPlant(dyeColor, string);
        ResourceLocation resourceLocation = tintState.getCrossPot().create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(blockModelGenerators.createSimpleBlock(block, resourceLocation));
    }
    public final void createCustomPottedFlowerPotWithPrefix(DyeColor dyeColor, Block block, Block block2, KekeModelTemplates.TintState tintState, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = KekeTextureMapping.customPottedPlantWithPrefix(dyeColor, block2);
        ResourceLocation resourceLocation = tintState.getCrossPot().create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(blockModelGenerators.createSimpleBlock(block, resourceLocation));
    }

    public final void createCustomPottedMangrovePropagule(DyeColor dyeColor, Block block, String string, KekeModelTemplates tintState, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = KekeTextureMapping.customMangrovePropagulePottedPlant(dyeColor, string);
        ResourceLocation resourceLocation = tintState.getPottedMangrovePropagule().create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(blockModelGenerators.createSimpleBlock(block, resourceLocation));
    }

    public final void createCustomPottedCactus(DyeColor dyeColor, Block block, String string, KekeModelTemplates tintState, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = KekeTextureMapping.customCactusPottedPlant(dyeColor, string);
        ResourceLocation resourceLocation = tintState.getPottedCactus().create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(blockModelGenerators.createSimpleBlock(block, resourceLocation));
    }
    public final void createCustomPottedBamboo(DyeColor dyeColor, Block block, String string, KekeModelTemplates tintState, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = KekeTextureMapping.customBambooPottedPlant(dyeColor, string);
        ResourceLocation resourceLocation = tintState.getPottedBamboo().create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(blockModelGenerators.createSimpleBlock(block, resourceLocation));
    }
    public final void createCustomPottedAzalea(DyeColor dyeColor, Block block, String string, KekeModelTemplates tintState, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = KekeTextureMapping.customAzaleaBushPottedPlant(dyeColor, string);
        ResourceLocation resourceLocation = tintState.getPottedAzalea().create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(blockModelGenerators.createSimpleBlock(block, resourceLocation));
    }

}
