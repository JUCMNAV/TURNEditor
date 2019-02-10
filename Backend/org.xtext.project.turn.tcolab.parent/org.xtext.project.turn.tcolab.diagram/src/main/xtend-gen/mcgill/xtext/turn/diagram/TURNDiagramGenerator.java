/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package mcgill.xtext.turn.diagram;

import com.google.common.base.Objects;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mcgill.xtext.turn.diagram.MAPStartNode;
import mcgill.xtext.turn.diagram.TURNHeaderNode;
import mcgill.xtext.turn.diagram.TURNLabel;
import mcgill.xtext.turn.diagram.TURNNode;
import mcgill.xtext.turn.diagram.TURNTag;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.example.mydsl.tURN.Actor;
import org.xtext.example.mydsl.tURN.Contribution;
import org.xtext.example.mydsl.tURN.Decomposition;
import org.xtext.example.mydsl.tURN.Dependency;
import org.xtext.example.mydsl.tURN.ElementLink;
import org.xtext.example.mydsl.tURN.EndpointWithConnect;
import org.xtext.example.mydsl.tURN.Evaluation;
import org.xtext.example.mydsl.tURN.EvaluationStrategy;
import org.xtext.example.mydsl.tURN.IntentionalElement;
import org.xtext.example.mydsl.tURN.LongName;
import org.xtext.example.mydsl.tURN.Path;
import org.xtext.example.mydsl.tURN.RegularEnd;
import org.xtext.example.mydsl.tURN.UCMmap;
import org.xtext.example.mydsl.tURN.URNspec;
import org.xtext.example.mydsl.tURN.impl.ActorImpl;
import org.xtext.example.mydsl.tURN.impl.ElementLinkImpl;
import org.xtext.example.mydsl.tURN.impl.IntentionalElementImpl;
import org.xtext.example.mydsl.tURN.impl.PathImpl;

@SuppressWarnings("all")
public class TURNDiagramGenerator implements IDiagramGenerator {
  private final static Logger LOG = Logger.getLogger(TURNDiagramGenerator.class);
  
  private final static String CONTRIBUTE_EDGE_TYPE = "contribute";
  
  private final static String CORRELATION_EDGE_TYPE = "correlated";
  
  private final static String DECOMPOSITION_EDGE_TYPE = "decomposition";
  
  private final static String DEPENDENCY_EDGE_TYPE = "dependency";
  
  private Pattern pattern;
  
  private Matcher matcher;
  
  private Map<Actor, SModelElement> actorIndex = new HashMap<Actor, SModelElement>();
  
  private Map<Actor, SModelElement> elementIndex;
  
  private Map<IntentionalElement, SModelElement> elementIE = new HashMap<IntentionalElement, SModelElement>();
  
  private Map<Path, List<SModelElement>> elementIEPath = new HashMap<Path, List<SModelElement>>();
  
  private Map<ElementLink, SModelElement> elementEL = new HashMap<ElementLink, SModelElement>();
  
  private List<Procedure0> postProcesses;
  
  private SGraph diagramRoot;
  
  @Inject
  private ITraceProvider traceProvider;
  
  private IDiagramState state;
  
  private Map<String, SModelElement> id2modules = CollectionLiterals.<String, SModelElement>newHashMap();
  
  private Actor diagramModule;
  
  private UCMmap diagramMapModule;
  
  private XtextResource xtresource;
  
  private ICompositeNode rootNode;
  
  private IParseResult parseResult;
  
  @Override
  public SModelRoot generate(final Resource resource, final IDiagramState state, final CancelIndicator cancelIndicator) {
    TURNDiagramGenerator.LOG.info(("Hello" + state));
    final EObject content = IterableExtensions.<EObject>head(resource.getContents());
    this.state = state;
    final Map<String, String> stateInfo = state.getOptions();
    final String stateURI = stateInfo.get("sourceUri");
    int _lastIndexOf = stateURI.lastIndexOf("#");
    int _plus = (_lastIndexOf + 1);
    final String modelElementPath = stateURI.substring(_plus);
    boolean _contains = modelElementPath.contains("%");
    if (_contains) {
    }
    int _lastIndexOf_1 = modelElementPath.lastIndexOf(".");
    int _plus_1 = (_lastIndexOf_1 + 1);
    final String segment = modelElementPath.substring(_plus_1);
    TURNDiagramGenerator.LOG.info(("State URI" + stateURI));
    TURNDiagramGenerator.LOG.info(("Model Element Path" + modelElementPath));
    TURNDiagramGenerator.LOG.info(("Model segments Path" + segment));
    this.state = state;
    this.xtresource = ((XtextResource) resource);
    if ((this.xtresource != null)) {
      this.parseResult = this.xtresource.getParseResult();
      if ((this.parseResult != null)) {
        this.rootNode = this.parseResult.getRootNode();
        BidiIterable<INode> _children = this.rootNode.getChildren();
        for (final INode abstractNode : _children) {
          {
            final EObject content2 = abstractNode.getSemanticElement();
            if ((content2 instanceof Actor)) {
              String _name = ((Actor)content2).getName();
              String _plus_2 = ("INSIDE CONTENT FIRST IF" + _name);
              InputOutput.<String>println(_plus_2);
              boolean _equals = segment.equals(((Actor)content2).getName());
              String _plus_3 = ("boolean" + Boolean.valueOf(_equals));
              InputOutput.<String>println(_plus_3);
              boolean _equals_1 = segment.equals(((Actor)content2).getName());
              if (_equals_1) {
                InputOutput.<String>println("generating actors");
                return this.generateDiagram(((Actor)content2), cancelIndicator);
              }
            } else {
              if ((content2 instanceof UCMmap)) {
                String _name_1 = ((UCMmap)content2).getName();
                String _plus_4 = ("INSIDE CONTENT SECOND IF" + _name_1);
                InputOutput.<String>println(_plus_4);
                boolean _equals_2 = segment.equals(((UCMmap)content2).getName());
                String _plus_5 = ("boolean" + Boolean.valueOf(_equals_2));
                InputOutput.<String>println(_plus_5);
                boolean _equals_3 = segment.equals(((UCMmap)content2).getName());
                if (_equals_3) {
                  InputOutput.<String>println("generating actors");
                  return this.generateMap(((UCMmap)content2), cancelIndicator);
                }
              }
            }
          }
        }
      }
      return null;
    }
    return null;
  }
  
