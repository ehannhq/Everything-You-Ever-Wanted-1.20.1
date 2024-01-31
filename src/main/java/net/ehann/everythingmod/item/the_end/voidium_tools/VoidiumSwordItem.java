package net.ehann.everythingmod.item.the_end.voidium_tools;

import net.ehann.everythingmod.item.ModItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VoidiumSwordItem extends SwordItem {
    public VoidiumSwordItem() {
        super(new Tier() {
            @Override
            public int getUses() {
                return 1561;
            }

            @Override
            public float getSpeed() {
                return 0.0f;
            }

            @Override
            public float getAttackDamageBonus() {
                return 1;
            }

            @Override
            public int getLevel() {
                return 4;
            }

            @Override
            public int getEnchantmentValue() {
                return 15;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(ModItem.VOIDIUM.get());
            }
        }, 5, -2.4f, new Properties().stacksTo(1));
//        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public static double maxKills = 50.0;

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (pTarget.getHealth() <= 0)
            addKillsToSword(pStack);
        pStack.hurtAndBreak(1, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public static void addKillsToSword(ItemStack pStack) {
        int newKillCount = pStack.getOrCreateTag().getInt("kills") + 1;
        if (newKillCount <= maxKills)
            pStack.getOrCreateTag().putInt("kills", newKillCount);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        int swordKills = (pStack.getOrCreateTag().getInt("kills"));

        pTooltipComponents.add(Component.literal("§9Call of the Void"));
        pTooltipComponents.add(Component.literal("§7Kills: " + swordKills + "§7/" + (int)maxKills));

        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.literal(" §8Each kill adds to the sword's potent"));
            pTooltipComponents.add(Component.literal(" §8ability. §e§o[Right Click]§r§8 will release"));
            pTooltipComponents.add(Component.literal(" §8the potential, granting the user a "));
            pTooltipComponents.add(Component.literal(" §8buff. The more kills stored translates "));
            pTooltipComponents.add(Component.literal(" §8to a stronger buff. "));
        }
        else
            pTooltipComponents.add(Component.literal(" §8Hold §e§o[Shift]§r§8 for more info."));

        pTooltipComponents.add(Component.literal(""));
        pTooltipComponents.add(Component.translatable("category.everythingmod.end"));


        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            ItemStack pStack = pPlayer.getItemInHand(pUsedHand);
            int swordKills = pStack.getOrCreateTag().getInt("kills");
            pStack.getOrCreateTag().putInt("kills", 0);

            if (swordKills != 0) {
                double killProporion = swordKills / maxKills;
                new VoidiumSwordAbility(pPlayer, killProporion);
            }

        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}