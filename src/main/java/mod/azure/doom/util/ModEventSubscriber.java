package mod.azure.doom.util;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ArachnotronEntity;
import mod.azure.doom.entity.ArchvileEntity;
import mod.azure.doom.entity.BaronEntity;
import mod.azure.doom.entity.CacodemonEntity;
import mod.azure.doom.entity.ChaingunnerEntity;
import mod.azure.doom.entity.CueBallEntity;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import mod.azure.doom.entity.CyberdemonEntity;
import mod.azure.doom.entity.GargoyleEntity;
import mod.azure.doom.entity.GoreNestEntity;
import mod.azure.doom.entity.Hellknight2016Entity;
import mod.azure.doom.entity.HellknightEntity;
import mod.azure.doom.entity.IconofsinEntity;
import mod.azure.doom.entity.Imp2016Entity;
import mod.azure.doom.entity.ImpEntity;
import mod.azure.doom.entity.ImpStoneEntity;
import mod.azure.doom.entity.LostSoulEntity;
import mod.azure.doom.entity.MancubusEntity;
import mod.azure.doom.entity.MarauderEntity;
import mod.azure.doom.entity.MechaZombieEntity;
import mod.azure.doom.entity.NightmareImpEntity;
import mod.azure.doom.entity.PainEntity;
import mod.azure.doom.entity.PinkyEntity;
import mod.azure.doom.entity.PossessedScientistEntity;
import mod.azure.doom.entity.PossessedSoldierEntity;
import mod.azure.doom.entity.ProwlerEntity;
import mod.azure.doom.entity.RevenantEntity;
import mod.azure.doom.entity.ShotgunguyEntity;
import mod.azure.doom.entity.SpectreEntity;
import mod.azure.doom.entity.SpiderdemonEntity;
import mod.azure.doom.entity.UnwillingEntity;
import mod.azure.doom.entity.ZombiemanEntity;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = DoomMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(ModEntityTypes.IMP.get(), ModEntityTypes.ARCHVILE.get(),
				ModEntityTypes.LOST_SOUL.get(), ModEntityTypes.BARENBLAST.get(), ModEntityTypes.BARON.get(),
				ModEntityTypes.GORE_NEST.get(), ModEntityTypes.CACODEMON.get(), ModEntityTypes.MANCUBUS.get(),
				ModEntityTypes.ARACHNOTRON.get(), ModEntityTypes.PINKY.get(), ModEntityTypes.CYBERDEMON.get(),
				ModEntityTypes.CYBERDEMON2016.get(), ModEntityTypes.UNWILLING.get(), ModEntityTypes.IMP2016.get(),
				ModEntityTypes.NIGHTMARE_IMP.get(), ModEntityTypes.CHAINGUNNER.get(), ModEntityTypes.SHOTGUNGUY.get(),
				ModEntityTypes.MARAUDER.get(), ModEntityTypes.REVENANT.get(), ModEntityTypes.SPIDERDEMON.get(),
				ModEntityTypes.HELLKNIGHT.get(), ModEntityTypes.ICONOFSIN.get(), ModEntityTypes.POSSESSEDSOLDIER.get(),
				ModEntityTypes.BULLETS.get(), ModEntityTypes.CHAINGUN_BULLET.get(), ModEntityTypes.ENERGY_CELL.get(),
				ModEntityTypes.SHOTGUN_SHELL.get(), ModEntityTypes.ARGENT_BOLT.get(),
				ModEntityTypes.HELLKNIGHT2016.get(), ModEntityTypes.ENERGY_CELL_MOB.get(), ModEntityTypes.FIRING.get(),
				ModEntityTypes.ROCKET_MOB.get(), ModEntityTypes.MECHAZOMBIE.get(), ModEntityTypes.GARGOYLE.get(),
				ModEntityTypes.POSSESSEDSCIENTIST.get(), ModEntityTypes.ZOMBIEMAN.get());
		EntitySpawnPlacementRegistry();
	}

	@SubscribeEvent
	public static void entityAttributes(EntityAttributeCreationEvent event) {
		event.put(ModEntityTypes.CYBERDEMON.get(), CyberdemonEntity.createAttributes().build());
		event.put(ModEntityTypes.ARCHVILE.get(), ArchvileEntity.createAttributes().build());
		event.put(ModEntityTypes.BARON.get(), BaronEntity.createAttributes().build());
		event.put(ModEntityTypes.CHAINGUNNER.get(), ChaingunnerEntity.createAttributes().build());
		event.put(ModEntityTypes.CYBERDEMON2016.get(), Cyberdemon2016Entity.createAttributes().build());
		event.put(ModEntityTypes.HELLKNIGHT.get(), HellknightEntity.createAttributes().build());
		event.put(ModEntityTypes.HELLKNIGHT2016.get(), Hellknight2016Entity.createAttributes().build());
		event.put(ModEntityTypes.ICONOFSIN.get(), IconofsinEntity.createAttributes().build());
		event.put(ModEntityTypes.IMP2016.get(), Imp2016Entity.createAttributes().build());
		event.put(ModEntityTypes.NIGHTMARE_IMP.get(), NightmareImpEntity.createAttributes().build());
		event.put(ModEntityTypes.IMP.get(), ImpEntity.createAttributes().build());
		event.put(ModEntityTypes.MANCUBUS.get(), MancubusEntity.createAttributes().build());
		event.put(ModEntityTypes.MARAUDER.get(), MarauderEntity.createAttributes().build());
		event.put(ModEntityTypes.PINKY.get(), PinkyEntity.createAttributes().build());
		event.put(ModEntityTypes.SPECTRE.get(), SpectreEntity.createAttributes().build());
		event.put(ModEntityTypes.LOST_SOUL.get(), LostSoulEntity.createAttributes().build());
		event.put(ModEntityTypes.POSSESSEDSCIENTIST.get(), PossessedScientistEntity.createAttributes().build());
		event.put(ModEntityTypes.POSSESSEDSOLDIER.get(), PossessedSoldierEntity.createAttributes().build());
		event.put(ModEntityTypes.REVENANT.get(), RevenantEntity.createAttributes().build());
		event.put(ModEntityTypes.SHOTGUNGUY.get(), ShotgunguyEntity.createAttributes().build());
		event.put(ModEntityTypes.ARACHNOTRON.get(), ArachnotronEntity.createAttributes().build());
		event.put(ModEntityTypes.SPIDERDEMON.get(), SpiderdemonEntity.createAttributes().build());
		event.put(ModEntityTypes.UNWILLING.get(), UnwillingEntity.createAttributes().build());
		event.put(ModEntityTypes.ZOMBIEMAN.get(), ZombiemanEntity.createAttributes().build());
		event.put(ModEntityTypes.CACODEMON.get(), CacodemonEntity.createAttributes().build());
		event.put(ModEntityTypes.PAIN.get(), PainEntity.createAttributes().build());
		event.put(ModEntityTypes.GORE_NEST.get(), GoreNestEntity.createAttributes().build());
		event.put(ModEntityTypes.MECHAZOMBIE.get(), MechaZombieEntity.createAttributes().build());
		event.put(ModEntityTypes.GARGOYLE.get(), GargoyleEntity.createAttributes().build());
		event.put(ModEntityTypes.CUEBALL.get(), CueBallEntity.createAttributes().build());
		event.put(ModEntityTypes.PROWLER.get(), ProwlerEntity.createAttributes().build());
		event.put(ModEntityTypes.DREADKNIGHT.get(), Hellknight2016Entity.createAttributes().build());
		event.put(ModEntityTypes.IMP_STONE.get(), ImpStoneEntity.createAttributes().build());
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(DoomMod.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
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
		EntitySpawnPlacementRegistry.register(ModEntityTypes.SPECTRE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SpectreEntity::spawning);
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
				CyberdemonEntity::checkGhastSpawnRules);
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
		EntitySpawnPlacementRegistry.register(ModEntityTypes.CUEBALL.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				CueBallEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.PROWLER.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ProwlerEntity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.DREADKNIGHT.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				Hellknight2016Entity::spawning);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.IMP_STONE.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				ImpStoneEntity::spawning);
	}

}