package com.kekecreations.arts_and_crafts.core.neoforge.datagen.client;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

public class ArtsAndCraftsLangProvider extends LanguageProvider {
    public ArtsAndCraftsLangProvider(PackOutput output, String modid) {
        super(output, modid, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (DyeColor colours : DyeColor.values()) {
            String stringColour = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colours.getName(), "blue", "Blue"), "gray" ,"Gray"), "_", " "));

            //ITEMS
            add(ACItems.getChalkStick(colours.getId()), stringColour + " Chalk Stick");
            add(ACItems.getPaintBrush(colours.getId()), stringColour + " Paintbrush");


            //BLOCKS
            add(ACBlocks.getDyedFlowerPot(colours.getId()), stringColour + " Flower Pot");
            add(ACBlocks.getChalkDust(colours.getId()), stringColour + " Chalk Dust");
            add(ACBlocks.getChalk(colours.getId()), stringColour + " Chalk");

            add(ACBlocks.getDyedTerracottaShingles(colours.getId()), stringColour + " Terracotta Shingles");
            add(ACBlocks.getDyedTerracottaShingleSlab(colours.getId()), stringColour + " Terracotta Shingle Slab");
            add(ACBlocks.getDyedTerracottaShingleWall(colours.getId()), stringColour + " Terracotta Shingle Wall");
            add(ACBlocks.getDyedTerracottaShingleStairs(colours.getId()), stringColour + " Terracotta Shingle Stairs");

            add(ACBlocks.getDyedMudBricks(colours.getId()), stringColour + " Mud Bricks");
            add(ACBlocks.getDyedMudBrickSlab(colours.getId()), stringColour + " Mud Brick Slab");
            add(ACBlocks.getDyedMudBrickWall(colours.getId()), stringColour + " Mud Brick Wall");
            add(ACBlocks.getDyedMudBrickStairs(colours.getId()), stringColour + " Mud Brick Stairs");

            add(ACBlocks.getDyedSoapstone(colours.getId()), stringColour + " Soapstone");
            add(ACBlocks.getDyedSoapstoneSlab(colours.getId()), stringColour + " Soapstone Slab");
            add(ACBlocks.getDyedSoapstoneWall(colours.getId()), stringColour + " Soapstone Wall");
            add(ACBlocks.getDyedSoapstoneStairs(colours.getId()), stringColour + " Soapstone Stairs");

            add(ACBlocks.getDyedSoapstoneBricks(colours.getId()), stringColour + " Soapstone Bricks");
            add(ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()), stringColour + " Soapstone Brick Slab");
            add(ACBlocks.getDyedSoapstoneBrickWall(colours.getId()), stringColour + " Soapstone Brick Wall");
            add(ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()), stringColour + " Soapstone Brick Stairs");

            add(ACBlocks.getDyedPolishedSoapstone(colours.getId()), stringColour + " Polished Soapstone");
            add(ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), stringColour + " Polished Soapstone Slab");
            add(ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()), stringColour + " Polished Soapstone Wall");
            add(ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), stringColour + " Polished Soapstone Stairs");

            add(ACBlocks.getDyedDecoratedPot(colours.getId()), stringColour + " Decorated Pot");

            add(ACBlocks.getDyedPlaster(colours.getId()), stringColour + " Plaster");
        }
        //BLOCKS
        add(ACBlocks.TERRACOTTA_SHINGLES.get(), "Terracotta Shingles");
        add(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get(), "Terracotta Shingle Slab");
        add(ACBlocks.TERRACOTTA_SHINGLE_WALL.get(), "Terracotta Shingle Wall");
        add(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), "Terracotta Shingle Stairs");
        add(ACBlocks.SOAPSTONE.get(), "Soapstone");
        add(ACBlocks.SOAPSTONE_SLAB.get(), "Soapstone Slab");
        add(ACBlocks.SOAPSTONE_WALL.get(), "Soapstone Wall");
        add(ACBlocks.SOAPSTONE_STAIRS.get(), "Soapstone Stairs");
        add(ACBlocks.SOAPSTONE_BRICKS.get(), "Soapstone Bricks");
        add(ACBlocks.SOAPSTONE_BRICK_SLAB.get(), "Soapstone Brick Slab");
        add(ACBlocks.SOAPSTONE_BRICK_WALL.get(), "Soapstone Brick Wall");
        add(ACBlocks.SOAPSTONE_BRICK_STAIRS.get(), "Soapstone Brick Stairs");
        add(ACBlocks.POLISHED_SOAPSTONE.get(), "Polished Soapstone");
        add(ACBlocks.POLISHED_SOAPSTONE_SLAB.get(), "Polished Soapstone Slab");
        add(ACBlocks.POLISHED_SOAPSTONE_WALL.get(), "Polished Soapstone Wall");
        add(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get(), "Polished Soapstone Stairs");
        add(ACBlocks.CORK_PLANKS.get(), "Cork Planks");
        add(ACBlocks.CORK_LOG.get(), "Cork Log");
        add(ACBlocks.STRIPPED_CORK_LOG.get(), "Stripped Cork Log");
        add(ACBlocks.CORK_DOOR.get(), "Cork Door");
        add(ACBlocks.CORK_TRAPDOOR.get(), "Cork Trapdoor");
        add(ACBlocks.CORK_BUTTON.get(), "Cork Button");
        add(ACBlocks.CORK_FENCE.get(), "Cork Fence");
        add(ACBlocks.CORK_FENCE_GATE.get(), "Cork Fence Gate");
        add(ACBlocks.CORK_PRESSURE_PLATE.get(), "Cork Pressure Plate");
        add(ACBlocks.CORK_SLAB.get(), "Cork Slab");
        add(ACBlocks.CORK_STAIRS.get(), "Cork Stairs");
        add(ACBlocks.CORK_SIGN.get(), "Cork Sign");
        add(ACBlocks.CORK_HANGING_SIGN.get(), "Cork Hanging Sign");
        add(ACBlocks.CORK_WOOD.get(), "Cork Wood");
        add(ACBlocks.STRIPPED_CORK_WOOD.get(), "Stripped Cork Wood");
        add(ACBlocks.CORK.get(), "Cork");
        add(ACBlocks.SMOOTH_CORK.get(), "Smooth Cork");
        add(ACBlocks.CORK_LEAVES.get(), "Cork Leaves");
        add(ACBlocks.CORK_SAPLING.get(), "Cork Sapling");
        add(ACBlocks.PLASTER.get(), "Plaster");
        add(ACBlocks.GYPSUM.get(), "Gypsum");
        add(ACBlocks.GYPSUM_SLAB.get(), "Gypsum Slab");
        add(ACBlocks.GYPSUM_WALL.get(), "Gypsum Wall");
        add(ACBlocks.GYPSUM_STAIRS.get(), "Gypsum Stairs");
        add(ACBlocks.GYPSUM_BRICKS.get(), "Gypsum Bricks");
        add(ACBlocks.GYPSUM_BRICK_SLAB.get(), "Gypsum Brick Slab");
        add(ACBlocks.GYPSUM_BRICK_WALL.get(), "Gypsum Brick Wall");
        add(ACBlocks.GYPSUM_BRICK_STAIRS.get(), "Gypsum Brick Stairs");
        add(ACBlocks.POLISHED_GYPSUM.get(), "Polished Gypsum");
        add(ACBlocks.POLISHED_GYPSUM_SLAB.get(), "Polished Gypsum Slab");
        add(ACBlocks.POLISHED_GYPSUM_WALL.get(), "Polished Gypsum Wall");
        add(ACBlocks.POLISHED_GYPSUM_STAIRS.get(), "Polished Gypsum Stairs");
        add(ACBlocks.LOTUS_FLOWER.get(), "Lotus Flower");
        add(ACBlocks.BLEACHED_WOOL.get(), "Bleached Wool");
        add(ACBlocks.BLEACHED_CARPET.get(), "Bleached Carpet");
        add(ACBlocks.BLEACHED_CHALK.get(), "Bleached Chalk");
        add(ACBlocks.GLAZED_TERRACOTTA.get(), "Glazed Terracotta");
        add(ACBlocks.BLEACHED_CONCRETE.get(), "Bleached Concrete");
        add(ACBlocks.BLEACHED_CONCRETE_POWDER.get(), "Bleached Concrete Powder");
        add(ACBlocks.BLEACHED_BED.get(), "Bleached Bed");



        //ITEMS
        add(ACItems.CORK_BOAT.get(), "Cork Boat");
        add(ACItems.CORK_CHEST_BOAT.get(), "Cork Boat with Chest");
        add(ACItems.POTTERY_SHERD.get(), "Pottery Sherd");
        add(ACItems.ROLL_POTTERY_SHERD.get(), "Roll Pottery Sherd");
        add(ACItems.RUINED_POTTERY_SHERD.get(), "Ruined Pottery Sherd");
        add(ACItems.FINALE_POTTERY_SHERD.get(), "Finale Pottery Sherd");
        add(ACItems.GATEWAY_POTTERY_SHERD.get(), "Gateway Pottery Sherd");
        add(ACItems.BLEACHDEW.get(), "Bleachdew");
        add(ACItems.BLEACHDEW_PAINTBRUSH.get(), "Bleachdew Paintbrush");
        add(ACItems.LOTUS_PISTILS.get(), "Lotus Pistils");
        add(ACItems.BLEACHED_CHALK_STICK.get(), "Bleached Chalk Stick");

        //ENTITY TYPES
        add(ACEntityTypes.CHEST_BOAT.get(), "Boat with Chest");
        add(ACEntityTypes.BOAT.get(), "Boat");
        add(ACEntityTypes.FLOATING_BLOCK.get(), "Floating Block");



        //ADVANCEMENTS
        //chalk
        add("advancements.adventure.no_you_cant_eat_it.title", "No You Can't Eat It!");
        add("advancements.adventure.no_you_cant_eat_it.description", "Craft any coloured chalk stick!");
        add("advancements.adventure.board_planning.title", "Board Planning");
        add("advancements.adventure.board_planning.description", "Have all chalk sticks in your inventory");
        add("advancements.adventure.let_the_creativity_flow_through_you.title", "Let Creativity Flow Through You");
        add("advancements.adventure.let_the_creativity_flow_through_you.description", "Cycle the chalk pattern forwards by interacting with chalk dust with a chalk stick in your main hand or off hand!!");
        add("advancements.adventure.flashpoint.title", "Flashpoint");
        add("advancements.adventure.flashpoint.description", "Cycle the chalk pattern backwards by shift clicking chalk dust with a chalk stick in your offhand!");
        add("advancements.adventure.handpicked.title", "Handpicked");
        add("advancements.adventure.handpicked.description", "Save a chalk pattern by shift clicking with a chalk stick in your main hand!");
        //lotus
        add("advancements.husbandry.let_the_past_bloom.title", "Let The Past Bloom!");
        add("advancements.husbandry.let_the_past_bloom.description", "Interact with a lily pad using some Lotus Pistils");
        add("advancements.husbandry.circa_1980.title", "Circa 1980");
        add("advancements.husbandry.circa_1980.description", "Obtain some bleachdew from a fully bloomed Lotus Flower!");
        //paintbrush & bleach
        add("advancements.adventure.aspiring_davinci.title", "Aspiring Davinci!");
        add("advancements.adventure.aspiring_davinci.description", "Craft any coloured paintbrush");
        add("advancements.adventure.born_to_paint_forced_to_mop.title", "Born To Paint Forced To Mop");
        add("advancements.adventure.born_to_paint_forced_to_mop.description", "Craft a bleachdew paintbrush");








        //TOOL TIPS
        add("tooltip.arts_and_crafts.chalk_pattern_0", "Dot Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_1", "Vertical Line Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_2", "Horizontal Line Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_3", "East To South Corner Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_4", "East To North Corner Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_5", "West To North Corner Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_6", "West To South Corner Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_7", "North T Cross Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_8", "West T Cross Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_9", "South T Cross Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_10", "East T Cross Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_11", "Plus Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_12", "Right Diagonal Line Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_13", "Left Diagonal Line Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_14", "X Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_15", "North Line Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_16", "East Line Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_17", "South Line Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_18", "West Line Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_19", "North Triangle Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_20", "East Triangle Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_21", "South Triangle Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_22", "West Triangle Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_23", "Circle Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_24", "Square Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_25", "East To South Block Corner Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_26", "East To North Block Corner Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_27", "West To North Block Corner Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_28", "West To South Block Corner Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_29", "East To South Arch Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_30", "East To North Arch Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_31", "West To North Arch Pattern");
        add("tooltip.arts_and_crafts.chalk_pattern_32", "West To South Arch Pattern");
    }
}