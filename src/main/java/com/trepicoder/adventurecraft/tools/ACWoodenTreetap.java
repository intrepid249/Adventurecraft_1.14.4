package com.trepicoder.adventurecraft.tools;

import com.trepicoder.adventurecraft.registries.ACItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static com.trepicoder.adventurecraft.Adventurecraft.LOGGER;
import static com.trepicoder.adventurecraft.Adventurecraft.MODID;

public class ACWoodenTreetap extends AxeItem {
    public ACWoodenTreetap(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("Sappy Wappy Sap Tap"));
    }

    @Override
    public boolean onBlockDestroyed(@Nullable ItemStack stack, World worldIn, @Nullable BlockState state, @Nullable BlockPos pos, @Nullable LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            // Check if player is destroying a log block with the treetap
            Tag<Block> logTag = BlockTags.getCollection().get(new ResourceLocation(MODID, "logs"));
            if (logTag != null && state != null && state.getBlock().isIn(logTag) && pos != null) {
                // If tag matches that provided in adventurecraft:logs then we can spawn a treesap item
                ItemEntity drop = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ACItems.treesap));
                worldIn.addEntity(drop);
            }
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
