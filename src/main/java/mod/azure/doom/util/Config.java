package mod.azure.doom.util;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.EntityDefaults.EntityConfigType;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
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

		private ConfigValue<Integer> specCRUCIBLE_MARAUDER_MAX_DAMAGE;
		private final BooleanValue specENABLE_LOCKON;

		public int CRUCIBLE_MARAUDER_MAX_DAMAGE;
		public boolean ENABLE_LOCKON;

		/*
		 * Spawn Weights
		 */
		private ConfigValue<Integer> specCOMMON_DEMON_SPAWN_WEIGHT;
		private ConfigValue<Integer> specHEAVY_DEMON_SPAWN_WEIGHT;
		private ConfigValue<Boolean> specUSE_INDIVIDUAL_SPAWN_RULES;
		private ConfigValue<List<? extends String>> specBIOME_DICT;

		public int COMMON_DEMON_SPAWN_WEIGHT;
		public int HEAVY_DEMON_SPAWN_WEIGHT;
		public boolean USE_INDIVIDUAL_SPAWN_RULES;
		public List<? extends String> BIOME_DICT;

		ServerConfig(ForgeConfigSpec.Builder builder) {
			builder.push("spawn_weight");
			specCOMMON_DEMON_SPAWN_WEIGHT = builder.comment("Spawn weight of Common Demons.")
					.translation(DoomMod.MODID + ".config.common_demon_spawn_weight")
					.define("COMMON_DEMON_SPAWN_WEIGHT", 30);
			specHEAVY_DEMON_SPAWN_WEIGHT = builder.comment("Spawn weight of Heavy Demons.")
					.translation(DoomMod.MODID + ".config.heavy_demon_spawn_weight")
					.define("HEAVY_DEMON_SPAWN_WEIGHT", 10);
			specUSE_INDIVIDUAL_SPAWN_RULES = builder.comment(
					"Define spawn rules and weights for each entity separately. Overrides the COMMON & HEAVY_DEMON_SPAWN_WEIGHT fields.")
					.translation(DoomMod.MODID + ".config.use_individual_spawn_rules")
					.define("USE_INDIVIDUAL_SPAWN_RULES", false);
			specBIOME_DICT = builder.comment(
					"Allowed biome dictionary values for all entities to spawn in. E.g. \"NETHER\", \"FOREST+HOT\", \"PLAINS+!SNOWY\"")
					.translation(new StringBuilder(DoomMod.MODID).append("biome_dict").toString())
					.defineList("BIOME_DICT", Arrays.asList("NETHER"), string -> string != null);

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
			specENABLE_LOCKON = builder.comment("You can disable disable the lockon feature here.")
					.translation(DoomMod.MODID + ".config.enable_lockon").define("ENABLE_LOCKON", true);
			builder.pop();
		}

		public HashMap<EntityConfigType, EntityConfig> entityConfig = new HashMap<EntityConfigType, EntityConfig>();

		public void pushDefaults(Builder builder, EntityConfigType type) {
			entityConfig.put(type,
					new EntityConfig(type.toString(),
							type.getDefaultAttributes().isHeavy() ? 10 : type == EntityConfigType.ICON_OF_SIN ? 0 : 30,
							1, type.getDefaultAttributes().getDefaultMaxRoll(), 0, 255, Arrays.asList("NETHER"))
									.setAttributes(type.getDefaultAttributes()).buildVia(builder));
		}

		public void bakeConfig() {
			CRUCIBLE_MARAUDER_MAX_DAMAGE = specCRUCIBLE_MARAUDER_MAX_DAMAGE.get();
			ENABLE_LOCKON = specENABLE_LOCKON.get();
			COMMON_DEMON_SPAWN_WEIGHT = specCOMMON_DEMON_SPAWN_WEIGHT.get();
			HEAVY_DEMON_SPAWN_WEIGHT = specHEAVY_DEMON_SPAWN_WEIGHT.get();
			USE_INDIVIDUAL_SPAWN_RULES = specUSE_INDIVIDUAL_SPAWN_RULES.get();
			BIOME_DICT = specBIOME_DICT.get();
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