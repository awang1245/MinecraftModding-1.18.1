package com.idtech.item;

import com.idtech.ModTab;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;

//not working properly
public class GamemodeSwitchingFood extends Item {

    //static instance of item for registration
    public static FoodProperties food = (new FoodProperties.Builder().nutrition(3).saturationMod(1.4f).alwaysEat().build());
    private static final Properties properties = new Properties().tab(ModTab.INSTANCE).food(food);
    //private static final Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new GamemodeSwitchingFood(properties).setRegistryName("fancysauce");
//    int timer = 0;
//    int cooldown = 0;
//    boolean used = false;

    //constructor tells the code how to create the item using the properties passed in
    public GamemodeSwitchingFood(Properties properties) {
        super(properties);
    }

//    @Override
//    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
//        ItemStack itemstack = playerIn.getItemInHand(handIn);
//        if (!level.isClientSide) {
//            if (cooldown == 0 && ((ServerPlayer) playerIn).gameMode.getGameModeForPlayer() == GameType.SURVIVAL) {
//                ((ServerPlayer) playerIn).setGameMode(GameType.CREATIVE);
//                timer = 200;
//                used = true;
//            }
//        }
//        return InteractionResultHolder.pass(itemstack);
//    }

    //upon eating food, gamemode is switched to creative
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack itemstack = super.finishUsingItem(stack, level, entity);
        if (!level.isClientSide && entity instanceof Player) {
                ((ServerPlayer) entity).setGameMode(GameType.CREATIVE);
        }
        return itemstack;
    }

//    public void inventoryTick(ItemStack stack, Level level, Entity entity, int num, boolean bool) {
//        if (entity instanceof Player) {
//            if (timer > 0 && ((ServerPlayer) entity).gameMode.getGameModeForPlayer() == GameType.CREATIVE) {
//                timer--;
//            } else if (cooldown > 0 && ((ServerPlayer) entity).gameMode.getGameModeForPlayer() == GameType.SURVIVAL) {
//                cooldown--;
//            }
//            if (timer == 0 && used) {
//                ((ServerPlayer) entity).setGameMode(GameType.SURVIVAL);
//                cooldown = 200;
//            }
//        }
//    }

}
