package mod.crend.silentscreenshots;

import mod.crend.silentscreenshots.common.SilentScreenshotsConfig;
import mod.crend.silentscreenshots.common.SilentScreenshotsMod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLPaths;

@Mod(SilentScreenshotsMod.MOD_ID)
@Mod.EventBusSubscriber(modid = SilentScreenshotsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SilentScreenshotsNeoForge {

	@SubscribeEvent
	static void onClientSetup(FMLClientSetupEvent event) {
		SilentScreenshotsConfig.load(FMLPaths.CONFIGDIR.get().resolve(SilentScreenshotsMod.CONFIG_FILE));
	}

}
