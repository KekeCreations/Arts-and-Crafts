package com.kekecreations.arts_and_crafts.common.recipe;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.arts_and_crafts.core.registry.ACRecipeSerializer;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class BleachBannerPatternsRecipe extends CustomRecipe {
    public BleachBannerPatternsRecipe(ResourceLocation resourceLocation, CraftingBookCategory craftingBookCategory) {
        super(resourceLocation, craftingBookCategory);
    }

    public boolean matches(CraftingContainer craftingContainer, @NotNull Level level) {
        int i = 0;
        int j = 0;

        for(int k = 0; k < craftingContainer.getContainerSize(); ++k) {
            ItemStack itemStack = craftingContainer.getItem(k);
            if (!itemStack.isEmpty()) {
                if (itemStack.is(ItemTags.BANNERS) && itemStack.hasTag()) {
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

    public @NotNull ItemStack assemble(CraftingContainer craftingContainer, @NotNull RegistryAccess registryAccess) {
        ItemStack itemStack = ItemStack.EMPTY;

        for(int i = 0; i < craftingContainer.getContainerSize(); ++i) {
            ItemStack itemStack2 = craftingContainer.getItem(i);
            if (!itemStack2.isEmpty()) {
                Item item = itemStack2.getItem();
                if (Block.byItem(item) instanceof BannerBlock) {
                    itemStack = itemStack2;
                }
            }
        }

        if (itemStack.getItem() instanceof BannerItem bannerItem) {
            return ArtsAndCraftsDyedBlockLists.getDyedBanner(bannerItem.getColor().getId()).asItem().getDefaultInstance();
        }
        return itemStack;
    }

    public boolean canCraftInDimensions(int i, int j) {
        return i * j >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return ACRecipeSerializer.BLEACH_BANNER_PATTERNS_RECIPE.get();
    }

}
