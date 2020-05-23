package com.trepicoder.adventurecraft.blocks.tileentities;

import com.mojang.blaze3d.platform.GlStateManager;
import com.trepicoder.adventurecraft.Adventurecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ACChoppingBlockTEScreen extends ContainerScreen<ACChoppingBlockTEContainer> {
    private ResourceLocation GUI = new ResourceLocation(Adventurecraft.MODID, "textures/gui/container/chopping_block.png");

    public ACChoppingBlockTEScreen(ACChoppingBlockTEContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.xSize = 256;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }
}
