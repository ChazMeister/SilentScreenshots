package mod.crend.silentscreenshots;

import mod.crend.silentscreenshots.common.SilentScreenshotsConfig;
import mod.crend.silentscreenshots.common.SilentScreenshotsMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(SilentScreenshotsMod.MOD_ID)
@Mod.EventBusSubscriber(modid = SilentScreenshotsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SilentScreenshotsForge {

	@SubscribeEvent
	static void onClientSetup(FMLClientSetupEvent event) {
		SilentScreenshotsConfig.load(FMLPaths.CONFIGDIR.get().resolve(SilentScreenshotsMod.CONFIG_FILE));
	}

}
