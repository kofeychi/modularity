package net.kofeychi.Modularity.Mixin.ScreenShakeModule;

import net.kofeychi.Modularity.ScreenShake.ScreenshakeHandler;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.kofeychi.Modularity.ScreenShake.ScreenShakeModule.RANDOM;

@Mixin(value = Camera.class,priority = -1000000)
public class CameraMixin {
    @Inject(method = "update", at = @At("RETURN"))
    public void modularityupdate(CallbackInfo ci) {
        ScreenshakeHandler.cameraTick((Camera) (Object) this, (Random) RANDOM);
    }
}
