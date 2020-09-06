package mod.azure.doomweapon.block;

import mod.azure.doomweapon.entity.projectiles.BarrelEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BarrelBlock extends Block {
	public static final DirectionProperty direction = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty light = RedstoneTorchBlock.LIT;

	public BarrelBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(
				this.stateContainer.getBaseState().with(direction, Direction.NORTH).with(light, Boolean.valueOf(true)));
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosionIn) {
		return false;
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 300;
	}

	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return true;
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		catchFire(state, worldIn, pos, null, null);
		worldIn.removeBlock(pos, false);
	}

	@Override
	public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
		if (!worldIn.isRemote) {
			BarrelEntity tntentity = new BarrelEntity(worldIn, (double) pos.getX() + 0.5D, (double) pos.getY(),
					(double) pos.getZ() + 0.5D, explosionIn.getExplosivePlacedBy());
			worldIn.addEntity(tntentity);
		}
	}

	@Override
	public void catchFire(BlockState state, World world, BlockPos pos, Direction face, LivingEntity igniter) {
		if (!world.isRemote) {
			BarrelEntity tntentity = new BarrelEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY(),
					(double) pos.getZ() + 0.5D, igniter);
			;
			world.addEntity(tntentity);
		}
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!worldIn.isRemote() && !player.isCreative()) {
			catchFire(state, worldIn, pos, null, null);
		}

		super.onBlockHarvested(worldIn, pos, state, player);
	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getHeldItem(handIn);
		Item item = itemstack.getItem();
		if (item != Items.FLINT_AND_STEEL && item != Items.FIRE_CHARGE) {
			return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
		} else {
			catchFire(state, worldIn, pos, hit.getFace(), player);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
			if (!player.isCreative()) {
				if (item == Items.FLINT_AND_STEEL) {
					itemstack.damageItem(1, player, (player1) -> {
						player1.sendBreakAnimation(handIn);
					});
				} else {
					itemstack.shrink(1);
				}
			}

			return ActionResultType.SUCCESS;
		}
	}

	@Override
	public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, Entity projectile) {
		if (!worldIn.isRemote) {
			AbstractArrowEntity abstractarrowentity = (AbstractArrowEntity) projectile;
			Entity entity = abstractarrowentity.getShooter();
			BlockPos blockpos = hit.getPos();
			catchFire(state, worldIn, blockpos, null, entity instanceof LivingEntity ? (LivingEntity) entity : null);
			worldIn.removeBlock(blockpos, false);
		}

	}

	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		return 10;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(direction, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(direction, rot.rotate(state.get(direction)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(direction)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(direction, light);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		return VoxelShapes.create(0.06f, 0f, 0.06f, 0.94f, 1.0f, 0.94f);
	}

}