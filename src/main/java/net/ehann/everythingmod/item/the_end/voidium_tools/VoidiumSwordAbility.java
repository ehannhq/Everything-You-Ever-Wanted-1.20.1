package net.ehann.everythingmod.item.the_end.voidium_tools;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;

public class VoidiumSwordAbility {
    public VoidiumSwordAbility(Player pPlayer, double proportion) {
        if (proportion == 1.00) {
            pPlayer.addEffect(new MobEffectInstance( // SPEED
                    MobEffect.byId(1), 300, 1, true, true, true));
            pPlayer.addEffect(new MobEffectInstance(
                    MobEffect.byId(10), 300, 1, true, true, true));
            pPlayer.addEffect(new MobEffectInstance( // STRENGTH
                    MobEffect.byId(5), 300, 1, true, true, true));
        }
        else if (proportion >= 0.70) {
            pPlayer.addEffect(new MobEffectInstance( // SPEED
                    MobEffect.byId(1), 300, 1, true, true, true));
            pPlayer.addEffect(new MobEffectInstance( // REGEN
                    MobEffect.byId(10), 240, 1, true, true, true));
            pPlayer.addEffect(new MobEffectInstance( // STRENGTH
                    MobEffect.byId(5), 200, 1, true, true, true));
        }
        else if (proportion >= 0.50) {
            pPlayer.addEffect(new MobEffectInstance( // SPEED
                    MobEffect.byId(1), 300, 1, true, true, true));
            pPlayer.addEffect(new MobEffectInstance( // REGEN
                    MobEffect.byId(10), 240, 1, true, true, true));
            pPlayer.addEffect(new MobEffectInstance( // STRENGTH
                    MobEffect.byId(5), 200, 0, true, true, true));
        }
        else if (proportion >= 0.30) {
            pPlayer.addEffect(new MobEffectInstance( // SPEED
                    MobEffect.byId(1), 300, 1, true, true, true));
            pPlayer.addEffect(new MobEffectInstance( // REGEN
                    MobEffect.byId(10), 240, 0, true, true, true));
            pPlayer.addEffect(new MobEffectInstance( // STRENGTH
                    MobEffect.byId(5), 200, 0, true, true, true));
        }
        else if(proportion >= 0.10) {
            pPlayer.addEffect(new MobEffectInstance( // SPEED
                    MobEffect.byId(1), 300, 0, true, true, true));
            pPlayer.addEffect(new MobEffectInstance( // REGEN
                    MobEffect.byId(10), 240, 0, true, true, true));
        }
        else {
            pPlayer.addEffect(new MobEffectInstance( // SPEED
                    MobEffect.byId(1), 300, 0, true, true, true));
        }
    }
}
