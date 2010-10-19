/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.trace.cloud.config;

import org.isistan.flabot.trace.config.LogPersister;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cloud Log Persister</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getService <em>Service</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getPath <em>Path</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getPassword <em>Password</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getUsername <em>Username</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getKey <em>Key</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getSecret <em>Secret</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.trace.cloud.config.ConfigPackage#getCloudLogPersister()
 * @model
 * @generated
 */
public interface CloudLogPersister extends LogPersister {
	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * The default value is <code>"traceOutput.tracelog"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.isistan.flabot.trace.cloud.config.ConfigPackage#getCloudLogPersister_FileName()
	 * @model default="traceOutput.tracelog"
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' attribute.
	 * The default value is <code>"S3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' attribute.
	 * @see #setService(String)
	 * @see org.isistan.flabot.trace.cloud.config.ConfigPackage#getCloudLogPersister_Service()
	 * @model default="S3"
	 * @generated
	 */
	String getService();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getService <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' attribute.
	 * @see #getService()
	 * @generated
	 */
	void setService(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * The default value is <code>"/"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.isistan.flabot.trace.cloud.config.ConfigPackage#getCloudLogPersister_Path()
	 * @model default="/"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.isistan.flabot.trace.cloud.config.ConfigPackage#getCloudLogPersister_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.isistan.flabot.trace.cloud.config.ConfigPackage#getCloudLogPersister_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.isistan.flabot.trace.cloud.config.ConfigPackage#getCloudLogPersister_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secret</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secret</em>' attribute.
	 * @see #setSecret(String)
	 * @see org.isistan.flabot.trace.cloud.config.ConfigPackage#getCloudLogPersister_Secret()
	 * @model
	 * @generated
	 */
	String getSecret();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.cloud.config.CloudLogPersister#getSecret <em>Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secret</em>' attribute.
	 * @see #getSecret()
	 * @generated
	 */
	void setSecret(String value);

} // CloudLogPersister
