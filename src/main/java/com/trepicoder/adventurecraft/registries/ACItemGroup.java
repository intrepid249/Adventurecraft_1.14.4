package com.trepicoder.adventurecraft.registries;

import com.trepicoder.adventurecraft.itemgroups.ACBuildingBlocks;
import com.trepicoder.adventurecraft.itemgroups.ACMiscGroup;
import com.trepicoder.adventurecraft.itemgroups.ACToolGroup;
import net.minecraft.item.ItemGroup;

public class ACItemGroup {
    public static final ItemGroup MISC = new ACMiscGroup();
    public static final ItemGroup TOOLS = new ACToolGroup();
    public static final ItemGroup BUILDINGBLOCKS = new ACBuildingBlocks();
}
