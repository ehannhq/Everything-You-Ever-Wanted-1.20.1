package net.ehann.everythingmod.item;

import net.ehann.everythingmod.EverythingMod;
import net.ehann.everythingmod.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EverythingMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EVERYTHING_TAB = CREATIVE_MODE_TAB.register("everything_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.CHUGJUG.get()))
                    .title(Component.literal("§5§oEverything Mod"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItem.CHUGJUG.get());
                        pOutput.accept(ModItem.EMPTY_JUG.get());

                        pOutput.accept(ModItem.SHIELD_POTION.get());
                        pOutput.accept(ModItem.EMPTY_FLASK.get());

                        pOutput.accept(ModItem.SMALL_SHIELD_POTION.get());
                        pOutput.accept(ModItem.EMPTY_VIAL.get());

                        pOutput.accept(ModItem.MEDKIT.get());
                        pOutput.accept(ModItem.BANDAGES.get());

                        pOutput.accept(ModBlock.END_ORE.get());
                        pOutput.accept(ModItem.VOIDIUMCHUNK.get());
                        pOutput.accept(ModItem.VOIDIUM.get());
                        pOutput.accept(ModItem.VOIDIUM_UPGRADE_TEMPLATE.get());

                        pOutput.accept(ModItem.VOIDIUM_HELMET.get());
                        pOutput.accept(ModItem.VOIDIUM_CHESTPLATE.get());
                        pOutput.accept(ModItem.VOIDIUM_LEGGINGS.get());
                        pOutput.accept(ModItem.VOIDIUM_BOOTS.get());


                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
