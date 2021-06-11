package mod.azure.doom.client.gui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class GunTableInventory implements IInventory {
	private final GunTableScreenHandler container;

	private final NonNullList<ItemStack> stacks;

	public GunTableInventory(GunTableScreenHandler container) {
		this.stacks = NonNullList.withSize(6, ItemStack.EMPTY);
		this.container = container;
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack stack : stacks) {
			if (!stack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void clearContent() {
		this.stacks.clear();
	}

	@Override
	public int getContainerSize() {
		return this.stacks.size();
	}

	@Override
	public ItemStack getItem(int slot) {
		return this.stacks.get(slot);
	}

	@Override
	public ItemStack removeItem(int slot, int amount) {
		ItemStack itemStack = ItemStackHelper.removeItem(this.stacks, slot, amount);
		if (!itemStack.isEmpty() && slot != 5) {
			this.container.onContentChanged(this);
		}
		return itemStack;
	}

	@Override
	public ItemStack removeItemNoUpdate(int slot) {
		return ItemStackHelper.takeItem(this.stacks, slot);
	}

	@Override
	public void setItem(int slot, ItemStack stack) {
		this.stacks.set(slot, stack);
		if (slot != 5)
			container.onContentChanged(this);
	}

	@Override
	public void setChanged() {

	}

	@Override
	public boolean stillValid(PlayerEntity p_70300_1_) {
		return true;
	}

}
