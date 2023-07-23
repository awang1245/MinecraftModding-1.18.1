package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.ChickenRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Zombie;

public class BulborbRenderer extends ChickenRenderer {

    public BulborbRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }

    /**
     * Method points the rendering code to the correct png file
     * @param entity
     * @return
     */
    @Override
    public ResourceLocation getTextureLocation(Chicken entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/bulborb.png");
    }

}
