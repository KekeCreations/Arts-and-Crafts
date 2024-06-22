package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.PaintbrushItem;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ArtsAndCraftsRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ArtsAndCraftsRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {

        //DYE BLOCKS
        List<Item> dyeList = List.of(Items.BLACK_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.CYAN_DYE, Items.GRAY_DYE, Items.GREEN_DYE, Items.LIGHT_BLUE_DYE, Items.LIGHT_GRAY_DYE, Items.LIME_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.PINK_DYE, Items.PURPLE_DYE, Items.RED_DYE, Items.YELLOW_DYE, Items.WHITE_DYE);
        List<Item> chalkList = List.of(ACBlocks.getChalk(DyeColor.BLACK.getId()).asItem(), ACBlocks.getChalk(DyeColor.BLUE.getId()).asItem(), ACBlocks.getChalk(DyeColor.BROWN.getId()).asItem(), ACBlocks.getChalk(DyeColor.CYAN.getId()).asItem(), ACBlocks.getChalk(DyeColor.GRAY.getId()).asItem(), ACBlocks.getChalk(DyeColor.GREEN.getId()).asItem(), ACBlocks.getChalk(DyeColor.LIGHT_BLUE.getId()).asItem(), ACBlocks.getChalk(DyeColor.LIGHT_GRAY.getId()).asItem(), ACBlocks.getChalk(DyeColor.LIME.getId()).asItem(), ACBlocks.getChalk(DyeColor.MAGENTA.getId()).asItem(), ACBlocks.getChalk(DyeColor.ORANGE.getId()).asItem(), ACBlocks.getChalk(DyeColor.PINK.getId()).asItem(), ACBlocks.getChalk(DyeColor.PURPLE.getId()).asItem(), ACBlocks.getChalk(DyeColor.RED.getId()).asItem(), ACBlocks.getChalk(DyeColor.YELLOW.getId()).asItem(), ACBlocks.getChalk(DyeColor.WHITE.getId()).asItem(), ACBlocks.BLEACHED_CHALK.get().asItem());
        List<Item> chalkStickList = List.of(ACItems.getChalkStick(DyeColor.BLACK.getId()).asItem(), ACItems.getChalkStick(DyeColor.BLUE.getId()).asItem(), ACItems.getChalkStick(DyeColor.BROWN.getId()).asItem(), ACItems.getChalkStick(DyeColor.CYAN.getId()).asItem(), ACItems.getChalkStick(DyeColor.GRAY.getId()).asItem(), ACItems.getChalkStick(DyeColor.GREEN.getId()).asItem(), ACItems.getChalkStick(DyeColor.LIGHT_BLUE.getId()).asItem(), ACItems.getChalkStick(DyeColor.LIGHT_GRAY.getId()).asItem(), ACItems.getChalkStick(DyeColor.LIME.getId()).asItem(), ACItems.getChalkStick(DyeColor.MAGENTA.getId()).asItem(), ACItems.getChalkStick(DyeColor.ORANGE.getId()).asItem(), ACItems.getChalkStick(DyeColor.PINK.getId()).asItem(), ACItems.getChalkStick(DyeColor.PURPLE.getId()).asItem(), ACItems.getChalkStick(DyeColor.RED.getId()).asItem(), ACItems.getChalkStick(DyeColor.YELLOW.getId()).asItem(), ACItems.getChalkStick(DyeColor.WHITE.getId()).asItem(), ACItems.BLEACHED_CHALK_STICK.get());
        List<Item> flowerPotList = List.of(ACBlocks.getDyedFlowerPot(DyeColor.BLACK.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.BLUE.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.BROWN.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.CYAN.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.GRAY.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.GREEN.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.LIGHT_BLUE.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.LIGHT_GRAY.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.LIME.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.MAGENTA.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.ORANGE.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.PINK.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.PURPLE.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.RED.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.YELLOW.getId()).asItem(), ACBlocks.getDyedFlowerPot(DyeColor.WHITE.getId()).asItem());
        colorBlockWithDye(recipeConsumer, dyeList, chalkList, "chalk");
        colorBlockWithDye(recipeConsumer, dyeList, chalkStickList, "chalk_sticks");
        colorBlockWithDye(recipeConsumer, dyeList, flowerPotList, "flower_pots");
        colorBleachedBlockWithDye(recipeConsumer, dyeList, flowerPotList, Blocks.FLOWER_POT, "flower_pots");

        //BLEACHED
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACBlocks.BLEACHED_CARPET.get(),3)
                .pattern("KK")
                .define('K', ACBlocks.BLEACHED_WOOL.get())
                .unlockedBy(getItemName(ACItems.BLEACHDEW.get()), has(ACItems.BLEACHDEW.get()))
                .save(recipeConsumer);
        paintbrushRecipe(ACItems.BLEACHDEW.get(), ACItems.BLEACHDEW_PAINTBRUSH.get(), recipeConsumer);
        //wool
        List<Item> woolList = List.of(Blocks.BLACK_WOOL.asItem(), Blocks.BLUE_WOOL.asItem(), Blocks.BROWN_WOOL.asItem(), Blocks.CYAN_WOOL.asItem(), Blocks.GRAY_WOOL.asItem(), Blocks.GREEN_WOOL.asItem(), Blocks.LIGHT_BLUE_WOOL.asItem(), Blocks.LIGHT_GRAY_WOOL.asItem(), Blocks.LIME_WOOL.asItem(), Blocks.MAGENTA_WOOL.asItem(), Blocks.ORANGE_WOOL.asItem(), Blocks.PINK_WOOL.asItem(), Blocks.PURPLE_WOOL.asItem(), Blocks.RED_WOOL.asItem(), Blocks.YELLOW_WOOL.asItem(), Blocks.WHITE_WOOL.asItem());
        colorBleachedBlockWithDye(recipeConsumer, dyeList, woolList, ACBlocks.BLEACHED_WOOL.get(),  "wool");
        bleachBlock(recipeConsumer, woolList, ACBlocks.BLEACHED_WOOL.get(), "wool");
        //carpet
        List<Item> carpetList = List.of(Blocks.BLACK_CARPET.asItem(), Blocks.BLUE_CARPET.asItem(), Blocks.BROWN_CARPET.asItem(), Blocks.CYAN_CARPET.asItem(), Blocks.GRAY_CARPET.asItem(), Blocks.GREEN_CARPET.asItem(), Blocks.LIGHT_BLUE_CARPET.asItem(), Blocks.LIGHT_GRAY_CARPET.asItem(), Blocks.LIME_CARPET.asItem(), Blocks.MAGENTA_CARPET.asItem(), Blocks.ORANGE_CARPET.asItem(), Blocks.PINK_CARPET.asItem(), Blocks.PURPLE_CARPET.asItem(), Blocks.RED_CARPET.asItem(), Blocks.YELLOW_CARPET.asItem(), Blocks.WHITE_CARPET.asItem());
        colorBleachedBlockWithDye(recipeConsumer, dyeList, carpetList, ACBlocks.BLEACHED_CARPET.get(),  "carpet");
        bleachBlock(recipeConsumer, carpetList, ACBlocks.BLEACHED_CARPET.get(), "carpet");
        //chalk
        bleachBlock(recipeConsumer, chalkList, ACBlocks.BLEACHED_CHALK.get(), "chalk");
        //chalk sticks
        bleachBlock(recipeConsumer, chalkStickList, ACItems.BLEACHED_CHALK_STICK.get(), "chalk_sticks");
        //terracotta
        List<Item> terracottaList = List.of(Blocks.BLACK_TERRACOTTA.asItem(), Blocks.BLUE_TERRACOTTA.asItem(), Blocks.BROWN_TERRACOTTA.asItem(), Blocks.CYAN_TERRACOTTA.asItem(), Blocks.GRAY_TERRACOTTA.asItem(), Blocks.GREEN_TERRACOTTA.asItem(), Blocks.LIGHT_BLUE_TERRACOTTA.asItem(), Blocks.LIGHT_GRAY_TERRACOTTA.asItem(), Blocks.LIME_TERRACOTTA.asItem(), Blocks.MAGENTA_TERRACOTTA.asItem(), Blocks.ORANGE_TERRACOTTA.asItem(), Blocks.PINK_TERRACOTTA.asItem(), Blocks.PURPLE_TERRACOTTA.asItem(), Blocks.RED_TERRACOTTA.asItem(), Blocks.YELLOW_TERRACOTTA.asItem(), Blocks.WHITE_TERRACOTTA.asItem());
        bleachBlockAlt(recipeConsumer, terracottaList, Blocks.TERRACOTTA, "terracotta");
        smeltingRecipe(Blocks.TERRACOTTA, ACBlocks.GLAZED_TERRACOTTA.get(), RecipeCategory.BUILDING_BLOCKS, 0.1F, recipeConsumer);
        List<Item> glazedTerracottaList = List.of(Blocks.BLACK_GLAZED_TERRACOTTA.asItem(), Blocks.BLUE_GLAZED_TERRACOTTA.asItem(), Blocks.BROWN_GLAZED_TERRACOTTA.asItem(), Blocks.CYAN_GLAZED_TERRACOTTA.asItem(), Blocks.GRAY_GLAZED_TERRACOTTA.asItem(), Blocks.GREEN_GLAZED_TERRACOTTA.asItem(), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.asItem(), Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA.asItem(), Blocks.LIME_GLAZED_TERRACOTTA.asItem(), Blocks.MAGENTA_GLAZED_TERRACOTTA.asItem(), Blocks.ORANGE_GLAZED_TERRACOTTA.asItem(), Blocks.PINK_GLAZED_TERRACOTTA.asItem(), Blocks.PURPLE_GLAZED_TERRACOTTA.asItem(), Blocks.RED_GLAZED_TERRACOTTA.asItem(), Blocks.YELLOW_GLAZED_TERRACOTTA.asItem(), Blocks.WHITE_GLAZED_TERRACOTTA.asItem());
        bleachBlockAlt(recipeConsumer, glazedTerracottaList, ACBlocks.GLAZED_TERRACOTTA.get(), "glazed_terracotta");
        colorBlockWithDye(recipeConsumer, dyeList, glazedTerracottaList, "glazed_terracotta");
        //Plaster
        List<Item> plasterList = List.of(ACBlocks.getDyedPlaster(DyeColor.BLACK.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.BLUE.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.BROWN.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.CYAN.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.GRAY.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.GREEN.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.LIGHT_BLUE.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.LIGHT_GRAY.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.LIME.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.MAGENTA.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.ORANGE.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.PINK.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.PURPLE.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.RED.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.YELLOW.getId()).asItem(), ACBlocks.getDyedPlaster(DyeColor.WHITE.getId()).asItem());
        bleachBlockAlt(recipeConsumer, plasterList, ACBlocks.PLASTER.get(), "plaster");
        //concrete
        concretePowder(recipeConsumer, ACBlocks.BLEACHED_CONCRETE_POWDER.get(), ACItems.BLEACHDEW.get());
        //bed
        List<Item> bedList = List.of(Items.BLACK_BED, Items.BLUE_BED, Items.BROWN_BED, Items.CYAN_BED, Items.GRAY_BED, Items.GREEN_BED, Items.LIGHT_BLUE_BED, Items.LIGHT_GRAY_BED, Items.LIME_BED, Items.MAGENTA_BED, Items.ORANGE_BED, Items.PINK_BED, Items.PURPLE_BED, Items.RED_BED, Items.YELLOW_BED, Items.WHITE_BED);
        bedFromPlanksAndWool(recipeConsumer, ACItems.BLEACHED_BED.get(), ACBlocks.BLEACHED_WOOL.get());
        bleachBlock(recipeConsumer, bedList, ACItems.BLEACHED_BED.get(), "bed");
        colorBleachedBlockWithDye(recipeConsumer, dyeList, bedList, ACBlocks.BLEACHED_BED.get(), "bed");
        //soapstone
        List<Item> soapstoneList = List.of(ACBlocks.getDyedSoapstone(DyeColor.BLACK.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.BLUE.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.BROWN.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.CYAN.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.GRAY.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.GREEN.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.LIGHT_BLUE.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.LIGHT_GRAY.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.LIME.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.MAGENTA.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.ORANGE.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.PINK.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.PURPLE.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.RED.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.YELLOW.getId()).asItem(), ACBlocks.getDyedSoapstone(DyeColor.WHITE.getId()).asItem());
        bleachBlockAlt(recipeConsumer, soapstoneList, ACBlocks.SOAPSTONE.get(), "soapstone");
        List<Item> polishedSoapstoneList = List.of(ACBlocks.getDyedPolishedSoapstone(DyeColor.BLACK.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.BLUE.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.BROWN.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.CYAN.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.GRAY.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.GREEN.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.LIGHT_BLUE.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.LIGHT_GRAY.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.LIME.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.MAGENTA.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.ORANGE.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.PINK.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.PURPLE.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.RED.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.YELLOW.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(DyeColor.WHITE.getId()).asItem());
        bleachBlockAlt(recipeConsumer, polishedSoapstoneList, ACBlocks.POLISHED_SOAPSTONE.get(), "polished_soapstone");
        List<Item> soapstoneBricksList = List.of(ACBlocks.getDyedSoapstoneBricks(DyeColor.BLACK.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.BLUE.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.BROWN.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.CYAN.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.GRAY.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.GREEN.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.LIGHT_BLUE.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.LIGHT_GRAY.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.LIME.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.MAGENTA.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.ORANGE.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.PINK.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.PURPLE.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.RED.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.YELLOW.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(DyeColor.WHITE.getId()).asItem());
        bleachBlockAlt(recipeConsumer, soapstoneBricksList, ACBlocks.SOAPSTONE_BRICKS.get(), "soapstone_bricks");
        //terracotta shingles
        List<Item> terracottaShinglesList = List.of(ACBlocks.getDyedTerracottaShingles(DyeColor.BLACK.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.BLUE.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.BROWN.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.CYAN.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.GRAY.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.GREEN.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.LIGHT_BLUE.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.LIGHT_GRAY.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.LIME.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.MAGENTA.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.ORANGE.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.PINK.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.PURPLE.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.RED.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.YELLOW.getId()).asItem(), ACBlocks.getDyedTerracottaShingles(DyeColor.WHITE.getId()).asItem());
        bleachBlockAlt(recipeConsumer, terracottaShinglesList, ACBlocks.TERRACOTTA_SHINGLES.get(), "terracotta_shingles");


        //GYPSUM
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.GYPSUM_BRICKS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.POLISHED_GYPSUM, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.GYPSUM_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.GYPSUM_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.GYPSUM_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.GYPSUM_BRICK_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.GYPSUM_BRICK_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.GYPSUM_BRICK_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.POLISHED_GYPSUM_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.POLISHED_GYPSUM_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM, ACBlocks.POLISHED_GYPSUM_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM_BRICKS, ACBlocks.GYPSUM_BRICK_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM_BRICKS, ACBlocks.GYPSUM_BRICK_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.GYPSUM_BRICKS, ACBlocks.GYPSUM_BRICK_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_GYPSUM, ACBlocks.POLISHED_GYPSUM_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_GYPSUM, ACBlocks.POLISHED_GYPSUM_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_GYPSUM, ACBlocks.POLISHED_GYPSUM_WALL, 1, recipeConsumer);
        stairRecipe(ACBlocks.GYPSUM.get(), ACBlocks.GYPSUM_STAIRS.get(), recipeConsumer);
        slabRecipe(ACBlocks.GYPSUM.get(), ACBlocks.GYPSUM_SLAB.get(), recipeConsumer);
        wallRecipe(ACBlocks.GYPSUM.get(), ACBlocks.GYPSUM_WALL.get(), recipeConsumer);
        stairRecipe(ACBlocks.POLISHED_GYPSUM.get(), ACBlocks.POLISHED_GYPSUM_STAIRS.get(), recipeConsumer);
        slabRecipe(ACBlocks.POLISHED_GYPSUM.get(), ACBlocks.POLISHED_GYPSUM_SLAB.get(), recipeConsumer);
        wallRecipe(ACBlocks.POLISHED_GYPSUM.get(), ACBlocks.POLISHED_GYPSUM_WALL.get(), recipeConsumer);
        stairRecipe(ACBlocks.GYPSUM_BRICKS.get(), ACBlocks.GYPSUM_BRICK_STAIRS.get(), recipeConsumer);
        slabRecipe(ACBlocks.GYPSUM_BRICKS.get(), ACBlocks.GYPSUM_BRICK_SLAB.get(), recipeConsumer);
        wallRecipe(ACBlocks.GYPSUM_BRICKS.get(), ACBlocks.GYPSUM_BRICK_WALL.get(), recipeConsumer);

        //GYPSUM TO BRICK OR POLISHED RECIPES
        typeRecipe(ACBlocks.GYPSUM.get(), ACBlocks.POLISHED_GYPSUM.get(), recipeConsumer);
        typeRecipe(ACBlocks.POLISHED_GYPSUM.get(), ACBlocks.GYPSUM_BRICKS.get(), recipeConsumer);

        //SOAPSTONE
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.SOAPSTONE_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.SOAPSTONE_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.SOAPSTONE_WALL.get().asItem(), 1, recipeConsumer);
        stairRecipe(ACBlocks.SOAPSTONE.get(), ACBlocks.SOAPSTONE_STAIRS.get(), recipeConsumer);
        slabRecipe(ACBlocks.SOAPSTONE.get(), ACBlocks.SOAPSTONE_SLAB.get(), recipeConsumer);
        wallRecipe(ACBlocks.SOAPSTONE.get(), ACBlocks.SOAPSTONE_WALL.get(), recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.POLISHED_SOAPSTONE.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.POLISHED_SOAPSTONE_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.POLISHED_SOAPSTONE_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.POLISHED_SOAPSTONE_WALL.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.SOAPSTONE_BRICKS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.SOAPSTONE_BRICK_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.SOAPSTONE_BRICK_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE.get().asItem(), ACBlocks.SOAPSTONE_BRICK_WALL.get().asItem(), 1, recipeConsumer);

        //SOAPSTONE TO BRICK OR POLISHED RECIPES
        typeRecipe(ACBlocks.SOAPSTONE.get(), ACBlocks.POLISHED_SOAPSTONE.get(), recipeConsumer);
        typeRecipe(ACBlocks.POLISHED_SOAPSTONE.get(), ACBlocks.SOAPSTONE_BRICKS.get(), recipeConsumer);

        //POLISHED SOAPSTONE
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_SOAPSTONE.get().asItem(), ACBlocks.POLISHED_SOAPSTONE_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_SOAPSTONE.get().asItem(), ACBlocks.POLISHED_SOAPSTONE_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.POLISHED_SOAPSTONE.get().asItem(), ACBlocks.POLISHED_SOAPSTONE_WALL.get().asItem(), 1, recipeConsumer);
        stairRecipe(ACBlocks.POLISHED_SOAPSTONE.get(), ACBlocks.POLISHED_SOAPSTONE_STAIRS.get(), recipeConsumer);
        slabRecipe(ACBlocks.POLISHED_SOAPSTONE.get(), ACBlocks.POLISHED_SOAPSTONE_SLAB.get(), recipeConsumer);
        wallRecipe(ACBlocks.POLISHED_SOAPSTONE.get(), ACBlocks.POLISHED_SOAPSTONE_WALL.get(), recipeConsumer);

        //SOAPSTONE BRICKS
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE_BRICKS.get().asItem(), ACBlocks.SOAPSTONE_BRICK_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE_BRICKS.get().asItem(), ACBlocks.SOAPSTONE_BRICK_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.SOAPSTONE_BRICKS.get().asItem(), ACBlocks.SOAPSTONE_BRICK_WALL.get().asItem(), 1, recipeConsumer);
        stairRecipe(ACBlocks.SOAPSTONE_BRICKS.get(), ACBlocks.SOAPSTONE_BRICK_STAIRS.get(), recipeConsumer);
        slabRecipe(ACBlocks.SOAPSTONE_BRICKS.get(), ACBlocks.SOAPSTONE_BRICK_SLAB.get(), recipeConsumer);
        wallRecipe(ACBlocks.SOAPSTONE_BRICKS.get(), ACBlocks.SOAPSTONE_BRICK_WALL.get(), recipeConsumer);

        //TERRACOTTA SHINGLES
        typeRecipe(Blocks.TERRACOTTA, ACBlocks.TERRACOTTA_SHINGLES.get(), recipeConsumer);
        stairRecipe(ACBlocks.TERRACOTTA_SHINGLES.get(), ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), recipeConsumer);
        slabRecipe(ACBlocks.TERRACOTTA_SHINGLES.get(), ACBlocks.TERRACOTTA_SHINGLE_SLAB.get(), recipeConsumer);
        wallRecipe(ACBlocks.TERRACOTTA_SHINGLES.get(), ACBlocks.TERRACOTTA_SHINGLE_WALL.get(), recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.TERRACOTTA_SHINGLES.get().asItem(), ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get().asItem(),1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.TERRACOTTA_SHINGLES.get().asItem(), ACBlocks.TERRACOTTA_SHINGLE_SLAB.get().asItem(),1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.TERRACOTTA_SHINGLES.get().asItem(), ACBlocks.TERRACOTTA_SHINGLE_WALL.get().asItem(),1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, Blocks.TERRACOTTA.asItem(), ACBlocks.TERRACOTTA_SHINGLES.get().asItem(), 1, recipeConsumer);

        //PLASTER
        smeltingRecipe(ACBlocks.GYPSUM.get(), ACBlocks.PLASTER.get(), RecipeCategory.BUILDING_BLOCKS, 0F, recipeConsumer);

        //CHALK
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.BLEACHED_CHALK.get().asItem(), ACItems.BLEACHED_CHALK_STICK.get(), 1, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getChalk(DyeColor.WHITE.getId()),2)
                .pattern("QK")
                .pattern("KQ")
                .define('K', Blocks.CALCITE)
                .define('Q', ACBlocks.GYPSUM.get())
                .unlockedBy(getItemName(Blocks.CALCITE), has(Blocks.CALCITE))
                .unlockedBy(getItemName(ACBlocks.GYPSUM.get()), has(ACBlocks.GYPSUM.get()))
                .save(recipeConsumer);

        //CORK
        planksFromLogsRecipe(ACBlocks.CORK_LOG, ACBlocks.CORK_PLANKS, recipeConsumer);
        woodFromLogsRecipe(ACBlocks.CORK_LOG, ACBlocks.CORK_WOOD, recipeConsumer);
        woodFromLogsRecipe(ACBlocks.STRIPPED_CORK_LOG, ACBlocks.STRIPPED_CORK_WOOD, recipeConsumer);
        slabRecipe(ACBlocks.CORK_PLANKS.get(), ACBlocks.CORK_SLAB.get(), recipeConsumer);
        fenceRecipe(ACBlocks.CORK_PLANKS, ACBlocks.CORK_FENCE, recipeConsumer);
        stairRecipe(ACBlocks.CORK_PLANKS.get(), ACBlocks.CORK_STAIRS.get(), recipeConsumer);
        buttonRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.CORK_PLANKS.get(), ACBlocks.CORK_BUTTON, recipeConsumer);
        pressurePlateRecipe(ACBlocks.CORK_PLANKS, ACBlocks.CORK_PRESSURE_PLATE, recipeConsumer);
        doorRecipe(ACBlocks.CORK_PLANKS, ACBlocks.CORK_DOOR, recipeConsumer);
        trapdoorRecipe(ACBlocks.CORK_PLANKS, ACBlocks.CORK_TRAPDOOR, recipeConsumer);
        fenceGateRecipe(ACBlocks.CORK_PLANKS, ACBlocks.CORK_FENCE_GATE, recipeConsumer);
        signRecipe(ACBlocks.CORK_PLANKS, ACBlocks.CORK_SIGN, recipeConsumer);
        hangingSignRecipe(ACBlocks.STRIPPED_CORK_LOG, ACBlocks.CORK_HANGING_SIGN, recipeConsumer);
        woodenBoat(recipeConsumer, ACItems.CORK_BOAT.get(), ACBlocks.CORK_PLANKS.get());
        chestBoatRecipe(recipeConsumer, ACItems.CORK_CHEST_BOAT.get(), ACItems.CORK_BOAT.get());
        typeRecipe(ACBlocks.STRIPPED_CORK_WOOD.get(), ACBlocks.CORK.get(), recipeConsumer);
        typeRecipe(ACBlocks.CORK.get(), ACBlocks.SMOOTH_CORK.get(), recipeConsumer);

        for (DyeColor colours : DyeColor.values()) {
            //CHALK
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getChalk(colours.getId()).asItem(), ACItems.getChalkStick(colours.getId()), 1, recipeConsumer);
            //SOAPSTONE
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(ACBlocks.getDyedSoapstone(colours.getId()), ACBlocks.getDyedSoapstoneStairs(colours.getId()), recipeConsumer);
            slabRecipe(ACBlocks.getDyedSoapstone(colours.getId()), ACBlocks.getDyedSoapstoneSlab(colours.getId()), recipeConsumer);
            wallRecipe(ACBlocks.getDyedSoapstone(colours.getId()), ACBlocks.getDyedSoapstoneWall(colours.getId()), recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneBrickWall(colours.getId()).asItem(), 1, recipeConsumer);
            //SOAPSTONE TO BRICK OR POLISHED RECIPES
            typeRecipe(ACBlocks.getDyedSoapstone(colours.getId()), ACBlocks.getDyedPolishedSoapstone(colours.getId()), recipeConsumer);
            typeRecipe(ACBlocks.getDyedPolishedSoapstone(colours.getId()), ACBlocks.getDyedSoapstoneBricks(colours.getId()), recipeConsumer);
            //POLISHED SOAPSTONE
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(ACBlocks.getDyedPolishedSoapstone(colours.getId()), ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), recipeConsumer);
            slabRecipe(ACBlocks.getDyedPolishedSoapstone(colours.getId()), ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), recipeConsumer);
            wallRecipe(ACBlocks.getDyedPolishedSoapstone(colours.getId()), ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()), recipeConsumer);
            //SOAPSTONE BRICKS
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), ACBlocks.getDyedSoapstoneBrickWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(ACBlocks.getDyedSoapstoneBricks(colours.getId()), ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()), recipeConsumer);
            slabRecipe(ACBlocks.getDyedSoapstoneBricks(colours.getId()), ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()), recipeConsumer);
            wallRecipe(ACBlocks.getDyedSoapstoneBricks(colours.getId()), ACBlocks.getDyedSoapstoneBrickWall(colours.getId()), recipeConsumer);

            //DYE SOAPSTONE RECIPES
            dyeBlockRecipe(ACBlocks.SOAPSTONE.get(), colours, ACBlocks.getDyedSoapstone(colours.getId()), "soapstone", recipeConsumer);
            dyeBlockRecipe(ACBlocks.SOAPSTONE_STAIRS.get(), colours, ACBlocks.getDyedSoapstoneStairs(colours.getId()), "soapstone_stairs", recipeConsumer);
            dyeBlockRecipe(ACBlocks.SOAPSTONE_SLAB.get(), colours, ACBlocks.getDyedSoapstoneSlab(colours.getId()), "soapstone_slab", recipeConsumer);
            dyeBlockRecipe(ACBlocks.SOAPSTONE_WALL.get(), colours, ACBlocks.getDyedSoapstoneWall(colours.getId()), "soapstone_wall", recipeConsumer);
            dyeBlockRecipe(ACBlocks.POLISHED_SOAPSTONE.get(), colours, ACBlocks.getDyedPolishedSoapstone(colours.getId()), "polished_soapstone", recipeConsumer);
            dyeBlockRecipe(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get(), colours, ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), "polished_soapstone_stairs", recipeConsumer);
            dyeBlockRecipe(ACBlocks.POLISHED_SOAPSTONE_SLAB.get(), colours, ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), "polished_soapstone_slab", recipeConsumer);
            dyeBlockRecipe(ACBlocks.POLISHED_SOAPSTONE_WALL.get(), colours, ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()), "polished_soapstone_wall", recipeConsumer);
            dyeBlockRecipe(ACBlocks.SOAPSTONE_BRICKS.get(), colours, ACBlocks.getDyedSoapstoneBricks(colours.getId()), "soapstone_brick", recipeConsumer);
            dyeBlockRecipe(ACBlocks.SOAPSTONE_BRICK_STAIRS.get(), colours, ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()), "soapstone_brick_stairs", recipeConsumer);
            dyeBlockRecipe(ACBlocks.SOAPSTONE_BRICK_SLAB.get(), colours, ACBlocks.getDyedSoapstoneSlab(colours.getId()), "soapstone_brick_slab", recipeConsumer);
            dyeBlockRecipe(ACBlocks.SOAPSTONE_BRICK_WALL.get(), colours, ACBlocks.getDyedSoapstoneWall(colours.getId()), "soapstone_brick_wall", recipeConsumer);

            //MUD BRICKS
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedMudBricks(colours.getId()).asItem(), ACBlocks.getDyedMudBrickStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedMudBricks(colours.getId()).asItem(), ACBlocks.getDyedMudBrickSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedMudBricks(colours.getId()).asItem(), ACBlocks.getDyedMudBrickWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(ACBlocks.getDyedMudBricks(colours.getId()), ACBlocks.getDyedMudBrickStairs(colours.getId()), recipeConsumer);
            slabRecipe(ACBlocks.getDyedMudBricks(colours.getId()), ACBlocks.getDyedMudBrickSlab(colours.getId()), recipeConsumer);
            wallRecipe(ACBlocks.getDyedMudBricks(colours.getId()), ACBlocks.getDyedMudBrickWall(colours.getId()), recipeConsumer);
            dyeBlockRecipe(Blocks.MUD_BRICKS, colours, ACBlocks.getDyedMudBricks(colours.getId()), "mud_bricks", recipeConsumer);
            dyeBlockRecipe(Blocks.MUD_BRICK_STAIRS, colours, ACBlocks.getDyedMudBrickStairs(colours.getId()), "mud_brick_stairs", recipeConsumer);
            dyeBlockRecipe(Blocks.MUD_BRICK_SLAB, colours, ACBlocks.getDyedMudBrickSlab(colours.getId()), "mud_brick_slab", recipeConsumer);
            dyeBlockRecipe(Blocks.MUD_BRICK_WALL, colours, ACBlocks.getDyedMudBrickWall(colours.getId()), "mud_brick_wall", recipeConsumer);

            //PAINTBRUSH
            paintbrushRecipe(colours, ACItems.getPaintBrush(colours.getId()), recipeConsumer);

            //TERRACOTTA SHINGLES
            typeRecipe(ArtsAndCraftsDyedBlockLists.getDyedTerracotta(colours.getId()), ACBlocks.getDyedTerracottaShingles(colours.getId()), recipeConsumer);
            dyeBlockRecipe(ACBlocks.TERRACOTTA_SHINGLES.get(), colours, ACBlocks.getDyedTerracottaShingles(colours.getId()), "terracotta_shingle", recipeConsumer);
            dyeBlockRecipe(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), colours, ACBlocks.getDyedTerracottaShingleStairs(colours.getId()), "terracotta_shingle_stairs", recipeConsumer);
            dyeBlockRecipe(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get(), colours, ACBlocks.getDyedTerracottaShingleSlab(colours.getId()), "terracotta_shingle_slab", recipeConsumer);
            dyeBlockRecipe(ACBlocks.TERRACOTTA_SHINGLE_WALL.get(), colours, ACBlocks.getDyedTerracottaShingleWall(colours.getId()), "terracotta_shingle_wall", recipeConsumer);
            stairRecipe(ACBlocks.getDyedTerracottaShingles(colours.getId()), ACBlocks.getDyedTerracottaShingleStairs(colours.getId()), recipeConsumer);
            slabRecipe(ACBlocks.getDyedTerracottaShingles(colours.getId()), ACBlocks.getDyedTerracottaShingleSlab(colours.getId()), recipeConsumer);
            wallRecipe(ACBlocks.getDyedTerracottaShingles(colours.getId()), ACBlocks.getDyedTerracottaShingleWall(colours.getId()), recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), ACBlocks.getDyedTerracottaShingleStairs(colours.getId()).asItem(),1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), ACBlocks.getDyedTerracottaShingleSlab(colours.getId()).asItem(),1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, ACBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), ACBlocks.getDyedTerracottaShingleWall(colours.getId()).asItem(),1, recipeConsumer);

            //PLASTER
            dyeBlockRecipe(ACBlocks.PLASTER.get(), colours, ACBlocks.getDyedPlaster(colours.getId()), "plaster", recipeConsumer);

            //BANNER
            bleachBannerRecipe(ArtsAndCraftsDyedBlockLists.getDyedBanner(colours.getId()), colours, "bleach_banner", recipeConsumer);
        }
    }
    protected static void smeltingRecipe(Block craftingBlock, Block resultBlock, RecipeCategory recipeCategory, float experience, Consumer<FinishedRecipe> recipeConsumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(craftingBlock), recipeCategory, resultBlock , experience, 200)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }
    protected static void bleachBannerRecipe(Block craftingBlock, DyeColor dyeColour, String group, Consumer<FinishedRecipe> recipeConsumer) {
        if (dyeColour != DyeColor.WHITE) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Blocks.WHITE_BANNER, 1)
                    .requires(craftingBlock)
                    .requires(ACItems.BLEACHDEW.get())
                    .group(group)
                    .unlockedBy(getItemName(ACItems.BLEACHDEW.get()), has(ACItems.BLEACHDEW.get()))
                    .save(recipeConsumer, "arts_and_crafts:" + getItemName(craftingBlock) + "_to_" + getItemName(Blocks.WHITE_BANNER));
        }
    }
    protected static void dyeBlockRecipe(Block craftingBlock, DyeColor dyeColour, Block resultBlock, String group, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,8)
                .pattern("KKK")
                .pattern("KQK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .define('Q', DyeItem.byColor(dyeColour))
                .group(group)
                .unlockedBy(getItemName(DyeItem.byColor(dyeColour)), has(DyeItem.byColor(dyeColour)))
                .save(recipeConsumer, "arts_and_crafts:" + dyeColour.getName() + "_" + getItemName(craftingBlock) + "_dye_recipe");
    }
    protected static void stairRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("K  ")
                .pattern("KK ")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void slabRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void wallRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void typeRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("KK")
                .pattern("KK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }
    protected static void paintbrushRecipe(DyeColor dyeColour, PaintbrushItem paintbrushItem, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, paintbrushItem,1)
                .pattern(" K ")
                .pattern("KQK")
                .define('K', DyeItem.byColor(dyeColour))
                .define('Q', Items.BRUSH)
                .group("paintbrush")
                .unlockedBy(getItemName(DyeItem.byColor(dyeColour)), has(DyeItem.byColor(dyeColour)))
                .save(recipeConsumer);
    }
    protected static void paintbrushRecipe(Item item, Item paintbrushItem, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, paintbrushItem,1)
                .pattern(" K ")
                .pattern("KQK")
                .define('K', item)
                .define('Q', Items.BRUSH)
                .group("paintbrush")
                .unlockedBy(getItemName(item), has(item))
                .save(recipeConsumer);
    }
    //Modified vanilla methods
    public static void chestBoatRecipe(Consumer<FinishedRecipe> consumer, ItemLike itemLike, ItemLike itemLike2) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, itemLike).requires(Blocks.CHEST).requires(itemLike2).group("chest_boat").unlockedBy("has_boat", RecipeProvider.has(ItemTags.BOATS)).save(consumer);
    }

    protected static void colorBlockWithDye(Consumer<FinishedRecipe> p_289666_, List<Item> p_289675_, List<Item> p_289672_, String p_289641_) {
        for(int i = 0; i < p_289675_.size(); ++i) {
            Item item = p_289675_.get(i);
            Item item1 = p_289672_.get(i);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, item1).requires(item).requires(Ingredient.of(p_289672_.stream().filter((p_288265_) -> {
                return !p_288265_.equals(item1);
            }).map(ItemStack::new))).group(p_289641_).unlockedBy("has_needed_dye", has(item)).save(p_289666_, "arts_and_crafts:" + "dye_" + getItemName(item1));
        }

    }

    protected static void colorBleachedBlockWithDye(Consumer<FinishedRecipe> p_289666_, List<Item> p_289675_, List<Item> p_289672_, ItemLike bleachedBlock, String p_289641_) {
        for(int i = 0; i < p_289675_.size(); ++i) {
            Item item = p_289675_.get(i);
            Item item1 = p_289672_.get(i);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, item1)
                    .requires(item)
                    .requires(bleachedBlock)
                    .group(p_289641_)
                    .unlockedBy("has_needed_dye", has(item)).save(p_289666_, "arts_and_crafts:" + "dye_" + getItemName(item1) + "_with_bleached_" + p_289641_);
        }
    }

    protected static void bleachBlockAlt(Consumer<FinishedRecipe> p_289666_, List<Item> itemList, ItemLike bleachedBlock, String string) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bleachedBlock, 8)
                .pattern("KKK")
                .pattern("KQK")
                .pattern("KKK")
                .define('K', Ingredient.of(itemList.stream().map(ItemStack::new)))
                .define('Q', ACItems.BLEACHDEW.get())
                .group(string)
                .unlockedBy("has_needed_dye", has(ACItems.BLEACHDEW.get())).save(p_289666_, "arts_and_crafts:" + "bleach_" + string);
    }
    protected static void bleachBlock(Consumer<FinishedRecipe> p_289666_, List<Item> p_289675_, ItemLike bleachedBlock, String p_289641_) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, bleachedBlock)
                .requires(Ingredient.of(p_289675_.stream().map(ItemStack::new)))
                .requires(ACItems.BLEACHDEW.get())
                .group(p_289641_)
                .unlockedBy("has_needed_dye", has(ACItems.BLEACHDEW.get())).save(p_289666_, "arts_and_crafts:" + "bleach_" + p_289641_);
    }

    //Thank you to Uraneptus for allowing me to use their datagen methods from Sully's Mod - Applies to all methods below this note
    protected static void stonecutterRecipes(RecipeCategory category, Item ingredient, Item result, int resultCount, Consumer<FinishedRecipe> consumer) {
        String prefix = getItemName(result) + "_from_" + getItemName(ingredient);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), category, result, resultCount)
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, ArtsAndCrafts.id("stonecutting/"+ prefix + "_stonecutting"));
    }
    protected static void stonecutterRecipes(RecipeCategory category, Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, int resultCount, Consumer<FinishedRecipe> consumer) {
        String prefix = getItemName(result.get()) + "_from_" + getItemName(ingredient.get());
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient.get()), category, result.get(), resultCount)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, ArtsAndCrafts.id("stonecutting/"+ prefix + "_stonecutting"));
    }
    private static void planksFromLogsRecipe(Supplier<? extends ItemLike> pLogs, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result.get(), 4).requires(pLogs.get())
                .unlockedBy("has_logs", has(pLogs.get())).save(consumer);
    }

    private static void woodFromLogsRecipe(Supplier<? extends ItemLike> pLog, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), 3).define('#', pLog.get()).pattern("##").pattern("##")
                .unlockedBy("has_log", has(pLog.get())).save(consumer);
    }

    private static void fenceRecipe(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), 3).define('W', ingredient.get()).define('#', Items.STICK).pattern("W#W").pattern("W#W")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer);
    }

    private static void pressurePlateRecipe(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get()).define('#', ingredient.get()).pattern("##")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer);
    }

    private static void doorRecipe(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), 3).define('#', ingredient.get()).pattern("##").pattern("##").pattern("##")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer);
    }

    private static void trapdoorRecipe(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), 2).define('#', ingredient.get()).pattern("###").pattern("###")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer);
    }

    private static void fenceGateRecipe(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get()).define('#', Items.STICK).define('W', ingredient.get()).pattern("#W#").pattern("#W#")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer);
    }

    private static void signRecipe(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), 3).define('#', ingredient.get()).define('X', Items.STICK).pattern("###").pattern("###").pattern(" X ")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer);
    }

    private static void hangingSignRecipe(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), 6).define('#', ingredient.get()).define('X', Items.CHAIN).pattern("X X").pattern("###").pattern("###")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer);
    }

    protected static void buttonRecipes(RecipeCategory category, ItemLike ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(category, result.get()).requires(ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer);
    }
}
