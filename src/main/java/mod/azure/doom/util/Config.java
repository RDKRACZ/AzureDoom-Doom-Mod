package mod.azure.doom.util;

import java.io.File;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import mod.azure.doom.DoomMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
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

		public ConfigValue<Integer> CRUCIBLE_MARUADER_MAXDAMAGE;
		public final BooleanValue ENABLE_LOCKON;
		public ConfigValue<Integer> COMMON_DEMON_SPAWN_WEIGHT;
		public ConfigValue<Integer> HEAVY_DEMON_SPAWN_WEIGHT;

		ServerConfig(ForgeConfigSpec.Builder builder) {
			builder.push("spawn_weight");
			COMMON_DEMON_SPAWN_WEIGHT = builder.comment("Spawn weight of Common Demons.")
					.translation(DoomMod.MODID + ".config.common_demon_spawn_weight")
					.define("COMMON_DEMON_SPAWN_WEIGHT", 30);
			HEAVY_DEMON_SPAWN_WEIGHT = builder.comment("Spawn weight of Heavy Demons.")
					.translation(DoomMod.MODID + ".config.heavy_demon_spawn_weight")
					.define("HEAVY_DEMON_SPAWN_WEIGHT", 10);
			builder.pop();
			builder.push("gear");
			CRUCIBLE_MARUADER_MAXDAMAGE = builder.comment("Crucible Sword/Maruader Axe Max Damage")
					.translation(DoomMod.MODID + ".config.crucible_maruader_maxdamage")
					.define("CRUCIBLE_MARUADER_MAXDAMAGE", 5);
			builder.pop();
			builder.push("extra");
			ENABLE_LOCKON = builder.comment("You can disable disable the lockon feature here.")
					.translation(DoomMod.MODID + ".config.enable_lockon").define("ENABLE_LOCKON", true);
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