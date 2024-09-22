package dev.cptlobster.structuretest.init;

import dev.cptlobster.structuretest.ExampleMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ExampleMod.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> METAL_PIPE = SOUND_EVENTS.register(
            "metal_pipe", // must match the resource location on the next line
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID, "metal_pipe"))
    );
}
