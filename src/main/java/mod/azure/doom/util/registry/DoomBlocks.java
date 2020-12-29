package mod.azure.doom.util.registry;

import mod.azure.doom.DoomMod;
import mod.azure.doom.block.ArgentBlock;
import mod.azure.doom.block.ArgentLampBlock;
import mod.azure.doom.block.BarrelBlock;
import mod.azure.doom.block.DoomSandBlock;
import mod.azure.doom.block.DoomWallBlock;
import mod.azure.doom.block.E1M1DoorBlock;
import mod.azure.doom.block.E1M1StairsBlock;
import mod.azure.doom.block.E1M1TurnableBlock;
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

	public static final RegistryObject<Block> ARGENT_BLOCK = BLOCKS.register("argent_block", () -> new ArgentBlock(
			(AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.BONE))));

	public static final RegistryObject<Block> ARGENT_LAMP_BLOCK = BLOCKS.register("argent_lamp_block",
			() -> new ArgentLampBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F)
					.sound(SoundType.BONE))));

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

	public static final RegistryObject<Block> E1M1_1 = BLOCKS.register("e1m1_block1",
			() -> new ArgentLampBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_2 = BLOCKS.register("e1m1_block2",
			() -> new ArgentLampBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_3 = BLOCKS.register("e1m1_block3",
			() -> new ArgentLampBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_4 = BLOCKS.register("e1m1_block4",
			() -> new ArgentLampBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_5 = BLOCKS.register("e1m1_block5",
			() -> new ArgentLampBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_6 = BLOCKS.register("e1m1_block6",
			() -> new ArgentLampBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_7 = BLOCKS.register("e1m1_block7",
			() -> new E1M1StairsBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_8 = BLOCKS.register("e1m1_block8",
			() -> new E1M1StairsBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_9 = BLOCKS.register("e1m1_block9",
			() -> new E1M1TurnableBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_10 = BLOCKS.register("e1m1_block10",
			() -> new E1M1TurnableBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_11 = BLOCKS.register("e1m1_block11",
			() -> new E1M1TurnableBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_12 = BLOCKS.register("e1m1_block12",
			() -> new E1M1TurnableBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));
	public static final RegistryObject<Block> E1M1_13 = BLOCKS.register("e1m1_block13",
			() -> new E1M1TurnableBlock((AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F))));

	public static final RegistryObject<Block> E1M1DOOR4 = BLOCKS.register("e1m1door4", () -> new E1M1DoorBlock(
			(AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).notSolid().doesNotBlockMovement())));

}