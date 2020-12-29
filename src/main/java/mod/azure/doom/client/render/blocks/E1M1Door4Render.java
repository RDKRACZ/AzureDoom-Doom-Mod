package mod.azure.doom.client.render.blocks;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.models.blocks.E1M1Door4Model;
import mod.azure.doom.entity.tileentity.E1M1Door4Entity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class E1M1Door4Render extends GeoBlockRenderer<E1M1Door4Entity> {
	public E1M1Door4Render(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn, new E1M1Door4Model());
	}
	
	@Override
	public RenderType getRenderType(E1M1Door4Entity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}