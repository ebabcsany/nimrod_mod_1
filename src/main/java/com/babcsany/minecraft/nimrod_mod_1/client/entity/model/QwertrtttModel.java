package com.babcsany.minecraft.nimrod_mod_1.client.entity.model;

import com.babcsany.minecraft.nimrod_mod_1.entity.QwertrtttEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class QwertrtttModel extends EntityModel<QwertrtttEntity> {
    private final ModelRenderer head;
    private final ModelRenderer spine;
    private final ModelRenderer jaw;
    private final ModelRenderer body;
    private ModelRenderer leftProximalWing;
    private ModelRenderer leftDistalWing;
    private ModelRenderer leftForeThigh;
    private ModelRenderer leftForeLeg;
    private ModelRenderer leftForeFoot;
    private ModelRenderer leftHindThigh;
    private ModelRenderer leftHindLeg;
    private ModelRenderer leftHindFoot;
    private ModelRenderer rightProximalWing;
    private ModelRenderer rightDistalWing;
    private ModelRenderer rightForeThigh;
    private ModelRenderer rightForeLeg;
    private ModelRenderer rightForeFoot;
    private ModelRenderer rightHindThigh;
    private ModelRenderer rightHindLeg;
    private ModelRenderer rightHindFoot;
    @Nullable
    private QwertrtttEntity dragonInstance;
    private float partialTicks;

    public QwertrtttModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        float f = -16.0F;
        this.head = new ModelRenderer(this);
        this.head.addBox("upperlip", -6.0F, -1.0F, -24.0F, 12, 5, 16, 0.0F, 176, 44);
        this.head.addBox("upperhead", -8.0F, -8.0F, -10.0F, 16, 16, 16, 0.0F, 112, 30);
        this.head.mirror = true;
        this.head.addBox("scale", -5.0F, -12.0F, -4.0F, 2, 4, 6, 0.0F, 0, 0);
        this.head.addBox("nostril", -5.0F, -3.0F, -22.0F, 2, 2, 4, 0.0F, 112, 0);
        this.head.mirror = false;
        this.head.addBox("scale", 3.0F, -12.0F, -4.0F, 2, 4, 6, 0.0F, 0, 0);
        this.head.addBox("nostril", 3.0F, -3.0F, -22.0F, 2, 2, 4, 0.0F, 112, 0);
        this.jaw = new ModelRenderer(this);
        this.jaw.setRotationPoint(0.0F, 4.0F, -8.0F);
        this.jaw.addBox("jaw", -6.0F, 0.0F, -16.0F, 12, 4, 16, 0.0F, 176, 65);
        this.head.addChild(this.jaw);
        this.spine = new ModelRenderer(this);
        this.spine.addBox("box", -5.0F, -5.0F, -5.0F, 10, 10, 10, 0.0F, 192, 104);
        this.spine.addBox("scale", -1.0F, -9.0F, -3.0F, 2, 4, 6, 0.0F, 48, 0);
        this.body = new ModelRenderer(this);
        this.body.setRotationPoint(0.0F, 4.0F, 8.0F);
        this.body.addBox("body", -12.0F, 0.0F, -16.0F, 24, 24, 64, 0.0F, 0, 0);
        this.body.addBox("scale", -1.0F, -6.0F, -10.0F, 2, 6, 12, 0.0F, 220, 53);
        this.body.addBox("scale", -1.0F, -6.0F, 10.0F, 2, 6, 12, 0.0F, 220, 53);
        this.body.addBox("scale", -1.0F, -6.0F, 30.0F, 2, 6, 12, 0.0F, 220, 53);
        this.leftProximalWing = new ModelRenderer(this);
        this.leftProximalWing.mirror = true;
        this.leftProximalWing.setRotationPoint(12.0F, 5.0F, 2.0F);
        this.leftProximalWing.addBox("bone", 0.0F, -4.0F, -4.0F, 56, 8, 8, 0.0F, 112, 88);
        this.leftProximalWing.addBox("skin", 0.0F, 0.0F, 2.0F, 56, 0, 56, 0.0F, -56, 88);
        this.leftDistalWing = new ModelRenderer(this);
        this.leftDistalWing.mirror = true;
        this.leftDistalWing.setRotationPoint(56.0F, 0.0F, 0.0F);
        this.leftDistalWing.addBox("bone", 0.0F, -2.0F, -2.0F, 56, 4, 4, 0.0F, 112, 136);
        this.leftDistalWing.addBox("skin", 0.0F, 0.0F, 2.0F, 56, 0, 56, 0.0F, -56, 144);
        this.leftProximalWing.addChild(this.leftDistalWing);
        this.leftForeThigh = new ModelRenderer(this);
        this.leftForeThigh.setRotationPoint(12.0F, 20.0F, 2.0F);
        this.leftForeThigh.addBox("main", -4.0F, -4.0F, -4.0F, 8, 24, 8, 0.0F, 112, 104);
        this.leftForeLeg = new ModelRenderer(this);
        this.leftForeLeg.setRotationPoint(0.0F, 20.0F, -1.0F);
        this.leftForeLeg.addBox("main", -3.0F, -1.0F, -3.0F, 6, 24, 6, 0.0F, 226, 138);
        this.leftForeThigh.addChild(this.leftForeLeg);
        this.leftForeFoot = new ModelRenderer(this);
        this.leftForeFoot.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.leftForeFoot.addBox("main", -4.0F, 0.0F, -12.0F, 8, 4, 16, 0.0F, 144, 104);
        this.leftForeLeg.addChild(this.leftForeFoot);
        this.leftHindThigh = new ModelRenderer(this);
        this.leftHindThigh.setRotationPoint(16.0F, 16.0F, 42.0F);
        this.leftHindThigh.addBox("main", -8.0F, -4.0F, -8.0F, 16, 32, 16, 0.0F, 0, 0);
        this.leftHindLeg = new ModelRenderer(this);
        this.leftHindLeg.setRotationPoint(0.0F, 32.0F, -4.0F);
        this.leftHindLeg.addBox("main", -6.0F, -2.0F, 0.0F, 12, 32, 12, 0.0F, 196, 0);
        this.leftHindThigh.addChild(this.leftHindLeg);
        this.leftHindFoot = new ModelRenderer(this);
        this.leftHindFoot.setRotationPoint(0.0F, 31.0F, 4.0F);
        this.leftHindFoot.addBox("main", -9.0F, 0.0F, -20.0F, 18, 6, 24, 0.0F, 112, 0);
        this.leftHindLeg.addChild(this.leftHindFoot);
        this.rightProximalWing = new ModelRenderer(this);
        this.rightProximalWing.setRotationPoint(-12.0F, 5.0F, 2.0F);
        this.rightProximalWing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8, 0.0F, 112, 88);
        this.rightProximalWing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56, 0.0F, -56, 88);
        this.rightDistalWing = new ModelRenderer(this);
        this.rightDistalWing.setRotationPoint(-56.0F, 0.0F, 0.0F);
        this.rightDistalWing.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4, 0.0F, 112, 136);
        this.rightDistalWing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56, 0.0F, -56, 144);
        this.rightProximalWing.addChild(this.rightDistalWing);
        this.rightForeThigh = new ModelRenderer(this);
        this.rightForeThigh.setRotationPoint(-12.0F, 20.0F, 2.0F);
        this.rightForeThigh.addBox("main", -4.0F, -4.0F, -4.0F, 8, 24, 8, 0.0F, 112, 104);
        this.rightForeLeg = new ModelRenderer(this);
        this.rightForeLeg.setRotationPoint(0.0F, 20.0F, -1.0F);
        this.rightForeLeg.addBox("main", -3.0F, -1.0F, -3.0F, 6, 24, 6, 0.0F, 226, 138);
        this.rightForeThigh.addChild(this.rightForeLeg);
        this.rightForeFoot = new ModelRenderer(this);
        this.rightForeFoot.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.rightForeFoot.addBox("main", -4.0F, 0.0F, -12.0F, 8, 4, 16, 0.0F, 144, 104);
        this.rightForeLeg.addChild(this.rightForeFoot);
        this.rightHindThigh = new ModelRenderer(this);
        this.rightHindThigh.setRotationPoint(-16.0F, 16.0F, 42.0F);
        this.rightHindThigh.addBox("main", -8.0F, -4.0F, -8.0F, 16, 32, 16, 0.0F, 0, 0);
        this.rightHindLeg = new ModelRenderer(this);
        this.rightHindLeg.setRotationPoint(0.0F, 32.0F, -4.0F);
        this.rightHindLeg.addBox("main", -6.0F, -2.0F, 0.0F, 12, 32, 12, 0.0F, 196, 0);
        this.rightHindThigh.addChild(this.rightHindLeg);
        this.rightHindFoot = new ModelRenderer(this);
        this.rightHindFoot.setRotationPoint(0.0F, 31.0F, 4.0F);
        this.rightHindFoot.addBox("main", -9.0F, 0.0F, -20.0F, 18, 6, 24, 0.0F, 112, 0);
        this.rightHindLeg.addChild(this.rightHindFoot);
    }

    public void setLivingAnimations(QwertrtttEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        this.dragonInstance = entityIn;
        this.partialTicks = partialTick;
    }

    /**
     * Sets this entity's model rotation angles
     */
    public void setRotationAngles(QwertrtttEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        matrixStackIn.push();
        float f = MathHelper.lerp(this.partialTicks, this.dragonInstance.prevAnimTime, this.dragonInstance.animTime);
        this.jaw.rotateAngleX = (float) (Math.sin((double) (f * ((float) Math.PI * 2F))) + 1.0D) * 0.2F;
        float f1 = (float) (Math.sin((double) (f * ((float) Math.PI * 2F) - 1.0F)) + 1.0D);
        f1 = (f1 * f1 + f1 * 2.0F) * 0.05F;
        matrixStackIn.translate(0.0D, (double) (f1 - 2.0F), -3.0D);
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f1 * 2.0F));
        float f2 = 0.0F;
        float f3 = 20.0F;
        float f4 = -12.0F;
        float f5 = 1.5F;
        double[] adouble = this.dragonInstance.getMovementOffsets(6, this.partialTicks);
        float f6 = MathHelper.rotWrap(this.dragonInstance.getMovementOffsets(5, this.partialTicks)[0] - this.dragonInstance.getMovementOffsets(10, this.partialTicks)[0]);
        float f7 = MathHelper.rotWrap(this.dragonInstance.getMovementOffsets(5, this.partialTicks)[0] + (double) (f6 / 2.0F));
        float f8 = f * ((float) Math.PI * 2F);
    }
}
