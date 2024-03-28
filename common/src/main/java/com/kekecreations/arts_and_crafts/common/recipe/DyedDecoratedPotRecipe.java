package com.kekecreations.arts_and_crafts.common.recipe;

import com.google.gson.JsonObject;
import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.item.DyedDecoratedPotBlockItem;
import com.kekecreations.arts_and_crafts.core.registry.KekeRecipeSerializer;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;

public class DyedDecoratedPotRecipe extends CustomRecipe {
    public DyedDecoratedPotRecipe(ResourceLocation resourceLocation, CraftingBookCategory craftingBookCategory) {
        super(resourceLocation, craftingBookCategory);
    }

    public boolean matches(CraftingContainer craftingContainer, Level level) {
        /*
        if (!this.canCraftInDimensions(craftingContainer.getWidth(), craftingContainer.getHeight())) {
            return false;
        } else {
            for(int i = 0; i < craftingContainer.getContainerSize(); ++i) {
                ItemStack itemStack = craftingContainer.getItem(i);
                switch (i) {
                    case 1:
                        if (!(itemStack.is(Items.RED_DYE))) {
                            return false;
                        }
                        break;
                    case 3:
                    case 5:
                    case 7:
                        if (!itemStack.is(ItemTags.DECORATED_POT_INGREDIENTS)) {
                            return false;
                        }
                        break;
                    case 2:
                    case 4:
                    case 6:
                    default:
                        if (!itemStack.is(Items.AIR)) {
                            return false;
                        }
                }
            }

            return true;
        }
         */
        int i = 0;
        int j = 0;

        for(int k = 0; k < craftingContainer.getContainerSize(); ++k) {
            ItemStack itemStack = craftingContainer.getItem(k);
            if (!itemStack.isEmpty()) {
                if (((itemStack.getItem()) instanceof DyedDecoratedPotBlockItem || itemStack.is(Items.DECORATED_POT)) && itemStack.hasTag()) {
                    ++i;
                } else {
                    if (!(itemStack.getItem() instanceof DyeItem)) {
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

    public ItemStack assemble(CraftingContainer craftingContainer, RegistryAccess registryAccess) {
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
        if (itemStack.hasTag()) {
            itemStack3.setTag(itemStack.getTag().copy());
        }

        return itemStack3;
    }

    public boolean canCraftInDimensions(int i, int j) {
        return i * j >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return KekeRecipeSerializer.DYED_DECORATED_POT_RECIPE;
    }

}
