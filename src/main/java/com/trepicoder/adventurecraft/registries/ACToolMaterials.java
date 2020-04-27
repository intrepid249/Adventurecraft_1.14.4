package com.trepicoder.adventurecraft.registries;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public enum ACToolMaterials implements IItemTier {
    // The higher the enchantability the more enchantments you can put on it
    WOOD(0, 0.3f, 4, 1, 3, null),
    FLINT(2, 0.6f, 20, 1, 7, Items.FLINT);

    private float m_attackDamage, m_efficiency;
    private int m_durability, m_harvestLevel, m_enchantability;
    private Item m_repairMaterial;

    private ACToolMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
        m_attackDamage = attackDamage;
        m_efficiency = efficiency;
        m_durability = durability;
        m_harvestLevel = harvestLevel;
        m_enchantability = enchantability;
        m_repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return m_durability;
    }

    @Override
    public float getEfficiency() {
        return m_efficiency;
    }

    @Override
    public float getAttackDamage() {
        return m_attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return m_harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return m_enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(m_repairMaterial);
    }
}
