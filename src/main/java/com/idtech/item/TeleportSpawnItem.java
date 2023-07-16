package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TeleportSpawnItem extends Item {

    //static instance of item for registration
    private static final Properties properties = new Properties().tab(CreativeModeTab.TAB_MISC);
    public static Item INSTANCE = new TeleportSpawnItem(properties).setRegistryName("teleportrod");

    //constructor tells the code how to create the item using the properties passed in
    public TeleportSpawnItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        //gets the item (teleport rod) held by the player for return
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        //finds the block/location at the cursor
        //params: Player, distance (higher value if want to use from farther away), ignoreFluids
        BlockPos pos = Utils.getBlockAtCursor(playerIn, 1000.0d, true);

        //if cursor is pointing at an existing block/location (no fluids, sky)
        if(pos != null) {

            //moves the player to the location of the block your cursor is pointing to
            playerIn.teleportTo(pos.getX(), pos.getY(), pos.getZ());

            //since player might teleport to somewhere in the air, set fall distance to zero so no damage
            playerIn.fallDistance = 0.0F;
        }

        //calling the pass method tells Minecraft your action successfully happened
        return InteractionResultHolder.pass(itemstack);
    }



}
