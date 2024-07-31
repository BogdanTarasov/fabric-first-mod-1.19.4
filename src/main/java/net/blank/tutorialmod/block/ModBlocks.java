package net.blank.tutorialmod.block;

import net.blank.tutorialmod.TutorialMod;
import net.blank.tutorialmod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    //adding blocks
    public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool(), UniformIntProvider.create(4, 8)), ModItemGroup.MODITEMGOUP);

    public static final Block DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(5.0f).requiresTool(), UniformIntProvider.create(3, 7)), ModItemGroup.MODITEMGOUP);

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6.0f).requiresTool()), ModItemGroup.MODITEMGOUP);

    //registers the blocks themselves
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);

    }

    //registers the block items and adds them to the item group
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }


    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering mod blocks for " + TutorialMod.MOD_ID);
    }
}
