package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;

public class OverWorldWeapon extends SwordItem {

    public static Tier tier = new ForgeTier(1,0,12, 0.0f, 22, null, () ->{return Ingredient.of(OverWorldWeapon.INSTANCE);});
    private static Properties properties = new Properties().tab(CreativeModeTab.TAB_COMBAT);
    public static Item INSTANCE = new OverWorldWeapon(tier, 7, -2,  properties).setRegistryName(BaseMod.MODID, "overworldweapon");

    public OverWorldWeapon(Tier tier, int attackDamageIn, int attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.addEffect(new MobEffectInstance(MobEffects.HEAL, 20, 2));
        return InteractionResultHolder.pass(itemstack);
    }

    //crafted using nature's heart + netherite sword
    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player playerin){
        //bane of arthropods
        stack.enchant(Enchantment.byId(22),5);
        //smite
        stack.enchant(Enchantment.byId(13),5);
        //looting
        stack.enchant(Enchantment.byId(17),3);
    }

    @Override
    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
        p_43280_.addEffect(new MobEffectInstance(MobEffects.HEAL, 20, 1));
        return super.hurtEnemy(p_43278_, p_43279_, p_43280_);
    }

}