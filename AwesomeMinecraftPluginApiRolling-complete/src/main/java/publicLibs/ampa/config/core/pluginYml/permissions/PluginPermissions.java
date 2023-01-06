/**
 *
 */
package publicLibs.ampa.config.core.pluginYml.permissions;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author user_dev_new
 *
 */
public class PluginPermissions {
	public String description;

	@JsonProperty("default")
	public String isDefault;// FIXME (op,not op,true,false)
	public Map<String, Boolean> children;

}
