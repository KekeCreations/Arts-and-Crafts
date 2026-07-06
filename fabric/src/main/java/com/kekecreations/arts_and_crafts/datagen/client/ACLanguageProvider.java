package com.kekecreations.arts_and_crafts.datagen.client;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.util.PietraforteColour;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.CompletableFuture;

public class ACLanguageProvider extends FabricLanguageProvider {


    public ACLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("tab." + ArtsAndCrafts.MOD_ID + ".configurable_tab", "Arts & Crafts");
        for (PietraforteColour colour : PietraforteColour.values()) {
            String stringColour = StringUtils.capitalize(colour.getName());
            translationBuilder.add(ACBlocks.getCobbledPietraforte(colour).asItem(), "Cobbled " + stringColour + " Pietraforte");
            translationBuilder.add(ACBlocks.getCobbledPietraforteStairs(colour).asItem(), "Cobbled " + stringColour + " Pietraforte Stairs");
            translationBuilder.add(ACBlocks.getCobbledPietraforteSlab(colour).asItem(), "Cobbled " + stringColour + " Pietraforte Slab");
            translationBuilder.add(ACBlocks.getCobbledPietraforteWall(colour).asItem(), "Cobbled " + stringColour + " Pietraforte Wall");

            translationBuilder.add(ACBlocks.getPietraforte(colour).asItem(), stringColour + " Pietraforte");
            translationBuilder.add(ACBlocks.getPietraforteStairs(colour).asItem(), stringColour + " Pietraforte Stairs");
            translationBuilder.add(ACBlocks.getPietraforteSlab(colour).asItem(), stringColour + " Pietraforte Slab");
            translationBuilder.add(ACBlocks.getPietraforteWall(colour).asItem(), stringColour + " Pietraforte Wall");

            translationBuilder.add(ACBlocks.getChiseledPietraforte(colour).asItem(), "Chiseled " + stringColour + " Pietraforte");

            translationBuilder.add(ACBlocks.getPietraforteBricks(colour).asItem(), stringColour + " Pietraforte Bricks");
            translationBuilder.add(ACBlocks.getPietraforteBrickStairs(colour).asItem(), stringColour + " Pietraforte Brick Stairs");
            translationBuilder.add(ACBlocks.getPietraforteBrickSlab(colour).asItem(), stringColour + " Pietraforte Brick Slab");
            translationBuilder.add(ACBlocks.getPietraforteBrickWall(colour).asItem(), stringColour + " Pietraforte Brick Wall");

            translationBuilder.add(ACBlocks.getPietrafortePillar(colour).asItem(), stringColour + " Pietraforte Pillar");

            translationBuilder.add(ACBlocks.getSmoothPietraforte(colour).asItem(), "Smooth " + stringColour + " Pietraforte");
            translationBuilder.add(ACBlocks.getSmoothPietraforteStairs(colour).asItem(), "Smooth " + stringColour + " Pietraforte Stairs");
            translationBuilder.add(ACBlocks.getSmoothPietraforteSlab(colour).asItem(), "Smooth " + stringColour + " Pietraforte Slab");
            translationBuilder.add(ACBlocks.getSmoothPietraforteWall(colour).asItem(), "Smooth " + stringColour + " Pietraforte Wall");

            translationBuilder.add(ACBlocks.getCutPietraforte(colour).asItem(), "Cut " + stringColour + " Pietraforte");
            translationBuilder.add(ACBlocks.getCutPietraforteStairs(colour).asItem(), "Cut " + stringColour + " Pietraforte Stairs");
            translationBuilder.add(ACBlocks.getCutPietraforteSlab(colour).asItem(), "Cut " + stringColour + " Pietraforte Slab");
            translationBuilder.add(ACBlocks.getCutPietraforteWall(colour).asItem(), "Cut " + stringColour + " Pietraforte Wall");
        }
        for (DyeColor colours : DyeColor.values()) {
            String stringColour = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colours.getName(), "blue", "Blue"), "gray" ,"Gray"), "_", " "));

            //ITEMS
            translationBuilder.add(ACItems.getChalkStick(colours.getId()).asItem(), stringColour + " Chalk Stick");
            translationBuilder.add(ACItems.getPaintBrush(colours.getId()).asItem(), stringColour + " Paintbrush");


            //BLOCKS
            translationBuilder.add(ACBlocks.getDyedFlowerPot(colours.getId()).asItem(), stringColour + " Flower Pot");
            translationBuilder.add(ACBlocks.getChalkDust(colours.getId()), stringColour + " Chalk Dust");
            translationBuilder.add(ACBlocks.getChalk(colours.getId()).asItem(), stringColour + " Chalk");

            translationBuilder.add(ACBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), stringColour + " Terracotta Shingles");
            translationBuilder.add(ACBlocks.getDyedTerracottaShingleSlab(colours.getId()).asItem(), stringColour + " Terracotta Shingle Slab");
            translationBuilder.add(ACBlocks.getDyedTerracottaShingleWall(colours.getId()).asItem(), stringColour + " Terracotta Shingle Wall");
            translationBuilder.add(ACBlocks.getDyedTerracottaShingleStairs(colours.getId()).asItem(), stringColour + " Terracotta Shingle Stairs");

            translationBuilder.add(ACBlocks.getDyedMudBricks(colours.getId()).asItem(), stringColour + " Mud Bricks");
            translationBuilder.add(ACBlocks.getDyedMudBrickSlab(colours.getId()).asItem(), stringColour + " Mud Brick Slab");
            translationBuilder.add(ACBlocks.getDyedMudBrickWall(colours.getId()).asItem(), stringColour + " Mud Brick Wall");
            translationBuilder.add(ACBlocks.getDyedMudBrickStairs(colours.getId()).asItem(), stringColour + " Mud Brick Stairs");

            translationBuilder.add(ACBlocks.getDyedSoapstone(colours.getId()).asItem(), stringColour + " Soapstone");
            translationBuilder.add(ACBlocks.getDyedSoapstoneSlab(colours.getId()).asItem(), stringColour + " Soapstone Slab");
            translationBuilder.add(ACBlocks.getDyedSoapstoneWall(colours.getId()).asItem(), stringColour + " Soapstone Wall");
            translationBuilder.add(ACBlocks.getDyedSoapstoneStairs(colours.getId()).asItem(), stringColour + " Soapstone Stairs");

            translationBuilder.add(ACBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), stringColour + " Soapstone Bricks");
            translationBuilder.add(ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()).asItem(), stringColour + " Soapstone Brick Slab");
            translationBuilder.add(ACBlocks.getDyedSoapstoneBrickWall(colours.getId()).asItem(), stringColour + " Soapstone Brick Wall");
            translationBuilder.add(ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()).asItem(), stringColour + " Soapstone Brick Stairs");

            translationBuilder.add(ACBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), stringColour + " Polished Soapstone");
            translationBuilder.add(ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()).asItem(), stringColour + " Polished Soapstone Slab");
            translationBuilder.add(ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()).asItem(), stringColour + " Polished Soapstone Wall");
            translationBuilder.add(ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()).asItem(), stringColour + " Polished Soapstone Stairs");

            translationBuilder.add(ACBlocks.getDyedDecoratedPot(colours.getId()).asItem(), stringColour + " Decorated Pot");

            translationBuilder.add(ACBlocks.getDyedPlaster(colours.getId()).asItem(), stringColour + " Plaster");
        }
        //BLOCKS
        translationBuilder.add(ACBlocks.TERRACOTTA_SHINGLES.get().asItem(), "Terracotta Shingles");
        translationBuilder.add(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get().asItem(), "Terracotta Shingle Slab");
        translationBuilder.add(ACBlocks.TERRACOTTA_SHINGLE_WALL.get().asItem(), "Terracotta Shingle Wall");
        translationBuilder.add(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get().asItem(), "Terracotta Shingle Stairs");
        translationBuilder.add(ACBlocks.SOAPSTONE.get().asItem(), "Soapstone");
        translationBuilder.add(ACBlocks.SOAPSTONE_SLAB.get().asItem(), "Soapstone Slab");
        translationBuilder.add(ACBlocks.SOAPSTONE_WALL.get().asItem(), "Soapstone Wall");
        translationBuilder.add(ACBlocks.SOAPSTONE_STAIRS.get().asItem(), "Soapstone Stairs");
        translationBuilder.add(ACBlocks.SOAPSTONE_BRICKS.get().asItem(), "Soapstone Bricks");
        translationBuilder.add(ACBlocks.SOAPSTONE_BRICK_SLAB.get().asItem(), "Soapstone Brick Slab");
        translationBuilder.add(ACBlocks.SOAPSTONE_BRICK_WALL.get().asItem(), "Soapstone Brick Wall");
        translationBuilder.add(ACBlocks.SOAPSTONE_BRICK_STAIRS.get().asItem(), "Soapstone Brick Stairs");
        translationBuilder.add(ACBlocks.POLISHED_SOAPSTONE.get().asItem(), "Polished Soapstone");
        translationBuilder.add(ACBlocks.POLISHED_SOAPSTONE_SLAB.get().asItem(), "Polished Soapstone Slab");
        translationBuilder.add(ACBlocks.POLISHED_SOAPSTONE_WALL.get().asItem(), "Polished Soapstone Wall");
        translationBuilder.add(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get().asItem(), "Polished Soapstone Stairs");
        translationBuilder.add(ACBlocks.CORK_PLANKS.get().asItem(), "Cork Planks");
        translationBuilder.add(ACBlocks.CORK_LOG.get().asItem(), "Cork Log");
        translationBuilder.add(ACBlocks.STRIPPED_CORK_LOG.get().asItem(), "Stripped Cork Log");
        translationBuilder.add(ACBlocks.CORK_DOOR.get().asItem(), "Cork Door");
        translationBuilder.add(ACBlocks.CORK_TRAPDOOR.get().asItem(), "Cork Trapdoor");
        translationBuilder.add(ACBlocks.CORK_BUTTON.get().asItem(), "Cork Button");
        translationBuilder.add(ACBlocks.CORK_FENCE.get().asItem(), "Cork Fence");
        translationBuilder.add(ACBlocks.CORK_FENCE_GATE.get().asItem(), "Cork Fence Gate");
        translationBuilder.add(ACBlocks.CORK_PRESSURE_PLATE.get().asItem(), "Cork Pressure Plate");
        translationBuilder.add(ACBlocks.CORK_SLAB.get().asItem(), "Cork Slab");
        translationBuilder.add(ACBlocks.CORK_STAIRS.get().asItem(), "Cork Stairs");
        translationBuilder.add(ACBlocks.CORK_SIGN.get().asItem(), "Cork Sign");
        translationBuilder.add(ACBlocks.CORK_HANGING_SIGN.get().asItem(), "Cork Hanging Sign");
        translationBuilder.add(ACBlocks.CORK_WOOD.get().asItem(), "Cork Wood");
        translationBuilder.add(ACBlocks.STRIPPED_CORK_WOOD.get().asItem(), "Stripped Cork Wood");
        translationBuilder.add(ACBlocks.CORK.get().asItem(), "Cork");
        translationBuilder.add(ACBlocks.SMOOTH_CORK.get().asItem(), "Smooth Cork");
        translationBuilder.add(ACBlocks.CORK_LEAVES.get().asItem(), "Cork Leaves");
        translationBuilder.add(ACBlocks.CORK_SAPLING.get().asItem(), "Cork Sapling");
        translationBuilder.add(ACBlocks.PLASTER.get().asItem(), "Plaster");
        translationBuilder.add(ACBlocks.GYPSUM.get().asItem(), "Gypsum");
        translationBuilder.add(ACBlocks.GYPSUM_SLAB.get().asItem(), "Gypsum Slab");
        translationBuilder.add(ACBlocks.GYPSUM_WALL.get().asItem(), "Gypsum Wall");
        translationBuilder.add(ACBlocks.GYPSUM_STAIRS.get().asItem(), "Gypsum Stairs");
        translationBuilder.add(ACBlocks.GYPSUM_BRICKS.get().asItem(), "Gypsum Bricks");
        translationBuilder.add(ACBlocks.GYPSUM_BRICK_SLAB.get().asItem(), "Gypsum Brick Slab");
        translationBuilder.add(ACBlocks.GYPSUM_BRICK_WALL.get().asItem(), "Gypsum Brick Wall");
        translationBuilder.add(ACBlocks.GYPSUM_BRICK_STAIRS.get().asItem(), "Gypsum Brick Stairs");
        translationBuilder.add(ACBlocks.POLISHED_GYPSUM.get().asItem(), "Polished Gypsum");
        translationBuilder.add(ACBlocks.POLISHED_GYPSUM_SLAB.get().asItem(), "Polished Gypsum Slab");
        translationBuilder.add(ACBlocks.POLISHED_GYPSUM_WALL.get().asItem(), "Polished Gypsum Wall");
        translationBuilder.add(ACBlocks.POLISHED_GYPSUM_STAIRS.get().asItem(), "Polished Gypsum Stairs");
        translationBuilder.add(ACBlocks.LOTUS_FLOWER.get().asItem(), "Lotus Flower");
        translationBuilder.add(ACBlocks.BLEACHED_WOOL.get().asItem(), "Bleached Wool");
        translationBuilder.add(ACBlocks.BLEACHED_CARPET.get().asItem(), "Bleached Carpet");
        translationBuilder.add(ACBlocks.BLEACHED_CHALK.get().asItem(), "Bleached Chalk");
        translationBuilder.add(ACBlocks.GLAZED_TERRACOTTA.get().asItem(), "Glazed Terracotta");
        translationBuilder.add(ACBlocks.BLEACHED_CONCRETE.get().asItem(), "Bleached Concrete");
        translationBuilder.add(ACBlocks.BLEACHED_CONCRETE_POWDER.get().asItem(), "Bleached Concrete Powder");
        translationBuilder.add(ACBlocks.BLEACHED_BED.get().asItem(), "Bleached Bed");
        translationBuilder.add(ACBlocks.BLEACHED_CHALK_DUST.get(), "Bleached Chalk Dust");
        //translationBuilder.add(ACBlocks.CRIMSON_HANGING_FLOWER_POT.get().asItem(), "Crimson Hanging Flower Pot");



        //ITEMS
        translationBuilder.add(ACItems.CORK_BOAT.get(), "Cork Boat");
        translationBuilder.add(ACItems.CORK_CHEST_BOAT.get(), "Cork Boat with Chest");
        translationBuilder.add(ACItems.POTTERY_SHERD.get(), "Pottery Sherd");
        translationBuilder.add(ACItems.ROLL_POTTERY_SHERD.get(), "Roll Pottery Sherd");
        translationBuilder.add(ACItems.RUINED_POTTERY_SHERD.get(), "Ruined Pottery Sherd");
        translationBuilder.add(ACItems.FINALE_POTTERY_SHERD.get(), "Finale Pottery Sherd");
        translationBuilder.add(ACItems.GATEWAY_POTTERY_SHERD.get(), "Gateway Pottery Sherd");
        translationBuilder.add(ACItems.BLEACHDEW.get(), "Bleachdew");
        translationBuilder.add(ACItems.BLEACHDEW_PAINTBRUSH.get(), "Bleachdew Paintbrush");
        translationBuilder.add(ACItems.LOTUS_PISTILS.get(), "Lotus Pistils");
        translationBuilder.add(ACItems.BLEACHED_CHALK_STICK.get(), "Bleached Chalk Stick");

        //April fools
        translationBuilder.add(ACItems.SUS_POTTERY_SHERD.get(), "Sus Pottery Sherd");

        //ENTITY TYPES
        //translationBuilder.add(ACEntityTypes.CHEST_BOAT.get().asItem(), "Boat with Chest");
       // translationBuilder.add(ACEntityTypes.BOAT.get().asItem(), "Boat");
        //translationBuilder.add(ACEntityTypes.FLOATING_BLOCK.get().asItem(), "Floating Block");



        //ADVANCEMENTS
        //chalk
        translationBuilder.add("advancements.adventure.no_you_cant_eat_it.title", "No You Can't Eat It!");
        translationBuilder.add("advancements.adventure.no_you_cant_eat_it.description", "Craft any coloured chalk stick!");
        translationBuilder.add("advancements.adventure.board_planning.title", "Board Planning");
        translationBuilder.add("advancements.adventure.board_planning.description", "Have all chalk sticks in your inventory");
        translationBuilder.add("advancements.adventure.let_the_creativity_flow_through_you.title", "Let Creativity Flow Through You");
        translationBuilder.add("advancements.adventure.let_the_creativity_flow_through_you.description", "Cycle the chalk pattern forwards by interacting with chalk dust with a chalk stick in your main hand or off hand!!");
        translationBuilder.add("advancements.adventure.flashpoint.title", "Flashpoint");
        translationBuilder.add("advancements.adventure.flashpoint.description", "Cycle the chalk pattern backwards by shift clicking chalk dust with a chalk stick in your offhand!");
        translationBuilder.add("advancements.adventure.handpicked.title", "Handpicked");
        translationBuilder.add("advancements.adventure.handpicked.description", "Save a chalk pattern by shift clicking with a chalk stick in your main hand!");
        //lotus
        translationBuilder.add("advancements.husbandry.let_the_past_bloom.title", "Let The Past Bloom!");
        translationBuilder.add("advancements.husbandry.let_the_past_bloom.description", "Interact with a lily pad using some Lotus Pistils");
        translationBuilder.add("advancements.husbandry.circa_1980.title", "Circa 1980");
        translationBuilder.add("advancements.husbandry.circa_1980.description", "Obtain some bleachdew from a fully bloomed Lotus Flower!");
        //paintbrush & bleach
        translationBuilder.add("advancements.adventure.aspiring_davinci.title", "Aspiring Davinci!");
        translationBuilder.add("advancements.adventure.aspiring_davinci.description", "Craft any coloured paintbrush");
        translationBuilder.add("advancements.adventure.born_to_paint_forced_to_mop.title", "Born To Paint Forced To Mop");
        translationBuilder.add("advancements.adventure.born_to_paint_forced_to_mop.description", "Craft a bleachdew paintbrush");
        //sherd
        translationBuilder.add("advancements.adventure.a_clean_slate.title", "A Clean Slate!");
        translationBuilder.add("advancements.adventure.a_clean_slate.description", "Find a blank pottery sherd");








        //TOOL TIPS
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_0", "Dot Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_1", "Vertical Line Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_2", "Horizontal Line Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_3", "East To South Corner Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_4", "East To North Corner Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_5", "West To North Corner Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_6", "West To South Corner Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_7", "North T Cross Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_8", "West T Cross Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_9", "South T Cross Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_10", "East T Cross Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_11", "Plus Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_12", "Right Diagonal Line Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_13", "Left Diagonal Line Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_14", "X Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_15", "North Line Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_16", "East Line Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_17", "South Line Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_18", "West Line Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_19", "North Triangle Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_20", "East Triangle Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_21", "South Triangle Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_22", "West Triangle Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_23", "Circle Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_24", "Square Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_25", "East To South Block Corner Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_26", "East To North Block Corner Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_27", "West To North Block Corner Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_28", "West To South Block Corner Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_29", "East To South Arch Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_30", "East To North Arch Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_31", "West To North Arch Pattern");
        translationBuilder.add("tooltip.arts_and_crafts.chalk_pattern_32", "West To South Arch Pattern");
    }
}
