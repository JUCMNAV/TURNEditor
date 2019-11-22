/**
 * Copyright (C) 2017 TypeFox and others.
 *
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.xtext.project.turn.tcolab.diagram;

import com.google.common.base.Objects;
import io.typefox.sprotty.api.IDiagramState;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SButton;
import io.typefox.sprotty.api.SCompartment;
import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SGraph;
import io.typefox.sprotty.api.SLabel;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.server.xtext.IDiagramGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.project.turn.tcolab.diagram.TURNLabel;
import org.xtext.project.turn.tcolab.diagram.TURNNode;
import org.xtext.project.turn.turn.Actor;
import org.xtext.project.turn.turn.Contribution;
import org.xtext.project.turn.turn.ContributionType;
import org.xtext.project.turn.turn.Decomposition;
import org.xtext.project.turn.turn.Dependency;
import org.xtext.project.turn.turn.ElementLink;
import org.xtext.project.turn.turn.ImportanceType;
import org.xtext.project.turn.turn.IntentionalElement;
import org.xtext.project.turn.turn.URNspec;
import org.xtext.project.turn.turn.EvaluationStrategy;

@SuppressWarnings("all")
public class TURNDiagramGenerator implements IDiagramGenerator {
  private static final String CONTRIBUTE_EDGE_TYPE = "contribute";
  
  private static final String CORRELATION_EDGE_TYPE = "correlated";
  
  private static final String DECOMPOSITION_EDGE_TYPE = "decomposition";
  
  private static final String DEPENDENCY_EDGE_TYPE = "dependency";
  
  private Map<Actor, SModelElement> actorIndex = new HashMap<Actor, SModelElement>();
  
  private Map<IntentionalElement, SModelElement> ieIndex = new HashMap<IntentionalElement, SModelElement>();
  
  private XtextResource xtresource;
  
  private IParseResult parseResult;
  
  private TURNEvaluationManager evalManager;
  
  @Override
  public SModelRoot generate(final Resource resource, final IDiagramState state, final CancelIndicator cancelIndicator) {
    this.xtresource = ((XtextResource) resource);
    if ((this.xtresource != null)) {
      this.parseResult = this.xtresource.getParseResult();
      if ((this.parseResult != null)) {
        EObject _semanticElement = this.parseResult.getRootNode().getSemanticElement();
        URNspec urnSpec = ((URNspec) _semanticElement);
        final Map<String, String> stateInfo = state.getOptions();
        final String stateURI = stateInfo.get("sourceUri");
        int _lastIndexOf = stateURI.lastIndexOf("#");
        int _plus = (_lastIndexOf + 1);
        String node = stateURI.substring(_plus);
        List<String> listElements = Arrays.<String>asList(node.split("%2C"));
        ArrayList<Actor> actorList = new ArrayList<Actor>();
        ArrayList<EvaluationStrategy> strategyList = new ArrayList<EvaluationStrategy>();
        for (final String element : listElements) {
          {
            int _lastIndexOf_1 = element.lastIndexOf(".");
            int _plus_1 = (_lastIndexOf_1 + 1);
            final String elemenName = element.substring(_plus_1);
            EList<Actor> _actors = urnSpec.getActors();
            for (final Actor actor : _actors) {
              String _name = actor.getName();
              boolean _equals = Objects.equal(elemenName, _name);
              if (_equals) {
                actorList.add(actor);
              }
            }
            EList<EvaluationStrategy> _strategies = urnSpec.getStrategies();
            for (final EvaluationStrategy strategy : _strategies) {
              String _name_1 = strategy.getName();
              boolean _equals_1 = Objects.equal(elemenName, _name_1);
              if (_equals_1) {
                strategyList.add(strategy);
              }
            }
          }
        }
        int _size = actorList.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          ArrayList<String> actorNames = new ArrayList<String>();
          for (final Actor actor : actorList) {
            actorNames.add(actor.getName());
          }
          return this.generateErrorDiagram(actorNames);
        }
        int _size_1 = strategyList.size();
        boolean _greaterThan_1 = (_size_1 > 1);
        if (_greaterThan_1) {
          ArrayList<String> strategyNames = new ArrayList<String>();
          for (final EvaluationStrategy strategy : strategyList) {
            strategyNames.add(strategy.getName());
          }
          return this.generateErrorDiagram(strategyNames);
        }
        Actor actor_1 = null;
        int _size_2 = actorList.size();
        boolean _equals = (_size_2 == 0);
        if (_equals) {
          int _size_3 = urnSpec.getActors().size();
          boolean _equals_1 = (_size_3 == 0);
          if (_equals_1) {
            return this.generateEmptyDiagram();
          }
          actor_1 = IterableExtensions.<Actor>head(urnSpec.getActors());
        } else {
          actor_1 = actorList.get(0);
        }
        int _size_4 = strategyList.size();
        boolean _equals_2 = (_size_4 == 1);
        if (_equals_2) {
          EvaluationStrategy _get = strategyList.get(0);
          TURNEvaluationManager _tURNEvaluationManager = new TURNEvaluationManager(_get);
          this.evalManager = _tURNEvaluationManager;
        }
        return this.generateDiagram(actor_1);
      }
    }
    return null;
  }
  
  public SModelRoot generateDiagram(final Actor actor) {
    SGraph _sGraph = new SGraph();
    final Procedure1<SGraph> _function = (SGraph it) -> {
      it.setType("graph");
      it.setId("turn");
      ArrayList<SModelElement> _arrayList = new ArrayList<SModelElement>();
      it.setChildren(_arrayList);
      final Consumer<LayoutOptions> _function_1 = (LayoutOptions it_1) -> {
        it_1.setHAlign("left");
        it_1.setHGap(Double.valueOf(0.0));
        it_1.setVGap(Double.valueOf(10.0));
        it_1.setPaddingLeft(Double.valueOf(0.0));
        it_1.setPaddingRight(Double.valueOf(0.0));
        it_1.setPaddingTop(Double.valueOf(0.0));
        it_1.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function_1);
      it.setLayoutOptions(_layoutOptions);
    };
    final SGraph diagramRoot = ObjectExtensions.<SGraph>operator_doubleArrow(_sGraph, _function);
    EList<IntentionalElement> _elems = actor.getElems();
    for (final IntentionalElement ie : _elems) {
      {
        String ieType = ie.getType().toString();
        this.generateIntentionalElement(diagramRoot, ie, ieType);
      }
    }
    EList<IntentionalElement> _elems_1 = actor.getElems();
    for (final IntentionalElement ie_1 : _elems_1) {
      EList<ElementLink> _linksSrc = ie_1.getLinksSrc();
      for (final ElementLink link : _linksSrc) {
        this.generateElementLink(diagramRoot, link);
      }
    }
    return diagramRoot;
  }
  
  public SModelRoot generateErrorDiagram(final List<String> string) {
    SGraph _sGraph = new SGraph();
    final Procedure1<SGraph> _function = (SGraph it) -> {
      it.setType("graph");
      it.setId("turn");
      ArrayList<SModelElement> _arrayList = new ArrayList<SModelElement>();
      it.setChildren(_arrayList);
      final Consumer<LayoutOptions> _function_1 = (LayoutOptions it_1) -> {
        it_1.setHAlign("left");
        it_1.setHGap(Double.valueOf(0.0));
        it_1.setVGap(Double.valueOf(10.0));
        it_1.setPaddingLeft(Double.valueOf(0.0));
        it_1.setPaddingRight(Double.valueOf(0.0));
        it_1.setPaddingTop(Double.valueOf(0.0));
        it_1.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function_1);
      it.setLayoutOptions(_layoutOptions);
    };
    final SGraph diagramRoot = ObjectExtensions.<SGraph>operator_doubleArrow(_sGraph, _function);
    TURNNode error = this.generateDetailedErrorDiagram(string);
    diagramRoot.getChildren().add(error);
    return diagramRoot;
  }
  
  public SModelRoot generateEmptyDiagram() {
    SGraph _sGraph = new SGraph();
    final Procedure1<SGraph> _function = (SGraph it) -> {
      it.setType("graph");
      it.setId("turn");
      final Consumer<LayoutOptions> _function_1 = (LayoutOptions it_1) -> {
        it_1.setHAlign("left");
        it_1.setHGap(Double.valueOf(0.0));
        it_1.setVGap(Double.valueOf(10.0));
        it_1.setPaddingLeft(Double.valueOf(0.0));
        it_1.setPaddingRight(Double.valueOf(0.0));
        it_1.setPaddingTop(Double.valueOf(0.0));
        it_1.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function_1);
      it.setLayoutOptions(_layoutOptions);
    };
    final SGraph diagramRoot = ObjectExtensions.<SGraph>operator_doubleArrow(_sGraph, _function);
    return diagramRoot;
  }
  
  protected TURNNode generateDetailedErrorDiagram(final List<String> string) {
    final TURNNode errorModule = this.<TURNNode>configSElement(TURNNode.class, "string", "error");
    errorModule.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    errorModule.setLayoutOptions(_layoutOptions);
    String _id = errorModule.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    errorModule.getChildren().add(moduleHeadingCompartment);
    String _id_1 = errorModule.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    String _plus_2 = (string + " selected. Please select only one.");
    moduleLabel.setText(_plus_2);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return errorModule;
  }
  
  protected SModelElement generateIntentionalElement(final SModelElement parent, final IntentionalElement ie, final String ieType) {
    final SModelElement existingIEModule = this.ieIndex.get(ie);
    if ((existingIEModule != null)) {
      return existingIEModule;
    }
    final String id = ie.getLongName().getLongname();
    final TURNNode ieModule = this.generateDetailedIntentionalElement(id, ie, ieType);
    this.ieIndex.put(ie, ieModule);
    parent.getChildren().add(ieModule);
    return ieModule;
  }
  
  protected TURNNode generateDetailedIntentionalElement(final String longName, final IntentionalElement ie, final String ieType) {
    final TURNNode ieModule = this.<TURNNode>configSElement(TURNNode.class, longName, ieType);
    ieModule.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    ieModule.setLayoutOptions(_layoutOptions);
    String _id = ieModule.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    ieModule.getChildren().add(moduleHeadingCompartment);
    int _importanceQuantitative = ie.getImportanceQuantitative();
    String importance = ("" + Integer.valueOf(_importanceQuantitative));
    if ((Objects.equal(Integer.valueOf(ie.getImportance().getValue()), "none") || (ie.getImportanceQuantitative() == 0))) {
      ImportanceType _importance = ie.getImportance();
      String _plus_1 = ("" + _importance);
      importance = _plus_1;
    }
    String textDisplay = ((((longName + " ") + "(") + importance) + ")");
    if ((this.evalManager != null)) {
      int ieEvalval = this.evalManager.getEvaluation(ie);
      textDisplay = (((((textDisplay + " ") + "[") + Integer.valueOf(ieEvalval)) + "*") + "]");
    }
    String _id_1 = ieModule.getId();
    String _plus_2 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_2, "heading");
    moduleLabel.setText(textDisplay);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return ieModule;
  }
  
  protected SEdge _generateElementLink(final SModelElement parent, final Contribution contribution) {
    final SModelElement sourceGoal = this.ieIndex.get(contribution.eContainer());
    final SModelElement destinationGoal = this.ieIndex.get(contribution.getDest());
    if (((sourceGoal != null) || (destinationGoal != null))) {
      String contributionType = TURNDiagramGenerator.CONTRIBUTE_EDGE_TYPE;
      boolean _isCorrelation = contribution.isCorrelation();
      if (_isCorrelation) {
        contributionType = TURNDiagramGenerator.CORRELATION_EDGE_TYPE;
      }
      final SEdge contributionModule = this.createEdge(destinationGoal, sourceGoal, contributionType);
      int _quantitativeContribution = contribution.getQuantitativeContribution();
      String contributionValue = ("" + Integer.valueOf(_quantitativeContribution));
      if ((Objects.equal(Integer.valueOf(contribution.getContribution().getValue()), "undefined") || (contribution.getQuantitativeContribution() == 0))) {
        ContributionType _contribution = contribution.getContribution();
        String _plus = ("" + _contribution);
        contributionValue = _plus;
      }
      String _id = contributionModule.getId();
      String _plus_1 = (_id + "-label");
      final SLabel labelModule = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
      labelModule.setText(contributionValue);
      contributionModule.getChildren().add(labelModule);
      parent.getChildren().add(contributionModule);
      return contributionModule;
    }
    return null;
  }
  
  protected SEdge _generateElementLink(final SModelElement parent, final Decomposition decomposition) {
    final SModelElement sourceGoal = this.ieIndex.get(decomposition.eContainer());
    final SModelElement destinationGoal = this.ieIndex.get(decomposition.getDest());
    if (((sourceGoal != null) || (destinationGoal != null))) {
      final SEdge decompositionModule = this.createEdge(destinationGoal, sourceGoal, TURNDiagramGenerator.DECOMPOSITION_EDGE_TYPE);
      String _id = decompositionModule.getId();
      String _plus = (_id + "-label");
      final SLabel labelModule = this.<SLabel>configSElement(SLabel.class, _plus, "heading");
      labelModule.setText(decomposition.getDecompositionType().getName());
      decompositionModule.getChildren().add(labelModule);
      parent.getChildren().add(decompositionModule);
      return decompositionModule;
    }
    return null;
  }
  
  protected SEdge _generateElementLink(final SModelElement parent, final Dependency dependency) {
    SModelElement sourceGoal = this.ieIndex.get(dependency.eContainer());
    SModelElement destinationGoal = this.ieIndex.get(dependency.getDest());
    if ((sourceGoal != null)) {
      if ((destinationGoal == null)) {
        EObject _eContainer = dependency.getDest().eContainer();
        Actor actor = ((Actor) _eContainer);
        final SModelElement actorModule = this.generateActor(parent, actor);
        IntentionalElement ie = dependency.getDest();
        String ieType = ie.getType().toString();
        destinationGoal = this.generateIntentionalElement(actorModule, ie, ieType);
      }
      final SEdge dependencyModule = this.createEdge(sourceGoal, destinationGoal, TURNDiagramGenerator.DEPENDENCY_EDGE_TYPE);
      parent.getChildren().add(dependencyModule);
      return dependencyModule;
    }
    return null;
  }
  
  protected SModelElement generateActor(final SModelElement parent, final Actor actor) {
    final SModelElement existingActorModule = this.actorIndex.get(actor);
    if ((existingActorModule != null)) {
      return existingActorModule;
    }
    final String id = actor.getLongName().getLongname();
    final TURNNode actorModule = this.generateDetailedActor(id);
    this.actorIndex.put(actor, actorModule);
    parent.getChildren().add(actorModule);
    return actorModule;
  }
  
  protected TURNNode generateDetailedActor(final String longName) {
    final TURNNode actorModule = this.<TURNNode>configSElement(TURNNode.class, longName, "actor");
    actorModule.setLayout("vbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(0.0));
      it.setPaddingBottom(Double.valueOf(20.0));
      it.setPaddingLeft(Double.valueOf(0.0));
      it.setPaddingRight(Double.valueOf(0.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    actorModule.setLayoutOptions(_layoutOptions);
    String _id = actorModule.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    actorModule.getChildren().add(moduleHeadingCompartment);
    String _id_1 = actorModule.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel labelModule = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    labelModule.setText(longName);
    moduleHeadingCompartment.getChildren().add(labelModule);
    return actorModule;
  }
  
  protected SEdge createEdge(final SModelElement fromElement, final SModelElement toElement, final String edgeType) {
    String _id = fromElement.getId();
    String _plus = (_id + "2");
    String _id_1 = toElement.getId();
    String _plus_1 = (_plus + _id_1);
    String _plus_2 = (_plus_1 + "importance");
    final SEdge edge = this.<SEdge>configSElement(SEdge.class, _plus_2, edgeType);
    edge.setSourceId(fromElement.getId());
    edge.setTargetId(toElement.getId());
    return edge;
  }
  
  protected <E extends SModelElement> E configSElement(final Class<E> elementClass, final String idStr, final String typeStr) {
    try {
      E _newInstance = elementClass.getConstructor().newInstance();
      final Procedure1<E> _function = (E it) -> {
        it.setId(idStr);
        String _findType = this.findType(it);
        String _plus = (_findType + ":");
        String _plus_1 = (_plus + typeStr);
        it.setType(_plus_1);
        ArrayList<SModelElement> _arrayList = new ArrayList<SModelElement>();
        it.setChildren(_arrayList);
      };
      return ObjectExtensions.<E>operator_doubleArrow(_newInstance, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String findType(final SModelElement element) {
    String _switchResult = null;
    boolean _matched = false;
    if (element instanceof TURNNode) {
      _matched=true;
      _switchResult = "turnnode";
    }
    if (!_matched) {
      if (element instanceof TURNLabel) {
        _matched=true;
        _switchResult = "turnlabel";
      }
    }
    if (!_matched) {
      if (element instanceof SLabel) {
        _matched=true;
        _switchResult = "label";
      }
    }
    if (!_matched) {
      if (element instanceof SCompartment) {
        _matched=true;
        _switchResult = "comp";
      }
    }
    if (!_matched) {
      if (element instanceof SEdge) {
        _matched=true;
        _switchResult = "edge";
      }
    }
    if (!_matched) {
      _switchResult = "dontknow";
    }
    return _switchResult;
  }
  
  protected SEdge generateElementLink(final SModelElement parent, final EObject contribution) {
    if (contribution instanceof Contribution) {
      return _generateElementLink(parent, (Contribution)contribution);
    } else if (contribution instanceof Decomposition) {
      return _generateElementLink(parent, (Decomposition)contribution);
    } else if (contribution instanceof Dependency) {
      return _generateElementLink(parent, (Dependency)contribution);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(parent, contribution).toString());
    }
  }
}
