package net.ehann.everythingmod.item.the_end;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VoidiumUpgradeTemplateItem extends Item {
    public VoidiumUpgradeTemplateItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Component getName(ItemStack pStack) {
        return Component.literal("Smithing Template");
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("§7Voidium Upgrade"));
        pTooltipComponents.add(Component.literal(""));
        pTooltipComponents.add(Component.literal("§7Applies to:"));
        pTooltipComponents.add(Component.literal("§9 Diamond Equipment"));
        pTooltipComponents.add(Component.literal("§9 Tridents"));
        pTooltipComponents.add(Component.literal("§9 Shields"));
        pTooltipComponents.add(Component.literal("§7Ingredients:"));
        pTooltipComponents.add(Component.literal("§9 Voidium Crystal"));
        pTooltipComponents.add(Component.literal(""));
        pTooltipComponents.add(Component.translatable("category.everythingmod.end"));
    }
}
