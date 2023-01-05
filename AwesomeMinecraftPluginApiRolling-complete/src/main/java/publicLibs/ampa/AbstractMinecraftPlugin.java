package publicLibs.ampa;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractMinecraftPlugin extends JavaPlugin {
	public @Override void onDisable() {
		onPluginDisable();
	}

	public @Override void onEnable() {
		onPluginEnable();
	}

	public @Override void onLoad() {
		onPluginLoad();
	}

	public abstract void onPluginDisable();

	public abstract void onPluginEnable();

	public abstract void onPluginLoad();
}
