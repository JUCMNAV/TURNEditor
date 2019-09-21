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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.jucmnav.turn.turn.Actor;
import org.jucmnav.turn.turn.Concern;
import org.jucmnav.turn.turn.ConcreteURNspec;
import org.jucmnav.turn.turn.ContributionContext;
import org.jucmnav.turn.turn.ContributionContextGroup;
import org.jucmnav.turn.turn.EnumerationType;
import org.jucmnav.turn.turn.EvaluationStrategy;
import org.jucmnav.turn.turn.IndicatorConversion;
import org.jucmnav.turn.turn.Metadata;
import org.jucmnav.turn.turn.ScenarioDef;
import org.jucmnav.turn.turn.ScenarioGroup;
import org.jucmnav.turn.turn.StrategiesGroup;
import org.jucmnav.turn.turn.TurnPackage;
import org.jucmnav.turn.turn.UCMmap;
import org.jucmnav.turn.turn.URNlink;
import org.jucmnav.turn.turn.URNspec;
import org.jucmnav.turn.turn.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UR Nspec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getInfo <em>Info</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getActors <em>Actors</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#isShowAsMeansEnd <em>Show As Means End</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getStratGroups <em>Strat Groups</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getStrategies <em>Strategies</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getIndConversions <em>Ind Conversions</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getContribContextGroups <em>Contrib Context Groups</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getContribContexts <em>Contrib Contexts</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getUcmMaps <em>Ucm Maps</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getScenGroups <em>Scen Groups</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getScenDefs <em>Scen Defs</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getEnumTypes <em>Enum Types</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getUrnlinks <em>Urnlinks</em>}</li>
 *   <li>{@link org.jucmnav.turn.turn.impl.URNspecImpl#getMetadata <em>Metadata</em>}</li>
 * </ul>
 *
 * @generated
 */
public class URNspecImpl extends MinimalEObjectImpl.Container implements URNspec
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
   * The cached value of the '{@link #getInfo() <em>Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInfo()
   * @generated
   * @ordered
   */
  protected ConcreteURNspec info;

  /**
   * The cached value of the '{@link #getActors() <em>Actors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActors()
   * @generated
   * @ordered
   */
  protected EList<Actor> actors;

  /**
   * The default value of the '{@link #isShowAsMeansEnd() <em>Show As Means End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isShowAsMeansEnd()
   * @generated
   * @ordered
   */
  protected static final boolean SHOW_AS_MEANS_END_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isShowAsMeansEnd() <em>Show As Means End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isShowAsMeansEnd()
   * @generated
   * @ordered
   */
  protected boolean showAsMeansEnd = SHOW_AS_MEANS_END_EDEFAULT;

  /**
   * The cached value of the '{@link #getStratGroups() <em>Strat Groups</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStratGroups()
   * @generated
   * @ordered
   */
  protected EList<StrategiesGroup> stratGroups;

  /**
   * The cached value of the '{@link #getStrategies() <em>Strategies</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrategies()
   * @generated
   * @ordered
   */
  protected EList<EvaluationStrategy> strategies;

  /**
   * The cached value of the '{@link #getIndConversions() <em>Ind Conversions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndConversions()
   * @generated
   * @ordered
   */
  protected EList<IndicatorConversion> indConversions;

  /**
   * The cached value of the '{@link #getContribContextGroups() <em>Contrib Context Groups</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContribContextGroups()
   * @generated
   * @ordered
   */
  protected EList<ContributionContextGroup> contribContextGroups;

  /**
   * The cached value of the '{@link #getContribContexts() <em>Contrib Contexts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContribContexts()
   * @generated
   * @ordered
   */
  protected EList<ContributionContext> contribContexts;

  /**
   * The cached value of the '{@link #getUcmMaps() <em>Ucm Maps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUcmMaps()
   * @generated
   * @ordered
   */
  protected EList<UCMmap> ucmMaps;

  /**
   * The cached value of the '{@link #getScenGroups() <em>Scen Groups</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenGroups()
   * @generated
   * @ordered
   */
  protected EList<ScenarioGroup> scenGroups;

  /**
   * The cached value of the '{@link #getScenDefs() <em>Scen Defs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenDefs()
   * @generated
   * @ordered
   */
  protected EList<ScenarioDef> scenDefs;

  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<Variable> variables;

  /**
   * The cached value of the '{@link #getEnumTypes() <em>Enum Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumTypes()
   * @generated
   * @ordered
   */
  protected EList<EnumerationType> enumTypes;

  /**
   * The cached value of the '{@link #getConcerns() <em>Concerns</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConcerns()
   * @generated
   * @ordered
   */
  protected EList<Concern> concerns;

  /**
   * The cached value of the '{@link #getUrnlinks() <em>Urnlinks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrnlinks()
   * @generated
   * @ordered
   */
  protected EList<URNlink> urnlinks;

  /**
   * The cached value of the '{@link #getMetadata() <em>Metadata</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetadata()
   * @generated
   * @ordered
   */
  protected EList<Metadata> metadata;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected URNspecImpl()
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
    return TurnPackage.Literals.UR_NSPEC;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.UR_NSPEC__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcreteURNspec getInfo()
  {
    return info;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInfo(ConcreteURNspec newInfo, NotificationChain msgs)
  {
    ConcreteURNspec oldInfo = info;
    info = newInfo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.UR_NSPEC__INFO, oldInfo, newInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInfo(ConcreteURNspec newInfo)
  {
    if (newInfo != info)
    {
      NotificationChain msgs = null;
      if (info != null)
        msgs = ((InternalEObject)info).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.UR_NSPEC__INFO, null, msgs);
      if (newInfo != null)
        msgs = ((InternalEObject)newInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.UR_NSPEC__INFO, null, msgs);
      msgs = basicSetInfo(newInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.UR_NSPEC__INFO, newInfo, newInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Actor> getActors()
  {
    if (actors == null)
    {
      actors = new EObjectContainmentEList<Actor>(Actor.class, this, TurnPackage.UR_NSPEC__ACTORS);
    }
    return actors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isShowAsMeansEnd()
  {
    return showAsMeansEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShowAsMeansEnd(boolean newShowAsMeansEnd)
  {
    boolean oldShowAsMeansEnd = showAsMeansEnd;
    showAsMeansEnd = newShowAsMeansEnd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.UR_NSPEC__SHOW_AS_MEANS_END, oldShowAsMeansEnd, showAsMeansEnd));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StrategiesGroup> getStratGroups()
  {
    if (stratGroups == null)
    {
      stratGroups = new EObjectContainmentEList<StrategiesGroup>(StrategiesGroup.class, this, TurnPackage.UR_NSPEC__STRAT_GROUPS);
    }
    return stratGroups;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EvaluationStrategy> getStrategies()
  {
    if (strategies == null)
    {
      strategies = new EObjectContainmentEList<EvaluationStrategy>(EvaluationStrategy.class, this, TurnPackage.UR_NSPEC__STRATEGIES);
    }
    return strategies;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IndicatorConversion> getIndConversions()
  {
    if (indConversions == null)
    {
      indConversions = new EObjectContainmentEList<IndicatorConversion>(IndicatorConversion.class, this, TurnPackage.UR_NSPEC__IND_CONVERSIONS);
    }
    return indConversions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContributionContextGroup> getContribContextGroups()
  {
    if (contribContextGroups == null)
    {
      contribContextGroups = new EObjectContainmentEList<ContributionContextGroup>(ContributionContextGroup.class, this, TurnPackage.UR_NSPEC__CONTRIB_CONTEXT_GROUPS);
    }
    return contribContextGroups;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContributionContext> getContribContexts()
  {
    if (contribContexts == null)
    {
      contribContexts = new EObjectContainmentEList<ContributionContext>(ContributionContext.class, this, TurnPackage.UR_NSPEC__CONTRIB_CONTEXTS);
    }
    return contribContexts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UCMmap> getUcmMaps()
  {
    if (ucmMaps == null)
    {
      ucmMaps = new EObjectContainmentEList<UCMmap>(UCMmap.class, this, TurnPackage.UR_NSPEC__UCM_MAPS);
    }
    return ucmMaps;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ScenarioGroup> getScenGroups()
  {
    if (scenGroups == null)
    {
      scenGroups = new EObjectContainmentEList<ScenarioGroup>(ScenarioGroup.class, this, TurnPackage.UR_NSPEC__SCEN_GROUPS);
    }
    return scenGroups;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ScenarioDef> getScenDefs()
  {
    if (scenDefs == null)
    {
      scenDefs = new EObjectContainmentEList<ScenarioDef>(ScenarioDef.class, this, TurnPackage.UR_NSPEC__SCEN_DEFS);
    }
    return scenDefs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Variable> getVariables()
  {
    if (variables == null)
    {
      variables = new EObjectContainmentEList<Variable>(Variable.class, this, TurnPackage.UR_NSPEC__VARIABLES);
    }
    return variables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EnumerationType> getEnumTypes()
  {
    if (enumTypes == null)
    {
      enumTypes = new EObjectContainmentEList<EnumerationType>(EnumerationType.class, this, TurnPackage.UR_NSPEC__ENUM_TYPES);
    }
    return enumTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Concern> getConcerns()
  {
    if (concerns == null)
    {
      concerns = new EObjectContainmentEList<Concern>(Concern.class, this, TurnPackage.UR_NSPEC__CONCERNS);
    }
    return concerns;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<URNlink> getUrnlinks()
  {
    if (urnlinks == null)
    {
      urnlinks = new EObjectContainmentEList<URNlink>(URNlink.class, this, TurnPackage.UR_NSPEC__URNLINKS);
    }
    return urnlinks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Metadata> getMetadata()
  {
    if (metadata == null)
    {
      metadata = new EObjectContainmentEList<Metadata>(Metadata.class, this, TurnPackage.UR_NSPEC__METADATA);
    }
    return metadata;
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
      case TurnPackage.UR_NSPEC__INFO:
        return basicSetInfo(null, msgs);
      case TurnPackage.UR_NSPEC__ACTORS:
        return ((InternalEList<?>)getActors()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__STRAT_GROUPS:
        return ((InternalEList<?>)getStratGroups()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__STRATEGIES:
        return ((InternalEList<?>)getStrategies()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__IND_CONVERSIONS:
        return ((InternalEList<?>)getIndConversions()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXT_GROUPS:
        return ((InternalEList<?>)getContribContextGroups()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXTS:
        return ((InternalEList<?>)getContribContexts()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__UCM_MAPS:
        return ((InternalEList<?>)getUcmMaps()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__SCEN_GROUPS:
        return ((InternalEList<?>)getScenGroups()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__SCEN_DEFS:
        return ((InternalEList<?>)getScenDefs()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__ENUM_TYPES:
        return ((InternalEList<?>)getEnumTypes()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__CONCERNS:
        return ((InternalEList<?>)getConcerns()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__URNLINKS:
        return ((InternalEList<?>)getUrnlinks()).basicRemove(otherEnd, msgs);
      case TurnPackage.UR_NSPEC__METADATA:
        return ((InternalEList<?>)getMetadata()).basicRemove(otherEnd, msgs);
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
      case TurnPackage.UR_NSPEC__NAME:
        return getName();
      case TurnPackage.UR_NSPEC__INFO:
        return getInfo();
      case TurnPackage.UR_NSPEC__ACTORS:
        return getActors();
      case TurnPackage.UR_NSPEC__SHOW_AS_MEANS_END:
        return isShowAsMeansEnd();
      case TurnPackage.UR_NSPEC__STRAT_GROUPS:
        return getStratGroups();
      case TurnPackage.UR_NSPEC__STRATEGIES:
        return getStrategies();
      case TurnPackage.UR_NSPEC__IND_CONVERSIONS:
        return getIndConversions();
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXT_GROUPS:
        return getContribContextGroups();
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXTS:
        return getContribContexts();
      case TurnPackage.UR_NSPEC__UCM_MAPS:
        return getUcmMaps();
      case TurnPackage.UR_NSPEC__SCEN_GROUPS:
        return getScenGroups();
      case TurnPackage.UR_NSPEC__SCEN_DEFS:
        return getScenDefs();
      case TurnPackage.UR_NSPEC__VARIABLES:
        return getVariables();
      case TurnPackage.UR_NSPEC__ENUM_TYPES:
        return getEnumTypes();
      case TurnPackage.UR_NSPEC__CONCERNS:
        return getConcerns();
      case TurnPackage.UR_NSPEC__URNLINKS:
        return getUrnlinks();
      case TurnPackage.UR_NSPEC__METADATA:
        return getMetadata();
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
      case TurnPackage.UR_NSPEC__NAME:
        setName((String)newValue);
        return;
      case TurnPackage.UR_NSPEC__INFO:
        setInfo((ConcreteURNspec)newValue);
        return;
      case TurnPackage.UR_NSPEC__ACTORS:
        getActors().clear();
        getActors().addAll((Collection<? extends Actor>)newValue);
        return;
      case TurnPackage.UR_NSPEC__SHOW_AS_MEANS_END:
        setShowAsMeansEnd((Boolean)newValue);
        return;
      case TurnPackage.UR_NSPEC__STRAT_GROUPS:
        getStratGroups().clear();
        getStratGroups().addAll((Collection<? extends StrategiesGroup>)newValue);
        return;
      case TurnPackage.UR_NSPEC__STRATEGIES:
        getStrategies().clear();
        getStrategies().addAll((Collection<? extends EvaluationStrategy>)newValue);
        return;
      case TurnPackage.UR_NSPEC__IND_CONVERSIONS:
        getIndConversions().clear();
        getIndConversions().addAll((Collection<? extends IndicatorConversion>)newValue);
        return;
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXT_GROUPS:
        getContribContextGroups().clear();
        getContribContextGroups().addAll((Collection<? extends ContributionContextGroup>)newValue);
        return;
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXTS:
        getContribContexts().clear();
        getContribContexts().addAll((Collection<? extends ContributionContext>)newValue);
        return;
      case TurnPackage.UR_NSPEC__UCM_MAPS:
        getUcmMaps().clear();
        getUcmMaps().addAll((Collection<? extends UCMmap>)newValue);
        return;
      case TurnPackage.UR_NSPEC__SCEN_GROUPS:
        getScenGroups().clear();
        getScenGroups().addAll((Collection<? extends ScenarioGroup>)newValue);
        return;
      case TurnPackage.UR_NSPEC__SCEN_DEFS:
        getScenDefs().clear();
        getScenDefs().addAll((Collection<? extends ScenarioDef>)newValue);
        return;
      case TurnPackage.UR_NSPEC__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends Variable>)newValue);
        return;
      case TurnPackage.UR_NSPEC__ENUM_TYPES:
        getEnumTypes().clear();
        getEnumTypes().addAll((Collection<? extends EnumerationType>)newValue);
        return;
      case TurnPackage.UR_NSPEC__CONCERNS:
        getConcerns().clear();
        getConcerns().addAll((Collection<? extends Concern>)newValue);
        return;
      case TurnPackage.UR_NSPEC__URNLINKS:
        getUrnlinks().clear();
        getUrnlinks().addAll((Collection<? extends URNlink>)newValue);
        return;
      case TurnPackage.UR_NSPEC__METADATA:
        getMetadata().clear();
        getMetadata().addAll((Collection<? extends Metadata>)newValue);
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
      case TurnPackage.UR_NSPEC__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TurnPackage.UR_NSPEC__INFO:
        setInfo((ConcreteURNspec)null);
        return;
      case TurnPackage.UR_NSPEC__ACTORS:
        getActors().clear();
        return;
      case TurnPackage.UR_NSPEC__SHOW_AS_MEANS_END:
        setShowAsMeansEnd(SHOW_AS_MEANS_END_EDEFAULT);
        return;
      case TurnPackage.UR_NSPEC__STRAT_GROUPS:
        getStratGroups().clear();
        return;
      case TurnPackage.UR_NSPEC__STRATEGIES:
        getStrategies().clear();
        return;
      case TurnPackage.UR_NSPEC__IND_CONVERSIONS:
        getIndConversions().clear();
        return;
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXT_GROUPS:
        getContribContextGroups().clear();
        return;
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXTS:
        getContribContexts().clear();
        return;
      case TurnPackage.UR_NSPEC__UCM_MAPS:
        getUcmMaps().clear();
        return;
      case TurnPackage.UR_NSPEC__SCEN_GROUPS:
        getScenGroups().clear();
        return;
      case TurnPackage.UR_NSPEC__SCEN_DEFS:
        getScenDefs().clear();
        return;
      case TurnPackage.UR_NSPEC__VARIABLES:
        getVariables().clear();
        return;
      case TurnPackage.UR_NSPEC__ENUM_TYPES:
        getEnumTypes().clear();
        return;
      case TurnPackage.UR_NSPEC__CONCERNS:
        getConcerns().clear();
        return;
      case TurnPackage.UR_NSPEC__URNLINKS:
        getUrnlinks().clear();
        return;
      case TurnPackage.UR_NSPEC__METADATA:
        getMetadata().clear();
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
      case TurnPackage.UR_NSPEC__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TurnPackage.UR_NSPEC__INFO:
        return info != null;
      case TurnPackage.UR_NSPEC__ACTORS:
        return actors != null && !actors.isEmpty();
      case TurnPackage.UR_NSPEC__SHOW_AS_MEANS_END:
        return showAsMeansEnd != SHOW_AS_MEANS_END_EDEFAULT;
      case TurnPackage.UR_NSPEC__STRAT_GROUPS:
        return stratGroups != null && !stratGroups.isEmpty();
      case TurnPackage.UR_NSPEC__STRATEGIES:
        return strategies != null && !strategies.isEmpty();
      case TurnPackage.UR_NSPEC__IND_CONVERSIONS:
        return indConversions != null && !indConversions.isEmpty();
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXT_GROUPS:
        return contribContextGroups != null && !contribContextGroups.isEmpty();
      case TurnPackage.UR_NSPEC__CONTRIB_CONTEXTS:
        return contribContexts != null && !contribContexts.isEmpty();
      case TurnPackage.UR_NSPEC__UCM_MAPS:
        return ucmMaps != null && !ucmMaps.isEmpty();
      case TurnPackage.UR_NSPEC__SCEN_GROUPS:
        return scenGroups != null && !scenGroups.isEmpty();
      case TurnPackage.UR_NSPEC__SCEN_DEFS:
        return scenDefs != null && !scenDefs.isEmpty();
      case TurnPackage.UR_NSPEC__VARIABLES:
        return variables != null && !variables.isEmpty();
      case TurnPackage.UR_NSPEC__ENUM_TYPES:
        return enumTypes != null && !enumTypes.isEmpty();
      case TurnPackage.UR_NSPEC__CONCERNS:
        return concerns != null && !concerns.isEmpty();
      case TurnPackage.UR_NSPEC__URNLINKS:
        return urnlinks != null && !urnlinks.isEmpty();
      case TurnPackage.UR_NSPEC__METADATA:
        return metadata != null && !metadata.isEmpty();
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
    result.append(", showAsMeansEnd: ");
    result.append(showAsMeansEnd);
    result.append(')');
    return result.toString();
  }

} //URNspecImpl
