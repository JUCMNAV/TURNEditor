/**
 * generated by Xtext 2.18.0
 */
package org.jucmnav.turn.turn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contribution Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.ContributionContext#getName <em>Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.ContributionContext#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.ContributionContext#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.ContributionContext#getIncludedContext <em>Included Context</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.ContributionContext#getIncludedContexts <em>Included Contexts</em>}</li>
 * </ul>
 *
 * @see org.jucmnav.turn.turn.TurnPackage#getContributionContext()
 * @model
 * @generated
 */
public interface ContributionContext extends URNmodelElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.jucmnav.turn.turn.TurnPackage#getContributionContext_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.ContributionContext#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Long Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Long Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Long Name</em>' containment reference.
   * @see #setLongName(LongName)
   * @see org.jucmnav.turn.turn.TurnPackage#getContributionContext_LongName()
   * @model containment="true"
   * @generated
   */
  LongName getLongName();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.ContributionContext#getLongName <em>Long Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long Name</em>' containment reference.
   * @see #getLongName()
   * @generated
   */
  void setLongName(LongName value);

  /**
   * Returns the value of the '<em><b>Changes</b></em>' containment reference list.
   * The list contents are of type {@link org.jucmnav.turn.turn.ContributionChange}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Changes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Changes</em>' containment reference list.
   * @see org.jucmnav.turn.turn.TurnPackage#getContributionContext_Changes()
   * @model containment="true"
   * @generated
   */
  EList<ContributionChange> getChanges();

  /**
   * Returns the value of the '<em><b>Included Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Included Context</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Included Context</em>' reference.
   * @see #setIncludedContext(ContributionContext)
   * @see org.jucmnav.turn.turn.TurnPackage#getContributionContext_IncludedContext()
   * @model
   * @generated
   */
  ContributionContext getIncludedContext();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.ContributionContext#getIncludedContext <em>Included Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Included Context</em>' reference.
   * @see #getIncludedContext()
   * @generated
   */
  void setIncludedContext(ContributionContext value);

  /**
   * Returns the value of the '<em><b>Included Contexts</b></em>' reference list.
   * The list contents are of type {@link org.jucmnav.turn.turn.ContributionContext}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Included Contexts</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Included Contexts</em>' reference list.
   * @see org.jucmnav.turn.turn.TurnPackage#getContributionContext_IncludedContexts()
   * @model
   * @generated
   */
  EList<ContributionContext> getIncludedContexts();

} // ContributionContext
