package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ZooSwordItem extends SwordItem {

    private static final Properties properties = new Properties().tab(CreativeModeTab.TAB_COMBAT);
    public static Item INSTANCE = new ZooSwordItem(Tiers.WOOD, 2, 100, properties)
            .setRegistryName("zoosword");

    public ZooSwordItem(Tiers tier, int speed, float damage, Properties properties) {

        super(tier, speed, damage, properties);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn) {

        //geting the block the player's cursor is on
        BlockPos location = Utils.getBlockAtCursor(playerIn, 200.0d, true);

        //max size of array
        int size = 10;

        EntityType[] animals = new EntityType[size];

        animals[0] = EntityType.BAT;
        animals[1] = EntityType.DONKEY;
        animals[2] = EntityType.BEE;
        animals[3] = EntityType.BOAT;
        animals[4] = EntityType.CAVE_SPIDER;
        animals[5] = EntityType.EXPERIENCE_ORB;
        animals[6] = EntityType.MAGMA_CUBE;
        animals[7] = EntityType.IRON_GOLEM;
        animals[8] = EntityType.MOOSHROOM;
        animals[9] = EntityType.FIREWORK_ROCKET;

        //stores a random number between 0 and 9
        int rand = levelIn.random.nextInt(10);

        //if player cursor is on block
        if (location != null) {
            //create the random animal
            Entity newAnimal = animals[rand].create(levelIn);
            //spawn the animal
            Utils.spawnEntity(levelIn, newAnimal, location);

            //return successful
            return InteractionResultHolder.success(playerIn.getItemInHand(handIn));
        }

        //return failure if player is not pointing at valid block
        return InteractionResultHolder.fail(playerIn.getItemInHand(handIn));
    }

}
