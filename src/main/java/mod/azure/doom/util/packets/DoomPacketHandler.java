package mod.azure.doom.util.packets;

import mod.azure.doom.DoomMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class DoomPacketHandler {
	private static final String PROTOCOL_VERSION = "1";
	private static int channel_id = 0;

	public static final SimpleChannel BALLISTA = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "ballista"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel BFG = NetworkRegistry.newSimpleChannel(new ResourceLocation(DoomMod.MODID, "bfg"),
			() -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

	public static final SimpleChannel BFG9000 = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "bfg9000"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel CHAINGUN = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "chaingun"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel PISTOL = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "pistol"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel PLASMA = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "plasma"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel ROCKETLAUNCHER = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "rocketlauncher"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel SHOTGUN = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "shotgun"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel SUPERSHOTGUN = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "supershotgun"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel UNMAYKR = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "unmakyr"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel CRUCIBLE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "crucible"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static final SimpleChannel CHAINSAW = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(DoomMod.MODID, "chainsaw"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static void register() {
		BALLISTA.registerMessage(channel_id++, BallistaLoadingPacket.class, BallistaLoadingPacket::encode,
				BallistaLoadingPacket::new, BallistaLoadingPacket::handle);
		BFG.registerMessage(channel_id++, BFGLoadingPacket.class, BFGLoadingPacket::encode, BFGLoadingPacket::new,
				BFGLoadingPacket::handle);
		BFG9000.registerMessage(channel_id++, BFG9000LoadingPacket.class, BFG9000LoadingPacket::encode,
				BFG9000LoadingPacket::new, BFG9000LoadingPacket::handle);
		CHAINGUN.registerMessage(channel_id++, ChaingunLoadingPacket.class, ChaingunLoadingPacket::encode,
				ChaingunLoadingPacket::new, ChaingunLoadingPacket::handle);
		PISTOL.registerMessage(channel_id++, PistolLoadingPacket.class, PistolLoadingPacket::encode,
				PistolLoadingPacket::new, PistolLoadingPacket::handle);
		PLASMA.registerMessage(channel_id++, PlasmaLoadingPacket.class, PlasmaLoadingPacket::encode,
				PlasmaLoadingPacket::new, PlasmaLoadingPacket::handle);
		ROCKETLAUNCHER.registerMessage(channel_id++, RocketLauncherLoadingPacket.class,
				RocketLauncherLoadingPacket::encode, RocketLauncherLoadingPacket::new,
				RocketLauncherLoadingPacket::handle);
		SHOTGUN.registerMessage(channel_id++, SGLoadingPacket.class, SGLoadingPacket::encode, SGLoadingPacket::new,
				SGLoadingPacket::handle);
		SUPERSHOTGUN.registerMessage(channel_id++, SSGLoadingPacket.class, SSGLoadingPacket::encode,
				SSGLoadingPacket::new, SSGLoadingPacket::handle);
		UNMAYKR.registerMessage(channel_id++, UnmaykrLoadingPacket.class, UnmaykrLoadingPacket::encode,
				UnmaykrLoadingPacket::new, UnmaykrLoadingPacket::handle);
		CRUCIBLE.registerMessage(channel_id++, CrucibleLoadingPacket.class, CrucibleLoadingPacket::encode,
				CrucibleLoadingPacket::new, CrucibleLoadingPacket::handle);
		CHAINSAW.registerMessage(channel_id++, ChainsawLoadingPacket.class, ChainsawLoadingPacket::encode,
				ChainsawLoadingPacket::new, ChainsawLoadingPacket::handle);
	}
}
