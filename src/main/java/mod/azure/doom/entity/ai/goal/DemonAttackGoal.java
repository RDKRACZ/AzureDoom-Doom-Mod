package mod.azure.doom.entity.ai.goal;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class DemonAttackGoal extends MeleeAttackGoal {
	private final DemonEntity zombie;
	private int raiseArmTicks;

	public DemonAttackGoal(DemonEntity zombieIn, double speedIn, boolean longMemoryIn) {
		super(zombieIn, speedIn, longMemoryIn);
		this.zombie = zombieIn;
	}

	public void start() {
		super.start();
		this.raiseArmTicks = 0;
	}

	public boolean canUse() {
		return this.zombie.getTarget() != null;
	}

	public void stop() {
		super.stop();
		this.zombie.setAggressive(false);
	}

	public void tick() {
		super.tick();
		++this.raiseArmTicks;
		LivingEntity livingentity = this.zombie.getTarget();
		this.zombie.getLookControl().setLookAt(livingentity, 90.0F, 30.0F);
		if (livingentity.distanceToSqr(this.zombie) < 1.0D) {
			if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
				this.zombie.setAggressive(true);
			} else {
				this.zombie.setAggressive(false);
			}
		}

	}

	@Override
	protected double getAttackReachSqr(LivingEntity attackTarget) {
		return (double) (this.mob.getBbWidth() * 1.0F * this.mob.getBbWidth() * 1.0F + attackTarget.getBbWidth());
	}
}