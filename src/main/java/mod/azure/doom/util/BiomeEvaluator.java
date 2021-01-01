package mod.azure.doom.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;

public class BiomeEvaluator {

	public static boolean isValidBiome(Biome biome, List<String> biomeTypes, EntityConfig config) {
		return matchBiome(config.BIOME_DICT, biome, biomeTypes);
	}

	public static boolean isValidBiomeAsGroup(Biome biome, List<String> biomeTypes) {
		return matchBiome(Config.SERVER.BIOME_DICT, biome, biomeTypes);
	}

	// ! = not include
	// + = and
	// , = or
	// @ = force and
	private static boolean matchBiome(List<? extends String> biomeDict, Biome biome, List<String> biomeTypes) {
		List<String> forceStrings = new ArrayList<String>();
		List<String> conditionals = new ArrayList<String>();
		String biomeID = biome.getRegistryName().toString();
		for (String biomeTag : biomeDict) {
			// match exact biomes, e.g. minecraft:taiga - these have highest priority.
			if (biomeTag.equalsIgnoreCase(biomeID))
				return true;
			if (biomeTag.startsWith("!") && biomeTag.substring(1).equalsIgnoreCase(biomeID))
				return false;
			biomeTag = biomeTag.toLowerCase(Locale.ROOT);

			if (biomeTag.startsWith("@"))
				forceStrings.add(biomeTag.substring(1));
			else
				conditionals.add(biomeTag);
			// TODO split the string and work out if passes. if negative force return false;
		}
		for (String required : forceStrings) {
			if (!meetsTag(required, biomeTypes))
				return false;
		}
		return conditionals.stream().anyMatch(biomeFragment -> {
			return meetsTag(biomeFragment, biomeTypes);
		});
	}

	private static boolean meetsTag(String query,
			List<String> biomeTypes) {
		for (String fragment : query.split(Pattern.quote("+"))) {
			if (fragment.startsWith("!")) {
				if (biomeTypes.contains(fragment.substring(1)))
						return false;
			} else {
				if (!biomeTypes.contains(fragment))
					return false;
			}
		}
		return true;
	}
	
    public static int getLightLevel(IServerWorld worldIn, double x, double y, double z) {
    ServerWorld o = worldIn.getWorld();
    return o.isThundering() ? o.getNeighborAwareLightSubtracted(new BlockPos(x, y, z), 10) : o.getLight(new BlockPos(x, y, z));
}

}