  public SModelRoot generateDiagram(final Actor module, final CancelIndicator cancelIndicator) {
    this.diagramModule = module;
    TURNDiagramGenerator.LOG.info((((("reached generate Diagram \'" + "module") + module) + "cancel") + cancelIndicator));
    HashMap<Actor, SModelElement> _hashMap = new HashMap<Actor, SModelElement>();
    this.elementIndex = _hashMap;
    ArrayList<Procedure0> _arrayList = new ArrayList<Procedure0>();
    this.postProcesses = _arrayList;
    SGraph _sGraph = new SGraph();
    final Procedure1<SGraph> _function = (SGraph it) -> {
      it.setType("graph");
      it.setId("turn");
      ArrayList<SModelElement> _arrayList_1 = new ArrayList<SModelElement>();
      it.setChildren(_arrayList_1);
      final Consumer<LayoutOptions> _function_1 = (LayoutOptions it_1) -> {
        it_1.setHAlign("left");
        it_1.setHGap(Double.valueOf(10.0));
        it_1.setVGap(Double.valueOf(0.0));
        it_1.setPaddingLeft(Double.valueOf(0.0));
        it_1.setPaddingRight(Double.valueOf(0.0));
        it_1.setPaddingTop(Double.valueOf(0.0));
        it_1.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function_1);
      it.setLayoutOptions(_layoutOptions);
    };
    SGraph _doubleArrow = ObjectExtensions.<SGraph>operator_doubleArrow(_sGraph, _function);
    this.diagramRoot = _doubleArrow;
    final List<SModelElement> rootChildren = this.createChildElements(this.diagramRoot, this.diagramRoot, module);
    TURNDiagramGenerator.LOG.info(("rootChildren" + rootChildren));
    this.diagramRoot.getChildren().addAll(rootChildren);
    return this.diagramRoot;
  }
  
  public SModelRoot generateMap(final UCMmap module, final CancelIndicator cancelIndicator) {
    this.diagramMapModule = module;
    TURNDiagramGenerator.LOG.info((((("reached generate Diagram \'" + "module") + module) + "cancel") + cancelIndicator));
    HashMap<Actor, SModelElement> _hashMap = new HashMap<Actor, SModelElement>();
    this.elementIndex = _hashMap;
    ArrayList<Procedure0> _arrayList = new ArrayList<Procedure0>();
    this.postProcesses = _arrayList;
    SGraph _sGraph = new SGraph();
    final Procedure1<SGraph> _function = (SGraph it) -> {
      it.setType("graph");
      it.setId("turn");
      ArrayList<SModelElement> _arrayList_1 = new ArrayList<SModelElement>();
      it.setChildren(_arrayList_1);
      final Consumer<LayoutOptions> _function_1 = (LayoutOptions it_1) -> {
        it_1.setHAlign("left");
        it_1.setHGap(Double.valueOf(10.0));
        it_1.setVGap(Double.valueOf(0.0));
        it_1.setPaddingLeft(Double.valueOf(0.0));
        it_1.setPaddingRight(Double.valueOf(0.0));
        it_1.setPaddingTop(Double.valueOf(0.0));
        it_1.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function_1);
      it.setLayoutOptions(_layoutOptions);
    };
    SGraph _doubleArrow = ObjectExtensions.<SGraph>operator_doubleArrow(_sGraph, _function);
    this.diagramRoot = _doubleArrow;
    final List<SModelElement> rootChildren = this.createMapChildElements(this.diagramRoot, this.diagramRoot, module);
    TURNDiagramGenerator.LOG.info(("rootChildren" + rootChildren));
    this.diagramRoot.getChildren().addAll(rootChildren);
    return this.diagramRoot;
  }
  
