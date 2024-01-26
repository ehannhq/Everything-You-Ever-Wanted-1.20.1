package net.ehann.everythingmod.item;

import net.ehann.everythingmod.EverythingMod;
import net.ehann.everythingmod.item.fortnite.*;
import net.ehann.everythingmod.item.the_end.VoidiumChunkItem;
import net.ehann.everythingmod.item.the_end.VoidiumItem;
import net.ehann.everythingmod.item.the_end.VoidiumUpgradeTemplateItem;
import net.minecraft.world.item.ArmorItem;
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

    public static final RegistryObject<Item> VOIDIUMCHUNK = ITEMS.register("voidium_chunk",
            () -> new VoidiumChunkItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> VOIDIUM = ITEMS.register("voidium",
            () -> new VoidiumItem(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> VOIDIUM_UPGRADE_TEMPLATE = ITEMS.register("voidium_upgrade_template",
            () -> new VoidiumUpgradeTemplateItem(new Item.Properties().stacksTo(64)));


    public static final RegistryObject<Item> VOIDIUM_HELMET = ITEMS.register("voidium_helmet",
            () -> new ArmorItem(ModArmorMaterials.VOIDIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> VOIDIUM_CHESTPLATE = ITEMS.register("voidium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.VOIDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> VOIDIUM_LEGGINGS = ITEMS.register("voidium_leggings",
            () -> new ArmorItem(ModArmorMaterials.VOIDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> VOIDIUM_BOOTS = ITEMS.register("voidium_boots",
            () -> new ArmorItem(ModArmorMaterials.VOIDIUM, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}