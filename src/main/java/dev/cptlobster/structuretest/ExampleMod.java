package dev.cptlobster.structuretest;

import com.mojang.logging.LogUtils;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ExampleMod.MODID)
@EventBusSubscriber(modid = ExampleMod.MODID)
public class ExampleMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "structuretest";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public ExampleMod(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        MetalPipe.SOUND_EVENTS.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP :3");
    }

    @SubscribeEvent
    public static void onRightClick(final PlayerInteractEvent.RightClickBlock event) {
        if (event.getItemStack().getItem() == Items.STICK) {
            // explode
            event.getLevel().explode(
                    null,
                    event.getPos().getX(),
                    event.getPos().getY(),
                    event.getPos().getZ(),
                    32.0F,
                    Level.ExplosionInteraction.TNT
            );
            // play a sound
            if (!event.getLevel().isClientSide()) {
                event.getLevel().playSound(
                        null,
                        event.getEntity().getX(),
                        event.getEntity().getY(),
                        event.getEntity().getZ(),
                        MetalPipe.METAL_PIPE.get(),
                        SoundSource.MASTER
                );
            }
        }
    }
}

