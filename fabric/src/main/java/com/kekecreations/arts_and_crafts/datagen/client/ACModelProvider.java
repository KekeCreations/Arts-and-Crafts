package com.kekecreations.arts_and_crafts.datagen.client;

import com.kekecreations.arts_and_crafts.common.util.PietraforteColour;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.arts_and_crafts.datagen.client.util.ACModelTemplates;
import com.kekecreations.arts_and_crafts.datagen.client.util.ACTextureMapping;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Objects;

public class ACModelProvider extends FabricModelProvider {

    public ACModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGen) {

        modelGen.family(ACBlocks.GYPSUM.get())
                .stairs(ACBlocks.GYPSUM_STAIRS.get())
                .slab(ACBlocks.GYPSUM_SLAB.get())
                .wall(ACBlocks.GYPSUM_WALL.get());

        modelGen.family(ACBlocks.GYPSUM_BRICKS.get())
                .stairs(ACBlocks.GYPSUM_BRICK_STAIRS.get())
                .slab(ACBlocks.GYPSUM_BRICK_SLAB.get())
                .wall(ACBlocks.GYPSUM_BRICK_WALL.get());

        modelGen.family(ACBlocks.POLISHED_GYPSUM.get())
                .stairs(ACBlocks.POLISHED_GYPSUM_STAIRS.get())
                .slab(ACBlocks.POLISHED_GYPSUM_SLAB.get())
                .wall(ACBlocks.POLISHED_GYPSUM_WALL.get());

        modelGen.woodProvider(ACBlocks.CORK_LOG.get()).log(ACBlocks.CORK_LOG.get()).wood(ACBlocks.CORK_WOOD.get());
        modelGen.woodProvider(ACBlocks.STRIPPED_CORK_LOG.get()).log(ACBlocks.STRIPPED_CORK_LOG.get()).wood(ACBlocks.STRIPPED_CORK_WOOD.get());
        modelGen.createTrivialCube(ACBlocks.CORK.get());
        modelGen.createTrivialCube(ACBlocks.SMOOTH_CORK.get());

        modelGen.family(ACBlocks.CORK_PLANKS.get())
                .stairs(ACBlocks.CORK_STAIRS.get())
                .slab(ACBlocks.CORK_SLAB.get())
                .fence(ACBlocks.CORK_FENCE.get())
                .fenceGate(ACBlocks.CORK_FENCE_GATE.get())
                .button(ACBlocks.CORK_BUTTON.get())
                .pressurePlate(ACBlocks.CORK_PRESSURE_PLATE.get());

        //BLEACHED
        modelGen.createTrivialCube(ACBlocks.BLEACHED_CONCRETE.get());
        modelGen.createTrivialCube(ACBlocks.BLEACHED_WOOL.get());
        modelGen.createTrivialCube(ACBlocks.BLEACHED_CHALK.get());

        //SHINGLES
        modelGen.family(ACBlocks.TERRACOTTA_SHINGLES.get())
                .stairs(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get())
                .slab(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get())
                .wall(ACBlocks.TERRACOTTA_SHINGLE_WALL.get());

        //SOAPSTONE
        modelGen.family(ACBlocks.SOAPSTONE.get())
                .stairs(ACBlocks.SOAPSTONE_STAIRS.get())
                .slab(ACBlocks.SOAPSTONE_SLAB.get())
                .wall(ACBlocks.SOAPSTONE_WALL.get());

        modelGen.family(ACBlocks.SOAPSTONE_BRICKS.get())
                .stairs(ACBlocks.SOAPSTONE_BRICK_STAIRS.get())
                .slab(ACBlocks.SOAPSTONE_BRICK_SLAB.get())
                .wall(ACBlocks.SOAPSTONE_BRICK_WALL.get());

        modelGen.family(ACBlocks.POLISHED_SOAPSTONE.get())
                .stairs(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get())
                .slab(ACBlocks.POLISHED_SOAPSTONE_SLAB.get())
                .wall(ACBlocks.POLISHED_SOAPSTONE_WALL.get());

        for (PietraforteColour colour : PietraforteColour.values()) {
            modelGen.createAxisAlignedPillarBlock(ACBlocks.getPietrafortePillar(colour), TexturedModel.COLUMN);
            modelGen.createTrivialCube(ACBlocks.getChiseledPietraforte(colour));
            modelGen.family(ACBlocks.getCobbledPietraforte(colour))
                    .stairs(ACBlocks.getCobbledPietraforteStairs(colour))
                    .slab(ACBlocks.getCobbledPietraforteSlab(colour))
                    .wall(ACBlocks.getCobbledPietraforteWall(colour));

            modelGen.family(ACBlocks.getPietraforte(colour))
                    .stairs(ACBlocks.getPietraforteStairs(colour))
                    .slab(ACBlocks.getPietraforteSlab(colour))
                    .wall(ACBlocks.getPietraforteWall(colour));

            modelGen.family(ACBlocks.getPietraforteBricks(colour))
                    .stairs(ACBlocks.getPietraforteBrickStairs(colour))
                    .slab(ACBlocks.getPietraforteBrickSlab(colour))
                    .wall(ACBlocks.getPietraforteBrickWall(colour));

            modelGen.family(ACBlocks.getCutPietraforte(colour))
                    .stairs(ACBlocks.getCutPietraforteStairs(colour))
                    .slab(ACBlocks.getCutPietraforteSlab(colour))
                    .wall(ACBlocks.getCutPietraforteWall(colour));

            modelGen.family(ACBlocks.getSmoothPietraforte(colour))
                    .stairs(ACBlocks.getSmoothPietraforteStairs(colour))
                    .slab(ACBlocks.getSmoothPietraforteSlab(colour))
                    .wall(ACBlocks.getSmoothPietraforteWall(colour));
        }

        for (DyeColor colour : DyeColor.values()) {

            modelGen.createTrivialCube(ACBlocks.getChalk(colour.getId()));
            plasterBlock(ACBlocks.getDyedPlaster(colour.getId()), colour, modelGen);

            modelGen.family(ACBlocks.getDyedTerracottaShingles(colour.getId()))
                    .stairs(ACBlocks.getDyedTerracottaShingleStairs(colour.getId()))
                    .slab(ACBlocks.getDyedTerracottaShingleSlab(colour.getId()))
                    .wall(ACBlocks.getDyedTerracottaShingleWall(colour.getId()));

            modelGen.family(ACBlocks.getDyedSoapstone(colour.getId()))
                    .stairs(ACBlocks.getDyedSoapstoneStairs(colour.getId()))
                    .slab(ACBlocks.getDyedSoapstoneSlab(colour.getId()))
                    .wall(ACBlocks.getDyedSoapstoneWall(colour.getId()));

            modelGen.family(ACBlocks.getDyedSoapstoneBricks(colour.getId()))
                    .stairs(ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()))
                    .slab(ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()))
                    .wall(ACBlocks.getDyedSoapstoneBrickWall(colour.getId()));

            modelGen.family(ACBlocks.getDyedPolishedSoapstone(colour.getId()))
                    .stairs(ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()))
                    .slab(ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()))
                    .wall(ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()));

            modelGen.family(ACBlocks.getDyedMudBricks(colour.getId()))
                    .stairs(ACBlocks.getDyedMudBrickStairs(colour.getId()))
                    .slab(ACBlocks.getDyedMudBrickSlab(colour.getId()))
                    .wall(ACBlocks.getDyedMudBrickWall(colour.getId()));

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

    public final void plasterBlock(Block plaster, DyeColor colour,  BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.plasterMappings(colour);
        Identifier resourceLocation = ACModelTemplates.PLASTER.create(plaster, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(createPlasterVariants(plaster, resourceLocation));
    }


    private static BlockModelDefinitionGenerator createPlasterVariants(Block plaster, Identifier identifier) {
        MultiVariant model = BlockModelGenerators.plainVariant(identifier);
        return MultiVariantGenerator.dispatch(plaster)
                .with(PropertyDispatch.initial(BlockStateProperties.FACING)
                        .select(Direction.NORTH, model.with(BlockModelGenerators.Y_ROT_180))
                        .select(Direction.EAST, model.with(BlockModelGenerators.Y_ROT_270))
                        .select(Direction.SOUTH, model)
                        .select(Direction.WEST, model.with(BlockModelGenerators.Y_ROT_90))
                        .select(Direction.UP, model.with(BlockModelGenerators.X_ROT_90))
                        .select(Direction.DOWN, model.with(BlockModelGenerators.X_ROT_270))
                );
    }


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
