/**
 * $Id: Context.java,v 1.1 2006/01/27 19:46:04 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.trace.cloud.config;

import org.isistan.flabot.trace.config.LogPersister;

/**
 * A standard EMF file log persister.
 * 
 * @author $Author: dacostae $
 * @model
 */
public interface CloudLogPersister extends LogPersister {
w
	/**
	 * Get the output file's name
	 * 
	 * @return the output file's name
	 * @model default="traceOutput.tracelog"
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.file.config.FileLogPersister#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);
}
