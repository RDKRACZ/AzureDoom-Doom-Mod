package mod.azure.doomweapon;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mod.azure.doomweapon.client.ModItemModelsProperties;
import mod.azure.doomweapon.util.LootHandler;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurio;

@Mod(DoomMod.MODID)
public class DoomMod {

	public static DoomMod instance;
	public static final String MODID = "doomweapon";

	public DoomMod() {
		instance = this;
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::clientSetup);
		modEventBus.addListener(this::enqueueIMC);
		ModSoundEvents.MOD_SOUNDS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		DoomItems.ITEMS.register(modEventBus);
	}

	private void clientSetup(FMLClientSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new ModItemModelsProperties());
	}

	private void setup(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new LootHandler());
	}

	private void enqueueIMC(InterModEnqueueEvent event) {
		InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
				() -> SlotTypePreset.CHARM.getMessageBuilder().build());
	}

	public static final ItemGroup DoomItemGroup = (new ItemGroup("doomweapon") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(DoomItems.CRUCIBLESWORD.get());
		}

		public boolean hasSearchBar() {
			return true;
		}
	}).setBackgroundImageName("item_search.png");

	@SubscribeEvent
	public void attachCapabilities(AttachCapabilitiesEvent<ItemStack> evt) {
		if (evt.getObject().getItem() != DoomItems.SOULCUBE.get()) {
			return;
		}
		ICurio curio = new ICurio() {

			@Override
			public boolean canRightClickEquip() {
				return true;
			}
		};

		ICapabilityProvider provider = new ICapabilityProvider() {
			private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);

			@Nonnull
			@Override
			public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
				return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
			}
		};
		evt.addCapability(CuriosCapability.ID_ITEM, provider);
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onLivingDeath(LivingDeathEvent evt) {
		if (soulCube(evt.getEntityLiving(), evt.getSource())) {
			evt.setCanceled(true);
		}
	}

	private boolean soulCube(LivingEntity livingEntity, DamageSource source) {
		if (source.canHarmInCreative()) {
			return false;
		}
		for (ItemStack held : livingEntity.getHeldEquipment()) {
			if (held.getItem() == DoomItems.SOULCUBE.get()) {
				return false;
			}
		}
		return CuriosApi.getCuriosHelper().findEquippedCurio(DoomItems.SOULCUBE.get(), livingEntity).map(soulcube -> {
			this.activateSoulCube(livingEntity, soulcube.getRight());
			return true;
		}).orElse(false);
	}

	private void activateSoulCube(LivingEntity livingEntity, ItemStack soulcube) {
		ItemStack copy = soulcube.copy();
		soulcube.damageItem(1, livingEntity, (entity) -> {
			entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		});

		if (livingEntity instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livingEntity;
			serverPlayer.addStat(Stats.ITEM_USED.get(DoomItems.SOULCUBE.get()));
			CriteriaTriggers.USED_TOTEM.trigger(serverPlayer, copy);
		}
		livingEntity.setHealth(20.0F);
		livingEntity.world.setEntityState(livingEntity, (byte) 35);
	}
}