  protected List<SModelElement> createChildElements(final SModelElement viewParentElement, final SModelElement modelParentElement, final Actor actor) {
    final ArrayList<SModelElement> rootChildren = new ArrayList<SModelElement>();
    SModelElement element3 = null;
    EObject _eContainer = actor.eContainer();
    EList<EvaluationStrategy> strategies = ((URNspec) _eContainer).getStrategies();
    EList<IntentionalElement> _elems = actor.getElems();
    for (final IntentionalElement ie : _elems) {
      {
        String ieType = ie.getType().toString();
        boolean _contains = ieType.contains("softgoal");
        if (_contains) {
          for (final EvaluationStrategy strategy : strategies) {
            EList<Evaluation> _evaluations = strategy.getEvaluations();
            for (final Evaluation evalST : _evaluations) {
              {
                EList<EObject> _eCrossReferences = evalST.eCrossReferences();
                String _plus = ("CrossReference Value =" + _eCrossReferences);
                TURNDiagramGenerator.LOG.info(_plus);
                boolean _contains_1 = evalST.eCrossReferences().contains(ie);
                if (_contains_1) {
                  element3 = this.findEvaluation(viewParentElement, modelParentElement, strategies, ie);
                } else {
                  element3 = this.generateSoftGoal(ie, viewParentElement, modelParentElement);
                }
              }
            }
          }
        } else {
          boolean _contains_1 = ieType.contains("goal");
          if (_contains_1) {
            element3 = this.generateGoal(ie, viewParentElement, modelParentElement);
          } else {
            boolean _contains_2 = ieType.contains("belief");
            if (_contains_2) {
              element3 = this.generateBelief(ie, viewParentElement, modelParentElement);
            } else {
              boolean _contains_3 = ieType.contains("task");
              if (_contains_3) {
                element3 = this.generateTask(ie, viewParentElement, modelParentElement);
              } else {
                boolean _contains_4 = ieType.contains("resource");
                if (_contains_4) {
                  element3 = this.generateResource(ie, viewParentElement, modelParentElement);
                } else {
                  element3 = this.generateIndicator(ie, viewParentElement, modelParentElement);
                }
              }
            }
          }
        }
        rootChildren.add(element3);
        this.trace(element3, ie);
        this.elementIE.put(ie, element3);
        TURNDiagramGenerator.LOG.info(("GOAL HASH MAP = " + this.elementIE));
      }
    }
    EList<IntentionalElement> _elems_1 = actor.getElems();
    for (final IntentionalElement elemLink : _elems_1) {
      EList<ElementLink> _linksSrc = elemLink.getLinksSrc();
      for (final ElementLink link : _linksSrc) {
        {
          final List<SModelElement> element4 = this.createLinks(viewParentElement, modelParentElement, Collections.<ElementLink>unmodifiableList(CollectionLiterals.<ElementLink>newArrayList(link)));
          rootChildren.addAll(element4);
        }
      }
    }
    return rootChildren;
  }
  
  protected SModelElement findEvaluation(final SModelElement viewParentElement, final SModelElement modelParentElement, final List<EvaluationStrategy> strategies, final IntentionalElement elem) {
    for (final EvaluationStrategy strategy : strategies) {
      EList<Evaluation> _evaluations = strategy.getEvaluations();
      for (final Evaluation firstEval : _evaluations) {
        {
          String qualitative = firstEval.getQualitativeEvaluation().toString();
          String quantitative = Integer.valueOf(firstEval.getEvaluation()).toString();
          boolean _isExceeds = firstEval.isExceeds();
          if (_isExceeds) {
            TURNDiagramGenerator.LOG.info(("Entered Goal =" + elem));
            SModelElement element3 = this.generateSoftGoalTry(elem, viewParentElement, modelParentElement);
            String _id = element3.getId();
            String _plus = (_id + "-heading");
            final SCompartment moduleHeadingCompartment = this.<SCompartment>configSElement(SCompartment.class, _plus, 
              "comp");
            moduleHeadingCompartment.setLayout("hbox");
            element3.getChildren().add(moduleHeadingCompartment);
            if ((Objects.equal(Integer.valueOf(firstEval.getQualitativeEvaluation().getValue()), "none") || (firstEval.getEvaluation() == 0))) {
              String _id_1 = element3.getId();
              String _plus_1 = (_id_1 + "-label");
              final SLabel moduleLabel = this.<SLabel>configSElement(SLabel.class, _plus_1, "heading");
              String _id_2 = element3.getId();
              String _plus_2 = (_id_2 + " ");
              String _plus_3 = (_plus_2 + qualitative);
              moduleLabel.setText(_plus_3);
              moduleHeadingCompartment.getChildren().add(moduleLabel);
              return element3;
            } else {
              String _id_3 = element3.getId();
              String _plus_4 = (_id_3 + "-label");
              final SLabel moduleLabel_1 = this.<SLabel>configSElement(SLabel.class, _plus_4, "heading");
              String _id_4 = element3.getId();
              String _plus_5 = (_id_4 + " ");
              String _plus_6 = (_plus_5 + quantitative);
              moduleLabel_1.setText(_plus_6);
              moduleHeadingCompartment.getChildren().add(moduleLabel_1);
              return element3;
            }
          }
        }
      }
    }
    return null;
  }
  
