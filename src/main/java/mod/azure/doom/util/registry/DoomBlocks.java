package mod.azure.doom.util.registry;

import mod.azure.doom.DoomMod;
import mod.azure.doom.block.ArgentBlock;
import mod.azure.doom.block.ArgentLampBlock;
import mod.azure.doom.block.BarrelBlock;
import mod.azure.doom.block.DoomSandBlock;
import mod.azure.doom.block.DoomWallBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DoomBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DoomMod.MODID);

	public static final RegistryObject<Block> BARREL_BLOCK = BLOCKS.register("barrel", () -> new BarrelBlock(
			(Block.Properties.create(Material.TNT).hardnessAndResistance(0.0F).sound(SoundType.PLANT).notSolid())));

	public static final RegistryObject<Block> ARGENT_BLOCK = BLOCKS.register("argent_block", () -> new ArgentBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_SAND = BLOCKS.register("doom_sand", () -> new DoomSandBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL1 = BLOCKS.register("icon_wall1", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL2 = BLOCKS.register("icon_wall2", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL3 = BLOCKS.register("icon_wall3", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL4 = BLOCKS.register("icon_wall4", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL5 = BLOCKS.register("icon_wall5", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL6 = BLOCKS.register("icon_wall6", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL7 = BLOCKS.register("icon_wall7", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL8 = BLOCKS.register("icon_wall8", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL9 = BLOCKS.register("icon_wall9", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL10 = BLOCKS.register("icon_wall10", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL11 = BLOCKS.register("icon_wall11", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL12 = BLOCKS.register("icon_wall12", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL13 = BLOCKS.register("icon_wall13", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL14 = BLOCKS.register("icon_wall14", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL15 = BLOCKS.register("icon_wall15", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> DOOM_WALL16 = BLOCKS.register("icon_wall16", () -> new DoomWallBlock(
			(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));

	public static final RegistryObject<Block> ARGENT_LAMP_BLOCK = BLOCKS.register("argent_lamp_block",
			() -> new ArgentLampBlock(
					(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE))));
}