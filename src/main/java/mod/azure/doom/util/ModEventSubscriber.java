package mod.azure.doom.util;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ArachnotronEntity;
import mod.azure.doom.entity.ArchvileEntity;
import mod.azure.doom.entity.BaronEntity;
import mod.azure.doom.entity.CacodemonEntity;
import mod.azure.doom.entity.ChaingunnerEntity;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import mod.azure.doom.entity.CyberdemonEntity;
import mod.azure.doom.entity.GoreNestEntity;
import mod.azure.doom.entity.HellknightEntity;
import mod.azure.doom.entity.IconofsinEntity;
import mod.azure.doom.entity.Imp2016Entity;
import mod.azure.doom.entity.ImpEntity;
import mod.azure.doom.entity.LostSoulEntity;
import mod.azure.doom.entity.MancubusEntity;
import mod.azure.doom.entity.MarauderEntity;
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
import mod.azure.doom.item.ammo.ArgentBolt;
import mod.azure.doom.item.ammo.BFGCell;
import mod.azure.doom.item.ammo.ChaingunAmmo;
import mod.azure.doom.item.ammo.ClipAmmo;
import mod.azure.doom.item.ammo.EnergyCell;
import mod.azure.doom.item.ammo.Rocket;
import mod.azure.doom.item.ammo.ShellAmmo;
import mod.azure.doom.item.ammo.UnmaykrBolt;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModEntitySpawn;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = DoomMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		@SuppressWarnings("unused")
		final IForgeRegistry<Item> registry = event.getRegistry();
		((ArgentBolt) (DoomItems.ARGENT_BOLT.get())).setItemReference(DoomItems.ARGENT_BOLT);
		((ShellAmmo) (DoomItems.SHOTGUN_SHELLS.get())).setItemReference(DoomItems.SHOTGUN_SHELLS);
		((EnergyCell) (DoomItems.ENERGY_CELLS.get())).setItemReference(DoomItems.ENERGY_CELLS);
		((ChaingunAmmo) (DoomItems.CHAINGUN_BULLETS.get())).setItemReference(DoomItems.CHAINGUN_BULLETS);
		((ClipAmmo) (DoomItems.BULLETS.get())).setItemReference(DoomItems.BULLETS);
		((BFGCell) (DoomItems.BFG_CELL.get())).setItemReference(DoomItems.BFG_CELL);
		((Rocket) (DoomItems.ROCKET.get())).setItemReference(DoomItems.ROCKET);
		((UnmaykrBolt) (DoomItems.UNMAKRY_BOLT.get())).setItemReference(DoomItems.UNMAKRY_BOLT);
	}

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
				ModEntityTypes.ENERGY_CELL_MOB.get(), ModEntityTypes.ROCKET_MOB.get(),
				ModEntityTypes.POSSESSEDSCIENTIST.get(), ModEntityTypes.ZOMBIEMAN.get());
		ModEntitySpawn.addSpawnEntries();
		ModEntitySpawn.EntitySpawnPlacementRegistry();
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void imstuff(final RegistryEvent.Register<EntityType<?>> event) {
		GlobalEntityTypeAttributes.put(ModEntityTypes.CYBERDEMON.get(), CyberdemonEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.ARCHVILE.get(), ArchvileEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.BARON.get(), BaronEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.CHAINGUNNER.get(), ChaingunnerEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.CYBERDEMON2016.get(),
				Cyberdemon2016Entity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.HELLKNIGHT.get(), HellknightEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.ICONOFSIN.get(), IconofsinEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.IMP2016.get(), Imp2016Entity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.NIGHTMARE_IMP.get(),
				NightmareImpEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.IMP.get(), ImpEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.MANCUBUS.get(), MancubusEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.MARAUDER.get(), MarauderEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.PINKY.get(), PinkyEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.LOST_SOUL.get(), LostSoulEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.POSSESSEDSCIENTIST.get(),
				PossessedScientistEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.POSSESSEDSOLDIER.get(),
				PossessedSoldierEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.REVENANT.get(), RevenantEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.SHOTGUNGUY.get(), ShotgunguyEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.ARACHNOTRON.get(), ArachnotronEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.SPIDERDEMON.get(), SpiderdemonEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.UNWILLING.get(), UnwillingEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.ZOMBIEMAN.get(), ZombiemanEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.CACODEMON.get(), CacodemonEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.PAIN.get(), PainEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.GORE_NEST.get(), GoreNestEntity.func_234200_m_().create());
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(DoomMod.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}

}