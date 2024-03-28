package net.brunopb.weaponsvendetta.datagen;

import net.brunopb.weaponsvendetta.WeaponsVendetta;
import net.brunopb.weaponsvendetta.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WeaponsVendetta.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SAPHIRA);
        simpleItem(ModItems.RUBI);
        simpleItem(ModItems.TOPAZIO);
        simpleItem(ModItems.SAPHIRA_ORE);
        simpleItem(ModItems.DETECTOR_DE_CRISTAL);
        simpleItem(ModItems.RUBI_APPLE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(WeaponsVendetta.MOD_ID,"item/" + item.getId().getPath()));
    }
}
