package mod.azure.doom.entity.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class CustomFireballEntity extends FireballEntity {

	private float directHitDamage = 6.0F;

	public CustomFireballEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ,
			float directHitDamage) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		this.directHitDamage = directHitDamage;
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		if (!this.world.isRemote) {
			Entity entity = p_213868_1_.getEntity();
			Entity entity1 = this.func_234616_v_();
			entity.attackEntityFrom(DamageSource.func_233547_a_(this, entity1), directHitDamage);
			if (entity1 instanceof LivingEntity) {
				this.applyEnchantments((LivingEntity) entity1, entity);
			}

		}
	}

}
