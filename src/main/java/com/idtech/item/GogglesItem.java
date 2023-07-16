package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

import javax.annotation.Nullable;

public class GogglesItem extends ArmorItem {

    private static Properties properties = new Properties().tab(CreativeModeTab.TAB_COMBAT);

    public static final Item GOGGLES = new GogglesItem(ArmorMaterials.IRON, EquipmentSlot.HEAD,
            properties).setRegistryName(BaseMod.MODID, "goggles");

    public GogglesItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type){
        return "examplemod:textures/models/armor/xray_goggles.png";
    }
}
