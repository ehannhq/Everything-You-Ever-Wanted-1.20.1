package net.ehann.everythingmod.item.the_end.voidium_tools;

import net.ehann.everythingmod.item.ModItem;
import net.ehann.everythingmod.item.the_end.voidium_tools.abilities.VoidiumSwordAbility;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Random;

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

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        int probability = (int)(Math.random() * 100) + 1;
        int roll = (int)(Math.random() * 100) + 1;

        if (roll <= probability) {
            new VoidiumSwordAbility(pStack, pTarget, pAttacker);
        }

        pStack.hurtAndBreak(1, pAttacker, (p_43296_) -> {
            p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        return true;
    }

}
