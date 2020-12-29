package mod.azure.doom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class DemonEntity extends MonsterEntity {

	private int angerLevel;

	protected DemonEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public boolean func_226547_i_(LivingEntity p_226547_1_) {
		this.setRevengeTarget(p_226547_1_);
		return true;
	}

	public boolean isAngry() {
		return this.angerLevel > 0;
	}

}