package publicLibs.ampa.utils.reader.core.config;

import java.io.IOException;
import java.util.NoSuchElementException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.publicLibs.freedom1b2830.awesomeio.IoUtils;
import com.github.publicLibs.freedom1b2830.awesomeio.ResourcesIoUtils;

import publicLibs.ampa.AbstractMinecraftPlugin;
import publicLibs.ampa.config.core.PluginYmlConfig;

public class PluginYmlReader {
	public static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());

	/**
	 * @return
	 * @throws IOException
	 * @throws NoSuchElementException
	 *
	 */
	public static PluginYmlConfig read() throws NoSuchElementException, IOException {
		try (var pluginYmlResource = ResourcesIoUtils.readResource(AbstractMinecraftPlugin.class.getClassLoader(),
				"plugin.yml")) {
			final var pluginYmlBytes = IoUtils.isToBytes(pluginYmlResource);
			return YAML_MAPPER.readValue(pluginYmlBytes, PluginYmlConfig.class);
		}
	}

}
