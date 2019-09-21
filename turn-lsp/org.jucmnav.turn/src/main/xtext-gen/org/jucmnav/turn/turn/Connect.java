/**
 * generated by Xtext 2.18.0
 */
package org.jucmnav.turn.turn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.Connect#getConnectsTo <em>Connects To</em>}</li>
 * </ul>
 *
 * @see org.jucmnav.turn.turn.TurnPackage#getConnect()
 * @model
 * @generated
 */
public interface Connect extends PathBodyNode
{
  /**
   * Returns the value of the '<em><b>Connects To</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connects To</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connects To</em>' reference.
   * @see #setConnectsTo(ConnectElement)
   * @see org.jucmnav.turn.turn.TurnPackage#getConnect_ConnectsTo()
   * @model
   * @generated
   */
  ConnectElement getConnectsTo();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.Connect#getConnectsTo <em>Connects To</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Connects To</em>' reference.
   * @see #getConnectsTo()
   * @generated
   */
  void setConnectsTo(ConnectElement value);

} // Connect
