package com.trepicoder.adventurecraft.utils;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public interface IBlockPosCheck {
    public boolean matchesBlock(IWorld worldIn, BlockPos pos);
}
