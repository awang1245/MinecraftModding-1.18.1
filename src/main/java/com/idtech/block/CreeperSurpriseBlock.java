package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;

public class CreeperSurpriseBlock extends Block {

    //can add properties like block strength and more???
    private static Properties properties = Properties.of(Material.STONE);

    public static Block INSTANCE = new CreeperSurpriseBlock(properties).setRegistryName(BaseMod.MODID, "creepersurprise");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, CreativeModeTab.TAB_BUILDING_BLOCKS);

    //constructor
    public CreeperSurpriseBlock(Properties properties) {
        super(properties);
    }

    /**
     * playerDestroy only works in survival mode.
     *
     * @param level
     * @param player
     * @param pos
     * @param blockState
     * @param blockEntity
     * @param stack
     */
    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState blockState,
                              @Nullable BlockEntity blockEntity, ItemStack stack) {

        super.playerDestroy(level, player, pos, blockState, blockEntity, stack);

        EntityType[] animals = new EntityType[10];

        animals[0] = EntityType.SKELETON;
        animals[1] = EntityType.ENDER_DRAGON;
        animals[2] = EntityType.BEE;
        animals[3] = EntityType.BOAT;
        animals[4] = EntityType.CAVE_SPIDER;
        animals[5] = EntityType.EXPERIENCE_ORB;
        animals[6] = EntityType.MAGMA_CUBE;
        animals[7] = EntityType.IRON_GOLEM;
        animals[8] = EntityType.MOOSHROOM;
        animals[9] = EntityType.FIREWORK_ROCKET;

        int rand = level.random.nextInt(10);
        Entity newAnimal = animals[rand].create(level);
        Utils.spawnEntity(level, newAnimal, pos);

        //Creeper creeper = new Creeper(EntityType.CREEPER, level);
        //1st param: level aka world entity is spawned in; 2nd: EntityType the entity to be spawned; 3rd: block position
        //Utils.spawnEntity(level, creeper, pos);
    }
}
