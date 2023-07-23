package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeTier;

public class UraniumPickaxe extends PickaxeItem {

    private static final Properties properties = new Properties().tab(ModTab.INSTANCE);

    public static Tier tier = new ForgeTier(5, 3000, 15.0F, 5.0F,
            5, null, () -> {return Ingredient.of(ItemMod.STRUCTURE_GEL);});

    //params: item tier, attackDamage (bonus atk dmg amt), attackSpeed (bonus atk speed amt)
    public static Item INSTANCE = new UraniumPickaxe(tier, 0, 5, properties)
            .setRegistryName(BaseMod.MODID, "uraniumpickaxe");

    //constructor
    public UraniumPickaxe(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level levelIn, BlockState state, BlockPos pos, LivingEntity player) {
        player.addEffect(new MobEffectInstance(MobEffects.HARM, 5, 0));
        return false;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity enemy, LivingEntity player) {
        enemy.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 2));
        return super.hurtEnemy(stack, enemy, player);
    }

//    @Override
//    public void inventoryTick(ItemStack stack, Level level, Entity entity, int num, boolean bool) {
//        super.inventoryTick(stack, level, entity, num, bool);
//        ((Player) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, 5, 2));
//    }
}
