package dev.cptlobster.structuretest.init;

import dev.cptlobster.structuretest.ExampleMod;
import dev.cptlobster.structuretest.items.ExplodingStickItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(
            ExampleMod.MODID
    );

    public static final DeferredItem<ExplodingStickItem> EXPLODING_STICK = ITEMS.registerItem(
            "exploding_stick",
            ExplodingStickItem::new,
            new Item.Properties()
    );

    public static final DeferredItem<BlockItem> CANNON = ITEMS.registerSimpleBlockItem(ModBlocks.CANNON);
}
