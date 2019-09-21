/**
 * generated by Xtext 2.18.0
 */
package org.jucmnav.turn.turn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.Timer#getKind <em>Kind</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.Timer#getName <em>Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.Timer#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.Timer#getTimeoutCondition <em>Timeout Condition</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.Timer#getTimeoutPath <em>Timeout Path</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.Timer#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.jucmnav.turn.turn.TurnPackage#getTimer()
 * @model
 * @generated
 */
public interface Timer extends URNmodelElement, PathBodyNode, ConnectElement
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.jucmnav.turn.turn.WaitKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.jucmnav.turn.turn.WaitKind
   * @see #setKind(WaitKind)
   * @see org.jucmnav.turn.turn.TurnPackage#getTimer_Kind()
   * @model
   * @generated
   */
  WaitKind getKind();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.Timer#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.jucmnav.turn.turn.WaitKind
   * @see #getKind()
   * @generated
   */
  void setKind(WaitKind value);

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
   * @see org.jucmnav.turn.turn.TurnPackage#getTimer_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.Timer#getName <em>Name</em>}' attribute.
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
   * @see org.jucmnav.turn.turn.TurnPackage#getTimer_LongName()
   * @model containment="true"
   * @generated
   */
  LongName getLongName();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.Timer#getLongName <em>Long Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long Name</em>' containment reference.
   * @see #getLongName()
   * @generated
   */
  void setLongName(LongName value);

  /**
   * Returns the value of the '<em><b>Timeout Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout Condition</em>' containment reference.
   * @see #setTimeoutCondition(Condition)
   * @see org.jucmnav.turn.turn.TurnPackage#getTimer_TimeoutCondition()
   * @model containment="true"
   * @generated
   */
  Condition getTimeoutCondition();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.Timer#getTimeoutCondition <em>Timeout Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout Condition</em>' containment reference.
   * @see #getTimeoutCondition()
   * @generated
   */
  void setTimeoutCondition(Condition value);

  /**
   * Returns the value of the '<em><b>Timeout Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout Path</em>' containment reference.
   * @see #setTimeoutPath(PathBody)
   * @see org.jucmnav.turn.turn.TurnPackage#getTimer_TimeoutPath()
   * @model containment="true"
   * @generated
   */
  PathBody getTimeoutPath();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.Timer#getTimeoutPath <em>Timeout Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout Path</em>' containment reference.
   * @see #getTimeoutPath()
   * @generated
   */
  void setTimeoutPath(PathBody value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Condition)
   * @see org.jucmnav.turn.turn.TurnPackage#getTimer_Condition()
   * @model containment="true"
   * @generated
   */
  Condition getCondition();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.Timer#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Condition value);

} // Timer
