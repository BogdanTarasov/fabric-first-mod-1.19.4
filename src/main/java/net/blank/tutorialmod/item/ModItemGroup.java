package net.blank.tutorialmod.item;

import net.blank.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static ItemGroup MODITEMGOUP;

    public static void RegisterItemGroups() {
        MODITEMGOUP = FabricItemGroup.builder(new Identifier(TutorialMod.MOD_ID, "customigroup"))
                .displayName(Text.literal("Cool and awesome mod"))
                .icon(() -> new ItemStack(ModItems.STEEL_INGOT)).build();
    }
}
