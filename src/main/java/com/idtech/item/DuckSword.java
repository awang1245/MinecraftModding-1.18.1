package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.Utils;
import com.idtech.entity.ZomboEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;

public class DuckSword extends SwordItem {
    private static final Properties properties = new Item.Properties().tab(ModTab.INSTANCE);

    public static Tier tier = new ForgeTier(4, 450, 12.0F, 15.0F,
            10, null, () -> {return Ingredient.of(ItemMod.STRUCTURE_GEL);});

    public static Item INSTANCE = new DuckSword(tier, 100, 100,
            properties).setRegistryName(BaseMod.MODID, "shubaduck");

    public DuckSword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        BlockPos pos = Utils.getBlockAtCursor(playerIn, 1000.0d, true);

        //Creeper creeper = new Creeper(EntityType.CREEPER, level);
        //Utils.spawnEntity(level, creeper, pos);

        if(pos != null) {

            Utils.spawnEntity(level, new ZomboEntity(ZomboEntity.TYPE, level), pos);

        }
        return InteractionResultHolder.pass(itemstack);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player playerIn) {
        stack.enchant(Enchantment.byId(20), 2);
    }

}
