package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class CustomArmorItem extends ArmorItem {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);

    public static final Item CUSTOM_HELM = new CustomArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.HEAD,
            (properties)).setRegistryName(BaseMod.MODID, "customhelm");
    public static final Item CUSTOM_CHEST = new CustomArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.CHEST,
            properties).setRegistryName(BaseMod.MODID, "customchest");
    public static final Item CUSTOM_LEGS = new CustomArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.LEGS,
            properties).setRegistryName(BaseMod.MODID, "customlegs");
    public static final Item CUSTOM_BOOTS = new CustomArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.FEET,
            properties).setRegistryName(BaseMod.MODID, "customboots");

    public CustomArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type){
        if(slot == EquipmentSlot.LEGS){
            return "examplemod:textures/models/armor/custom_armor_layer_2.png";
        }
        return "examplemod:textures/models/armor/custom_armor_layer_1.png";
    }

    @Override
    public void onArmorTick(ItemStack itemStack, Level level, Player player) {
        boolean helm = player.hasItemInSlot(EquipmentSlot.HEAD);
        if (helm) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 1));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5,1));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5,3));
        }
        super.onArmorTick(itemStack, level, player);
    }



}
