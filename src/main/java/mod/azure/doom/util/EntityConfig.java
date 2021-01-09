package mod.azure.doom.util;

import java.util.List;

import mod.azure.doom.DoomMod;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class EntityConfig {

	public String name;
	private String lName;
	private String uName;

	private ConfigValue<Integer> specSPAWN_WEIGHT;
	private ConfigValue<Integer> specMIN_GROUP;
	private ConfigValue<Integer> specMAX_GROUP;
	private ConfigValue<Integer> specMIN_Y;
	private ConfigValue<Integer> specMAX_Y;
	private ConfigValue<List<? extends String>> specBIOME_DICT;

	public int SPAWN_WEIGHT;
	public int MIN_GROUP;
	public int MAX_GROUP;
	public int MIN_Y;
	public int MAX_Y;
	public List<? extends String> BIOME_DICT;

	public EntityConfig(String name, int spawnWeight, int minGroup, int maxGroup, int minY, int maxY,
			List<String> biomeDict) {
		this.name = name;
		lName = name.toLowerCase();
		uName = name.toUpperCase();
		SPAWN_WEIGHT = spawnWeight;
		MIN_GROUP = minGroup;
		MAX_GROUP = maxGroup;
		MIN_Y = minY;
		MAX_Y = maxY;
		BIOME_DICT = biomeDict;
	}
	

	private ConfigValue<Double> specRANGED_ATTACK_DAMAGE;
	public float RANGED_ATTACK_DAMAGE;

	protected void bake() {
		// load into memory to avoid real-time persistent storage calls
		SPAWN_WEIGHT = specSPAWN_WEIGHT.get();
		MIN_GROUP = specMIN_GROUP.get();
		MAX_GROUP = specMAX_GROUP.get();
		MIN_Y = specMIN_Y.get();
		MAX_Y = specMAX_Y.get();
		BIOME_DICT = specBIOME_DICT.get();
		RANGED_ATTACK_DAMAGE = specRANGED_ATTACK_DAMAGE == null ? 0F : specRANGED_ATTACK_DAMAGE.get().floatValue();
	}

	public EntityConfig setAttributes(EntityDefaults defaults) {
		RANGED_ATTACK_DAMAGE = defaults.getDefaultRangedDamage();
		return this;
	}

	public EntityConfig buildVia(Builder builder) {

		builder.push("individual_spawning");
		builder.push(name);

		/*
		 * Customisable per-entity spawn weights
		 */

		specSPAWN_WEIGHT = builder
				.comment(
						new StringBuilder("Spawn weight of ").append(name).append("s. Set to 0 to disable.").toString())
				.translation(new StringBuilder(DoomMod.MODID).append(".config.").append(lName).append("_spawn_weight")
						.toString())
				.defineInRange(new StringBuilder(uName).append("_SPAWN_WEIGHT").toString(), SPAWN_WEIGHT, 0, 9999);

		specMIN_GROUP = builder.comment("Smallest group to spawn.")
				.translation(new StringBuilder(DoomMod.MODID).append(".config.").append(lName).append("_min_group")
						.toString())
				.defineInRange(new StringBuilder(uName).append("_MIN_GROUP").toString(), MIN_GROUP, 1, 9);

		specMAX_GROUP = builder.comment("Largest group to spawn.")
				.translation(new StringBuilder(DoomMod.MODID).append(".config.").append(lName).append("_max_group")
						.toString())
				.defineInRange(new StringBuilder(uName).append("_MAX_GROUP").toString(), MAX_GROUP, 1, 9);

		specMIN_Y = builder.comment("Minimum Y location to spawn at.")
				.translation(
						new StringBuilder(DoomMod.MODID).append(".config.").append(lName).append("_min_y").toString())
				.defineInRange(new StringBuilder(uName).append("_MIN_Y").toString(), MIN_Y, 0, 255);

		specMAX_Y = builder.comment("Maximum Y location to spawn at.")
				.translation(
						new StringBuilder(DoomMod.MODID).append(".config.").append(lName).append("_max_y").toString())
				.defineInRange(new StringBuilder(uName).append("_MAX_Y").toString(), MAX_Y, 0, 255);

		specBIOME_DICT = builder.comment(
				"Allowed biome dictionary values for the entity to spawn in. E.g. [\"NETHER\", \"FOREST+HOT\", \"PLAINS+!SNOWY\"]")
				.translation(new StringBuilder(DoomMod.MODID).append(".config.").append(lName).append("_biome_dict")
						.toString())
				.defineList(new StringBuilder(uName).append("_BIOME_DICT").toString(), BIOME_DICT,
						string -> string != null);

		builder.pop(3);

		/*
		 * Customisable mob attributes
		 */
		builder.push("attributes");
		builder.push(name);

		if (RANGED_ATTACK_DAMAGE > 0) {
			specRANGED_ATTACK_DAMAGE = builder
					.comment(new StringBuilder("Average RANGED damaged caused by ").append(name)
							.append("s when attacking.").toString())
					.translation(new StringBuilder(DoomMod.MODID).append(".config.").append(lName)
							.append("_ranged_attack_damage").toString())
					.defineInRange(new StringBuilder(uName).append("_RANGED_ATTACK_DAMAGE").toString(),
							RANGED_ATTACK_DAMAGE, 0, Double.MAX_VALUE);
		}
		builder.pop(2);

		builder.push("spawn_weight");
		return this;
	}

}
