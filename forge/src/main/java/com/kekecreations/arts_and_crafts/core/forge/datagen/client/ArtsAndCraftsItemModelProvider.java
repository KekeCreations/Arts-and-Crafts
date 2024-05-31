package com.kekecreations.arts_and_crafts.core.forge.datagen.client;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.data.models.model.TextureSlot.LAYER0;

public class ArtsAndCraftsItemModelProvider extends ItemModelProvider {
    public ArtsAndCraftsItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //CHALK STICKS
        for (DyeColor colours : DyeColor.values()) {
            basicHandheld(KekeItems.getChalkStick(colours.getId()));
            basicItem(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem());
            decoratedPotItem(KekeItems.getDyedDecoratedPotBlockItem(colours));
            basicHandheld(KekeItems.getPaintBrush(colours.getId()));
        }
        basicHandheld(KekeItems.BLEACHED_CHALK_STICK.get());
        basicItem(KekeItems.CORK_BOAT.get());
        basicItem(KekeItems.CORK_CHEST_BOAT.get());
        basicItem(KekeItems.ROLL_POTTERY_SHERD.get());
        basicItem(KekeItems.RUINED_POTTERY_SHERD.get());
        basicItem(KekeItems.FINALE_POTTERY_SHERD.get());
        basicItem(KekeItems.GATEWAY_POTTERY_SHERD.get());
        basicHandheld(KekeItems.BLEACHDEW_PAINTBRUSH.get());
        basicItem(KekeItems.BLEACHDEW.get());
        basicItem(KekeBlocks.CORK_DOOR.get().asItem());
        basicItemWithBlockFolder(KekeBlocks.CORK_SAPLING.get().asItem());
        basicItem(KekeItems.CORK_SIGN.get());
        basicItem(KekeItems.CORK_HANGING_SIGN.get());
        basicItem(KekeItems.LOTUS_PISTILS.get());
    }
    private ResourceLocation key(Item item) {
        return ForgeRegistries.ITEMS.getKey(item);
    }

    private String name(Item item) {
        return key(item).getPath();
    }

    private void basicItemWithBlockFolder(Item item) {
        withExistingParent(name(item), new ResourceLocation(ItemModelProvider.ITEM_FOLDER + "/generated"))
                .texture("layer0", ArtsAndCrafts.id(ItemModelProvider.BLOCK_FOLDER + "/" + name(item)));
    }

    private void basicHandheld(Item item) {
        withExistingParent(name(item), new ResourceLocation(ItemModelProvider.ITEM_FOLDER + "/handheld"))
                .texture("layer0", ArtsAndCrafts.id(ItemModelProvider.ITEM_FOLDER + "/" + name(item)));
    }

    private void decoratedPotItem(Item item) {
        withExistingParent(name(item), new ResourceLocation(ItemModelProvider.ITEM_FOLDER + "/decorated_pot"))
                .texture("particle", ArtsAndCrafts.id(ItemModelProvider.ITEM_FOLDER + "/" + name(item) + "_side"));
    }
}
