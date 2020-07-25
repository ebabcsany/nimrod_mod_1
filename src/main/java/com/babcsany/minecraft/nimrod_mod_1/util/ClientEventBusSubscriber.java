package com.babcsany.minecraft.nimrod_mod_1.util;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.client.entity.render.RuuuururezrzwrRender;
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
        //RenderingRegistry.registerEntityRenderingHandler(EntityInit.FREIN_ENTITY.get(), FreinEntityRender::new);
        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        //DeferredWorkQueue.runLater(() -> {
        //    ScreenManager.registerFactory(ContainerInit.ZENDIO_ENTIO_CONTAINER.get(), LeatBlockCraftingTableScreen::new);
        //});*/
    }
}
