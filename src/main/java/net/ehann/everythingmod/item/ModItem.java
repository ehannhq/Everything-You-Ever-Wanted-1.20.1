package net.ehann.everythingmod.item;

import net.ehann.everythingmod.EverythingMod;
import net.ehann.everythingmod.item.fortnite.*;
import net.ehann.everythingmod.item.the_end.VoidstoneChunkItem;
import net.ehann.everythingmod.item.the_end.VoidstoneItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EverythingMod.MOD_ID);

    // FORTNITE ITEMS

    public static final RegistryObject<Item> CHUGJUG = ITEMS.register("chug_jug",
            () -> new ChugJugItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SHIELD_POTION = ITEMS.register("shield_potion",
            () -> new ShieldPotionItem(new Item.Properties().stacksTo(3)));

    public static final RegistryObject<Item> SMALL_SHIELD_POTION = ITEMS.register("small_shield_potion",
            () -> new SmallShieldPotionItem(new Item.Properties().stacksTo(6)));

    public static final RegistryObject<Item> MEDKIT = ITEMS.register("medkit",
            () -> new MedkitItem(new Item.Properties().stacksTo(3)));

    public static final RegistryObject<Item> BANDAGES = ITEMS.register("bandages",
            () -> new BandagesItem(new Item.Properties().stacksTo(15)));

    // THE END ITEMS

    public static final RegistryObject<Item> VOIDSTONECHUNK = ITEMS.register("voidstone_chunk",
            () -> new VoidstoneChunkItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> VOIDSTONE = ITEMS.register("voidstone",
            () -> new VoidstoneItem(new Item.Properties().stacksTo(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
