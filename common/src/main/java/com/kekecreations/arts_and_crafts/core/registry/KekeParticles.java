package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.DyeColor;

import java.util.HashMap;
import java.util.function.Supplier;

public class KekeParticles {

    public static final HashMap<DyeColor, Supplier<SimpleParticleType>> CHALK_DRAW_PARTICLES = new HashMap<>();
    public static void register() {

    }


    //public static final Supplier<SimpleParticleType> CHALK_DRAW = RegistryHelper.registerParticle("chalk_draw");

    static {
        for (DyeColor colours : DyeColor.values()) {
            CHALK_DRAW_PARTICLES.put(colours, RegistryHelper.registerParticle(colours + "_chalk_draw"));
        }
    }

    public static SimpleParticleType getChalkDrawParticle(DyeColor colours) {
        return CHALK_DRAW_PARTICLES.get(colours).get();
    }

}
