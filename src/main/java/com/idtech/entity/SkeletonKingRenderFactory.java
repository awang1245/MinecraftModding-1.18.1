package com.idtech.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.AbstractSkeleton;

/**
 * Render factory class; Minecraft needs a render factory class to produce copies of your render class as needed
 */
public class SkeletonKingRenderFactory implements EntityRendererProvider<AbstractSkeleton> {

    public static SkeletonKingRenderFactory INSTANCE = new SkeletonKingRenderFactory();

    @Override
    public EntityRenderer<AbstractSkeleton> create(Context manager) {
        return new SkeletonKingRenderer(manager);
    }

}
