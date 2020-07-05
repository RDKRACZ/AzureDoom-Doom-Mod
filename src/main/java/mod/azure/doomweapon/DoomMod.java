package mod.azure.doomweapon;

import java.util.UUID;

import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DoomMod.MODID)
public class DoomMod {

	public static DoomMod instance;
	public static final String MODID = "doomweapon";

	public DoomMod() {
		instance = this;
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		ModSoundEvents.MOD_SOUNDS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		DoomItems.ITEMS.register(modEventBus);
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
	public static void entityJoin(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof PlayerEntity && UUID.fromString("fbcf9922-df24-49bb-8f0f-d2ec6f5a3232")
				.equals(((PlayerEntity) event.getEntity()).getUniqueID())) {
			// Please Note This is a joke and does nothing. It was a joke about landmaster
			// and would only affect myself.
		}
	}

	@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
	public static class ClientEvents {
		private static boolean isAboutToBreak(ItemStack stack) {
			return stack.isDamageable() && (stack.getDamage() + 1) >= stack.getMaxDamage();
		}

		public static int adjustedDurability(ItemStack stack, int remaining) {
			int unbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, stack);

			double chance = 1.0 / (unbreaking + 1);
			if (stack.getItem() instanceof ArmorItem) {
				chance *= 0.4;
			}

			double durability_coef = 1 / chance;

			return MathHelper.floor(remaining * durability_coef);
		}

		@SubscribeEvent
		public static void itemInteractEvent(AttackEntityEvent event) {
			if (event.getPlayer().isCreative())
				return;
			ItemStack stack = event.getPlayer().getHeldItemMainhand();
			if (isAboutToBreak(stack)) {
				event.setCanceled(true);
			}
		}

		@SubscribeEvent
		public static void itemInteractEvent(PlayerInteractEvent.LeftClickBlock event) {
			if (event.getPlayer().isCreative())
				return;
			ItemStack stack = event.getItemStack();
			if (isAboutToBreak(stack)) {
				event.setUseItem(Event.Result.DENY);
			}
		}
	}
}