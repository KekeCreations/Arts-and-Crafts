package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.common.block.entity.CustomFlowerPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.platform.PlatformHelper;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class KekeBlockEntityTypes {

    public static final Supplier<BlockEntityType<CustomFlowerPotBlockEntity>> CUSTOM_FLOWER_POT = RegistryHelper.registerBlockEntityType("custom_flower_pot", () ->
            PlatformHelper.createBlockEntity(CustomFlowerPotBlockEntity::new,
                    KekeBlocks.getDyedFlowerPot(DyeColor.WHITE),
                    KekeBlocks.getDyedFlowerPot(DyeColor.ORANGE),
                    KekeBlocks.getDyedFlowerPot(DyeColor.MAGENTA),
                    KekeBlocks.getDyedFlowerPot(DyeColor.LIGHT_BLUE),
                    KekeBlocks.getDyedFlowerPot(DyeColor.YELLOW),
                    KekeBlocks.getDyedFlowerPot(DyeColor.LIME),
                    KekeBlocks.getDyedFlowerPot(DyeColor.PINK),
                    KekeBlocks.getDyedFlowerPot(DyeColor.GRAY),
                    KekeBlocks.getDyedFlowerPot(DyeColor.LIGHT_GRAY),
                    KekeBlocks.getDyedFlowerPot(DyeColor.CYAN),
                    KekeBlocks.getDyedFlowerPot(DyeColor.PURPLE),
                    KekeBlocks.getDyedFlowerPot(DyeColor.BLUE),
                    KekeBlocks.getDyedFlowerPot(DyeColor.BROWN),
                    KekeBlocks.getDyedFlowerPot(DyeColor.GREEN),
                    KekeBlocks.getDyedFlowerPot(DyeColor.RED),
                    KekeBlocks.getDyedFlowerPot(DyeColor.BLACK)
            )
    );

    public static void register() {
    }

}
