package mod.azure.doomweapon.entity.ai.goal;

import mod.azure.doomweapon.entity.LostSoulEntity;

public class LostSoulAttackGoal extends MeleeAttackGoal {
	   private final LostSoulEntity zombie;
	   private int raiseArmTicks;

	   public LostSoulAttackGoal(LostSoulEntity zombieIn, double speedIn, boolean longMemoryIn) {
	      super(zombieIn, speedIn, longMemoryIn);
	      this.zombie = zombieIn;
	   }

	   /**
	    * Execute a one shot task or start executing a continuous task
	    */
	   public void startExecuting() {
	      super.startExecuting();
	      this.raiseArmTicks = 0;
	   }

	   /**
	    * Reset the task's internal state. Called when this task is interrupted by another one
	    */
	   public void resetTask() {
	      super.resetTask();
	      this.zombie.setAggroed(false);
	   }

	   /**
	    * Keep ticking a continuous task that has already been started
	    */
	   public void tick() {
	      super.tick();
	      ++this.raiseArmTicks;
	      if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
	         this.zombie.setAggroed(true);
	      } else {
	         this.zombie.setAggroed(false);
	      }

	   }
	}