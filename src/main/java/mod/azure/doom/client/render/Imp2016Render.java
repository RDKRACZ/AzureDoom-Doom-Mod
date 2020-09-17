package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.Imp2016Model;
import mod.azure.doom.entity.Imp2016Entity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Imp2016Render extends MobRenderer<Imp2016Entity, Imp2016Model<Imp2016Entity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/imp2016.png");

	public Imp2016Render(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new Imp2016Model<Imp2016Entity>(0.5f, false), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(Imp2016Entity entity) {
		return TEXTURE;
	}

}