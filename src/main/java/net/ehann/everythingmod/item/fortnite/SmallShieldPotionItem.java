package net.ehann.everythingmod.item.fortnite;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SmallShieldPotionItem extends PotionItem {
    public SmallShieldPotionItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 40;
    }


    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player)pEntityLiving : null;
        if (!pLevel.isClientSide) {
            float currentAbsorption = player.getAbsorptionAmount();
            float maxAbsorption = player.getMaxHealth() / 2;

            if (currentAbsorption < maxAbsorption) {
                float newAbsorption = currentAbsorption + 2.5f;

                if (newAbsorption > maxAbsorption)
                    newAbsorption = maxAbsorption;

                player.setAbsorptionAmount(newAbsorption);

                if (!player.getAbilities().instabuild)
                    pStack.shrink(1);
            }
            else {
                pEntityLiving.sendSystemMessage(Component.literal("You can't use this item anymore!"));
                pLevel.playSound(player, BlockPos.containing(player.position()), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.MASTER, 1, 1);
            }
        }
        return pStack;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("§7The pinnacle of Fortnite"));
        pTooltip.add(Component.literal(""));
        pTooltip.add(Component.translatable("category.everythingmod.fortnite"));
    }

    @Override
    public Component getName(ItemStack pStack) {
        return Component.translatable("item.everythingmod.small_shield_potion");
    }

}

