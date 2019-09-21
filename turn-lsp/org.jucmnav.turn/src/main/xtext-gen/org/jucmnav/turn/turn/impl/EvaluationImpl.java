/**
 * generated by Xtext 2.18.0
 */
package org.jucmnav.turn.turn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.jucmnav.turn.turn.Evaluation;
import org.jucmnav.turn.turn.IndicatorConversion;
import org.jucmnav.turn.turn.IndicatorEvaluation;
import org.jucmnav.turn.turn.IntentionalElement;
import org.jucmnav.turn.turn.QualitativeLabel;
import org.jucmnav.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evaluation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.impl.EvaluationImpl#getIntElement <em>Int Element</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.EvaluationImpl#isExceeds <em>Exceeds</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.EvaluationImpl#getQualitativeEvaluation <em>Qualitative Evaluation</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.EvaluationImpl#getEvaluation <em>Evaluation</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.EvaluationImpl#getIndicatorEval <em>Indicator Eval</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.EvaluationImpl#getConversion <em>Conversion</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EvaluationImpl extends MinimalEObjectImpl.Container implements Evaluation
{
  /**
   * The cached value of the '{@link #getIntElement() <em>Int Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntElement()
   * @generated
   * @ordered
   */
  protected IntentionalElement intElement;

  /**
   * The default value of the '{@link #isExceeds() <em>Exceeds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExceeds()
   * @generated
   * @ordered
   */
  protected static final boolean EXCEEDS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExceeds() <em>Exceeds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExceeds()
   * @generated
   * @ordered
   */
  protected boolean exceeds = EXCEEDS_EDEFAULT;

  /**
   * The default value of the '{@link #getQualitativeEvaluation() <em>Qualitative Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualitativeEvaluation()
   * @generated
   * @ordered
   */
  protected static final QualitativeLabel QUALITATIVE_EVALUATION_EDEFAULT = QualitativeLabel.DENIED;

  /**
   * The cached value of the '{@link #getQualitativeEvaluation() <em>Qualitative Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualitativeEvaluation()
   * @generated
   * @ordered
   */
  protected QualitativeLabel qualitativeEvaluation = QUALITATIVE_EVALUATION_EDEFAULT;

  /**
   * The default value of the '{@link #getEvaluation() <em>Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluation()
   * @generated
   * @ordered
   */
  protected static final int EVALUATION_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getEvaluation() <em>Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluation()
   * @generated
   * @ordered
   */
  protected int evaluation = EVALUATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getIndicatorEval() <em>Indicator Eval</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndicatorEval()
   * @generated
   * @ordered
   */
  protected IndicatorEvaluation indicatorEval;

  /**
   * The cached value of the '{@link #getConversion() <em>Conversion</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConversion()
   * @generated
   * @ordered
   */
  protected IndicatorConversion conversion;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EvaluationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TurnPackage.Literals.EVALUATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntentionalElement getIntElement()
  {
    if (intElement != null && intElement.eIsProxy())
    {
      InternalEObject oldIntElement = (InternalEObject)intElement;
      intElement = (IntentionalElement)eResolveProxy(oldIntElement);
      if (intElement != oldIntElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TurnPackage.EVALUATION__INT_ELEMENT, oldIntElement, intElement));
      }
    }
    return intElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntentionalElement basicGetIntElement()
  {
    return intElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntElement(IntentionalElement newIntElement)
  {
    IntentionalElement oldIntElement = intElement;
    intElement = newIntElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.EVALUATION__INT_ELEMENT, oldIntElement, intElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExceeds()
  {
    return exceeds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExceeds(boolean newExceeds)
  {
    boolean oldExceeds = exceeds;
    exceeds = newExceeds;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.EVALUATION__EXCEEDS, oldExceeds, exceeds));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualitativeLabel getQualitativeEvaluation()
  {
    return qualitativeEvaluation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualitativeEvaluation(QualitativeLabel newQualitativeEvaluation)
  {
    QualitativeLabel oldQualitativeEvaluation = qualitativeEvaluation;
    qualitativeEvaluation = newQualitativeEvaluation == null ? QUALITATIVE_EVALUATION_EDEFAULT : newQualitativeEvaluation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.EVALUATION__QUALITATIVE_EVALUATION, oldQualitativeEvaluation, qualitativeEvaluation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getEvaluation()
  {
    return evaluation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvaluation(int newEvaluation)
  {
    int oldEvaluation = evaluation;
    evaluation = newEvaluation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.EVALUATION__EVALUATION, oldEvaluation, evaluation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndicatorEvaluation getIndicatorEval()
  {
    return indicatorEval;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndicatorEval(IndicatorEvaluation newIndicatorEval, NotificationChain msgs)
  {
    IndicatorEvaluation oldIndicatorEval = indicatorEval;
    indicatorEval = newIndicatorEval;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.EVALUATION__INDICATOR_EVAL, oldIndicatorEval, newIndicatorEval);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndicatorEval(IndicatorEvaluation newIndicatorEval)
  {
    if (newIndicatorEval != indicatorEval)
    {
      NotificationChain msgs = null;
      if (indicatorEval != null)
        msgs = ((InternalEObject)indicatorEval).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.EVALUATION__INDICATOR_EVAL, null, msgs);
      if (newIndicatorEval != null)
        msgs = ((InternalEObject)newIndicatorEval).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.EVALUATION__INDICATOR_EVAL, null, msgs);
      msgs = basicSetIndicatorEval(newIndicatorEval, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.EVALUATION__INDICATOR_EVAL, newIndicatorEval, newIndicatorEval));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndicatorConversion getConversion()
  {
    if (conversion != null && conversion.eIsProxy())
    {
      InternalEObject oldConversion = (InternalEObject)conversion;
      conversion = (IndicatorConversion)eResolveProxy(oldConversion);
      if (conversion != oldConversion)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TurnPackage.EVALUATION__CONVERSION, oldConversion, conversion));
      }
    }
    return conversion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndicatorConversion basicGetConversion()
  {
    return conversion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConversion(IndicatorConversion newConversion)
  {
    IndicatorConversion oldConversion = conversion;
    conversion = newConversion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.EVALUATION__CONVERSION, oldConversion, conversion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TurnPackage.EVALUATION__INDICATOR_EVAL:
        return basicSetIndicatorEval(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TurnPackage.EVALUATION__INT_ELEMENT:
        if (resolve) return getIntElement();
        return basicGetIntElement();
      case TurnPackage.EVALUATION__EXCEEDS:
        return isExceeds();
      case TurnPackage.EVALUATION__QUALITATIVE_EVALUATION:
        return getQualitativeEvaluation();
      case TurnPackage.EVALUATION__EVALUATION:
        return getEvaluation();
      case TurnPackage.EVALUATION__INDICATOR_EVAL:
        return getIndicatorEval();
      case TurnPackage.EVALUATION__CONVERSION:
        if (resolve) return getConversion();
        return basicGetConversion();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TurnPackage.EVALUATION__INT_ELEMENT:
        setIntElement((IntentionalElement)newValue);
        return;
      case TurnPackage.EVALUATION__EXCEEDS:
        setExceeds((Boolean)newValue);
        return;
      case TurnPackage.EVALUATION__QUALITATIVE_EVALUATION:
        setQualitativeEvaluation((QualitativeLabel)newValue);
        return;
      case TurnPackage.EVALUATION__EVALUATION:
        setEvaluation((Integer)newValue);
        return;
      case TurnPackage.EVALUATION__INDICATOR_EVAL:
        setIndicatorEval((IndicatorEvaluation)newValue);
        return;
      case TurnPackage.EVALUATION__CONVERSION:
        setConversion((IndicatorConversion)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TurnPackage.EVALUATION__INT_ELEMENT:
        setIntElement((IntentionalElement)null);
        return;
      case TurnPackage.EVALUATION__EXCEEDS:
        setExceeds(EXCEEDS_EDEFAULT);
        return;
      case TurnPackage.EVALUATION__QUALITATIVE_EVALUATION:
        setQualitativeEvaluation(QUALITATIVE_EVALUATION_EDEFAULT);
        return;
      case TurnPackage.EVALUATION__EVALUATION:
        setEvaluation(EVALUATION_EDEFAULT);
        return;
      case TurnPackage.EVALUATION__INDICATOR_EVAL:
        setIndicatorEval((IndicatorEvaluation)null);
        return;
      case TurnPackage.EVALUATION__CONVERSION:
        setConversion((IndicatorConversion)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TurnPackage.EVALUATION__INT_ELEMENT:
        return intElement != null;
      case TurnPackage.EVALUATION__EXCEEDS:
        return exceeds != EXCEEDS_EDEFAULT;
      case TurnPackage.EVALUATION__QUALITATIVE_EVALUATION:
        return qualitativeEvaluation != QUALITATIVE_EVALUATION_EDEFAULT;
      case TurnPackage.EVALUATION__EVALUATION:
        return evaluation != EVALUATION_EDEFAULT;
      case TurnPackage.EVALUATION__INDICATOR_EVAL:
        return indicatorEval != null;
      case TurnPackage.EVALUATION__CONVERSION:
        return conversion != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (exceeds: ");
    result.append(exceeds);
    result.append(", qualitativeEvaluation: ");
    result.append(qualitativeEvaluation);
    result.append(", evaluation: ");
    result.append(evaluation);
    result.append(')');
    return result.toString();
  }

} //EvaluationImpl
