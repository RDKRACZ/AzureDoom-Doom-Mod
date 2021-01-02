package mod.azure.doom.entity.attack;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class RangedAttack {

	public DemonEntity parentEntity;
	public double xOffSetModifier = 2;
	public double entityHeightFraction = 0.5;
	public double zOffSetModifier = 2;
	public float damage = 1;
	
	public RangedAttack(DemonEntity parentEntity) {
		this.parentEntity = parentEntity;
	}

	public RangedAttack(DemonEntity parentEntity, double xOffSetModifier,
			double entityHeightFraction, double zOffSetModifier, float damage) {
		this.parentEntity = parentEntity;
		this.xOffSetModifier = xOffSetModifier;
		this.entityHeightFraction = entityHeightFraction;
		this.zOffSetModifier = zOffSetModifier;
		this.damage = damage;
	}
	
	public RangedAttack setProjectileOriginOffset(double x, double entityHeightFraction, double z) {
		xOffSetModifier = x;
		this.entityHeightFraction = entityHeightFraction;
		zOffSetModifier = z;
		return this;
	}
	
	public RangedAttack setDamage(float damage) {
		this.damage = damage;
		return this;
	}

	public SoundEvent sound = SoundEvents.ENTITY_ARROW_SHOOT;
	public float volume = 1.0F;
	public float pitch = 1.0F;

	public RangedAttack overrideShootSound(SoundEvent sound, float volume, float pitch) {
		this.sound = sound;
		this.volume = volume;
		this.pitch = pitch;
		return this;
	}

	public ProjectileEntity getProjectile(World world, double d2, double d3, double d4) {
		ArrowEntity arrow = new ArrowEntity(world, d2, d3, d4);
		arrow.setShooter(parentEntity);
		arrow.setDamage(damage);
		return arrow;

	}

	public void shoot() {
		LivingEntity livingentity = this.parentEntity.getAttackTarget();
		World world = this.parentEntity.getEntityWorld();
		Vector3d vector3d = this.parentEntity.getLook(1.0F);
		double d2 = livingentity.getPosX() - (this.parentEntity.getPosX() + vector3d.x * xOffSetModifier);
		double d3 = livingentity.getPosYHeight(0.5D)
				- (this.parentEntity.getPosYHeight(entityHeightFraction));
		double d4 = livingentity.getPosZ() - (this.parentEntity.getPosZ() + vector3d.z * zOffSetModifier);
		ProjectileEntity projectile = getProjectile(world, d2, d3, d4);
		projectile.setPosition(this.parentEntity.getPosX() + vector3d.x * xOffSetModifier,
				this.parentEntity.getPosYHeight(entityHeightFraction),
				this.parentEntity.getPosZ() + vector3d.z * zOffSetModifier);
		world.addEntity(projectile);
		this.parentEntity.playSound(sound, volume, pitch);
	}

}
