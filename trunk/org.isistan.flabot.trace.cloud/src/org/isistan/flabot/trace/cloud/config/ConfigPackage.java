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
import org.isistan.flabot.trace.cloud.config.impl.ConfigPackageImpl;

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
 * @see org.isistan.flabot.trace.cloud.config.file.config.ConfigFactory
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
	 * The meta object id for the '{@link org.isistan.flabot.trace.file.config.impl.FileLogPersisterImpl <em>File Log Persister</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.trace.file.config.impl.FileLogPersisterImpl
	 * @see org.isistan.flabot.trace.cloud.config.impl.file.config.impl.ConfigPackageImpl#getFileLogPersister()
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
	 * The number of structural features of the '<em>File Log Persister</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOUD_LOG_PERSISTER_FEATURE_COUNT = org.isistan.flabot.trace.config.ConfigPackage.LOG_PERSISTER_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.trace.file.config.FileLogPersister <em>File Log Persister</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Log Persister</em>'.
	 * @see org.isistan.flabot.trace.file.config.FileLogPersister
	 * @generated
	 */
	EClass getCloudLogPersister();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.file.config.FileLogPersister#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.isistan.flabot.trace.file.config.FileLogPersister#getFileName()
	 * @see #getFileLogPersister()
	 * @generated
	 */
	EAttribute getCloudLogPersister_FileName();

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
		 * The meta object literal for the '{@link org.isistan.flabot.trace.file.config.impl.FileLogPersisterImpl <em>File Log Persister</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.trace.file.config.impl.FileLogPersisterImpl
		 * @see org.isistan.flabot.trace.cloud.config.impl.file.config.impl.ConfigPackageImpl#getFileLogPersister()
		 * @generated
		 */
		EClass FILE_LOG_PERSISTER = eINSTANCE.getCloudLogPersister();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_LOG_PERSISTER__FILE_NAME = eINSTANCE.getCloudLogPersister_FileName();

	}

} //ConfigPackage
