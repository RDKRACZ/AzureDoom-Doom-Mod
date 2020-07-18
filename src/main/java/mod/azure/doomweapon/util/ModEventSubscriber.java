package mod.azure.doomweapon.util;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.item.ammo.ArgentBolt;
import mod.azure.doomweapon.item.ammo.BFGCell;
import mod.azure.doomweapon.item.ammo.ChaingunAmmo;
import mod.azure.doomweapon.item.ammo.ClipAmmo;
import mod.azure.doomweapon.item.ammo.EnergyCell;
import mod.azure.doomweapon.item.ammo.Rocket;
import mod.azure.doomweapon.item.ammo.ShellAmmo;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModEntitySpawn;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
	}

	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(ModEntityTypes.IMP.get(), ModEntityTypes.ARCHVILE.get(),
				ModEntityTypes.BARON.get(), ModEntityTypes.CACODEMON.get(), ModEntityTypes.LOST_SOUL.get(),
				ModEntityTypes.MANCUBUS.get(), ModEntityTypes.PINKY.get(), ModEntityTypes.CYBERDEMON.get(),
				ModEntityTypes.CYBERDEMON2016.get(), ModEntityTypes.UNWILLING.get(), ModEntityTypes.IMP2016.get(),
				ModEntityTypes.CHAINGUNNER.get(), ModEntityTypes.SHOTGUNGUY.get(), ModEntityTypes.MARAUDER.get(),
				ModEntityTypes.REVENANT.get(), ModEntityTypes.SPIDERDEMON.get(), ModEntityTypes.HELLKNIGHT.get(),
				ModEntityTypes.ICONOFSIN.get(), ModEntityTypes.POSSESSEDSOLDIER.get(), ModEntityTypes.BULLETS.get(),
				ModEntityTypes.CHAINGUN_BULLET.get(), ModEntityTypes.ENERGY_CELL.get(),
				ModEntityTypes.SHOTGUN_SHELL.get(), ModEntityTypes.ARGENT_BOLT.get(),
				ModEntityTypes.POSSESSEDSCIENTIST.get(), ModEntityTypes.ZOMBIEMAN.get());
		ModEntitySpawn.registerEntityWorldSpawns();
		ModEntitySpawn.EntitySpawnPlacementRegistry();
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(DoomMod.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}

	@Mod.EventBusSubscriber(modid = DoomMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
	public static class ItemEvents {
		private static boolean noBreak(ItemStack stack) {
			return stack.isDamageable()
					&& (stack.getDamage() + 1) >= new ItemStack(DoomItems.CRUCIBLESWORD.get()).getMaxDamage()
					|| stack.isDamageable()
							&& (stack.getDamage() + 1) >= new ItemStack(DoomItems.AXE_OPEN.get()).getMaxDamage();
		}

		@SubscribeEvent
		public static void itemAttackEvent(AttackEntityEvent event) {
			if (event.getPlayer().isCreative())
				return;
			ItemStack stack = event.getPlayer().getHeldItemMainhand();
			if (noBreak(stack)) {
				event.setCanceled(true);
			}
		}

		@SubscribeEvent
		public static void itemBlockEvent(PlayerInteractEvent.LeftClickBlock event) {
			if (event.getPlayer().isCreative())
				return;
			ItemStack stack = event.getItemStack();
			if (noBreak(stack)) {
				event.setUseItem(Event.Result.DENY);
			}
		}
	}

}