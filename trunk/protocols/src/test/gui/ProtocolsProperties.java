package test.gui;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProtocolsProperties {
	
	private Properties properties = new Properties();
	private static final String PROPERTIES_PATH = "config.properties";
	public static ProtocolsProperties instance = new ProtocolsProperties();
	
	protected ProtocolsProperties() {
		try {
		    properties.load(new FileInputStream(PROPERTIES_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
