/**
 * generated by Xtext 2.18.0
 */
package org.jucmnav.turn.turn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.jucmnav.turn.turn.PathBodyNode;
import org.jucmnav.turn.turn.PathBodyNodes;
import org.jucmnav.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Body Nodes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.impl.PathBodyNodesImpl#getPathNodes <em>Path Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PathBodyNodesImpl extends PathBodyImpl implements PathBodyNodes
{
  /**
   * The cached value of the '{@link #getPathNodes() <em>Path Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPathNodes()
   * @generated
   * @ordered
   */
  protected EList<PathBodyNode> pathNodes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PathBodyNodesImpl()
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
    return TurnPackage.Literals.PATH_BODY_NODES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PathBodyNode> getPathNodes()
  {
    if (pathNodes == null)
    {
      pathNodes = new EObjectContainmentEList<PathBodyNode>(PathBodyNode.class, this, TurnPackage.PATH_BODY_NODES__PATH_NODES);
    }
    return pathNodes;
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
      case TurnPackage.PATH_BODY_NODES__PATH_NODES:
        return ((InternalEList<?>)getPathNodes()).basicRemove(otherEnd, msgs);
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
      case TurnPackage.PATH_BODY_NODES__PATH_NODES:
        return getPathNodes();
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
      case TurnPackage.PATH_BODY_NODES__PATH_NODES:
        getPathNodes().clear();
        getPathNodes().addAll((Collection<? extends PathBodyNode>)newValue);
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
      case TurnPackage.PATH_BODY_NODES__PATH_NODES:
        getPathNodes().clear();
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
      case TurnPackage.PATH_BODY_NODES__PATH_NODES:
        return pathNodes != null && !pathNodes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PathBodyNodesImpl
