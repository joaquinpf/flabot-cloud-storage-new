package org.isistan.flabot.trace.cloud.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.isistan.flabot.launcher.LauncherPlugin;
import org.isistan.flabot.launcher.tabs.AbstractConfigurationTab;


/**
 * Configuration tab for the log persister provider selection
 * @author edacost
 *
 */
public class FileLogPersisterProviderConfigurationTab extends AbstractConfigurationTab {

	
	/**
	 * Text for the output file
	 */
	private Text outputFileText;
	
	/**
	 * Tab's image 
	 */
	private Image image;

	/**
	 * Status for output file selection 
	 */
	private IStatus outputFileSelectionStatus;
	
	/**
	 * Blocks changes
	 */
	private boolean blockChanges = false;

	private Composite parent;

	/**
	 * Creates a new FileLogPersisterProviderConfigurationTab
	 *
	 */
	public FileLogPersisterProviderConfigurationTab() {
		outputFileSelectionStatus = createStatus(IStatus.OK, ""); //$NON-NLS-1$
		//TODO: set image
		//image = PDEPluginImages.DESC_MAIN_TAB.createImage();
	}

	@Override
	public void dispose() {
		super.dispose();
		//TODO: set image
		//image.dispose();
	}

	public void createControl(Composite parent) {
		this.parent=parent;
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		createOutputFileSection(composite);
		
		setControl(composite);
		
		//TODO: INFO See how help is added
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IHelpContextIds.LAUNCHER_BASIC);
	}
	
	/**
	 * Creates the output file section
	 * @param composite
	 */
	protected void createOutputFileSection(Composite composite) {
		Group group = new Group(composite, SWT.NONE);
		group.setText("Output File Selection");
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(group, SWT.NULL);
		label.setText("Output File");
		


		outputFileText = new Text(group, SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		outputFileText.setLayoutData(gd);

		
		outputFileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				outputFileSelectionStatus = validateOutputFileSelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		outputFileText.setEditable(false);

		Button button= new Button(group, SWT.NULL);
		button.setText("...");
		
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				browseOutputFile();
			}
			public void widgetDefaultSelected(SelectionEvent e) {				
			}
			
		});
	}

	private void browseOutputFile() {
		SaveAsDialog dialog = new SaveAsDialog(parent.getShell());

		String fileName = outputFileText.getText().trim();
		if (fileName.length() == 0)
			dialog.setOriginalName(fileName);
		dialog.setTitle("Trace Log File Selection");
		// dialog.setMessage("Select where the trace log should be saved.");
		dialog.create();
		if (dialog.open() == Window.OK) {
			IPath path = dialog.getResult();
			if (path == null)
				return;
			String extension = path.getFileExtension();
			String file = path.toPortableString();
			if (extension == null || extension.length() == 0) {
				file = file + ".tracelog";
			}

			outputFileText.setText(file);
		}
	}
	
	public void initializeFrom(ILaunchConfiguration config) {
		try {
			blockChanges = true;			
			initializeOutputFileSection(config);
			outputFileSelectionStatus = validateOutputFileSelection();
			updateStatus();
		} catch (CoreException e) {
			//TODO: send to log
			e.printStackTrace();
		} finally {
			blockChanges = false;
		}
	}
	
	/**
	 * Initilizes the output file section
	 * @param config
	 * @throws CoreException
	 */
	protected void initializeOutputFileSection(ILaunchConfiguration config)
			throws CoreException {
		
		String outputFile=config.getAttribute(
				LaunchConfigurationConstants.OUTPUT_FILE, "");
		outputFileText.setText(outputFile);
	}
	
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(LaunchConfigurationConstants.OUTPUT_FILE, ""); //$NON-NLS-1$
	}
	
	/**
	 * Updates the tab status
	 *
	 */
	private void updateStatus() {
		updateStatus(outputFileSelectionStatus);
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
	 * Saves the output file data
	 * @param config
	 * @throws CoreException
	 */
	protected void saveOutputFileDataSection(ILaunchConfigurationWorkingCopy config)
			throws CoreException {
		config.setAttribute(LaunchConfigurationConstants.OUTPUT_FILE,
				outputFileText.getText());
	}

	/**
	 * Validates the output file selection
	 * @return
	 */
	private IStatus validateOutputFileSelection() {
		String outputFile = outputFileText.getText();
		if (outputFile.trim().length()==0) {
			return createStatus(
				IStatus.ERROR,
				"Output file not selected.");
		}

		// TODO: check if file is valid
		if (false) {
			return createStatus(
				IStatus.ERROR,
				"Invalid output file.");
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
