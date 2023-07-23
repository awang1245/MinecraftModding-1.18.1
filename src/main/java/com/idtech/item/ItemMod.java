package com.idtech.item;

import com.idtech.ModTab;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * File where we tell Minecraft about any Items we make
 */
@Mod.EventBusSubscriber
public class ItemMod {

    /**
     * This is the code to create an instance of our items. At t
     */

    //BASIC ITEMS
    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", ModTab.INSTANCE);
    public static final Item GEL_ORE = ItemUtils.buildBasicItem("gelore", ModTab.INSTANCE);
    public static final Item PERI_CRYSTAL = ItemUtils.buildBasicItem("pericrystal", CreativeModeTab.TAB_MISC);
    public static final Item WITHER_CORE = ItemUtils.buildBasicItem("withercore", ModTab.INSTANCE);
    public static final Item NATURES_HEART = ItemUtils.buildBasicItem("naturesheart", ModTab.INSTANCE);
    public static final Item WITHER_ESSENCE = ItemUtils.buildBasicItem("witheressence", ModTab.INSTANCE);
    public static final Item DRAGONS_CLAW = ItemUtils.buildBasicItem("dragonsclaw", ModTab.INSTANCE);
    public static final Item GUARDIAN_SPIKES = ItemUtils.buildBasicItem("guardianspikes", ModTab.INSTANCE);

    //FOODS
    //hunger in half food icons
    //saturation: time it takes to get hungry again
    //effect: mobeffectinstance: 2nd arg is duration in milliseconds, 3rd arg is amplifier how powerful effect is
    //last arg is probability effect happens
    public static FoodProperties yummyFood = (new FoodProperties.Builder().nutrition(5).saturationMod(1.4f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 1000, 1), 0.5f).alwaysEat().build());
    public static Item yummyFoodItem = ItemUtils.buildFoodItem("yummyfood", yummyFood, ModTab.INSTANCE);

    public static FoodProperties sushi = (new FoodProperties.Builder().nutrition(3).saturationMod(1.4f)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 1000, 5), 0.5f).alwaysEat().build());
    public static Item sushiFoodItem = ItemUtils.buildFoodItem("sushi", sushi, ModTab.INSTANCE);


    /**
     * Method where modded items are registered so they show up in the game (creative inventory)
     * Uses instances of the created Items to let Minecraft know the item exists + needs to be registered
     * @param event
     */
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        event.getRegistry().register(STRUCTURE_GEL);
        event.getRegistry().register(GEL_ORE);
        event.getRegistry().register(PERI_CRYSTAL);
        event.getRegistry().register(STRUCTURE_GEL);
        event.getRegistry().register(WITHER_CORE);
        event.getRegistry().register(NATURES_HEART);
        event.getRegistry().register(WITHER_ESSENCE);
        event.getRegistry().register(DRAGONS_CLAW);
        event.getRegistry().register(GUARDIAN_SPIKES);

        // ITEMS
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        event.getRegistry().register(KnockbackStick.INSTANCE);

        // TOOLS
        event.getRegistry().register(GelPickaxeItem.INSTANCE);
        event.getRegistry().register(GelAxeItem.INSTANCE);
        event.getRegistry().register(GelSwordItem.INSTANCE);
        event.getRegistry().register(GelShovelItem.INSTANCE);
        event.getRegistry().register(GelHoeItem.INSTANCE);
        event.getRegistry().register(DuckSword.INSTANCE);
        event.getRegistry().register(ZooSwordItem.INSTANCE);
        event.getRegistry().register(ExplodingSwordItem.INSTANCE);
        event.getRegistry().register(EndWeapon.INSTANCE);
        event.getRegistry().register(NetherWeapon.INSTANCE);
        event.getRegistry().register(OverWorldWeapon.INSTANCE);
        event.getRegistry().register(OverpoweredPickaxeItem.INSTANCE);
        event.getRegistry().register(UraniumPickaxe.INSTANCE);

        // FOOD
        event.getRegistry().register(yummyFoodItem);
        event.getRegistry().register(sushiFoodItem);

        // ARMOR
        event.getRegistry().register(CustomArmorItem.CUSTOM_HELM);
        event.getRegistry().register(CustomArmorItem.CUSTOM_CHEST);
        event.getRegistry().register(CustomArmorItem.CUSTOM_LEGS);
        event.getRegistry().register(CustomArmorItem.CUSTOM_BOOTS);
        event.getRegistry().register(FireCrystalArmorItem.FIRE_CRYSTAL_HELM);
        event.getRegistry().register(FireCrystalArmorItem.FIRE_CRYSTAL_CHEST);
        event.getRegistry().register(FireCrystalArmorItem.FIRE_CRYSTAL_LEGS);
        event.getRegistry().register(FireCrystalArmorItem.FIRE_CRYSTAL_BOOTS);
        event.getRegistry().register(GogglesItem.GOGGLES);
        event.getRegistry().register(EndHelmet.INSTANCE);
        event.getRegistry().register(NetherHelmet.INSTANCE);
        event.getRegistry().register(OverworldHelmet.INSTANCE);

        //PROJECTILES

    }

    /**
     * Next we add a texture and model so that our item has a nice appearance in game. Otherwise it will just
     * look like a pink and black block. Then we name it so the in game name appears nicely too.
     *
     * Items in Minecraft use what's called a JSON file to tell Minecraft how to attach your png to the code
     * you wrote.
     * Type generated _____ in generate > items file; then use generateItemJSONS in Gradle tab
     *
     * Then go to resources > assets > examplemod to update the name so it shows up looking good in
     * Minecraft
     */
}
