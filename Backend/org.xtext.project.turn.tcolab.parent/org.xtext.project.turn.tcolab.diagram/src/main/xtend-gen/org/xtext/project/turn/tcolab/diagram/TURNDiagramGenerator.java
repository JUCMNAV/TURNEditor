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

import com.google.inject.Inject;
import io.typefox.sprotty.api.IDiagramState;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SButton;
import io.typefox.sprotty.api.SCompartment;
import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SGraph;
import io.typefox.sprotty.api.SLabel;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.api.SNode;
import io.typefox.sprotty.server.xtext.IDiagramGenerator;
import io.typefox.sprotty.server.xtext.tracing.ITraceProvider;
import io.typefox.sprotty.server.xtext.tracing.Traceable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.project.turn.tcolab.diagram.MAPStartNode;
import org.xtext.project.turn.tcolab.diagram.TURNHeaderNode;
import org.xtext.project.turn.tcolab.diagram.TURNLabel;
import org.xtext.project.turn.tcolab.diagram.TURNNode;

@SuppressWarnings("all")
public class TURNDiagramGenerator implements IDiagramGenerator {
  private final static Logger LOG = Logger.getLogger(TURNDiagramGenerator.class);
  
  private final static String CONTRIBUTE_EDGE_TYPE = "contribute";
  
  private final static String CORRELATION_EDGE_TYPE = "correlated";
  
  private final static String DECOMPOSITION_EDGE_TYPE = "decomposition";
  
  private final static String DEPENDENCY_EDGE_TYPE = "dependency";
  
  private Pattern pattern;
  
  private Matcher matcher;
  
  private /* Map<Actor, SModelElement> */Object actorIndex = new HashMap<Actor, SModelElement>();
  
  private /* Map<Actor, SModelElement> */Object elementIndex;
  
  private /* Map<IntentionalElement, SModelElement> */Object elementIE = new HashMap<IntentionalElement, SModelElement>();
  
  private /* Map<Path, List<SModelElement>> */Object elementIEPath = new HashMap<Path, List<SModelElement>>();
  
  private /* Map<ElementLink, SModelElement> */Object elementEL = new HashMap<ElementLink, SModelElement>();
  
  private List<Procedure0> postProcesses;
  
  private SGraph diagramRoot;
  
  @Inject
  private ITraceProvider traceProvider;
  
  private IDiagramState state;
  
  private Map<String, SModelElement> id2modules = CollectionLiterals.<String, SModelElement>newHashMap();
  
  private /* Actor */Object diagramModule;
  
  private /* UCMmap */Object diagramMapModule;
  
  private XtextResource xtresource;
  
  private ICompositeNode rootNode;
  
  private IParseResult parseResult;
  
  @Override
  public SModelRoot generate(final Resource resource, final IDiagramState state, final CancelIndicator cancelIndicator) {
    throw new Error("Unresolved compilation problems:"
      + "\nActor cannot be resolved to a type."
      + "\nUCMmap cannot be resolved to a type."
      + "\nThe method or field name is undefined for the type EObject"
      + "\nThe method or field name is undefined for the type EObject"
      + "\nThe method or field name is undefined for the type EObject"
      + "\nThe method or field name is undefined for the type EObject"
      + "\nThe method or field name is undefined for the type EObject"
      + "\nThe method or field name is undefined for the type EObject"
      + "\nUnreachable code: The if condition can never match. It is already handled by a previous condition."
      + "\nThe method generateDiagram(Actor, CancelIndicator) from the type TURNDiagramGenerator refers to the missing type Actor"
      + "\nThe method generateMap(UCMmap, CancelIndicator) from the type TURNDiagramGenerator refers to the missing type UCMmap");
  }
  
