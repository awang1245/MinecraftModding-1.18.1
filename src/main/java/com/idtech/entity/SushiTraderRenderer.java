package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.ChickenRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WanderingTraderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.npc.WanderingTrader;

public class SushiTraderRenderer extends WanderingTraderRenderer {

    public SushiTraderRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }

    /**
     * Method points the rendering code to the correct png file
     * @param entity
     * @return
     */
    @Override
    public ResourceLocation getTextureLocation(WanderingTrader entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/cherryvillager.png");
    }

}
