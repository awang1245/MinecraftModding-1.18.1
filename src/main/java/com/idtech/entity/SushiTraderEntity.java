package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.SoundHandler;
import com.idtech.Utils;
import com.idtech.item.ItemMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

/**
 * Zombo entity code, this class is the blueprint for what a zombo entity will be in Minecraft.
 */
public class SushiTraderEntity extends WanderingTrader {

    public static EntityType<SushiTraderEntity> TYPE = (EntityType<SushiTraderEntity>)
            EntityType.Builder.of(SushiTraderEntity::new, MobCategory.CREATURE)
                    .build("cherryvillager")
                    .setRegistryName(BaseMod.MODID, "cherryvillager"); //setRegistryName sets the name used internally

    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xffb8f3, 0xf03ef0, ModTab.INSTANCE);

    public SushiTraderEntity(EntityType<? extends WanderingTrader> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.2);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, TropicalFish.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Salmon.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Cod.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Pufferfish.class, false));
    }

    @Override
    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();

        merchantoffers.clear();

            ItemStack stack = new ItemStack(ItemMod.sushiFoodItem, 1);

            MerchantOffer customOffer = new MerchantOffer(new ItemStack(Items.EMERALD, 3),
                    stack, 64, 8, 0.03f);

            merchantoffers.add(0, customOffer);

            this.addOffersFromItemListings(merchantoffers, new VillagerTrades.ItemListing[0], 0);
//        VillagerTrades.ItemListing[] avillagertrades$itemlisting = VillagerTrades.WANDERING_TRADER_TRADES.get(1);
//        VillagerTrades.ItemListing[] avillagertrades$itemlisting1 = VillagerTrades.WANDERING_TRADER_TRADES.get(2);
//        if (avillagertrades$itemlisting != null && avillagertrades$itemlisting1 != null) {
//            MerchantOffers merchantoffers = this.getOffers();
//
//            ItemStack stack = new ItemStack(ItemMod.sushiFoodItem, 1);
//
//            MerchantOffer customOffer = new MerchantOffer(new ItemStack(Items.EMERALD, 3),
//                    stack, 10, 8, 0.03f);
//
//            merchantoffers.add(0, customOffer);
//
//            this.addOffersFromItemListings(merchantoffers, avillagertrades$itemlisting, 5);
//            int i = this.random.nextInt(avillagertrades$itemlisting1.length);
//            VillagerTrades.ItemListing villagertrades$itemlisting = avillagertrades$itemlisting1[i];
//            MerchantOffer merchantoffer = villagertrades$itemlisting.getOffer(this, this.random);
//            if (merchantoffer != null) {
//                merchantoffers.add(merchantoffer);
//
//            }
//        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CANDLE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_29715_) {
        return SoundEvents.BUBBLE_COLUMN_BUBBLE_POP;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BAMBOO_BREAK;
    }
}