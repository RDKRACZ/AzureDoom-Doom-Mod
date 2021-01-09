package mod.azure.doom.entity.ai.goal;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class DemonAttackGoal extends MeleeAttackGoal {
	private final DemonEntity zombie;

	public DemonAttackGoal(DemonEntity zombieIn, double speedIn, boolean longMemoryIn) {
		super(zombieIn, speedIn, longMemoryIn);
		this.zombie = zombieIn;
	}

	public void startExecuting() {
		super.startExecuting();
	}

	public void resetTask() {
		super.resetTask();
		this.zombie.setAggroed(false);
	}

	public void tick() {
		super.tick();
		LivingEntity livingentity = this.zombie.getAttackTarget();
		this.zombie.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 30.0F);
		if (livingentity.getDistanceSq(this.zombie) < 4.0D) {
			this.zombie.setAggroed(true);
		}
	}
}