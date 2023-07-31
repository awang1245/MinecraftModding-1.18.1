package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EvilRabbit extends Rabbit {

    public static EntityType<EvilRabbit> TYPE = (EntityType<EvilRabbit>)
            EntityType.Builder.of(EvilRabbit::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build("evilrabbit").setRegistryName(BaseMod.MODID, "evilrabbit");

    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xfef9f8 , 0x383737, ModTab.INSTANCE);

    public EvilRabbit(EntityType<? extends Rabbit> entityIn, Level levelIn) {
        super(entityIn, levelIn);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 12)
                .add(Attributes.MOVEMENT_SPEED, 5)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.FOLLOW_RANGE, 35);
    }
}
