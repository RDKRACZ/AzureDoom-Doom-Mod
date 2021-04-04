package mod.azure.doom.util.config;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.config.EntityDefaults.EntityConfigType;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class Config {

	public static final ServerConfig SERVER;
	public static final ForgeConfigSpec SERVER_SPEC;
	public static final ForgeConfigSpec BIOME_SPEC;
	public static final BiomeConfig BIOME;

	static {

		{
			final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder()
					.configure(ServerConfig::new);
			SERVER_SPEC = specPair.getRight();
			SERVER = specPair.getLeft();
		}
		{
			final Pair<BiomeConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder()
					.configure(BiomeConfig::new);
			BIOME = specPair.getLeft();
			BIOME_SPEC = specPair.getRight();
		}
	}

	public static class ServerConfig {

		private ConfigValue<Integer> specCRUCIBLE_MARAUDER_MAX_DAMAGE;
		private final BooleanValue specENABLE_LOCKON;
		private final BooleanValue specENABLE_BLOCK_BREAKING;

		public int CRUCIBLE_MARAUDER_MAX_DAMAGE;
		public boolean ENABLE_LOCKON;
		public boolean ENABLE_BLOCK_BREAKING;

		/*
		 * Spawn Weights
		 */
		public int COMMON_DEMON_SPAWN_WEIGHT;
		public int HEAVY_DEMON_SPAWN_WEIGHT;
		public boolean USE_INDIVIDUAL_SPAWN_RULES;
		public List<? extends String> BIOME_DICT;

		ServerConfig(ForgeConfigSpec.Builder builder) {
			builder.push("spawn_weight");

			// Default settings per entity here.
			for (EntityConfigType entityType : EntityConfigType.values())
				pushDefaults(builder, entityType);

			builder.pop();
			builder.push("gear");
			specCRUCIBLE_MARAUDER_MAX_DAMAGE = builder.comment("Crucible Sword/Marauder Axe Max Damage")
					.translation(DoomMod.MODID + ".config.crucible_marauder_max_damage")
					.define("CRUCIBLE_MARAUDER_MAX_DAMAGE", 5);
			builder.pop();
			builder.push("extra");
			specENABLE_LOCKON = builder.comment("You can disable the lockon feature here.")
					.translation(DoomMod.MODID + ".config.enable_lockon").define("ENABLE_LOCKON", true);
			specENABLE_BLOCK_BREAKING = builder.comment("You can enable weapons breaking blocks.")
					.translation(DoomMod.MODID + ".config.enable_block_breaking").define("ENABLE_BLOCK_BREAKING", true);
			builder.pop();
		}

		public HashMap<EntityConfigType, EntityConfig> entityConfig = new HashMap<EntityConfigType, EntityConfig>();

		public void pushDefaults(Builder builder, EntityConfigType type) {
			entityConfig.put(type,
					new EntityConfig(type.toString(),
							type.getDefaultAttributes().isHeavy() ? 5 : type == EntityConfigType.ICON_OF_SIN ? 0 : 15,
							1, type.getDefaultAttributes().getDefaultMaxRoll(), 0, 255, Arrays.asList("nether"))
									.setAttributes(type.getDefaultAttributes()).buildVia(builder));
		}

		public void bakeConfig() {
			CRUCIBLE_MARAUDER_MAX_DAMAGE = specCRUCIBLE_MARAUDER_MAX_DAMAGE.get();
			ENABLE_LOCKON = specENABLE_LOCKON.get();
			ENABLE_BLOCK_BREAKING = specENABLE_BLOCK_BREAKING.get();
			entityConfig.values().forEach(config -> config.bake());
		}

	}

	public static void loadConfig(ForgeConfigSpec config, String path) {
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave()
				.writingMode(WritingMode.REPLACE).build();
		file.load();
		config.setConfig(file);
	}
}