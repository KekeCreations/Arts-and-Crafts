package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.CustomBoat;
import com.kekecreations.arts_and_crafts.common.entity.CustomChestBoat;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.kekecreations.arts_and_crafts.core.platform.PlatformHelper;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class KekeEntityTypes {

    public static final Supplier<EntityType<FloatingBlockEntity>> FLOATING_BLOCK = RegistryHelper.registerEntityType("floating_block", () ->
            EntityType.Builder.of(FloatingBlockEntity::new, MobCategory.MISC)
                    .sized(0.98f, 0.98f)
                    .clientTrackingRange(10)
                    //.updateInterval(20)
                    .build(dataFixer("floating_block")));



    public static final Supplier<EntityType<CustomBoat>> BOAT = RegistryHelper.registerEntityType("boat", () ->
            EntityType.Builder.of((EntityType.EntityFactory<CustomBoat>) CustomBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .clientTrackingRange(10)
                    .build(dataFixer("boat")));


    public static final Supplier<EntityType<CustomChestBoat>> CHEST_BOAT = RegistryHelper.registerEntityType("chest_boat", () ->
            EntityType.Builder.of((EntityType.EntityFactory<CustomChestBoat>) CustomChestBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .clientTrackingRange(10)
                    .build(dataFixer("chest_boat")));


    public static final Supplier<BlockEntityType<DyedDecoratedPotBlockEntity>> CUSTOM_DECORATED_POT_BLOCK_ENTITY = RegistryHelper.registerBlockEntityType("custom_decorated_pot_block_entity", () ->
            PlatformHelper.createBlockEntity(DyedDecoratedPotBlockEntity::new,
                    KekeBlocks.getDyedDecoratedPot(DyeColor.WHITE.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.ORANGE.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.MAGENTA.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.LIGHT_BLUE.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.YELLOW.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.LIME.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.PINK.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.GRAY.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.LIGHT_GRAY.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.CYAN.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.PURPLE.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.BLUE.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.BROWN.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.GREEN.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.RED.getId()),
                    KekeBlocks.getDyedDecoratedPot(DyeColor.BLACK.getId())
            )
    );



    public static void register() {
        createMobAttributes();
    }
    public static void createMobAttributes() {
    }

    private static String dataFixer(String mobName) {
        return ArtsAndCrafts.MOD_ID + ":" + mobName;
    }
}
