package dev.cptlobster.structuretest.items;

import dev.cptlobster.structuretest.init.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ExplodingStickItem extends Item {
    public ExplodingStickItem (Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getHand() == InteractionHand.MAIN_HAND && !context.getLevel().isClientSide()) {
            context.getLevel().explode(
                    null,
                    context.getClickedPos().getX(),
                    context.getClickedPos().getY(),
                    context.getClickedPos().getZ(),
                    16.0F,
                    Level.ExplosionInteraction.TNT
            );
            // play a sound
            context.getLevel().playSound(
                    null,
                    context.getClickedPos().getX(),
                    context.getClickedPos().getY(),
                    context.getClickedPos().getZ(),
                    ModSounds.METAL_PIPE.get(),
                    SoundSource.MASTER
            );
            return InteractionResult.SUCCESS_NO_ITEM_USED;
        }
        return super.useOn(context);
    }
}
