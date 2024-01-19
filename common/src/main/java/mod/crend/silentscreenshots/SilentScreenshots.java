package mod.crend.silentscreenshots;

import com.mojang.logging.LogUtils;
import mod.crend.silentscreenshots.common.SilentScreenshotsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import org.slf4j.Logger;

import java.util.function.Consumer;

public class SilentScreenshots {
	private static final Logger LOGGER = LogUtils.getLogger();

	public static void trigger(Consumer<Component> chatMessage, Component component) {
		if (SilentScreenshotsConfig.INSTANCE.playSound) {
			Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
		}
		if (SilentScreenshotsConfig.INSTANCE.showChatMessage) {
			chatMessage.accept(component);
		} else {
			String string = component.getString().replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
			LOGGER.info("[SCREENSHOT] {}", string);
		}
		if (SilentScreenshotsConfig.INSTANCE.showInActionBar) {
			Minecraft.getInstance().player.displayClientMessage(component, true);
		}
	}
}
