package mod.azure.doom.client;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.render.ArachnotronRender;
import mod.azure.doom.client.render.ArchvileRender;
import mod.azure.doom.client.render.BaronRender;
import mod.azure.doom.client.render.BarrelRender;
import mod.azure.doom.client.render.CacodemonRender;
import mod.azure.doom.client.render.ChaingunnerRender;
import mod.azure.doom.client.render.Cyberdemon2016Render;
import mod.azure.doom.client.render.CyberdemonRender;
import mod.azure.doom.client.render.HellknightRender;
import mod.azure.doom.client.render.IconofsinRender;
import mod.azure.doom.client.render.Imp2016Render;
import mod.azure.doom.client.render.ImpRender;
import mod.azure.doom.client.render.MancubusRender;
import mod.azure.doom.client.render.MarauderRender;
import mod.azure.doom.client.render.NightmareImpRender;
import mod.azure.doom.client.render.PainRender;
import mod.azure.doom.client.render.PinkyRender;
import mod.azure.doom.client.render.PossessedScientistRender;
import mod.azure.doom.client.render.PossessedSoldierRender;
import mod.azure.doom.client.render.RevenantRender;
import mod.azure.doom.client.render.ShotgunguyRender;
import mod.azure.doom.client.render.SpiderdemonRender;
import mod.azure.doom.client.render.UnwillingRender;
import mod.azure.doom.client.render.ZombiemanRender;
import mod.azure.doom.client.render.projectiles.ArgentBoltRender;
import mod.azure.doom.client.render.projectiles.BFGCellRender;
import mod.azure.doom.client.render.projectiles.BarenBlastRender;
import mod.azure.doom.client.render.projectiles.BulletsRender;
import mod.azure.doom.client.render.projectiles.ChaingunBulletRender;
import mod.azure.doom.client.render.projectiles.EnergyCellRender;
import mod.azure.doom.client.render.projectiles.LostSoulShootRender;
import mod.azure.doom.client.render.projectiles.RocketRender;
import mod.azure.doom.client.render.projectiles.ShotgunShellRender;
import mod.azure.doom.client.render.projectiles.UnmaykrBulletRender;
import mod.azure.doom.client.render.projectiles.entity.EnergyCellMobRender;
import mod.azure.doom.client.render.projectiles.entity.RocketMobRender;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = DoomMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BARREL.get(), BarrelRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SHOTGUN_SHELL.get(), ShotgunShellRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARGENT_BOLT.get(), ArgentBoltRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNMAYKR.get(), UnmaykrBulletRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENERGY_CELL.get(), EnergyCellRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BULLETS.get(), BulletsRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BFG_CELL.get(), BFGCellRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ROCKET.get(), RocketRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHAINGUN_BULLET.get(),
				ChaingunBulletRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BARENBLAST.get(), BarenBlastRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LOST_SOUL.get(), LostSoulShootRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.IMP.get(), ImpRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARACHNOTRON.get(), ArachnotronRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.NIGHTMARE_IMP.get(), NightmareImpRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PINKY.get(), PinkyRender::new);
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
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENERGY_CELL_MOB.get(),
				EnergyCellMobRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ROCKET_MOB.get(), RocketMobRender::new);
	}

}