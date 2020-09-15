package mod.azure.doomweapon.util.registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableMap;

import mod.azure.doomweapon.entity.ArachnotronEntity;
import mod.azure.doomweapon.entity.ArchvileEntity;
import mod.azure.doomweapon.entity.BaronEntity;
import mod.azure.doomweapon.entity.CacodemonEntity;
import mod.azure.doomweapon.entity.ChaingunnerEntity;
import mod.azure.doomweapon.entity.Cyberdemon2016Entity;
import mod.azure.doomweapon.entity.CyberdemonEntity;
import mod.azure.doomweapon.entity.HellknightEntity;
import mod.azure.doomweapon.entity.IconofsinEntity;
import mod.azure.doomweapon.entity.Imp2016Entity;
import mod.azure.doomweapon.entity.ImpEntity;
import mod.azure.doomweapon.entity.MancubusEntity;
import mod.azure.doomweapon.entity.MarauderEntity;
import mod.azure.doomweapon.entity.NightmareImpEntity;
import mod.azure.doomweapon.entity.PainEntity;
import mod.azure.doomweapon.entity.PinkyEntity;
import mod.azure.doomweapon.entity.PossessedScientistEntity;
import mod.azure.doomweapon.entity.PossessedSoldierEntity;
import mod.azure.doomweapon.entity.RevenantEntity;
import mod.azure.doomweapon.entity.ShotgunguyEntity;
import mod.azure.doomweapon.entity.SpiderdemonEntity;
import mod.azure.doomweapon.entity.UnwillingEntity;
import mod.azure.doomweapon.entity.ZombiemanEntity;
import mod.azure.doomweapon.entity.projectiles.LostSoulEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;

public class ModEntitySpawn {

	/* Major fucking thanks to Corgi Taco for figuring this shit out */
	@SuppressWarnings("deprecation")
	public static void addSpawnEntries() {
		for (Biome biome : WorldGenRegistries.field_243657_i) {
			if (biome.getCategory().equals(Biome.Category.NETHER)) {
				addMobSpawnToBiome(biome, EntityClassification.MONSTER,
						new MobSpawnInfo.Spawners(ModEntityTypes.IMP.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.PINKY.get(), 12, 2, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.LOST_SOUL.get(), 12, 2, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.LOST_SOUL.get(), 12, 2, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.CACODEMON.get(), 8, 1, 2),
						new MobSpawnInfo.Spawners(ModEntityTypes.ARCHVILE.get(), 4, 1, 2),
						new MobSpawnInfo.Spawners(ModEntityTypes.BARON.get(), 10, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.MANCUBUS.get(), 10, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.REVENANT.get(), 10, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.SPIDERDEMON.get(), 10, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.ZOMBIEMAN.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.NIGHTMARE_IMP.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.IMP2016.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.ARACHNOTRON.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.CHAINGUNNER.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.SHOTGUNGUY.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.MARAUDER.get(), 15, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.PAIN.get(), 8, 1, 2),
						new MobSpawnInfo.Spawners(ModEntityTypes.HELLKNIGHT.get(), 10, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.CYBERDEMON.get(), 10, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.UNWILLING.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.POSSESSEDSCIENTIST.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.POSSESSEDSOLDIER.get(), 30, 1, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.CYBERDEMON2016.get(), 10, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.ICONOFSIN.get(), 1, 1, 1));
			}
		}
	}

	public static void addMobSpawnToBiome(Biome biome, EntityClassification classification,
			MobSpawnInfo.Spawners... spawnInfos) {
		convertImmutableSpawners(biome);
		List<MobSpawnInfo.Spawners> spawnersList = new ArrayList<>(
				biome.func_242433_b().field_242554_e.get(classification));
		spawnersList.addAll(Arrays.asList(spawnInfos));
		biome.func_242433_b().field_242554_e.put(classification, spawnersList);
	}

	private static void convertImmutableSpawners(Biome biome) {
		if (biome.func_242433_b().field_242554_e instanceof ImmutableMap) {
			biome.func_242433_b().field_242554_e = new HashMap<>(biome.func_242433_b().field_242554_e);
		}
	}

	public static void EntitySpawnPlacementRegistry() {
		EntitySpawnPlacementRegistry.register(ModEntityTypes.ARCHVILE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ArchvileEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.LOST_SOUL.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				LostSoulEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.ZOMBIEMAN.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ZombiemanEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.SPIDERDEMON.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SpiderdemonEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.ARACHNOTRON.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ArachnotronEntity::spawning);
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
		EntitySpawnPlacementRegistry.register(ModEntityTypes.CACODEMON.get(),
				EntitySpawnPlacementRegistry.PlacementType.IN_LAVA, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
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
				EntitySpawnPlacementRegistry.PlacementType.IN_LAVA, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				PainEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.HELLKNIGHT.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				HellknightEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.CYBERDEMON.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				CyberdemonEntity::func_223368_b);
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
		EntitySpawnPlacementRegistry.register(ModEntityTypes.ICONOFSIN.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				IconofsinEntity::spawning);
	}
}