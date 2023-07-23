package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LightningHammerItem extends Item {

    //static instance of Item to be registered in ItemMod
    private static final Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new LightningHammerItem(properties).setRegistryName(BaseMod.MODID, "lightninghammer");

    //constructor tells the code how to create the item using the properties passed in
    public LightningHammerItem(Properties properties) {
        super(properties);
    }

    /**
     * Overrided method inherited from Item enabling the lightning hammer to perform an action when the
     * user right clicks, or uses, the item. When the user right clicks on a block, the code summons a
     * lightning bolt and creates an explosion at the location of the cursor.
     * @param level
     * @param playerIn
     * @param handIn
     * @return
     */
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        //gets the item (lightning hammer) held by the player for return
        ItemStack itemStack = playerIn.getItemInHand(handIn);

        //finds the block/location at the cursor
        //params: Player, distance (higher value if want to use from farther away), ignoreFluids
        BlockPos location = Utils.getBlockAtCursor(playerIn, 20.0d, true);

        //controls the size of the explosion; e.g. 0.5f means only one block is exploded
        float radius = 5f;

        //if cursor is pointing at an existing block/location (no fluids, sky)
        if (location != null) {

            //create an explosion at that location
            //params: world, location, explosion radius
            Utils.createExplosion(level, location, radius);
            //strike lightning
            //params: world, location
            Utils.strikeLightning(level, location);
        }
        //return success; calling the pass method tells Minecraft your action successfully happened
        return InteractionResultHolder.pass(itemStack);
    }

}
