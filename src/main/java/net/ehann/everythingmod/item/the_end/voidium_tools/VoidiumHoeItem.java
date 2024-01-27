package net.ehann.everythingmod.item.the_end.voidium_tools;

import net.ehann.everythingmod.item.ModItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class VoidiumHoeItem extends HoeItem {
    public VoidiumHoeItem() {
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
        }, 0, 0f, new Properties().stacksTo(1));

//      super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
}
