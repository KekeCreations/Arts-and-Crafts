package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.DyeColor;

import java.util.HashMap;
import java.util.function.Supplier;

public class KekeParticles {

    public static final HashMap<DyeColor, Supplier<SimpleParticleType>> CHALK_DRAW_PARTICLES = new HashMap<>();

    public static final Supplier<SimpleParticleType> BLEACHED_CHALK_DRAW = registerParticle("bleached_chalk_draw");

    public static void register() {

    }

    static {
        for (DyeColor colours : DyeColor.values()) {
            CHALK_DRAW_PARTICLES.put(colours, registerParticle(colours + "_chalk_draw"));
        }
    }

    public static SimpleParticleType getChalkDrawParticle(DyeColor colours) {
        CHALK_DRAW_PARTICLES.put(null, BLEACHED_CHALK_DRAW);
        return CHALK_DRAW_PARTICLES.get(colours).get();
    }


    private static Supplier<SimpleParticleType> registerParticle(String name) {
        return Services.REGISTRY.registerParticle(name);
    }

}
