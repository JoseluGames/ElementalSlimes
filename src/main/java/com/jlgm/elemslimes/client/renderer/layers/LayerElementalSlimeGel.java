package com.jlgm.elemslimes.client.renderer.layers;

import com.jlgm.elemslimes.client.renderer.entity.RenderElementalSlime;
import com.jlgm.elemslimes.entity.monster.EntityElementalSlime;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public class LayerElementalSlimeGel implements LayerRenderer<EntityElementalSlime> {
	
    private final RenderElementalSlime slimeRenderer;
    private final ModelBase slimeModel = new ModelSlime(0);

    public LayerElementalSlimeGel(RenderElementalSlime slimeRendererIn)
    {
        this.slimeRenderer = slimeRendererIn;
    }

    public void doRenderLayer(EntityElementalSlime entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (!entitylivingbaseIn.isInvisible())
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.slimeModel.setModelAttributes(this.slimeRenderer.getMainModel());
            this.slimeModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}
