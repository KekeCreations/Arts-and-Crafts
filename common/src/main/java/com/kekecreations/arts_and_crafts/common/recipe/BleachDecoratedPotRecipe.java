package com.kekecreations.arts_and_crafts.common.recipe;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.util.ACTags;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.arts_and_crafts.core.registry.ACRecipeSerializer;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class BleachDecoratedPotRecipe extends CustomRecipe {
    public BleachDecoratedPotRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }
    public boolean matches(CraftingInput craftingContainer, @NotNull Level level) {
        int i = 0;
        int j = 0;

        for(int k = 0; k < craftingContainer.size(); ++k) {
            ItemStack itemStack = craftingContainer.getItem(k);
            if (!itemStack.isEmpty()) {
                if (itemStack.is(ACTags.ItemTags.DECORATED_POTS) && !itemStack.is(Items.DECORATED_POT)) {
                    ++i;
                } else {
                    if (!(itemStack.is(ACItems.BLEACHDEW.get()))) {
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

    public @NotNull ItemStack assemble(CraftingInput craftingContainer, @NotNull HolderLookup.Provider provider) {
        ItemStack itemStack = ItemStack.EMPTY;

        for(int i = 0; i < craftingContainer.size(); ++i) {
            ItemStack itemStack2 = craftingContainer.getItem(i);
            if (!itemStack2.isEmpty()) {
                Item item = itemStack2.getItem();
                if (Block.byItem(item) instanceof DyedDecoratedPotBlock) {
                    itemStack = itemStack2;
                }
            }
        }

        Block block = Blocks.DECORATED_POT;
        return itemStack.transmuteCopy(block, 1);
    }

    public boolean canCraftInDimensions(int i, int j) {
        return i * j >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return ACRecipeSerializer.DYED_DECORATED_POT_RECIPE.get();
    }

}
