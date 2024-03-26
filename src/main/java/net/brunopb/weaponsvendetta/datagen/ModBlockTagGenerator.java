package net.brunopb.weaponsvendetta.datagen;

import net.brunopb.weaponsvendetta.WeaponsVendetta;
import net.brunopb.weaponsvendetta.block.ModBlocks;
import net.brunopb.weaponsvendetta.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WeaponsVendetta.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.DETECTOR_DE_CRISTAL)
                .add(ModBlocks.SAPHIRA_BLOCK.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SAPHIRA_BLOCK.get(),
                        ModBlocks.SAPHIRA_BLOCK.get(),
                        ModBlocks.RUBI_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RUBI_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPHIRA_BLOCK.get());

    }
}
