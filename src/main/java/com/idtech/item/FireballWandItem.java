package com.idtech.item;

import com.idtech.ModTab;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FireballWandItem extends Item {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);

    public static Item INSTANCE = new FireballWandItem(properties).setRegistryName("fireballwand");

    public FireballWandItem(Properties properties) {
        super(properties); }

    @Override
    public InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        levelIn.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(),
                SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 0.5F,
                0.4F / (levelIn.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!levelIn.isClientSide) {
            ExplosionProjectile projectile = new ExplosionProjectile(levelIn, playerIn);
            //manually set the projectile instead of it being the item the playing is holding
            projectile.setItem(new ItemStack(ItemMod.sushiFoodItem));
            projectile.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 1.5F, 1.0F);
            levelIn.addFreshEntity(projectile);
        }

        // commented out so the wand does not disappear after one use!!
//        if (!playerIn.getAbilities().instabuild) {
//            itemstack.shrink(1);
//        }
        return InteractionResultHolder.sidedSuccess(itemstack, levelIn.isClientSide());
    }
}
