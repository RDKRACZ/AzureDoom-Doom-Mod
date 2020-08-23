package mod.azure.doomweapon.util.registry;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.block.ArgentBlock;
import mod.azure.doomweapon.block.ArgentLampBlock;
import mod.azure.doomweapon.block.BarrelBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DoomBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DoomMod.MODID);

	public static final RegistryObject<Block> BARREL_BLOCK = BLOCKS.register("barrel",
			() -> new BarrelBlock((AbstractBlock.Properties.create(Material.TNT).zeroHardnessAndResistance()
					.sound(SoundType.PLANT).notSolid())));

	public static final RegistryObject<Block> ARGENT_BLOCK = BLOCKS.register("argent_block",
			() -> new ArgentBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F)
					.sound(SoundType.BONE))));

	public static final RegistryObject<Block> ARGENT_LAMP_BLOCK = BLOCKS.register("argent_lamp_block",
			() -> new ArgentLampBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F)
					.sound(SoundType.BONE))));
}