package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.common.item.ChalkStickItem;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class KekeItems {


    public static final Supplier<ChalkStickItem> WHITE_CHALK_STICK = RegistryHelper.registerItem("white_chalk_stick", () -> new ChalkStickItem(new Item.Properties().stacksTo(1).durability(32)));




    public static void register() {
    }
}
