package mod.azure.doomweapon.util;

import mod.azure.doomweapon.DoomMod;
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

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void imstuff(final RegistryEvent.Register<EntityType<?>> event) {
		GlobalEntityTypeAttributes.put(ModEntityTypes.CYBERDEMON.get(),
				CyberdemonEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.ARCHVILE.get(), ArchvileEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.BARON.get(), BaronEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.CHAINGUNNER.get(),
				ChaingunnerEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.CYBERDEMON2016.get(),
				Cyberdemon2016Entity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.HELLKNIGHT.get(),
				HellknightEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.ICONOFSIN.get(),
				IconofsinEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.IMP2016.get(), Imp2016Entity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.IMP.get(), ImpEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.MANCUBUS.get(), MancubusEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.MARAUDER.get(), MarauderEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.PINKY.get(), PinkyEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.POSSESSEDSCIENTIST.get(),
				PossessedScientistEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.POSSESSEDSOLDIER.get(),
				PossessedSoldierEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.REVENANT.get(), RevenantEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.SHOTGUNGUY.get(),
				ShotgunguyEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.SPIDERDEMON.get(),
				SpiderdemonEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.UNWILLING.get(),
				UnwillingEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.ZOMBIEMAN.get(),
				ZombiemanEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.CACODEMON.get(),
				CacodemonEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.LOST_SOUL.get(),
				LostSoulEntity.func_234200_m_().func_233813_a_());
		GlobalEntityTypeAttributes.put(ModEntityTypes.PAIN.get(), PainEntity.func_234200_m_().func_233813_a_());
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(DoomMod.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}

}