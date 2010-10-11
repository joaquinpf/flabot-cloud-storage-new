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
import org.isistan.flabot.trace.config.LogPersister;
import org.isistan.flabot.trace.file.config.ConfigFactory;
import org.isistan.flabot.trace.file.config.FileLogPersister;
import org.isistan.flabot.util.resource.PathUtil;

/**
 * EMF log persister provider.
 * 
 * @author edacost
 * 
 */
public class CloudLogPersisterProvider implements LogPersisterProvider {

	public LogPersister getLogPersister(ILaunchConfiguration launchConfiguration)
			throws LogPersisterProviderException, CoreException {
		String outputFile = launchConfiguration.getAttribute(
				LaunchConfigurationConstants.OUTPUT_FILE, "");
		if (outputFile == null || outputFile.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR,
					LauncherPlugin.SYMBOLIC_NAME, IStatus.ERROR,
					"Output file not selected.", null));
		}
		outputFile = PathUtil.toString(PathUtil.makeSystemAbsolute(PathUtil
				.fromString(outputFile)));
		FileLogPersister fileLogPersister = ConfigFactory.eINSTANCE
				.createFileLogPersister();
		fileLogPersister.setFileName(outputFile);
		return fileLogPersister;
	}

}
