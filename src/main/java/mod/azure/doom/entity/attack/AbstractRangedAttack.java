package mod.azure.doom.entity.attack;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class AbstractRangedAttack implements IRangedAttack {

	public DemonEntity parentEntity;
	public double xOffSetModifier = 2;
	public double entityHeightFraction = 0.5;
	public double zOffSetModifier = 2;
	public float damage = 1;
	public double accuracy = 0.95;

	public AbstractRangedAttack(DemonEntity parentEntity) {
		this.parentEntity = parentEntity;
	}

	public AbstractRangedAttack(DemonEntity parentEntity, double xOffSetModifier, double entityHeightFraction,
			double zOffSetModifier, float damage) {
		this.parentEntity = parentEntity;
		this.xOffSetModifier = xOffSetModifier;
		this.entityHeightFraction = entityHeightFraction;
		this.zOffSetModifier = zOffSetModifier;
		this.damage = damage;
	}

	public AbstractRangedAttack setProjectileOriginOffset(double x, double entityHeightFraction, double z) {
		xOffSetModifier = x;
		this.entityHeightFraction = entityHeightFraction;
		zOffSetModifier = z;
		return this;
	}

	public AbstractRangedAttack setDamage(float damage) {
		this.damage = damage;
		return this;
	}

	private AttackSound sound;

	public AbstractRangedAttack setSound(AttackSound sound) {
		this.sound = sound;
		return this;
	}

	public AbstractRangedAttack setSound(SoundEvent sound, float volume, float pitch) {
		this.sound = new AttackSound(sound, volume, pitch);
		return this;
	}

	public AbstractRangedAttack setAccuracy(double accuracy) {
		this.accuracy = accuracy;
		return this;
	}

	public double rollAccuracy(double directional) {
		return directional + (1.0D - accuracy) * directional * this.parentEntity.getRNG().nextGaussian();
	}

	public void shoot() {
		LivingEntity livingentity = this.parentEntity.getAttackTarget();
		World world = this.parentEntity.getEntityWorld();
		Vector3d vector3d = this.parentEntity.getLook(1.0F);
		double d2 = livingentity.getPosX() - (this.parentEntity.getPosX() + vector3d.x * xOffSetModifier);
		double d3 = livingentity.getPosYHeight(0.5D) - (this.parentEntity.getPosYHeight(entityHeightFraction));
		double d4 = livingentity.getPosZ() - (this.parentEntity.getPosZ() + vector3d.z * zOffSetModifier);
		ProjectileEntity projectile = getProjectile(world, rollAccuracy(d2), rollAccuracy(d3), rollAccuracy(d4));
		projectile.setPosition(this.parentEntity.getPosX() + vector3d.x * xOffSetModifier,
				this.parentEntity.getPosYHeight(entityHeightFraction),
				this.parentEntity.getPosZ() + vector3d.z * zOffSetModifier);
		world.addEntity(projectile);
		if (sound == null)
			getDefaultAttackSound().play(this.parentEntity);
		else
			sound.play(this.parentEntity);
	}

}
