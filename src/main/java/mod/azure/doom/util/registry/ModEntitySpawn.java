package mod.azure.doom.util.registry;

import mod.azure.doom.entity.ArachnotronEntity;
import mod.azure.doom.entity.ArchvileEntity;
import mod.azure.doom.entity.BaronEntity;
import mod.azure.doom.entity.CacodemonEntity;
import mod.azure.doom.entity.ChaingunnerEntity;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import mod.azure.doom.entity.CyberdemonEntity;
import mod.azure.doom.entity.GargoyleEntity;
import mod.azure.doom.entity.GoreNestEntity;
import mod.azure.doom.entity.Hellknight2016Entity;
import mod.azure.doom.entity.HellknightEntity;
import mod.azure.doom.entity.Imp2016Entity;
import mod.azure.doom.entity.ImpEntity;
import mod.azure.doom.entity.MancubusEntity;
import mod.azure.doom.entity.MarauderEntity;
import mod.azure.doom.entity.MechaZombieEntity;
import mod.azure.doom.entity.NightmareImpEntity;
import mod.azure.doom.entity.PainEntity;
import mod.azure.doom.entity.PinkyEntity;
import mod.azure.doom.entity.PossessedScientistEntity;
import mod.azure.doom.entity.PossessedSoldierEntity;
import mod.azure.doom.entity.RevenantEntity;
import mod.azure.doom.entity.ShotgunguyEntity;
import mod.azure.doom.entity.SpectreEntity;
import mod.azure.doom.entity.SpiderdemonEntity;
import mod.azure.doom.entity.UnwillingEntity;
import mod.azure.doom.entity.ZombiemanEntity;
import mod.azure.doom.util.Config;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;

public class ModEntitySpawn {

	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(ModEntityTypes.IMP.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.PINKY.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 2, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.SPECTRE.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 2, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.CACODEMON.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 2,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.ARCHVILE.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 2,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.BARON.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.MANCUBUS.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.REVENANT.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.SPIDERDEMON.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.ZOMBIEMAN.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.IMP2016.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.ARACHNOTRON.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.NIGHTMARE_IMP.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.GARGOYLE.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.CHAINGUNNER.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.SHOTGUNGUY.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.MARAUDER.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.PAIN.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 2,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.HELLKNIGHT.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.HELLKNIGHT2016.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.UNWILLING.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSCIENTIST.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSOLDIER.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON2016.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.GORE_NEST.get(), Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT, 1, 1,
				Biomes.NETHER);
		registerEntityWorldSpawn(ModEntityTypes.MECHAZOMBIE.get(), Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT, 1, 4,
				Biomes.NETHER);
	}

	public static void EntitySpawnPlacementRegistry() {
		EntitySpawnPlacementRegistry.register(ModEntityTypes.ARCHVILE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ArchvileEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.ARACHNOTRON.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ArachnotronEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.ZOMBIEMAN.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ZombiemanEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.SPIDERDEMON.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SpiderdemonEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.MANCUBUS.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MancubusEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.BARON.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				BaronEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.REVENANT.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				RevenantEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.IMP.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ImpEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.NIGHTMARE_IMP.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				NightmareImpEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.PINKY.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				PinkyEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.SPECTRE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SpectreEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.CACODEMON.get(),
				EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				CacodemonEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.IMP2016.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				Imp2016Entity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.CHAINGUNNER.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ChaingunnerEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.MARAUDER.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MarauderEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.SHOTGUNGUY.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ShotgunguyEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.PAIN.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				PainEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.HELLKNIGHT.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				HellknightEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.HELLKNIGHT2016.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				Hellknight2016Entity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.CYBERDEMON.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				CyberdemonEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.CYBERDEMON2016.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				Cyberdemon2016Entity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.UNWILLING.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				UnwillingEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.POSSESSEDSCIENTIST.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				PossessedScientistEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.POSSESSEDSOLDIER.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				PossessedSoldierEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.GORE_NEST.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				GoreNestEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.MECHAZOMBIE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MechaZombieEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.GARGOYLE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				GargoyleEntity::spawning);
	}

	public static void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minGroup, int maxGroup,
			Biome... biomes) {
		for (Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, weight, minGroup, maxGroup));
			}
		}
	}
}