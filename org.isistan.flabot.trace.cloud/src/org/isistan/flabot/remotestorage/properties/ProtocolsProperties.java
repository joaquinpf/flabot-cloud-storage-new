package com.flabot.remotestorage.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProtocolsProperties {
	
	private Properties properties = new Properties();
	private String propertiesPath = "config.properties";
	
	public ProtocolsProperties(String path) {
		if (path != null && path.trim().length() > 0)
			propertiesPath = path;
		try {
		    properties.load(new FileInputStream(propertiesPath));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
