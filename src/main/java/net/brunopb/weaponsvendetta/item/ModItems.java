package net.brunopb.weaponsvendetta.item;

import net.brunopb.weaponsvendetta.WeaponsVendetta;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WeaponsVendetta.MOD_ID);

    public static final RegistryObject<Item> SAPHIRA = ITEMS.register("saphira",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TOPAZIO = ITEMS.register("topazio",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBI = ITEMS.register("rubi",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
