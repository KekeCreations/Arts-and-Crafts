package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.common.item.ChalkStickItem;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.function.Supplier;

public class KekeItems {

    public static final HashMap<DyeColor, Supplier<ChalkStickItem>> CHALK_STICKS = new HashMap<>();



    //public static final Supplier<ChalkStickItem> WHITE_CHALK_STICK = RegistryHelper.registerItem("white_chalk_stick", () -> new ChalkStickItem(new Item.Properties().stacksTo(1).durability(32)));

    public static final Supplier<SignItem> CORK_SIGN = RegistryHelper.registerItem("cork_sign", () -> new SignItem(new Item.Properties().stacksTo(16), KekeBlocks.CORK_SIGN.get(), KekeBlocks.CORK_WALL_SIGN.get()));
    public static final Supplier<HangingSignItem> CORK_HANGING_SIGN = RegistryHelper.registerItem("cork_hanging_sign", () -> new HangingSignItem(KekeBlocks.CORK_HANGING_SIGN.get(), KekeBlocks.CORK_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    static {
        for (DyeColor colours : DyeColor.values()) {
            CHALK_STICKS.put(colours, RegistryHelper.registerItem(colours + "_chalk_stick", () -> new ChalkStickItem(colours, new Item.Properties().stacksTo(1).durability(32))));
        }
    }

    public static ChalkStickItem getChalkStick(DyeColor colours) {
        return CHALK_STICKS.get(colours).get();
    }





    public static void register() {
    }
}
