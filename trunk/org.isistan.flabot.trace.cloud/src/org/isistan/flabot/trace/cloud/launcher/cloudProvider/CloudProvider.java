package org.isistan.flabot.trace.cloud.launcher.cloudProvider;

import java.util.Map;

public interface CloudProvider {

	public void save(Map<String,String> properties) throws Exception;
	public void load(Map<String,String> properties) throws Exception;
	
}
