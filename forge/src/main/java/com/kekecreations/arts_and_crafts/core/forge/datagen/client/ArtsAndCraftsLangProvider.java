package com.kekecreations.arts_and_crafts.core.forge.datagen.client;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.data.LanguageProvider;
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
            add(KekeItems.getChalkStick(colours.getId()), stringColour + " Chalk Stick");
            add(KekeItems.getPaintBrush(colours.getId()), stringColour + " Paintbrush");


            //BLOCKS
            add(KekeBlocks.getDyedFlowerPot(colours.getId()), stringColour + " Flower Pot");
            add(KekeBlocks.getChalkDust(colours), stringColour + " Chalk Dust");
            add(KekeBlocks.getChalk(colours.getId()), stringColour + " Chalk");

            add(KekeBlocks.getDyedTerracottaShingles(colours.getId()), stringColour + " Terracotta Shingles");
            add(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), stringColour + " Terracotta Shingle Slab");
            add(KekeBlocks.getDyedTerracottaShingleWall(colours.getId()), stringColour + " Terracotta Shingle Wall");
            add(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), stringColour + " Terracotta Shingle Stairs");

            add(KekeBlocks.getDyedSoapstone(colours.getId()), stringColour + " Soapstone");
            add(KekeBlocks.getDyedSoapstoneSlab(colours.getId()), stringColour + " Soapstone Slab");
            add(KekeBlocks.getDyedSoapstoneWall(colours.getId()), stringColour + " Soapstone Wall");
            add(KekeBlocks.getDyedSoapstoneStairs(colours.getId()), stringColour + " Soapstone Stairs");

            add(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), stringColour + " Soapstone Bricks");
            add(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()), stringColour + " Soapstone Brick Slab");
            add(KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()), stringColour + " Soapstone Brick Wall");
            add(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()), stringColour + " Soapstone Brick Stairs");

            add(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), stringColour + " Polished Soapstone");
            add(KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), stringColour + " Polished Soapstone Slab");
            add(KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()), stringColour + " Polished Soapstone Wall");
            add(KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), stringColour + " Polished Soapstone Stairs");

            add(KekeBlocks.getDyedDecoratedPot(colours.getId()), stringColour + " Decorated Pot");

            add(KekeBlocks.getDyedPlaster(colours.getId()), stringColour + " Plaster");
        }
        //BLOCKS
        add(KekeBlocks.TERRACOTTA_SHINGLES.get(), "Terracotta Shingles");
        add(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), "Terracotta Shingle Slab");
        add(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), "Terracotta Shingle Wall");
        add(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), "Terracotta Shingle Stairs");
        add(KekeBlocks.SOAPSTONE.get(), "Soapstone");
        add(KekeBlocks.SOAPSTONE_SLAB.get(), "Soapstone Slab");
        add(KekeBlocks.SOAPSTONE_WALL.get(), "Soapstone Wall");
        add(KekeBlocks.SOAPSTONE_STAIRS.get(), "Soapstone Stairs");
        add(KekeBlocks.SOAPSTONE_BRICKS.get(), "Soapstone Bricks");
        add(KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), "Soapstone Brick Slab");
        add(KekeBlocks.SOAPSTONE_BRICK_WALL.get(), "Soapstone Brick Wall");
        add(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), "Soapstone Brick Stairs");
        add(KekeBlocks.POLISHED_SOAPSTONE.get(), "Polished Soapstone");
        add(KekeBlocks.POLISHED_SOAPSTONE_SLAB.get(), "Polished Soapstone Slab");
        add(KekeBlocks.POLISHED_SOAPSTONE_WALL.get(), "Polished Soapstone Wall");
        add(KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get(), "Polished Soapstone Stairs");
        add(KekeBlocks.CORK_PLANKS.get(), "Cork Planks");
        add(KekeBlocks.CORK_LOG.get(), "Cork Log");
        add(KekeBlocks.STRIPPED_CORK_LOG.get(), "Stripped Cork Log");
        add(KekeBlocks.CORK_DOOR.get(), "Cork Door");
        add(KekeBlocks.CORK_TRAPDOOR.get(), "Cork Trapdoor");
        add(KekeBlocks.CORK_BUTTON.get(), "Cork Button");
        add(KekeBlocks.CORK_FENCE.get(), "Cork Fence");
        add(KekeBlocks.CORK_FENCE_GATE.get(), "Cork Fence Gate");
        add(KekeBlocks.CORK_PRESSURE_PLATE.get(), "Cork Pressure Plate");
        add(KekeBlocks.CORK_SLAB.get(), "Cork Slab");
        add(KekeBlocks.CORK_STAIRS.get(), "Cork Stairs");
        add(KekeBlocks.CORK_SIGN.get(), "Cork Sign");
        add(KekeBlocks.CORK_HANGING_SIGN.get(), "Cork Hanging Sign");
        add(KekeBlocks.CORK_WOOD.get(), "Cork Wood");
        add(KekeBlocks.STRIPPED_CORK_WOOD.get(), "Stripped Cork Wood");
        add(KekeBlocks.CORK.get(), "Cork");
        add(KekeBlocks.SMOOTH_CORK.get(), "Smooth Cork");
        add(KekeBlocks.CORK_LEAVES.get(), "Cork Leaves");
        add(KekeBlocks.CORK_SAPLING.get(), "Cork Sapling");
        add(KekeBlocks.PLASTER.get(), "Plaster");
        add(KekeBlocks.GYPSUM.get(), "Gypsum");
        add(KekeBlocks.GYPSUM_SLAB.get(), "Gypsum Slab");
        add(KekeBlocks.GYPSUM_WALL.get(), "Gypsum Wall");
        add(KekeBlocks.GYPSUM_STAIRS.get(), "Gypsum Stairs");
        add(KekeBlocks.GYPSUM_BRICKS.get(), "Gypsum Bricks");
        add(KekeBlocks.GYPSUM_BRICK_SLAB.get(), "Gypsum Brick Slab");
        add(KekeBlocks.GYPSUM_BRICK_WALL.get(), "Gypsum Brick Wall");
        add(KekeBlocks.GYPSUM_BRICK_STAIRS.get(), "Gypsum Brick Stairs");
        add(KekeBlocks.POLISHED_GYPSUM.get(), "Polished Gypsum");
        add(KekeBlocks.POLISHED_GYPSUM_SLAB.get(), "Polished Gypsum Slab");
        add(KekeBlocks.POLISHED_GYPSUM_WALL.get(), "Polished Gypsum Wall");
        add(KekeBlocks.POLISHED_GYPSUM_STAIRS.get(), "Polished Gypsum Stairs");
        add(KekeBlocks.BLEACHED_WOOL.get(), "Bleached Wool");


        //ITEMS
        add(KekeItems.CORK_BOAT.get(), "Cork Boat");
        add(KekeItems.CORK_CHEST_BOAT.get(), "Cork Boat with Chest");
        add(KekeItems.ROLL_POTTERY_SHERD.get(), "Roll Pottery Sherd");
        add(KekeItems.RUINED_POTTERY_SHERD.get(), "Ruined Pottery Sherd");
        add(KekeItems.FINALE_POTTERY_SHERD.get(), "Finale Pottery Sherd");
        add(KekeItems.GATEWAY_POTTERY_SHERD.get(), "Gateway Pottery Sherd");
        add(KekeItems.BLEACHDEW.get(), "Bleachdew");
        add(KekeItems.BLEACHDEW_PAINTBRUSH.get(), "Bleachdew Paintbrush");

        //ENTITY TYPES
        add(KekeEntityTypes.CHEST_BOAT.get(), "Boat with Chest");
        add(KekeEntityTypes.BOAT.get(), "Boat");
        add(KekeEntityTypes.FLOATING_BLOCK.get(), "Floating Block");



        //ADVANCEMENTS
        add("advancements.adventure.no_you_cant_eat_it.title", "No You Can't Eat It!");
        add("advancements.adventure.no_you_cant_eat_it.description", "Craft any coloured chalk stick!");
        add("advancements.adventure.board_planning.title", "Board Planning");
        add("advancements.adventure.board_planning.description", "Have all chalk sticks in your inventory");
        add("advancements.adventure.let_the_creativity_flow_through_you.title", "Let Creativity Flow Through You");
        add("advancements.adventure.let_the_creativity_flow_through_you.description", "Cycle the chalk pattern forwards by interacting with chalk dust with a chalk stick in your main hand or off hand!!");
        add("advancements.adventure.execute_order_33.title", "Execute Order 33");
        add("advancements.adventure.execute_order_33.description", "Cycle the chalk pattern backwards by shift clicking chalk dust with a chalk stick in your offhand!");
        add("advancements.adventure.handpicked.title", "Handpicked");
        add("advancements.adventure.handpicked.description", "Save a chalk pattern by shift clicking with a chalk stick in your main hand!");

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