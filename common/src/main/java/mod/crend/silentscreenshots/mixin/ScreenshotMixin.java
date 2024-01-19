package mod.crend.silentscreenshots.mixin;

import mod.crend.silentscreenshots.SilentScreenshots;
import net.minecraft.client.Screenshot;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Consumer;

@Mixin(Screenshot.class)
public class ScreenshotMixin {
	@Redirect(
			method = "method_1661",
			at = @At(value = "INVOKE", target = "Ljava/util/function/Consumer;accept(Ljava/lang/Object;)V", ordinal = 0)
	)
	private static void silentScreenshots$successMessage(Consumer<Component> instance, Object object) {
		SilentScreenshots.trigger(instance, (Component) object);
	}

	/*
	 * (Neo)Forge patch the Screenshot class to introduce a ScreenshotEvent. We cannot use that as it still outputs
	 * a chat message on canceling. The patch also makes the Mixin above fail, so we simply try both variants with
	 * `defaultRequire=0` in the mixin config.
	 */
	@Redirect(
			method = "lambda$_grab$2",
			at = @At(value = "INVOKE", target = "Ljava/util/function/Consumer;accept(Ljava/lang/Object;)V", ordinal = 1)
	)
	private static void silentScreenshots$successMessageForge(Consumer<Component> instance, Object object) {
		SilentScreenshots.trigger(instance, (Component) object);
	}
}
