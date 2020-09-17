package mod.azure.doom.item.eggs;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import mod.azure.doom.DoomMod;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;

public class DoomSpawnEgg extends SpawnEggItem {
	private Supplier<? extends EntityType<?>> typeGetter;

	public DoomSpawnEgg(Supplier<? extends EntityType<?>> typeIn, int primaryColorIn, int secondaryColorIn) {
		super(null, primaryColorIn, secondaryColorIn,
				new Item.Properties().maxStackSize(1).group(DoomMod.DoomEggItemGroup));
		typeGetter = typeIn;
	}

	@Override
	public EntityType<?> getType(@Nullable CompoundNBT p_208076_1_) {
		return typeGetter.get();
	}

}