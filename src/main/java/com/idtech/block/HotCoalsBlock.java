package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class HotCoalsBlock extends Block {

    private static BlockBehaviour.Properties properties = BlockBehaviour.Properties.of(Material.STONE);

    public static Block INSTANCE = new HotCoalsBlock(properties).setRegistryName(BaseMod.MODID, "hotcoals");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ModTab.INSTANCE);

    //constructor
    public HotCoalsBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level levelIn, BlockPos posIn, BlockState blockStateIn, Entity entityIn) {
        super.stepOn(levelIn, posIn, blockStateIn, entityIn);
        //setSecondsOnFire takes in one argument that is the amt of time in seconds
        entityIn.setSecondsOnFire(1);
    }
}
