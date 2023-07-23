package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.animal.Wolf;

/**
 * Render factory class; Minecraft needs a render factory class to produce copies of your render class as needed
 */
public class DragonWolfRenderFactory implements EntityRendererProvider<Wolf> {

    public static DragonWolfRenderFactory INSTANCE = new DragonWolfRenderFactory();

    @Override
    public EntityRenderer<Wolf> create(Context manager) {
        return new DragonWolfRenderer(manager);
    }

}
