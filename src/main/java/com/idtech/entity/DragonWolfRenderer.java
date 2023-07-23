package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;

public class DragonWolfRenderer extends WolfRenderer {

    public DragonWolfRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }

    /**
     * Method points the rendering code to the correct png file
     * @param entity
     * @return
     */
    @Override
    public ResourceLocation getTextureLocation(Wolf entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/dragon.png");
    }

}
