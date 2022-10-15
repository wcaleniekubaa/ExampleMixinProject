package poradnik.mixin.impl.client;

import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import poradnik.*;

@Mixin(Minecraft.class)
public class MixinMinecraft {

	@Inject(method = "startGame", at = @At("HEAD"))
	public void init(CallbackInfo ci) {
		PoradnikClient.init();
	}
	@Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiIngame;<init>(Lnet/minecraft/client/Minecraft;)V"))
	public void start(CallbackInfo ci) {
		PoradnikClient.start();
	}

	@Inject(method = "shutdownMinecraftApplet", at = @At("HEAD"))
	public void shutdown(CallbackInfo ci) {
		PoradnikClient.shutdown();
	}

}
