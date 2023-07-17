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

public class OverworldHelmet extends ArmorItem {

    private static Properties properties = new Properties().tab(CreativeModeTab.TAB_COMBAT);
   public static ArmorMaterial materials = ItemUtils.buildArmorMaterial("guardianspikes", 0,
           new int[]{10,10,10,10}, 22, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0f,
           1.0f, "minecraft:netherite_ingot");
    public static Item INSTANCE = new OverworldHelmet(materials, EquipmentSlot.HEAD, properties)
            .setRegistryName(BaseMod.MODID, "overworldhelmet");

    public OverworldHelmet(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "examplemod:textures/models/armor/overworld_helmet.png";
    }

    @Override
    public void onArmorTick(ItemStack itemStack, Level level, Player player) {
        boolean equipped = player.hasItemInSlot(EquipmentSlot.HEAD);
        if (equipped) {
            player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 5,1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1,0));
            //player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 5,0));
        }
        super.onArmorTick(itemStack, level, player);
    }

    //crafted using guardian spikes + netherite helmet
    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player playerin) {
        //aqua affinity
        stack.enchant(Enchantment.byId(6), 1);
        //respiration
        stack.enchant(Enchantment.byId(5), 3);
        //protection
        stack.enchant(Enchantment.byId(0), 4);
        //projectile protection
        stack.enchant(Enchantment.byId(4), 4);
    }

}
