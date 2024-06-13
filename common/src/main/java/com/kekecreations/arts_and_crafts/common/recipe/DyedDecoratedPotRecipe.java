package com.kekecreations.arts_and_crafts.common.recipe;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.registry.KekeRecipeSerializer;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.PotDecorations;
import org.jetbrains.annotations.NotNull;

public class DyedDecoratedPotRecipe extends CustomRecipe {
    public DyedDecoratedPotRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    public boolean matches(CraftingContainer craftingContainer, @NotNull Level level) {
        int i = 0;
        int j = 0;

        for(int k = 0; k < craftingContainer.getContainerSize(); ++k) {
            ItemStack itemStack = craftingContainer.getItem(k);
            if (!itemStack.isEmpty()) {
                if (itemStack.is(ArtsAndCraftsTags.ItemTags.DECORATED_POTS)) {
                    ++i;
                } else {
                    if (!(itemStack.is(ArtsAndCraftsTags.ItemTags.DYES))) {
                        return false;
                    }

                    ++j;
                }

                if (j > 1 || i > 1) {
                    return false;
                }
            }
        }

        return i == 1 && j == 1;
    }

    public @NotNull ItemStack assemble(CraftingContainer craftingContainer, @NotNull HolderLookup.Provider provider) {
        ItemStack itemStack = ItemStack.EMPTY;
        DyeItem dyeItem = (DyeItem)Items.WHITE_DYE;

        for(int i = 0; i < craftingContainer.getContainerSize(); ++i) {
            ItemStack itemStack2 = craftingContainer.getItem(i);
            if (!itemStack2.isEmpty()) {
                Item item = itemStack2.getItem();
                if (Block.byItem(item) instanceof DyedDecoratedPotBlock || Block.byItem(item) instanceof DecoratedPotBlock) {
                    itemStack = itemStack2;
                } else if (item instanceof DyeItem) {
                    dyeItem = (DyeItem)item;
                }
            }
        }

        ItemStack itemStack3 = DyedDecoratedPotBlock.getColoredItemStack(dyeItem.getDyeColor());
        if (!itemStack.getOrDefault(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY).ordered().isEmpty()) {
            //assert itemStack.getTag() != null;
            itemStack3.set(DataComponents.POT_DECORATIONS, itemStack.getComponents().get(DataComponents.POT_DECORATIONS));
            //itemStack3.setTag(itemStack.getTag().copy());
        }

        return itemStack3;
    }

    public boolean canCraftInDimensions(int i, int j) {
        return i * j >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return KekeRecipeSerializer.DYED_DECORATED_POT_RECIPE.get();
    }

}
