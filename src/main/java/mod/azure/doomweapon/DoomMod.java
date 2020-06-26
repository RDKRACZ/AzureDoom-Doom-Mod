package mod.azure.doomweapon;

import java.util.UUID;

import mod.azure.doomweapon.util.Config;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
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
}