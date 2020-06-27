package mod.azure.doomweapon;

import java.util.UUID;

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
import mod.azure.doomweapon.util.Config;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(DoomMod.MODID)
public class DoomMod {

	public static DoomMod instance;
	public static final String MODID = "doomweapon";

	public DoomMod() {
		instance = this;
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, Config.SERVER_SPEC, "doomweapon-config.toml");
		Config.loadConfig(Config.SERVER_SPEC, FMLPaths.CONFIGDIR.get().resolve("doomweapon-config.toml").toString());
		MinecraftForge.EVENT_BUS.register(this);
		ModSoundEvents.MOD_SOUNDS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		DoomItems.ITEMS.register(modEventBus);
	}

	public static final ItemGroup DoomItemGroup = (new ItemGroup("doomweapon") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(DoomItems.ICON.get());
		}

		public boolean hasSearchBar() {
			return true;
		}
	}).setBackgroundImageName("item_search.png");

	@SubscribeEvent
	public static void entityJoin(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof PlayerEntity && UUID.fromString("fbcf9922-df24-49bb-8f0f-d2ec6f5a3232")
				.equals(((PlayerEntity) event.getEntity()).getUniqueID())) {
			// Please Note This is a joke and does nothing. It was a joke about landmaster
			// and would only affect myself.
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent(priority = EventPriority.LOWEST)
		public static void imstuff(final RegistryEvent.Register<EntityType<?>> event) {
			GlobalEntityTypeAttributes.put(ModEntityTypes.CYBERDEMON.get(),
					CyberdemonEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.ARCHVILE.get(),
					ArchvileEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.BARON.get(), BaronEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.CHAINGUNNER.get(),
					ChaingunnerEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.CYBERDEMON2016.get(),
					Cyberdemon2016Entity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.HELLKNIGHT.get(),
					HellknightEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.ICONOFSIN.get(),
					IconofsinEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.IMP2016.get(),
					Imp2016Entity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.IMP.get(), ImpEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.MANCUBUS.get(),
					MancubusEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.MARAUDER.get(),
					MarauderEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.PINKY.get(), PinkyEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.POSSESSEDSCIENTIST.get(),
					PossessedScientistEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.POSSESSEDSOLDIER.get(),
					PossessedSoldierEntity.func_234200_m_().func_233813_a_());
			GlobalEntityTypeAttributes.put(ModEntityTypes.REVENANT.get(),
					RevenantEntity.func_234200_m_().func_233813_a_());
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
	}
}