package com.animania.client.render.amphibians;

import com.animania.client.models.ModelFrog;
import com.animania.common.entities.amphibians.EntityFrogs;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFrogs<T extends EntityFrogs> extends RenderLiving<T> {// RenderPlayer
	public static final Factory FACTORY = new Factory();

	// Need to move in main class
	private static final String modid = "animania", frogsBaseDir = "textures/entity/amphibians/frogs/";
	private static final ResourceLocation[] FROGS_TEXTURE = new ResourceLocation[] {
			new ResourceLocation(modid, frogsBaseDir + "default_frog.png"),
			new ResourceLocation(modid, frogsBaseDir + "green_frog.png"),
			new ResourceLocation(modid, frogsBaseDir + "red_tree_frog.png"),
			new ResourceLocation(modid, frogsBaseDir + "blue_tree_frog.png"),
			new ResourceLocation(modid, frogsBaseDir + "yellow_tree_frog.png") };

	public RenderFrogs(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelFrog(), 0.2F);
	}

	/**
	 * Allows the render to do state modifications necessary before the model is
	 * rendered.
	 */
	protected void preRenderCallback(AbstractClientPlayer entitylivingbaseIn, float partialTickTime) {
		GlStateManager.scale(0.5D, 0.5D, 0.5D);
	}

	@Override
	protected ResourceLocation getEntityTexture(T entity) {
		switch (entity.getFrogsType()) {
		case 0:
		default:
			return FROGS_TEXTURE[0];
		case 1:
			return FROGS_TEXTURE[1];
		case 2:
			return FROGS_TEXTURE[2];
		case 3:
			return FROGS_TEXTURE[3];
		case 4:
			return FROGS_TEXTURE[4];
		case 5:
			return FROGS_TEXTURE[5];
		}
	}

	public static class Factory implements IRenderFactory<EntityFrogs> {
		@Override
		public Render<? super EntityFrogs> createRenderFor(RenderManager manager) {
			return new RenderFrogs(manager);
		}
	}
}
