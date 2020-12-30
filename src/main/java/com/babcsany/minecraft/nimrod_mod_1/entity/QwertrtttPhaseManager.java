package com.babcsany.minecraft.nimrod_mod_1.entity;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.IPhase;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QwertrtttPhaseManager {
   private static final Logger LOGGER = LogManager.getLogger();
   private final QwertrtttEntity dragon;
   private final IPhase[] phases = new IPhase[PhaseType.getTotalPhases()];
   private IPhase phase;

   public QwertrtttPhaseManager(QwertrtttEntity dragonIn) {
      this.dragon = dragonIn;
      this.setPhase(PhaseType.HOVER);
   }

   public void setPhase(PhaseType<?> phaseIn) {
      if (this.phase == null || phaseIn != this.phase.getType()) {
         if (this.phase != null) {
            this.phase.removeAreaEffect();
         }

         this.phase = this.getPhase(phaseIn);
         if (!this.dragon.world.isRemote) {
            this.dragon.getDataManager().set(QwertrtttEntity.PHASE, phaseIn.getId());
         }

         LOGGER.debug("Dragon is now in phase {} on the {}", phaseIn, this.dragon.world.isRemote ? "client" : "server");
         this.phase.initPhase();
      }
   }

   public IPhase getCurrentPhase() {
      return this.phase;
   }

   public <T extends IPhase> T getPhase(PhaseType<T> phaseIn) {
      int i = phaseIn.getId();
      if (this.phases[i] == null) {
         //this.phases[i] = phaseIn.createPhase(this.dragon);
      }

      return (T)this.phases[i];
   }
}