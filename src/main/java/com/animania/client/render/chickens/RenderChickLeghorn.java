package com.animania.client.render.chickens;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.animania.client.models.ModelChick;
import com.animania.common.entities.chickens.EntityChickLeghorn;

@SideOnly(Side.CLIENT)
public class RenderChickLeghorn extends RenderLiving<EntityChickLeghorn>
{
	public RenderChickLeghorn(RenderManager rm)
	{
		super(rm, new ModelChick(), 0.2F);
	}

	@Override
	protected float handleRotationFloat(EntityChickLeghorn livingBase, float partialTicks)
	{
		float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
		float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
		return (MathHelper.sin(f) + 1.0F) * f1;
	}

	@Override
	protected void preRenderCallback(EntityChickLeghorn entityliving, float f)
	{
		preRenderScale(entityliving, f);
	}

	protected void preRenderScale(EntityChickLeghorn entity, float f)
	{
		
		float age = entity.getEntityAge();
		
		GL11.glScalef(1.0F + age, 1.0F + age, 1.0F + age); 
		

	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityChickLeghorn entity) {
		int blinkTimer = entity.blinkTimer;

		if (blinkTimer < 5 && blinkTimer >= 0) {
			return entity.getResourceLocationBlink();
		} else {
			return entity.getResourceLocation();
		}
	}
	
	

}
