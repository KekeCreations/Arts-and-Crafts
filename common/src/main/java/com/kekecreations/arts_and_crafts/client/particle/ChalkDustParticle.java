package com.kekecreations.arts_and_crafts.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

@Environment(EnvType.CLIENT)
public class ChalkDustParticle extends SimpleAnimatedParticle {
    double velX;
    double velY;
    double velZ;

    ChalkDustParticle(ClientLevel world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteSet spriteProvider) {
        super(world, x, y, z, spriteProvider, 0.0F);
        velX = velocityX;
        velY = velocityY;
        velZ = velocityZ;
        this.xd = velX;
        this.yd = velY;
        this.zd = velZ;
        this.quadSize = 0.16F;
        this.hasPhysics = true;
        this.gravity = 0.1F;
        this.lifetime = 40;
        this.setSpriteFromAge(spriteProvider);
    }

    public void tick() {
        super.tick();
        xd = velX;
        zd = velZ;
        int magnitude = 2;
        int smoothness = 300;

        velX += (float) random.nextIntBetweenInclusive(-magnitude, magnitude) / smoothness;
        velZ += (float) random.nextIntBetweenInclusive(-magnitude, magnitude) / smoothness;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteProvider;

        public Factory(SpriteSet spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType defaultParticleType, ClientLevel clientWorld, double d, double e, double f, double g, double h, double i) {
            return new ChalkDustParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider);
        }
    }
}
