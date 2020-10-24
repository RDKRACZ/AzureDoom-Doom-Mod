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

		public final BooleanValue IN_FIGHTING;
		public ConfigValue<Integer> CRUCIBLE_MARUADER_MAXDAMAGE;

		ServerConfig(ForgeConfigSpec.Builder builder) {
			builder.push("gear");
			CRUCIBLE_MARUADER_MAXDAMAGE = builder.comment("Crucible Sword/Maruader Axe Max Damage")
					.translation(DoomMod.MODID + ".config.crucible_maruader_maxdamage")
					.define("CRUCIBLE_MARUADER_MAXDAMAGE", 5);
			builder.pop();
			builder.push("extra");
			IN_FIGHTING = builder.comment("Do you want to allow In-fighting of the mobs?")
					.translation(DoomMod.MODID + ".config.in_fighting").define("IN_FIGHTING", true);
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