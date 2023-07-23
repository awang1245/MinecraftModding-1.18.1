package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
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

public class OverpoweredPickaxeItem extends PickaxeItem {

    private static final Properties properties = new Properties().tab(ModTab.INSTANCE);

    public static Item INSTANCE = new OverpoweredPickaxeItem(Tiers.NETHERITE, 100, 100, properties)
            .setRegistryName(BaseMod.MODID, "overpoweredpickaxe");

    public OverpoweredPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level levelIn, BlockState state, BlockPos pos, LivingEntity player) {
        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 1));
        for (int x_offset = -5; x_offset < 6; x_offset++) {
            for (int y_offset = -8; y_offset < 3; y_offset++) {
                for (int z_offset = -5; z_offset < 6; z_offset++) {
//                    if (x_offset == y_offset && y_offset == z_offset && z_offset == x_offset) {
//                        continue;
//                    }
                    BlockPos newPos = new BlockPos(pos.getX() + x_offset,
                            pos.getY() + y_offset, pos.getZ() + z_offset);
                    if (levelIn.getBlockState(newPos).getBlock() != Blocks.BEDROCK) {
                        levelIn.destroyBlock(newPos, true);
                    }
                }
            }
        }
        stack.hurtAndBreak(3000, player, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return false;
    }
}
