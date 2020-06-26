package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.SpiderdemonEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.util.ResourceLocation;

public class SpiderdemonLayer<T extends SpiderdemonEntity, M extends SpiderdemonModel<T>>
		extends AbstractEyesLayer<T, M> {
	private static final RenderType RENDER_TYPE = RenderType
			.getEyes(new ResourceLocation(DoomMod.MODID, "textures/entity/spiderdemon.png"));

	public SpiderdemonLayer(IEntityRenderer<T, M> rendererIn) {
		super(rendererIn);
	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}
}