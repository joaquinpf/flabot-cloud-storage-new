package org.isistan.flabot.trace.cloud.launcher;

import org.isistan.flabot.trace.cloud.TraceCloudPlugin;


public interface LaunchConfigurationConstants {

	/**
	 * Prefix for every attribute
	 */
	public static final String PREFIX = TraceCloudPlugin.SYMBOLIC_NAME + ".";
	
	public static final String FILENAME = PREFIX + "fileName";
	public static final String SERVICE = PREFIX + "service";
	public static final String PATH = PREFIX + "path";
	public static final String PASSWORD = PREFIX + "password";
	public static final String USERNAME = PREFIX + "username";
	public static final String SECRET = PREFIX + "secret";
	public static final String KEY = PREFIX + "key";
	
}
