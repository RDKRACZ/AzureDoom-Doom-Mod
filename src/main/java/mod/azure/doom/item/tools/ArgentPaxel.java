package mod.azure.doom.item.tools;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.enums.DoomTier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.Constants.BlockFlags;
import net.minecraftforge.common.util.Constants.WorldEvents;

public class ArgentPaxel extends ToolItem {

	protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Maps
			.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState()));
	protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new Builder<Block, Block>())
			.put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
			.put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
			.put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
			.put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
			.put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
			.put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
			.put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
			.put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
			.put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
			.put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).build();

	public ArgentPaxel() {
		super(8, -2.4F, DoomTier.DOOM, Collections.emptySet(),
				new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).addToolType(ToolType.AXE, 18)
						.addToolType(ToolType.SHOVEL, 18).addToolType(ToolType.PICKAXE, 18));
	}

	@Override
	public float getDestroySpeed(@Nonnull ItemStack stack, BlockState state) {
		return 30;
	}

	@Override
	public boolean canHarvestBlock(BlockState state) {
		ToolType harvestTool = state.getHarvestTool();
		if (harvestTool == ToolType.AXE || harvestTool == ToolType.PICKAXE || harvestTool == ToolType.SHOVEL) {
			return true;
		}
		Block block = state.getBlock();
		if (block == Blocks.SNOW || block == Blocks.SNOW_BLOCK) {
			return true;
		}
		Material material = state.getMaterial();
		return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
	}

	@Nonnull
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		BlockPos blockpos = context.getPos();
		PlayerEntity player = context.getPlayer();
		BlockState blockstate = world.getBlockState(blockpos);
		BlockState resultToSet = null;
		Block strippedResult = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
		if (strippedResult != null) {
			world.playSound(player, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
			resultToSet = strippedResult.getDefaultState().with(RotatedPillarBlock.AXIS,
					blockstate.get(RotatedPillarBlock.AXIS));
		} else {
			if (context.getFace() == Direction.DOWN) {
				return ActionResultType.PASS;
			}
			BlockState foundResult = SHOVEL_LOOKUP.get(blockstate.getBlock());
			if (foundResult != null && world.isAirBlock(blockpos.up())) {
				world.playSound(player, blockpos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
				resultToSet = foundResult;
			} else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.get(CampfireBlock.LIT)) {
				world.playEvent(null, WorldEvents.FIRE_EXTINGUISH_SOUND, blockpos, 0);
				resultToSet = blockstate.with(CampfireBlock.LIT, false);
			}
		}
		if (resultToSet == null) {
			return ActionResultType.PASS;
		}
		if (!world.isRemote) {
			world.setBlockState(blockpos, resultToSet, BlockFlags.DEFAULT_AND_RERENDER);
			if (player != null) {
				context.getItem().damageItem(1, player, onBroken -> onBroken.sendBreakAnimation(context.getHand()));
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A7c" + "\u00A7o" + "Powered by Argent Energy"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}