package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Sniffer.class)
public class SnifferMixin {


    @Inject(method = "dropSeed", at = @At(value = "HEAD"), cancellable = true)
    private void arts_and_crafts_dropSeed(CallbackInfo callbackInfo) {
        Sniffer $this = (Sniffer) (Object) this;
        Level lvl = $this.level();
        double chance = Math.random();
        if (lvl instanceof ServerLevel level) {
            if (chance <= 0.1) {
                if ($this.tickCount % 20 == 0) {
                    $this.drop(new ItemStack(ACItems.LOTUS_PISTILS.get()), false, false);
                    $this.playSound(SoundEvents.SNIFFER_DROP_SEED, 1.0F, 1.0F);
                    $this.onDiggingComplete(true);

                    $this.getBrain().eraseMemory(MemoryModuleType.SNIFFER_DIGGING);
                    $this.getBrain().eraseMemory(MemoryModuleType.SNIFFER_SNIFFING_TARGET);
                    $this.getBrain().stopAll(level, $this);
                    $this.transitionTo(Sniffer.State.IDLING);
                }
            }
        }
    }
}
