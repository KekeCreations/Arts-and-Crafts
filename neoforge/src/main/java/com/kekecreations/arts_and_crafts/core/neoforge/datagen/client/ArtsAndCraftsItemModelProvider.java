package com.kekecreations.arts_and_crafts.core.neoforge.datagen.client;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ArtsAndCraftsItemModelProvider extends ItemModelProvider {
    public ArtsAndCraftsItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //CHALK STICKS
        for (DyeColor colours : DyeColor.values()) {
            basicHandheld(ACItems.getChalkStick(colours.getId()));
            basicItem(ACBlocks.getDyedFlowerPot(colours.getId()).asItem());
            decoratedPotItem(ACItems.getDyedDecoratedPotBlockItem(colours));
            basicHandheld(ACItems.getPaintBrush(colours.getId()));
        }
        basicHandheld(ACItems.BLEACHED_CHALK_STICK.get());
        basicItem(ACItems.CORK_BOAT.get());
        basicItem(ACItems.CORK_CHEST_BOAT.get());
        basicItem(ACItems.POTTERY_SHERD.get());
        basicItem(ACItems.ROLL_POTTERY_SHERD.get());
        basicItem(ACItems.RUINED_POTTERY_SHERD.get());
        basicItem(ACItems.FINALE_POTTERY_SHERD.get());
        basicItem(ACItems.GATEWAY_POTTERY_SHERD.get());
        basicHandheld(ACItems.BLEACHDEW_PAINTBRUSH.get());
        basicItem(ACItems.BLEACHDEW.get());
        basicItem(ACBlocks.CORK_DOOR.get().asItem());
        basicItemWithBlockFolder(ACBlocks.CORK_SAPLING.get().asItem());
        basicItem(ACItems.CORK_SIGN.get());
        basicItem(ACItems.CORK_HANGING_SIGN.get());
        basicItem(ACItems.LOTUS_PISTILS.get());
        bedBlockItem(ACItems.BLEACHED_BED.get());
        buttonInventory(ACBlocks.CORK_BUTTON.get().asItem(), "cork_planks");
    }
    private ResourceLocation key(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }

    private String name(Item item) {
        return key(item).getPath();
    }

    private void basicItemWithBlockFolder(Item item) {
        withExistingParent(name(item), ResourceLocation.withDefaultNamespace(ItemModelProvider.ITEM_FOLDER + "/generated"))
                .texture("layer0", ArtsAndCrafts.id(ItemModelProvider.BLOCK_FOLDER + "/" + name(item)));
    }

    private void basicHandheld(Item item) {
        withExistingParent(name(item), ResourceLocation.withDefaultNamespace(ItemModelProvider.ITEM_FOLDER + "/handheld"))
                .texture("layer0", ArtsAndCrafts.id(ItemModelProvider.ITEM_FOLDER + "/" + name(item)));
    }

    private void decoratedPotItem(Item item) {
        withExistingParent(name(item), ResourceLocation.withDefaultNamespace(ItemModelProvider.ITEM_FOLDER + "/decorated_pot"))
                .texture("particle", ArtsAndCrafts.id(ItemModelProvider.ITEM_FOLDER + "/" + name(item) + "_side"));
    }

    public void bedBlockItem(Item item) {
        withExistingParent(name(item), ResourceLocation.withDefaultNamespace(ItemModelProvider.ITEM_FOLDER + "/template_bed"))
                .texture("particle", ArtsAndCrafts.id(ItemModelProvider.BLOCK_FOLDER + "/bleached_wool"));
    }
    public void buttonInventory(Item item, String texture) {
        withExistingParent(name(item), BLOCK_FOLDER + "/button_inventory").texture("texture", ArtsAndCrafts.id(ItemModelProvider.BLOCK_FOLDER + "/" + texture));
    }
}
