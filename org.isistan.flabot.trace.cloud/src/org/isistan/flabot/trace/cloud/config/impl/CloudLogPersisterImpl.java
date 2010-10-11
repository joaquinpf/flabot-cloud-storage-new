/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.trace.cloud.config.impl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import org.isistan.flabot.trace.cloud.config.CloudLogPersister;
import org.isistan.flabot.trace.config.impl.LogPersisterImpl;

import org.isistan.flabot.trace.file.config.ConfigPackage;
import org.isistan.flabot.trace.file.config.FileLogPersister;
import org.isistan.flabot.trace.file.log.FileTraceLogFactory;
import org.isistan.flabot.trace.log.LogPackage;
import org.isistan.flabot.trace.log.TraceLog;
import org.isistan.flabot.trace.log.TraceLogFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>File Log Persister</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.isistan.flabot.trace.file.config.impl.FileLogPersisterImpl#getFileName <em>File Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CloudLogPersisterImpl extends LogPersisterImpl implements
	CloudLogPersister {
	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = "traceOutput.tracelog";
w
	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CloudLogPersisterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.FILE_LOG_PERSISTER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					org.isistan.flabot.trace.cloud.config.FILE_LOG_PERSISTER__FILE_NAME, oldFileName,
					fileName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case org.isistan.flabot.trace.cloud.config.FILE_LOG_PERSISTER__FILE_NAME:
			return getFileName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case org.isistan.flabot.trace.cloud.config.FILE_LOG_PERSISTER__FILE_NAME:
			setFileName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case org.isistan.flabot.trace.cloud.config.FILE_LOG_PERSISTER__FILE_NAME:
			setFileName(FILE_NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case org.isistan.flabot.trace.cloud.config.FILE_LOG_PERSISTER__FILE_NAME:
			return FILE_NAME_EDEFAULT == null ? fileName != null
					: !FILE_NAME_EDEFAULT.equals(fileName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileName: ");
		result.append(fileName);
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

	private Resource getResource(boolean cleared) {
		if (resource == null) {
			if (cleared) {
				URI uri = URI.createFileURI(getFileName());
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry()
						.getExtensionToFactoryMap().put(
								Resource.Factory.Registry.DEFAULT_EXTENSION,
								new XMIResourceFactoryImpl());

				if (LogPackage.eINSTANCE == null)
					;
				resource = resourceSet.createResource(uri);

			} else {
				resource = new XMIResourceImpl(URI.createFileURI(getFileName()));
				try {
					resource.load(Collections.emptyMap());
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
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error commiting log changes to file.",
					e);
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
			factory = new FileTraceLogFactory(getResource(false));
		}
		return factory;
	}

	public long getSize() {
		if (resource == null) {
			return 0;
		} else {
			File file=new File(getFileName());
			if(!file.exists()) {
				return 0;
			} else {
				return file.length();
			}
		}
	}

} // FileLogPersisterImpl
