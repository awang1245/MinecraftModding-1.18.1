package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EvilRabbit extends Rabbit {

    public static EntityType<EvilRabbit> TYPE = (EntityType<EvilRabbit>)
            EntityType.Builder.of(EvilRabbit::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build("evilrabbit").setRegistryName(BaseMod.MODID, "evilrabbit");

    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xfef9f8 , 0x383737, ModTab.INSTANCE);

    public EvilRabbit(EntityType<? extends Rabbit> entityIn, Level levelIn) {
        super(entityIn, levelIn);
    }
}
