package dev.cptlobster.structuretest;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MetalPipe {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ExampleMod.MODID);

    // All vanilla sounds use variable range events.
    public static final DeferredHolder<SoundEvent, SoundEvent> METAL_PIPE = SOUND_EVENTS.register(
            "metal_pipe", // must match the resource location on the next line
            () -> SoundEvent.createFixedRangeEvent(ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID, "metal_pipe"), 1f)
    );
}
