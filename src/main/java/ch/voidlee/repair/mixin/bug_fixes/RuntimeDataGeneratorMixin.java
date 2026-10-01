package ch.voidlee.repair.mixin.bug_fixes;

import ch.voidlee.repair.implementation.RepairRuntimeDatageneratorConstants;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.foundation.data.RuntimeDataGenerator;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

// https://github.com/Creators-of-Create/Create/pull/10320
@Mixin(RuntimeDataGenerator.class)
public abstract class RuntimeDataGeneratorMixin {
    @Definition(id = "equals", method = "Ljava/lang/String;equals(Ljava/lang/Object;)Z")
    @Definition(id = "BTN", field = "Lcom/simibubi/create/foundation/data/recipe/Mods;BTN:Lcom/simibubi/create/foundation/data/recipe/Mods;")
    @Definition(id = "getId", method = "Lcom/simibubi/create/foundation/data/recipe/Mods;getId()Ljava/lang/String;")
    @Expression("?.equals(BTN.getId())")
    @ModifyExpressionValue(method = "cuttingRecipes", at = @At("MIXINEXTRAS:EXPRESSION"), remap = false)
    private static boolean create_repair$quarkAlsoHasPlanks(boolean original, @Local(name = "base") ResourceLocation base) {
        return original || RepairRuntimeDatageneratorConstants.USES_PLANKS_IN_STAIRS_OR_SLAB_ID.contains(base.getNamespace());
    }
}