package com.idtech.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityMod {

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){

        event.getRegistry().register(ZomboEntity.TYPE);
        event.getRegistry().register(BulborbEntity.TYPE);
        event.getRegistry().register(DragonWolfEntity.TYPE);
        event.getRegistry().register(SushiTraderEntity.TYPE);

    }
    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event) {

        event.getRegistry().register(ZomboEntity.EGG);
        event.getRegistry().register(BulborbEntity.EGG);
        event.getRegistry().register(DragonWolfEntity.EGG);
        event.getRegistry().register(SushiTraderEntity.EGG);

    }
    @SubscribeEvent
    public static void entityRenderers(final EntityRenderersEvent.RegisterRenderers event){

        event.registerEntityRenderer(ZomboEntity.TYPE, ZomboRenderFactory.INSTANCE);
        event.registerEntityRenderer(BulborbEntity.TYPE, BulborbRenderFactory.INSTANCE);
        event.registerEntityRenderer(DragonWolfEntity.TYPE, DragonWolfRenderFactory.INSTANCE);
        event.registerEntityRenderer(SushiTraderEntity.TYPE, SushiTraderRenderFactory.INSTANCE);

    }

    // this is different than in 1.16 but everything else is the same
    // I do think this makes more sense than the other way but alas change is usually hard.
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {

        event.put(ZomboEntity.TYPE, ZomboEntity.createAttributes().build());
        event.put(BulborbEntity.TYPE, BulborbEntity.createAttributes().build());
        event.put(DragonWolfEntity.TYPE, DragonWolfEntity.createAttributes().build());
        event.put(SushiTraderEntity.TYPE, SushiTraderEntity.createAttributes().build());

    }

}
