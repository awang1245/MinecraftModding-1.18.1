package com.idtech.entity;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

//Zombie superclass helps zombo get rendered in the same shape as a zombie
public class ZomboRenderer extends ZombieRenderer {

    //constructor exists so render factory can use this class to render the zombo
    public ZomboRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }

    /**
     * Method points the rendering code to the correct png file
     * @param entity
     * @return
     */
    @Override
    public ResourceLocation getTextureLocation(Zombie entity) {
        //if want to change zombo or any mob texture, only need to update the file path
        return new ResourceLocation(BaseMod.MODID, "textures/entity/zombo.png");
    }

}
