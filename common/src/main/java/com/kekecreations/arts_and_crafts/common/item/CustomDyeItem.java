package com.kekecreations.arts_and_crafts.common.item;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.common.entity.CustomDyeSheep;
import com.kekecreations.arts_and_crafts.core.registry.KekeDyeColours;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignApplicator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.SignBlockEntity;

import java.util.Map;

public class CustomDyeItem extends Item implements SignApplicator {
    private static final Map<KekeDyeColours, CustomDyeItem> ITEM_BY_COLOR = Maps.newEnumMap(KekeDyeColours.class);
    private final KekeDyeColours dyeColor;

    public CustomDyeItem(KekeDyeColours dyeColor, Item.Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
        ITEM_BY_COLOR.put(dyeColor, this);
    }




    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (getDyeColor() == KekeDyeColours.CRIMSON) {
            if (livingEntity instanceof Sheep sheep && livingEntity.isAlive() && !sheep.isSheared() && sheep.getColor() != DyeColor.RED) {
                sheep.level().playSound(player, sheep, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
                if (!player.level().isClientSide) {
                    CustomDyeSheep customDyeSheep = new CustomDyeSheep(KekeEntityTypes.CUSTOM_DYE_SHEEP.get(), livingEntity.level());
                    customDyeSheep.setXRot(sheep.getXRot());
                    customDyeSheep.setYRot(sheep.getYRot());
                    customDyeSheep.setYBodyRot(sheep.yBodyRot);
                    customDyeSheep.setYHeadRot(sheep.getYHeadRot());
                    customDyeSheep.setPos(sheep.getX(), sheep.getY(), sheep.getZ());
                    customDyeSheep.setColor(KekeDyeColours.CRIMSON);
                    if (sheep.isBaby()) {
                        customDyeSheep.setBaby(true);
                    }
                    player.level().addFreshEntity(customDyeSheep);
                    sheep.remove(Entity.RemovalReason.DISCARDED);
                    itemStack.shrink(1);
                }
                return InteractionResult.sidedSuccess(player.level().isClientSide);
            }
        }
        if (getDyeColor() == KekeDyeColours.CREAM) {
            if (livingEntity instanceof Sheep sheep && livingEntity.isAlive() && !sheep.isSheared() && sheep.getColor() != DyeColor.RED) {
                sheep.level().playSound(player, sheep, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
                if (!player.level().isClientSide) {
                    CustomDyeSheep customDyeSheep = new CustomDyeSheep(KekeEntityTypes.CUSTOM_DYE_SHEEP.get(), livingEntity.level());
                    customDyeSheep.setXRot(sheep.getXRot());
                    customDyeSheep.setYRot(sheep.getYRot());
                    customDyeSheep.setYBodyRot(sheep.yBodyRot);
                    customDyeSheep.setYHeadRot(sheep.getYHeadRot());
                    customDyeSheep.setPos(sheep.getX(), sheep.getY(), sheep.getZ());
                    customDyeSheep.setColor(KekeDyeColours.CREAM);
                    if (sheep.isBaby()) {
                        customDyeSheep.setBaby(true);
                    }
                    player.level().addFreshEntity(customDyeSheep);
                    sheep.remove(Entity.RemovalReason.DISCARDED);
                    itemStack.shrink(1);
                }
                return InteractionResult.sidedSuccess(player.level().isClientSide);
            }
        }
        return InteractionResult.PASS;
    }


    public KekeDyeColours getDyeColor() {
        return this.dyeColor;
    }

    public static CustomDyeItem byColor(KekeDyeColours dyeColor) {
        return ITEM_BY_COLOR.get(dyeColor);
    }


    @Override
    public boolean tryApplyToSign(Level level, SignBlockEntity signBlockEntity, boolean bl, Player player) {
        if (getDyeColor() == KekeDyeColours.CRIMSON) {
            if (signBlockEntity.updateText(signText -> signText.setColor(DyeColor.RED), bl)) {
                level.playSound(null, signBlockEntity.getBlockPos(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
                return true;
            }
        }

        return false;
    }
}
