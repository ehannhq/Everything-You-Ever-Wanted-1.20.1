package net.ehann.everythingmod.item.the_end.voidium_tools.abilities;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class VoidiumSwordAbility {

    public VoidiumSwordAbility(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Player player = pAttacker instanceof Player ? (Player)pAttacker : null;
        player.playSound(SoundEvents.TOTEM_USE, 1, 1);
        float playerHealth = player.getHealth();

        double roll = (Math.random() * 100) + 1;

        if (roll >= 16 && roll < 84) { // 1 z-score
            player.setHealth(playerHealth + 2.0f);
        }
        else if (roll >= 2.5 && roll < 16 || roll >= 84 && roll < 97.5) { // 2 z-scores
            player.setHealth(playerHealth + 4.0f);

        }
        else if (roll < 2.5 || roll >= 97.5) { // 3 z-scores
            player.setHealth(playerHealth + 6.0f);

        }
    }
}
