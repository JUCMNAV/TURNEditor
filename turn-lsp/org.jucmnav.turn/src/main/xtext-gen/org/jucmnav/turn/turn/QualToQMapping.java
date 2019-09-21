/**
 * generated by Xtext 2.18.0
 */
package org.jucmnav.turn.turn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qual To QMapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.QualToQMapping#isExceeds <em>Exceeds</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.QualToQMapping#getRealWorldLabel <em>Real World Label</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.QualToQMapping#getQualitativeEvaluation <em>Qualitative Evaluation</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.QualToQMapping#getEvaluation <em>Evaluation</em>}</li>
 * </ul>
 *
 * @see org.jucmnav.turn.turn.TurnPackage#getQualToQMapping()
 * @model
 * @generated
 */
public interface QualToQMapping extends EObject
{
  /**
   * Returns the value of the '<em><b>Exceeds</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exceeds</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exceeds</em>' attribute.
   * @see #setExceeds(boolean)
   * @see org.jucmnav.turn.turn.TurnPackage#getQualToQMapping_Exceeds()
   * @model
   * @generated
   */
  boolean isExceeds();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.QualToQMapping#isExceeds <em>Exceeds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exceeds</em>' attribute.
   * @see #isExceeds()
   * @generated
   */
  void setExceeds(boolean value);

  /**
   * Returns the value of the '<em><b>Real World Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Real World Label</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Real World Label</em>' attribute.
   * @see #setRealWorldLabel(String)
   * @see org.jucmnav.turn.turn.TurnPackage#getQualToQMapping_RealWorldLabel()
   * @model
   * @generated
   */
  String getRealWorldLabel();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.QualToQMapping#getRealWorldLabel <em>Real World Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Real World Label</em>' attribute.
   * @see #getRealWorldLabel()
   * @generated
   */
  void setRealWorldLabel(String value);

  /**
   * Returns the value of the '<em><b>Qualitative Evaluation</b></em>' attribute.
   * The literals are from the enumeration {@link org.jucmnav.turn.turn.QualitativeLabel}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualitative Evaluation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualitative Evaluation</em>' attribute.
   * @see org.jucmnav.turn.turn.QualitativeLabel
   * @see #setQualitativeEvaluation(QualitativeLabel)
   * @see org.jucmnav.turn.turn.TurnPackage#getQualToQMapping_QualitativeEvaluation()
   * @model
   * @generated
   */
  QualitativeLabel getQualitativeEvaluation();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.QualToQMapping#getQualitativeEvaluation <em>Qualitative Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualitative Evaluation</em>' attribute.
   * @see org.jucmnav.turn.turn.QualitativeLabel
   * @see #getQualitativeEvaluation()
   * @generated
   */
  void setQualitativeEvaluation(QualitativeLabel value);

  /**
   * Returns the value of the '<em><b>Evaluation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Evaluation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Evaluation</em>' attribute.
   * @see #setEvaluation(int)
   * @see org.jucmnav.turn.turn.TurnPackage#getQualToQMapping_Evaluation()
   * @model
   * @generated
   */
  int getEvaluation();

  /**
   * Sets the value of the '{@link org.jucmnav.turn.turn.QualToQMapping#getEvaluation <em>Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Evaluation</em>' attribute.
   * @see #getEvaluation()
   * @generated
   */
  void setEvaluation(int value);

} // QualToQMapping
