package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheep.class)
public class SheepMixin {

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    public void arts_and_crafts_mobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        Sheep $this = (Sheep) (Object) this;
        ItemStack itemStack = player.getItemInHand(hand);
        if (Services.CONFIG.bleachableSheep()) {
            if (itemStack.is(ACItems.BLEACHDEW.get())) {
                if (!$this.level().isClientSide && $this.readyForShearing()) {
                    int chance = player.getRandom().nextInt(0, 2);
                    if (chance == 0) {
                        $this.level().playSound(null, $this, SoundEvents.GHAST_SCREAM, SoundSource.PLAYERS, player.getRandom().nextFloat(), 1.0F);
                    } else {
                        $this.level().playSound(null, $this, SoundEvents.GOAT_SCREAMING_DEATH, SoundSource.PLAYERS, player.getRandom().nextFloat(), 1.0F);
                    }
                    $this.hurt($this.damageSources().playerAttack(player), 2.5F);
                    itemStack.setCount(itemStack.getCount() - 1);
                    cir.setReturnValue(InteractionResult.SUCCESS);
                }
            }
        }
    }
}
