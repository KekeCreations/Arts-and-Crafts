package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.CustomBoat;
import com.kekecreations.arts_and_crafts.common.entity.CustomChestBoat;
import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.ChestBoat;

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




    public static void register() {
        createMobAttributes();
    }
    public static void createMobAttributes() {
    }

    private static String dataFixer(String mobName) {
        return ArtsAndCrafts.MOD_ID + ":" + mobName;
    }
}
