package mod.azure.doomweapon.util;

import harmonised.pmmo.util.XP;
import net.minecraft.entity.player.ServerPlayerEntity;

public class PMMOCompat {

	public static void awardInmortalXp(ServerPlayerEntity player) {
		XP.awardXpTrigger(player.getUniqueID(), "doomweapon.consume.inmortal", null, true, true);
	}

	public static void awardInvisibleXp(ServerPlayerEntity player) {
		XP.awardXpTrigger(player.getUniqueID(), "doomweapon.consume.invisible", null, true, true);
	}

	public static void awardMegaXp(ServerPlayerEntity player) {
		XP.awardXpTrigger(player.getUniqueID(), "doomweapon.consume.mega", null, true, true);
	}

	public static void awardPowerXp(ServerPlayerEntity player) {
		XP.awardXpTrigger(player.getUniqueID(), "doomweapon.consume.power", null, true, true);
	}

	public static void awardSoulXp(ServerPlayerEntity player) {
		XP.awardXpTrigger(player.getUniqueID(), "doomweapon.consume.soul", null, true, true);
	}

}