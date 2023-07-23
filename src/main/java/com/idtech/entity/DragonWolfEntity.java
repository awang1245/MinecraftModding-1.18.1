package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.item.ItemMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;

/**
 * Zombo entity code, this class is the blueprint for what a zombo entity will be in Minecraft.
 */
public class DragonWolfEntity extends Wolf {

    //type instance
    public static EntityType<DragonWolfEntity> TYPE = (EntityType<DragonWolfEntity>)
            EntityType.Builder.of(DragonWolfEntity::new, MobCategory.CREATURE)
                    .build("dragon")
                    .setRegistryName(BaseMod.MODID, "dragon"); //setRegistryName sets the name used internally

    //egg instance; allows us to set the color of the egg; 2nd arg is base color, 3rd is color of sports; 0x + hex code
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0x373040, 0x6bf0ff, ModTab.INSTANCE);

    //to display code for entities, use go to > declaratons/usages
    public DragonWolfEntity(EntityType<? extends Wolf> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 50);
    }

    //need to change here in order for health and damage attribute changes to work
    @Override
    public void setTame(boolean p_30443_) {
        super.setTame(p_30443_);
        if (p_30443_) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(400.0D);
            this.setHealth(400.0F);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(200.0D);
        }
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(50.0D);
    }

    /**
     * The actions and tasks entities in Minecraft perform are controlled by AI, artificial intelligence.
     * The way it works is that each entity has a set of goals, each with their own priority, and the entity
     * will pick a goal to complete based on its priority.
     *
     * A chicken, for example, has very different goals from a Zombie. Zombie's have goals focused on attacking,
     * while chickens have goals like float, panic, and breed
     */
    @Override
    public void registerGoals() {
        this.targetSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, Ingredient.of(ItemMod.yummyFoodItem), false));
        this.goalSelector.addGoal(3, new BegGoal(this, 8.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Zombie.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Creeper.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Skeleton.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Slime.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Spider.class, false));
        this.targetSelector.addGoal(4, new MeleeAttackGoal(this, 1, false));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(5, (new HurtByTargetGoal(this)).setAlertOthers());
        this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));
    }

    //ensures modded mob skin shows up on babies
    @Nullable
    @Override
    public DragonWolfEntity getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return TYPE.create(level);
    }

    //sets food that allows mob to breed
    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == ItemMod.yummyFoodItem;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENDER_DRAGON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_29715_) {
        return SoundEvents.ENDER_DRAGON_GROWL;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDER_DRAGON_DEATH;
    }

    @Override
    public InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
        ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
        Item item = itemstack.getItem();
        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(p_30412_) || this.isTame() || itemstack.is(ItemMod.yummyFoodItem) && !this.isTame() && !this.isAngry();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!p_30412_.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    this.heal((float)item.getFoodProperties().getNutrition());
                    this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
                    return InteractionResult.SUCCESS;
                }

                if (!(item instanceof DyeItem)) {
                    InteractionResult interactionresult = super.mobInteract(p_30412_, p_30413_);
                    if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(p_30412_)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        this.setTarget((LivingEntity)null);
                        return InteractionResult.SUCCESS;
                    }

                    return interactionresult;
                }

                DyeColor dyecolor = ((DyeItem)item).getDyeColor();
                if (dyecolor != this.getCollarColor()) {
                    this.setCollarColor(dyecolor);
                    if (!p_30412_.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    return InteractionResult.SUCCESS;
                }
            } else if (itemstack.is(ItemMod.yummyFoodItem) && !this.isAngry()) {
                if (!p_30412_.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_30412_)) {
                    this.tame(p_30412_);
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte)7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte)6);
                }

                return InteractionResult.SUCCESS;
            }

            return super.mobInteract(p_30412_, p_30413_);
        }
    }
}
