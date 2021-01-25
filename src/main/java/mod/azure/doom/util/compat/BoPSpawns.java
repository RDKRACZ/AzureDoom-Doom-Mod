package mod.azure.doom.util.compat;

import biomesoplenty.api.biome.BOPBiomes;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;

public class BoPSpawns {

	public static void registerEntityModWorldSpawns() {
		registerEntityWorldSpawn(ModEntityTypes.IMP.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.PINKY.get(), 12, 2, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.SPECTRE.get(), 12, 2, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.CACODEMON.get(), 8, 1, 2, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.ARCHVILE.get(), 4, 1, 2, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.BARON.get(), 10, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.MANCUBUS.get(), 10, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.REVENANT.get(), 10, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.SPIDERDEMON.get(), 10, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.ZOMBIEMAN.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.ARACHNOTRON.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.IMP2016.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.LOST_SOUL.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.NIGHTMARE_IMP.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.GARGOYLE.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.CHAINGUNNER.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.SHOTGUNGUY.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.MARAUDER.get(), 15, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.PAIN.get(), 8, 1, 2, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.HELLKNIGHT.get(), 10, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.HELLKNIGHT2016.get(), 10, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON.get(), 10, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.UNWILLING.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSCIENTIST.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSOLDIER.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON2016.get(), 10, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.GORE_NEST.get(), 10, 1, 1, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
		registerEntityWorldSpawn(ModEntityTypes.MECHAZOMBIE.get(), 30, 1, 4, BOPBiomes.ashen_inferno.get(),
				BOPBiomes.undergarden.get(), BOPBiomes.visceral_heap.get());
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