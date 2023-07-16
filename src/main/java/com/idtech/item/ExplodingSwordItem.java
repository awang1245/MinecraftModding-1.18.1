package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class ExplodingSwordItem extends SwordItem {

    private static final Properties properties = new Properties().tab(CreativeModeTab.TAB_MISC);

    public static Item INSTANCE = new ExplodingSwordItem(Tiers.NETHERITE, 3, 3,
           properties).setRegistryName(BaseMod.MODID, "explodingsword");

    public ExplodingSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        float explosionRadius = 3.0f;

        level.explode(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(),
                explosionRadius, Explosion.BlockInteraction.BREAK);

        return InteractionResultHolder.pass(itemstack);
    }

    }
