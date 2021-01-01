package mod.azure.doom;

import mod.azure.doom.client.LockOnHandler;
import mod.azure.doom.client.ModItemModelsProperties;
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
import mod.azure.doom.util.Config;
import mod.azure.doom.util.DoomLeapEntityEvents;
import mod.azure.doom.util.DoomVillagerTrades;
import mod.azure.doom.util.LootHandler;
import mod.azure.doom.util.SoulCubeHandler;
import mod.azure.doom.util.registry.DoomBlocks;
import mod.azure.doom.util.registry.DoomEnchantments;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModEntityTypes;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;
import software.bernie.geckolib3.GeckoLib;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod(DoomMod.MODID)
public class DoomMod {

	public static DoomMod instance;
	public static final String MODID = "doomweapon";

	public DoomMod() {
		instance = this;
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modLoadingContext.registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPEC, "doom-config.toml");
		Config.loadConfig(Config.SERVER_SPEC, FMLPaths.CONFIGDIR.get().resolve("doom-config.toml").toString());
		Config.SERVER.bakeConfig();
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new SoulCubeHandler());
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::clientSetup);
		modEventBus.addListener(this::enqueueIMC);
		MinecraftForge.EVENT_BUS.addListener(DoomVillagerTrades::onVillagerTradesEvent);
		ModSoundEvents.MOD_SOUNDS.register(modEventBus);
		DoomEnchantments.ENCHANTMENTS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		ModEntityTypes.TILE_TYPES.register(modEventBus);
		DoomItems.ITEMS.register(modEventBus);
		DoomBlocks.BLOCKS.register(modEventBus);
		if (!ModList.get().isLoaded("lockon")) {
			if (Config.SERVER.ENABLE_LOCKON) {
				if (FMLEnvironment.dist == Dist.CLIENT)
					modEventBus.addListener(LockOnHandler::client);
			}
		}
		if (!ModList.get().isLoaded("leap")) {
			MinecraftForge.EVENT_BUS.register(new DoomLeapEntityEvents());
		}
		GeckoLib.initialize();
	}

	private void clientSetup(FMLClientSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new ModItemModelsProperties());
	}

	private void setup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new LootHandler());
		event.enqueueWork(() -> {
			GlobalEntityTypeAttributes.put(ModEntityTypes.CYBERDEMON.get(), CyberdemonEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.ARCHVILE.get(), ArchvileEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.BARON.get(), BaronEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.CHAINGUNNER.get(),
					ChaingunnerEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.CYBERDEMON2016.get(),
					Cyberdemon2016Entity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.HELLKNIGHT.get(), HellknightEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.HELLKNIGHT2016.get(),
					Hellknight2016Entity.func_234200_m_().create());
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
			GlobalEntityTypeAttributes.put(ModEntityTypes.ARACHNOTRON.get(),
					ArachnotronEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.SPIDERDEMON.get(),
					SpiderdemonEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.UNWILLING.get(), UnwillingEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.ZOMBIEMAN.get(), ZombiemanEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.CACODEMON.get(), CacodemonEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.PAIN.get(), PainEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.GORE_NEST.get(), GoreNestEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.MECHAZOMBIE.get(),
					MechaZombieEntity.func_234200_m_().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.GARGOYLE.get(), GargoyleEntity.func_234200_m_().create());
		});
	}

	private void enqueueIMC(InterModEnqueueEvent event) {
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
				() -> SlotTypePreset.CHARM.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
				() -> SlotTypePreset.BELT.getMessageBuilder().build());
	}

	public static final ItemGroup DoomWeaponItemGroup = (new ItemGroup("doomweapons") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(DoomItems.CRUCIBLESWORD.get());
		}
	});

	public static final ItemGroup DoomArmorItemGroup = (new ItemGroup("doomarmor") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(DoomItems.DOOM_HELMET.get());
		}
	});

	public static final ItemGroup DoomBlockItemGroup = (new ItemGroup("doomblocks") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(DoomBlocks.BARREL_BLOCK.get());
		}
	});

	public static final ItemGroup DoomEggItemGroup = (new ItemGroup("doomeggs") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(DoomItems.IMP_SPAWN_EGG.get());
		}
	});

	public static final ItemGroup DoomPowerUPItemGroup = (new ItemGroup("doompowerup") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(DoomItems.INMORTAL.get());
		}
	});
}