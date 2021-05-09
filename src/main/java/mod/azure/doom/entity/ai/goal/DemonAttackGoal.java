package mod.azure.doom.entity.ai.goal;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class DemonAttackGoal extends MeleeAttackGoal {
	private final DemonEntity entity;
	private int raiseArmTicks;

	public DemonAttackGoal(DemonEntity zombieIn, double speedIn, boolean longMemoryIn) {
		super(zombieIn, speedIn, longMemoryIn);
		this.entity = zombieIn;
	}

	public void start() {
		super.start();
		this.raiseArmTicks = 0;
	}

	public boolean canUse() {
		return this.entity.getTarget() != null;
	}

	public void stop() {
		super.stop();
		this.entity.setAggressive(false);
	}

	public void tick() {
		super.tick();
		LivingEntity livingentity = this.entity.getTarget();
		if (livingentity != null) {
			++this.raiseArmTicks;
			this.entity.getLookControl().setLookAt(livingentity, 90.0F, 30.0F);
			if (livingentity.distanceToSqr(this.entity) < 1.0D) {
				if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
					this.entity.setAggressive(true);
					this.entity.setMeleeAttacking(true);
				} else {
					this.entity.setAggressive(false);
					this.entity.setMeleeAttacking(false);
				}
			}
		}
	}

	@Override
	protected double getAttackReachSqr(LivingEntity attackTarget) {
		return (double) (this.mob.getBbWidth() * 1.0F * this.mob.getBbWidth() * 1.0F + attackTarget.getBbWidth());
	}
}