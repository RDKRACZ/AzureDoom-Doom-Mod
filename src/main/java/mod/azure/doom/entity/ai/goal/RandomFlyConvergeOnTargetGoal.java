package mod.azure.doom.entity.ai.goal;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;

public class RandomFlyConvergeOnTargetGoal extends Goal {
	private final DemonEntity parentEntity;
	private double flySpeed = 1;
	private double convergeDistance = 200;
	private double convergenceAdherence = 0.25;

	/**
	 * 
	 * @param entity
	 * @param flySpeed The flying speed of the entity.
	 * @param convergeDistance The distance in blocks from the target at which the entity starts to trend towards moving back towards it.
	 * @param convergenceAdherence The strength of the convergence. Max value is 1, default 0.25.
	 */
	public RandomFlyConvergeOnTargetGoal(DemonEntity entity, double flySpeed, double convergeDistance, double convergenceAdherence) {
		this.parentEntity = entity;
		this.flySpeed = flySpeed;
		this.convergeDistance = convergeDistance * convergeDistance;
		this.convergenceAdherence = convergenceAdherence;
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	public boolean shouldExecute() {
		MovementController movementcontroller = this.parentEntity.getMoveHelper();
		if (!movementcontroller.isUpdating()) {
			return true;
		} else {
			double d0 = movementcontroller.getX() - this.parentEntity.getPosX();
			double d1 = movementcontroller.getY() - this.parentEntity.getPosY();
			double d2 = movementcontroller.getZ() - this.parentEntity.getPosZ();
			double d3 = d0 * d0 + d1 * d1 + d2 * d2;
			return d3 < 1.0D || d3 > 10.0D;
		}
	}

	public boolean shouldContinueExecuting() {
		return false;
	}
	
	public boolean shouldConverge(LivingEntity target) {
		return target != null && this.parentEntity.getDistanceSq(target) >= convergeDistance;
	}

	public void startExecuting() {
		LivingEntity target = this.parentEntity.getAttackTarget();
		boolean converge = shouldConverge(target);
		Random random = this.parentEntity.getRNG();
		double d0 = this.parentEntity.getPosX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
		double d1 = this.parentEntity.getPosY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
		double d2 = this.parentEntity.getPosZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
		
		if (converge) {
			double xDifference = target.getPosX() - this.parentEntity.getPosX();
			double yDifference = target.getPosY() - this.parentEntity.getPosY();
			double zDifference = target.getPosZ() - this.parentEntity.getPosZ();
			double maxAbs = Math.max(Math.abs(xDifference), Math.abs(yDifference));
			maxAbs = Math.max(maxAbs, Math.abs(zDifference));
			d0 += 2 * xDifference/maxAbs * convergenceAdherence;
			d1 += 2 * yDifference/maxAbs * convergenceAdherence;
			d2 += 2 * zDifference/maxAbs * convergenceAdherence;
		}
		this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, flySpeed);
	}
}
