package net.ehann.everythingmod.item.fortnite;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.Nullable;


import java.util.List;

public class MedkitItem extends PotionItem {
    public MedkitItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 200;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player)pEntityLiving : null;
        if (!pLevel.isClientSide) {

            if (player.getHealth() < player.getMaxHealth()) {
                player.setHealth(player.getMaxHealth());
            }
            else {
                player.sendSystemMessage(Component.literal("§cYou're already at max health!"));
                pLevel.playSound(player, BlockPos.containing(player.position()), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.MASTER, 1, 1);
            }
        }
        return pStack;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("§7When in doubt, pop a meddy-beddy."));
        pTooltip.add(Component.literal(""));
        pTooltip.add(Component.translatable("category.everythingmod.fortnite"));
    }

    @Override
    public Component getName(ItemStack pStack) {
        return Component.translatable("item.everythingmod.medkit");
    }

}

