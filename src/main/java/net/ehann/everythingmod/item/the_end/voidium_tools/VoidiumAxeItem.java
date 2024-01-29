package net.ehann.everythingmod.item.the_end.voidium_tools;

import net.ehann.everythingmod.item.ModItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class VoidiumAxeItem extends AxeItem {
    public VoidiumAxeItem() {
        super(new Tier() {
            @Override
            public int getUses() {
                return 1562;
            }

            @Override
            public float getSpeed() {
                return 0;
            }

            @Override
            public float getAttackDamageBonus() {
                return 0;
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
        }, 8, -3f, new Properties().stacksTo(1));

//      super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
}
