package mod.azure.doomweapon.util;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.item.ammo.ArgentBolt;
import mod.azure.doomweapon.item.ammo.BFGCell;
import mod.azure.doomweapon.item.ammo.ChaingunAmmo;
import mod.azure.doomweapon.item.ammo.ClipAmmo;
import mod.azure.doomweapon.item.ammo.EnergyCell;
import mod.azure.doomweapon.item.ammo.Rocket;
import mod.azure.doomweapon.item.ammo.ShellAmmo;
import mod.azure.doomweapon.item.ammo.UnmaykrBolt;
import mod.azure.doomweapon.util.registry.BYGSpawns;
import mod.azure.doomweapon.util.registry.BoPSpawns;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ExtraModSpawns;
import mod.azure.doomweapon.util.registry.ModEntitySpawn;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.NetherExSpawns;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
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
				ModEntityTypes.BARON.get(), ModEntityTypes.CACODEMON.get(), ModEntityTypes.MANCUBUS.get(),
				ModEntityTypes.PINKY.get(), ModEntityTypes.ARACHNOTRON.get(), ModEntityTypes.CYBERDEMON.get(),
				ModEntityTypes.CYBERDEMON2016.get(), ModEntityTypes.UNWILLING.get(), ModEntityTypes.IMP2016.get(),
				ModEntityTypes.NIGHTMARE_IMP.get(), ModEntityTypes.CHAINGUNNER.get(), ModEntityTypes.SHOTGUNGUY.get(),
				ModEntityTypes.MARAUDER.get(), ModEntityTypes.REVENANT.get(), ModEntityTypes.SPIDERDEMON.get(),
				ModEntityTypes.HELLKNIGHT.get(), ModEntityTypes.ICONOFSIN.get(), ModEntityTypes.POSSESSEDSOLDIER.get(),
				ModEntityTypes.BULLETS.get(), ModEntityTypes.CHAINGUN_BULLET.get(), ModEntityTypes.ENERGY_CELL.get(),
				ModEntityTypes.SHOTGUN_SHELL.get(), ModEntityTypes.ARGENT_BOLT.get(),
				ModEntityTypes.SHOTGUN_SHELL_MOB.get(), ModEntityTypes.BULLETS_MOB.get(),
				ModEntityTypes.CHAINGUN_BULLET_MOB.get(), ModEntityTypes.ENERGY_CELL_MOB.get(),
				ModEntityTypes.ROCKET_MOB.get(), ModEntityTypes.POSSESSEDSCIENTIST.get(),
				ModEntityTypes.ZOMBIEMAN.get(), ModEntityTypes.LOST_SOUL.get(), ModEntityTypes.BARENBLAST.get());
		ModEntitySpawn.registerEntityWorldSpawns();
		ModEntitySpawn.EntitySpawnPlacementRegistry();
		if (ModList.get().isLoaded("extendednether")) {
			ExtraModSpawns.registerEntityModWorldSpawns();
		}
		if (ModList.get().isLoaded("netherex")) {
			NetherExSpawns.registerEntityModWorldSpawns();
		}
		if (ModList.get().isLoaded("biomesoplenty")) {
			BoPSpawns.registerEntityModWorldSpawns();
		}
		if (ModList.get().isLoaded("byg")) {
			BYGSpawns.registerEntityModWorldSpawns();
		}
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(DoomMod.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}

}