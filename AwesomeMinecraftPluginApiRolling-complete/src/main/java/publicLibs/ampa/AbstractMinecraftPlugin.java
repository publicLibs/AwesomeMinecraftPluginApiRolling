package publicLibs.ampa;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.bukkit.plugin.java.JavaPlugin;

import publicLibs.ampa.config.core.PluginYmlConfig;
import publicLibs.ampa.utils.reader.core.config.PluginYmlReader;

public abstract class AbstractMinecraftPlugin extends JavaPlugin {
	public @Override void onDisable() {
		onPluginDisable();
	}

	public @Override void onEnable() {
		try {
			readPluginYml();

			// TODO регистрация команд
			onPluginEnable();
		} catch (NoSuchElementException | IOException e) {
			e.printStackTrace();
		}
	}

	public @Override void onLoad() {
		onPluginLoad();
	}

	public abstract void onPluginDisable();

	public abstract void onPluginEnable();

	public abstract void onPluginLoad();

	/**
	 * @return
	 * @throws IOException
	 * @throws NoSuchElementException
	 *
	 */
	public final PluginYmlConfig readPluginYml() throws NoSuchElementException, IOException {
		final var pluginYml = PluginYmlReader.read();
		// TODO

		return pluginYml;
	}
}
