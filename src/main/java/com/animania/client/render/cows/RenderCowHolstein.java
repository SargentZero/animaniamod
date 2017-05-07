package com.animania.client.render.cows;

import java.util.Random;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.animania.client.models.ModelCow;
import com.animania.common.entities.cows.EntityCowHolstein;

@SideOnly(Side.CLIENT)
public class RenderCowHolstein extends RenderLiving
{
    private static final ResourceLocation cowTextures = new ResourceLocation("animania:textures/entity/cows/cow_holstein.png");
    private static final ResourceLocation cowTexturesBlink = new ResourceLocation("animania:textures/entity/cows/cow_holstein_blink.png");
    Random rand = new Random();
    
    public RenderCowHolstein(RenderManager rm)
   	{
   		super(rm, new ModelCow(), 0.5F);
   	}

    protected ResourceLocation getCowTextures(EntityCowHolstein par1EntityCow)
    {
        return cowTextures;
    }
    
    protected ResourceLocation getCowTexturesBlink(EntityCowHolstein par1EntityCow)
    {
        return cowTexturesBlink;
    }

    protected void preRenderScale(EntityCowHolstein entity, float f)
    {
        GL11.glScalef(1.24F, 1.24F, 1.24F); 
    }

	@Override
    protected void preRenderCallback(EntityLivingBase entityliving, float f)
    {
        preRenderScale((EntityCowHolstein)entityliving, f);
    }  
  
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		EntityCowHolstein entity = (EntityCowHolstein)par1Entity;

		int blinkTimer = entity.blinkTimer;

		if (blinkTimer < 7 && blinkTimer >= 0) {
			return this.getCowTexturesBlink(entity);
		} else {
			return this.getCowTextures(entity);
		}

	}
}
