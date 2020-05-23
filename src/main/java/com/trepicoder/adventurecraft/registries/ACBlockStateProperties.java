package com.trepicoder.adventurecraft.registries;

import com.trepicoder.adventurecraft.blockstateproperties.WoodpileFullness;
import net.minecraft.state.EnumProperty;

public class ACBlockStateProperties {
    public static final EnumProperty<WoodpileFullness> WOODPILE_FULLNESS = EnumProperty.create("fullness", WoodpileFullness.class);
}
