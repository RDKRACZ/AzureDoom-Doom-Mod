package mod.azure.doomweapon;

import java.util.UUID;

import mod.azure.doomweapon.item.weapons.SuperShotgun;
import mod.azure.doomweapon.util.Config;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
		modEventBus.addListener(this::clientSetup);
		MinecraftForge.EVENT_BUS.register(this);
		ModSoundEvents.MOD_SOUNDS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		DoomItems.ITEMS.register(modEventBus);
	}

	private void clientSetup(FMLClientSetupEvent event) {
		// SuperShotGun
		ItemModelsProperties.func_239418_a_(DoomItems.SSG.get(), new ResourceLocation("pull"),
				(p_239427_0_, p_239427_1_, p_239427_2_) -> {
					if (p_239427_2_ == null) {
						return 0.0F;
					} else {
						return SuperShotgun.isCharged(p_239427_0_) ? 0.0F
								: (float) (p_239427_0_.getUseDuration() - p_239427_2_.getItemInUseCount())
										/ (float) SuperShotgun.getChargeTime(p_239427_0_);
					}
				});
		ItemModelsProperties.func_239418_a_(DoomItems.SSG.get(), new ResourceLocation("pulling"),
				(p_239426_0_, p_239426_1_, p_239426_2_) -> {
					return p_239426_2_ != null && p_239426_2_.isHandActive()
							&& p_239426_2_.getActiveItemStack() == p_239426_0_ && !SuperShotgun.isCharged(p_239426_0_)
									? 1.0F
									: 0.0F;
				});
		ItemModelsProperties.func_239418_a_(DoomItems.SSG.get(), new ResourceLocation("charged"),
				(p_239425_0_, p_239425_1_, p_239425_2_) -> {
					return p_239425_2_ != null && SuperShotgun.isCharged(p_239425_0_) ? 1.0F : 0.0F;
				});
		ItemModelsProperties.func_239418_a_(DoomItems.SSG.get(), new ResourceLocation("firework"),
				(p_239424_0_, p_239424_1_, p_239424_2_) -> {
					return p_239424_2_ != null && SuperShotgun.isCharged(p_239424_0_)
							&& SuperShotgun.hasChargedProjectile(p_239424_0_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
				});
		// ShotGun
		ItemModelsProperties.func_239418_a_(DoomItems.SG.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.func_239418_a_(DoomItems.SG.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});
		// BFG
		ItemModelsProperties.func_239418_a_(DoomItems.BFG.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.func_239418_a_(DoomItems.BFG.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});
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