  protected List<SModelElement> createMapChildElements(final SModelElement viewParentElement, final SModelElement modelParentElement, final UCMmap map) {
    final ArrayList<SModelElement> rootChildren = new ArrayList<SModelElement>();
    List<SModelElement> element3 = null;
    EList<Path> _paths = map.getPaths();
    for (final Path path : _paths) {
      {
        element3 = this.generatePathElement(path, viewParentElement, modelParentElement);
        rootChildren.addAll(element3);
        this.trace(element3, path);
        this.elementIEPath.put(path, element3);
        TURNDiagramGenerator.LOG.info(("MAP CHILDREN = " + element3));
        TURNDiagramGenerator.LOG.info(("MAP PATH HASH MAP = " + this.elementIEPath));
      }
    }
    return rootChildren;
  }
  
  protected List<SModelElement> createLinks(final SModelElement viewParentElement, final SModelElement modelParentElement, final List<ElementLink> links) {
    final ArrayList<SModelElement> rootChildren = new ArrayList<SModelElement>();
    for (final ElementLink link : links) {
      {
        SModelElement element = null;
        element = this.generateElement(link, viewParentElement, modelParentElement);
        this.elementEL.put(link, element);
        TURNDiagramGenerator.LOG.info(("Link Hash Map" + this.elementEL));
        boolean _contains = rootChildren.contains(element);
        boolean _not = (!_contains);
        if (_not) {
          rootChildren.add(element);
          this.trace(element, link);
        }
      }
    }
    return rootChildren;
  }
  
  protected SModelElement _generateElementActor(final Actor actor, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    SModelElement elementActor = null;
    elementActor = this.generateActorModule(actor, viewParentElement, modelParentElement);
    this.trace(elementActor, actor);
    this.actorIndex.put(actor, elementActor);
    TURNDiagramGenerator.LOG.info(("Actor HASH MAP = " + this.actorIndex));
    elementActor.getChildren().addAll(this.createChildElements(viewParentElement, modelParentElement, actor));
    return elementActor;
  }
  
  protected SModelElement _generateElement1(final Actor moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.generateElementActor(moduleStmt, viewParentElement, modelParentElement);
  }
  
  protected void trace(final SModelElement element, final IntentionalElement elem) {
    if ((element instanceof Traceable)) {
      this.traceProvider.trace(((Traceable)element), elem);
    }
  }
  
  protected void trace(final SModelElement element, final Actor elem) {
    if ((element instanceof Traceable)) {
      this.traceProvider.trace(((Traceable)element), elem);
    }
  }
  
  protected void trace(final List<SModelElement> element, final Path elem) {
    if ((element instanceof Traceable)) {
      this.traceProvider.trace(((Traceable)element), elem);
    }
  }
  
  protected void trace(final SModelElement element, final ElementLink linksrc) {
    if ((element instanceof Traceable)) {
      this.traceProvider.trace(((Traceable)element), linksrc);
    }
  }
  
  protected SModelElement _generateElement(final Contribution contribution, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    String contributeValue = contribution.getContribution().getName();
    String quantativeValue = Integer.valueOf(contribution.getQuantitativeContribution()).toString();
    final SModelElement sourceGoal = this.elementIE.get(contribution.eContainer());
    String _id = sourceGoal.getId();
    String _plus = ("sourceGoal = " + _id);
    TURNDiagramGenerator.LOG.info(_plus);
    final SModelElement destinationGoal = this.elementIE.get(contribution.getDest());
    String _id_1 = destinationGoal.getId();
    String _plus_1 = ("destinationGoal = " + _id_1);
    TURNDiagramGenerator.LOG.info(_plus_1);
    if (((sourceGoal != null) || (destinationGoal != null))) {
      boolean _isCorrelation = contribution.isCorrelation();
      if (_isCorrelation) {
        final SEdge edge = this.createEdge(destinationGoal, sourceGoal, TURNDiagramGenerator.CORRELATION_EDGE_TYPE);
        TURNDiagramGenerator.LOG.info(("SEDGE = " + edge));
        this.elementEL.put(contribution, edge);
        if ((Objects.equal(Integer.valueOf(contribution.getContribution().getValue()), "undefined") || (contribution.getQuantitativeContribution() == 0))) {
          String _id_2 = edge.getId();
          String _plus_2 = (_id_2 + "-label");
          final SLabel edgeLabel = this.<SLabel>configSElement(SLabel.class, _plus_2, "heading");
          edgeLabel.setText(contributeValue);
          edge.getChildren().add(edgeLabel);
          return edge;
        } else {
          String _id_3 = edge.getId();
          String _plus_3 = (_id_3 + "-label");
          final SLabel edgeLabel_1 = this.<SLabel>configSElement(SLabel.class, _plus_3, "heading");
          edgeLabel_1.setText(quantativeValue);
          edge.getChildren().add(edgeLabel_1);
          return edge;
        }
      } else {
        final SEdge edge_1 = this.createEdge(destinationGoal, sourceGoal, TURNDiagramGenerator.CONTRIBUTE_EDGE_TYPE);
        TURNDiagramGenerator.LOG.info(("SEDGE = " + edge_1));
        this.elementEL.put(contribution, edge_1);
        if ((Objects.equal(Integer.valueOf(contribution.getContribution().getValue()), "undefined") || (contribution.getQuantitativeContribution() == 0))) {
          String _id_4 = edge_1.getId();
          String _plus_4 = (_id_4 + "-label");
          final SLabel edgeLabel_2 = this.<SLabel>configSElement(SLabel.class, _plus_4, "heading");
          edgeLabel_2.setText(contributeValue);
          edge_1.getChildren().add(edgeLabel_2);
          return edge_1;
        } else {
          String _id_5 = edge_1.getId();
          String _plus_5 = (_id_5 + "-label");
          final SLabel edgeLabel_3 = this.<SLabel>configSElement(SLabel.class, _plus_5, "heading");
          edgeLabel_3.setText(quantativeValue);
          edge_1.getChildren().add(edgeLabel_3);
          return edge_1;
        }
      }
    }
    return null;
  }
  
