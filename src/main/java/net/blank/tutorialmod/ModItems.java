package net.blank.tutorialmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item SULFUR = RegisterItem("sulfur", new Item(new FabricItemSettings()));
    public static final Item INGOT = RegisterItem("ingot", new Item(new FabricItemSettings()));

    private static Item RegisterItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }


    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, SULFUR);
        addToItemGroup(ItemGroups.NATURAL, SULFUR);
        addToItemGroup(ItemGroups.INGREDIENTS, INGOT);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    public static void RegisterModItems() {
        TutorialMod.LOGGER.debug("Registering mod items for " + TutorialMod.MOD_ID);

        addItemsToItemGroup();
    }
}
