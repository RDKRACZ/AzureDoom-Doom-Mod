package mod.azure.doom.util;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class MyExplosions extends Explosion {

	private final World world;
	private final double x;
	private final double y;
	private final double z;
	@Nullable
	private final Entity exploder;
	private final float size;

	public MyExplosions(World worldIn, Entity exploderIn, double xIn, double yIn, double zIn, float sizeIn) {
		super(worldIn, exploderIn, xIn, yIn, zIn, sizeIn, false, Explosion.Mode.NONE);
		this.world = worldIn;
		this.exploder = exploderIn;
		this.size = sizeIn;
		this.x = xIn;
		this.y = yIn;
		this.z = zIn;
	}

	@Override
	public void doExplosionA() {

		float f2 = this.size * 2.0F;
		int k1 = MathHelper.floor(this.x - (double) f2 - 1.0D);
		int l1 = MathHelper.floor(this.x + (double) f2 + 1.0D);
		int i2 = MathHelper.floor(this.y - (double) f2 - 1.0D);
		int i1 = MathHelper.floor(this.y + (double) f2 + 1.0D);
		int j2 = MathHelper.floor(this.z - (double) f2 - 1.0D);
		int j1 = MathHelper.floor(this.z + (double) f2 + 1.0D);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this.exploder,
				new AxisAlignedBB((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
		net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(this.world, this, list, f2);
		Vec3d vector3d = new Vec3d(this.x, this.y, this.z);

		for (int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			if (!(entity instanceof ServerPlayerEntity) && (entity instanceof MonsterEntity)
					|| (entity instanceof SlimeEntity) || (entity instanceof PhantomEntity)
					|| (entity instanceof ShulkerEntity)) {
				double d12 = (double) (MathHelper.sqrt(entity.getDistanceSq(vector3d)) / f2);
				if (d12 <= 1.0D) {
					double d5 = entity.getPosX() - this.x;
					double d7 = (entity instanceof TNTEntity ? entity.getPosY() : entity.getPosYEye()) - this.y;
					double d9 = entity.getPosZ() - this.z;
					double d13 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7 + d9 * d9);
					if (d13 != 0.0D) {
						entity.attackEntityFrom(this.getDamageSource(), 100);
					}
				}
			}
		}

	}

}
