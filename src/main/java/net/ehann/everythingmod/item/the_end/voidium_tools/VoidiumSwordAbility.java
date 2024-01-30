package net.ehann.everythingmod.item.the_end.voidium_tools;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class VoidiumSwordAbility {

    public VoidiumSwordAbility(ItemStack pStack, LivingEntity pAttacker) {
        Player player = pAttacker instanceof Player ? (Player)pAttacker : null;
        Level world = player.level();

        if (!world.isClientSide) {
            float playerHealth = player.getHealth();
            // Sound is not working.
            world.playSound(player, BlockPos.containing(player.position()), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.MASTER, 1, 1);

            double roll = (Math.random() * 100) + 1;

            if (roll >= 16 && roll < 84) { // 1 z-score, 68% chance of occurring
                player.setHealth(playerHealth + 1.0f);
            }
            else if (roll >= 2.5 && roll < 16 || roll >= 84 && roll < 97.5) { // 2 z-scores, 27% chance of occurring
                player.setHealth(playerHealth + 2.0f);

            }
            else if (roll < 2.5 || roll >= 97.5) { // 3 z-scores, 5% chance of occurring
                player.setHealth(playerHealth + 6.0f);
            }
        }
    }
}
