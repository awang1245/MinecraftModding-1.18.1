package com.idtech.world;

import com.idtech.BaseMod;
import com.idtech.block.BlockMod;
import com.idtech.entity.ZomboEntity;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * In order for our mob to naturally spawn in certain biomes, we need to call an event listener method in
 * BaseMod.
 * Event Listeners are special methods that wait for certain events in Minecraft's loading process to happen
 * BaseMod and other files are full of event listeners that load different parts of our mod as Minecraft loads
 * the game.
 * E.g. all custom items are registered when the game registers items through the event
 * All event listeners start with @SubscribeEvent
 */
@Mod.EventBusSubscriber(modid = BaseMod.MODID)
public class WorldMod {

    public static void registerBiomes(final RegistryEvent.Register<Biome> event){
    }

    @SubscribeEvent
    public static void addFeatures(BiomeLoadingEvent event) {

        //variable holding mob spawn information
        MobSpawnSettingsBuilder builder = event.getSpawns();

        //if one of the mob's biomes is loaded in the game
        if (event.getCategory().equals(Biome.BiomeCategory.SWAMP)) {
            //then the mob is added to the spawn list
            //SpawnerData object has 4 parameters, the mob we are spawning, the mobs weight (how likely it is to spawn),
            // the minimum number that appear in a group, and the max number to appear in a group
            // (how many are spawned at a location at a time); game randomly picks a number bw the min and max to spawn
            builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ZomboEntity.TYPE, 100, 2, 4));
        }
    }
}
