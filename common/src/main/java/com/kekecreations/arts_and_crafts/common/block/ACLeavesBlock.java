package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.jinxedlib.common.block.FlammableLeavesBlock;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ACLeavesBlock extends FlammableLeavesBlock {

    public static final MapCodec<ACLeavesBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(ExtraCodecs.floatRange(0.0F, 1.0F).fieldOf("leaf_particle_chance").forGetter((particleLeavesBlock) -> particleLeavesBlock.leafParticleChance), propertiesCodec()).apply(instance, ACLeavesBlock::new));

    public ACLeavesBlock(float f, BlockBehaviour.Properties properties) {
        super(f, properties);
    }

    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        ColorParticleOption colorParticleOption = ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, level.getClientLeafTintColor(pos));
        ParticleUtils.spawnParticleBelow(level, pos, random, colorParticleOption);
    }

    public MapCodec<? extends ACLeavesBlock> codec() {
        return CODEC;
    }
}
