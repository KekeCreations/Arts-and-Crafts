package com.kekecreations.arts_and_crafts.core.neoforge.datagen.client;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.misc.ACBlockStateProperties;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ArtsAndCraftsBlockStateProvider extends BlockStateProvider {
    public ArtsAndCraftsBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //GYPSUM
        cubeAllWithItem(ACBlocks.GYPSUM.get());
        cubeAllWithItem(ACBlocks.GYPSUM_BRICKS.get());
        cubeAllWithItem(ACBlocks.POLISHED_GYPSUM.get());
        stairsWithItem(ACBlocks.GYPSUM_STAIRS.get(), ACBlocks.GYPSUM.get());
        stairsWithItem(ACBlocks.GYPSUM_BRICK_STAIRS.get(), ACBlocks.GYPSUM_BRICKS.get());
        stairsWithItem(ACBlocks.POLISHED_GYPSUM_STAIRS.get(), ACBlocks.POLISHED_GYPSUM.get());
        slabWithItem(ACBlocks.GYPSUM_SLAB.get(), ACBlocks.GYPSUM.get());
        slabWithItem(ACBlocks.GYPSUM_BRICK_SLAB.get(), ACBlocks.GYPSUM_BRICKS.get());
        slabWithItem(ACBlocks.POLISHED_GYPSUM_SLAB.get(), ACBlocks.POLISHED_GYPSUM.get());
        wallWithItem(ACBlocks.GYPSUM_WALL.get(), ACBlocks.GYPSUM.get());
        wallWithItem(ACBlocks.GYPSUM_BRICK_WALL.get(), ACBlocks.GYPSUM_BRICKS.get());
        wallWithItem(ACBlocks.POLISHED_GYPSUM_WALL.get(), ACBlocks.POLISHED_GYPSUM.get());

        //HANGING FLOWER POT
        hangingFlowerPotBlock(Blocks.CRIMSON_PLANKS, "minecraft:", ACBlocks.CRIMSON_HANGING_FLOWER_POT.get());

        //SOAPSTONE
        cubeAllWithItem(ACBlocks.SOAPSTONE.get());
        cubeAllWithItem(ACBlocks.SOAPSTONE_BRICKS.get());
        cubeAllWithItem(ACBlocks.POLISHED_SOAPSTONE.get());
        stairsWithItem(ACBlocks.SOAPSTONE_STAIRS.get(), ACBlocks.SOAPSTONE.get());
        stairsWithItem(ACBlocks.SOAPSTONE_BRICK_STAIRS.get(), ACBlocks.SOAPSTONE_BRICKS.get());
        stairsWithItem(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get(), ACBlocks.POLISHED_SOAPSTONE.get());
        slabWithItem(ACBlocks.SOAPSTONE_SLAB.get(), ACBlocks.SOAPSTONE.get());
        slabWithItem(ACBlocks.SOAPSTONE_BRICK_SLAB.get(), ACBlocks.SOAPSTONE_BRICKS.get());
        slabWithItem(ACBlocks.POLISHED_SOAPSTONE_SLAB.get(), ACBlocks.POLISHED_SOAPSTONE.get());
        wallWithItem(ACBlocks.SOAPSTONE_WALL.get(), ACBlocks.SOAPSTONE.get());
        wallWithItem(ACBlocks.SOAPSTONE_BRICK_WALL.get(), ACBlocks.SOAPSTONE_BRICKS.get());
        wallWithItem(ACBlocks.POLISHED_SOAPSTONE_WALL.get(), ACBlocks.POLISHED_SOAPSTONE.get());

        //Terracotta Shingles
        cubeAllWithItem(ACBlocks.TERRACOTTA_SHINGLES.get());
        stairsWithItem(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), ACBlocks.TERRACOTTA_SHINGLES.get());
        slabWithItem(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get(), ACBlocks.TERRACOTTA_SHINGLES.get());
        wallWithItem(ACBlocks.TERRACOTTA_SHINGLE_WALL.get(), ACBlocks.TERRACOTTA_SHINGLES.get());

        //Bleached
        cubeAllWithItem(ACBlocks.BLEACHED_WOOL.get());
        carpetWithItem(ACBlocks.BLEACHED_CARPET.get(), ACBlocks.BLEACHED_WOOL.get());
        chalkDustBlock(ACBlocks.BLEACHED_CHALK_DUST.get(), "bleached");
        cubeAllWithItem(ACBlocks.BLEACHED_CHALK.get());
        glazedTerracottaWithItem(ACBlocks.GLAZED_TERRACOTTA.get(), "glazed_terracotta");
        concretePowderWithItem(ACBlocks.BLEACHED_CONCRETE_POWDER.get());
        cubeAllWithItem(ACBlocks.BLEACHED_CONCRETE.get());
        bedBlock(ACBlocks.BLEACHED_BED.get(), "bleached_bed");


        //Cork
        logWithItem(ACBlocks.CORK_LOG.get());
        logWithItem(ACBlocks.STRIPPED_CORK_LOG.get());
        logWithItem(ACBlocks.CORK_WOOD.get());
        logWithItem(ACBlocks.STRIPPED_CORK_WOOD.get());
        doorBlock(ACBlocks.CORK_DOOR.get(), "cork", ArtsAndCrafts.id("block/cork_door_bottom"), ArtsAndCrafts.id("block/cork_door_top"));
        cubeAllWithItem(ACBlocks.CORK.get());
        cubeAllWithItem(ACBlocks.SMOOTH_CORK.get());
        cubeAllWithItem(ACBlocks.CORK_LEAVES.get());
        simpleBlock(ACBlocks.CORK_SAPLING.get(), models().withExistingParent("cork_sapling", "minecraft:block/cross").texture("cross", "block/cork_sapling"));
        cubeAllWithItem(ACBlocks.CORK_PLANKS.get());
        stairsWithItem(ACBlocks.CORK_STAIRS.get(), ACBlocks.CORK_PLANKS.get());
        slabWithItem(ACBlocks.CORK_SLAB.get(), ACBlocks.CORK_PLANKS.get());
        fenceWithItem(ACBlocks.CORK_FENCE.get(), ACBlocks.CORK_PLANKS.get());
        fenceGateWithItem(ACBlocks.CORK_FENCE_GATE.get(), ACBlocks.CORK_PLANKS.get());
        pressurePlateWithItem(ACBlocks.CORK_PRESSURE_PLATE.get(), ACBlocks.CORK_PLANKS.get());
        buttonWithItem(ACBlocks.CORK_BUTTON.get(), ACBlocks.CORK_PLANKS.get());
        trapdoorWithItem(ACBlocks.CORK_TRAPDOOR.get(), ACBlocks.CORK_TRAPDOOR.get());
        signBlock(ACBlocks.CORK_SIGN.get(), ACBlocks.CORK_WALL_SIGN.get(), ArtsAndCrafts.id("block/cork_planks"));
        hangingSignBlock(ACBlocks.CORK_HANGING_SIGN.get(), ACBlocks.CORK_WALL_HANGING_SIGN.get(),"cork");


        normalFlowerPotBlock(ACBlocks.POTTED_CORK_SAPLING.get(), "cork_sapling", "arts_and_crafts");


        lotusFlowerBlock(ACBlocks.LOTUS_FLOWER.get());

        //DYED STUFF
        for (DyeColor colours : DyeColor.values()) {
            plasterWithItem(ACBlocks.getDyedPlaster(colours.getId()), colours);
            plasterWithItem(ACBlocks.PLASTER.get(), null);
            chalkDustBlock(ACBlocks.getChalkDust(colours.getId()), colours.getName());
            cubeAllWithItem(ACBlocks.getChalk(colours.getId()));
            //Terracotta Shingles
            cubeAllWithItem(ACBlocks.getDyedTerracottaShingles(colours.getId()));
            stairsWithItem(((StairBlock) ACBlocks.getDyedTerracottaShingleStairs(colours.getId())), ACBlocks.getDyedTerracottaShingles(colours.getId()));
            slabWithItem(((SlabBlock) ACBlocks.getDyedTerracottaShingleSlab(colours.getId())), ACBlocks.getDyedTerracottaShingles(colours.getId()));
            wallWithItem(((WallBlock) ACBlocks.getDyedTerracottaShingleWall(colours.getId())), ACBlocks.getDyedTerracottaShingles(colours.getId()));

            //Dyed Mud Bricks
            cubeAllWithItem(ACBlocks.getDyedMudBricks(colours.getId()));
            stairsWithItem(((StairBlock) ACBlocks.getDyedMudBrickStairs(colours.getId())), ACBlocks.getDyedMudBricks(colours.getId()));
            slabWithItem(((SlabBlock) ACBlocks.getDyedMudBrickSlab(colours.getId())), ACBlocks.getDyedMudBricks(colours.getId()));
            wallWithItem(((WallBlock) ACBlocks.getDyedMudBrickWall(colours.getId())), ACBlocks.getDyedMudBricks(colours.getId()));

            //Soapstone
            cubeAllWithItem(ACBlocks.getDyedSoapstone(colours.getId()));
            stairsWithItem(((StairBlock) ACBlocks.getDyedSoapstoneStairs(colours.getId())), ACBlocks.getDyedSoapstone(colours.getId()));
            slabWithItem(((SlabBlock) ACBlocks.getDyedSoapstoneSlab(colours.getId())), ACBlocks.getDyedSoapstone(colours.getId()));
            wallWithItem(((WallBlock) ACBlocks.getDyedSoapstoneWall(colours.getId())), ACBlocks.getDyedSoapstone(colours.getId()));
            cubeAllWithItem(ACBlocks.getDyedSoapstoneBricks(colours.getId()));
            stairsWithItem(((StairBlock) ACBlocks.getDyedSoapstoneBrickStairs(colours.getId())), ACBlocks.getDyedSoapstoneBricks(colours.getId()));
            slabWithItem(((SlabBlock) ACBlocks.getDyedSoapstoneBrickSlab(colours.getId())), ACBlocks.getDyedSoapstoneBricks(colours.getId()));
            wallWithItem(((WallBlock) ACBlocks.getDyedSoapstoneBrickWall(colours.getId())), ACBlocks.getDyedSoapstoneBricks(colours.getId()));
            cubeAllWithItem(ACBlocks.getDyedPolishedSoapstone(colours.getId()));
            stairsWithItem(((StairBlock) ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId())), ACBlocks.getDyedPolishedSoapstone(colours.getId()));
            slabWithItem(((SlabBlock) ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId())), ACBlocks.getDyedPolishedSoapstone(colours.getId()));
            wallWithItem(((WallBlock) ACBlocks.getDyedPolishedSoapstoneWall(colours.getId())), ACBlocks.getDyedPolishedSoapstone(colours.getId()));

            emptyFlowerPotBlock(ACBlocks.getDyedFlowerPot(colours.getId()), colours);

            flowerPotBlock(ACBlocks.getDyedPottedCorkSapling(colours), colours, "cork_sapling", "arts_and_crafts");
            flowerPotBlock(ACBlocks.getDyedPottedOakSapling(colours), colours, "oak_sapling", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedSpruceSapling(colours), colours, "spruce_sapling", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedBirchSapling(colours), colours, "birch_sapling", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedJungleSapling(colours), colours, "jungle_sapling", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedAcaciaSapling(colours), colours, "acacia_sapling", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedCherrySapling(colours), colours, "cherry_sapling", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedDarkOakSapling(colours), colours, "dark_oak_sapling", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedMangrovePropagule(colours), colours, "mangrove_propagule", "minecraft");

            flowerPotBlock(ACBlocks.getDyedPottedCrimsonFungus(colours), colours, "crimson_fungus", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedCrimsonRoots(colours), colours, "crimson_roots_pot", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedWarpedFungus(colours), colours, "warped_fungus", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedWarpedRoots(colours), colours, "warped_roots_pot", "minecraft");

            flowerPotBlock(ACBlocks.getDyedPottedFern(colours), colours, "fern", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedDandelion(colours), colours, "dandelion", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedPoppy(colours), colours, "poppy", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedBlueOrchid(colours), colours, "blue_orchid", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedAllium(colours), colours, "allium", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedAzureBluet(colours), colours, "azure_bluet", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedRedTulip(colours), colours, "red_tulip", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedOrangeTulip(colours), colours, "orange_tulip", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedWhiteTulip(colours), colours, "white_tulip", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedPinkTulip(colours), colours, "pink_tulip", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedOxeyeDaisy(colours), colours, "oxeye_daisy", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedCornflower(colours), colours, "cornflower", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedLilyOfTheValley(colours), colours, "lily_of_the_valley", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedWitherRose(colours), colours, "wither_rose", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedRedMushroom(colours), colours, "red_mushroom", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedBrownMushroom(colours), colours, "brown_mushroom", "minecraft");
            flowerPotBlock(ACBlocks.getDyedPottedDeadBush(colours), colours, "dead_bush", "minecraft");
            cactusFlowerPotBlock(ACBlocks.getDyedPottedCactus(colours), colours);
            bambooFlowerPotBlock(ACBlocks.getDyedPottedBamboo(colours), colours);
            azaleaFlowerPotBlock(ACBlocks.getDyedPottedAzalea(colours), colours, "potted_azalea_bush");
            azaleaFlowerPotBlock(ACBlocks.getDyedPottedFloweringAzalea(colours), colours, "potted_flowering_azalea_bush");
            flowerPotBlock(ACBlocks.getDyedPottedTorchFlower(colours), colours, "torchflower", "minecraft");
        }
    }
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private void cubeAllWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }
    private void concretePowderWithItem(Block block) {
        concretePowderBlock(block);
        simpleBlockItem(block, cubeAll(block));
    }

    private void glazedTerracottaWithItem(Block block, String blockId) {
        glazedTerracotta(block);
        simpleBlockItem(block, glazedTerracottaModel(blockId));
    }
    private void bedBlock(Block block, String blockId) {
        simpleBlock(block, bedModel(blockId).texture("particle", "minecraft:block/oak_planks"));
    }

    private void stairsWithItem(StairBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        stairsBlock(block, resLoc);
        simpleBlockItem(block, models().stairs(name(block), resLoc, resLoc, resLoc));
    }
    private void slabWithItem(SlabBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        slabBlock(block, resLoc, resLoc);
        simpleBlockItem(block, models().slab(name(block), resLoc, resLoc, resLoc));
    }
    private void wallWithItem(WallBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        wallBlock(block, resLoc);
        simpleBlockItem(block, models().wallInventory(name(block), resLoc));
    }
    private void fenceWithItem(FenceBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        fenceBlock(block, resLoc);
        simpleBlockItem(block, models().fenceInventory(name(block), resLoc));
    }
    private void fenceGateWithItem(FenceGateBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        fenceGateBlock(block, resLoc);
        simpleBlockItem(block, models().fenceGate(name(block), resLoc));
    }
    private void pressurePlateWithItem(PressurePlateBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        pressurePlateBlock(block, resLoc);
        simpleBlockItem(block, models().pressurePlate(name(block), resLoc));
    }
    private void buttonWithItem(ButtonBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        buttonBlock(block, resLoc);
        //simpleBlockItem(block, models().buttonInventory(name(block), resLoc));
    }
    private void carpetWithItem(Block block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        simpleBlock(block, models().carpet(name(block), resLoc));
        simpleBlockItem(block, models().carpet(name(block), resLoc));
    }
    private void trapdoorWithItem(TrapDoorBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        trapdoorBlock(block, resLoc, true);
        simpleBlockItem(block, models().trapdoorOrientableBottom(name(block), resLoc));
    }
    private void hangingSignBlock(Block hangingSignBlock, Block wallHangingSignBlock, String woodType) {
        ModelFile sign = models().sign(name(hangingSignBlock), ArtsAndCrafts.id("block/" + woodType + "_planks"));
        simpleBlock(hangingSignBlock, sign);
        simpleBlock(wallHangingSignBlock, sign);
    }
    private void logWithItem(RotatedPillarBlock block) {
        logBlock(block);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_column"));
    }

    public void plasterWithItem(Block block, DyeColor dyeColor) {
        if (dyeColor == null) {
            normalPlasterBlock(block);
            simpleBlockItem(block, plasterModel("plaster"));
        } else {
            plasterBlock(block, dyeColor);
            simpleBlockItem(block, plasterModel(dyeColor.getName() + "_plaster"));
        }
    }
    public void azaleaFlowerPotBlock(Block block, DyeColor dyeColor, String flower) {
        if (flower.equals("potted_azalea_bush")) {
            simpleBlock(block, ConfiguredModel.builder().modelFile(azaleaFlowerPotModel(dyeColor.getName() + "_potted_" + flower).texture("particle", "block/" + dyeColor.getName() + "_flower_pot").texture("flowerpot", "block/" + dyeColor.getName() + "_flower_pot")).build());
        }
        if (flower.equals("potted_flowering_azalea_bush")) {
            simpleBlock(block, ConfiguredModel.builder().modelFile(floweringAzaleaFlowerPotModel(dyeColor.getName() + "_potted_" + flower).texture("particle", "block/" + dyeColor.getName() + "_flower_pot").texture("flowerpot", "block/" + dyeColor.getName() + "_flower_pot")).build());
        }
    }
    public void cactusFlowerPotBlock(Block block, DyeColor dyeColor) {
        simpleBlock(block, ConfiguredModel.builder().modelFile(cactusFlowerPotModel(dyeColor.getName() + "_potted_cactus").texture("particle", "block/" + dyeColor.getName() + "_flower_pot").texture("flowerpot", "block/" + dyeColor.getName() + "_flower_pot")).build());
    }
    public void bambooFlowerPotBlock(Block block, DyeColor dyeColor) {
        simpleBlock(block, ConfiguredModel.builder().modelFile(bambooFlowerPotModel(dyeColor.getName() + "_potted_bamboo").texture("particle", "block/" + dyeColor.getName() + "_flower_pot").texture("flowerpot", "block/" + dyeColor.getName() + "_flower_pot")).build());
    }
    public void emptyFlowerPotBlock(Block block, DyeColor dyeColor) {
        simpleBlock(block, ConfiguredModel.builder().modelFile(flowerPotModel(dyeColor.getName() + "_flower_pot").texture("particle", "block/" + dyeColor.getName() + "_flower_pot").texture("flowerpot", "block/" + dyeColor.getName() + "_flower_pot")).build());
    }
    public void flowerPotBlock(Block block, DyeColor dyeColor, String flower, String modId) {
        simpleBlock(block, ConfiguredModel.builder().modelFile(flowerPotCrossModel(dyeColor.getName() + "_potted_" + flower).texture("plant", modId + ":block/" + flower).texture("particle", "block/" + dyeColor.getName() + "_flower_pot").texture("flowerpot", "block/" + dyeColor.getName() + "_flower_pot")).build());
    }
    public void normalFlowerPotBlock(Block block, String flower, String modId) {
        simpleBlock(block, ConfiguredModel.builder().modelFile(flowerPotCrossModel("potted_" + flower).texture("plant", modId + ":block/" + flower)).build());
    }

    public void lotusFlowerBlock(Block block) {
        getVariantBuilder(block)
                .partialState().with(BlockStateProperties.AGE_3, 0).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_0").texture("lotus", "block/lotus_0").texture("particle", "block/lotus_0")).rotationY(180).build())
                .partialState().with(BlockStateProperties.AGE_3, 1).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_1").texture("lotus", "block/lotus_1").texture("particle", "block/lotus_1")).rotationY(180).build())
                .partialState().with(BlockStateProperties.AGE_3, 2).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_2").texture("lotus", "block/lotus_2").texture("particle", "block/lotus_2")).rotationY(180).build())
                .partialState().with(BlockStateProperties.AGE_3, 3).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_3").texture("lotus", "block/lotus_3").texture("particle", "block/lotus_3")).rotationY(180).build())
                //EAST
                .partialState().with(BlockStateProperties.AGE_3, 0).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_0").texture("lotus", "block/lotus_0").texture("particle", "block/lotus_0")).rotationY(270).build())
                .partialState().with(BlockStateProperties.AGE_3, 1).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_1").texture("lotus", "block/lotus_1").texture("particle", "block/lotus_1")).rotationY(270).build())
                .partialState().with(BlockStateProperties.AGE_3, 2).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_2").texture("lotus", "block/lotus_2").texture("particle", "block/lotus_2")).rotationY(270).build())
                .partialState().with(BlockStateProperties.AGE_3, 3).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_3").texture("lotus", "block/lotus_3").texture("particle", "block/lotus_3")).rotationY(270).build())
                //SOUTH
                .partialState().with(BlockStateProperties.AGE_3, 0).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_0").texture("lotus", "block/lotus_0").texture("particle", "block/lotus_0")).build())
                .partialState().with(BlockStateProperties.AGE_3, 1).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_1").texture("lotus", "block/lotus_1").texture("particle", "block/lotus_1")).build())
                .partialState().with(BlockStateProperties.AGE_3, 2).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_2").texture("lotus", "block/lotus_2").texture("particle", "block/lotus_2")).build())
                .partialState().with(BlockStateProperties.AGE_3, 3).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_3").texture("lotus", "block/lotus_3").texture("particle", "block/lotus_3")).build())
                //WEST
                .partialState().with(BlockStateProperties.AGE_3, 0).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_0").texture("lotus", "block/lotus_0").texture("particle", "block/lotus_0")).rotationY(90).build())
                .partialState().with(BlockStateProperties.AGE_3, 1).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_1").texture("lotus", "block/lotus_1").texture("particle", "block/lotus_1")).rotationY(90).build())
                .partialState().with(BlockStateProperties.AGE_3, 2).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_2").texture("lotus", "block/lotus_2").texture("particle", "block/lotus_2")).rotationY(90).build())
                .partialState().with(BlockStateProperties.AGE_3, 3).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(lotusFlowerModel("lotus_flower_3").texture("lotus", "block/lotus_3").texture("particle", "block/lotus_3")).rotationY(90).build());
    }

    public void glazedTerracotta(Block block) {
        getVariantBuilder(block)
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(glazedTerracottaModel(name(block)).texture("pattern", "block/" + name(block))).rotationY(180).build())
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(glazedTerracottaModel(name(block)).texture("pattern", "block/" + name(block))).rotationY(270).build())
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(glazedTerracottaModel(name(block)).texture("pattern", "block/" + name(block))).build())
                .partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(glazedTerracottaModel(name(block)).texture("pattern", "block/" + name(block))).rotationY(90).build());
    }
    public void concretePowderBlock(Block block) {
        getVariantBuilder(block)
                .partialState()
                .addModels(ConfiguredModel.builder().modelFile(cubeAllModel(name(block)).texture("all", "block/" + name(block))).build())
                .partialState()
                .addModels(ConfiguredModel.builder().modelFile(cubeAllModel(name(block)).texture("all", "block/" + name(block))).rotationY(90).build())
                .partialState()
                .addModels(ConfiguredModel.builder().modelFile(cubeAllModel(name(block)).texture("all", "block/" + name(block))).rotationY(180).build())
                .partialState()
                .addModels(ConfiguredModel.builder().modelFile(cubeAllModel(name(block)).texture("all", "block/" + name(block))).rotationY(270).build());
    }

    public void normalPlasterBlock(Block block) {
        getVariantBuilder(block)
                .partialState().with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(plasterModel("plaster").texture("plaster", "block/plaster").texture("particle", "block/plaster")).rotationY(180).build())
                .partialState().with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(plasterModel("plaster").texture("plaster", "block/plaster").texture("particle", "block/plaster")).rotationY(270).build())
                .partialState().with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(plasterModel("plaster").texture("plaster", "block/plaster").texture("particle", "block/plaster")).build())
                .partialState().with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(plasterModel("plaster").texture("plaster", "block/plaster").texture("particle", "block/plaster")).rotationY(90).build())
                .partialState().with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(plasterModel("plaster").texture("plaster", "block/plaster").texture("particle", "block/plaster")).rotationX(90).build())
                .partialState().with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(plasterModel("plaster").texture("plaster", "block/plaster").texture("particle", "block/plaster")).rotationX(270).build());
    }

    public void plasterBlock(Block block, DyeColor dyeColor) {
       getVariantBuilder(block)
               .partialState().with(BlockStateProperties.FACING, Direction.NORTH)
               .addModels(ConfiguredModel.builder().modelFile(plasterModel(dyeColor.getName() + "_plaster").texture("plaster", "block/" + dyeColor.getName() + "_plaster").texture("particle", "block/" + dyeColor.getName() + "_plaster")).rotationY(180).build())
               .partialState().with(BlockStateProperties.FACING, Direction.EAST)
               .addModels(ConfiguredModel.builder().modelFile(plasterModel(dyeColor.getName() + "_plaster").texture("plaster", "block/" + dyeColor.getName() + "_plaster").texture("particle", "block/" + dyeColor.getName() + "_plaster")).rotationY(270).build())
               .partialState().with(BlockStateProperties.FACING, Direction.SOUTH)
               .addModels(ConfiguredModel.builder().modelFile(plasterModel(dyeColor.getName() + "_plaster").texture("plaster", "block/" + dyeColor.getName() + "_plaster").texture("particle", "block/" + dyeColor.getName() + "_plaster")).build())
               .partialState().with(BlockStateProperties.FACING, Direction.WEST)
               .addModels(ConfiguredModel.builder().modelFile(plasterModel(dyeColor.getName() + "_plaster").texture("plaster", "block/" + dyeColor.getName() + "_plaster").texture("particle", "block/" + dyeColor.getName() + "_plaster")).rotationY(90).build())
               .partialState().with(BlockStateProperties.FACING, Direction.UP)
               .addModels(ConfiguredModel.builder().modelFile(plasterModel(dyeColor.getName() + "_plaster").texture("plaster", "block/" + dyeColor.getName() + "_plaster").texture("particle", "block/" + dyeColor.getName() + "_plaster")).rotationX(90).build())
               .partialState().with(BlockStateProperties.FACING, Direction.DOWN)
               .addModels(ConfiguredModel.builder().modelFile(plasterModel(dyeColor.getName() + "_plaster").texture("plaster", "block/" + dyeColor.getName() + "_plaster").texture("particle", "block/" + dyeColor.getName() + "_plaster")).rotationX(270).build());
    }

    public void chalkDustBlock(Block block, String dyeColor) {
        String dot = "block/" + dyeColor + "_dot";
        String verticalLine = "block/" + dyeColor + "_vertical_line_middle";
        String rotatedLine = "block/" + dyeColor + "_rotated_line_middle";
        String corner0 = "block/" + dyeColor + "_corner_0";
        String corner1 = "block/" + dyeColor + "_corner_1";
        String corner2 = "block/" + dyeColor + "_corner_2";
        String corner3 = "block/" + dyeColor + "_corner_3";
        String tCross0 = "block/" + dyeColor + "_t_cross_0";
        String tCross1 = "block/" + dyeColor + "_t_cross_1";
        String tCross2 = "block/" + dyeColor + "_t_cross_2";
        String tCross3 = "block/" + dyeColor + "_t_cross_3";
        String plus = "block/" + dyeColor + "_plus";
        String diagonalLineRight = "block/" + dyeColor + "_diagonal_line_right";
        String diagonalLineLeft = "block/" + dyeColor + "_diagonal_line_left";
        String x = "block/" + dyeColor + "_x";
        String lineEdge0 = "block/" + dyeColor + "_line_edge_0";
        String lineEdge1 = "block/" + dyeColor + "_line_edge_1";
        String lineEdge2 = "block/" + dyeColor + "_line_edge_2";
        String lineEdge3 = "block/" + dyeColor + "_line_edge_3";
        String triangle0 = "block/" + dyeColor + "_triangle_0";
        String triangle1 = "block/" + dyeColor + "_triangle_1";
        String triangle2 = "block/" + dyeColor + "_triangle_2";
        String triangle3 = "block/" + dyeColor + "_triangle_3";
        String circle = "block/" + dyeColor + "_circle";
        String square = "block/" + dyeColor + "_square";
        String blockCorner0 = "block/" + dyeColor + "_block_corner_0";
        String blockCorner1 = "block/" + dyeColor + "_block_corner_1";
        String blockCorner2 = "block/" + dyeColor + "_block_corner_2";
        String blockCorner3 = "block/" + dyeColor + "_block_corner_3";
        String arch0 = "block/" + dyeColor + "_arch_0";
        String arch1 = "block/" + dyeColor + "_arch_1";
        String arch2 = "block/" + dyeColor + "_arch_2";
        String arch3 = "block/" + dyeColor + "_arch_3";
        getVariantBuilder(block)
                //Chalk Pattern 0
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_dot").texture("dust", dot).texture("particle", dot)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_dot").texture("dust", dot).texture("particle", dot)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_dot").texture("dust", dot).texture("particle", dot)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_dot").texture("dust", dot).texture("particle", dot)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_dot").texture("dust", dot).texture("particle", dot)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_dot").texture("dust", dot).texture("particle", dot)).rotationX(270).build())
                //Chalk Pattern 1
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_vertical_line_middle").texture("dust", verticalLine).texture("particle", verticalLine)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_vertical_line_middle").texture("dust", verticalLine).texture("particle", verticalLine)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_vertical_line_middle").texture("dust", verticalLine).texture("particle", verticalLine)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_vertical_line_middle").texture("dust", verticalLine).texture("particle", verticalLine)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_vertical_line_middle").texture("dust", verticalLine).texture("particle", verticalLine)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_vertical_line_middle").texture("dust", verticalLine).texture("particle", verticalLine)).rotationX(270).build())
                //Chalk Pattern 2
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_rotated_line_middle").texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_rotated_line_middle").texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_rotated_line_middle").texture("dust", rotatedLine).texture("particle", rotatedLine)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_rotated_line_middle").texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_rotated_line_middle").texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_rotated_line_middle").texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationX(270).build())
                //Chalk Pattern 3
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_0").texture("dust", corner0).texture("particle", corner0)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_0").texture("dust", corner0).texture("particle", corner0)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_0").texture("dust", corner0).texture("particle", corner0)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_0").texture("dust", corner0).texture("particle", corner0)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_0").texture("dust", corner0).texture("particle", corner0)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_0").texture("dust", corner0).texture("particle", corner0)).rotationX(270).build())
                //Chalk Pattern 4
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_1").texture("dust", corner1).texture("particle", corner1)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_1").texture("dust", corner1).texture("particle", corner1)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_1").texture("dust", corner1).texture("particle", corner1)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_1").texture("dust", corner1).texture("particle", corner1)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_1").texture("dust", corner1).texture("particle", corner1)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_1").texture("dust", corner1).texture("particle", corner1)).rotationX(270).build())
                //Chalk Pattern 5
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_2").texture("dust", corner2).texture("particle", corner2)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_2").texture("dust", corner2).texture("particle", corner2)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_2").texture("dust", corner2).texture("particle", corner2)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_2").texture("dust", corner2).texture("particle", corner2)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_2").texture("dust", corner2).texture("particle", corner2)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_2").texture("dust", corner2).texture("particle", corner2)).rotationX(270).build())
                //Chalk Pattern 6
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_3").texture("dust", corner3).texture("particle", corner3)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_3").texture("dust", corner3).texture("particle", corner3)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_3").texture("dust", corner3).texture("particle", corner3)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_3").texture("dust", corner3).texture("particle", corner3)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_3").texture("dust", corner3).texture("particle", corner3)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_corner_3").texture("dust", corner3).texture("particle", corner3)).rotationX(270).build())
                //Chalk Pattern 7
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_0").texture("dust", tCross0).texture("particle", tCross0)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_0").texture("dust", tCross0).texture("particle", tCross0)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_0").texture("dust", tCross0).texture("particle", tCross0)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_0").texture("dust", tCross0).texture("particle", tCross0)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_0").texture("dust", tCross0).texture("particle", tCross0)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_0").texture("dust", tCross0).texture("particle", tCross0)).rotationX(270).build())
                //Chalk Pattern 8
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_1").texture("dust", tCross1).texture("particle", tCross1)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_1").texture("dust", tCross1).texture("particle", tCross1)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_1").texture("dust", tCross1).texture("particle", tCross1)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_1").texture("dust", tCross1).texture("particle", tCross1)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_1").texture("dust", tCross1).texture("particle", tCross1)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_1").texture("dust", tCross1).texture("particle", tCross1)).rotationX(270).build())
                //Chalk Pattern 9
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_2").texture("dust", tCross2).texture("particle", tCross2)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_2").texture("dust", tCross2).texture("particle", tCross2)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_2").texture("dust", tCross2).texture("particle", tCross2)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_2").texture("dust", tCross2).texture("particle", tCross2)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_2").texture("dust", tCross2).texture("particle", tCross2)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_2").texture("dust", tCross2).texture("particle", tCross2)).rotationX(270).build())
                //Chalk Pattern 10
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_3").texture("dust", tCross3).texture("particle", tCross3)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_3").texture("dust", tCross3).texture("particle", tCross3)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_3").texture("dust", tCross3).texture("particle", tCross3)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_3").texture("dust", tCross3).texture("particle", tCross3)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_3").texture("dust", tCross3).texture("particle", tCross3)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_t_cross_3").texture("dust", tCross3).texture("particle", tCross3)).rotationX(270).build())
                //Chalk Pattern 11
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_plus").texture("dust", plus).texture("particle", plus)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_plus").texture("dust", plus).texture("particle", plus)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_plus").texture("dust", plus).texture("particle", plus)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_plus").texture("dust", plus).texture("particle", plus)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_plus").texture("dust", plus).texture("particle", plus)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_plus").texture("dust", plus).texture("particle", plus)).rotationX(270).build())
                //Chalk Pattern 12
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_right").texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_right").texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_right").texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_right").texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_right").texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_right").texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationX(270).build())
                //Chalk Pattern 13
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_left").texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_left").texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_left").texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_left").texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_left").texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_diagonal_line_left").texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationX(270).build())
                //Chalk Pattern 14
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_x").texture("dust", x).texture("particle", x)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_x").texture("dust", x).texture("particle", x)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_x").texture("dust", x).texture("particle", x)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_x").texture("dust", x).texture("particle", x)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_x").texture("dust", x).texture("particle", x)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_x").texture("dust", x).texture("particle", x)).rotationX(270).build())
                //Chalk Pattern 15
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_0").texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_0").texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_0").texture("dust", lineEdge0).texture("particle", lineEdge0)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_0").texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_0").texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_0").texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationX(270).build())
                //Chalk Pattern 16
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_1").texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_1").texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_1").texture("dust", lineEdge1).texture("particle", lineEdge1)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_1").texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_1").texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_1").texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationX(270).build())
                //Chalk Pattern 17
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_2").texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_2").texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_2").texture("dust", lineEdge2).texture("particle", lineEdge2)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_2").texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_2").texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_2").texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationX(270).build())
                //Chalk Pattern 18
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_3").texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_3").texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_3").texture("dust", lineEdge3).texture("particle", lineEdge3)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_3").texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_3").texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_line_edge_3").texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationX(270).build())
                //Chalk Pattern 19
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_0").texture("dust", triangle0).texture("particle", triangle0)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_0").texture("dust", triangle0).texture("particle", triangle0)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_0").texture("dust", triangle0).texture("particle", triangle0)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_0").texture("dust", triangle0).texture("particle", triangle0)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_0").texture("dust", triangle0).texture("particle", triangle0)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_0").texture("dust", triangle0).texture("particle", triangle0)).rotationX(270).build())
                //Chalk Pattern 20
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_1").texture("dust", triangle1).texture("particle", triangle1)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_1").texture("dust", triangle1).texture("particle", triangle1)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_1").texture("dust", triangle1).texture("particle", triangle1)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_1").texture("dust", triangle1).texture("particle", triangle1)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_1").texture("dust", triangle1).texture("particle", triangle1)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_1").texture("dust", triangle1).texture("particle", triangle1)).rotationX(270).build())
                //Chalk Pattern 21
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_2").texture("dust", triangle2).texture("particle", triangle2)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_2").texture("dust", triangle2).texture("particle", triangle2)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_2").texture("dust", triangle2).texture("particle", triangle2)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_2").texture("dust", triangle2).texture("particle", triangle2)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_2").texture("dust", triangle2).texture("particle", triangle2)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_2").texture("dust", triangle2).texture("particle", triangle2)).rotationX(270).build())
                //Chalk Pattern 22
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_3").texture("dust", triangle3).texture("particle", triangle3)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_3").texture("dust", triangle3).texture("particle", triangle3)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_3").texture("dust", triangle3).texture("particle", triangle3)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_3").texture("dust", triangle3).texture("particle", triangle3)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_3").texture("dust", triangle3).texture("particle", triangle3)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_triangle_3").texture("dust", triangle3).texture("particle", triangle3)).rotationX(270).build())
                //Chalk Pattern 23
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_circle").texture("dust", circle).texture("particle", circle)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_circle").texture("dust", circle).texture("particle", circle)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_circle").texture("dust", circle).texture("particle", circle)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_circle").texture("dust", circle).texture("particle", circle)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_circle").texture("dust", circle).texture("particle", circle)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_circle").texture("dust", circle).texture("particle", circle)).rotationX(270).build())
                //Chalk Pattern 24
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_square").texture("dust", square).texture("particle", square)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_square").texture("dust", square).texture("particle", square)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_square").texture("dust", square).texture("particle", square)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_square").texture("dust", square).texture("particle", square)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_square").texture("dust", square).texture("particle", square)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_square").texture("dust", square).texture("particle", square)).rotationX(270).build())
                //Chalk Pattern 25
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_0").texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_0").texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_0").texture("dust", blockCorner0).texture("particle", blockCorner0)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_0").texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_0").texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_0").texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationX(270).build())
                //Chalk Pattern 26
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_1").texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_1").texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_1").texture("dust", blockCorner1).texture("particle", blockCorner1)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_1").texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_1").texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_1").texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationX(270).build())
                //Chalk Pattern 27
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_2").texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_2").texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_2").texture("dust", blockCorner2).texture("particle", blockCorner2)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_2").texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_2").texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_2").texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationX(270).build())
                //Chalk Pattern 28
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_3").texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_3").texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_3").texture("dust", blockCorner3).texture("particle", blockCorner3)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_3").texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_3").texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_block_corner_3").texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationX(270).build())
                //Chalk Pattern 29
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_0").texture("dust", arch0).texture("particle", arch0)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_0").texture("dust", arch0).texture("particle", arch0)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_0").texture("dust", arch0).texture("particle", arch0)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_0").texture("dust", arch0).texture("particle", arch0)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_0").texture("dust", arch0).texture("particle", arch0)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_0").texture("dust", arch0).texture("particle", arch0)).rotationX(270).build())
                //Chalk Pattern 30
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_1").texture("dust", arch1).texture("particle", arch1)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_1").texture("dust", arch1).texture("particle", arch1)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_1").texture("dust", arch1).texture("particle", arch1)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_1").texture("dust", arch1).texture("particle", arch1)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_1").texture("dust", arch1).texture("particle", arch1)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_1").texture("dust", arch1).texture("particle", arch1)).rotationX(270).build())
                //Chalk Pattern 31
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_2").texture("dust", arch2).texture("particle", arch2)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_2").texture("dust", arch2).texture("particle", arch2)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_2").texture("dust", arch2).texture("particle", arch2)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_2").texture("dust", arch2).texture("particle", arch2)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_2").texture("dust", arch2).texture("particle", arch2)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_2").texture("dust", arch2).texture("particle", arch2)).rotationX(270).build())
                //Chalk Pattern 32
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_3").texture("dust", arch3).texture("particle", arch3)).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_3").texture("dust", arch3).texture("particle", arch3)).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_3").texture("dust", arch3).texture("particle", arch3)).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_3").texture("dust", arch3).texture("particle", arch3)).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_3").texture("dust", arch3).texture("particle", arch3)).rotationX(90).build())
                .partialState().with(ACBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(chalkDustModel(dyeColor + "_arch_3").texture("dust", arch3).texture("particle", arch3)).rotationX(270).build());
    }

    public void hangingFlowerPotBlock(Block plank, String plankModId, Block hangingFlowerPot) {
        getVariantBuilder(hangingFlowerPot)
                .partialState().with(ACBlockStateProperties.PLANK, false).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(hangingFlowerPotModel(name(hangingFlowerPot)).texture("hanging_flower_pot", "block/" + name(hangingFlowerPot)).texture("particle", plankModId + "block/" + name(plank))).rotationY(180).build())
                .partialState().with(ACBlockStateProperties.PLANK, true).with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(hangingFlowerPotModelWithPlank(name(hangingFlowerPot) + "_with_plank").texture("hanging_flower_pot", "block/" + name(hangingFlowerPot)).texture("particle", plankModId + "block/" + name(plank))).rotationY(180).build())
                //EAST
                .partialState().with(ACBlockStateProperties.PLANK, false).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(hangingFlowerPotModel(name(hangingFlowerPot)).texture("hanging_flower_pot", "block/" + name(hangingFlowerPot)).texture("particle", plankModId + "block/" + name(plank))).rotationY(270).build())
                .partialState().with(ACBlockStateProperties.PLANK, true).with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(hangingFlowerPotModelWithPlank(name(hangingFlowerPot) + "_with_plank").texture("hanging_flower_pot", "block/" + name(hangingFlowerPot)).texture("particle", plankModId + "block/" + name(plank))).rotationY(270).build())
                //SOUTH
                .partialState().with(ACBlockStateProperties.PLANK, false).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(hangingFlowerPotModel(name(hangingFlowerPot)).texture("hanging_flower_pot", "block/" + name(hangingFlowerPot)).texture("particle", plankModId + "block/" + name(plank))).build())
                .partialState().with(ACBlockStateProperties.PLANK, true).with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(hangingFlowerPotModelWithPlank(name(hangingFlowerPot) + "_with_plank").texture("hanging_flower_pot", "block/" + name(hangingFlowerPot)).texture("particle", plankModId + "block/" + name(plank))).build())
                //WEST
                .partialState().with(ACBlockStateProperties.PLANK, false).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(hangingFlowerPotModel(name(hangingFlowerPot)).texture("hanging_flower_pot", "block/" + name(hangingFlowerPot)).texture("particle", plankModId + "block/" + name(plank))).rotationY(90).build())
                .partialState().with(ACBlockStateProperties.PLANK, true).with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(hangingFlowerPotModelWithPlank(name(hangingFlowerPot) + "_with_plank").texture("hanging_flower_pot", "block/" + name(hangingFlowerPot)).texture("particle", plankModId + "block/" + name(plank))).rotationY(90).build());
    }

    public ModelBuilder<?> hangingFlowerPotModel(String name) {
        return models().withExistingParent(name, "arts_and_crafts:block/template_hanging_flower_pot");
    }

    public ModelBuilder<?> hangingFlowerPotModelWithPlank(String name) {
        return models().withExistingParent(name, "arts_and_crafts:block/template_hanging_flower_pot_with_plank");
    }

    public ModelBuilder<?> chalkDustModel(String name) {
        return models().withExistingParent(name, "arts_and_crafts:block/chalk_dust");
    }
    public ModelBuilder<?> plasterModel(String name) {
        return models().withExistingParent(name, "arts_and_crafts:block/plaster_model");
    }
    public ModelBuilder<?> lotusFlowerModel(String name) {
        return models().withExistingParent(name, "arts_and_crafts:block/lotus_flower_model");
    }
    public ModelBuilder<?> glazedTerracottaModel(String name) {
        return models().withExistingParent(name, "minecraft:block/template_glazed_terracotta");
    }
    public ModelBuilder<?> flowerPotModel(String name) {
        return models().withExistingParent(name, "minecraft:block/flower_pot");
    }
    public ModelBuilder<?> cubeAllModel(String name) {
        return models().withExistingParent(name, "minecraft:block/cube_all");
    }
    public ModelBuilder<?> flowerPotCrossModel(String name) {
        return models().withExistingParent(name, "minecraft:block/flower_pot_cross");
    }
    public ModelBuilder<?> cactusFlowerPotModel(String name) {
        return models().withExistingParent(name, "minecraft:block/potted_cactus");
    }
    public ModelBuilder<?> bambooFlowerPotModel(String name) {
        return models().withExistingParent(name, "minecraft:block/potted_bamboo");
    }
    public ModelBuilder<?> azaleaFlowerPotModel(String name) {
        return models().withExistingParent(name, "minecraft:block/potted_azalea_bush");
    }
    public ModelBuilder<?> floweringAzaleaFlowerPotModel(String name) {
        return models().withExistingParent(name, "minecraft:block/potted_flowering_azalea_bush");
    }

    public ModelBuilder<?> bedModel(String name) {
        return models().withExistingParent(name, "minecraft:block/bed");
    }
}
