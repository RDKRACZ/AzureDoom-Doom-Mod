package mod.azure.doom.entity.ai.goal;

import mod.azure.doom.entity.DemonEntity;
import mod.azure.doom.entity.attack.AbstractRangedAttack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

public class RangedStaticAttackGoal extends Goal{

		private final DemonEntity parentEntity;
		public int attackTimer;
		private AbstractRangedAttack attack;
		private int attackCooldown;
		private int visibleTicksDelay = 20;
		private float maxAttackDistance = 20;
		private int seeTime = -1;

		public RangedStaticAttackGoal(DemonEntity mob, AbstractRangedAttack attack, int attackCooldownIn,
				int visibleTicksDelay, float maxAttackDistanceIn) {
			this.parentEntity = mob;
			this.attackCooldown = attackCooldownIn;
			this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
			this.attack = attack;
			this.visibleTicksDelay = visibleTicksDelay;
		}
		
		public boolean shouldExecute() {
			return this.parentEntity.getAttackTarget() != null;
		}

		public void startExecuting() {
			this.attackTimer = 0;
		}

		public void resetTask() {
			this.parentEntity.setAttacking(false);
		}

		public void tick() {
			LivingEntity livingentity = this.parentEntity.getAttackTarget();
			boolean inLineOfSight = this.parentEntity.getEntitySenses().canSee(livingentity);
	         if (inLineOfSight != this.seeTime > 0) {
	            this.seeTime = 0;
	         }
	         if (inLineOfSight) {
	            ++this.seeTime;
	         } else {
	            --this.seeTime;
	         }
			if (livingentity.getDistanceSq(this.parentEntity) < this.maxAttackDistance
					&& this.seeTime >= this.visibleTicksDelay) {
				this.parentEntity.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 30.0F);
				++this.attackTimer;

				if (this.attackTimer == this.attackCooldown) {
					attack.shoot();
					this.attackTimer = 0;
				}
			} else if (this.attackTimer > 0) {
				--this.attackTimer;
			}
			this.parentEntity.setAttacking(attackTimer >= attackCooldown * 0.75);
		}
	
}
