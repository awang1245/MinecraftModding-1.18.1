package com.idtech.entity;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.SoundHandler;
import com.idtech.Utils;
import com.idtech.item.FireCrystalArmorItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

/**
 * Zombo entity code, this class is the blueprint for what a zombo entity will be in Minecraft.
 */
public class SkeletonKingEntity extends Skeleton {

    //type instance
    public static EntityType<SkeletonKingEntity> TYPE = (EntityType<SkeletonKingEntity>)
            EntityType.Builder.of(SkeletonKingEntity::new, MobCategory.MONSTER)
                    .build("skeletonking")
                    .setRegistryName(BaseMod.MODID, "skeletonking"); //setRegistryName sets the name used internally

    //egg instance; allows us to set the color of the egg; 2nd arg is base color, 3rd is color of sports; 0x + hex code
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xfeffe3, 0x40ede4, ModTab.INSTANCE);

    //to display code for entities, use go to > declaratons/usages
    public SkeletonKingEntity(EntityType<? extends Skeleton> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE)//any mob deriving from Zombie needs spawn reinforcements chance in order to spawn
                .add(Attributes.FOLLOW_RANGE, 30)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 20)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
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
        //needed so Zombie does not sink to the bottom of a body of water
        this.targetSelector.addGoal(0, new FloatGoal(this));
        //attack goal for the zombo to decide what to attack; can have multiple
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Slime.class, false));
        //goal for the zombo to actually attack; second parameter is the zombo's speed
        this.targetSelector.addGoal(3, new MeleeAttackGoal(this, 0.8f, false));
        //goal for the zombo to call for help when attacked; can pick what entities the zombo gets help from
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setAlertOthers(SkeletonKingEntity.class));
        this.targetSelector.addGoal(5, new HurtByTargetGoal(this).setAlertOthers(Creeper.class));
        //lowest priority; goal for zombo to look around
        this.targetSelector.addGoal(8, new RandomLookAroundGoal(this));

        //goalSelector and targetSelector are the same; same class declared twice with different names
    }

    /**
     * Method is called every time an entity is spawned.
     * Here it is used to have a zombo ride another entity.
     * @param levelAccessor
     * @param difficultyInstance
     * @param mobSpawnType
     * @param spawnGroupData
     * @param compoundTag
     * @return
     */
    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
                                        MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData,
                                        @Nullable CompoundTag compoundTag) {

        this.setItemSlotAndDropWhenKilled(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));

        int random = this.level.random.nextInt(100);

        if (random < 10) {
            Llama llama = new Llama(EntityType.LLAMA, levelAccessor.getLevel());
            Utils.spawnEntity(levelAccessor.getLevel(), llama, this.blockPosition());

            this.startRiding(llama);
        }

        if (random > 10 && random < 30) {
            //method allows us to add an item to a "slot" on the entity; zombo is similar to a player so can
            // set items to same slot as a player's
            // 1st param: slot (EquipmentSlot.something); 2nd param: the actual item, new ItemStack(Items.something)
            //slots like head chest legs feet, need armor items specific to that spot
            //to add an item to another slot, just make a new line
            this.setItemSlotAndDropWhenKilled(EquipmentSlot.HEAD, new ItemStack(FireCrystalArmorItem.FIRE_CRYSTAL_HELM));
        }

        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WITHER_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.WITHER_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WITHER_SKELETON_DEATH;
    }
}
