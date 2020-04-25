package com.trepicoder.adventurecraft.itemgroups;

import com.trepicoder.adventurecraft.registries.ACItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ACMiscGroup extends ItemGroup {
    public ACMiscGroup() {
        super("adventurecraft_misc");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ACItems.plantfibres);
    }
}
