package publicLibs.ampa;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import publicLibs.ampa.config.core.pluginYml.PluginYmlConfig;
import publicLibs.ampa.utils.reader.core.config.PluginYmlReader;

public abstract class AbstractMinecraftPlugin extends JavaPlugin implements Listener {
	public Stream<? extends Player> getPlayers() {
		return getPlayers(null);
	}

	public Stream<? extends Player> getPlayers(final String permission) {
		return getServer().getOnlinePlayers().stream().filter((final var player) -> {
			if (permission == null) {
				return true;
			}
			return player.hasPermission(permission);
		});
	}

	public @Override void onDisable() {
		onPluginDisable();
	}

	public @Override void onEnable() {
		try {
			readPluginYml();
			getServer().getPluginManager().registerEvents(this, this);

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

	/**
	 * @param format
	 */
	public void sendBroadCastMessage(final String message) {
		getPlayers().parallel().forEachOrdered(player -> player.sendMessage(message));
	}

	public void sendBroadCastMessage(final String permission, final String message) {
		getPlayers(permission).parallel().forEachOrdered(player -> player.sendMessage(message));
	}

}
