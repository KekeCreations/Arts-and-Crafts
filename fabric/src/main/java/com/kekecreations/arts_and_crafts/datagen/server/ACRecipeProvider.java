package com.kekecreations.arts_and_crafts.datagen.server;

import com.kekecreations.arts_and_crafts.core.init.ACTags;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static net.minecraft.data.recipes.RecipeProvider.getHasName;
import static net.minecraft.data.recipes.RecipeProvider.inventoryTrigger;

public class ACRecipeProvider extends FabricRecipeProvider {
    private static HolderGetter<Item> items;

    public ACRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
        try {
            items = registriesFuture.get().lookupOrThrow(Registries.ITEM);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                stairRecipe(ACBlocks.SOAPSTONE.get(), ACBlocks.SOAPSTONE_STAIRS.get(), exporter);
                dyedDecoratedPot(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ACRecipeProvider";
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike itemLike) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(items, new ItemLike[]{itemLike}));
    }


    protected Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tag) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(items, tag));
    }

    protected Ingredient tag(TagKey<Item> tag) {
        return Ingredient.of(items.getOrThrow(tag));
    }


    private void dyedDecoratedPot(RecipeOutput exporter) {
        Ingredient ingredient = this.tag(ACTags.ItemTags.DECORATED_POTS);

        for(DyeColor dyecolor : DyeColor.values()) {
            TransmuteRecipeBuilder.transmute(RecipeCategory.DECORATIONS,
                    ingredient,
                    Ingredient.of(DyeItem.byColor(dyecolor)),
                    ACBlocks.getDyedDecoratedPot(dyecolor.getId()).asItem())
                    .group("decorated_pot_dye")
                    .unlockedBy("has_decorated_pot", has(ACTags.ItemTags.DECORATED_POTS))
                    .save(exporter);
        }

        TransmuteRecipeBuilder.transmute(RecipeCategory.DECORATIONS,
                        ingredient,
                        Ingredient.of(ACItems.BLEACHDEW.get()),
                        Blocks.DECORATED_POT.asItem())
                .group("decorated_pot_dye")
                .unlockedBy("has_decorated_pot", has(ACTags.ItemTags.DECORATED_POTS))
                .save(exporter);
    }


    protected static void stairRecipe(Block craftingBlock, Block resultBlock, RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("K  ")
                .pattern("KK ")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getHasName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }
}
