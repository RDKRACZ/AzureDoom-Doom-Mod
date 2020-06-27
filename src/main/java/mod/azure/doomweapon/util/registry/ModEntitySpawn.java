package mod.azure.doomweapon.util.registry;

import mod.azure.doomweapon.entity.ArchvileEntity;
import mod.azure.doomweapon.entity.BaronEntity;
import mod.azure.doomweapon.entity.CacodemonEntity;
import mod.azure.doomweapon.entity.ChaingunnerEntity;
import mod.azure.doomweapon.entity.Cyberdemon2016Entity;
import mod.azure.doomweapon.entity.CyberdemonEntity;
import mod.azure.doomweapon.entity.HellknightEntity;
import mod.azure.doomweapon.entity.Imp2016Entity;
import mod.azure.doomweapon.entity.ImpEntity;
import mod.azure.doomweapon.entity.LostSoulEntity;
import mod.azure.doomweapon.entity.MancubusEntity;
import mod.azure.doomweapon.entity.MarauderEntity;
import mod.azure.doomweapon.entity.PainEntity;
import mod.azure.doomweapon.entity.PinkyEntity;
import mod.azure.doomweapon.entity.PossessedScientistEntity;
import mod.azure.doomweapon.entity.PossessedSoldierEntity;
import mod.azure.doomweapon.entity.RevenantEntity;
import mod.azure.doomweapon.entity.ShotgunguyEntity;
import mod.azure.doomweapon.entity.SpiderdemonEntity;
import mod.azure.doomweapon.entity.UnwillingEntity;
import mod.azure.doomweapon.entity.ZombiemanEntity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;

public class ModEntitySpawn {

	public static void registerEntityWorldSpawns() {
		registerEntityWorldSpawn(ModEntityTypes.IMP.get(), 12, 2, 7, Biomes.field_235250_aA_, Biomes.field_235251_aB_,
				Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.PINKY.get(), 12, 2, 4, Biomes.field_235250_aA_, Biomes.field_235251_aB_,
				Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.LOST_SOUL.get(), 8, 1, 3, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.CACODEMON.get(), 8, 1, 2, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.ARCHVILE.get(), 4, 1, 2, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.BARON.get(), 2, 1, 1, Biomes.field_235250_aA_, Biomes.field_235251_aB_,
				Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.MANCUBUS.get(), 2, 1, 1, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.REVENANT.get(), 2, 1, 1, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.SPIDERDEMON.get(), 2, 1, 1, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.ZOMBIEMAN.get(), 12, 2, 7, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.IMP2016.get(), 12, 2, 7, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.CHAINGUNNER.get(), 12, 2, 7, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.SHOTGUNGUY.get(), 12, 2, 7, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.MARAUDER.get(), 1, 1, 1, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.PAIN.get(), 8, 1, 2, Biomes.field_235250_aA_, Biomes.field_235251_aB_,
				Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.HELLKNIGHT.get(), 2, 1, 1, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON.get(), 2, 1, 1, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.UNWILLING.get(), 12, 2, 7, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSCIENTIST.get(), 12, 2, 7, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSOLDIER.get(), 12, 2, 7, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON2016.get(), 2, 1, 1, Biomes.field_235250_aA_,
				Biomes.field_235251_aB_, Biomes.field_235253_az_, Biomes.field_235252_ay_);
	}

	public static void EntitySpawnPlacementRegistry() {
		EntitySpawnPlacementRegistry.register(ModEntityTypes.ARCHVILE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ArchvileEntity::spawning);
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
		EntitySpawnPlacementRegistry.register(ModEntityTypes.PINKY.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				PinkyEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.CACODEMON.get(),
				EntitySpawnPlacementRegistry.PlacementType.IN_LAVA, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				CacodemonEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.LOST_SOUL.get(),
				EntitySpawnPlacementRegistry.PlacementType.IN_LAVA, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				LostSoulEntity::spawning);
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