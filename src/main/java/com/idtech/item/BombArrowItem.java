package com.idtech.item;

import com.idtech.ModTab;
import com.idtech.entity.BombArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

//two parts to creating projectiles, this is the item that interacts with the bow
//bombarrowitem class works together with bombarrow class to control behavior of arrow
//to be able to interact with bows, must be registered in the arrows tag json file
public class BombArrowItem extends ArrowItem {
    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new BombArrowItem(properties).setRegistryName("bombarrow");

    public BombArrowItem(Properties properties) {
        super (properties);
    }

    @Override
    public AbstractArrow createArrow(Level levelIn, ItemStack stack, LivingEntity shooter) {
        BombArrow arrowEntity = new BombArrow(levelIn, shooter);
        return arrowEntity;
    }
}
