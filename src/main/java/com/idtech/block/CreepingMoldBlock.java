package com.idtech.block;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class CreepingMoldBlock extends Block {

    private static Properties properties = Properties.of(Material.STONE).randomTicks();
    public static Block INSTANCE = new CreepingMoldBlock(properties).setRegistryName(BaseMod.MODID, "creepingmold");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, CreativeModeTab.TAB_BUILDING_BLOCKS);

    public CreepingMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, Random random) {
        super.randomTick(blockState, serverLevel, pos, random);

        //takes in position of the current block and finds the position of a random neighboring block
        // this position is where the new creeping mold block will be spawned
        BlockPos blockPos = Utils.findNeightborBlock(pos);

        //if the random neighboring block's position exists
        if(blockPos != null) {
            //set the block at that position to be creeping mold
            // "this" is us referencing the class we are currently in;
            // calling the method defaultBlockState on our creeping mold class
            serverLevel.setBlockAndUpdate(blockPos, this.defaultBlockState());
        }
    }

}
