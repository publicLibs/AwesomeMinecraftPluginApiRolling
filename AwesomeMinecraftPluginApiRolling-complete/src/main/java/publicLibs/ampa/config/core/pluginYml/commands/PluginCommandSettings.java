/**
 *
 */
package publicLibs.ampa.config.core.pluginYml.commands;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author user_dev_new
 *
 */
public class PluginCommandSettings {
	public String usage;
	public String permission;
	@JsonProperty("permission-message")
	public String permissionMessage;
	public String description;
	public String[] aliases;
}
