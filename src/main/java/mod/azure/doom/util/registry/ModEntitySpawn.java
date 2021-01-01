package mod.azure.doom.util.registry;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ArachnotronEntity;
import mod.azure.doom.entity.ArchvileEntity;
import mod.azure.doom.entity.BaronEntity;
import mod.azure.doom.entity.CacodemonEntity;
import mod.azure.doom.entity.ChaingunnerEntity;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import mod.azure.doom.entity.CyberdemonEntity;
import mod.azure.doom.entity.DemonEntity;
import mod.azure.doom.entity.GargoyleEntity;
import mod.azure.doom.entity.GoreNestEntity;
import mod.azure.doom.entity.Hellknight2016Entity;
import mod.azure.doom.entity.HellknightEntity;
import mod.azure.doom.entity.IconofsinEntity;
import mod.azure.doom.entity.Imp2016Entity;
import mod.azure.doom.entity.ImpEntity;
import mod.azure.doom.entity.LostSoulEntity;
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
import mod.azure.doom.entity.SpiderdemonEntity;
import mod.azure.doom.entity.UnwillingEntity;
import mod.azure.doom.entity.ZombiemanEntity;
import mod.azure.doom.util.BiomeEvaluator;
import mod.azure.doom.util.Config;
import mod.azure.doom.util.EntityConfig;
import mod.azure.doom.util.EntityDefaults.EntityConfigType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = DoomMod.MODID)
public class ModEntitySpawn {

	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		if (event.getName() == null)
			return;
		Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
		RegistryKey<Biome> biomeKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, biome.getRegistryName());
		List<String> biomeTypes = BiomeDictionary.getTypes(biomeKey).stream()
				.map(t -> t.toString().toLowerCase(Locale.ROOT)).collect(Collectors.toList());
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.ARACHNOTRON.get(), EntityConfigType.ARACHNOTRON);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.ARCHVILE.get(), EntityConfigType.ARCHVILE);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER, ModEntityTypes.BARON.get(),
				EntityConfigType.BARON);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.CACODEMON.get(), EntityConfigType.CACODEMON);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.CHAINGUNNER.get(), EntityConfigType.CHAINGUNNER);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.CYBERDEMON2016.get(), EntityConfigType.CYBER_DEMON_2016);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.CYBERDEMON.get(), EntityConfigType.CYBER_DEMON);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.GARGOYLE.get(), EntityConfigType.GARGOYLE);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.GORE_NEST.get(), EntityConfigType.GORE_NEST);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.HELLKNIGHT2016.get(), EntityConfigType.HELL_KNIGHT_2016);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.HELLKNIGHT.get(), EntityConfigType.HELL_KNIGHT);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.ICONOFSIN.get(), EntityConfigType.ICON_OF_SIN);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.IMP2016.get(), EntityConfigType.IMP_2016);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER, ModEntityTypes.IMP.get(),
				EntityConfigType.IMP);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.LOST_SOUL.get(), EntityConfigType.LOST_SOUL);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.MANCUBUS.get(), EntityConfigType.MANCUBUS);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.MARAUDER.get(), EntityConfigType.MARAUDER);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.MECHAZOMBIE.get(), EntityConfigType.MECHA_ZOMBIE);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.NIGHTMARE_IMP.get(), EntityConfigType.NIGHTMARE_IMP);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER, ModEntityTypes.PAIN.get(),
				EntityConfigType.PAIN);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER, ModEntityTypes.PINKY.get(),
				EntityConfigType.PINKY);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.POSSESSEDSCIENTIST.get(), EntityConfigType.POSSESSED_SCIENTIST);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.POSSESSEDSOLDIER.get(), EntityConfigType.POSSESSED_SOLDIER);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.REVENANT.get(), EntityConfigType.REVENANT);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.SHOTGUNGUY.get(), EntityConfigType.SHOTGUN_GUY);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.SPIDERDEMON.get(), EntityConfigType.SPIDER_DEMON);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.UNWILLING.get(), EntityConfigType.UNWILLING);
		attemptRegisterEntityInBiome(event, biome, biomeTypes, EntityClassification.MONSTER,
				ModEntityTypes.ZOMBIEMAN.get(), EntityConfigType.ZOMBIEMAN);
	}

	public static void attemptRegisterEntityInBiome(BiomeLoadingEvent event, Biome biome, List<String> biomeTypes,
			EntityClassification entityClassification, EntityType<? extends DemonEntity> entity,
			EntityConfigType entityType) {
		if (Config.SERVER.USE_INDIVIDUAL_SPAWN_RULES) {
			EntityConfig config = Config.SERVER.entityConfig.get(entityType);
			if (config != null && config.SPAWN_WEIGHT > 0 && BiomeEvaluator.isValidBiome(biome, biomeTypes, config))
				event.getSpawns().getSpawner(entityClassification)
						.add(new Spawners(entity, config.SPAWN_WEIGHT, config.MIN_GROUP, config.MAX_GROUP));
		} else {
			if ((entityType.getDefaultAttributes().isHeavy() ? Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT
					: Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT) > 0
					&& BiomeEvaluator.isValidBiomeAsGroup(biome, biomeTypes))
				event.getSpawns().getSpawner(entityClassification)
						.add(new Spawners(entity,
								entityType.getDefaultAttributes().isHeavy()
										? entityType == EntityConfigType.ICON_OF_SIN ? 0
												: Config.SERVER.HEAVY_DEMON_SPAWN_WEIGHT
										: Config.SERVER.COMMON_DEMON_SPAWN_WEIGHT,
								1, entityType.getDefaultAttributes().getDefaultMaxRoll()));
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
		EntitySpawnPlacementRegistry.register(ModEntityTypes.HELLKNIGHT2016.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				Hellknight2016Entity::spawning);
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
}