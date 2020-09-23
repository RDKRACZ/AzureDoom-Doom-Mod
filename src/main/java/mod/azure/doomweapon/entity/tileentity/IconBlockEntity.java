package mod.azure.doomweapon.entity.tileentity;

import javax.annotation.Nullable;

import mod.azure.doomweapon.util.registry.ModEntityTypes;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class IconBlockEntity extends TileEntity {

	public IconBlockEntity() {
		super(ModEntityTypes.ICON.get());
	}

	@Override
	public void markDirty() {
		super.markDirty();
	}

	@Override
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, 12, this.getUpdateTag());
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.read(pkt.getNbtCompound());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public double getMaxRenderDistanceSquared() {
		return 65536.0D;
	}

}