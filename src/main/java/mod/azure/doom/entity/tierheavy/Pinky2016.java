package mod.azure.doom.entity.tierheavy;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class Pinky2016 extends PinkyEntity {

	public Pinky2016(EntityType<PinkyEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	@Override
	public int getArmorValue() {
		return 3;
	}

}