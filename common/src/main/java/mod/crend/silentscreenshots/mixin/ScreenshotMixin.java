package mod.crend.silentscreenshots.mixin;

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
	}
}
