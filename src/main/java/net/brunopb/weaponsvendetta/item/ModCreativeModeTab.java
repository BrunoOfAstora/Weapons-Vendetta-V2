package net.brunopb.weaponsvendetta.item;

import net.brunopb.weaponsvendetta.WeaponsVendetta;
import net.brunopb.weaponsvendetta.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WeaponsVendetta.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("saphira_tab",
            () -> CreativeModeTab.builder().icon(() -> new  ItemStack(ModItems.SAPHIRA.get()))
                    .title(Component.translatable("WeaponsVendetta"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAPHIRA.get());
                        pOutput.accept(ModItems.RUBI.get());
                        pOutput.accept(ModItems.TOPAZIO.get());
                        pOutput.accept(ModItems.SAPHIRA_ORE.get());
                        pOutput.accept(ModItems.DETECTOR_DE_CRISTAL.get());
                        pOutput.accept(ModItems.RUBI_APPLE.get());
                        pOutput.accept(ModItems.SAPHIRA_SWORD.get());

                        pOutput.accept(ModBlocks.SAPHIRA_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBI_BLOCK.get());
                    })
                    .build());

    public static  void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }
}
