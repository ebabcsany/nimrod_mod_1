package com.babcsany.minecraft.nimrod_mod_1.init;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.container.CraftingBlockContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Nimrod_mod_1.MOD_ID);

    public static final RegistryObject<ContainerType<CraftingBlockContainer>> CRAFTING_BLOCK = CONTAINER_TYPES
            .register("crafting_block", () -> IForgeContainerType.create(CraftingBlockContainer::new));
}