  protected SModelElement _generateElement(final Decomposition decomposition, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    String decompose = decomposition.getDecompositionType().getName();
    final SModelElement sourceGoal = this.elementIE.get(decomposition.eContainer());
    String _id = sourceGoal.getId();
    String _plus = ("sourceGoal = " + _id);
    TURNDiagramGenerator.LOG.info(_plus);
    final SModelElement destinationGoal = this.elementIE.get(decomposition.getDest());
    String _id_1 = destinationGoal.getId();
    String _plus_1 = ("destinationGoal = " + _id_1);
    TURNDiagramGenerator.LOG.info(_plus_1);
    if (((sourceGoal != null) || (destinationGoal != null))) {
      final SEdge edge = this.createEdge(destinationGoal, sourceGoal, TURNDiagramGenerator.DECOMPOSITION_EDGE_TYPE);
      TURNDiagramGenerator.LOG.info(("SEDGE = " + edge));
      this.elementEL.put(decomposition, edge);
      String _id_2 = edge.getId();
      String _plus_2 = (_id_2 + "-label");
      final SLabel edgeLabel = this.<SLabel>configSElement(SLabel.class, _plus_2, "heading");
      edgeLabel.setText(decompose);
      edge.getChildren().add(edgeLabel);
      return edge;
    }
    return null;
  }
  
  protected SModelElement _generateElement(final Dependency dependency, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    SModelElement sourceGoal = this.elementIE.get(dependency.eContainer());
    SModelElement destinationGoal = this.elementIE.get(dependency.getDest());
    EObject _eContainer = dependency.eContainer().eContainer();
    EObject _eContainer_1 = dependency.getDest().eContainer();
    boolean _equals = Objects.equal(_eContainer, _eContainer_1);
    if (_equals) {
      EObject _eContainer_2 = dependency.getDest().eContainer();
      String _plus = ("destGoal info =" + _eContainer_2);
      TURNDiagramGenerator.LOG.info(_plus);
      if (((sourceGoal != null) || (destinationGoal != null))) {
        final SEdge edge = this.createEdge(sourceGoal, destinationGoal, TURNDiagramGenerator.DEPENDENCY_EDGE_TYPE);
        TURNDiagramGenerator.LOG.info(("SEDGE = " + edge));
        this.elementEL.put(dependency, edge);
        return edge;
      }
    } else {
      boolean _contains = this.actorIndex.values().contains(dependency.getDest().eContainer());
      boolean _not = (!_contains);
      if (_not) {
        EObject actObj = dependency.getDest().eContainer();
        final SModelElement createActor = this.generateElement(actObj, viewParentElement, modelParentElement);
        modelParentElement.getChildren().add(createActor);
        return this.generateElementDependencyLink(dependency, viewParentElement, modelParentElement);
      }
    }
    return null;
  }
  
