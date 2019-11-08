/*
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */

package org.jucmnav.turn.diagram

import io.typefox.sprotty.api.SGraph
import io.typefox.sprotty.api.SModelRoot
import io.typefox.sprotty.layout.ElkLayoutEngine
import io.typefox.sprotty.layout.SprottyLayoutConfigurator
import java.io.ByteArrayOutputStream
import org.apache.log4j.Logger
import org.eclipse.elk.alg.layered.options.LayeredOptions
import org.eclipse.elk.core.math.ElkPadding
import org.eclipse.elk.core.options.CoreOptions
import org.eclipse.elk.core.options.Direction
import org.eclipse.elk.graph.ElkNode
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.elk.core.options.Alignment
import org.eclipse.elk.core.options.HierarchyHandling
import org.eclipse.elk.alg.layered.options.GreedySwitchType

class TurnLayoutEngine extends ElkLayoutEngine {
	
	static val LOG = Logger.getLogger(TurnLayoutEngine);
	
	override layout(SModelRoot root) {

		if (root instanceof SGraph) {
			
			val configurator = new SprottyLayoutConfigurator
			
			// ----------- GRL configuration -----------
			configurator.configureByType('graph')
			.setProperty(CoreOptions.DIRECTION, Direction.DOWN)
			.setProperty(CoreOptions.SPACING_NODE_NODE, 30.0)
			.setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, 30.0)
			.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN)
			.setProperty(LayeredOptions.CROSSING_MINIMIZATION_GREEDY_SWITCH_TYPE, GreedySwitchType.OFF);

			// ----------- UCM configuration -----------
			configurator.configureByType('ucm')
			.setProperty(CoreOptions.ALIGNMENT, Alignment.CENTER)
			.setProperty(CoreOptions.DIRECTION, Direction.RIGHT)
			.setProperty(CoreOptions.SPACING_NODE_NODE, 100.0)
			.setProperty(CoreOptions.SPACING_EDGE_NODE, 30.0)
			.setProperty(CoreOptions.SPACING_EDGE_EDGE, 15.0)
			.setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, 30.0)
			.setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 100.0)
			.setProperty(CoreOptions.PADDING, new ElkPadding(120.0))
			.setProperty(CoreOptions.PROGRESS_BAR, true)
			.setProperty(CoreOptions.ZOOM_TO_FIT, true)
			.setProperty(CoreOptions.EDGE_THICKNESS, 4.0)
			.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN)
			.setProperty(LayeredOptions.CROSSING_MINIMIZATION_GREEDY_SWITCH_TYPE, GreedySwitchType.TWO_SIDED);
			
			// TUCM start point configuration
			configurator.configureByType('turnnode:startpoint')
			.setProperty(CoreOptions.ALIGNMENT, Alignment.LEFT);
			
			configurator.configureByType("turnnode:endpoint")
			.setProperty(CoreOptions.ALIGNMENT, Alignment.RIGHT);
						
			// compute the layout
			layout(root, configurator);
		}
	}
	
	override protected applyEngine(ElkNode elkGraph) {
		if (LOG.isTraceEnabled)
			LOG.info(elkGraph.toXMI)
		super.applyEngine(elkGraph)
	}
	
	private def toXMI(ElkNode elkGraph) {
		val resourceSet = new ResourceSetImpl
		val resource = resourceSet.createResource(URI.createFileURI('output.elkg'))
		resource.contents += elkGraph
		val outputStream = new ByteArrayOutputStream
		resource.save(outputStream, emptyMap)
		return outputStream.toString
	}
	
}