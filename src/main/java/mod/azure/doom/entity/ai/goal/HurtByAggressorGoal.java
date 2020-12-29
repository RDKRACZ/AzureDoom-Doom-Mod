package mod.azure.doom.entity.ai.goal;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;

public class HurtByAggressorGoal extends HurtByTargetGoal {
	public HurtByAggressorGoal(DemonEntity p_i45828_1_) {
		super(p_i45828_1_);
		this.setCallsForHelp(new Class[] { DemonEntity.class });
	}

	protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
		if (mobIn instanceof DemonEntity && this.goalOwner.canEntityBeSeen(targetIn)
				&& ((DemonEntity) mobIn).func_226547_i_(targetIn)) {
			mobIn.setAttackTarget(targetIn);
		}

	}
}