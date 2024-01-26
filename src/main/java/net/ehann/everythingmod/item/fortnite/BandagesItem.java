package net.ehann.everythingmod.item.fortnite;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.Nullable;


import java.util.List;

public class BandagesItem extends PotionItem {
    public BandagesItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 70;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player)pEntityLiving : null;
        if (!pLevel.isClientSide) {
            float currentHealth = player.getHealth();
            float maxHealing = player.getMaxHealth() * 0.75f;
            if (currentHealth < maxHealing) {
                float newHealth = player.getHealth() + 3.0f;
                if (newHealth > maxHealing)
                    newHealth = maxHealing;

                player.setHealth(newHealth);
            }
            else {
                player.sendSystemMessage(Component.literal("§cYou can't use this item anymore!"));
                pLevel.playSound(player, BlockPos.containing(player.position()), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.MASTER, 1, 1);
            }
        }
        return pStack;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("§7Ol' Reliable"));
        pTooltip.add(Component.literal(""));
        pTooltip.add(Component.translatable("category.everythingmod.fortnite"));
    }

    @Override
    public Component getName(ItemStack pStack) {
        return Component.translatable("item.everythingmod.bandages");
    }

}

