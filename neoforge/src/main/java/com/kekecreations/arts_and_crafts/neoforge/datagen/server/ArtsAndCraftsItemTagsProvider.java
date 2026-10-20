package com.kekecreations.arts_and_crafts.neoforge.datagen.server;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.init.ACTags;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsItemTagsProvider extends ItemTagsProvider {


    public ArtsAndCraftsItemTagsProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, String modId, ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        appendPlanks();
        appendLogsThatBurn();
        appendWoodenButtons();
        appendWoodenSlabs();
        appendWoodenDoors();
        appendWoodenFences();
        appendWoodenStairs();
        appendWoodenPressurePlates();
        appendWoodenTrapdoors();
        appendDecoratedPotSherds();
        appendDecoratedPots();
        appendDyes();
        appendChalkSticks();
        appendBoats();
        appendChestBoats();
        appendWoolCarpets();
        appendPaintbrushes();
        appendSigns();
        appendHangingSigns();
        appendSaplings();
        appendFenceGates();
        appendBeds();
        appendWools();
        appendCanBePotted();
    }

    private void appendCanBePotted() {
        this.tag(ACTags.ItemTags.CAN_BE_POTTED)
                .add(Items.TORCHFLOWER)
                .add(Items.MANGROVE_PROPAGULE)
                .add(Items.FERN)
                .add(Items.DANDELION)
                .add(Items.POPPY)
                .add(Items.BLUE_ORCHID)
                .add(Items.ALLIUM)
                .add(Items.AZURE_BLUET)
                .add(Items.RED_TULIP)
                .add(Items.ORANGE_TULIP)
                .add(Items.WHITE_TULIP)
                .add(Items.PINK_TULIP)
                .add(Items.OXEYE_DAISY)
                .add(Items.CORNFLOWER)
                .add(Items.LILY_OF_THE_VALLEY)
                .add(Items.WITHER_ROSE)
                .add(Items.RED_MUSHROOM)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.DEAD_BUSH)
                .add(Items.CACTUS)
                .add(Items.BAMBOO)
                .add(Items.CRIMSON_FUNGUS)
                .add(Items.WARPED_FUNGUS)
                .add(Items.AZALEA)
                .add(Items.FLOWERING_AZALEA)
                .addOptional(ResourceLocation.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "cork_sapling"));
    }

    private void appendBeds() {
        this.tag(ItemTags.BEDS)
                .add(ACBlocks.BLEACHED_BED.get().asItem());
    }

    private void appendWools() {
        this.tag(ItemTags.WOOL)
                .add(ACBlocks.BLEACHED_WOOL.get().asItem());
    }


    private void appendFenceGates() {
        this.tag(ItemTags.FENCE_GATES)
                .add(ACBlocks.CORK_FENCE_GATE.get().asItem());
    }
    private void appendWoodenSlabs() {
        this.tag(ItemTags.WOODEN_SLABS)
                .add(ACBlocks.CORK_SLAB.get().asItem());
    }
    private void appendWoodenDoors() {
        this.tag(ItemTags.WOODEN_DOORS)
                .add(ACBlocks.CORK_DOOR.get().asItem());
    }
    private void appendWoodenFences() {
        this.tag(ItemTags.WOODEN_FENCES)
                .add(ACBlocks.CORK_FENCE.get().asItem());
    }
    private void appendWoodenStairs() {
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ACBlocks.CORK_STAIRS.get().asItem());
    }
    private void appendWoodenPressurePlates() {
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ACBlocks.CORK_PRESSURE_PLATE.get().asItem());
    }
    private void appendWoodenTrapdoors() {
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ACBlocks.CORK_TRAPDOOR.get().asItem());
    }
    private void appendSigns() {
        this.tag(ItemTags.SIGNS)
                .add(ACItems.CORK_SIGN.get());
    }
    private void appendHangingSigns() {
        this.tag(ItemTags.HANGING_SIGNS)
                .add(ACItems.CORK_HANGING_SIGN.get());
    }
    private void appendSaplings() {
        this.tag(ItemTags.SAPLINGS)
                .add(ACBlocks.CORK_SAPLING.get().asItem());
    }
    private void appendPaintbrushes() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(ACTags.ItemTags.PAINTBRUSHES)
                    .add(ACItems.getPaintBrush(colours.getId()));
        }
        this.tag(ACTags.ItemTags.PAINTBRUSHES)
                .add(ACItems.BLEACHDEW_PAINTBRUSH.get());
    }

    private void appendWoolCarpets() {
        this.tag(ItemTags.WOOL_CARPETS)
                .add(ACBlocks.BLEACHED_CARPET.get().asItem());
    }
    private void appendBoats() {
        this.tag(ItemTags.BOATS)
                .add(ACItems.CORK_BOAT.get());
    }
    private void appendChestBoats() {
        this.tag(ItemTags.CHEST_BOATS)
                .add(ACItems.CORK_CHEST_BOAT.get());
    }

    private void appendDyes() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(ACTags.ItemTags.DYES)
                    .add(DyeItem.byColor(colours));
        }
    }
    private void appendChalkSticks() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(ACTags.ItemTags.CHALK_STICKS)
                    .add(ACItems.getChalkStick(colours.getId()));
        }
        this.tag(ACTags.ItemTags.CHALK_STICKS)
                .add(ACItems.BLEACHED_CHALK_STICK.get());
    }
    private void appendDecoratedPots() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(ACTags.ItemTags.DECORATED_POTS)
                    .add(Items.DECORATED_POT)
                    .add(ACItems.getDyedDecoratedPotBlockItem(colours));
        }
    }
    private void appendDecoratedPotSherds() {
        this.tag(ItemTags.DECORATED_POT_SHERDS)
                .add(ACItems.ROLL_POTTERY_SHERD.get())
                .add(ACItems.RUINED_POTTERY_SHERD.get())
                .add(ACItems.FINALE_POTTERY_SHERD.get())
                .add(ACItems.GATEWAY_POTTERY_SHERD.get())
                .add(ACItems.POTTERY_SHERD.get())
                .add(ACItems.SUS_POTTERY_SHERD.get());
    }

    private void appendPlanks() {
        this.tag(ItemTags.PLANKS)
                .add(ACBlocks.CORK_PLANKS.get().asItem());
    }
    private void appendWoodenButtons() {
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ACBlocks.CORK_BUTTON.get().asItem());
    }
    private void appendLogsThatBurn() {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ACBlocks.CORK_LOG.get().asItem())
                .add(ACBlocks.STRIPPED_CORK_LOG.get().asItem())
                .add(ACBlocks.CORK_WOOD.get().asItem())
                .add(ACBlocks.STRIPPED_CORK_WOOD.get().asItem());
    }
}
