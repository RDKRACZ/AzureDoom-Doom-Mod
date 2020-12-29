package mod.azure.doom.entity.ai.goal;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;

public class TargetAggressorGoal extends NearestAttackableTargetGoal<PlayerEntity> {
	public TargetAggressorGoal(DemonEntity p_i45829_1_) {
		super(p_i45829_1_, PlayerEntity.class, true);
	}

	public boolean shouldExecute() {
		return ((DemonEntity) this.goalOwner).isAngry() && super.shouldExecute();
	}
}