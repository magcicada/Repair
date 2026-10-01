package ch.voidlee.repair.mixin.bug_fixes.dupes.voiding;

import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.equipment.TreeFertilizerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// https://github.com/Creators-of-Create/Create/pull/9758
// https://github.com/Creators-of-Create/Create/pull/10742
@Mixin(TreeFertilizerItem.class)
public abstract class TreeFertilizerItemMixin {
    @Inject(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z"))
    private void create_repair$dropBlocksWhenReplaced(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir, @Local(name = "actualPos") BlockPos actualPos, @Local(name = "block") Block sapling, @Local(name = "newState") BlockState newState) {
        BlockState oldState = context.getLevel().getBlockState(actualPos);
        boolean shouldDrop = !(oldState.getBlock() == sapling ||
                oldState.getBlock() == newState.getBlock() ||
                oldState.is(BlockTags.REPLACEABLE_BY_TREES) ||
                oldState.is(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH) ||
                oldState.is(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH));
        context.getLevel().destroyBlock(actualPos, shouldDrop);
    }
}
