package mod.azure.doomweapon.util;

import java.io.File;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import mod.azure.doomweapon.DoomMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class Config {

	public static final ServerConfig SERVER;
	public static final ForgeConfigSpec SERVER_SPEC;

	static {
		final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
		SERVER_SPEC = specPair.getRight();
		SERVER = specPair.getLeft();
	}

	public static class ServerConfig {
		public ConfigValue<Integer> SWORD_CRUCIBLE_ATTACK;
		public ConfigValue<Integer> SWORD_CRUCIBLE_MAXDAMAGE;
		public ConfigValue<Integer> AXE_CRUCIBLE_ATTACK;
		public ConfigValue<Integer> AXE_CRUCIBLE_MAXDAMAGE;

		ServerConfig(ForgeConfigSpec.Builder builder) {
			builder.push("general");
			SWORD_CRUCIBLE_ATTACK = builder.comment(
					"Attack damage of Crucible Sword. Minecraft adds 4 to this number so set it four lower then you want.")
					.translation(DoomMod.MODID + ".config.sword_crucible_attack").define("SWORD_CRUCIBLE_ATTACK", 12);
			SWORD_CRUCIBLE_MAXDAMAGE = builder.comment("Max damage of Crucible Sword.")
					.translation(DoomMod.MODID + ".config.sword_crucible_maxdamage")
					.define("SWORD_CRUCIBLE_MAXDAMAGE", 300);
			AXE_CRUCIBLE_ATTACK = builder.comment(
					"Attack damage of Crucible Axe. Minecraft adds 4 to this number so set it four lower then you want.")
					.translation(DoomMod.MODID + ".config.axe_crucible_attack").define("AXE_CRUCIBLE_ATTACK", 12);
			AXE_CRUCIBLE_MAXDAMAGE = builder.comment("Max damage of Crucible Axe.")
					.translation(DoomMod.MODID + ".config.axe_crucible_maxdamage")
					.define("AXE_CRUCIBLE_MAXDAMAGE", 300);
			builder.pop();
			builder.push("mobs");
			builder.pop();
		}
	}

	public static void loadConfig(ForgeConfigSpec config, String path) {
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave()
				.writingMode(WritingMode.REPLACE).build();
		file.load();
		config.setConfig(file);
	}
}