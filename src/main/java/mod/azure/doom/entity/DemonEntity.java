package mod.azure.doom.entity;

import java.util.Random;

import mod.azure.doom.util.Config;
import mod.azure.doom.util.EntityConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class DemonEntity extends MonsterEntity {

	protected DemonEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public static boolean passPeacefulAndYCheck(EntityConfig config, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		// peaceful check
		if (p_223337_1_.getDifficulty() == Difficulty.PEACEFUL)
			return false;
		// pass through if natural spawn and using individual spawn rules
		if (!Config.SERVER.USE_INDIVIDUAL_SPAWN_RULES
				|| (reason != SpawnReason.CHUNK_GENERATION && reason != SpawnReason.NATURAL))
			return true;
		int blockY = p_223337_3_.getY();
		return blockY >= config.MIN_Y && blockY <= config.MAX_Y;
	}
	
	public void setAttacking(boolean attacking) {
		
	}

}