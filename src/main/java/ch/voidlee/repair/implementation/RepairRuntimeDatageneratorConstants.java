package ch.voidlee.repair.implementation;

import com.google.common.collect.ImmutableSet;
import com.simibubi.create.foundation.data.recipe.Mods;

import java.util.Set;

// https://github.com/Creators-of-Create/Create/pull/10320
public class RepairRuntimeDatageneratorConstants {
    public static final Set<String> USES_PLANKS_IN_STAIRS_OR_SLAB_ID = ImmutableSet.<String>builder()
            .add(Mods.Q.getId())
            .add(Mods.BTN.getId())
            .build();
}
