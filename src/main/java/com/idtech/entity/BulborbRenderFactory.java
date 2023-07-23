package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Zombie;

/**
 * Render factory class; Minecraft needs a render factory class to produce copies of your render class as needed
 */
public class BulborbRenderFactory implements EntityRendererProvider<Chicken> {

    public static BulborbRenderFactory INSTANCE = new BulborbRenderFactory();

    @Override
    public EntityRenderer<Chicken> create(Context manager) {
        return new BulborbRenderer(manager);
    }

}
