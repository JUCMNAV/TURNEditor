/**
 * generated by Xtext 2.18.0
 */
package org.jucmnav.turn.turn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.jucmnav.turn.turn.Condition;
import org.jucmnav.turn.turn.FailureLabel;
import org.jucmnav.turn.turn.FailurePoint;
import org.jucmnav.turn.turn.LongName;
import org.jucmnav.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.impl.FailurePointImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.FailurePointImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.FailurePointImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.FailurePointImpl#getFailLabel <em>Fail Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FailurePointImpl extends URNmodelElementImpl implements FailurePoint
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getLongName() <em>Long Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongName()
   * @generated
   * @ordered
   */
  protected LongName longName;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected Condition condition;

  /**
   * The cached value of the '{@link #getFailLabel() <em>Fail Label</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailLabel()
   * @generated
   * @ordered
   */
  protected FailureLabel failLabel;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FailurePointImpl()
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
    return TurnPackage.Literals.FAILURE_POINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.FAILURE_POINT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongName getLongName()
  {
    return longName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLongName(LongName newLongName, NotificationChain msgs)
  {
    LongName oldLongName = longName;
    longName = newLongName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.FAILURE_POINT__LONG_NAME, oldLongName, newLongName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLongName(LongName newLongName)
  {
    if (newLongName != longName)
    {
      NotificationChain msgs = null;
      if (longName != null)
        msgs = ((InternalEObject)longName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.FAILURE_POINT__LONG_NAME, null, msgs);
      if (newLongName != null)
        msgs = ((InternalEObject)newLongName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.FAILURE_POINT__LONG_NAME, null, msgs);
      msgs = basicSetLongName(newLongName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.FAILURE_POINT__LONG_NAME, newLongName, newLongName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Condition getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(Condition newCondition, NotificationChain msgs)
  {
    Condition oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.FAILURE_POINT__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(Condition newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.FAILURE_POINT__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.FAILURE_POINT__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.FAILURE_POINT__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailureLabel getFailLabel()
  {
    return failLabel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFailLabel(FailureLabel newFailLabel, NotificationChain msgs)
  {
    FailureLabel oldFailLabel = failLabel;
    failLabel = newFailLabel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.FAILURE_POINT__FAIL_LABEL, oldFailLabel, newFailLabel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailLabel(FailureLabel newFailLabel)
  {
    if (newFailLabel != failLabel)
    {
      NotificationChain msgs = null;
      if (failLabel != null)
        msgs = ((InternalEObject)failLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.FAILURE_POINT__FAIL_LABEL, null, msgs);
      if (newFailLabel != null)
        msgs = ((InternalEObject)newFailLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.FAILURE_POINT__FAIL_LABEL, null, msgs);
      msgs = basicSetFailLabel(newFailLabel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.FAILURE_POINT__FAIL_LABEL, newFailLabel, newFailLabel));
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
      case TurnPackage.FAILURE_POINT__LONG_NAME:
        return basicSetLongName(null, msgs);
      case TurnPackage.FAILURE_POINT__CONDITION:
        return basicSetCondition(null, msgs);
      case TurnPackage.FAILURE_POINT__FAIL_LABEL:
        return basicSetFailLabel(null, msgs);
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
      case TurnPackage.FAILURE_POINT__NAME:
        return getName();
      case TurnPackage.FAILURE_POINT__LONG_NAME:
        return getLongName();
      case TurnPackage.FAILURE_POINT__CONDITION:
        return getCondition();
      case TurnPackage.FAILURE_POINT__FAIL_LABEL:
        return getFailLabel();
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
      case TurnPackage.FAILURE_POINT__NAME:
        setName((String)newValue);
        return;
      case TurnPackage.FAILURE_POINT__LONG_NAME:
        setLongName((LongName)newValue);
        return;
      case TurnPackage.FAILURE_POINT__CONDITION:
        setCondition((Condition)newValue);
        return;
      case TurnPackage.FAILURE_POINT__FAIL_LABEL:
        setFailLabel((FailureLabel)newValue);
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
      case TurnPackage.FAILURE_POINT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TurnPackage.FAILURE_POINT__LONG_NAME:
        setLongName((LongName)null);
        return;
      case TurnPackage.FAILURE_POINT__CONDITION:
        setCondition((Condition)null);
        return;
      case TurnPackage.FAILURE_POINT__FAIL_LABEL:
        setFailLabel((FailureLabel)null);
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
      case TurnPackage.FAILURE_POINT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TurnPackage.FAILURE_POINT__LONG_NAME:
        return longName != null;
      case TurnPackage.FAILURE_POINT__CONDITION:
        return condition != null;
      case TurnPackage.FAILURE_POINT__FAIL_LABEL:
        return failLabel != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //FailurePointImpl
