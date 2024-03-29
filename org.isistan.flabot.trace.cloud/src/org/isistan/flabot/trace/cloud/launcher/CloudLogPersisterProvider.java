/**
 * $Id: FlabotFileContextProvider.java,v 1.13 2006/04/13 04:42:17 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.trace.cloud.launcher;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.isistan.flabot.launcher.LauncherPlugin;
import org.isistan.flabot.launcher.persister.LogPersisterProvider;
import org.isistan.flabot.launcher.persister.LogPersisterProviderException;
import org.isistan.flabot.trace.cloud.TraceCloudPlugin;
import org.isistan.flabot.trace.cloud.config.CloudLogPersister;
import org.isistan.flabot.trace.cloud.config.ConfigFactory;
import org.isistan.flabot.trace.cloud.launcher.cloudProvider.CloudProvider;
import org.isistan.flabot.trace.cloud.launcher.cloudProvider.CloudProviderLoader;
import org.isistan.flabot.trace.config.LogPersister;
import org.isistan.flabot.util.extension.NoMatchingConstructorFoundException;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;

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
		if (key == null || key.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Key not selected.", null));
		}
		
		String password = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.PASSWORD, "");
		if (password == null || password.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Password not selected.", null));
		}
		
		String path = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.PATH, "");
		if (path == null || path.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Path not selected.", null));
		}
		
		String secret = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.SECRET, "");
		if (secret == null || secret.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Secret not selected.", null));
		}
		
		String service = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.SERVICE, "");
		if (service == null || service.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Service not selected.", null));
		}
		
		String username = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.USERNAME, "");
		if (username == null || username.trim().length() == 0) {
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
		cloudLogPersister.setUsername(username);
		
		try {
			RestS3Service ser = new RestS3Service(null);
			ser.checkBucketStatus(null);
		} catch (S3ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CloudProvider provider = getCloudProvider(service);
		cloudLogPersister.setService(provider.getClass().getCanonicalName());
		
		return cloudLogPersister;
	}

	public CloudProvider getCloudProvider(String cloudProviderId)
	throws CoreException {
		System.out.println("cloudProviderId"+cloudProviderId);
		if (cloudProviderId.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					TraceCloudPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Cloud provider not selected.", null));
		}
		try {
			return CloudProviderLoader.loadCloudProvider(cloudProviderId);
		} catch (ClassNotFoundException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					TraceCloudPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Cloud provider class not found.", e));
		} catch (IllegalArgumentException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					TraceCloudPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Invalid arguments on cloud provider.", e));
		} catch (NoMatchingConstructorFoundException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					TraceCloudPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"No default constructor found in cloud provider.", e));
		} catch (InstantiationException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					TraceCloudPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Error instantiating cloud provider class.", e));
		} catch (IllegalAccessException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					TraceCloudPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Error accessing cloud provider constuctors.", e));
		} catch (InvocationTargetException e) {
			throw new CoreException(new Status(IStatus.ERROR,
					TraceCloudPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Error creating cloud provider instance.", e));
		}
	}

}
