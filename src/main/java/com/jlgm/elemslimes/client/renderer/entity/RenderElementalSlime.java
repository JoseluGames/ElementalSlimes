package com.jlgm.elemslimes.client.renderer.entity;

import javax.annotation.Nonnull;

import com.jlgm.elemslimes.client.renderer.layers.LayerElementalSlimeGel;
import com.jlgm.elemslimes.entity.monster.EntityElementalSlime;
import com.jlgm.elemslimes.lib.ElemSlimesConstants;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerSlimeGel;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderElementalSlime extends RenderLiving<EntityElementalSlime>{
	
	public static final Factory FACTORY = new Factory();

	public RenderElementalSlime(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelSlime(16), 0.25F);
        this.addLayer(new LayerElementalSlimeGel(this));
	}

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityElementalSlime entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        this.shadowSize = 0.25F * (float)entity.getSlimeSize();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityElementalSlime entitylivingbaseIn, float partialTickTime)
    {
        float f = 0.999F;
        GlStateManager.scale(0.999F, 0.999F, 0.999F);
        float f1 = (float)entitylivingbaseIn.getSlimeSize();
        float f2 = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }
	
	@Override
	@Nonnull
	protected ResourceLocation getEntityTexture(@Nonnull EntityElementalSlime entity) {
		return new ResourceLocation(ElemSlimesConstants.MODID, "textures/entity/elementalslime/" + entity.getType() + ".png");
	}
	
	public static class Factory implements IRenderFactory<EntityElementalSlime> {
		
		@Override
		public Render<? super EntityElementalSlime> createRenderFor(RenderManager manager) {
			return new RenderElementalSlime(manager);
		}
	}

}
