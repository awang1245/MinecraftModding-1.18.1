package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

import javax.annotation.Nullable;

public class FireCrystalArmorItem extends ArmorItem {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);

    public static final Item FIRE_CRYSTAL_HELM = new FireCrystalArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.HEAD,
            (properties)).setRegistryName(BaseMod.MODID, "firecrystalhelm");
    public static final Item FIRE_CRYSTAL_CHEST = new FireCrystalArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.CHEST,
            properties).setRegistryName(BaseMod.MODID, "firecrystalchest");
    public static final Item FIRE_CRYSTAL_LEGS = new FireCrystalArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.LEGS,
            properties).setRegistryName(BaseMod.MODID, "firecrystallegs");
    public static final Item FIRE_CRYSTAL_BOOTS = new FireCrystalArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.FEET,
            properties).setRegistryName(BaseMod.MODID, "firecrystalboots");

    public FireCrystalArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type){
        if(slot == EquipmentSlot.LEGS){
            return "examplemod:textures/models/armor/firecrystal_armor_layer_2.png";
        }
        return "examplemod:textures/models/armor/firecrystal_armor_layer_1.png";
    }
}
