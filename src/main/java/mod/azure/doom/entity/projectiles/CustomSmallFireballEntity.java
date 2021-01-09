package mod.azure.doom.entity.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CustomSmallFireballEntity extends SmallFireballEntity {

	private float directHitDamage = 5.0F;

	public CustomSmallFireballEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ,
			float directHitDamage) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		this.directHitDamage = directHitDamage;
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (!this.world.isRemote) {
			if (result.getType() == RayTraceResult.Type.ENTITY) {
				Entity entity = ((EntityRayTraceResult) result).getEntity();
				if (!entity.isImmuneToFire()) {
					int i = entity.getFireTimer();
					entity.setFire(5);
					boolean flag = entity.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity),
							directHitDamage);
					if (flag) {
						this.applyEnchantments(this.shootingEntity, entity);
					} else {
						entity.setFireTimer(i);
					}
				}
			}
			this.remove();
		}
	}

}
