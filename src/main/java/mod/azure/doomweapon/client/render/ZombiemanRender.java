package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.ZombiemanModel;
import mod.azure.doomweapon.entity.ZombiemanEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class ZombiemanRender extends MobRenderer<ZombiemanEntity, ZombiemanModel<ZombiemanEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/eternalzombiemen.png");

	public ZombiemanRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ZombiemanModel<ZombiemanEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(ZombiemanEntity entity) {
		return TEXTURE;
	}

}