  protected SModelElement _generateElementDependencyLink(final Dependency dependency, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    SModelElement sourceGoal = this.elementIE.get(dependency.eContainer());
    SModelElement destinationGoal = this.elementIE.get(dependency.getDest());
    EObject _eContainer = dependency.getDest().eContainer();
    String _plus = ("destGoal info =" + _eContainer);
    TURNDiagramGenerator.LOG.info(_plus);
    if (((sourceGoal != null) || (destinationGoal != null))) {
      final SEdge edge = this.createEdge(sourceGoal, destinationGoal, TURNDiagramGenerator.DEPENDENCY_EDGE_TYPE);
      TURNDiagramGenerator.LOG.info(("SEDGE = " + edge));
      this.elementEL.put(dependency, edge);
      return edge;
    }
    return null;
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
  
  protected SNode initModule(final TURNNode moduleElement, final IntentionalElement moduleStmt) {
    boolean _equals = Objects.equal(moduleStmt, this.diagramModule);
    if (_equals) {
      String _id = moduleElement.getId();
      String _plus = (_id + "-example");
      final TURNNode moduleNode = this.<TURNNode>configSElement(TURNNode.class, _plus, "class");
      moduleNode.setLayout("hbox");
      final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
        it.setPaddingLeft(Double.valueOf(10.0));
        it.setPaddingRight(Double.valueOf(10.0));
        it.setPaddingTop(Double.valueOf(10.0));
        it.setPaddingBottom(Double.valueOf(10.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function);
      moduleNode.setLayoutOptions(_layoutOptions);
      moduleNode.setCssClass("example");
      moduleNode.getChildren().add(this.createClassHeader(moduleNode.getId(), this.findTag(moduleStmt), moduleStmt.getLongName()));
      moduleElement.getChildren().add(moduleNode);
    }
    return moduleElement;
  }
  
  protected SModelElement initModule(final SModelElement moduleElement, final Path moduleStmt) {
    if (((Objects.equal(this.state.getCurrentModel().getType(), "NONE") && Objects.equal(moduleStmt, this.diagramModule)) || 
      this.state.getExpandedElements().contains(moduleElement.getId()))) {
      String _id = moduleElement.getId();
      String _plus = (_id + "-node");
      final TURNNode moduleNode = this.<TURNNode>configSElement(TURNNode.class, _plus, "class");
      moduleNode.setLayout("hbox");
      final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
        it.setPaddingLeft(Double.valueOf(10.0));
        it.setPaddingRight(Double.valueOf(10.0));
        it.setPaddingTop(Double.valueOf(10.0));
        it.setPaddingBottom(Double.valueOf(10.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function);
      moduleNode.setLayoutOptions(_layoutOptions);
      moduleNode.setCssClass("moduleNode");
      moduleNode.getChildren().add(
        this.createClassHeader(moduleNode.getId(), this.findTag(moduleStmt), moduleStmt.getStartPoint().getLongName()));
      moduleElement.getChildren().add(moduleNode);
      this.state.getExpandedElements().add(moduleElement.getId());
    } else {
    }
    return moduleElement;
  }
  
  protected TURNHeaderNode createClassHeader(final String id, final String tag, final LongName longName) {
    final TURNHeaderNode classHeader = this.<TURNHeaderNode>configSElement(TURNHeaderNode.class, (id + "-header"), "classHeader");
    classHeader.setLayout("hbox");
    final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
      it.setPaddingLeft(Double.valueOf(8.0));
      it.setPaddingRight(Double.valueOf(8.0));
      it.setPaddingTop(Double.valueOf(8.0));
      it.setPaddingBottom(Double.valueOf(8.0));
    };
    LayoutOptions _layoutOptions = new LayoutOptions(_function);
    classHeader.setLayoutOptions(_layoutOptions);
    final Procedure1<TURNTag> _function_1 = (TURNTag t) -> {
      String _id = classHeader.getId();
      String _plus = (_id + "-tag");
      t.setId(_plus);
      t.setType("tag");
      t.setLayout("stack");
      final Consumer<LayoutOptions> _function_2 = (LayoutOptions it) -> {
        it.setResizeContainer(Boolean.valueOf(false));
        it.setHAlign("center");
        it.setVAlign("center");
        it.setPaddingLeft(Double.valueOf(0.0));
        it.setPaddingRight(Double.valueOf(0.0));
        it.setPaddingTop(Double.valueOf(0.0));
        it.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions_1 = new LayoutOptions(_function_2);
      t.setLayoutOptions(_layoutOptions_1);
      final Consumer<SLabel> _function_3 = (SLabel l) -> {
        l.setType("label:tag");
        String _id_1 = classHeader.getId();
        String _plus_1 = (_id_1 + "-tag-text");
        l.setId(_plus_1);
        l.setText(tag);
      };
      SLabel _sLabel = new SLabel(_function_3);
      t.setChildren(Collections.<SModelElement>unmodifiableList(CollectionLiterals.<SModelElement>newArrayList(_sLabel)));
    };
    TURNTag _tURNTag = new TURNTag(_function_1);
    final Consumer<SLabel> _function_2 = (SLabel l) -> {
      l.setType("label:classHeader");
      String _id = classHeader.getId();
      String _plus = (_id + "-header-label");
      l.setId(_plus);
    };
    SLabel _sLabel = new SLabel(_function_2);
    classHeader.setChildren(Collections.<SModelElement>unmodifiableList(CollectionLiterals.<SModelElement>newArrayList(_tURNTag, _sLabel)));
    return classHeader;
  }
  
  protected SModelElement _generateElement(final ElementLink moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return null;
  }
  
  protected SModelElement _generateElement(final Actor moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.generateElementActor(moduleStmt, viewParentElement, modelParentElement);
  }
  
  protected SModelElement _generateActorModule(final Actor moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModule(moduleStmt);
  }
  
  protected SModelElement generateGoal(final IntentionalElement moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModule(moduleStmt);
  }
  
  protected SModelElement generateSoftGoal(final IntentionalElement moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModuleSoftGoal(moduleStmt);
  }
  
  protected SModelElement generateSoftGoalTry(final IntentionalElement moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModuleSoftGoalTry(moduleStmt);
  }
  
  protected SModelElement generateBelief(final IntentionalElement moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModuleBelief(moduleStmt);
  }
  
  protected SModelElement generateTask(final IntentionalElement moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModuleTask(moduleStmt);
  }
  
  protected SModelElement generateResource(final IntentionalElement moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModuleResource(moduleStmt);
  }
  
  protected SModelElement generateIndicator(final IntentionalElement moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createModuleIndicator(moduleStmt);
  }
  
  protected SModelElement createModule(final Actor moduleStmt) {
    final String id = moduleStmt.getLongName().getLongname();
    final SModelElement existingModule = this.id2modules.get(id);
    if ((existingModule != null)) {
      return existingModule;
    }
    final TURNNode moduleElement = this.createModule(id);
    this.id2modules.put(id, moduleElement);
    return moduleElement;
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
  
  protected SNode initModule(final TURNNode moduleElement, final Actor actor) {
    if (((Objects.equal(this.state.getCurrentModel().getType(), "NONE") && Objects.equal(actor, this.diagramModule)) || 
      this.state.getExpandedElements().contains(moduleElement.getId()))) {
      String _id = moduleElement.getId();
      String _plus = (_id + "-node");
      final TURNNode moduleNode = this.<TURNNode>configSElement(TURNNode.class, _plus, "class");
      moduleNode.setLayout("hbox");
      final Consumer<LayoutOptions> _function = (LayoutOptions it) -> {
        it.setPaddingLeft(Double.valueOf(0.0));
        it.setPaddingRight(Double.valueOf(0.0));
        it.setPaddingTop(Double.valueOf(0.0));
        it.setPaddingBottom(Double.valueOf(0.0));
      };
      LayoutOptions _layoutOptions = new LayoutOptions(_function);
      moduleNode.setLayoutOptions(_layoutOptions);
      moduleNode.setCssClass("moduleNode");
      moduleNode.getChildren().add(this.createClassHeader(moduleNode.getId(), this.findTag(actor), actor.getLongName()));
      moduleElement.getChildren().add(moduleNode);
      moduleElement.getChildren().addAll(this.createChildElements(moduleNode, moduleElement, actor));
      moduleElement.setExpanded(Boolean.valueOf(true));
      this.state.getExpandedElements().add(moduleElement.getId());
    } else {
      moduleElement.setExpanded(Boolean.valueOf(false));
    }
    return moduleElement;
  }
  
  protected SModelElement createChildElements2(final SModelElement viewParentElement, final SModelElement modelParentElement, final Actor actor) {
    SModelElement element = null;
    EList<IntentionalElement> _elems = actor.getElems();
    for (final IntentionalElement goal : _elems) {
      {
        element = this.generateElement(goal, viewParentElement, modelParentElement);
        this.trace(element, goal);
        this.elementIE.put(goal, element);
        TURNDiagramGenerator.LOG.info(("Goals HASH MAP" + this.elementIE));
        return element;
      }
    }
    return null;
  }
  
  protected List<SModelElement> _generatePathElement(final Path moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return this.createPath(moduleStmt);
  }
  
  protected SModelElement createModule(final IntentionalElement moduleStmt) {
    final String id = moduleStmt.getLongName().getLongname();
    final SModelElement existingModule = this.id2modules.get(id);
    if ((existingModule != null)) {
      return existingModule;
    }
    final TURNNode moduleElement = this.createModule2(id);
    this.id2modules.put(id, moduleElement);
    this.initModule(moduleElement, moduleStmt);
    return moduleElement;
  }
  
  protected SModelElement createModuleBelief(final IntentionalElement moduleStmt) {
    final String id = moduleStmt.getLongName().getLongname();
    final SModelElement existingModule = this.id2modules.get(id);
    if ((existingModule != null)) {
      return existingModule;
    }
    final TURNNode moduleElement = this.createBelief(id);
    this.id2modules.put(id, moduleElement);
    this.initModule(moduleElement, moduleStmt);
    return moduleElement;
  }
  
  protected SModelElement createModuleTask(final IntentionalElement moduleStmt) {
    final String id = moduleStmt.getLongName().getLongname();
    final SModelElement existingModule = this.id2modules.get(id);
    if ((existingModule != null)) {
      return existingModule;
    }
    final TURNNode moduleElement = this.createTask(id);
    this.id2modules.put(id, moduleElement);
    this.initModule(moduleElement, moduleStmt);
    return moduleElement;
  }
  
  protected SModelElement createModuleResource(final IntentionalElement moduleStmt) {
    final String id = moduleStmt.getLongName().getLongname();
    final SModelElement existingModule = this.id2modules.get(id);
    if ((existingModule != null)) {
      return existingModule;
    }
    final TURNNode moduleElement = this.createResource(id);
    this.id2modules.put(id, moduleElement);
    this.initModule(moduleElement, moduleStmt);
    return moduleElement;
  }
  
  protected SModelElement createModuleIndicator(final IntentionalElement moduleStmt) {
    final String id = moduleStmt.getLongName().getLongname();
    final SModelElement existingModule = this.id2modules.get(id);
    if ((existingModule != null)) {
      return existingModule;
    }
    final TURNNode moduleElement = this.createIndicator(id);
    this.id2modules.put(id, moduleElement);
    this.initModule(moduleElement, moduleStmt);
    return moduleElement;
  }
  
  protected SModelElement createModuleSoftGoalTry(final IntentionalElement moduleStmt) {
    final String id = moduleStmt.getLongName().getLongname();
    final SModelElement existingModule = this.id2modules.get(id);
    if ((existingModule != null)) {
      return existingModule;
    }
    final TURNNode moduleElement = this.createModule2SGTry(id);
    this.id2modules.put(id, moduleElement);
    this.initModule(moduleElement, moduleStmt);
    return moduleElement;
  }
  
  protected SModelElement createModuleSoftGoal(final IntentionalElement moduleStmt) {
    final String id = moduleStmt.getLongName().getLongname();
    final SModelElement existingModule = this.id2modules.get(id);
    if ((existingModule != null)) {
      return existingModule;
    }
    final TURNNode moduleElement = this.createModule2SG(id);
    this.id2modules.put(id, moduleElement);
    this.initModule(moduleElement, moduleStmt);
    return moduleElement;
  }
  
  protected List<SModelElement> createPath(final Path moduleStmt) {
    final ArrayList<SModelElement> rootChildren = new ArrayList<SModelElement>();
    final String id = moduleStmt.getStartPoint().getLongName().getLongname();
    final RegularEnd pathEnd = moduleStmt.getPathBody().getPathEnd();
    if ((pathEnd instanceof EndpointWithConnect)) {
      final String pathEndID = ((EndpointWithConnect)pathEnd).getRegularEnd().getLongName().getLongname();
      final SModelElement EndpointWithConnectElement = this.createEndpointWithConnect(pathEndID);
      rootChildren.add(EndpointWithConnectElement);
      this.id2modules.put(id, EndpointWithConnectElement);
      this.initModule(EndpointWithConnectElement, moduleStmt);
    }
    final MAPStartNode moduleElement = this.createPath(id);
    this.id2modules.put(id, moduleElement);
    rootChildren.add(moduleElement);
    int _size = rootChildren.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      final SEdge edge = this.createMapEdge(rootChildren.get(1), rootChildren.get(0), "straight2");
      rootChildren.add(edge);
    }
    this.initModule(moduleElement, moduleStmt);
    return rootChildren;
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
  
  protected String findClass(final IntentionalElement statement) {
    String _switchResult = null;
    boolean _matched = false;
    if (statement instanceof IntentionalElementImpl) {
      _matched=true;
      _switchResult = "goal";
    }
    if (!_matched) {
      if (statement instanceof ActorImpl) {
        _matched=true;
        _switchResult = "actor";
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected String findTag(final IntentionalElement statement) {
    String _switchResult = null;
    boolean _matched = false;
    if (statement instanceof IntentionalElementImpl) {
      _matched=true;
      _switchResult = "I";
    }
    if (!_matched) {
      if (statement instanceof ElementLinkImpl) {
        _matched=true;
        _switchResult = "E";
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected String findTag(final Path statement) {
    String _switchResult = null;
    boolean _matched = false;
    if (statement instanceof PathImpl) {
      _matched=true;
      _switchResult = "P";
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected String findTag(final Actor statement) {
    String _switchResult = null;
    boolean _matched = false;
    if (statement instanceof ActorImpl) {
      _matched=true;
      _switchResult = "A";
    }
    if (!_matched) {
      if (statement instanceof IntentionalElementImpl) {
        _matched=true;
        _switchResult = "I";
      }
    }
    if (!_matched) {
      if (statement instanceof ElementLinkImpl) {
        _matched=true;
        _switchResult = "E";
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  protected void postProcessing() {
    final Consumer<Procedure0> _function = (Procedure0 process) -> {
      process.apply();
    };
    this.postProcesses.forEach(_function);
  }
  
  protected SModelElement generateElementActor(final Actor actor, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return _generateElementActor(actor, viewParentElement, modelParentElement);
  }
  
  protected SModelElement generateElement1(final Actor moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return _generateElement1(moduleStmt, viewParentElement, modelParentElement);
  }
  
  protected SModelElement generateElement(final EObject moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    if (moduleStmt instanceof Actor) {
      return _generateElement((Actor)moduleStmt, viewParentElement, modelParentElement);
    } else if (moduleStmt instanceof Contribution) {
      return _generateElement((Contribution)moduleStmt, viewParentElement, modelParentElement);
    } else if (moduleStmt instanceof Decomposition) {
      return _generateElement((Decomposition)moduleStmt, viewParentElement, modelParentElement);
    } else if (moduleStmt instanceof Dependency) {
      return _generateElement((Dependency)moduleStmt, viewParentElement, modelParentElement);
    } else if (moduleStmt instanceof ElementLink) {
      return _generateElement((ElementLink)moduleStmt, viewParentElement, modelParentElement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(moduleStmt, viewParentElement, modelParentElement).toString());
    }
  }
  
  protected SModelElement generateElementDependencyLink(final Dependency dependency, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return _generateElementDependencyLink(dependency, viewParentElement, modelParentElement);
  }
  
  protected SModelElement generateActorModule(final Actor moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return _generateActorModule(moduleStmt, viewParentElement, modelParentElement);
  }
  
  protected List<SModelElement> generatePathElement(final Path moduleStmt, final SModelElement viewParentElement, final SModelElement modelParentElement) {
    return _generatePathElement(moduleStmt, viewParentElement, modelParentElement);
  }
}
