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

	public void startExecuting() {
		super.startExecuting();
		this.raiseArmTicks = 0;
	}

	public void resetTask() {
		super.resetTask();
		this.zombie.setAggroed(false);
	}

	public void tick() {
		super.tick();
		++this.raiseArmTicks;
		LivingEntity livingentity = this.zombie.getAttackTarget();
		this.zombie.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 30.0F);
		if (livingentity.getDistanceSq(this.zombie) < 8.0D) {
			if (this.raiseArmTicks >= 5 && this.func_234041_j_() < this.func_234042_k_() / 2) {
				this.zombie.setAggroed(true);
			} else {
				this.zombie.setAggroed(false);
			}
		}

	}
}