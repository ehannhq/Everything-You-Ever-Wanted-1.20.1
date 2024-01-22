package net.ehann.everythingmod.item.fortnite;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChugJugItem extends PotionItem {

    public int drinkTime = 300;
    public ChugJugItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return drinkTime;
    }


    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player)pEntityLiving : null;
        if (!pLevel.isClientSide) {
            float maxAbsorption = player.getMaxHealth();
            float currentAbsorption = player.getAbsorptionAmount();

            if (player.getHealth() < player.getMaxHealth() || currentAbsorption < maxAbsorption) {
                player.setHealth(player.getMaxHealth());
                player.setAbsorptionAmount(maxAbsorption);

                if (!player.getAbilities().instabuild)
                    pStack.shrink(1);
            }
            else {
                pEntityLiving.sendSystemMessage(Component.literal("You can't use this item anymore!"));
            }
        }
        return pStack;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("§7A Jug for the Chug."));
        pTooltip.add(Component.literal(""));
        pTooltip.add(Component.translatable("category.everythingmod.fortnite"));
    }

    @Override
    public Component getName(ItemStack pStack) {
        return Component.translatable("item.everythingmod.chug_jug");
    }
}

