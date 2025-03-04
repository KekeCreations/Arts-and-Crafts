package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.particle.CommonSimpleParticleType;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;

import java.util.HashMap;
import java.util.function.Supplier;

public class ACParticles {

    public static final HashMap<Integer, Supplier<SimpleParticleType>> CHALK_DRAW_PARTICLES = new HashMap<>();

    public static final Supplier<SimpleParticleType> BLEACHED_CHALK_DRAW = registerParticle("bleached_chalk_draw");

    public static void register() {

    }

    static {
        CHALK_DRAW_PARTICLES.put(-1, BLEACHED_CHALK_DRAW);
        for (DyeColor colours : DyeColor.values()) {
            CHALK_DRAW_PARTICLES.put(colours.getId(), registerParticle(colours + "_chalk_draw"));
        }
    }

    public static SimpleParticleType getChalkDrawParticle(Integer colours) {
        return CHALK_DRAW_PARTICLES.get(colours).get();
    }


    private static Supplier<SimpleParticleType> registerParticle(String name) {
        return JinxedRegistryHelper.register(BuiltInRegistries.PARTICLE_TYPE, ArtsAndCrafts.MOD_ID, name, () -> new CommonSimpleParticleType(false));
    }

}
