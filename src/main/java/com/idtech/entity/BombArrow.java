package com.idtech.entity;

import com.idtech.item.BombArrowItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

//two parts to creating projectiles, this is the entity that interacts with mobs and the world
public class BombArrow extends AbstractArrow {

    int count = 0;

    public BombArrow(Level levelIn, LivingEntity entityIn) {
        super(EntityType.ARROW, entityIn, levelIn);
    }

    //spawns item for pickup
    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack((BombArrowItem.INSTANCE));
    }

    //method activates when arrow lands somewhere
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        Vec3 loc = result.getLocation();
        if(count < 1) {
            //can control explosion radius
            level.explode(null, loc.x, loc.y, loc.z, 10.0F, Explosion.BlockInteraction.DESTROY);
            count++;
        }
    }
}
