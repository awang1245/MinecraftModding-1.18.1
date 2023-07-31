package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class FireSword extends SwordItem {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new FireSword(Tiers.NETHERITE, 7, -2,  properties).setRegistryName(BaseMod.MODID, "firesword");

    public FireSword(Tier tier, int attackDamageIn, int attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity enemy, LivingEntity player) {
        enemy.setSecondsOnFire(5);
        return super.hurtEnemy(stack, enemy, player);
    }
}