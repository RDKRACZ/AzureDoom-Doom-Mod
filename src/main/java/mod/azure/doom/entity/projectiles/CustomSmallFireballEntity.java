package mod.azure.doom.entity.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class CustomSmallFireballEntity extends SmallFireballEntity {

	public CustomSmallFireballEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		// TODO Auto-generated constructor stub
	}
	
	private float directHitDamage = 5.0F;
	
	public void setDirectHitDamage(float f) {
		directHitDamage = f;
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		if (!this.world.isRemote) {
			Entity entity = p_213868_1_.getEntity();
			if (!entity.isImmuneToFire()) {
				Entity entity1 = this.func_234616_v_();
				int i = entity.getFireTimer();
				entity.setFire(5);
				boolean flag = entity.attackEntityFrom(DamageSource.func_233547_a_(this, entity1), directHitDamage);
				if (!flag) {
					entity.forceFireTicks(i);
				} else if (entity1 instanceof LivingEntity) {
					this.applyEnchantments((LivingEntity) entity1, entity);
				}
			}

		}
	}

}
