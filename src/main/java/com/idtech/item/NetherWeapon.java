package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;

public class NetherWeapon extends SwordItem {

    public static Tier tier = new ForgeTier(1,0,12, 0.0f, 22, null, () ->{return Ingredient.of(NetherWeapon.INSTANCE);});
    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    //public static Item INSTANCE = new OverWorldWeapon(Tiers.NETHERITE, 3, (int)-2,  properties).setRegistryName(BaseMod.MODID, "netherweapon");
    public static Item INSTANCE = new NetherWeapon(tier, 7, -2,  properties).setRegistryName(BaseMod.MODID, "netherweapon");

    public NetherWeapon(Tier tier, int attackDamageIn, int attackSpeedIn, Properties properties) {
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }

    //crafted using wither core + netherite sword
    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player playerin){
        //sharpness
        stack.enchant(Enchantment.byId(12),5);
        //fire aspect
        stack.enchant(Enchantment.byId(16), 2);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        float explosionRadius = 3.0f;

        level.explode(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), explosionRadius, Explosion.BlockInteraction.NONE);

        return InteractionResultHolder.pass(itemstack);
    }

}
