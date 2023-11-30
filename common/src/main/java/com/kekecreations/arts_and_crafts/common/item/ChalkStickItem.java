package com.kekecreations.arts_and_crafts.common.item;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import java.util.Map;

public class ChalkStickItem extends Item {

    private static final Map<DyeColor, ChalkStickItem> ITEM_BY_COLOR = Maps.newEnumMap(DyeColor.class);
    private final DyeColor dyeColor;
    public ChalkStickItem(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
        ITEM_BY_COLOR.put(dyeColor, this);
    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    public static ChalkStickItem byColour(DyeColor dyeColor) {
        return ITEM_BY_COLOR.get(dyeColor);
    }

    public void spawnParticle(Player player, double x, double y, double z, DyeColor colours) {
        player.level().addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        player.level().addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        player.level().addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        player.level().addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
    }


    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        BlockPos blockPos = useOnContext.getClickedPos();
        Level level = useOnContext.getLevel();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();
        RandomSource random = level.getRandom();
        Direction clickedFace = useOnContext.getClickedFace();
        Vec3 clickLocation = useOnContext.getClickLocation();

        InteractionResult interactionResult = this.place(new BlockPlaceContext(useOnContext));


        if (block instanceof ChalkDustBlock chalkDustBlock) {
            int state;
            if (player.isCrouching()) {
                state = -1;
            } else {
                state = 1;
            }


            for (DyeColor colours : DyeColor.values()) {
                if (block == KekeBlocks.getChalkDust(colours) && this == KekeItems.getChalkStick(colours)) {

                    spawnParticle(player, clickLocation.x(), clickLocation.y() + 0.2D, clickLocation.z(), colours);
                    level.setBlockAndUpdate(blockPos, chalkDustBlock.changeState(blockState, player, state));
                    level.playSound(player, blockPos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.2F + 0.9F);

                }
            }
            return InteractionResult.SUCCESS;
        }


        return interactionResult;
    }

    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.canPlace()) return InteractionResult.FAIL;

        Level level = blockPlaceContext.getLevel();
        BlockPos pos = blockPlaceContext.getClickedPos();
        Player player = blockPlaceContext.getPlayer();
        ItemStack itemStack = blockPlaceContext.getItemInHand();

        BlockState state = KekeBlocks.getChalkDust(this.getDyeColor()).getStateForPlacement(blockPlaceContext);
        BlockState clickedState = level.getBlockState(pos);

        if (state != null && !(clickedState.getBlock() instanceof ChalkDustBlock)) {
            RandomSource randomSource = level.getRandom();
            level.setBlockAndUpdate(pos, state);
            level.playSound(player, pos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.2F + 0.9F);
            level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, clickedState));

            if (player instanceof ServerPlayer serverPlayer) CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
            clickedState.getBlock().setPlacedBy(level, pos, clickedState, player, itemStack);

            if ((player == null || !player.getAbilities().instabuild) && !(clickedState.getBlock() instanceof ChalkDustBlock)) {
                itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(blockPlaceContext.getHand()));
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
