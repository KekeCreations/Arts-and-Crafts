package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.ACBoat;
import com.kekecreations.arts_and_crafts.common.item.*;
import com.kekecreations.arts_and_crafts.common.item.april_fools.ACFoolItem;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public class ACItems {
    public static final HashMap<Integer, Supplier<Item>> FLOWER_POTS = new HashMap<>();

    public static final HashMap<Integer, Supplier<Item>> CHALK_STICKS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Item>> DYED_DECORATED_POT_BLOCK_ITEMS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Item>> PAINT_BRUSHES = new HashMap<>();


    //April Fools 2025
    public static final Supplier<Item> SUS_POTTERY_SHERD = registerItem("sus_pottery_sherd", registryName -> new ACFoolItem(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName))));
    public static final Supplier<Item> VICTORY_POTTERY_SHERD = registerItem("victory_pottery_sherd", registryName -> new ACFoolItem(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName))));


    public static Supplier<Item> BLEACHED_BED = registerItem("bleached_bed", registryName -> new ACBedBlockItem(ACBlocks.BLEACHED_BED.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)).stacksTo(1)));
    public static final Supplier<Item> LOTUS_PISTILS = registerItem("lotus_pistils", registryName -> new LotusPistilItem(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName))));
    public static final Supplier<Item> CORK_SIGN = registerItem("cork_sign", registryName -> new SignItem(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)).stacksTo(16), ACBlocks.CORK_SIGN.get(), ACBlocks.CORK_WALL_SIGN.get(), Direction.DOWN));
    public static final Supplier<Item> CORK_HANGING_SIGN = registerItem("cork_hanging_sign", registryName -> new HangingSignItem(ACBlocks.CORK_HANGING_SIGN.get(), ACBlocks.CORK_WALL_HANGING_SIGN.get(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)).stacksTo(16)));
    public static final Supplier<Item> CORK_BOAT = registerItem("cork_boat", registryName -> new ACBoatItem(false, ACBoat.WoodType.CORK, new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)).stacksTo(1)));
    public static final Supplier<Item> CORK_CHEST_BOAT = registerItem("cork_chest_boat", registryName -> new ACBoatItem(true, ACBoat.WoodType.CORK, new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)).stacksTo(1)));

    public static final Supplier<Item> POTTERY_SHERD = registerItem("pottery_sherd", registryName -> new Item(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName))));
    public static final Supplier<Item> ROLL_POTTERY_SHERD = registerItem("roll_pottery_sherd", registryName -> new Item(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName))));
    public static final Supplier<Item> RUINED_POTTERY_SHERD = registerItem("ruined_pottery_sherd", registryName -> new Item(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName))));
    public static final Supplier<Item> FINALE_POTTERY_SHERD = registerItem("finale_pottery_sherd", registryName -> new Item(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName))));
    public static final Supplier<Item> GATEWAY_POTTERY_SHERD = registerItem("gateway_pottery_sherd", registryName -> new Item(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName))));



    //BLEACHED
    public static final Supplier<Item> BLEACHDEW = registerItem("bleachdew", registryName -> new Item(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName))));
    public static final Supplier<Item> BLEACHDEW_PAINTBRUSH = registerItem("bleachdew_paintbrush", registryName -> new PaintbrushItem(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)).stacksTo(1).durability(48)));
    public static final Supplier<Item> BLEACHED_CHALK_STICK = registerItem("bleached_chalk_stick", registryName -> new ChalkStickItem(-1, new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)).stacksTo(1).durability(32)));


    static {
        CHALK_STICKS.put(-1, BLEACHED_CHALK_STICK);
        for (DyeColor colours : DyeColor.values()) {
            FLOWER_POTS.put(colours.getId(), registerItem(colours + "_flower_pot", registryName -> new DyedFlowerPotBlockItem(ACBlocks.getDyedFlowerPot(colours.getId()), new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)))));
            CHALK_STICKS.put(colours.getId(), registerItem(colours + "_chalk_stick", registryName -> new ChalkStickItem(colours.getId(), new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)).stacksTo(1).durability(32))));
            PAINT_BRUSHES.put(colours, registerItem(colours + "_paintbrush", registryName -> new PaintbrushItem(new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)).stacksTo(1).durability(48))));
            if (colours.getId() <= 15) {
                DYED_DECORATED_POT_BLOCK_ITEMS.put(colours, registerItem(colours + "_decorated_pot", registryName -> new DyedDecoratedPotBlockItem(ACBlocks.getDyedDecoratedPot(colours.getId()), new Item.Properties().setId(JinxedRegistryHelper.itemKey(registryName)))));
            }
        }
    }

    public static Item getChalkStick(int colours) {
        return CHALK_STICKS.get(colours).get();
    }
    public static Item getDyedDecoratedPotBlockItem(DyeColor colours) {
        return DYED_DECORATED_POT_BLOCK_ITEMS.get(colours).get();
    }

    public static Item getPaintBrush(int colours) {
        return PAINT_BRUSHES.get(DyeColor.byId(colours)).get();
    }


    private static Supplier<Item> registerItem(String name, Function<Identifier, ? extends Item> function) {
        return JinxedRegistryHelper.registerItem(ArtsAndCrafts.MOD_ID, name, function);
    }





    public static void register() {
    }
}
