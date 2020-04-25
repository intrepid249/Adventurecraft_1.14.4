package com.trepicoder.adventurecraft.itemgroups;

import com.trepicoder.adventurecraft.registries.ACItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ACToolGroup extends ItemGroup {
    public ACToolGroup() {
        super("adventurecraft_tools");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ACItems.flint_hatchet);
    }
}
