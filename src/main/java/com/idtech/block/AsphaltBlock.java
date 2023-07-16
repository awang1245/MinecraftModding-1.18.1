package com.idtech.block;

import com.idtech.BaseMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class AsphaltBlock extends Block {

    //static instance for registration
    private static Properties properties = Properties.of(Material.STONE);

    //two diff instances, one for the block itself and one for inventory
    public static Block INSTANCE = new AsphaltBlock(properties).setRegistryName(BaseMod.MODID, "asphalt");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, CreativeModeTab.TAB_BUILDING_BLOCKS);

    //constructor
    public AsphaltBlock(Properties properties) {
        super(properties);
    }

    /**
     * Overriding parent class Block method stepOn, which is called any time an entity walks over the block.
     * We see this being used in the Magma block in Minecraft to deal damage to anyone who walks over it.
     *
     * Asphalt block will allow entities to walk faster (like the concrete block).
     *
     * @param levelIn
     * @param posIn
     * @param blockStateIn
     * @param entityIn
     */
    @Override
    public void stepOn(Level levelIn, BlockPos posIn, BlockState blockStateIn, Entity entityIn) {
        super.stepOn(levelIn, posIn, blockStateIn, entityIn);

        //adds velocity to propel entity forward
        entityIn.setDeltaMovement(1, 0, 0);
    }
}
