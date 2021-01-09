package mod.azure.doom;

import mod.azure.doom.client.LockOnHandler;
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
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;
import software.bernie.geckolib3.GeckoLib;
import top.theillusivec4.curios.api.CuriosAPI;
import top.theillusivec4.curios.api.imc.CurioIMCMessage;

@Mod(DoomMod.MODID)
public class DoomMod {

	public static DoomMod instance;
	public static final String MODID = "doomweapon";

	public DoomMod() {
		instance = this;
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::enqueueIMC);
		MinecraftForge.EVENT_BUS.addListener(DoomVillagerTrades::onVillagerTradesEvent);
		modLoadingContext.registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPEC, "doom-config.toml");
		Config.loadConfig(Config.SERVER_SPEC, FMLPaths.CONFIGDIR.get().resolve("doom-config.toml").toString());
		Config.SERVER.bakeConfig();
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new SoulCubeHandler());
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

	private void setup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new LootHandler());
	}

	private void enqueueIMC(InterModEnqueueEvent event) {
		InterModComms.sendTo("curios", CuriosAPI.IMC.REGISTER_TYPE, () -> new CurioIMCMessage("charm"));
		InterModComms.sendTo("curios", CuriosAPI.IMC.REGISTER_TYPE, () -> new CurioIMCMessage("belt"));
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