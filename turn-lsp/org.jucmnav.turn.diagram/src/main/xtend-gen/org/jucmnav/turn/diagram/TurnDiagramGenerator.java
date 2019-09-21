/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.jucmnav.turn.diagram;

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
import org.jucmnav.turn.diagram.TURNLabel;
import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.Actor;
import org.jucmnav.turn.turn.Contribution;
import org.jucmnav.turn.turn.ContributionType;
import org.jucmnav.turn.turn.Decomposition;
import org.jucmnav.turn.turn.Dependency;
import org.jucmnav.turn.turn.ElementLink;
import org.jucmnav.turn.turn.ImportanceType;
import org.jucmnav.turn.turn.IntentionalElement;

@SuppressWarnings("all")
public class TurnDiagramGenerator implements IDiagramGenerator {
  private static final String CONTRIBUTE_EDGE_TYPE = "contribute";
  
  private static final String CORRELATION_EDGE_TYPE = "correlated";
  
  private static final String DECOMPOSITION_EDGE_TYPE = "decomposition";
  
  private static final String DEPENDENCY_EDGE_TYPE = "dependency";
  
  private Map<Actor, SModelElement> actorIndex = new HashMap<Actor, SModelElement>();
  
  private Map<IntentionalElement, SModelElement> ieIndex = new HashMap<IntentionalElement, SModelElement>();
  
  private XtextResource xtresource;
  
  private ICompositeNode rootNode;
  
  private IParseResult parseResult;
  
  @Override
  public SModelRoot generate(final Resource resource, final IDiagramState state, final CancelIndicator cancelIndicator) {
    final Map<String, String> stateInfo = state.getOptions();
    final String stateURI = stateInfo.get("sourceUri");
    int _lastIndexOf = stateURI.lastIndexOf("#");
    int _plus = (_lastIndexOf + 1);
    final String modelElementPath = stateURI.substring(_plus);
    int _lastIndexOf_1 = modelElementPath.lastIndexOf(".");
    int _plus_1 = (_lastIndexOf_1 + 1);
    final String sections = modelElementPath.substring(_plus_1);
    this.xtresource = ((XtextResource) resource);
    if ((this.xtresource != null)) {
      this.parseResult = this.xtresource.getParseResult();
      if ((this.parseResult != null)) {
        this.rootNode = this.parseResult.getRootNode();
        BidiIterable<INode> _children = this.rootNode.getChildren();
        for (final INode abstractNode : _children) {
          {
            final EObject content = abstractNode.getSemanticElement();
            if ((content instanceof Actor)) {
              boolean _equals = sections.equals(((Actor)content).getName());
              if (_equals) {
                InputOutput.<String>println("generating actors");
                return this.generateDiagram(((Actor)content));
              }
            }
          }
        }
      }
      return null;
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
    String _id_1 = ieModule.getId();
    String _plus_2 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_2, "heading");
    moduleLabel.setText(((((longName + " ") + "(") + importance) + ")"));
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return ieModule;
  }
  
  protected SEdge _generateElementLink(final SModelElement parent, final Contribution contribution) {
    final SModelElement sourceGoal = this.ieIndex.get(contribution.eContainer());
    final SModelElement destinationGoal = this.ieIndex.get(contribution.getDest());
    if (((sourceGoal != null) || (destinationGoal != null))) {
      String contributionType = TurnDiagramGenerator.CONTRIBUTE_EDGE_TYPE;
      boolean _isCorrelation = contribution.isCorrelation();
      if (_isCorrelation) {
        contributionType = TurnDiagramGenerator.CORRELATION_EDGE_TYPE;
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
      final SEdge decompositionModule = this.createEdge(destinationGoal, sourceGoal, TurnDiagramGenerator.DECOMPOSITION_EDGE_TYPE);
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
      final SEdge dependencyModule = this.createEdge(sourceGoal, destinationGoal, TurnDiagramGenerator.DEPENDENCY_EDGE_TYPE);
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
      if (element instanceof SButton) {
        _matched=true;
        _switchResult = "button";
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
