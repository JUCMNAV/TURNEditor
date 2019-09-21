/**
 * generated by Xtext 2.18.0
 */
package org.jucmnav.turn.turn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.jucmnav.turn.turn.ContributionChange;
import org.jucmnav.turn.turn.ContributionContext;
import org.jucmnav.turn.turn.LongName;
import org.jucmnav.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contribution Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.impl.ContributionContextImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.ContributionContextImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.ContributionContextImpl#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.ContributionContextImpl#getIncludedContext <em>Included Context</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.ContributionContextImpl#getIncludedContexts <em>Included Contexts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContributionContextImpl extends URNmodelElementImpl implements ContributionContext
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
   * The cached value of the '{@link #getChanges() <em>Changes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChanges()
   * @generated
   * @ordered
   */
  protected EList<ContributionChange> changes;

  /**
   * The cached value of the '{@link #getIncludedContext() <em>Included Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncludedContext()
   * @generated
   * @ordered
   */
  protected ContributionContext includedContext;

  /**
   * The cached value of the '{@link #getIncludedContexts() <em>Included Contexts</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncludedContexts()
   * @generated
   * @ordered
   */
  protected EList<ContributionContext> includedContexts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContributionContextImpl()
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
    return TurnPackage.Literals.CONTRIBUTION_CONTEXT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.CONTRIBUTION_CONTEXT__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.CONTRIBUTION_CONTEXT__LONG_NAME, oldLongName, newLongName);
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
        msgs = ((InternalEObject)longName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.CONTRIBUTION_CONTEXT__LONG_NAME, null, msgs);
      if (newLongName != null)
        msgs = ((InternalEObject)newLongName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.CONTRIBUTION_CONTEXT__LONG_NAME, null, msgs);
      msgs = basicSetLongName(newLongName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.CONTRIBUTION_CONTEXT__LONG_NAME, newLongName, newLongName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContributionChange> getChanges()
  {
    if (changes == null)
    {
      changes = new EObjectContainmentEList<ContributionChange>(ContributionChange.class, this, TurnPackage.CONTRIBUTION_CONTEXT__CHANGES);
    }
    return changes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContributionContext getIncludedContext()
  {
    if (includedContext != null && includedContext.eIsProxy())
    {
      InternalEObject oldIncludedContext = (InternalEObject)includedContext;
      includedContext = (ContributionContext)eResolveProxy(oldIncludedContext);
      if (includedContext != oldIncludedContext)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXT, oldIncludedContext, includedContext));
      }
    }
    return includedContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContributionContext basicGetIncludedContext()
  {
    return includedContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIncludedContext(ContributionContext newIncludedContext)
  {
    ContributionContext oldIncludedContext = includedContext;
    includedContext = newIncludedContext;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXT, oldIncludedContext, includedContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContributionContext> getIncludedContexts()
  {
    if (includedContexts == null)
    {
      includedContexts = new EObjectResolvingEList<ContributionContext>(ContributionContext.class, this, TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXTS);
    }
    return includedContexts;
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
      case TurnPackage.CONTRIBUTION_CONTEXT__LONG_NAME:
        return basicSetLongName(null, msgs);
      case TurnPackage.CONTRIBUTION_CONTEXT__CHANGES:
        return ((InternalEList<?>)getChanges()).basicRemove(otherEnd, msgs);
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
      case TurnPackage.CONTRIBUTION_CONTEXT__NAME:
        return getName();
      case TurnPackage.CONTRIBUTION_CONTEXT__LONG_NAME:
        return getLongName();
      case TurnPackage.CONTRIBUTION_CONTEXT__CHANGES:
        return getChanges();
      case TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXT:
        if (resolve) return getIncludedContext();
        return basicGetIncludedContext();
      case TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXTS:
        return getIncludedContexts();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TurnPackage.CONTRIBUTION_CONTEXT__NAME:
        setName((String)newValue);
        return;
      case TurnPackage.CONTRIBUTION_CONTEXT__LONG_NAME:
        setLongName((LongName)newValue);
        return;
      case TurnPackage.CONTRIBUTION_CONTEXT__CHANGES:
        getChanges().clear();
        getChanges().addAll((Collection<? extends ContributionChange>)newValue);
        return;
      case TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXT:
        setIncludedContext((ContributionContext)newValue);
        return;
      case TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXTS:
        getIncludedContexts().clear();
        getIncludedContexts().addAll((Collection<? extends ContributionContext>)newValue);
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
      case TurnPackage.CONTRIBUTION_CONTEXT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TurnPackage.CONTRIBUTION_CONTEXT__LONG_NAME:
        setLongName((LongName)null);
        return;
      case TurnPackage.CONTRIBUTION_CONTEXT__CHANGES:
        getChanges().clear();
        return;
      case TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXT:
        setIncludedContext((ContributionContext)null);
        return;
      case TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXTS:
        getIncludedContexts().clear();
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
      case TurnPackage.CONTRIBUTION_CONTEXT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TurnPackage.CONTRIBUTION_CONTEXT__LONG_NAME:
        return longName != null;
      case TurnPackage.CONTRIBUTION_CONTEXT__CHANGES:
        return changes != null && !changes.isEmpty();
      case TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXT:
        return includedContext != null;
      case TurnPackage.CONTRIBUTION_CONTEXT__INCLUDED_CONTEXTS:
        return includedContexts != null && !includedContexts.isEmpty();
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

} //ContributionContextImpl
