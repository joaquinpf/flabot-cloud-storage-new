/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.trace.cloud.config;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.trace.cloud.config.ConfigFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "config";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/trace/cloud/config.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.trace.cloud.config";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigPackage eINSTANCE = org.isistan.flabot.trace.cloud.config.impl.ConfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl <em>Cloud Log Persister</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl
	 * @see org.isistan.flabot.trace.cloud.config.impl.ConfigPackageImpl#getCloudLogPersister()
	 * @generated
	 */
	int CLOUD_LOG_PERSISTER = 0;

	/**
	 * The feature id for the '<em><b>Trace Configuration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER__TRACE_CONFIGURATION = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER__TRACE_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER__FILE_NAME = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER__SERVICE = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER__PATH = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER__PASSWORD = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER__USERNAME = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER__KEY = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER__SECRET = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Cloud Log Persister</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER_FEATURE_COUNT = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER_FEATURE_COUNT + 7;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister <em>Cloud Log Persister</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cloud Log Persister</em>'.
	 * @see org.isistan.flabot.trace.cloud.config.CloudLogPersister
	 * @generated
	 */
	EClass getCloudLogPersister();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.isistan.flabot.trace.cloud.config.CloudLogPersister#getFileName()
	 * @see #getCloudLogPersister()
	 * @generated
	 */
	EAttribute getCloudLogPersister_FileName();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service</em>'.
	 * @see org.isistan.flabot.trace.cloud.config.CloudLogPersister#getService()
	 * @see #getCloudLogPersister()
	 * @generated
	 */
	EAttribute getCloudLogPersister_Service();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.isistan.flabot.trace.cloud.config.CloudLogPersister#getPath()
	 * @see #getCloudLogPersister()
	 * @generated
	 */
	EAttribute getCloudLogPersister_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.isistan.flabot.trace.cloud.config.CloudLogPersister#getPassword()
	 * @see #getCloudLogPersister()
	 * @generated
	 */
	EAttribute getCloudLogPersister_Password();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.isistan.flabot.trace.cloud.config.CloudLogPersister#getUsername()
	 * @see #getCloudLogPersister()
	 * @generated
	 */
	EAttribute getCloudLogPersister_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.isistan.flabot.trace.cloud.config.CloudLogPersister#getKey()
	 * @see #getCloudLogPersister()
	 * @generated
	 */
	EAttribute getCloudLogPersister_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getSecret <em>Secret</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secret</em>'.
	 * @see org.isistan.flabot.trace.cloud.config.CloudLogPersister#getSecret()
	 * @see #getCloudLogPersister()
	 * @generated
	 */
	EAttribute getCloudLogPersister_Secret();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigFactory getConfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl <em>Cloud Log Persister</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.trace.cloud.config.impl.CloudLogPersisterImpl
		 * @see org.isistan.flabot.trace.cloud.config.impl.ConfigPackageImpl#getCloudLogPersister()
		 * @generated
		 */
		EClass CLOUD_LOG_PERSISTER = eINSTANCE.getCloudLogPersister();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOUD_LOG_PERSISTER__FILE_NAME = eINSTANCE.getCloudLogPersister_FileName();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOUD_LOG_PERSISTER__SERVICE = eINSTANCE.getCloudLogPersister_Service();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOUD_LOG_PERSISTER__PATH = eINSTANCE.getCloudLogPersister_Path();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOUD_LOG_PERSISTER__PASSWORD = eINSTANCE.getCloudLogPersister_Password();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOUD_LOG_PERSISTER__USERNAME = eINSTANCE.getCloudLogPersister_Username();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOUD_LOG_PERSISTER__KEY = eINSTANCE.getCloudLogPersister_Key();

		/**
		 * The meta object literal for the '<em><b>Secret</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOUD_LOG_PERSISTER__SECRET = eINSTANCE.getCloudLogPersister_Secret();

	}

} //ConfigPackage
