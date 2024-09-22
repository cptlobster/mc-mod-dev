package dev.cptlobster.structuretest.init;

import dev.cptlobster.structuretest.ExampleMod;
import dev.cptlobster.structuretest.blocks.CannonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ExampleMod.MODID);

    public static final DeferredBlock<CannonBlock> CANNON = BLOCKS.registerBlock("cannon", CannonBlock::new, BlockBehaviour.Properties.of().noOcclusion().explosionResistance(1200F));
}
