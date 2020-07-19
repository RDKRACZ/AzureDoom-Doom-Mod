package mod.azure.doomweapon.util.registry;

import com.blackgear.nether.core.registry.world.NetherBiomes;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class ExtraModSpawns {

	public static void registerEntityModWorldSpawns() {
		registerEntityWorldSpawn(ModEntityTypes.IMP.get(), 12, 2, 7, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.PINKY.get(), 12, 2, 4, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.LOST_SOUL.get(), 8, 1, 3, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.CACODEMON.get(), 8, 1, 2, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.ARCHVILE.get(), 4, 1, 2, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.BARON.get(), 2, 1, 1, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.MANCUBUS.get(), 2, 1, 1, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.REVENANT.get(), 2, 1, 1, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.SPIDERDEMON.get(), 2, 1, 1, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.ZOMBIEMAN.get(), 12, 2, 7, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.IMP2016.get(), 12, 2, 7, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.CHAINGUNNER.get(), 12, 2, 7, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.SHOTGUNGUY.get(), 12, 2, 7, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.MARAUDER.get(), 1, 1, 1, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.PAIN.get(), 8, 1, 2, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.HELLKNIGHT.get(), 2, 1, 1, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON.get(), 2, 1, 1, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.UNWILLING.get(), 12, 2, 7, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSCIENTIST.get(), 12, 2, 7, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSOLDIER.get(), 12, 2, 7, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON2016.get(), 2, 1, 1, NetherBiomes.BASALT_DELTAS.get(),
				NetherBiomes.CRIMSON_FOREST.get(), NetherBiomes.SOUL_SAND_VALLEY.get(),
				NetherBiomes.WARPED_FOREST.get());
	}

	public static void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minGroup, int maxGroup,
			Biome... biomes) {
		for (Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, weight, minGroup, maxGroup));
			}
		}
	}
}