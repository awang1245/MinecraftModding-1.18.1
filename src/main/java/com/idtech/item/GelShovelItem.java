package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelShovelItem extends ShovelItem {

    private static final Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_TOOLS);

    public static Tier tier = new ForgeTier(2, 150, 1.0F, 3.0F,
            5, null, () -> {return Ingredient.of(ItemMod.STRUCTURE_GEL);});

    public static Item INSTANCE = new GelShovelItem(tier, 100, 100, properties)
            .setRegistryName(BaseMod.MODID, "gelshovel");

    public GelShovelItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

}
