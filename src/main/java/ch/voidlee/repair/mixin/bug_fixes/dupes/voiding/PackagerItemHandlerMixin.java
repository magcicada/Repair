package ch.voidlee.repair.mixin.bug_fixes.dupes.voiding;

import com.simibubi.create.content.logistics.packager.PackagerItemHandler;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// https://github.com/Creators-of-Create/Create/pull/10426
@Mixin(PackagerItemHandler.class)
public abstract class PackagerItemHandlerMixin {
    @Inject(method = "extractItem", at = @At("HEAD"), remap = false, cancellable = true)
    private void create_repair$dontDeleteBoxWhenNotExtracting(int slot, int amount, boolean simulate, CallbackInfoReturnable<ItemStack> cir) {
        if (amount == 0) {
            cir.setReturnValue(ItemStack.EMPTY);
        }
    }
}