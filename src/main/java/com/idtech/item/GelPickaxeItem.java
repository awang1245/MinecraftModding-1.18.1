package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeTier;

public class GelPickaxeItem extends PickaxeItem {

    //instance of a tool item has a Tool tier, damage value, and attack speed value
    private static final Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);

    //to decide the stats for the gel pickaxe, create a tier (like wood, stone, iron, diamond),
    // which has stats for
    // mining lvl, durability (# of uses), mining speed (efficiency), damage (combination of
    // value here and atk and speed values from instance), enchantability, repair ingredient
    public static Tier tier = new ForgeTier(3, 50, 8.0F, 10.0F,
            5, null, () -> {return Ingredient.of(ItemMod.STRUCTURE_GEL);});

    //params: item tier, attackDamage (bonus atk dmg amt), attackSpeed (bonus atk speed amt)
    public static Item INSTANCE = new GelPickaxeItem(tier, 100, 100, properties)
            .setRegistryName(BaseMod.MODID, "gelpickaxe");

    //constructor
    public GelPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level levelIn, BlockState state, BlockPos pos, LivingEntity player) {
//        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 500, 2));
//        Utils.createExplosion(levelIn, pos, 0.5f);
//        Utils.strikeLightning(levelIn, pos);
//        stack.hurtAndBreak(100, player, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
//        player.addEffect(new MobEffectInstance(MobEffects.HEAL, 20, 2));
        for (int x_offset = -1; x_offset < 2; x_offset++) {
            for (int y_offset = -1; y_offset < 2; y_offset++) {
                for (int z_offset = -1; z_offset < 2; z_offset++) {
//                    if (x_offset == y_offset && y_offset == z_offset && z_offset == x_offset) {
//                        continue;
//                    }
                    BlockPos newPos = new BlockPos(pos.getX() + x_offset, pos.getY() + y_offset, pos.getZ() + z_offset);
                    if (levelIn.getBlockState(newPos).getBlock() != Blocks.BEDROCK) {
                        levelIn.destroyBlock(newPos, true);
                    }
                }
            }
        }
        return false;
    }
}
