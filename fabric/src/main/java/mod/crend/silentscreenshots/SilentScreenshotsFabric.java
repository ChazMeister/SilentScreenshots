package mod.crend.silentscreenshots;

import mod.crend.silentscreenshots.common.SilentScreenshotsConfig;
import mod.crend.silentscreenshots.common.SilentScreenshotsMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class SilentScreenshotsFabric implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		SilentScreenshotsConfig.load(FabricLoader.getInstance().getConfigDir().resolve(SilentScreenshotsMod.CONFIG_FILE));
	}

}
