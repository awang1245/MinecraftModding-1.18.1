package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.item.ItemMod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

/**
 * Zombo entity code, this class is the blueprint for what a zombo entity will be in Minecraft.
 */
public class BulborbEntity extends Chicken {

    //type instance
    public static EntityType<BulborbEntity> TYPE = (EntityType<BulborbEntity>)
            EntityType.Builder.of(BulborbEntity::new, MobCategory.CREATURE)
                    .build("bulborb")
                    .setRegistryName(BaseMod.MODID, "bulborb"); //setRegistryName sets the name used internally

    //egg instance; allows us to set the color of the egg; 2nd arg is base color, 3rd is color of sports; 0x + hex code
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xffcda1, 0xff1900, ModTab.INSTANCE);

    public BulborbEntity(EntityType<? extends Chicken> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.MAX_HEALTH, 100);
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
        //breed and tempt goals important
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, Ingredient.of(ItemMod.sushiFoodItem), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.targetSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    //too complicated to override the aiStep method, as cannot get rid of super.aiStep() without
    //copying code from 5+ superclasses
    @Override
    public void aiStep() {
        super.aiStep();
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed = (float)((double)this.flapSpeed + (double)(this.onGround ? -1 : 4) * 0.3D);
        this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
        if (!this.onGround && this.flapping < 1.0F) {
            this.flapping = 1.0F;
        }

        this.flapping = (float)((double)this.flapping * 0.9D);
        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround && vec3.y < 0.0D) {
            this.setDeltaMovement(vec3.multiply(1.0D, 0.6D, 1.0D));
        }
    }

    //allows modded mob skin to show up on baby mobs too
    @Nullable
    @Override
    public BulborbEntity getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return TYPE.create(level);
    }

    //sets food that allows mob to breed
    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == ItemMod.sushiFoodItem;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PIGLIN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_29715_) {
        return SoundEvents.PIGLIN_ANGRY;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PIGLIN_DEATH;
    }
}
