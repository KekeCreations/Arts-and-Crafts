package com.kekecreations.arts_and_crafts.common.item;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class PaintBrushItem extends Item {

    private final DyeColor dyeColor;

    public PaintBrushItem(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

}
