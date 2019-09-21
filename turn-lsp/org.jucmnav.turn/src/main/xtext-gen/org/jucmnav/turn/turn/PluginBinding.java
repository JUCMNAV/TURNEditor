/**
 * generated by Xtext 2.18.0
 */
package org.jucmnav.turn.turn;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.PluginBinding#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.PluginBinding#getReplication <em>Replication</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.PluginBinding#getMap <em>Map</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.PluginBinding#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.PluginBinding#getBindings <em>Bindings</em>}</li>
 * </ul>
 *
 * @see org.jucmnav.turn.turn.TurnPackage#getPluginBinding()
 * @model
 * @generated
 */
public interface PluginBinding extends EObject
{
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
   * @see org.jucmnav.turn.turn.TurnPackage#getPluginBinding_Condition()
   * @model containment="true"
   * @generated
   */
  Condition getCondition();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.PluginBinding#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Condition value);

  /**
   * Returns the value of the '<em><b>Replication</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Replication</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Replication</em>' attribute.
   * @see #setReplication(int)
   * @see org.jucmnav.turn.turn.TurnPackage#getPluginBinding_Replication()
   * @model
   * @generated
   */
  int getReplication();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.PluginBinding#getReplication <em>Replication</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Replication</em>' attribute.
   * @see #getReplication()
   * @generated
   */
  void setReplication(int value);

  /**
   * Returns the value of the '<em><b>Map</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Map</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Map</em>' reference.
   * @see #setMap(UCMmap)
   * @see org.jucmnav.turn.turn.TurnPackage#getPluginBinding_Map()
   * @model
   * @generated
   */
  UCMmap getMap();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.PluginBinding#getMap <em>Map</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Map</em>' reference.
   * @see #getMap()
   * @generated
   */
  void setMap(UCMmap value);

  /**
   * Returns the value of the '<em><b>Binding</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binding</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binding</em>' containment reference.
   * @see #setBinding(Binding)
   * @see org.jucmnav.turn.turn.TurnPackage#getPluginBinding_Binding()
   * @model containment="true"
   * @generated
   */
  Binding getBinding();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.PluginBinding#getBinding <em>Binding</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Binding</em>' containment reference.
   * @see #getBinding()
   * @generated
   */
  void setBinding(Binding value);

  /**
   * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
   * The list contents are of type {@link org.jucmnav.turn.turn.Binding}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bindings</em>' containment reference list.
   * @see org.jucmnav.turn.turn.TurnPackage#getPluginBinding_Bindings()
   * @model containment="true"
   * @generated
   */
  EList<Binding> getBindings();

} // PluginBinding
