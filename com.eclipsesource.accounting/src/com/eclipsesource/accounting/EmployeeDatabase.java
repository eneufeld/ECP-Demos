/**
 */
package com.eclipsesource.accounting;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Employee Database</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eclipsesource.accounting.EmployeeDatabase#getEmployees <em>Employees</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eclipsesource.accounting.AccountingPackage#getEmployeeDatabase()
 * @model
 * @generated
 */
public interface EmployeeDatabase extends EObject {
	/**
	 * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
	 * The list contents are of type {@link com.eclipsesource.accounting.Employee}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' containment reference list.
	 * @see com.eclipsesource.accounting.AccountingPackage#getEmployeeDatabase_Employees()
	 * @model containment="true"
	 * @generated
	 */
	EList<Employee> getEmployees();

} // EmployeeDatabase
