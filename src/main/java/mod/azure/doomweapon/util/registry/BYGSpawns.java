package mod.azure.doomweapon.util.registry;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

public class BYGSpawns {

	public static void registerEntityModWorldSpawns() {
		registerEntityWorldSpawn(ModEntityTypes.IMP.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.PINKY.get(), 12, 2, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.CACODEMON.get(), 8, 1, 2, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.ARCHVILE.get(), 4, 1, 2, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.BARON.get(), 10, 1, 1, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.MANCUBUS.get(), 10, 1, 1, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.REVENANT.get(), 10, 1, 1, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.SPIDERDEMON.get(), 10, 1, 1, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.ZOMBIEMAN.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.ARACHNOTRON.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.IMP2016.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.LOST_SOUL.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.NIGHTMARE_IMP.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.CHAINGUNNER.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.SHOTGUNGUY.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.MARAUDER.get(), 15, 1, 1, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.PAIN.get(), 8, 1, 2, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.HELLKNIGHT.get(), 10, 1, 1, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON.get(), 10, 1, 1, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.UNWILLING.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSCIENTIST.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.POSSESSEDSOLDIER.get(), 30, 1, 4, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
		registerEntityWorldSpawn(ModEntityTypes.CYBERDEMON2016.get(), 10, 1, 1, BYGBiomeList.EMBURBOG,
				BYGBiomeList.GLOWSTONEGARDENS, BYGBiomeList.SYTHIANTORRIDS, BYGBiomeList.WARPEDDESERT);
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