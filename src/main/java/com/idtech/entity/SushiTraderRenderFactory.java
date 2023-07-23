package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.npc.WanderingTrader;

/**
 * Render factory class; Minecraft needs a render factory class to produce copies of your render class as needed
 */
public class SushiTraderRenderFactory implements EntityRendererProvider<WanderingTrader> {

    public static SushiTraderRenderFactory INSTANCE = new SushiTraderRenderFactory();

    @Override
    public EntityRenderer<WanderingTrader> create(Context manager) {
        return new SushiTraderRenderer(manager);
    }

}
