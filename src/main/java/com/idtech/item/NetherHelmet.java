package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class NetherHelmet extends ArmorItem {

    private static Properties properties = new Properties().tab(CreativeModeTab.TAB_COMBAT);
    public static ArmorMaterial materials = ItemUtils.buildArmorMaterial("witheressence",0,
            new int[]{10,10,10,10}, 22, SoundEvents.ARMOR_EQUIP_NETHERITE,5.0f,
            1.0f, "minecraft:netherite_ingot");

    public static Item INSTANCE = new NetherHelmet(materials,EquipmentSlot.HEAD, properties)
            .setRegistryName(BaseMod.MODID, "netherhelmet");

    public NetherHelmet( ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "examplemod:textures/models/armor/nether_helmet.png";
    }

    @Override
    public void onArmorTick(ItemStack itemStack, Level level, Player player) {
        boolean equipped = player.hasItemInSlot(EquipmentSlot.HEAD);
        if (equipped) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 1));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5,1));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5,3));
        }
        super.onArmorTick(itemStack, level, player);
    }

    //crafted using wither essence + netherite helmet
    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player playerin) {
        //enchants to combat damage from explosions
        //fire protection
        stack.enchant(Enchantment.byId(1), 4);
        //blast protection
        stack.enchant(Enchantment.byId(3), 4);
        //protection
        stack.enchant(Enchantment.byId(0), 4);
    }

}