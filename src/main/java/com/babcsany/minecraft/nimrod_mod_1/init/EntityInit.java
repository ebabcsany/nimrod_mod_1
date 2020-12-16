package com.babcsany.minecraft.nimrod_mod_1.init;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.entity.QERTZUIOPUEntity;
import com.babcsany.minecraft.nimrod_mod_1.entity.TDIYFXFVDZTDSGFCFDCEntity;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.Ruuuururezrzwr;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Nimrod_mod_1.MOD_ID);

    /*public static final RegistryObject<EntityType<QwertrtttEntity>> QWERTRTTT = ENTITY_TYPES
            .register("qwertrttt",
                    () -> EntityType.Builder.<QwertrtttEntity>create(QwertrtttEntity::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Nimrod_mod_1.MOD_ID, "qwertrttt").toString()
                            ));*/
    public static final RegistryObject<EntityType<Ruuuururezrzwr>> RUUUURUREZRZWR = ENTITY_TYPES
            .register("ruuuururezrzwr",
                    () -> EntityType.Builder.<Ruuuururezrzwr>create(Ruuuururezrzwr::new, EntityClassification.MONSTER)
                            .size(0.6f, 1.95f)
                            .build(new ResourceLocation(Nimrod_mod_1.MOD_ID, "ruuuururezrzwr").toString()
                            ));
    public static final RegistryObject<EntityType<Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf>> ZUHDGdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf = ENTITY_TYPES
            .register("zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf",
                    () -> EntityType.Builder.<Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf>create(Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf::new, EntityClassification.MONSTER)
                            .size(0.6f, 1.95f)
                            .build(new ResourceLocation(Nimrod_mod_1.MOD_ID, "zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf").toString()
                            ));
    public static final RegistryObject<EntityType<ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity>> ZEDGFCVXYGDGXVCGFDGCHGJVNBBFHDZRTHD_ENTITY = ENTITY_TYPES
            .register("zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd_entity",
                    () -> EntityType.Builder.<ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity>create(ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity::new, EntityClassification.MONSTER)
                            .size(0.6f, 1.95f)
                            .build(new ResourceLocation(Nimrod_mod_1.MOD_ID, "zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd_entity").toString()
                            ));
    public static final RegistryObject<EntityType<QERTZUIOPUEntity>> QERTZUIOPU_ENTITY = ENTITY_TYPES
            .register("qertzuiopu",
                    () -> EntityType.Builder.<QERTZUIOPUEntity>create(QERTZUIOPUEntity::new, EntityClassification.MISC)
                            .size(0.6f, 1.95f).immuneToFire()
                            .build(new ResourceLocation(Nimrod_mod_1.MOD_ID, "qertzuiopu").toString()
                            ));
    public static final RegistryObject<EntityType<TDIYFXFVDZTDSGFCFDCEntity>> TDIYFXFVDZTDSGFCFDC_ENTITY = ENTITY_TYPES
            .register("tdiyfxfvdztdsgfcfdc",
                    () -> EntityType.Builder.<TDIYFXFVDZTDSGFCFDCEntity>create(TDIYFXFVDZTDSGFCFDCEntity::new, EntityClassification.MISC)
                            .size(0.6f, 1.95f).immuneToFire()
                            .build(new ResourceLocation(Nimrod_mod_1.MOD_ID, "tdiyfxfvdztdsgfcfdc").toString()
                            ));
    /*public static final RegistryObject<EntityType<MinecartEntity1>> MINECART = ENTITY_TYPES
            .register("minecart_entity",
                    () -> EntityType.Builder.<MinecartEntity1>create(MinecartEntity1::new, EntityClassification.MISC)
                            .size(0.98f, 0.7f)
                            .build(new ResourceLocation(Nimrod_mod_1.MOD_ID, "minecart").toString()
                            ));*/
}

