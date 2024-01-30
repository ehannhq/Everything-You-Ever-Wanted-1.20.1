package net.ehann.everythingmod.item.the_end.voidium_tools;

import net.ehann.everythingmod.item.ModItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
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

    public static final int swordLevelOne = 100;
    public static final int swordLevelTwo = 500;
    public static final int swordLevelThree = 1000;
    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Player player = pAttacker instanceof Player ? (Player) pAttacker : null;

        double swordCurrentProgression = pStack.getOrCreateTag().getDouble("progression");
        if (swordCurrentProgression >= swordLevelOne) {
            int probability = 5;

            if (swordCurrentProgression >= swordLevelThree)
                probability = 15;
            else if (swordCurrentProgression >= swordLevelTwo)
                probability = 10;

            int roll = (int)(Math.random() * 100) + 1;

            if (roll <= probability) {
                new VoidiumSwordAbility(pStack, pAttacker);
            }
        }

        if (pTarget.getHealth() <= 0) {
            upgradeSword(pStack, player);
        }

        pStack.hurtAndBreak(1, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public static void upgradeSword(ItemStack pStack, Player player) {
        List<Component> pToolTipComponents = pStack.getTooltipLines(player, TooltipFlag.ADVANCED);

        double newLevel = pStack.getOrCreateTag().getDouble("progression") + 1;
        if (newLevel <= swordLevelThree) {
            pStack.getOrCreateTag().putDouble("progression", newLevel);
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        int swordLevel = (int)(pStack.getOrCreateTag().getDouble("progression"));
        String isUnlocked;
        int swordProgressionMax = swordLevelOne;
        if (swordLevel >= swordLevelThree) {
            isUnlocked = "§9III";
            swordProgressionMax = swordLevelThree;
        }
        else if (swordLevel >= swordLevelTwo) {
            isUnlocked = "§9II";
            swordProgressionMax = swordLevelThree;
        }
        else if (swordLevel >= swordLevelOne) {
            isUnlocked = "§9I";
            swordProgressionMax = swordLevelTwo;
        }
        else {
            isUnlocked = "§c§l[LOCKED]";
        }
        pTooltipComponents.add(Component.literal("§9Lifesteal " + isUnlocked));
        pTooltipComponents.add(Component.literal("§7Kills: " + swordLevel + "§7/" + swordProgressionMax));
        pTooltipComponents.add(Component.literal(" §8Each hit gives a chance to steal"));
        pTooltipComponents.add(Component.literal(" §8health from the target. Amount stolen"));
        pTooltipComponents.add(Component.literal(" §8varies from one to three hearts"));
        pTooltipComponents.add(Component.literal(""));
        pTooltipComponents.add(Component.translatable("category.everythingmod.end"));


        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
