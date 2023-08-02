package com.idtech.entity;

import com.idtech.item.ExplosionProjectile;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
        event.getRegistry().register(SkeletonKingEntity.TYPE);
        event.getRegistry().register(EvilRabbit.TYPE);

    }
    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event) {

        event.getRegistry().register(ZomboEntity.EGG);
        event.getRegistry().register(BulborbEntity.EGG);
        event.getRegistry().register(DragonWolfEntity.EGG);
        event.getRegistry().register(SushiTraderEntity.EGG);
        event.getRegistry().register(SkeletonKingEntity.EGG);
        event.getRegistry().register(EvilRabbit.EGG);

    }
    @SubscribeEvent
    public static void entityRenderers(final EntityRenderersEvent.RegisterRenderers event){

        event.registerEntityRenderer(ZomboEntity.TYPE, ZomboRenderFactory.INSTANCE);
        event.registerEntityRenderer(BulborbEntity.TYPE, BulborbRenderFactory.INSTANCE);
        event.registerEntityRenderer(DragonWolfEntity.TYPE, DragonWolfRenderFactory.INSTANCE);
        event.registerEntityRenderer(SushiTraderEntity.TYPE, SushiTraderRenderFactory.INSTANCE);
        event.registerEntityRenderer(SkeletonKingEntity.TYPE, SkeletonKingRenderFactory.INSTANCE);
        event.registerEntityRenderer(EvilRabbit.TYPE, EvilRabbitRenderFactory.INSTANCE);
        event.registerEntityRenderer(ExplosionProjectile.TYPE, (m) -> { return new ThrownItemRenderer<>(m, 1.0f, true);});

    }

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {

        event.put(ZomboEntity.TYPE, ZomboEntity.createAttributes().build());
        event.put(BulborbEntity.TYPE, BulborbEntity.createAttributes().build());
        event.put(DragonWolfEntity.TYPE, DragonWolfEntity.createAttributes().build());
        event.put(SushiTraderEntity.TYPE, SushiTraderEntity.createAttributes().build());
        event.put(SkeletonKingEntity.TYPE, SkeletonKingEntity.createAttributes().build());
        event.put(EvilRabbit.TYPE, EvilRabbit.createAttributes().build());

    }

}
