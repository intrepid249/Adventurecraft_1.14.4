package com.trepicoder.adventurecraft.registries;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class ACBlockColors implements IBlockColor {
    public static final ACBlockColors INSTANCE = new ACBlockColors();

    private ACBlockColors() {}

    @Override
    public int getColor(@Nullable BlockState state, @Nullable IEnviromentBlockReader worldIn, @Nullable BlockPos pos, int tintIndex) {
        if (state.getBlock().getRegistryName().getPath().contains("sugarmaple_leaves")) {
            return 0xEBC934;
        }

        return FoliageColors.getBirch();
    }

    public static void registerBlockColors() {
        Minecraft.getInstance().getBlockColors().register(INSTANCE, ACBlocks.sugarmaple_leaves);
    }
}
