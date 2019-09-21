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
import org.jucmnav.turn.turn.FailureKind;
import org.jucmnav.turn.turn.LongName;
import org.jucmnav.turn.turn.StartPoint;
import org.jucmnav.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.impl.StartPointImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.StartPointImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.StartPointImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.StartPointImpl#getFailKind <em>Fail Kind</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.StartPointImpl#getCatches <em>Catches</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StartPointImpl extends URNmodelElementImpl implements StartPoint
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
   * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrecondition()
   * @generated
   * @ordered
   */
  protected Condition precondition;

  /**
   * The default value of the '{@link #getFailKind() <em>Fail Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailKind()
   * @generated
   * @ordered
   */
  protected static final FailureKind FAIL_KIND_EDEFAULT = FailureKind.ABORT;

  /**
   * The cached value of the '{@link #getFailKind() <em>Fail Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFailKind()
   * @generated
   * @ordered
   */
  protected FailureKind failKind = FAIL_KIND_EDEFAULT;

  /**
   * The default value of the '{@link #getCatches() <em>Catches</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCatches()
   * @generated
   * @ordered
   */
  protected static final String CATCHES_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCatches() <em>Catches</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCatches()
   * @generated
   * @ordered
   */
  protected String catches = CATCHES_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StartPointImpl()
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
    return TurnPackage.Literals.START_POINT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.START_POINT__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.START_POINT__LONG_NAME, oldLongName, newLongName);
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
        msgs = ((InternalEObject)longName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.START_POINT__LONG_NAME, null, msgs);
      if (newLongName != null)
        msgs = ((InternalEObject)newLongName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.START_POINT__LONG_NAME, null, msgs);
      msgs = basicSetLongName(newLongName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.START_POINT__LONG_NAME, newLongName, newLongName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Condition getPrecondition()
  {
    return precondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrecondition(Condition newPrecondition, NotificationChain msgs)
  {
    Condition oldPrecondition = precondition;
    precondition = newPrecondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.START_POINT__PRECONDITION, oldPrecondition, newPrecondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrecondition(Condition newPrecondition)
  {
    if (newPrecondition != precondition)
    {
      NotificationChain msgs = null;
      if (precondition != null)
        msgs = ((InternalEObject)precondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.START_POINT__PRECONDITION, null, msgs);
      if (newPrecondition != null)
        msgs = ((InternalEObject)newPrecondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.START_POINT__PRECONDITION, null, msgs);
      msgs = basicSetPrecondition(newPrecondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.START_POINT__PRECONDITION, newPrecondition, newPrecondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailureKind getFailKind()
  {
    return failKind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFailKind(FailureKind newFailKind)
  {
    FailureKind oldFailKind = failKind;
    failKind = newFailKind == null ? FAIL_KIND_EDEFAULT : newFailKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.START_POINT__FAIL_KIND, oldFailKind, failKind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCatches()
  {
    return catches;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCatches(String newCatches)
  {
    String oldCatches = catches;
    catches = newCatches;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.START_POINT__CATCHES, oldCatches, catches));
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
      case TurnPackage.START_POINT__LONG_NAME:
        return basicSetLongName(null, msgs);
      case TurnPackage.START_POINT__PRECONDITION:
        return basicSetPrecondition(null, msgs);
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
      case TurnPackage.START_POINT__NAME:
        return getName();
      case TurnPackage.START_POINT__LONG_NAME:
        return getLongName();
      case TurnPackage.START_POINT__PRECONDITION:
        return getPrecondition();
      case TurnPackage.START_POINT__FAIL_KIND:
        return getFailKind();
      case TurnPackage.START_POINT__CATCHES:
        return getCatches();
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
      case TurnPackage.START_POINT__NAME:
        setName((String)newValue);
        return;
      case TurnPackage.START_POINT__LONG_NAME:
        setLongName((LongName)newValue);
        return;
      case TurnPackage.START_POINT__PRECONDITION:
        setPrecondition((Condition)newValue);
        return;
      case TurnPackage.START_POINT__FAIL_KIND:
        setFailKind((FailureKind)newValue);
        return;
      case TurnPackage.START_POINT__CATCHES:
        setCatches((String)newValue);
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
      case TurnPackage.START_POINT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TurnPackage.START_POINT__LONG_NAME:
        setLongName((LongName)null);
        return;
      case TurnPackage.START_POINT__PRECONDITION:
        setPrecondition((Condition)null);
        return;
      case TurnPackage.START_POINT__FAIL_KIND:
        setFailKind(FAIL_KIND_EDEFAULT);
        return;
      case TurnPackage.START_POINT__CATCHES:
        setCatches(CATCHES_EDEFAULT);
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
      case TurnPackage.START_POINT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TurnPackage.START_POINT__LONG_NAME:
        return longName != null;
      case TurnPackage.START_POINT__PRECONDITION:
        return precondition != null;
      case TurnPackage.START_POINT__FAIL_KIND:
        return failKind != FAIL_KIND_EDEFAULT;
      case TurnPackage.START_POINT__CATCHES:
        return CATCHES_EDEFAULT == null ? catches != null : !CATCHES_EDEFAULT.equals(catches);
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
    result.append(", failKind: ");
    result.append(failKind);
    result.append(", catches: ");
    result.append(catches);
    result.append(')');
    return result.toString();
  }

} //StartPointImpl
