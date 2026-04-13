package ch.voidlee.repair.mixin.bug_fixes;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ForgeRegistry.class, remap = false)
public class GalosphereForgePatchMixin {

    @Inject(
            method = "getValue(Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/Object;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onGetValue(ResourceLocation location, CallbackInfoReturnable<Object> cir) {
        if (location != null && "galosphere".equals(location.getNamespace())) {
            String path = location.getPath();
            if (path.contains("silver") && !path.equals("silverfish") && !path.contains("loot")) {
                ResourceLocation redirectedId = new ResourceLocation("galosphere", path.replace("silver", "palladium"));

                cir.setReturnValue(((ForgeRegistry<?>) (Object) this).getValue(redirectedId));
            }
        }
    }
}
