package mod.azure.doom.entity.ai.goal;

import java.util.EnumSet;

import mod.azure.doom.entity.DemonEntity;
import mod.azure.doom.entity.attack.RangedAttack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.Hand;

public class RangedStrafeAttackGoal extends Goal {
	private final DemonEntity entity;
	private double moveSpeedAmp = 1;
	private int attackCooldown;
	private int visibleTicksDelay = 20;
	private float maxAttackDistance = 20;
	private int strafeTicks = 20;
	private int attackTime = -1;
	private int seeTime;
	private boolean strafingClockwise;
	private boolean strafingBackwards;
	private int strafingTime = -1;

	private RangedAttack attack;

	public RangedStrafeAttackGoal(DemonEntity mob, RangedAttack attack, double moveSpeedAmpIn, int attackCooldownIn,
			int visibleTicksDelay, int strafeTicks, float maxAttackDistanceIn) {
		this.entity = mob;
		this.moveSpeedAmp = moveSpeedAmpIn;
		this.attackCooldown = attackCooldownIn;
		this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		this.attack = attack;
		this.visibleTicksDelay = visibleTicksDelay;
		this.strafeTicks = strafeTicks;
	}
	
	//use defaults
	public RangedStrafeAttackGoal(DemonEntity mob, RangedAttack attack, int attackCooldownIn) {
		this.entity = mob;
		this.attackCooldown = attackCooldownIn;
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		this.attack = attack;
	}

	public void setAttackCooldown(int attackCooldownIn) {
		this.attackCooldown = attackCooldownIn;
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state
	 * necessary for execution in this method as well.
	 */
	public boolean shouldExecute() {
		return this.entity.getAttackTarget() != null;
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean shouldContinueExecuting() {
		return (this.shouldExecute() || !this.entity.getNavigator().noPath());
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting() {
		super.startExecuting();
		this.entity.setAggroed(true);
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by
	 * another one
	 */
	public void resetTask() {
		super.resetTask();
		this.entity.setAggroed(false);
		this.seeTime = 0;
		this.attackTime = -1;
		this.entity.resetActiveHand();
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	public void tick() {
		LivingEntity livingentity = this.entity.getAttackTarget();
		if (livingentity != null) {
			double distanceToTargetSq = this.entity.getDistanceSq(livingentity.getPosX(), livingentity.getPosY(),
					livingentity.getPosZ());
			boolean inLineOfSight = this.entity.getEntitySenses().canSee(livingentity);
	         if (inLineOfSight != this.seeTime > 0) {
	            this.seeTime = 0;
	         }

	         if (inLineOfSight) {
	            ++this.seeTime;
	         } else {
	            --this.seeTime;
	         }

			if (distanceToTargetSq <= (double) this.maxAttackDistance && this.seeTime >= 20) {
				this.entity.getNavigator().clearPath();
				++this.strafingTime;
			} else {
				this.entity.getNavigator().tryMoveToEntityLiving(livingentity, this.moveSpeedAmp);
				this.strafingTime = -1;
			}

			if (this.strafingTime >= strafeTicks) {
				if ((double) this.entity.getRNG().nextFloat() < 0.3D) {
					this.strafingClockwise = !this.strafingClockwise;
				}

				if ((double) this.entity.getRNG().nextFloat() < 0.3D) {
					this.strafingBackwards = !this.strafingBackwards;
				}

				this.strafingTime = 0;
			}

			if (this.strafingTime > -1) {
				if (distanceToTargetSq > (double) (this.maxAttackDistance * 0.75F)) {
					this.strafingBackwards = false;
				} else if (distanceToTargetSq < (double) (this.maxAttackDistance * 0.25F)) {
					this.strafingBackwards = true;
				}

				this.entity.getMoveHelper().strafe(this.strafingBackwards ? -0.5F : 0.5F,
						this.strafingClockwise ? 0.5F : -0.5F);
				this.entity.faceEntity(livingentity, 30.0F, 30.0F);
			} else {
				this.entity.getLookController().setLookPositionWithEntity(livingentity, 30.0F, 30.0F);
			}
			
			//attack
			if (this.seeTime >= this.visibleTicksDelay) {
				if (this.attackTime >= this.attackCooldown) {
					this.attack.shoot();
					this.attackTime = 0;
				} else
					this.attackTime++;
			}
			
			this.entity.setAttacking(this.attackTime >= this.attackCooldown - this.attackCooldown * 0.25);
//			if (!flag && this.seeTime < -60) {
//				this.entity.resetActiveHand();
//			} else if (flag) {
//				int i = this.entity.getItemInUseMaxCount();
//				if (i >= 20) {
//					attack.shoot();
//					this.attackTime = this.attackCooldown;
//				}
//
//			}

		}
	}
}
