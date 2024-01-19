package mod.crend.silentscreenshots.common;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SilentScreenshotsConfig {
	public static SilentScreenshotsConfig INSTANCE;

	public boolean playSound = true;

	public boolean showChatMessage = false;

	public boolean showInActionBar = false;

	public static void load(Path configFile) {
		try {
			INSTANCE = new GsonBuilder().create().fromJson(Files.readString(configFile), SilentScreenshotsConfig.class);
		} catch (IOException e) {
			INSTANCE = new SilentScreenshotsConfig();
			try {
				Files.writeString(configFile, new GsonBuilder().setPrettyPrinting().create().toJson(INSTANCE));
			} catch (IOException ignored) {
			}
		}
	}
}
