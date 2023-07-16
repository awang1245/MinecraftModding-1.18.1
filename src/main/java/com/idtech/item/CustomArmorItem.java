package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

import javax.annotation.Nullable;

public class CustomArmorItem extends ArmorItem {

    private static Properties properties = new Properties().tab(CreativeModeTab.TAB_COMBAT);

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
}
