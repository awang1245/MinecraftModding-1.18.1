package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelAxeItem extends AxeItem {

    private static final Properties properties = new Item.Properties().tab(ModTab.INSTANCE);

    public static Tier tier = new ForgeTier(3, 150, 1.0F, 8.0F,
            5, null, () -> {return Ingredient.of(ItemMod.STRUCTURE_GEL);});

    public static Item INSTANCE = new GelAxeItem(tier, 100, 100, properties)
            .setRegistryName(BaseMod.MODID, "gelaxe");

    public GelAxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
