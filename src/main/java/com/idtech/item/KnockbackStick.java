package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

public class KnockbackStick extends Item {

    private static final Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new KnockbackStick(properties).setRegistryName(BaseMod.MODID, "knockbackstick");

    public KnockbackStick(Properties properties) {
        super(properties);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player playerin){
        stack.enchant(Enchantment.byId(15), 20);
    }
}