  public SModelRoot generateDiagram(final /* Actor */Object module, final CancelIndicator cancelIndicator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TURNDiagramGenerator.diagramModule refers to the missing type Actor"
      + "\nThe field TURNDiagramGenerator.elementIndex refers to the missing type Actor"
      + "\nThe method createChildElements(SModelElement, SModelElement, Actor) from the type TURNDiagramGenerator refers to the missing type Actor");
  }
  
  public SModelRoot generateMap(final /* UCMmap */Object module, final CancelIndicator cancelIndicator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TURNDiagramGenerator.diagramMapModule refers to the missing type UCMmap"
      + "\nThe field TURNDiagramGenerator.elementIndex refers to the missing type Actor"
      + "\nThe method createMapChildElements(SModelElement, SModelElement, UCMmap) from the type TURNDiagramGenerator refers to the missing type UCMmap");
  }
  
  protected List<SModelElement> createChildElements(final SModelElement viewParentElement, final SModelElement modelParentElement, final /* Actor */Object actor) {
    throw new Error("Unresolved compilation problems:"
      + "\nURNspec cannot be resolved to a type."
      + "\nThe method findEvaluation(SModelElement, SModelElement, List<EvaluationStrategy>, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type EvaluationStrategy"
      + "\nThe method generateSoftGoal(IntentionalElement, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe method generateGoal(IntentionalElement, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe method generateBelief(IntentionalElement, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe method generateTask(IntentionalElement, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe method generateResource(IntentionalElement, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe method generateIndicator(IntentionalElement, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe method trace(SModelElement, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe method createLinks(SModelElement, SModelElement, List<ElementLink>) from the type TURNDiagramGenerator refers to the missing type ElementLink"
      + "\neContainer cannot be resolved"
      + "\nstrategies cannot be resolved"
      + "\nelems cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\ncontains cannot be resolved"
      + "\nevaluations cannot be resolved"
      + "\neCrossReferences cannot be resolved"
      + "\neCrossReferences cannot be resolved"
      + "\ncontains cannot be resolved"
      + "\ncontains cannot be resolved"
      + "\ncontains cannot be resolved"
      + "\ncontains cannot be resolved"
      + "\ncontains cannot be resolved"
      + "\nelems cannot be resolved"
      + "\nlinksSrc cannot be resolved");
  }
  
  protected SModelElement findEvaluation(final SModelElement viewParentElement, final SModelElement modelParentElement, final /* List<EvaluationStrategy> */Object strategies, final /* IntentionalElement */Object elem) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generateSoftGoalTry(IntentionalElement, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nevaluations cannot be resolved"
      + "\nqualitativeEvaluation cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\nevaluation cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\nexceeds cannot be resolved"
      + "\nqualitativeEvaluation cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\n== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\nevaluation cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  protected List<SModelElement> createMapChildElements(final SModelElement viewParentElement, final SModelElement modelParentElement, final /* UCMmap */Object map) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generatePathElement(Path, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type Path"
      + "\nThe method trace(List<SModelElement>, Path) from the type TURNDiagramGenerator refers to the missing type Path"
      + "\nThe field TURNDiagramGenerator.elementIEPath refers to the missing type Path"
      + "\nThe field TURNDiagramGenerator.elementIEPath refers to the missing type Path"
      + "\npaths cannot be resolved");
  }
  
  protected List<SModelElement> createLinks(final SModelElement viewParentElement, final SModelElement modelParentElement, final /* List<ElementLink> */Object links) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generateElement(Contribution, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type Contribution"
      + "\nThe field TURNDiagramGenerator.elementEL refers to the missing type ElementLink"
      + "\nThe field TURNDiagramGenerator.elementEL refers to the missing type ElementLink"
      + "\nThe method trace(SModelElement, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement");
  }
  
  protected SModelElement _generateElementActor(final /* Actor */Object actor, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generateActorModule(Actor, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type Actor"
      + "\nThe method trace(SModelElement, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.actorIndex refers to the missing type Actor"
      + "\nThe field TURNDiagramGenerator.actorIndex refers to the missing type Actor"
      + "\nThe method createChildElements(SModelElement, SModelElement, Actor) from the type TURNDiagramGenerator refers to the missing type Actor");
  }
  
  protected SModelElement _generateElement1(final /* Actor */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generateElementActor(Actor, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type Actor");
  }
  
  protected void trace(final SModelElement element, final /* IntentionalElement */Object elem) {
    if ((element instanceof Traceable)) {
      this.traceProvider.trace(((Traceable)element), elem);
    }
  }
  
  protected void trace(final SModelElement element, final /* Actor */Object elem) {
    if ((element instanceof Traceable)) {
      this.traceProvider.trace(((Traceable)element), elem);
    }
  }
  
  protected void trace(final List<SModelElement> element, final /* Path */Object elem) {
    if ((element instanceof Traceable)) {
      this.traceProvider.trace(((Traceable)element), elem);
    }
  }
  
  protected void trace(final SModelElement element, final /* ElementLink */Object linksrc) {
    if ((element instanceof Traceable)) {
      this.traceProvider.trace(((Traceable)element), linksrc);
    }
  }
  
  protected SModelElement _generateElement(final /* Contribution */Object contribution, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementEL refers to the missing type ElementLink"
      + "\nThe field TURNDiagramGenerator.elementEL refers to the missing type ElementLink"
      + "\ncontribution cannot be resolved"
      + "\ngetName cannot be resolved"
      + "\nquantitativeContribution cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\ncorrelation cannot be resolved"
      + "\ncontribution cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\n== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\nquantitativeContribution cannot be resolved"
      + "\n== cannot be resolved"
      + "\ncontribution cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\n== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\nquantitativeContribution cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  protected SModelElement _generateElement(final /* Decomposition */Object decomposition, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementEL refers to the missing type ElementLink"
      + "\ndecompositionType cannot be resolved"
      + "\ngetName cannot be resolved"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved");
  }
  
  protected SModelElement _generateElement(final /* Dependency */Object dependency, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementEL refers to the missing type ElementLink"
      + "\nThe field TURNDiagramGenerator.actorIndex refers to the missing type Actor"
      + "\nThe method generateElement(Contribution, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type Contribution"
      + "\nThe method generateElementDependencyLink(Dependency, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type Dependency"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\neContainer cannot be resolved"
      + "\neContainer cannot be resolved"
      + "\n== cannot be resolved"
      + "\ndest cannot be resolved"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\neContainer cannot be resolved");
  }
  
  protected SModelElement _generateElementDependencyLink(final /* Dependency */Object dependency, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementEL refers to the missing type ElementLink"
      + "\neContainer cannot be resolved"
      + "\ndest cannot be resolved"
      + "\ndest cannot be resolved"
      + "\neContainer cannot be resolved");
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
  
  protected SEdge createMapEdge(final SModelElement fromElement, final SModelElement toElement, final String edgeType) {
    String _plus = (fromElement + "2");
    String _plus_1 = (_plus + toElement);
    String _plus_2 = (_plus_1 + "importance");
    final SEdge edge = this.<SEdge>configSElement(SEdge.class, _plus_2, edgeType);
    edge.setSourceId(fromElement.getId());
    edge.setTargetId(toElement.getId());
    return edge;
  }
  
  protected TURNNode createNodeWithHeadingLabel(final String id, final String name, final String type) {
    final TURNNode classElement = this.<TURNNode>configSElement(TURNNode.class, ((((id + "-") + name) + "-") + type), type);
    classElement.setLayout("hbox");
    String _id = classElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment headingContainer = this.<SCompartment>configSElement(SCompartment.class, _plus, "importance");
    headingContainer.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingFactor(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    headingContainer.setLayoutOptions(_layoutOptions);
    String _id_1 = headingContainer.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel heading = this.<SLabel>configSElement(SLabel.class, _plus_1, "description");
    heading.setText(name);
    headingContainer.getChildren().add(heading);
    classElement.getChildren().add(headingContainer);
    return classElement;
  }
  
  protected SCompartment createClassMemberCompartment(final String id) {
    final SCompartment compartment = this.<SCompartment>configSElement(SCompartment.class, (id + "-compartment"), "comp");
    compartment.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingFactor(Double.valueOf(1.0));
      it.setPaddingLeft(Double.valueOf(0.0));
      it.setPaddingRight(Double.valueOf(0.0));
      it.setPaddingTop(Double.valueOf(0.0));
      it.setPaddingBottom(Double.valueOf(0.0));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    compartment.setLayoutOptions(_layoutOptions);
    return compartment;
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
  
  protected TURNNode createModule2(final String longName) {
    final TURNNode moduleElement = this.<TURNNode>configSElement(TURNNode.class, longName, "goal");
    moduleElement.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(longName);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return moduleElement;
  }
  
  protected TURNNode createModule2SG(final String longName) {
    final TURNNode moduleElement = this.<TURNNode>configSElement(TURNNode.class, longName, "softgoal");
    moduleElement.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(longName);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return moduleElement;
  }
  
  protected TURNNode createModule2SGTry(final String longName) {
    final TURNNode moduleElement = this.<TURNNode>configSElement(TURNNode.class, longName, "softgoaltry");
    moduleElement.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    return moduleElement;
  }
  
  protected TURNNode createBelief(final String longName) {
    final TURNNode moduleElement = this.<TURNNode>configSElement(TURNNode.class, longName, "belief");
    moduleElement.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(longName);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return moduleElement;
  }
  
  protected TURNNode createTask(final String longName) {
    final TURNNode moduleElement = this.<TURNNode>configSElement(TURNNode.class, longName, "task");
    moduleElement.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(longName);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return moduleElement;
  }
  
  protected TURNNode createResource(final String longName) {
    final TURNNode moduleElement = this.<TURNNode>configSElement(TURNNode.class, longName, "resource");
    moduleElement.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(longName);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return moduleElement;
  }
  
  protected TURNNode createIndicator(final String longName) {
    final TURNNode moduleElement = this.<TURNNode>configSElement(TURNNode.class, longName, "indicator");
    moduleElement.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(longName);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return moduleElement;
  }
  
  protected MAPStartNode createPath(final String longName) {
    final MAPStartNode moduleElement = this.<MAPStartNode>configSElement(MAPStartNode.class, longName, "path");
    moduleElement.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(longName);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return moduleElement;
  }
  
  protected SModelElement createEndpointWithConnect(final String longName) {
    final TURNNode moduleElement = this.<TURNNode>configSElement(TURNNode.class, longName, "end");
    moduleElement.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(10.0));
      it.setPaddingBottom(Double.valueOf(10.0));
      it.setPaddingLeft(Double.valueOf(10.0));
      it.setPaddingRight(Double.valueOf(10.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(longName);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return moduleElement;
  }
  
  protected SNode initModule(final TURNNode moduleElement, final /* IntentionalElement */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field cssClass is not visible"
      + "\nThe field TURNDiagramGenerator.diagramModule refers to the missing type Actor"
      + "\nThe method createClassHeader(String, String, LongName) from the type TURNDiagramGenerator refers to the missing type LongName"
      + "\nThe method findTag(IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\n== cannot be resolved"
      + "\nlongName cannot be resolved");
  }
  
  protected SModelElement initModule(final SModelElement moduleElement, final /* Path */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field cssClass is not visible"
      + "\nThe field TURNDiagramGenerator.diagramModule refers to the missing type Actor"
      + "\nThe method createClassHeader(String, String, LongName) from the type TURNDiagramGenerator refers to the missing type LongName"
      + "\nThe method findTag(IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\n== cannot be resolved"
      + "\nstartPoint cannot be resolved"
      + "\nlongName cannot be resolved");
  }
  
  protected TURNHeaderNode createClassHeader(final String id, final String tag, final /* LongName */Object longName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field layout is not visible");
  }
  
  protected SModelElement _generateElement(final /* ElementLink */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return null;
  }
  
  protected SModelElement _generateElement(final /* Actor */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generateElementActor(Actor, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type Actor");
  }
  
  protected SModelElement _generateActorModule(final /* Actor */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Object to SModelElement"
      + "\nThe method createModule(Actor) from the type TURNDiagramGenerator refers to the missing type Actor");
  }
  
  protected SModelElement generateGoal(final /* IntentionalElement */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Object to SModelElement"
      + "\nThe method createModule(Actor) from the type TURNDiagramGenerator refers to the missing type Actor");
  }
  
  protected SModelElement generateSoftGoal(final /* IntentionalElement */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createModuleSoftGoal(IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement");
  }
  
  protected SModelElement generateSoftGoalTry(final /* IntentionalElement */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createModuleSoftGoalTry(IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement");
  }
  
  protected SModelElement generateBelief(final /* IntentionalElement */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createModuleBelief(IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement");
  }
  
  protected SModelElement generateTask(final /* IntentionalElement */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createModuleTask(IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement");
  }
  
  protected SModelElement generateResource(final /* IntentionalElement */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createModuleResource(IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement");
  }
  
  protected SModelElement generateIndicator(final /* IntentionalElement */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createModuleIndicator(IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement");
  }
  
  protected Object createModule(final /* Actor */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Object to SModelElement"
      + "\nThe method createModule(Actor) from the type TURNDiagramGenerator refers to the missing type Actor"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected TURNNode createModule(final String longName) {
    final TURNNode moduleElement = this.<TURNNode>configSElement(TURNNode.class, longName, "actor");
    moduleElement.setLayout("vbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingTop(Double.valueOf(0.0));
      it.setPaddingBottom(Double.valueOf(0.0));
      it.setPaddingLeft(Double.valueOf(0.0));
      it.setPaddingRight(Double.valueOf(0.0));
      it.setResizeContainer(Boolean.valueOf(true));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    moduleElement.setLayoutOptions(_layoutOptions);
    String _id = moduleElement.getId();
    String _plus = (_id + "-heading");
    final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, "comp");
    moduleHeadingCompartment.setLayout("hbox");
    moduleElement.getChildren().add(moduleHeadingCompartment);
    String _id_1 = moduleElement.getId();
    String _plus_1 = (_id_1 + "-label");
    final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
    moduleLabel.setText(longName);
    moduleHeadingCompartment.getChildren().add(moduleLabel);
    return moduleElement;
  }
  
  protected SNode initModule(final TURNNode moduleElement, final /* Actor */Object actor) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field cssClass is not visible"
      + "\nThe field expanded is not visible"
      + "\nThe field expanded is not visible"
      + "\nThe field TURNDiagramGenerator.diagramModule refers to the missing type Actor"
      + "\nThe method createClassHeader(String, String, LongName) from the type TURNDiagramGenerator refers to the missing type LongName"
      + "\nThe method findTag(IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe method createChildElements(SModelElement, SModelElement, Actor) from the type TURNDiagramGenerator refers to the missing type Actor"
      + "\n== cannot be resolved"
      + "\nlongName cannot be resolved");
  }
  
  protected SModelElement createChildElements2(final SModelElement viewParentElement, final SModelElement modelParentElement, final /* Actor */Object actor) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generateElement(Contribution, SModelElement, SModelElement) from the type TURNDiagramGenerator refers to the missing type Contribution"
      + "\nThe method trace(SModelElement, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nThe field TURNDiagramGenerator.elementIE refers to the missing type IntentionalElement"
      + "\nelems cannot be resolved");
  }
  
  protected List<SModelElement> _generatePathElement(final /* Path */Object moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from MAPStartNode to List<SModelElement>");
  }
  
  protected SModelElement createModule(final /* IntentionalElement */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initModule(TURNNode, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected SModelElement createModuleBelief(final /* IntentionalElement */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initModule(TURNNode, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected SModelElement createModuleTask(final /* IntentionalElement */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initModule(TURNNode, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected SModelElement createModuleResource(final /* IntentionalElement */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initModule(TURNNode, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected SModelElement createModuleIndicator(final /* IntentionalElement */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initModule(TURNNode, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected SModelElement createModuleSoftGoalTry(final /* IntentionalElement */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initModule(TURNNode, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected SModelElement createModuleSoftGoal(final /* IntentionalElement */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initModule(TURNNode, IntentionalElement) from the type TURNDiagramGenerator refers to the missing type IntentionalElement"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected List<SModelElement> createPath(final /* Path */Object moduleStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nEndpointWithConnect cannot be resolved to a type."
      + "\nThe method initModule(SModelElement, Path) from the type TURNDiagramGenerator refers to the missing type Path"
      + "\nThe method initModule(SModelElement, Path) from the type TURNDiagramGenerator refers to the missing type Path"
      + "\nstartPoint cannot be resolved"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved"
      + "\npathBody cannot be resolved"
      + "\npathEnd cannot be resolved"
      + "\nregularEnd cannot be resolved"
      + "\nlongName cannot be resolved"
      + "\nlongname cannot be resolved");
  }
  
  protected String findType(final SModelElement element) {
    String _switchResult = null;
    boolean _matched = false;
    if (element instanceof SNode) {
      _matched=true;
      _switchResult = "node";
    }
    if (!_matched) {
      if (element instanceof TURNLabel) {
        _matched=true;
        _switchResult = "ylabel";
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
  
  protected String findClass(final /* IntentionalElement */Object statement) {
    throw new Error("Unresolved compilation problems:"
      + "\nIntentionalElementImpl cannot be resolved to a type."
      + "\nActorImpl cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition.");
  }
  
  protected String findTag(final /* IntentionalElement */Object statement) {
    throw new Error("Unresolved compilation problems:"
      + "\nIntentionalElementImpl cannot be resolved to a type."
      + "\nElementLinkImpl cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition.");
  }
  
  protected String findTag(final /* Path */Object statement) {
    throw new Error("Unresolved compilation problems:"
      + "\nPathImpl cannot be resolved to a type.");
  }
  
  protected String findTag(final /* Actor */Object statement) {
    throw new Error("Unresolved compilation problems:"
      + "\nActorImpl cannot be resolved to a type."
      + "\nIntentionalElementImpl cannot be resolved to a type."
      + "\nElementLinkImpl cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition.");
  }
  
  protected void postProcessing() {
    final Consumer<Procedure0> _function = (Procedure0 process) -> {
      process.apply();
    };
    this.postProcesses.forEach(_function);
  }
  
  protected SModelElement generateElementActor(final Actor actor, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if (actor != null) {
      return _generateElementActor(actor, viewParentElement, modelParentElement); else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(actor, viewParentElement, modelParentElement).toString());
      }
    }
    
    protected SModelElement generateElement1(final Actor moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
      if (moduleStmt != null) {
        return _generateElement1(moduleStmt, viewParentElement, modelParentElement); else {
          throw new IllegalArgumentException("Unhandled parameter types: " +
            Arrays.<Object>asList(moduleStmt, viewParentElement, modelParentElement).toString());
        }
      }
      
      protected SModelElement generateElement(final Contribution contribution, final SModelElement viewParentElement, final SModelElement modelParentElement) {
        if (contribution != null) {
          return _generateElement(contribution, viewParentElement, modelParentElement); else {
            throw new IllegalArgumentException("Unhandled parameter types: " +
              Arrays.<Object>asList(contribution, viewParentElement, modelParentElement).toString());
          }
        }
        
        protected SModelElement generateElementDependencyLink(final Dependency dependency, final SModelElement viewParentElement, final SModelElement modelParentElement) {
          if (dependency != null) {
            return _generateElementDependencyLink(dependency, viewParentElement, modelParentElement); else {
              throw new IllegalArgumentException("Unhandled parameter types: " +
                Arrays.<Object>asList(dependency, viewParentElement, modelParentElement).toString());
            }
          }
          
          protected SModelElement generateActorModule(final Actor moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
            if (moduleStmt != null) {
              return _generateActorModule(moduleStmt, viewParentElement, modelParentElement); else {
                throw new IllegalArgumentException("Unhandled parameter types: " +
                  Arrays.<Object>asList(moduleStmt, viewParentElement, modelParentElement).toString());
              }
            }
            
            protected List<SModelElement> generatePathElement(final Path moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
              if (moduleStmt != null) {
                return _generatePathElement(moduleStmt, viewParentElement, modelParentElement); else {
                  throw new IllegalArgumentException("Unhandled parameter types: " +
                    Arrays.<Object>asList(moduleStmt, viewParentElement, modelParentElement).toString());
                }
              }
            }
            