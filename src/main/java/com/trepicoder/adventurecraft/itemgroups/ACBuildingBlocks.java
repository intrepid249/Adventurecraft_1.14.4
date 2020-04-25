package com.trepicoder.adventurecraft.itemgroups;

import com.trepicoder.adventurecraft.registries.ACItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ACBuildingBlocks extends ItemGroup {
    public ACBuildingBlocks() {
        super("adventurecraft_building");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ACItems.sugarmaple_log);
    }
}
