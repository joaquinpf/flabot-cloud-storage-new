package org.isistan.flabot.trace.cloud.launcher;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.launcher.LauncherPlugin;
import org.isistan.flabot.launcher.tabs.AbstractConfigurationTab;
import org.isistan.flabot.trace.cloud.ExtensionPointConstants;
import org.isistan.flabot.trace.cloud.launcher.cloudProvider.CloudProviderLoader;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * Configuration tab for the log persister provider selection
 * @author edacost
 *
 */
public class CloudLogPersisterProviderConfigurationTab extends AbstractConfigurationTab {

	
	/**
	 * Text for the output file name
	 */
	private Text outputFileName;
	/**
	 * Text for the path
	 */
	private Text path;
	/**
	 * Text for the password
	 */
	private Text password;
	/**
	 * Text for the username
	 */
	private Text username;
	/**
	 * Text for the key
	 */
	private Text key;
	/**
	 * Text for the secret
	 */
	private Text secret;
	
	/**
	 * Tab's image 
	 */
	private Image image;

	/**
	 * Status for filename selection 
	 */
	private IStatus filenameSelectionStatus;
	
	/**
	 * Status for service selection
	 */
	private IStatus serviceSelectionStatus;

	/**
	 * Status for path selection
	 */
	private IStatus pathSelectionStatus;

	/**
	 * Status for password selection
	 */
	private IStatus passwordSelectionStatus;

	/**
	 * Status for username selection
	 */
	private IStatus usernameSelectionStatus;

	/**
	 * Status for key selection
	 */
	private IStatus keySelectionStatus;

	/**
	 * Status for secret selection
	 */
	private IStatus secretSelectionStatus;

	/**
	 * The available DriverProviders
	 */
	private IConfigurationElement[] driverProviders;

	/**
	 * Blocks changes
	 */
	private boolean blockChanges = false;
	private Label lblCloudDriver;
	private Combo cloudDriver;
	private Group CloudProviderSelection;

	private Composite parent;

	/**
	 * Creates a new FileLogPersisterProviderConfigurationTab
	 *
	 */
	public CloudLogPersisterProviderConfigurationTab() {
		filenameSelectionStatus = createStatus(IStatus.OK, "");
		serviceSelectionStatus = createStatus(IStatus.OK, "");
		pathSelectionStatus = createStatus(IStatus.OK, "");
		passwordSelectionStatus = createStatus(IStatus.OK, "");
		usernameSelectionStatus = createStatus(IStatus.OK, "");
		keySelectionStatus = createStatus(IStatus.OK, "");
		secretSelectionStatus = createStatus(IStatus.OK, "");
	}

	@Override
	public void dispose() {
		super.dispose();
		//TODO: set image
		//image.dispose();
	}

	public void createControl(Composite parent) {
		this.parent = parent;
		parent.setSize(475, 292);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());

