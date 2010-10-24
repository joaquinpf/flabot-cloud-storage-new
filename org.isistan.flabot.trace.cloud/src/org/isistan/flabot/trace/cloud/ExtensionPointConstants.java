package org.isistan.flabot.trace.cloud;


/**
 * Constants for provided extension points
 * @author $Author: dacostae $
 *
 */
public interface ExtensionPointConstants {
	
	
	/**
	 * Prefix for every extension-point's id
	 */
	public static final String PREFIX = TraceCloudPlugin.SYMBOLIC_NAME + ".";
	
	/**
	 * Extension-point for the collection launchers
	 */
	public static final String CLOUD_PROVIDER = 
		PREFIX + "cloudProvider";
	
	public static final String CLOUD_PROVIDER__PROVIDER_TAG = "provider";
	public static final String CLOUD_PROVIDER__ID_ATTRIBUTE = "id";
	public static final String CLOUD_PROVIDER__NAME_ATTRIBUTE = "name";
	public static final String CLOUD_PROVIDER__PROVIDER_CLASS_ATTRIBUTE = "class";

}
