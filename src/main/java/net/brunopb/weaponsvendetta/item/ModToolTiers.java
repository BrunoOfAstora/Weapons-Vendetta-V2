package net.brunopb.weaponsvendetta.item;

import net.brunopb.weaponsvendetta.WeaponsVendetta;
import net.brunopb.weaponsvendetta.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SAPHIRA = TierSortingRegistry.registerTier(
            new ForgeTier(4, 500, 8f, 6f, 25,
                    ModTags.Blocks.NEEDS_SAPHIRA_TOOL, () -> Ingredient.of(ModItems.SAPHIRA.get())),
            new ResourceLocation(WeaponsVendetta.MOD_ID, "saphira"), List.of(Tiers.NETHERITE), List.of());
}

