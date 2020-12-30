package com.babcsany.minecraft.nimrod_mod_1.util;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.client.entity.render.*;
import com.babcsany.minecraft.nimrod_mod_1.entity.QERTZUIOPUEntity;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf;
import com.babcsany.minecraft.nimrod_mod_1.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Nimrod_mod_1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.RUUUURUREZRZWR.get(), RuuuururezrzwrRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZEDGFCVXYGDGXVCGFDGCHGJVNBBFHDZRTHD_ENTITY.get(), ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ZUHDGdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf.get(), Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhfRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.QERTZUIOPU_ENTITY.get(), QERTZUIOPURender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TDIYFXFVDZTDSGFCFDC_ENTITY.get(), TDIYFXFVDZTDSGFCFDCRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SNOW_MAN_ENTITY.get(), Snow1ManRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.IEURJJFJUIJJFUHUJRIJFUHFJZUFHZUHUHZDJHJUHUGUGZFGZZZRHDGUGUGZRZ7RZZZEZDHZGEUGFDJHGUEZZRGHD_ENTITY.get(), Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdRender::new);
        //RenderingRegistry.registerEntityRenderingHandler(EntityInit.QWERTRTTT.get(), QwertrtttRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SRACH_ENTITY.get(), SrachRender::new);
        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        //DeferredWorkQueue.runLater(() -> {
        //    ScreenManager.registerFactory(ContainerInit.ZENDIO_ENTIO_CONTAINER.get(), LeatBlockCraftingTableScreen::new);
        //});*/
        /*if (DimensionType.byName(Nimrod_mod_1.EXAMPLE_DIM_TYPE) == null) {
            DimensionManager.registerDimension(Nimrod_mod_1.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null,
                    true);
        }*/
    }
}
