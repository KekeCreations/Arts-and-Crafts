package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.common.entity.CustomBoat;
import com.kekecreations.arts_and_crafts.common.item.ChalkStickItem;
import com.kekecreations.arts_and_crafts.common.item.CustomBoatItem;
import com.kekecreations.arts_and_crafts.common.item.DyedDecoratedPotBlockItem;
import com.kekecreations.arts_and_crafts.common.item.PaintBrushItem;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.kekecreations.arts_and_crafts.core.platform.services.RegistryHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;

import java.util.HashMap;
import java.util.function.Supplier;

public class KekeItems {

    public static final HashMap<DyeColor, Supplier<ChalkStickItem>> CHALK_STICKS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<DyedDecoratedPotBlockItem>> DYED_DECORATED_POT_BLOCK_ITEMS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<PaintBrushItem>> PAINT_BRUSHES = new HashMap<>();



    //public static final Supplier<ChalkStickItem> WHITE_CHALK_STICK = RegistryHelper.registerItem("white_chalk_stick", () -> new ChalkStickItem(new Item.Properties().stacksTo(1).durability(32)));

    public static final Supplier<SignItem> CORK_SIGN = registerItem("cork_sign", () -> new SignItem(new Item.Properties().stacksTo(16), KekeBlocks.CORK_SIGN.get(), KekeBlocks.CORK_WALL_SIGN.get()));
    public static final Supplier<HangingSignItem> CORK_HANGING_SIGN = registerItem("cork_hanging_sign", () -> new HangingSignItem(KekeBlocks.CORK_HANGING_SIGN.get(), KekeBlocks.CORK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));


    public static final Supplier<CustomBoatItem> CORK_BOAT = registerItem("cork_boat", () -> new CustomBoatItem(false, CustomBoat.WoodType.CORK, new Item.Properties().stacksTo(1)));

    public static final Supplier<CustomBoatItem> CORK_CHEST_BOAT = registerItem("cork_chest_boat", () -> new CustomBoatItem(true, CustomBoat.WoodType.CORK, new Item.Properties().stacksTo(1)));


    public static final Supplier<Item> ROLL_POTTERY_SHERD = registerItem("roll_pottery_sherd", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> IMPOSTER_POTTERY_SHERD = registerItem("imposter_pottery_sherd", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> POT_POTTERY_SHERD = registerItem("pot_pottery_sherd", () -> new Item(new Item.Properties()));





    static {
        for (DyeColor colours : DyeColor.values()) {
            CHALK_STICKS.put(colours, registerItem(colours + "_chalk_stick", () -> new ChalkStickItem(colours, new Item.Properties().stacksTo(1).durability(32))));
            DYED_DECORATED_POT_BLOCK_ITEMS.put(colours, registerItem(colours + "_decorated_pot", () -> new DyedDecoratedPotBlockItem(KekeBlocks.getDyedDecoratedPot(colours.getId()), new Item.Properties())));
            PAINT_BRUSHES.put(colours, registerItem(colours + "_paintbrush", () -> new PaintBrushItem(colours, new Item.Properties().stacksTo(1).durability(24))));
        }
    }

    public static ChalkStickItem getChalkStick(int colours) {
        return CHALK_STICKS.get(DyeColor.byId(colours)).get();
    }
    public static DyedDecoratedPotBlockItem getDyedDecoratedPotBlockItem(DyeColor colours) {
        return DYED_DECORATED_POT_BLOCK_ITEMS.get(colours).get();
    }

    public static PaintBrushItem getPaintBrush(int colours) {
        return PAINT_BRUSHES.get(DyeColor.byId(colours)).get();
    }


    private static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY.register(BuiltInRegistries.ITEM, name, itemSupplier);
    }





    public static void register() {
    }
}
