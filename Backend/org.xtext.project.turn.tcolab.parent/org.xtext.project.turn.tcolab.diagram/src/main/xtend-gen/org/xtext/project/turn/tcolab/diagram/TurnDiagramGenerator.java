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

import io.typefox.sprotty.api.IDiagramState;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SButton;
import io.typefox.sprotty.api.SCompartment;
import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SLabel;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.server.xtext.IDiagramGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.project.turn.tcolab.diagram.TURNLabel;
import org.xtext.project.turn.tcolab.diagram.TURNNode;

@SuppressWarnings("all")
public class TurnDiagramGenerator implements IDiagramGenerator {
  private final static String CONTRIBUTE_EDGE_TYPE = "contribute";
  
  private final static String CORRELATION_EDGE_TYPE = "correlated";
  
  private final static String DECOMPOSITION_EDGE_TYPE = "decomposition";
  
  private final static String DEPENDENCY_EDGE_TYPE = "dependency";
  
  private /* Map<Actor, SModelElement> */Object actorIndex = new HashMap<Actor, SModelElement>();
  
  private /* Map<IntentionalElement, SModelElement> */Object ieIndex = new HashMap<IntentionalElement, SModelElement>();
  
  private XtextResource xtresource;
  
  private ICompositeNode rootNode;
  
  private IParseResult parseResult;
  
  @Override
  public SModelRoot generate(final Resource resource, final IDiagramState state, final CancelIndicator cancelIndicator) {
    throw new Error("Unresolved compilation problems:"
      + "\nActor cannot be resolved to a type."
      + "\nThe method generateDiagram(Actor) from the type TurnDiagramGenerator refers to the missing type Actor");
  }
  
  public SModelRoot generateDiagram(final /* Actor */Object actor) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generateIntentionalElement(SModelElement, IntentionalElement, String) from the type TurnDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe method generateElementLink(SModelElement, Contribution) from the type TurnDiagramGenerator refers to the missing type Contribution"
      + "\nelems cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\nelems cannot be resolved"
      + "\nlinksSrc cannot be resolved");
  }
  
  protected SModelElement generateIntentionalElement(final SModelElement parent, final /* IntentionalElement */Object ie, final String ieType) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TurnDiagramGenerator.ieIndex refers to the missing type IntentionalElement"
      + "\nThe method generateDetailedIntentionalElement(String, IntentionalElement, String) from the type TurnDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe field TurnDiagramGenerator.ieIndex refers to the missing type IntentionalElement"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected TURNNode generateDetailedIntentionalElement(final String longName, final /* IntentionalElement */Object ie, final String ieType) {
    throw new Error("Unresolved compilation problems:"
      + "\nimportanceQuantitative cannot be resolved"
      + "\nimportance cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\n== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\nimportanceQuantitative cannot be resolved"
      + "\n== cannot be resolved"
      + "\nimportance cannot be resolved");
  }
  
  protected SEdge _generateElementLink(final SModelElement parent, final /* Contribution */Object contribution) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TurnDiagramGenerator.ieIndex refers to the missing type IntentionalElement"
      + "\nThe field TurnDiagramGenerator.ieIndex refers to the missing type IntentionalElement"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\ncorrelation cannot be resolved"
      + "\nquantitativeContribution cannot be resolved"
      + "\ncontribution cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\n== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\nquantitativeContribution cannot be resolved"
      + "\n== cannot be resolved"
      + "\ncontribution cannot be resolved");
  }
  
  protected SEdge _generateElementLink(final SModelElement parent, final /* Decomposition */Object decomposition) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TurnDiagramGenerator.ieIndex refers to the missing type IntentionalElement"
      + "\nThe field TurnDiagramGenerator.ieIndex refers to the missing type IntentionalElement"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\ndecompositionType cannot be resolved"
      + "\ngetName cannot be resolved");
  }
  
  protected SEdge _generateElementLink(final SModelElement parent, final /* Dependency */Object dependency) {
    throw new Error("Unresolved compilation problems:"
      + "\nActor cannot be resolved to a type."
      + "\nThe field TurnDiagramGenerator.ieIndex refers to the missing type IntentionalElement"
      + "\nThe field TurnDiagramGenerator.ieIndex refers to the missing type IntentionalElement"
      + "\nThe method generateActor(SModelElement, Actor) from the type TurnDiagramGenerator refers to the missing type Actor"
      + "\nThe method generateIntentionalElement(SModelElement, IntentionalElement, String) from the type TurnDiagramGenerator refers to the missing type IntentionalElement"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\ndest cannot be resolved"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ntoString cannot be resolved");
  }
  
  protected SModelElement generateActor(final SModelElement parent, final /* Actor */Object actor) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TurnDiagramGenerator.actorIndex refers to the missing type Actor"
      + "\nThe field TurnDiagramGenerator.actorIndex refers to the missing type Actor"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
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
  
  protected SEdge generateElementLink(final SModelElement parent, final Contribution contribution) {
    if (contribution != null) {
      return _generateElementLink(parent, contribution); else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(parent, contribution).toString());
      }
    }
  }
  