package com.babcsany.minecraft.nimrod_mod_1.entity.horse;

import net.minecraft.block.SoundType;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.CoatColors;
import net.minecraft.entity.passive.horse.CoatTypes;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

public class DerhhsgxvsEntity extends AbstractHorseEntity {
   private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");
   private static final DataParameter<Integer> HORSE_VARIANT = EntityDataManager.createKey(DerhhsgxvsEntity.class, DataSerializers.VARINT);

   public DerhhsgxvsEntity(EntityType<? extends DerhhsgxvsEntity> type, World worldIn) {
      super(type, worldIn);
   }

   protected void func_230273_eI_() {
      this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double)this.getModifiedMaxHealth());
      this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(this.getModifiedMovementSpeed());
      this.getAttribute(Attributes.HORSE_JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(HORSE_VARIANT, 0);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("Variant", this.func_234241_eS_());
      if (!this.horseChest.getStackInSlot(1).isEmpty()) {
         compound.put("ArmorItem", this.horseChest.getStackInSlot(1).write(new CompoundNBT()));
      }

   }

   public ItemStack func_213803_dV() {
      return this.getItemStackFromSlot(EquipmentSlotType.CHEST);
   }

   private void func_213805_k(ItemStack p_213805_1_) {
      this.setItemStackToSlot(EquipmentSlotType.CHEST, p_213805_1_);
      this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      this.func_234242_w_(compound.getInt("Variant"));
      if (compound.contains("ArmorItem", 10)) {
         ItemStack itemstack = ItemStack.read(compound.getCompound("ArmorItem"));
         if (!itemstack.isEmpty() && this.isArmor(itemstack)) {
            this.horseChest.setInventorySlotContents(1, itemstack);
         }
      }

      this.func_230275_fc_();
   }

   private void func_234242_w_(int p_234242_1_) {
      this.dataManager.set(HORSE_VARIANT, p_234242_1_);
   }

   private int func_234241_eS_() {
      return this.dataManager.get(HORSE_VARIANT);
   }

   private void func_234238_a_(CoatColors p_234238_1_, CoatTypes p_234238_2_) {
      this.func_234242_w_(p_234238_1_.getId() & 255 | p_234238_2_.getId() << 8 & '\uff00');
   }

   public CoatColors func_234239_eK_() {
      return CoatColors.func_234254_a_(this.func_234241_eS_() & 255);
   }

   public CoatTypes func_234240_eM_() {
      return CoatTypes.func_234248_a_((this.func_234241_eS_() & '\uff00') >> 8);
   }

   protected void func_230275_fc_() {
      if (!this.world.isRemote) {
         super.func_230275_fc_();
         this.func_213804_l(this.horseChest.getStackInSlot(1));
         this.setDropChance(EquipmentSlotType.CHEST, 0.0F);
      }
   }

   private void func_213804_l(ItemStack p_213804_1_) {
      this.func_213805_k(p_213804_1_);
      if (!this.world.isRemote) {
         this.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
         if (this.isArmor(p_213804_1_)) {
            int i = ((HorseArmorItem)p_213804_1_.getItem()).getArmorValue();
            if (i != 0) {
               this.getAttribute(Attributes.ARMOR).applyNonPersistentModifier(new AttributeModifier(ARMOR_MODIFIER_UUID, "Horse armor bonus", (double)i, AttributeModifier.Operation.ADDITION));
            }
         }
      }

   }

   /**
    * Called by InventoryBasic.onInventoryChanged() on a array that is never filled.
    */
   public void onInventoryChanged(IInventory invBasic) {
      ItemStack itemstack = this.func_213803_dV();
      super.onInventoryChanged(invBasic);
      ItemStack itemstack1 = this.func_213803_dV();
      if (this.ticksExisted > 20 && this.isArmor(itemstack1) && itemstack != itemstack1) {
         this.playSound(SoundEvents.ENTITY_HORSE_ARMOR, 0.5F, 1.0F);
      }

   }

   protected void playGallopSound(SoundType p_190680_1_) {
      super.playGallopSound(p_190680_1_);
      if (this.rand.nextInt(10) == 0) {
         this.playSound(SoundEvents.ENTITY_HORSE_BREATHE, p_190680_1_.getVolume() * 0.6F, p_190680_1_.getPitch());
      }

      ItemStack stack = this.horseChest.getStackInSlot(1);
      if (isArmor(stack)) stack.onHorseArmorTick(world, this);
   }

   protected SoundEvent getAmbientSound() {
      super.getAmbientSound();
      return SoundEvents.ENTITY_HORSE_AMBIENT;
   }

   protected SoundEvent getDeathSound() {
      super.getDeathSound();
      return SoundEvents.ENTITY_HORSE_DEATH;
   }

   @Nullable
   protected SoundEvent func_230274_fe_() {
      return SoundEvents.ENTITY_HORSE_EAT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      super.getHurtSound(damageSourceIn);
      return SoundEvents.ENTITY_HORSE_HURT;
   }

   protected SoundEvent getAngrySound() {
      super.getAngrySound();
      return SoundEvents.ENTITY_HORSE_ANGRY;
   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (!this.isChild()) {
         if (this.isTame() && p_230254_1_.isSecondaryUseActive()) {
            this.openGUI(p_230254_1_);
            return ActionResultType.func_233537_a_(this.world.isRemote);
         }

         if (this.isBeingRidden()) {
            return super.func_230254_b_(p_230254_1_, p_230254_2_);
         }
      }

      if (!itemstack.isEmpty()) {
         if (this.isBreedingItem(itemstack)) {
            return this.func_241395_b_(p_230254_1_, itemstack);
         }

         ActionResultType actionresulttype = itemstack.interactWithEntity(p_230254_1_, this, p_230254_2_);
         if (actionresulttype.isSuccessOrConsume()) {
            return actionresulttype;
         }

         if (!this.isTame()) {
            this.makeMad();
            return ActionResultType.func_233537_a_(this.world.isRemote);
         }

         boolean flag = !this.isChild() && !this.isHorseSaddled() && itemstack.getItem() == Items.SADDLE;
         if (this.isArmor(itemstack) || flag) {
            this.openGUI(p_230254_1_);
            return ActionResultType.func_233537_a_(this.world.isRemote);
         }
      }

      if (this.isChild()) {
         return super.func_230254_b_(p_230254_1_, p_230254_2_);
      } else {
         this.mountTo(p_230254_1_);
         return ActionResultType.func_233537_a_(this.world.isRemote);
      }
   }

   /**
    * Returns true if the mob is currently able to mate with the specified mob.
    */
   public boolean canMateWith(AnimalEntity otherAnimal) {
      if (otherAnimal == this) {
         return false;
      } else if (!(otherAnimal instanceof DonkeyEntity) && !(otherAnimal instanceof DerhhsgxvsEntity)) {
         return false;
      } else {
         return this.canMate() && ((AbstractDerhhsgxvsEntity)otherAnimal).canMate();
      }
   }

   public AgeableEntity createChild(AgeableEntity ageable) {
      AbstractHorseEntity abstracthorseentity;
      if (ageable instanceof DonkeyEntity) {
         abstracthorseentity = EntityType.MULE.create(this.world);
      } else {
         DerhhsgxvsEntity horseentity = (DerhhsgxvsEntity)ageable;
         abstracthorseentity = EntityType.HORSE.create(this.world);
         int i = this.rand.nextInt(9);
         CoatColors coatcolors;
         if (i < 4) {
            coatcolors = this.func_234239_eK_();
         } else if (i < 8) {
            coatcolors = horseentity.func_234239_eK_();
         } else {
            coatcolors = Util.getRandomObject(CoatColors.values(), this.rand);
         }

         int j = this.rand.nextInt(5);
         CoatTypes coattypes;
         if (j < 2) {
            coattypes = this.func_234240_eM_();
         } else if (j < 4) {
            coattypes = horseentity.func_234240_eM_();
         } else {
            coattypes = Util.getRandomObject(CoatTypes.values(), this.rand);
         }

         ((DerhhsgxvsEntity)abstracthorseentity).func_234238_a_(coatcolors, coattypes);
      }

      this.setOffspringAttributes(ageable, abstracthorseentity);
      return abstracthorseentity;
   }

   public boolean func_230276_fq_() {
      return true;
   }

   public boolean isArmor(ItemStack stack) {
      return stack.getItem() instanceof HorseArmorItem;
   }

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      CoatColors coatcolors;
      if (spawnDataIn instanceof DerhhsgxvsEntity.HorseData) {
         coatcolors = ((DerhhsgxvsEntity.HorseData)spawnDataIn).variant;
      } else {
         coatcolors = Util.getRandomObject(CoatColors.values(), this.rand);
         spawnDataIn = new DerhhsgxvsEntity.HorseData(coatcolors);
      }

      this.func_234238_a_(coatcolors, Util.getRandomObject(CoatTypes.values(), this.rand));
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   public static class HorseData extends AgeableData {
      public final CoatColors variant;

      public HorseData(CoatColors p_i231557_1_) {
         this.variant = p_i231557_1_;
      }
   }
}