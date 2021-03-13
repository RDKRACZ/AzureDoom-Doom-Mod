package mod.azure.doom;

import java.util.HashMap;
import java.util.Map;

import mod.azure.doom.client.LockOnHandler;
import mod.azure.doom.client.ModItemModelsProperties;
import mod.azure.doom.structures.DoomConfiguredStructures;
import mod.azure.doom.structures.DoomStructures;
import mod.azure.doom.util.DoomLeapEntityEvents;
import mod.azure.doom.util.DoomVillagerTrades;
import mod.azure.doom.util.LootHandler;
import mod.azure.doom.util.SoulCubeHandler;
import mod.azure.doom.util.config.BiomeConfig;
import mod.azure.doom.util.config.Config;
import mod.azure.doom.util.packets.DoomPacketHandler;
import mod.azure.doom.util.registry.DoomBlocks;
import mod.azure.doom.util.registry.DoomEnchantments;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModEntitySpawn;
import mod.azure.doom.util.registry.ModEntityTypes;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onModConfigEvent);
		modLoadingContext.registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPEC, "doom-config.toml");
		modLoadingContext.registerConfig(ModConfig.Type.SERVER, Config.BIOME_SPEC, "doom-mob-biomes.toml");
		Config.loadConfig(Config.SERVER_SPEC, FMLPaths.CONFIGDIR.get().resolve("doom-config.toml").toString());
		Config.SERVER.bakeConfig();
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new SoulCubeHandler());
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::clientSetup);
		modEventBus.addListener(this::enqueueIMC);
		if (!FMLEnvironment.production) {
			DoomStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
			forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
			forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
		}
		MinecraftForge.EVENT_BUS.addListener(DoomVillagerTrades::onVillagerTradesEvent);
		ModSoundEvents.MOD_SOUNDS.register(modEventBus);
		DoomEnchantments.ENCHANTMENTS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		ModEntityTypes.TILE_TYPES.register(modEventBus);
		DoomItems.ITEMS.register(modEventBus);
		DoomBlocks.BLOCKS.register(modEventBus);
		MinecraftForge.EVENT_BUS.addListener(this::onBiomeLoad);
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

	@SubscribeEvent
	public void onModConfigEvent(final ModConfig.ModConfigEvent event) {
		final ModConfig config = event.getConfig();
		if (config.getSpec() == Config.BIOME_SPEC) {
			BiomeConfig.bake(config);
		}
	}

	@SubscribeEvent
	public void onBiomeLoad(BiomeLoadingEvent event) {
		ModEntitySpawn.onBiomesLoad(event);
	}

	private void clientSetup(FMLClientSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new ModItemModelsProperties());
	}

	private void setup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new LootHandler());
		DoomPacketHandler.register();
		event.enqueueWork(() -> {
			DoomStructures.setupStructures();
			DoomConfiguredStructures.registerConfiguredStructures();
		});
	}

	public void biomeModification(final BiomeLoadingEvent event) {
		event.getGeneration().getStructures().add(() -> DoomConfiguredStructures.CONFIGURED_DOOM1);
	}

	public void addDimensionalSpacing(final WorldEvent.Load event) {
		if (event.getWorld() instanceof ServerWorld) {
			ServerWorld serverWorld = (ServerWorld) event.getWorld();
			if (serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator
					&& serverWorld.dimension().equals(World.OVERWORLD)) {
				return;
			}

			Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(
					serverWorld.getChunkSource().generator.getSettings().structureConfig());
			tempMap.putIfAbsent(DoomStructures.DOOM1.get(),
					DimensionStructuresSettings.DEFAULTS.get(DoomStructures.DOOM1.get()));
			serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
		}
	}

	private void enqueueIMC(InterModEnqueueEvent event) {
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
				() -> SlotTypePreset.CHARM.getMessageBuilder().build());
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
				() -> SlotTypePreset.BELT.getMessageBuilder().build());
	}

	public static final ItemGroup DoomWeaponItemGroup = (new ItemGroup("doomweapons") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DoomItems.CRUCIBLESWORD.get());
		}
	});

	public static final ItemGroup DoomArmorItemGroup = (new ItemGroup("doomarmor") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DoomItems.DOOM_HELMET.get());
		}
	});

	public static final ItemGroup DoomBlockItemGroup = (new ItemGroup("doomblocks") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DoomBlocks.BARREL_BLOCK.get());
		}
	});

	public static final ItemGroup DoomEggItemGroup = (new ItemGroup("doomeggs") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DoomItems.IMP_SPAWN_EGG.get());
		}
	});

	public static final ItemGroup DoomPowerUPItemGroup = (new ItemGroup("doompowerup") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DoomItems.INMORTAL.get());
		}
	});
}