package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;

public class GelSwordItem extends SwordItem {

    private static final Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);

    public static Tier tier = new ForgeTier(1, 150, 1.6F, 8.0F,
            5, null, () -> {return Ingredient.of(ItemMod.STRUCTURE_GEL);});

    public static Item INSTANCE = new GelSwordItem(tier, 3, 3,
           properties).setRegistryName(BaseMod.MODID, "gelsword");

    public GelSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        BlockPos pos = Utils.getBlockAtCursor(playerIn, 100.0d, true);

        if(pos != null) {
            Utils.setFireBlock(level, pos, Direction.UP);
        }

        return InteractionResultHolder.pass(itemstack);
    }

}
