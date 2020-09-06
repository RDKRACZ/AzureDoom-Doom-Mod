package mod.azure.doomweapon.util.registry;


import logictechcorp.netherex.world.biome.NetherExBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class NetherExSpawns {
	public static void registerEntityModWorldSpawns() {
		registerEntityWorldSpawn(ModEntityTypes.IMP.get(), 30, 1, 4, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.PINKY.get(), 12, 2, 4, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.CACODEMON.get(), 8, 1, 2, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.ARCHVILE.get(), 4, 1, 2, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.BARON.get(), 10, 1, 1, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.MANCUBUS.get(), 10, 1, 1, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.REVENANT.get(), 10, 1, 1, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.SPIDERDEMON.get(), 10, 1, 1, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.ZOMBIEMAN.get(), 30, 1, 4, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.IMP2016.get(), 30, 1, 4, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.CHAINGUNNER.get(), 30, 1, 4, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.SHOTGUNGUY.get(), 30, 1, 4, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.MARAUDER.get(), 15, 1, 1, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.PAIN.get(), 8, 1, 2, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.HELLKNIGHT.get(), 10, 1, 1, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON.get(), 10, 1, 1, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.UNWILLING.get(), 30, 1, 4, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSCIENTIST.get(), 30, 1, 4, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSOLDIER.get(), 30, 1, 4, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON2016.get(), 10, 1, 1, NetherExBiomes.RUTHLESS_SANDS.get(),
				NetherExBiomes.FUNGI_FOREST.get(), NetherExBiomes.TORRID_WASTELAND.get(),
				NetherExBiomes.ARCTIC_ABYSS.get());
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