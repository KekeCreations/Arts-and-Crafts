package com.kekecreations.arts_and_crafts.datagen.client;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.arts_and_crafts.datagen.client.util.ACModelTemplates;
import com.kekecreations.arts_and_crafts.datagen.client.util.ACTextureMapping;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.Objects;

public class ACModelProvider extends FabricModelProvider {

    public ACModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGen) {

        modelGen.createTrivialCube(ACBlocks.GYPSUM.get());
        modelGen.createTrivialCube(ACBlocks.GYPSUM_BRICKS.get());
        modelGen.createTrivialCube(ACBlocks.POLISHED_GYPSUM.get());

        modelGen.woodProvider(ACBlocks.CORK_LOG.get()).log(ACBlocks.CORK_LOG.get()).wood(ACBlocks.CORK_WOOD.get());
        modelGen.woodProvider(ACBlocks.STRIPPED_CORK_LOG.get()).log(ACBlocks.STRIPPED_CORK_LOG.get()).wood(ACBlocks.STRIPPED_CORK_WOOD.get());

        for (DyeColor colour : DyeColor.values()) {
            createEmptyFlowerPot(ACBlocks.getDyedFlowerPot(colour.getId()), colour, modelGen);

            flowerPotBlock(ACBlocks.getDyedPottedCorkSapling(colour), colour, "cork_sapling", "arts_and_crafts", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedOakSapling(colour), colour, "oak_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedSpruceSapling(colour), colour, "spruce_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedBirchSapling(colour), colour, "birch_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedJungleSapling(colour), colour, "jungle_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedAcaciaSapling(colour), colour, "acacia_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedCherrySapling(colour), colour, "cherry_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedDarkOakSapling(colour), colour, "dark_oak_sapling", "minecraft", modelGen);
            mangrovePropaguleFlowerPotBlock(ACBlocks.getDyedPottedMangrovePropagule(colour), colour,  modelGen);

            flowerPotBlock(ACBlocks.getDyedPottedCrimsonFungus(colour), colour, "crimson_fungus", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedCrimsonRoots(colour), colour, "crimson_roots_pot", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedWarpedFungus(colour), colour, "warped_fungus", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedWarpedRoots(colour), colour, "warped_roots_pot", "minecraft", modelGen);

            tintedFlowerPotBlock(ACBlocks.getDyedPottedFern(colour), colour, "fern", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedDandelion(colour), colour, "dandelion", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedPoppy(colour), colour, "poppy", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedBlueOrchid(colour), colour, "blue_orchid", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedAllium(colour), colour, "allium", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedAzureBluet(colour), colour, "azure_bluet", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedRedTulip(colour), colour, "red_tulip", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedOrangeTulip(colour), colour, "orange_tulip", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedWhiteTulip(colour), colour, "white_tulip", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedPinkTulip(colour), colour, "pink_tulip", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedOxeyeDaisy(colour), colour, "oxeye_daisy", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedCornflower(colour), colour, "cornflower", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedLilyOfTheValley(colour), colour, "lily_of_the_valley", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedWitherRose(colour), colour, "wither_rose", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedRedMushroom(colour), colour, "red_mushroom", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedBrownMushroom(colour), colour, "brown_mushroom", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedDeadBush(colour), colour, "dead_bush", "minecraft", modelGen);
            cactusFlowerPotBlock(ACBlocks.getDyedPottedCactus(colour), colour, modelGen);
            bambooFlowerPotBlock(ACBlocks.getDyedPottedBamboo(colour), colour, modelGen);
            azaleaFlowerPotBlock(ACBlocks.getDyedPottedAzalea(colour), colour, "potted_azalea_bush", modelGen);
            azaleaFlowerPotBlock(ACBlocks.getDyedPottedFloweringAzalea(colour), colour, "potted_flowering_azalea_bush", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedTorchFlower(colour), colour, "torchflower", "minecraft", modelGen);
        }

    }

    @Override
    public void generateItemModels(ItemModelGenerators modelGen) {

        for (DyeColor colour : DyeColor.values()) {
            modelGen.generateFlatItem(ACItems.getChalkStick(colour.getId()).asItem(), ModelTemplates.FLAT_HANDHELD_ITEM);
            modelGen.generateFlatItem(ACBlocks.getDyedFlowerPot(colour.getId()).asItem(), ModelTemplates.FLAT_ITEM);
            //decoratedPotItem(ACItems.getDyedDecoratedPotBlockItem(colours));
            modelGen.generateFlatItem(ACItems.getPaintBrush(colour.getId()).asItem(), ModelTemplates.FLAT_HANDHELD_ITEM);
        }
        modelGen.generateFlatItem(ACItems.BLEACHED_CHALK_STICK.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        modelGen.generateFlatItem(ACItems.CORK_BOAT.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.CORK_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.ROLL_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.RUINED_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.FINALE_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.GATEWAY_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.SUS_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.BLEACHDEW_PAINTBRUSH.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        modelGen.generateFlatItem(ACItems.BLEACHDEW.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACBlocks.CORK_DOOR.get().asItem(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACBlocks.CORK_SAPLING.get().asItem(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.CORK_SIGN.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.CORK_HANGING_SIGN.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.LOTUS_PISTILS.get(), ModelTemplates.FLAT_ITEM);

        //bedBlockItem(ACItems.BLEACHED_BED.get());
        //buttonInventory(ACBlocks.CORK_BUTTON.get().asItem(), "cork_planks");
    }


    /*
    public Variant flowerPotVariant(Identifier blockId) {
        MultiVariant variant = BlockModelGenerators.plainVariant(blockId);
        return MultiVariantGenerator.dispatch(variant)
                .with(PropertyDispatch.initial(VerticalSlabBlock.FACING, VerticalSlabBlock.SINGLE)
                        .select(Direction.NORTH, true, vertSlabModel.with(BlockModelGenerators.UV_LOCK))
                        .select(Direction.EAST, true, vertSlabModel.with(BlockModelGenerators.UV_LOCK).with(BlockModelGenerators.Y_ROT_90))
                        .select(Direction.SOUTH, true, vertSlabModel.with(BlockModelGenerators.UV_LOCK).with(BlockModelGenerators.Y_ROT_180))
                        .select(Direction.WEST, true, vertSlabModel.with(BlockModelGenerators.UV_LOCK).with(BlockModelGenerators.Y_ROT_270))
                        .select(Direction.NORTH, false, fullBlockModel.with(BlockModelGenerators.UV_LOCK))
                        .select(Direction.EAST, false, fullBlockModel.with(BlockModelGenerators.UV_LOCK))
                        .select(Direction.SOUTH, false, fullBlockModel.with(BlockModelGenerators.UV_LOCK))
                        .select(Direction.WEST, false, fullBlockModel.with(BlockModelGenerators.UV_LOCK))
                );
    }

     */


    public final void flowerPotBlock(Block flowerPot, DyeColor colour, String plant, String modID,  BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.flowerPotTextureMappings(modID, plant, colour);
        Identifier resourceLocation = ACModelTemplates.FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void cactusFlowerPotBlock(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = ACModelTemplates.CACTUS_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void bambooFlowerPotBlock(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = ACModelTemplates.BAMBOO_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void mangrovePropaguleFlowerPotBlock(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = ACModelTemplates.MANGROVE_PROPAGULE_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void azaleaFlowerPotBlock(Block flowerPot, DyeColor colour, String bush, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = Identifier.parse("ifyouevergetthisihavezerocluewhathappened");
        if (Objects.equals(bush, "potted_azalea_bush")) {
            resourceLocation = ACModelTemplates.AZALEA_BUSH_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        } else if (Objects.equals(bush, "potted_flowering_azalea_bush")) {
            resourceLocation = ACModelTemplates.FLOWERING_AZALEA_BUSH_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        }
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void tintedFlowerPotBlock(Block flowerPot, DyeColor colour, String plant, String modID,  BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.flowerPotTextureMappings(modID, plant, colour);
        Identifier resourceLocation = ACModelTemplates.TINTED_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void createEmptyFlowerPot(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = ACModelTemplates.EMPTY_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }
}
