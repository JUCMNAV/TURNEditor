/*
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package mcgill.xtext.turn.diagram

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
import io.typefox.sprotty.api.Dimension
import io.typefox.sprotty.api.SLabel
import io.typefox.sprotty.api.SCompartment
import io.typefox.sprotty.api.Point
import io.typefox.sprotty.api.SEdge
import java.util.Map
import java.util.HashMap
import io.typefox.sprotty.api.LayoutUtil
import java.util.ArrayList
import java.util.List

class TURNLayoutEngine extends ElkLayoutEngine {
	
	var Map<SModelRoot, SModelRoot> elementIE = new HashMap<SModelRoot, SModelRoot>()
	int rev = 0
	SModelRoot currentRoot
	List<SModelRoot> myArray = new ArrayList<SModelRoot>()

	static val LOG = Logger.getLogger(TURNLayoutEngine)
		
	override layout(SModelRoot root) {
		
		LOG.info("outer worldddddd   " + root.toString + "CLASS   " + root.type)
		if (root instanceof SGraph) {
			
	
			for (root_child : root.children) {
//				if (root_child instanceof TURNNode)
//				{
//					if (root_child.size.height != 0 && root_child.size.width != 0)
//					{
//					LOG.info("ye gaya map mein" + root_child.size)
//					//elementIE.put(root,root)
//					myArray.add(root)
//					}
//					if (root_child.size.height == 0 && root_child.size.width == 0)
//					{
						
					
				//		currentRoot = myArray.get(0)
						
//						LOG.info("Iam inside ZERO ZERO" + myArray.size + "SOMETHING" + myArray.get(0))
//						LOG.info(" ROOT0 ROOT0 ROOT0" + root_child)
//						LOG.info(" ROOT ROOT ROOT" + root)
//						currentRoot = myArray.get(0)
//						LayoutUtil.copyLayoutData(currentRoot, root);
//						LOG.info(" ROOT2 ROOT2 ROOT2" + root)
						
//						if (rev === 0)
//						{
//							LOG.info("Iam inside IF OF ZERO REVISION")
//						currentRoot = myArray.get(0)
//						rev = rev + 1	
//						}
//						else
//						{
//							LOG.info("Iam inside ELSE OF ZERO REVISION")					
//						rev = rev + 1	
//						}
//						LayoutUtil.copyLayoutData(currentRoot, root);
//												currentRoot = root
//						
//					}
//					LOG.info("dekho zara" + root_child)
//				}
				
			
//				if (root_child instanceof TURNNode) {
//					val node_label = root_child.id
//					val len = node_label.length
//					root_child.size = new Dimension(11 * len, 60.0)
//					root_child.position = new Point(10.0, 10.0)
//					for (rootNode_Child : root_child.children) {
//						if (rootNode_Child instanceof SLabel) {
//							rootNode_Child.size = new Dimension(11.0 * len - 40, 15.0)
//							rootNode_Child.position = new Point(10.0, 10.0)
//							rootNode_Child.alignment = new Point(0.0, 12.0)
//						}
//						if (rootNode_Child instanceof SCompartment) {
//							rootNode_Child.size = new Dimension(216.53, 35.0)
//							rootNode_Child.position = new Point(15.0, 25.0)
//						}
//
//					}
//				}
//				if (root_child instanceof SEdge) {
//					for (rootEdge_child : root_child.children) {
//						if (rootEdge_child instanceof SLabel) {
//							rootEdge_child.size = new Dimension(42, 15)
//							rootEdge_child.position = new Point(88.984375, 92.0)
//						}
//					}
//				}

			}
			LOG.info("so here i am in TURNLayoutEngine" + root.size)
			LOG.info("so here i am in layout ELKG" + root + "GRAPHHHHH" + SGraph)
			val configurator = new SprottyLayoutConfigurator
			configurator.configureByType('graph').setProperty(CoreOptions.DIRECTION, Direction.DOWN).setProperty(
				CoreOptions.SPACING_NODE_NODE, 30.0).setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, 30.0)
			// TODO: enable when ELK is fixed:
			// https://github.com/eclipse/elk/issues/226
//				.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN)
//				.setProperty(LayeredOptions.CROSSING_MINIMIZATION_GREEDY_SWITCH_TYPE, GreedySwitchType.OFF)
			configurator.configureByType('node:goal')
			configurator.configureByType('node:actor').setProperty(CoreOptions.DIRECTION, Direction.DOWN).setProperty(
				CoreOptions.SPACING_NODE_NODE, 100.0).setProperty(CoreOptions.SPACING_EDGE_NODE, 30.0).setProperty(
				CoreOptions.SPACING_EDGE_EDGE, 15.0).setProperty(LayeredOptions.SPACING_EDGE_NODE_BETWEEN_LAYERS, 30.0).
				setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 100.0).setProperty(CoreOptions.PADDING,
					new ElkPadding(50))
			layout(root, configurator)

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
