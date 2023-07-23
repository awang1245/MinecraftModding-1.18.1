package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

//extends/inheriting from Block allows us to borrow block code from Minecraft and lets us override only the code
// we need to change; extends = "is a"; a RubberBlock is a Block
public class RubberBlock extends Block {

    //static instance for registration
    private static Properties properties = Properties.of(Material.STONE); //Material handles the blocks opacity, movement, and other things

    //two diff instances, one for the block itself and one for inventory
    public static Block INSTANCE = new RubberBlock(properties).setRegistryName(BaseMod.MODID, "rubber");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, CreativeModeTab.TAB_BUILDING_BLOCKS);

    //constructor
    public RubberBlock(Properties properties) {
        super(properties);
    }

    /**
     * Overriding parent class Block method stepOn, which is called any time an entity walks over the block.
     * We see this being used in the Magma block in Minecraft to deal damage to anyone who walks over it.
     *
     * Rubber block will launch entities into the air.
     *
     * @param levelIn
     * @param posIn
     * @param blockStateIn
     * @param entityIn
     */
    @Override
    public void stepOn(Level levelIn, BlockPos posIn, BlockState blockStateIn, Entity entityIn) {
        super.stepOn(levelIn, posIn, blockStateIn, entityIn);

        //adds velocity to the entity to launch it up into the air
        //numbers in parentheses are x y z values; we want entity to be launched up, so we add velocity to y-axis
        //if you are interested in having the player be transported forward or sideways, you can edit the x and z values too
        entityIn.setDeltaMovement(0, 5, 0);
//        if (entityIn.getBlockY() <= posIn.getY() + 10 && entityIn.getBlockX() == posIn.getX()) {
//            ((LivingEntity) entityIn).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 120, 1));
//        }

    }
}
