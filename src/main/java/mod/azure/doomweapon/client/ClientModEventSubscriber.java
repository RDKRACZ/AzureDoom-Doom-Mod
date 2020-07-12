package mod.azure.doomweapon.client;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.render.ArchvileRender;
import mod.azure.doomweapon.client.render.BaronRender;
import mod.azure.doomweapon.client.render.CacodemonRender;
import mod.azure.doomweapon.client.render.ChaingunnerRender;
import mod.azure.doomweapon.client.render.Cyberdemon2016Render;
import mod.azure.doomweapon.client.render.CyberdemonRender;
import mod.azure.doomweapon.client.render.HellknightRender;
import mod.azure.doomweapon.client.render.IconofsinRender;
import mod.azure.doomweapon.client.render.Imp2016Render;
import mod.azure.doomweapon.client.render.ImpRender;
import mod.azure.doomweapon.client.render.LostSoulRender;
import mod.azure.doomweapon.client.render.MancubusRender;
import mod.azure.doomweapon.client.render.MarauderRender;
import mod.azure.doomweapon.client.render.PainRender;
import mod.azure.doomweapon.client.render.PinkyRender;
import mod.azure.doomweapon.client.render.PossessedScientistRender;
import mod.azure.doomweapon.client.render.PossessedSoldierRender;
import mod.azure.doomweapon.client.render.RevenantRender;
import mod.azure.doomweapon.client.render.ShotgunguyRender;
import mod.azure.doomweapon.client.render.SpiderdemonRender;
import mod.azure.doomweapon.client.render.UnwillingRender;
import mod.azure.doomweapon.client.render.ZombiemanRender;
import mod.azure.doomweapon.client.render.projectiles.ArgentBoltRender;
import mod.azure.doomweapon.client.render.projectiles.BFGCellRender;
import mod.azure.doomweapon.client.render.projectiles.BulletsRender;
import mod.azure.doomweapon.client.render.projectiles.ChaingunBulletRender;
import mod.azure.doomweapon.client.render.projectiles.EnergyCellRender;
import mod.azure.doomweapon.client.render.projectiles.RocketRender;
import mod.azure.doomweapon.client.render.projectiles.ShotgunShellRender;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = DoomMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SHOTGUN_SHELL.get(), ShotgunShellRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARGENT_BOLT.get(), ArgentBoltRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENERGY_CELL.get(), EnergyCellRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BULLETS.get(), BulletsRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BFG_CELL.get(), BFGCellRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ROCKET.get(), RocketRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHAINGUN_BULLET.get(),
				ChaingunBulletRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.IMP.get(), ImpRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PINKY.get(), PinkyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LOST_SOUL.get(), LostSoulRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CACODEMON.get(), CacodemonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARCHVILE.get(), ArchvileRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BARON.get(), BaronRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MANCUBUS.get(), MancubusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SPIDERDEMON.get(), SpiderdemonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ZOMBIEMAN.get(), ZombiemanRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.REVENANT.get(), RevenantRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.IMP2016.get(), Imp2016Render::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHAINGUNNER.get(), ChaingunnerRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SHOTGUNGUY.get(), ShotgunguyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MARAUDER.get(), MarauderRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PAIN.get(), PainRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HELLKNIGHT.get(), HellknightRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CYBERDEMON.get(), CyberdemonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNWILLING.get(), UnwillingRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CYBERDEMON2016.get(),
				Cyberdemon2016Render::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ICONOFSIN.get(), IconofsinRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.POSSESSEDSCIENTIST.get(),
				PossessedScientistRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.POSSESSEDSOLDIER.get(),
				PossessedSoldierRender::new);
	}

	@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = DoomMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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