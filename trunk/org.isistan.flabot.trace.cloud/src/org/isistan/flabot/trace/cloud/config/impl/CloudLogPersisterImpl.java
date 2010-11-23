/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.trace.cloud.config.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.isistan.flabot.trace.cloud.TraceCloudPlugin;
import org.isistan.flabot.trace.cloud.config.CloudLogPersister;
import org.isistan.flabot.trace.cloud.config.ConfigPackage;
import org.isistan.flabot.trace.cloud.launcher.LaunchConfigurationConstants;
import org.isistan.flabot.trace.cloud.launcher.cloudProvider.CloudProvider;
import org.isistan.flabot.trace.cloud.launcher.cloudProvider.CloudProviderLoader;
import org.isistan.flabot.trace.cloud.launcher.cloudProvider.CloudProviderPropertiesConstants;
import org.isistan.flabot.trace.cloud.log.CloudTraceLogFactory;
import org.isistan.flabot.trace.config.impl.LogPersisterImpl;
import org.isistan.flabot.trace.log.LogPackage;
import org.isistan.flabot.trace.log.TraceLog;
import org.isistan.flabot.trace.log.TraceLogFactory;
import org.isistan.flabot.util.extension.NoMatchingConstructorFoundException;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.common.util.URI;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cloud Log Persister</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl#getService <em>Service</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl#getSecret <em>Secret</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CloudLogPersisterImpl extends LogPersisterImpl implements CloudLogPersister {
	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = "traceOutput.tracelog";

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_EDEFAULT = "S3";

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected String service = SERVICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = "/";

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecret() <em>Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecret()
	 * @generated
	 * @ordered
	 */
	protected static final String SECRET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecret() <em>Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecret()
	 * @generated
	 * @ordered
	 */
	protected String secret = SECRET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CloudLogPersisterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.CLOUD_LOG_PERSISTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CLOUD_LOG_PERSISTER__FILE_NAME, oldFileName, fileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(String newService) {
		String oldService = service;
		service = newService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CLOUD_LOG_PERSISTER__SERVICE, oldService, service));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CLOUD_LOG_PERSISTER__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CLOUD_LOG_PERSISTER__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CLOUD_LOG_PERSISTER__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CLOUD_LOG_PERSISTER__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecret(String newSecret) {
		String oldSecret = secret;
		secret = newSecret;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CLOUD_LOG_PERSISTER__SECRET, oldSecret, secret));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.CLOUD_LOG_PERSISTER__FILE_NAME:
				return getFileName();
			case ConfigPackage.CLOUD_LOG_PERSISTER__SERVICE:
				return getService();
			case ConfigPackage.CLOUD_LOG_PERSISTER__PATH:
				return getPath();
			case ConfigPackage.CLOUD_LOG_PERSISTER__PASSWORD:
				return getPassword();
			case ConfigPackage.CLOUD_LOG_PERSISTER__USERNAME:
				return getUsername();
			case ConfigPackage.CLOUD_LOG_PERSISTER__KEY:
				return getKey();
			case ConfigPackage.CLOUD_LOG_PERSISTER__SECRET:
				return getSecret();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.CLOUD_LOG_PERSISTER__FILE_NAME:
				setFileName((String)newValue);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__SERVICE:
				setService((String)newValue);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__PATH:
				setPath((String)newValue);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__PASSWORD:
				setPassword((String)newValue);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__USERNAME:
				setUsername((String)newValue);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__KEY:
				setKey((String)newValue);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__SECRET:
				setSecret((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigPackage.CLOUD_LOG_PERSISTER__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__SERVICE:
				setService(SERVICE_EDEFAULT);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case ConfigPackage.CLOUD_LOG_PERSISTER__SECRET:
				setSecret(SECRET_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigPackage.CLOUD_LOG_PERSISTER__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case ConfigPackage.CLOUD_LOG_PERSISTER__SERVICE:
				return SERVICE_EDEFAULT == null ? service != null : !SERVICE_EDEFAULT.equals(service);
			case ConfigPackage.CLOUD_LOG_PERSISTER__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case ConfigPackage.CLOUD_LOG_PERSISTER__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case ConfigPackage.CLOUD_LOG_PERSISTER__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case ConfigPackage.CLOUD_LOG_PERSISTER__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case ConfigPackage.CLOUD_LOG_PERSISTER__SECRET:
				return SECRET_EDEFAULT == null ? secret != null : !SECRET_EDEFAULT.equals(secret);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileName: ");
		result.append(fileName);
		result.append(", service: ");
		result.append(service);
		result.append(", path: ");
		result.append(path);
		result.append(", password: ");
		result.append(password);
		result.append(", username: ");
		result.append(username);
		result.append(", key: ");
		result.append(key);
		result.append(", secret: ");
		result.append(secret);
		result.append(')');
		return result.toString();
	}

	public void clear() {
		if (resource == null) {
			getResource(true);
		} else {
			resource.getContents().clear();
		}
	}

	private Resource resource;
	private Map<String,String> propertiesMap; 
	
	private void setPropertiesMap(Map<String,String> propertiesMap){
		this.propertiesMap = propertiesMap;
	}
	
	private Map<String,String> getPropertiesMap(){
		if(propertiesMap == null) {
			Map<String,String> properties = new HashMap<String, String>();
			properties.put(CloudProviderPropertiesConstants.FILE_NAME, getFileName());
			properties.put(CloudProviderPropertiesConstants.KEY, getKey());
			properties.put(CloudProviderPropertiesConstants.LOCAL_FILE_NAME, LOCAL_FILE_NAME);
			properties.put(CloudProviderPropertiesConstants.PASSWORD, getPassword());
			properties.put(CloudProviderPropertiesConstants.PATH, getPath());
			properties.put(CloudProviderPropertiesConstants.SECRET, getSecret());
			properties.put(CloudProviderPropertiesConstants.USER_NAME, getUsername());
			setPropertiesMap(properties);
		}
		
		return this.propertiesMap;
	}
	
	private final String LOCAL_FILE_NAME = "./temp.xmi";

	private Resource getResource(boolean cleared) {
		if (resource == null) {
			try {
				getCloudProvider().load(getPropertiesMap());
			} catch (Exception e) {
				cleared = true;
				//throw new RuntimeException(e);
			}
			
			if (cleared) {
				URI uri = URI.createFileURI(LOCAL_FILE_NAME);
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry()
						.getExtensionToFactoryMap().put(
								Resource.Factory.Registry.DEFAULT_EXTENSION,
								new XMIResourceFactoryImpl());

				if (LogPackage.eINSTANCE == null)
					;
				resource = resourceSet.createResource(uri);

			} else {
				resource = new XMIResourceImpl(URI.createFileURI(LOCAL_FILE_NAME));
				try {
					Map<String, Object> options = new HashMap<String, Object>();
					options.put(XMIResource.OPTION_ZIP, Boolean.TRUE);
					resource.load(options);
					
					//resource.load(Collections.emptyMap());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return resource;
	}

	public void save() {
		if (resource == null) {
			return;
		}
		try {
			
			Map<String, Object> options = new HashMap<String, Object>();
			options.put(XMIResource.OPTION_ZIP, Boolean.TRUE);
			resource.save(options);
			
			//resource.save(Collections.EMPTY_MAP);

			getCloudProvider().save(getPropertiesMap());
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error commiting log changes to file.",
					e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void close() {
	}

	public TraceLog[] loadTraceLogs() {
		Resource resource = getResource(false);
		List<?> traceLogList = resource.getContents();
		TraceLog[] traceLogs = traceLogList.toArray(new TraceLog[traceLogList
				.size()]);
		Arrays.sort(traceLogs, new Comparator<TraceLog>() {

			public int compare(TraceLog traceLog1, TraceLog traceLog2) {
				return Long.valueOf(traceLog1.getTimeStamp()).compareTo(
						traceLog2.getTimeStamp());
			}

		});
		return traceLogs;
	}

	private TraceLogFactory factory;

	public TraceLogFactory getTraceLogFactory() {
		if (factory == null) {
			factory = new CloudTraceLogFactory(getResource(false));
		}
		return factory;
	}

	public long getSize() {
		if (resource == null) {
			return 0;
		} else {
			File file=new File(LOCAL_FILE_NAME);
			if(!file.exists()) {
				return 0;
			} else {
				return file.length();
			}
		}
	}


	private CloudProvider cloudProvider = null;
	
	public CloudProvider getCloudProvider() throws CoreException {
		

		if(cloudProvider == null) {
			try {
				CloudProvider prov = (CloudProvider) Class.forName(this.getService()).newInstance();
				this.setCloudProvider(prov);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}	
		}
		
		return cloudProvider;
	}

	public void setCloudProvider(CloudProvider cloudProvider) {
		this.cloudProvider = cloudProvider;
	}
	
} 
