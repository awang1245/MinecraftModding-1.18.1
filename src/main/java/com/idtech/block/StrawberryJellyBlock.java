package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;

public class StrawberryJellyBlock extends Block {

    //static instance for registration
    //web, replaceable plant, plant,
    //private static Properties properties = Properties.of(Material.COBWEB).noCollission();
    private static Properties properties = Properties.of(Material.PLANT).noCollission();

    //two diff instances, one for the block itself and one for inventory
    public static Block INSTANCE = new StrawberryJellyBlock(properties).setRegistryName(BaseMod.MODID, "strawberryjelly");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ModTab.INSTANCE);

    //constructor
    public StrawberryJellyBlock(Properties properties) {
        super(properties);
    }

    //madeline wants player to be shot forward if walk on it

    //stepon doesnt work in combo with noCollission

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            //if crouching, can walk through block, behaves like berry bush almost
            if (entity.isCrouching()) {
                entity.makeStuckInBlock(state, new Vec3((double)0.8F, 0.75D, (double)0.8F));
                //else player gets propelled forward in whatever direction they were moving in
            } else {
                if (entity.getDeltaMovement().x > 0) {
                    entity.setDeltaMovement(5, 0, 0);
                } else if (entity.getDeltaMovement().x < 0) {
                    entity.setDeltaMovement(-5, 0, 0);
                } else if (entity.getDeltaMovement().z > 0) {
                    entity.setDeltaMovement(0, 0, 5);
                } else if (entity.getDeltaMovement().z < 0) {
                    entity.setDeltaMovement(0, 0, -5);
                }
            }
        }
    }
}
