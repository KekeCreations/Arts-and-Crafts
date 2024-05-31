package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.PaintBrushItem;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.StairBlock;
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
        List<Item> chalkList = List.of(KekeBlocks.getChalk(DyeColor.BLACK.getId()).asItem(), KekeBlocks.getChalk(DyeColor.BLUE.getId()).asItem(), KekeBlocks.getChalk(DyeColor.BROWN.getId()).asItem(), KekeBlocks.getChalk(DyeColor.CYAN.getId()).asItem(), KekeBlocks.getChalk(DyeColor.GRAY.getId()).asItem(), KekeBlocks.getChalk(DyeColor.GREEN.getId()).asItem(), KekeBlocks.getChalk(DyeColor.LIGHT_BLUE.getId()).asItem(), KekeBlocks.getChalk(DyeColor.LIGHT_GRAY.getId()).asItem(), KekeBlocks.getChalk(DyeColor.LIME.getId()).asItem(), KekeBlocks.getChalk(DyeColor.MAGENTA.getId()).asItem(), KekeBlocks.getChalk(DyeColor.ORANGE.getId()).asItem(), KekeBlocks.getChalk(DyeColor.PINK.getId()).asItem(), KekeBlocks.getChalk(DyeColor.PURPLE.getId()).asItem(), KekeBlocks.getChalk(DyeColor.RED.getId()).asItem(), KekeBlocks.getChalk(DyeColor.YELLOW.getId()).asItem(), KekeBlocks.getChalk(DyeColor.WHITE.getId()).asItem());
        List<Item> chalkStickList = List.of(KekeItems.getChalkStick(DyeColor.BLACK.getId()).asItem(), KekeItems.getChalkStick(DyeColor.BLUE.getId()).asItem(), KekeItems.getChalkStick(DyeColor.BROWN.getId()).asItem(), KekeItems.getChalkStick(DyeColor.CYAN.getId()).asItem(), KekeItems.getChalkStick(DyeColor.GRAY.getId()).asItem(), KekeItems.getChalkStick(DyeColor.GREEN.getId()).asItem(), KekeItems.getChalkStick(DyeColor.LIGHT_BLUE.getId()).asItem(), KekeItems.getChalkStick(DyeColor.LIGHT_GRAY.getId()).asItem(), KekeItems.getChalkStick(DyeColor.LIME.getId()).asItem(), KekeItems.getChalkStick(DyeColor.MAGENTA.getId()).asItem(), KekeItems.getChalkStick(DyeColor.ORANGE.getId()).asItem(), KekeItems.getChalkStick(DyeColor.PINK.getId()).asItem(), KekeItems.getChalkStick(DyeColor.PURPLE.getId()).asItem(), KekeItems.getChalkStick(DyeColor.RED.getId()).asItem(), KekeItems.getChalkStick(DyeColor.YELLOW.getId()).asItem(), KekeItems.getChalkStick(DyeColor.WHITE.getId()).asItem());
        List<Item> flowerPotList = List.of(KekeBlocks.getDyedFlowerPot(DyeColor.BLACK.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.BLUE.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.BROWN.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.CYAN.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.GRAY.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.GREEN.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.LIGHT_BLUE.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.LIGHT_GRAY.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.LIME.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.MAGENTA.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.ORANGE.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.PINK.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.PURPLE.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.RED.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.YELLOW.getId()).asItem(), KekeBlocks.getDyedFlowerPot(DyeColor.WHITE.getId()).asItem());
        colorBlockWithDye(recipeConsumer, dyeList, chalkList, "chalk");
        colorBlockWithDye(recipeConsumer, dyeList, chalkStickList, "chalk_sticks");
        colorBlockWithDye(recipeConsumer, dyeList, flowerPotList, "flower_pots");

        //BLEACHED
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.BLEACHED_CARPET.get(),3)
                .pattern("KK")
                .define('K', KekeBlocks.BLEACHED_WOOL.get())
                .unlockedBy(getItemName(KekeItems.BLEACHDEW.get()), has(KekeItems.BLEACHDEW.get()))
                .save(recipeConsumer);
        //wool
        List<Item> woolList = List.of(Blocks.BLACK_WOOL.asItem(), Blocks.BLUE_WOOL.asItem(), Blocks.BROWN_WOOL.asItem(), Blocks.CYAN_WOOL.asItem(), Blocks.GRAY_WOOL.asItem(), Blocks.GREEN_WOOL.asItem(), Blocks.LIGHT_BLUE_WOOL.asItem(), Blocks.LIGHT_GRAY_WOOL.asItem(), Blocks.LIME_WOOL.asItem(), Blocks.MAGENTA_WOOL.asItem(), Blocks.ORANGE_WOOL.asItem(), Blocks.PINK_WOOL.asItem(), Blocks.PURPLE_WOOL.asItem(), Blocks.RED_WOOL.asItem(), Blocks.YELLOW_WOOL.asItem(), Blocks.WHITE_WOOL.asItem());
        colorBleachedBlockWithDye(recipeConsumer, dyeList, woolList, KekeBlocks.BLEACHED_WOOL.get(),  "wool");
        bleachBlock(recipeConsumer, woolList, KekeBlocks.BLEACHED_WOOL.get(), "wool");
        //carpet
        List<Item> carpetList = List.of(Blocks.BLACK_CARPET.asItem(), Blocks.BLUE_CARPET.asItem(), Blocks.BROWN_CARPET.asItem(), Blocks.CYAN_CARPET.asItem(), Blocks.GRAY_CARPET.asItem(), Blocks.GREEN_CARPET.asItem(), Blocks.LIGHT_BLUE_CARPET.asItem(), Blocks.LIGHT_GRAY_CARPET.asItem(), Blocks.LIME_CARPET.asItem(), Blocks.MAGENTA_CARPET.asItem(), Blocks.ORANGE_CARPET.asItem(), Blocks.PINK_CARPET.asItem(), Blocks.PURPLE_CARPET.asItem(), Blocks.RED_CARPET.asItem(), Blocks.YELLOW_CARPET.asItem(), Blocks.WHITE_CARPET.asItem());
        colorBleachedBlockWithDye(recipeConsumer, dyeList, carpetList, KekeBlocks.BLEACHED_CARPET.get(),  "carpet");
        bleachBlock(recipeConsumer, carpetList, KekeBlocks.BLEACHED_CARPET.get(), "carpet");
        //chalk
        colorBleachedBlockWithDye(recipeConsumer, dyeList, chalkList, KekeBlocks.BLEACHED_CHALK.get(), "chalk");
        bleachBlock(recipeConsumer, chalkList, KekeBlocks.BLEACHED_CHALK.get(), "chalk");
        //chalk sticks
        colorBleachedBlockWithDye(recipeConsumer, dyeList, chalkStickList, KekeItems.BLEACHED_CHALK_STICK.get(), "chalk_sticks");
        bleachBlock(recipeConsumer, chalkStickList, KekeItems.BLEACHED_CHALK_STICK.get(), "chalk_sticks");
        //terracotta
        List<Item> terracottaList = List.of(Blocks.BLACK_TERRACOTTA.asItem(), Blocks.BLUE_TERRACOTTA.asItem(), Blocks.BROWN_TERRACOTTA.asItem(), Blocks.CYAN_TERRACOTTA.asItem(), Blocks.GRAY_TERRACOTTA.asItem(), Blocks.GREEN_TERRACOTTA.asItem(), Blocks.LIGHT_BLUE_TERRACOTTA.asItem(), Blocks.LIGHT_GRAY_TERRACOTTA.asItem(), Blocks.LIME_TERRACOTTA.asItem(), Blocks.MAGENTA_TERRACOTTA.asItem(), Blocks.ORANGE_TERRACOTTA.asItem(), Blocks.PINK_TERRACOTTA.asItem(), Blocks.PURPLE_TERRACOTTA.asItem(), Blocks.RED_TERRACOTTA.asItem(), Blocks.YELLOW_TERRACOTTA.asItem(), Blocks.WHITE_TERRACOTTA.asItem());
        colorBleachedBlockWithDye(recipeConsumer, dyeList, terracottaList, Blocks.TERRACOTTA, "terracotta");
        bleachBlockAlt(recipeConsumer, terracottaList, Blocks.TERRACOTTA, "terracotta");
        smeltingRecipe(Blocks.TERRACOTTA, KekeBlocks.GLAZED_TERRACOTTA.get(), RecipeCategory.BUILDING_BLOCKS, 0.1F, recipeConsumer);
        List<Item> glazedTerracottaList = List.of(Blocks.BLACK_GLAZED_TERRACOTTA.asItem(), Blocks.BLUE_GLAZED_TERRACOTTA.asItem(), Blocks.BROWN_GLAZED_TERRACOTTA.asItem(), Blocks.CYAN_GLAZED_TERRACOTTA.asItem(), Blocks.GRAY_GLAZED_TERRACOTTA.asItem(), Blocks.GREEN_GLAZED_TERRACOTTA.asItem(), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.asItem(), Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA.asItem(), Blocks.LIME_GLAZED_TERRACOTTA.asItem(), Blocks.MAGENTA_GLAZED_TERRACOTTA.asItem(), Blocks.ORANGE_GLAZED_TERRACOTTA.asItem(), Blocks.PINK_GLAZED_TERRACOTTA.asItem(), Blocks.PURPLE_GLAZED_TERRACOTTA.asItem(), Blocks.RED_GLAZED_TERRACOTTA.asItem(), Blocks.YELLOW_GLAZED_TERRACOTTA.asItem(), Blocks.WHITE_GLAZED_TERRACOTTA.asItem());
        bleachBlockAlt(recipeConsumer, glazedTerracottaList, KekeBlocks.GLAZED_TERRACOTTA.get(), "glazed_terracotta");
        colorBleachedBlockWithDye(recipeConsumer, dyeList, glazedTerracottaList, KekeBlocks.GLAZED_TERRACOTTA.get(), "glazed_terracotta");
        //Plaster
        List<Item> plasterList = List.of(KekeBlocks.getDyedPlaster(DyeColor.BLACK.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.BLUE.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.BROWN.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.CYAN.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.GRAY.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.GREEN.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.LIGHT_BLUE.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.LIGHT_GRAY.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.LIME.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.MAGENTA.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.ORANGE.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.PINK.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.PURPLE.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.RED.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.YELLOW.getId()).asItem(), KekeBlocks.getDyedPlaster(DyeColor.WHITE.getId()).asItem());
        colorBleachedBlockWithDye(recipeConsumer, dyeList, plasterList, KekeBlocks.PLASTER.get(), "plaster");
        bleachBlockAlt(recipeConsumer, plasterList, KekeBlocks.PLASTER.get(), "plaster");




        //GYPSUM
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_BRICKS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.POLISHED_GYPSUM, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_BRICK_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_BRICK_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_BRICK_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.POLISHED_GYPSUM_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.POLISHED_GYPSUM_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.POLISHED_GYPSUM_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM_BRICKS, KekeBlocks.GYPSUM_BRICK_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM_BRICKS, KekeBlocks.GYPSUM_BRICK_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM_BRICKS, KekeBlocks.GYPSUM_BRICK_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_GYPSUM, KekeBlocks.POLISHED_GYPSUM_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_GYPSUM, KekeBlocks.POLISHED_GYPSUM_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_GYPSUM, KekeBlocks.POLISHED_GYPSUM_WALL, 1, recipeConsumer);
        stairRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.GYPSUM_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.GYPSUM_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.GYPSUM_WALL.get(), recipeConsumer);
        stairRecipe(KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM_WALL.get(), recipeConsumer);
        stairRecipe(KekeBlocks.GYPSUM_BRICKS.get(), KekeBlocks.GYPSUM_BRICK_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.GYPSUM_BRICKS.get(), KekeBlocks.GYPSUM_BRICK_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.GYPSUM_BRICKS.get(), KekeBlocks.GYPSUM_BRICK_WALL.get(), recipeConsumer);

        //GYPSUM TO BRICK OR POLISHED RECIPES
        typeRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM.get(), recipeConsumer);
        typeRecipe(KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.GYPSUM_BRICKS.get(), recipeConsumer);

        //SOAPSTONE
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_WALL.get().asItem(), 1, recipeConsumer);
        stairRecipe(KekeBlocks.SOAPSTONE.get(), KekeBlocks.SOAPSTONE_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.SOAPSTONE.get(), KekeBlocks.SOAPSTONE_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.SOAPSTONE.get(), KekeBlocks.SOAPSTONE_WALL.get(), recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_WALL.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_BRICKS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_WALL.get().asItem(), 1, recipeConsumer);

        //SOAPSTONE TO BRICK OR POLISHED RECIPES
        typeRecipe(KekeBlocks.SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE.get(), recipeConsumer);
        typeRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.SOAPSTONE_BRICKS.get(), recipeConsumer);

        //POLISHED SOAPSTONE
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_WALL.get().asItem(), 1, recipeConsumer);
        stairRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE_WALL.get(), recipeConsumer);

        //SOAPSTONE BRICKS
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE_BRICKS.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE_BRICKS.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE_BRICKS.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_WALL.get().asItem(), 1, recipeConsumer);
        stairRecipe(KekeBlocks.SOAPSTONE_BRICKS.get(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.SOAPSTONE_BRICKS.get(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.SOAPSTONE_BRICKS.get(), KekeBlocks.SOAPSTONE_BRICK_WALL.get(), recipeConsumer);

        //TERRACOTTA SHINGLES
        typeRecipe(Blocks.TERRACOTTA, KekeBlocks.TERRACOTTA_SHINGLES.get(), recipeConsumer);
        stairRecipe(KekeBlocks.TERRACOTTA_SHINGLES.get(), KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.TERRACOTTA_SHINGLES.get(), KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.TERRACOTTA_SHINGLES.get(), KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.TERRACOTTA_SHINGLES.get().asItem(), KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get().asItem(),1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.TERRACOTTA_SHINGLES.get().asItem(), KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get().asItem(),1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.TERRACOTTA_SHINGLES.get().asItem(), KekeBlocks.TERRACOTTA_SHINGLE_WALL.get().asItem(),1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, Blocks.TERRACOTTA.asItem(), KekeBlocks.TERRACOTTA_SHINGLES.get().asItem(), 1, recipeConsumer);

        //PLASTER
        smeltingRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.PLASTER.get(), RecipeCategory.BUILDING_BLOCKS, 0F, recipeConsumer);

        //CHALK
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getChalk(DyeColor.WHITE.getId()),2)
                .pattern("QK")
                .pattern("KQ")
                .define('K', Blocks.CALCITE)
                .define('Q', KekeBlocks.GYPSUM.get())
                .unlockedBy(getItemName(Blocks.CALCITE), has(Blocks.CALCITE))
                .unlockedBy(getItemName(KekeBlocks.GYPSUM.get()), has(KekeBlocks.GYPSUM.get()))
                .save(recipeConsumer);

        //CORK
        planksFromLogsRecipe(KekeBlocks.CORK_LOG, KekeBlocks.CORK_PLANKS, recipeConsumer);
        woodFromLogsRecipe(KekeBlocks.CORK_LOG, KekeBlocks.CORK_WOOD, recipeConsumer);
        woodFromLogsRecipe(KekeBlocks.STRIPPED_CORK_LOG, KekeBlocks.STRIPPED_CORK_WOOD, recipeConsumer);
        slabRecipe(KekeBlocks.CORK_PLANKS.get(), KekeBlocks.CORK_SLAB.get(), recipeConsumer);
        fenceRecipe(KekeBlocks.CORK_PLANKS, KekeBlocks.CORK_FENCE, recipeConsumer);
        stairRecipe(KekeBlocks.CORK_PLANKS.get(), KekeBlocks.CORK_STAIRS.get(), recipeConsumer);
        buttonRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.CORK_PLANKS.get(), KekeBlocks.CORK_BUTTON, recipeConsumer);
        pressurePlateRecipe(KekeBlocks.CORK_PLANKS, KekeBlocks.CORK_PRESSURE_PLATE, recipeConsumer);
        doorRecipe(KekeBlocks.CORK_PLANKS, KekeBlocks.CORK_DOOR, recipeConsumer);
        trapdoorRecipe(KekeBlocks.CORK_PLANKS, KekeBlocks.CORK_TRAPDOOR, recipeConsumer);
        fenceGateRecipe(KekeBlocks.CORK_PLANKS, KekeBlocks.CORK_FENCE_GATE, recipeConsumer);
        signRecipe(KekeBlocks.CORK_PLANKS, KekeBlocks.CORK_SIGN, recipeConsumer);
        hangingSignRecipe(KekeBlocks.STRIPPED_CORK_LOG, KekeBlocks.CORK_HANGING_SIGN, recipeConsumer);
        woodenBoat(recipeConsumer, KekeItems.CORK_BOAT.get(), KekeBlocks.CORK_PLANKS.get());
        chestBoatRecipe(recipeConsumer, KekeItems.CORK_CHEST_BOAT.get(), KekeItems.CORK_BOAT.get());

        for (DyeColor colours : DyeColor.values()) {
            //CHALK
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getChalk(colours.getId()).asItem(), KekeItems.getChalkStick(colours.getId()), 1, recipeConsumer);
            //SOAPSTONE
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneWall(colours.getId()), recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()).asItem(), 1, recipeConsumer);
            //SOAPSTONE TO BRICK OR POLISHED RECIPES
            typeRecipe(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstone(colours.getId()), recipeConsumer);
            typeRecipe(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneBricks(colours.getId()), recipeConsumer);
            //POLISHED SOAPSTONE
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()), recipeConsumer);
            //SOAPSTONE BRICKS
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()), recipeConsumer);

            //DYE SOAPSTONE RECIPES
            dyeBlockRecipe(KekeBlocks.SOAPSTONE.get(), colours, KekeBlocks.getDyedSoapstone(colours.getId()), "soapstone", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_STAIRS.get(), colours, KekeBlocks.getDyedSoapstoneStairs(colours.getId()), "soapstone_stairs", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_SLAB.get(), colours, KekeBlocks.getDyedSoapstoneSlab(colours.getId()), "soapstone_slab", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_WALL.get(), colours, KekeBlocks.getDyedSoapstoneWall(colours.getId()), "soapstone_wall", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), colours, KekeBlocks.getDyedPolishedSoapstone(colours.getId()), "polished_soapstone", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get(), colours, KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), "polished_soapstone_stairs", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.POLISHED_SOAPSTONE_SLAB.get(), colours, KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), "polished_soapstone_slab", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.POLISHED_SOAPSTONE_WALL.get(), colours, KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()), "polished_soapstone_wall", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_BRICKS.get(), colours, KekeBlocks.getDyedSoapstoneBricks(colours.getId()), "soapstone_brick", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), colours, KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()), "soapstone_brick_stairs", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), colours, KekeBlocks.getDyedSoapstoneSlab(colours.getId()), "soapstone_brick_slab", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_BRICK_WALL.get(), colours, KekeBlocks.getDyedSoapstoneWall(colours.getId()), "soapstone_brick_wall", recipeConsumer);

            //MUD BRICKS
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedMudBricks(colours.getId()).asItem(), KekeBlocks.getDyedMudBrickStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedMudBricks(colours.getId()).asItem(), KekeBlocks.getDyedMudBrickSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedMudBricks(colours.getId()).asItem(), KekeBlocks.getDyedMudBrickWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(KekeBlocks.getDyedMudBricks(colours.getId()), KekeBlocks.getDyedMudBrickStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedMudBricks(colours.getId()), KekeBlocks.getDyedMudBrickSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedMudBricks(colours.getId()), KekeBlocks.getDyedMudBrickWall(colours.getId()), recipeConsumer);
            dyeBlockRecipe(Blocks.MUD_BRICKS, colours, KekeBlocks.getDyedMudBricks(colours.getId()), "mud_bricks", recipeConsumer);
            dyeBlockRecipe(Blocks.MUD_BRICK_STAIRS, colours, KekeBlocks.getDyedMudBrickStairs(colours.getId()), "mud_brick_stairs", recipeConsumer);
            dyeBlockRecipe(Blocks.MUD_BRICK_SLAB, colours, KekeBlocks.getDyedMudBrickSlab(colours.getId()), "mud_brick_slab", recipeConsumer);
            dyeBlockRecipe(Blocks.MUD_BRICK_WALL, colours, KekeBlocks.getDyedMudBrickWall(colours.getId()), "mud_brick_wall", recipeConsumer);

            //PAINTBRUSH
            paintbrushRecipe(colours, KekeItems.getPaintBrush(colours.getId()), recipeConsumer);

            //TERRACOTTA SHINGLES
            typeRecipe(ArtsAndCraftsDyedBlockLists.getDyedTerracotta(colours.getId()), KekeBlocks.getDyedTerracottaShingles(colours.getId()), recipeConsumer);
            dyeBlockRecipe(KekeBlocks.TERRACOTTA_SHINGLES.get(), colours, KekeBlocks.getDyedTerracottaShingles(colours.getId()), "terracotta_shingle", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), colours, KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), "terracotta_shingle_stairs", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), colours, KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), "terracotta_shingle_slab", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), colours, KekeBlocks.getDyedTerracottaShingleWall(colours.getId()), "terracotta_shingle_wall", recipeConsumer);
            stairRecipe(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()), recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()).asItem(),1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()).asItem(),1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()).asItem(),1, recipeConsumer);

            //PLASTER
            dyeBlockRecipe(KekeBlocks.PLASTER.get(), colours, KekeBlocks.getDyedPlaster(colours.getId()), "plaster", recipeConsumer);

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
                    .requires(KekeItems.BLEACHDEW.get())
                    .group(group)
                    .unlockedBy(getItemName(KekeItems.BLEACHDEW.get()), has(KekeItems.BLEACHDEW.get()))
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
    protected static void paintbrushRecipe(DyeColor dyeColour, PaintBrushItem paintbrushItem, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, paintbrushItem,1)
                .pattern(" K ")
                .pattern("KQK")
                .define('K', DyeItem.byColor(dyeColour))
                .define('Q', Items.BRUSH)
                .group("paintbrush")
                .unlockedBy(getItemName(DyeItem.byColor(dyeColour)), has(DyeItem.byColor(dyeColour)))
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

    protected static void bleachBlockAlt(Consumer<FinishedRecipe> p_289666_, List<Item> p_289675_, ItemLike bleachedBlock, String p_289641_) {
        for(int i = 0; i < p_289675_.size(); ++i) {
            Item item = p_289675_.get(i);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bleachedBlock, 8)
                    .pattern("KKK")
                    .pattern("KQK")
                    .pattern("KKK")
                    .define('K', item)
                    .define('Q', KekeItems.BLEACHDEW.get())
                    .group(p_289641_)
                    .unlockedBy("has_needed_dye", has(KekeItems.BLEACHDEW.get())).save(p_289666_, "arts_and_crafts:" + "bleach_" + getItemName(item));
        }
    }
    protected static void bleachBlock(Consumer<FinishedRecipe> p_289666_, List<Item> p_289675_, ItemLike bleachedBlock, String p_289641_) {
        for(int i = 0; i < p_289675_.size(); ++i) {
            Item item = p_289675_.get(i);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, bleachedBlock)
                    .requires(item)
                    .requires(KekeItems.BLEACHDEW.get())
                    .group(p_289641_)
                    .unlockedBy("has_needed_dye", has(KekeItems.BLEACHDEW.get())).save(p_289666_, "arts_and_crafts:" + "bleach_" + getItemName(item));
        }
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
