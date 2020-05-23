package com.trepicoder.adventurecraft.blockstateproperties;

import net.minecraft.util.IStringSerializable;

public enum WoodpileFullness implements IStringSerializable {
    EMPTY("empty"),
    SHALLOW("shallow"),
    HALF("half"),
    FULL("full");

    private final String name;

    private WoodpileFullness(String name) { this.name = name; }

    @Override
    public String getName() {
        return this.name;
    }
}
