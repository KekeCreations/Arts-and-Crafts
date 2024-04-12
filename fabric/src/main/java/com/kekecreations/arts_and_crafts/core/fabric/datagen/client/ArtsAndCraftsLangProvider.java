package com.kekecreations.arts_and_crafts.core.fabric.datagen.client;

import com.kekecreations.arts_and_crafts.common.misc.NaturalDyeColor;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.world.item.DyeColor;
import org.apache.commons.lang3.StringUtils;

public class ArtsAndCraftsLangProvider extends FabricLanguageProvider {
    public ArtsAndCraftsLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        for (DyeColor colours : DyeColor.values()) {
            String stringColour = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colours.getName(), "blue", "Blue"), "gray" ,"Gray"), "_", " "));
            String stringNaturalColour = StringUtils.capitalize(NaturalDyeColor.byId(colours.getId()).getName());

            //ITEMS
            translationBuilder.add(KekeItems.getChalkStick(colours.getId()), stringColour + " Chalk Stick");
            translationBuilder.add(KekeItems.getPaintBrush(colours.getId()), stringColour + " Paintbrush");


            //BLOCKS
            translationBuilder.add(KekeBlocks.getDyedFlowerPot(colours.getId()), stringColour + " Flower Pot");
            translationBuilder.add(KekeBlocks.getChalkDust(colours), stringColour + " Chalk Dust");
            translationBuilder.add(KekeBlocks.getChalk(colours.getId()), stringColour + " Chalk");

            translationBuilder.add(KekeBlocks.getDyedTerracottaShingles(colours.getId()), stringColour + " Terracotta Shingles");
            translationBuilder.add(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), stringColour + " Terracotta Shingle Slab");
            translationBuilder.add(KekeBlocks.getDyedTerracottaShingleWall(colours.getId()), stringColour + " Terracotta Shingle Wall");
            translationBuilder.add(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), stringColour + " Terracotta Shingle Stairs");

            translationBuilder.add(KekeBlocks.getDyedSoapstone(colours.getId()), stringNaturalColour + " Soapstone");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneSlab(colours.getId()), stringNaturalColour + " Soapstone Slab");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneWall(colours.getId()), stringNaturalColour + " Soapstone Wall");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneStairs(colours.getId()), stringNaturalColour + " Soapstone Stairs");

            translationBuilder.add(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), stringNaturalColour + " Soapstone Bricks");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()), stringNaturalColour + " Soapstone Brick Slab");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()), stringNaturalColour + " Soapstone Brick Wall");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()), stringNaturalColour + " Soapstone Brick Stairs");

            translationBuilder.add(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), stringNaturalColour + " Polished Soapstone");
            translationBuilder.add(KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), stringNaturalColour + " Polished Soapstone Slab");
            translationBuilder.add(KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()), stringNaturalColour + " Polished Soapstone Wall");
            translationBuilder.add(KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), stringNaturalColour + " Polished Soapstone Stairs");

            translationBuilder.add(KekeBlocks.getDyedDecoratedPot(colours.getId()), stringColour + " Decorated Pot");
        }
        //BLOCKS
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLES.get(), "Terracotta Shingles");
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), "Terracotta Shingle Slab");
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), "Terracotta Shingle Wall");
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), "Terracotta Shingle Stairs");
        translationBuilder.add(KekeBlocks.SOAPSTONE.get(), "Soapstone");
        translationBuilder.add(KekeBlocks.SOAPSTONE_SLAB.get(), "Soapstone Slab");
        translationBuilder.add(KekeBlocks.SOAPSTONE_WALL.get(), "Soapstone Wall");
        translationBuilder.add(KekeBlocks.SOAPSTONE_STAIRS.get(), "Soapstone Stairs");
        translationBuilder.add(KekeBlocks.SOAPSTONE_BRICKS.get(), "Soapstone Bricks");
        translationBuilder.add(KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), "Soapstone Brick Slab");
        translationBuilder.add(KekeBlocks.SOAPSTONE_BRICK_WALL.get(), "Soapstone Brick Wall");
        translationBuilder.add(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), "Soapstone Brick Stairs");
        translationBuilder.add(KekeBlocks.POLISHED_SOAPSTONE.get(), "Polished Soapstone");
        translationBuilder.add(KekeBlocks.POLISHED_SOAPSTONE_SLAB.get(), "Polished Soapstone Slab");
        translationBuilder.add(KekeBlocks.POLISHED_SOAPSTONE_WALL.get(), "Polished Soapstone Wall");
        translationBuilder.add(KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get(), "Polished Soapstone Stairs");
        translationBuilder.add(KekeBlocks.CORK_PLANKS.get(), "Cork Planks");
        translationBuilder.add(KekeBlocks.CORK_LOG.get(), "Cork Log");
        translationBuilder.add(KekeBlocks.STRIPPED_CORK_LOG.get(), "Stripped Cork Log");
        translationBuilder.add(KekeBlocks.CORK_DOOR.get(), "Cork Door");
        translationBuilder.add(KekeBlocks.CORK_TRAPDOOR.get(), "Cork Trapdoor");
        translationBuilder.add(KekeBlocks.CORK_BUTTON.get(), "Cork Button");
        translationBuilder.add(KekeBlocks.CORK_FENCE.get(), "Cork Fence");
        translationBuilder.add(KekeBlocks.CORK_FENCE_GATE.get(), "Cork Fence Gate");
        translationBuilder.add(KekeBlocks.CORK_PRESSURE_PLATE.get(), "Cork Pressure Plate");
        translationBuilder.add(KekeBlocks.CORK_SLAB.get(), "Cork Slab");
        translationBuilder.add(KekeBlocks.CORK_STAIRS.get(), "Cork Stairs");
        translationBuilder.add(KekeBlocks.CORK_SIGN.get(), "Cork Sign");
        translationBuilder.add(KekeBlocks.CORK_HANGING_SIGN.get(), "Cork Hanging Sign");
        translationBuilder.add(KekeBlocks.CORK_WOOD.get(), "Cork Wood");
        translationBuilder.add(KekeBlocks.STRIPPED_CORK_WOOD.get(), "Stripped Cork Wood");
        translationBuilder.add(KekeBlocks.CORK.get(), "Cork");
        translationBuilder.add(KekeBlocks.SMOOTH_CORK.get(), "Smooth Cork");
        translationBuilder.add(KekeBlocks.CORK_LEAVES.get(), "Cork Leaves");
        translationBuilder.add(KekeBlocks.CORK_SAPLING.get(), "Cork Sapling");


        //ITEMS
        translationBuilder.add(KekeItems.CORK_BOAT.get(), "Cork Boat");
        translationBuilder.add(KekeItems.CORK_CHEST_BOAT.get(), "Cork Boat with Chest");
        translationBuilder.add(KekeItems.ROLL_POTTERY_SHERD.get(), "Roll Pottery Sherd");
        translationBuilder.add(KekeItems.RUINED_POTTERY_SHERD.get(), "Ruined Pottery Sherd");
        translationBuilder.add(KekeItems.FINALE_POTTERY_SHERD.get(), "Finale Pottery Sherd");
        translationBuilder.add(KekeItems.GATEWAY_POTTERY_SHERD.get(), "Gateway Pottery Sherd");

        //ENTITY TYPES
        translationBuilder.add(KekeEntityTypes.CHEST_BOAT.get(), "Boat with Chest");
        translationBuilder.add(KekeEntityTypes.BOAT.get(), "Boat");
        translationBuilder.add(KekeEntityTypes.FLOATING_BLOCK.get(), "Floating Block");



        //ADVANCEMENTS
        translationBuilder.add("advancements.adventure.no_you_cant_eat_it.title", "No You Can't Eat It!");
        translationBuilder.add("advancements.adventure.no_you_cant_eat_it.description", "Craft any coloured chalk stick!");
        translationBuilder.add("advancements.adventure.board_planning.title", "Board Planning");
        translationBuilder.add("advancements.adventure.board_planning.description", "Have all chalk sticks in your inventory");
        translationBuilder.add("advancements.adventure.let_the_creativity_flow_through_you.title", "Let Creativity Flow Through You");
        translationBuilder.add("advancements.adventure.let_the_creativity_flow_through_you.description", "Cycle the chalk pattern forwards by interacting with chalk dust with a chalk stick in your main hand or off hand!!");
        translationBuilder.add("advancements.adventure.execute_order_33.title", "Execute Order 33");
        translationBuilder.add("advancements.adventure.execute_order_33.description", "Cycle the chalk pattern backwards by shift clicking chalk dust with a chalk stick in your offhand!");
        translationBuilder.add("advancements.adventure.handpicked.title", "Handpicked");
        translationBuilder.add("advancements.adventure.handpicked.description", "Save a chalk pattern by shift clicking with a chalk stick in your main hand!");

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

