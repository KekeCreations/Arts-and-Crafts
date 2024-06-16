package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.common.entity.ACBoat;
import com.kekecreations.arts_and_crafts.common.item.*;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.world.item.*;

import java.util.HashMap;
import java.util.function.Supplier;

public class ACItems {

    public static final HashMap<Integer, Supplier<ChalkStickItem>> CHALK_STICKS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<DyedDecoratedPotBlockItem>> DYED_DECORATED_POT_BLOCK_ITEMS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<PaintbrushItem>> PAINT_BRUSHES = new HashMap<>();

    public static Supplier<Item> BLEACHED_BED = registerItem("bleached_bed", () -> new ACBedBlockItem(ACBlocks.BLEACHED_BED.get(), new Item.Properties().stacksTo(1)));

    public static final Supplier<Item> LOTUS_PISTILS = registerItem("lotus_pistils", () -> new LotusPistilItem(new Item.Properties().stacksTo(16)));


    public static final Supplier<SignItem> CORK_SIGN = registerItem("cork_sign", () -> new SignItem(new Item.Properties().stacksTo(16), ACBlocks.CORK_SIGN.get(), ACBlocks.CORK_WALL_SIGN.get()));
    public static final Supplier<HangingSignItem> CORK_HANGING_SIGN = registerItem("cork_hanging_sign", () -> new HangingSignItem(ACBlocks.CORK_HANGING_SIGN.get(), ACBlocks.CORK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));


    public static final Supplier<ACBoatItem> CORK_BOAT = registerItem("cork_boat", () -> new ACBoatItem(false, ACBoat.WoodType.CORK, new Item.Properties().stacksTo(1)));

    public static final Supplier<ACBoatItem> CORK_CHEST_BOAT = registerItem("cork_chest_boat", () -> new ACBoatItem(true, ACBoat.WoodType.CORK, new Item.Properties().stacksTo(1)));

    public static final Supplier<Item> POTTERY_SHERD = registerItem("pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> ROLL_POTTERY_SHERD = registerItem("roll_pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> RUINED_POTTERY_SHERD = registerItem("ruined_pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> FINALE_POTTERY_SHERD = registerItem("finale_pottery_sherd", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GATEWAY_POTTERY_SHERD = registerItem("gateway_pottery_sherd", () -> new Item(new Item.Properties()));



    //BLEACHED
    public static final Supplier<Item> BLEACHDEW = registerItem("bleachdew", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> BLEACHDEW_PAINTBRUSH = registerItem("bleachdew_paintbrush", () -> new PaintbrushItem(new Item.Properties().stacksTo(1).durability(48)));
    public static final Supplier<ChalkStickItem> BLEACHED_CHALK_STICK = registerItem("bleached_chalk_stick", () -> new ChalkStickItem(-1, new Item.Properties().stacksTo(1).durability(32)));


    static {
        CHALK_STICKS.put(-1, BLEACHED_CHALK_STICK);
        for (DyeColor colours : DyeColor.values()) {
            CHALK_STICKS.put(colours.getId(), registerItem(colours + "_chalk_stick", () -> new ChalkStickItem(colours.getId(), new Item.Properties().stacksTo(1).durability(32))));
            DYED_DECORATED_POT_BLOCK_ITEMS.put(colours, registerItem(colours + "_decorated_pot", () -> new DyedDecoratedPotBlockItem(ACBlocks.getDyedDecoratedPot(colours.getId()), new Item.Properties())));
            PAINT_BRUSHES.put(colours, registerItem(colours + "_paintbrush", () -> new PaintbrushItem(new Item.Properties().stacksTo(1).durability(48))));
        }
    }

    public static ChalkStickItem getChalkStick(int colours) {
        return CHALK_STICKS.get(colours).get();
    }
    public static DyedDecoratedPotBlockItem getDyedDecoratedPotBlockItem(DyeColor colours) {
        return DYED_DECORATED_POT_BLOCK_ITEMS.get(colours).get();
    }

    public static PaintbrushItem getPaintBrush(int colours) {
        return PAINT_BRUSHES.get(DyeColor.byId(colours)).get();
    }


    private static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY.registerItem(name, itemSupplier);
    }





    public static void register() {
    }
}
