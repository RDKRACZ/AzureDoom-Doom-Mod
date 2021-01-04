package mod.azure.doom.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class JumppadBlock extends Block {

	public JumppadBlock() {
		super(Block.Properties.create(Material.ANVIL).hardnessAndResistance(4.0F).sound(SoundType.STONE).notSolid());
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.create(0.00f, 0.0f, 0.00f, 1.0f, 0.2f, 1.0f);
	}

	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.onLivingFall(5.0F, 0.0F);
	}

	@Override
	public void onLanded(IBlockReader worldIn, Entity entityIn) {
		this.jumpEntity(entityIn);
	}

	private void jumpEntity(Entity entity) {
		Vector3d vector3d = entity.getMotion();
		if (vector3d.y < 0.0D) {
			entity.setMotion(vector3d.x, 1D, vector3d.z);
		}
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		double d0 = Math.abs(entityIn.getMotion().y);
		double d1 = 1.4D + d0 * 0.2D;
		entityIn.setMotion(entityIn.getMotion().mul(d1, 1.0D, 0.5D));
		super.onEntityWalk(worldIn, pos, entityIn);
	}

}