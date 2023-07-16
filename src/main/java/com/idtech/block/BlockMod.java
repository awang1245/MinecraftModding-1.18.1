package com.idtech.block;


import com.idtech.BaseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
//import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * File where we tell Minecraft about any Blocks we create
 */
@Mod.EventBusSubscriber
public class BlockMod {

    //Basic Block

    //name: used internally to keep track of item (must be in all lowercase!)
    //material: based on different block categories; ores are made of rock material hence we use stone
    // hardness, resistance, tooltype????
    public static final Block CASTLE_WALL = BlockUtils.createBasicBlock("castlewall", Material.STONE);
    //used so block can act like item in inventory and player's hand
    public static final Item CASTLE_WALL_ITEM = BlockUtils.createBlockItem(CASTLE_WALL, CreativeModeTab.TAB_BUILDING_BLOCKS);

    //block instance of gel ore
    public static final Block GEL_ORE_BLOCK = BlockUtils.createBasicBlock("geloreblock", Material.STONE, 0.5f);

    /*
    * Screenshot showing resistance and ToolType does not match the resource pack we are using, so we cannot just
    * set tool type when creating our block instance.
    * 1. Use the code below with method .requiresCorrectToolForDrops()
    * 2. navigate to resources>data>minecraft.tags>blocks>mineable>pickaxe.json
    * 3. add "examplemod:geloreblock" to square brackets
     */
    //public static final Block GEL_ORE_BLOCK = new OreBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)).setRegistryName(BaseMod.MODID, "geloreblock");

    //block item instance of gel ore
    public static final Item GEL_ORE_BLOCK_ITEM = BlockUtils.createBlockItem(GEL_ORE_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);

    /**
     * In two methods below, blocks are registered so they can actually show up in the game.
     * Unlike Items which we worked with earlier, Blocks need both the block instance and block item instance
     * (for inventory and player's hand) to be registered.
     * @param event
     */
    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {

        //BASIC BLOCK ITEMS

        //registers the block item so it shows up in Minecraft; also need to register the block itself
        event.getRegistry().register(CASTLE_WALL_ITEM);
        event.getRegistry().register(GEL_ORE_BLOCK_ITEM);

        //REGULAR BLOCK ITEMS
        event.getRegistry().register(RubberBlock.ITEM);
        event.getRegistry().register(AsphaltBlock.ITEM);
        event.getRegistry().register(CreepingMoldBlock.ITEM);
        event.getRegistry().register(CreeperSurpriseBlock.ITEM);
        event.getRegistry().register(HotCoalsBlock.ITEM);

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        //BASIC BLOCKS

        //registers the block itself
        event.getRegistry().register(CASTLE_WALL);
        event.getRegistry().register(GEL_ORE_BLOCK);

        //REGULAR BLOCKS
        event.getRegistry().register(RubberBlock.INSTANCE);
        event.getRegistry().register(AsphaltBlock.INSTANCE);
        event.getRegistry().register(CreepingMoldBlock.INSTANCE);
        event.getRegistry().register(CreeperSurpriseBlock.INSTANCE);
        event.getRegistry().register(HotCoalsBlock.INSTANCE);

    }
}





