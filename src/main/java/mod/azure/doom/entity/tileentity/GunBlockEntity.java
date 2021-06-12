package mod.azure.doom.entity.tileentity;

import mod.azure.doom.client.gui.weapons.GunTableScreenHandler;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class GunBlockEntity extends TileEntity implements ImplementedInventory, INamedContainerProvider {

	private final NonNullList<ItemStack> items = NonNullList.withSize(6, ItemStack.EMPTY);

	public GunBlockEntity() {
		super(ModEntityTypes.GUN_TABLE_ENTITY.get());
	}

	@Override
	public Container createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
		return new GunTableScreenHandler(syncId, inventory, IWorldPosCallable.create(level, worldPosition));
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("block.doom.gun_table");
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return items;
	}

	@Override
	public void load(BlockState state, CompoundNBT tag) {
		super.load(state, tag);
		ItemStackHelper.loadAllItems(tag, items);
	}

	@Override
	public CompoundNBT save(CompoundNBT tag) {
		ItemStackHelper.saveAllItems(tag, items);
		return super.save(tag);
	}

}