		CloudProviderSelection = new Group(composite, SWT.NONE);
		GridLayout CloudProviderSelectionLayout = new GridLayout();
		CloudProviderSelectionLayout.numColumns = 2;
		CloudProviderSelection.setLayout(CloudProviderSelectionLayout);
		CloudProviderSelection.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		CloudProviderSelection.setText("Cloud Provider Selection");
		lblCloudDriver = new Label(CloudProviderSelection, SWT.NULL);
		lblCloudDriver.setText("Cloud driver:");
		cloudDriver = new Combo(CloudProviderSelection, SWT.NULL);
		GridData cloudDriverLData = new GridData(GridData.FILL_HORIZONTAL);
		cloudDriver.setLayoutData(cloudDriverLData);
		cloudDriver.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				serviceSelectionStatus = validateServiceSelection();
				if (!blockChanges)
					updateStatus();
			}
		});

		
		Group group = new Group(composite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		GridData groupLData = new GridData();
		groupLData.horizontalAlignment = GridData.FILL;
		groupLData.heightHint = 208;
		groupLData.grabExcessHorizontalSpace = true;
		group.setText("Cloud storage configuration");
		group.setLayout(layout);
		group.setLayoutData(groupLData);

		Label labelOutputFileName = new Label(group, SWT.NULL);
		labelOutputFileName.setText("File Name:");
		outputFileName = new Text(group, SWT.BORDER);
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = true;
		outputFileName.setLayoutData(gd);
		outputFileName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				filenameSelectionStatus = validateFilenameSelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		outputFileName.setEditable(true);
		/*
		Label labelService = new Label(group, SWT.NULL);
		labelService.setText("Service:");
		service = new Text(group, SWT.BORDER);
		service.setLayoutData(gd);
		service.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				serviceSelectionStatus = validateServiceSelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		service.setEditable(true);
*/
		Label labelPath = new Label(group, SWT.NULL);
		labelPath.setText("Path:");
		path = new Text(group, SWT.BORDER);
		path.setLayoutData(gd);
		path.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				pathSelectionStatus = validatePathSelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		path.setEditable(true);

		Label labelUsername = new Label(group, SWT.NULL);
		labelUsername.setText("Username:");
		username = new Text(group, SWT.BORDER);
		username.setLayoutData(gd);
		username.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				usernameSelectionStatus = validateUsernameSelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		username.setEditable(true);

		Label labelPassword = new Label(group, SWT.NULL);
		labelPassword.setText("Password:");
		password = new Text(group, SWT.BORDER);
		password.setLayoutData(gd);
		password.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				passwordSelectionStatus = validatePasswordSelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		password.setEditable(true);

		Label labelKey = new Label(group, SWT.NULL);
		labelKey.setText("Key:");
		key = new Text(group, SWT.BORDER);
		key.setLayoutData(gd);
		key.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				keySelectionStatus = validateKeySelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		key.setEditable(true);

		Label labelSecret = new Label(group, SWT.NULL);
		labelSecret.setText("Secret:");
		secret = new Text(group, SWT.BORDER);
		secret.setLayoutData(gd);
		secret.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				secretSelectionStatus = validateSecretSelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		secret.setEditable(true);
		

	}
		
		//TODO: INFO See how help is added
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IHelpContextIds.LAUNCHER_BASIC);
	
	
	/**
	 * Creates the output file section
	 * @param composite
	 */
	protected void createOutputFileSection(Composite composite) {

	}

	public void initializeFrom(ILaunchConfiguration config) {
		try {
			blockChanges = true;			
			initializeDriverProviderSection(config);
			
			initializeStorageConfigurationSection(config);
			
			updateStatus();
		} catch (CoreException e) {
			//TODO: send to log
			e.printStackTrace();
		} finally {
			blockChanges = false;
		}
	}
	
	/**
	 * Initializes the connection settings section
	 * 
	 * @param config
	 * @throws CoreException
	 */
	protected void initializeStorageConfigurationSection(
			ILaunchConfiguration config) throws CoreException {

		String fileName = config.getAttribute(LaunchConfigurationConstants.FILENAME, "");
		outputFileName.setText(fileName);

		String userName = config.getAttribute(
				LaunchConfigurationConstants.USERNAME, "");
		username.setText(userName);

		String passWord = config.getAttribute(
				LaunchConfigurationConstants.PASSWORD, "");
		password.setText(passWord);

		String path_ = config.getAttribute(
				LaunchConfigurationConstants.PATH, "");
		path.setText(path_);

		String key_ = config.getAttribute(
				LaunchConfigurationConstants.KEY, "");
		key.setText(key_);

		String secret_ = config.getAttribute(
				LaunchConfigurationConstants.SECRET, "");
		secret.setText(secret_);
	}

	/**
	 * Initilizes the output file section
	 * @param config
	 * @throws CoreException
	 */
	protected void initializeDriverProviderSection(ILaunchConfiguration config)
			throws CoreException {
		driverProviders = CloudProviderLoader
				.getAllCloudProviderConfigurationElements();

		List<String> driverProviderNames = new ArrayList<String>(
				driverProviders.length);
		for (int i = 0; i < driverProviders.length; i++) {
			IConfigurationElement driverProvider = driverProviders[i];
			String driverProviderName = getTextualRepresentation(
					driverProvider,
					ExtensionPointConstants.CLOUD_PROVIDER__NAME_ATTRIBUTE,
					ExtensionPointConstants.CLOUD_PROVIDER__ID_ATTRIBUTE);
			driverProviderNames.add(driverProviderName);
		}

		cloudDriver.setItems(driverProviderNames
				.toArray(new String[driverProviderNames.size()]));
		if (cloudDriver.getItemCount() > 0) {
			String selectedDriverProviderId = config.getAttribute(
					LaunchConfigurationConstants.SERVICE, "");
			int selection = idToIndex(driverProviders,
					selectedDriverProviderId,
					ExtensionPointConstants.CLOUD_PROVIDER__ID_ATTRIBUTE);
			cloudDriver.select(selection);

		}
		
		cloudDriver.select(0);
		
		/*
		String outputFile = config.getAttribute(
				LaunchConfigurationConstants.FILENAME, "");
		outputFileText.setText(outputFile);*/
	}
	
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(LaunchConfigurationConstants.FILENAME, ""); //$NON-NLS-1$
	}
	
	/**
	 * Updates the tab status
	 *
	 */
	private void updateStatus() {
		updateStatus(getMoreSevere(filenameSelectionStatus,
						serviceSelectionStatus,
						pathSelectionStatus,
						passwordSelectionStatus,
						usernameSelectionStatus,
						keySelectionStatus,
						secretSelectionStatus));
	}

	public void performApply(ILaunchConfigurationWorkingCopy config) {
		try {
			saveOutputFileDataSection(config);
		} catch (CoreException e) {
			//TODO: send to log
			e.printStackTrace();
		}
	}

	/**
	 * Saves the output cloud configuration data
	 * @param config
	 * @throws CoreException
	 */
	protected void saveOutputFileDataSection(ILaunchConfigurationWorkingCopy config)
			throws CoreException {
		config.setAttribute(LaunchConfigurationConstants.FILENAME,
				outputFileName.getText());
		config.setAttribute(LaunchConfigurationConstants.SERVICE,
				cloudDriver.getText());
		config.setAttribute(LaunchConfigurationConstants.PATH,
				path.getText());
		config.setAttribute(LaunchConfigurationConstants.PASSWORD,
				password.getText());
		config.setAttribute(LaunchConfigurationConstants.USERNAME,
				username.getText());
		config.setAttribute(LaunchConfigurationConstants.KEY,
				key.getText());
		config.setAttribute(LaunchConfigurationConstants.SECRET,
				secret.getText());
	}

	/**
	 * Validates the output file selection
	 * @return
	 */
	private IStatus validateFilenameSelection() {
		String filename_ = outputFileName.getText();
		if (filename_.trim().length()==0) {
			return createStatus(
				IStatus.ERROR,
				"Output file name selected.");
		}

		// TODO: check if file is valid
		if (false) {
			return createStatus(
				IStatus.ERROR,
				"Invalid output file.");
		}

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}
	
	/**
	 * Validates the username selection
	 * 
	 * @return
	 */
	private IStatus validateUsernameSelection() {
		String username_ = username.getText();
		if (username_.trim().length() == 0) {
			return createStatus(IStatus.ERROR, "Username not selected.");
		}

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}
	
	/**
	 * Validates the username selection
	 * 
	 * @return
	 */
	private IStatus validatePasswordSelection() {
		String password_ = password.getText();
		if (password_.trim().length() == 0) {
			return createStatus(IStatus.ERROR, "Password not selected.");
		}

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}

	/**
	 * Validates the username selection
	 * 
	 * @return
	 */
	private IStatus validateServiceSelection() {
		String service_ = cloudDriver.getText();
		if (service_.trim().length() == 0) {
			return createStatus(IStatus.ERROR, "Service not selected.");
		}

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}

	/**
	 * Validates the username selection
	 * 
	 * @return
	 */
	private IStatus validatePathSelection() {
		String path_ = path.getText();
		if (path_.trim().length() == 0) {
			return createStatus(IStatus.ERROR, "Path not selected.");
		}

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}

	/**
	 * Validates the username selection
	 * 
	 * @return
	 */
	private IStatus validateKeySelection() {
		String key_ = key.getText();
		if (key_.trim().length() == 0) {
			return createStatus(IStatus.ERROR, "Key not selected.");
		}

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}

	/**
	 * Validates the username selection
	 * 
	 * @return
	 */
	private IStatus validateSecretSelection() {
		String secret_ = secret.getText();
		if (secret_.trim().length() == 0) {
			return createStatus(IStatus.ERROR, "Secret not selected.");
		}

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}

	public String getName() {
		return "Main";
	}
	
	@Override
	public Image getImage() {
		return image;
	}
	
	/**
	 * Creates a new Status
	 * @param severity
	 * @param message
	 * @return
	 */
	private static IStatus createStatus(int severity, String message) {
		return AbstractConfigurationTab.createStatus(
				LauncherPlugin.SYMBOLIC_NAME, severity, message);
	}	
}
