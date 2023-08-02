package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.KnockbackEnchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;

public class EndWeapon extends SwordItem {

    public static Tier tier = new ForgeTier(1,0,12, 0.0f, 21, null, () ->{return Ingredient.of(EndWeapon.INSTANCE);});
    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    //public static Item INSTANCE = new OverWorldWeapon(Tiers.NETHERITE, 3, (int)-2,  properties).setRegistryName(BaseMod.MODID, "endweapon");
    public static Item INSTANCE = new EndWeapon(tier, 7, -2,  properties).setRegistryName(BaseMod.MODID, "endweapon");
    //private boolean isCoolingDown = false;
    private final int MAX_COOLDOWN = 60;
    private int curCoolDown = 0;


    public EndWeapon(Tier tier, int attackDamageIn, int attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

        ItemStack itemstack = playerIn.getItemInHand(handIn);

//        if (curCoolDown > 0) {
//            return InteractionResultHolder.fail(itemstack);
//        }
        //else {
            BlockPos pos = Utils.getBlockAtCursor(playerIn, 50.0d, false);

            if(pos != null){
                playerIn.teleportTo(pos.getX(), pos.getY(), pos.getZ());
                playerIn.fallDistance = 0.0F;
            }
            //isCoolingDown = !isCoolingDown;
            //curCoolDown = MAX_COOLDOWN;
            return InteractionResultHolder.pass(itemstack);
        //}
    }

//    @Override
//    public void inventoryTick(ItemStack stack, Level level, Entity entity, int num, boolean bool) {
//        super.inventoryTick(stack, level, entity, num, bool);
//        if (curCoolDown > 0) {
//            curCoolDown--;
//        }
//    }

    //crafted using dragon egg + netherite sword
    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player playerin){
        //knockback
        stack.enchant(Enchantment.byId(15), 2);
        //sweeping edge
        stack.enchant(Enchantment.byId(18), 3);
    }

    /**
     * id record
     * channelling: 32
     * efficiency: 19
     * sharpness: 12
     * fortune: 22
     * sweeping edge: 18
     * looting: 17
     * unbreaking: 21
     * fire aspect: 16
     * silk touch: 20
     * knockback: 15
     * smite: 13
     * soul speed: 11
     * punch: 24
     * lure: 28
     * quick charge: 34
     * flame: 25
     * impaling: 30
     * bane of anthropods: 14
     * riptide: 31
     * power: 23
     * infinity: 26
     * luck of the sea: 27
     * loyalty: 29
     */
}

