/**
 * $Id: FlabotFileContextProvider.java,v 1.13 2006/04/13 04:42:17 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.trace.cloud.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.isistan.flabot.launcher.LauncherPlugin;
import org.isistan.flabot.launcher.persister.LogPersisterProvider;
import org.isistan.flabot.launcher.persister.LogPersisterProviderException;
import org.isistan.flabot.trace.cloud.config.CloudLogPersister;
import org.isistan.flabot.trace.cloud.config.ConfigFactory;
import org.isistan.flabot.trace.config.LogPersister;

/**
 * EMF log persister provider.
 * 
 * 
 */
public class CloudLogPersisterProvider implements LogPersisterProvider {

	public LogPersister getLogPersister(ILaunchConfiguration launchConfiguration)
			throws LogPersisterProviderException, CoreException {
		String filename = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.FILENAME, "");
		if (filename == null || filename.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Filename not selected.", null));
		}
		
		String key = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.KEY, "");
		if (filename == null || filename.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Key not selected.", null));
		}
		
		String password = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.PASSWORD, "");
		if (filename == null || filename.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Password not selected.", null));
		}
		
		String path = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.PATH, "");
		if (filename == null || filename.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Path not selected.", null));
		}
		
		String secret = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.SECRET, "");
		if (filename == null || filename.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Secret not selected.", null));
		}
		
		String service = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.SERVICE, "");
		if (filename == null || filename.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Service not selected.", null));
		}
		
		String username = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.USERNAME, "");
		if (filename == null || filename.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Username not selected.", null));
		}
		
		CloudLogPersister cloudLogPersister = ConfigFactory.eINSTANCE
				.createCloudLogPersister();
		
		cloudLogPersister.setFileName(filename);
		cloudLogPersister.setKey(key);
		cloudLogPersister.setPassword(password);
		cloudLogPersister.setPath(path);
		cloudLogPersister.setSecret(secret);
		cloudLogPersister.setService(service);
		cloudLogPersister.setUsername(username);

		return cloudLogPersister;
	}

}
