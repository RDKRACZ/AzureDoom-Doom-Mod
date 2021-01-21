package mod.azure.doom.structures;

import mod.azure.doom.DoomMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class DoomConfiguredStructures {

	public static StructureFeature<?, ?> CONFIGURED_DOOM1 = DoomStructures.DOOM1.get()
			.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);

	public static void registerConfiguredStructures() {
		Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
		Registry.register(registry, new ResourceLocation(DoomMod.MODID, "configured_doom1"),
				CONFIGURED_DOOM1);

		FlatGenerationSettings.STRUCTURES.put(DoomStructures.DOOM1.get(), CONFIGURED_DOOM1);
	}
}