package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.CustomBoat;
import com.kekecreations.arts_and_crafts.common.entity.CustomChestBoat;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.kekecreations.arts_and_crafts.core.platform.services.IPlatformHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class KekeEntityTypes {

    public static final Supplier<EntityType<FloatingBlockEntity>> FLOATING_BLOCK = registerEntityType("floating_block", () ->
            EntityType.Builder.of(FloatingBlockEntity::new, MobCategory.MISC)
                    .sized(0.98f, 0.98f)
                    .clientTrackingRange(10)
                    //.updateInterval(20)
                    .build(dataFixer("floating_block")));



    public static final Supplier<EntityType<CustomBoat>> BOAT = registerEntityType("boat", () ->
            EntityType.Builder.of((EntityType.EntityFactory<CustomBoat>) CustomBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .clientTrackingRange(10)
                    .build(dataFixer("boat")));


    public static final Supplier<EntityType<CustomChestBoat>> CHEST_BOAT = registerEntityType("chest_boat", () ->
            EntityType.Builder.of((EntityType.EntityFactory<CustomChestBoat>) CustomChestBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .clientTrackingRange(10)
                    .build(dataFixer("chest_boat")));


    public static final Supplier<BlockEntityType<DyedDecoratedPotBlockEntity>> CUSTOM_DECORATED_POT_BLOCK_ENTITY = registerBlockEntityType("custom_decorated_pot_block_entity", () ->
                    createBlockEntity(DyedDecoratedPotBlockEntity::new,
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


    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> type) {
        return Services.REGISTRY.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, name, type);
    }
    private static <T extends BlockEntity> BlockEntityType<T> createBlockEntity(IPlatformHelper.BlockEntitySupplier<T> blockEntitySupplier, Block... blocks) {
        return Services.PLATFORM.createBlockEntity(blockEntitySupplier, blocks);
    }

    private static <T extends EntityType<?>> Supplier<T> registerEntityType(String name, Supplier<T> entityTypeSupplier) {
        return Services.REGISTRY.register(BuiltInRegistries.ENTITY_TYPE, name, entityTypeSupplier);
    }

    public static void register() {
        createMobAttributes();
    }

    public static void createMobAttributes() {
    }

    private static String dataFixer(String mobName) {
        return ArtsAndCrafts.MOD_ID + ":" + mobName;
    }
}
