package net.ehann.everythingmod.item.the_end.voidium_tools;

import com.google.common.collect.Multimap;
import net.ehann.everythingmod.item.ModItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

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
        }, 6, -2.4f, new Properties().stacksTo(1));
//        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            InteractionResultHolder<ItemStack> ar = super.use(pLevel, pPlayer, pUsedHand);
            pPlayer.sendSystemMessage(Component.literal("HEYY!"));
            return ar;
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }
}
