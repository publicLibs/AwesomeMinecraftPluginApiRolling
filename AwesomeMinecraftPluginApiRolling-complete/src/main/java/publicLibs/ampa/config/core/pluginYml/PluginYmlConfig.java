/**
 *
 */
package publicLibs.ampa.config.core.pluginYml;

import java.util.HashMap;

import publicLibs.ampa.config.core.pluginYml.commands.PluginCommandSettings;
import publicLibs.ampa.config.core.pluginYml.permissions.PluginPermissions;

/**
 * @author user_dev_new
 *
 */
public class PluginYmlConfig {
	public String main;
	public String name;
	public String description;
	public String website;
	public String prefix;
	public String author;
	public String[] depend;
	public String[] softdepend;
	public String[] loadbefore;
	public HashMap<String, PluginCommandSettings> commands;
	public HashMap<String, PluginPermissions> permissions;
	public PluginLoadStage load;
	public String version;
}
