package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class DyedDecoratedPotBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {

    private final DyeColor dyeColor;

    public static final ResourceLocation SHERDS_DYNAMIC_DROP_ID = ResourceLocation.withDefaultNamespace("sherds");
    private static final VoxelShape BOUNDING_BOX = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
    private static final DirectionProperty HORIZONTAL_FACING;
    public static final BooleanProperty CRACKED;
    private static final BooleanProperty WATERLOGGED;

    public DyedDecoratedPotBlock(DyeColor colour, Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(HORIZONTAL_FACING, Direction.NORTH)).setValue(WATERLOGGED, false)).setValue(CRACKED, false));
        this.dyeColor = colour;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        DyedDecoratedPotBlockEntity customDecoratedPotBlockEntity = new DyedDecoratedPotBlockEntity(blockPos, blockState);
        customDecoratedPotBlockEntity.setDyeColor(this.dyeColor.getId());
        return customDecoratedPotBlockEntity;
    }
    protected BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if ((Boolean)blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        return (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection())).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER)).setValue(CRACKED, false);
    }

    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        BlockEntity var9 = level.getBlockEntity(blockPos);
        if (var9 instanceof DyedDecoratedPotBlockEntity decoratedPotBlockEntity) {
            if (level.isClientSide) {
                return ItemInteractionResult.CONSUME;
            } else {
                ItemStack itemStack2 = decoratedPotBlockEntity.getTheItem();
                if (!itemStack.isEmpty() && (itemStack2.isEmpty() || ItemStack.isSameItemSameComponents(itemStack2, itemStack) && itemStack2.getCount() < itemStack2.getMaxStackSize())) {
                    decoratedPotBlockEntity.wobble(DyedDecoratedPotBlockEntity.WobbleStyle.POSITIVE);
                    player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
                    ItemStack itemStack3 = player.isCreative() ? itemStack.copyWithCount(1) : itemStack.split(1);
                    float f;
                    if (decoratedPotBlockEntity.isEmpty()) {
                        decoratedPotBlockEntity.setTheItem(itemStack3);
                        f = (float)itemStack3.getCount() / (float)itemStack3.getMaxStackSize();
                    } else {
                        itemStack2.grow(1);
                        f = (float)itemStack2.getCount() / (float)itemStack2.getMaxStackSize();
                    }

                    level.playSound((Player)null, blockPos, SoundEvents.DECORATED_POT_INSERT, SoundSource.BLOCKS, 1.0F, 0.7F + 0.5F * f);
                    if (level instanceof ServerLevel) {
                        ServerLevel serverLevel = (ServerLevel)level;
                        serverLevel.sendParticles(ParticleTypes.DUST_PLUME, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 1.2, (double)blockPos.getZ() + 0.5, 7, 0.0, 0.0, 0.0, 0.0);
                    }

                    decoratedPotBlockEntity.setChanged();
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                    return ItemInteractionResult.SUCCESS;
                } else {
                    return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                }
            }
        } else {
            return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }
    }

    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        BlockEntity var7 = level.getBlockEntity(blockPos);
        if (var7 instanceof DyedDecoratedPotBlockEntity decoratedPotBlockEntity) {
            level.playSound((Player)null, blockPos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            decoratedPotBlockEntity.wobble(DyedDecoratedPotBlockEntity.WobbleStyle.NEGATIVE);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }

    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return BOUNDING_BOX;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{HORIZONTAL_FACING, WATERLOGGED, CRACKED});
    }

    protected void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        Containers.dropContentsOnDestroy(blockState, blockState2, level, blockPos);
        super.onRemove(blockState, level, blockPos, blockState2, bl);
    }

    protected List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        BlockEntity blockEntity = (BlockEntity)builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof DecoratedPotBlockEntity decoratedPotBlockEntity) {
            builder.withDynamicDrop(SHERDS_DYNAMIC_DROP_ID, (consumer) -> {
                Iterator var2 = decoratedPotBlockEntity.getDecorations().ordered().iterator();

                while(var2.hasNext()) {
                    Item item = (Item)var2.next();
                    consumer.accept(item.getDefaultInstance());
                }

            });
        }

        return super.getDrops(blockState, builder);
    }

    public BlockState playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        ItemStack itemStack = player.getMainHandItem();
        BlockState blockState2 = blockState;
        if (itemStack.is(ItemTags.BREAKS_DECORATED_POTS) && !EnchantmentHelper.hasTag(itemStack, EnchantmentTags.PREVENTS_DECORATED_POT_SHATTERING)) {
            blockState2 = (BlockState)blockState.setValue(CRACKED, true);
            level.setBlock(blockPos, blockState2, 4);
        }

        return super.playerWillDestroy(level, blockPos, blockState2, player);
    }

    protected FluidState getFluidState(BlockState blockState) {
        return (Boolean)blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    protected SoundType getSoundType(BlockState blockState) {
        return (Boolean)blockState.getValue(CRACKED) ? SoundType.DECORATED_POT_CRACKED : SoundType.DECORATED_POT;
    }

    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        PotDecorations potDecorations = (PotDecorations)itemStack.getOrDefault(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY);
        if (!potDecorations.equals(PotDecorations.EMPTY)) {
            list.add(CommonComponents.EMPTY);
            Stream.of(potDecorations.front(), potDecorations.left(), potDecorations.right(), potDecorations.back()).forEach((optional) -> {
                list.add((new ItemStack((ItemLike)optional.orElse(Items.BRICK), 1)).getHoverName().plainCopy().withStyle(ChatFormatting.GRAY));
            });
        }
    }

    protected void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        BlockPos blockPos = blockHitResult.getBlockPos();
        if (!level.isClientSide && projectile.mayInteract(level, blockPos) && projectile.mayBreak(level)) {
            level.setBlock(blockPos, (BlockState)blockState.setValue(CRACKED, true), 4);
            level.destroyBlock(blockPos, true, projectile);
        }

    }

    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        BlockEntity var5 = levelReader.getBlockEntity(blockPos);
        if (var5 instanceof DyedDecoratedPotBlockEntity decoratedPotBlockEntity) {
            return decoratedPotBlockEntity.getPotAsItem(this.dyeColor);
        } else {
            return super.getCloneItemStack(levelReader, blockPos, blockState);
        }
    }

    protected boolean hasAnalogOutputSignal(BlockState blockState) {
        return true;
    }

    protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(blockPos));
    }

    protected BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState)blockState.setValue(HORIZONTAL_FACING, rotation.rotate((Direction)blockState.getValue(HORIZONTAL_FACING)));
    }

    protected BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation((Direction)blockState.getValue(HORIZONTAL_FACING)));
    }



    public static Block getBlockByColor(@Nullable DyeColor arg) {
        if (arg == null) {
            return Blocks.DECORATED_POT;
        } else {
            return switch (arg) {
                default -> Blocks.DECORATED_POT;
                case WHITE -> ACBlocks.getDyedDecoratedPot(DyeColor.WHITE.getId());
                case ORANGE -> ACBlocks.getDyedDecoratedPot(DyeColor.ORANGE.getId());
                case MAGENTA -> ACBlocks.getDyedDecoratedPot(DyeColor.MAGENTA.getId());
                case LIGHT_BLUE -> ACBlocks.getDyedDecoratedPot(DyeColor.LIGHT_BLUE.getId());
                case YELLOW -> ACBlocks.getDyedDecoratedPot(DyeColor.YELLOW.getId());
                case LIME -> ACBlocks.getDyedDecoratedPot(DyeColor.LIME.getId());
                case PINK -> ACBlocks.getDyedDecoratedPot(DyeColor.PINK.getId());
                case GRAY -> ACBlocks.getDyedDecoratedPot(DyeColor.GRAY.getId());
                case LIGHT_GRAY -> ACBlocks.getDyedDecoratedPot(DyeColor.LIGHT_GRAY.getId());
                case CYAN -> ACBlocks.getDyedDecoratedPot(DyeColor.CYAN.getId());
                case PURPLE -> ACBlocks.getDyedDecoratedPot(DyeColor.PURPLE.getId());
                case BLUE -> ACBlocks.getDyedDecoratedPot(DyeColor.BLUE.getId());
                case BROWN -> ACBlocks.getDyedDecoratedPot(DyeColor.BROWN.getId());
                case GREEN -> ACBlocks.getDyedDecoratedPot(DyeColor.GREEN.getId());
                case RED -> ACBlocks.getDyedDecoratedPot(DyeColor.RED.getId());
                case BLACK -> ACBlocks.getDyedDecoratedPot(DyeColor.BLACK.getId());
            };
        }
    }

    public static final MapCodec<DyedDecoratedPotBlock> CODEC = RecordCodecBuilder.mapCodec(($$0) -> {
        return $$0.group(DyeColor.CODEC.fieldOf("dyecolor").forGetter(($$0x) -> {
            return $$0x.dyeColor;
        }), propertiesCodec()).apply($$0, DyedDecoratedPotBlock::new);
    });
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    static {
        HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
        CRACKED = BlockStateProperties.CRACKED;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }
}
