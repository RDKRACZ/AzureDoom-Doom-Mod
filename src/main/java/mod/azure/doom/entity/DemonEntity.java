package mod.azure.doom.entity;

import java.util.Random;
import java.util.UUID;

import mod.azure.doom.util.config.Config;
import mod.azure.doom.util.config.EntityConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IAngerable;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.RangedInteger;
import net.minecraft.util.TickRangeConverter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class DemonEntity extends MonsterEntity implements IAngerable {

	private static final DataParameter<Integer> ANGER_TIME = EntityDataManager.createKey(DemonEntity.class,
			DataSerializers.VARINT);
	private static final RangedInteger ANGER_TIME_RANGE = TickRangeConverter.convertRange(20, 39);
	private UUID targetUuid;

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

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(ANGER_TIME, 0);
	}

	@Override
	public int getAngerTime() {
		return this.dataManager.get(ANGER_TIME);
	}

	@Override
	public void setAngerTime(int time) {
		this.dataManager.set(ANGER_TIME, time);
	}

	@Override
	public UUID getAngerTarget() {
		return this.targetUuid;
	}

	@Override
	public void setAngerTarget(UUID target) {
		this.targetUuid = target;
	}

	@Override
	public void func_230258_H__() {
		this.setAngerTime(ANGER_TIME_RANGE.getRandomWithinRange(this.rand));
	}

}