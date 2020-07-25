package com.babcsany.minecraft.nimrod_mod_1.init;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
//import com.babcsany.minecraft.nimrod_mod_1.entity.animal.qwertrttt;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.Ruuuururezrzwr;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            Nimrod_mod_1.MOD_ID);

  /*  public static final RegistryObject<EntityType<qwertrttt>> QWERTRTTT = ENTITY_TYPES
            .register("qwertrttt",
                    () -> EntityType.Builder.<qwertrttt>create(qwertrttt::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Nimrod_mod_1.MOD_ID, "qwertrttt").toString()));
*/
    public static final RegistryObject<EntityType<Ruuuururezrzwr>> RUUUURUREZRZWR = ENTITY_TYPES
            .register("ruuuururezrzwr",
                    () -> EntityType.Builder.<Ruuuururezrzwr>create(Ruuuururezrzwr::new, EntityClassification.MONSTER)
                            .size(0.6f, 1.95f)
                            .build(new ResourceLocation(Nimrod_mod_1.MOD_ID, "ruuuururezrzwr").toString()));

}
