/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package mcgill.xtext.turn.diagram;

import io.typefox.sprotty.api.Dimension;
import io.typefox.sprotty.api.SGraph;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.layout.ElkLayoutEngine;
import io.typefox.sprotty.layout.SprottyLayoutConfigurator;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.core.math.ElkPadding;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.properties.IPropertyHolder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TURNLayoutEngine extends ElkLayoutEngine {
  private Map<SModelRoot, SModelRoot> elementIE = new HashMap<SModelRoot, SModelRoot>();
  
  private int rev = 0;
  
  private SModelRoot currentRoot;
  
  private List<SModelRoot> myArray = new ArrayList<SModelRoot>();
  
  private final static Logger LOG = Logger.getLogger(TURNLayoutEngine.class);
  
  @Override
  public void layout(final SModelRoot root) {
    String _string = root.toString();
    String _plus = ("outer worldddddd   " + _string);
    String _plus_1 = (_plus + "CLASS   ");
    String _type = root.getType();
    String _plus_2 = (_plus_1 + _type);
    TURNLayoutEngine.LOG.info(_plus_2);
    if ((root instanceof SGraph)) {
      List<SModelElement> _children = ((SGraph)root).getChildren();
      for (final SModelElement root_child : _children) {
      }
      Dimension _size = ((SGraph)root).getSize();
      String _plus_3 = ("so here i am in TURNLayoutEngine" + _size);
      TURNLayoutEngine.LOG.info(_plus_3);
      TURNLayoutEngine.LOG.info(((("so here i am in layout ELKG" + root) + "GRAPHHHHH") + SGraph.class));
      final SprottyLayoutConfigurator configurator = new SprottyLayoutConfigurator();
      configurator.configureByType("graph").<Direction>setProperty(CoreOptions.DIRECTION, Direction.DOWN).<Double>setProperty(
        CoreOptions.SPACING_NODE_NODE, Double.valueOf(30.0)).<Double>setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, Double.valueOf(30.0));
      configurator.configureByType("node:goal");
      IPropertyHolder _setProperty = configurator.configureByType("node:actor").<Direction>setProperty(CoreOptions.DIRECTION, Direction.DOWN).<Double>setProperty(
        CoreOptions.SPACING_NODE_NODE, Double.valueOf(100.0)).<Double>setProperty(CoreOptions.SPACING_EDGE_NODE, Double.valueOf(30.0)).<Double>setProperty(
        CoreOptions.SPACING_EDGE_EDGE, Double.valueOf(15.0)).<Double>setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, Double.valueOf(30.0)).<Double>setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, Double.valueOf(100.0));
      ElkPadding _elkPadding = new ElkPadding(50);
      _setProperty.<ElkPadding>setProperty(CoreOptions.PADDING, _elkPadding);
      this.layout(((SGraph)root), configurator);
    }
  }
  
  @Override
  protected void applyEngine(final ElkNode elkGraph) {
    boolean _isTraceEnabled = TURNLayoutEngine.LOG.isTraceEnabled();
    if (_isTraceEnabled) {
      TURNLayoutEngine.LOG.info(this.toXMI(elkGraph));
    }
    super.applyEngine(elkGraph);
  }
  
  private String toXMI(final ElkNode elkGraph) {
    try {
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      final Resource resource = resourceSet.createResource(URI.createFileURI("output.elkg"));
      EList<EObject> _contents = resource.getContents();
      _contents.add(elkGraph);
      final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      resource.save(outputStream, CollectionLiterals.<Object, Object>emptyMap());
      return outputStream.toString();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
