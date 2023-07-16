package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelHoeItem extends HoeItem {

    private static final Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);

    public static Tier tier = new ForgeTier(1, 150, 1.0F, 2.0F,
            5, null, () -> {return Ingredient.of(ItemMod.STRUCTURE_GEL);});

    public static Item INSTANCE = new GelHoeItem(tier, 100, 100, properties)
            .setRegistryName(BaseMod.MODID, "gelhoe");

    public GelHoeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

}
