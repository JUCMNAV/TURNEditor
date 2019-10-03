/*
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */

package org.jucmnav.turn.diagram

import io.typefox.sprotty.api.IDiagramState
import io.typefox.sprotty.api.LayoutOptions
import io.typefox.sprotty.api.SButton
import io.typefox.sprotty.api.SCompartment
import io.typefox.sprotty.api.SEdge
import io.typefox.sprotty.api.SGraph
import io.typefox.sprotty.api.SLabel
import io.typefox.sprotty.api.SModelElement
import io.typefox.sprotty.api.SModelRoot
import io.typefox.sprotty.server.xtext.IDiagramGenerator
import java.util.ArrayList
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.parser.IParseResult
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.jucmnav.turn.turn.Actor
import org.jucmnav.turn.turn.Contribution
import org.jucmnav.turn.turn.Decomposition
import org.jucmnav.turn.turn.Dependency
import org.jucmnav.turn.turn.IntentionalElement
import org.jucmnav.turn.turn.UCMmap
import org.jucmnav.turn.turn.Path

class TurnDiagramGenerator implements IDiagramGenerator {
	
	static val CONTRIBUTE_EDGE_TYPE = 'contribute';
	static val CORRELATION_EDGE_TYPE = 'correlated';
	static val DECOMPOSITION_EDGE_TYPE = 'decomposition';
	static val DEPENDENCY_EDGE_TYPE = 'dependency';
	
	var Map<Actor, SModelElement> actorIndex = new HashMap;
	var Map<IntentionalElement, SModelElement> ieIndex = new HashMap;
	
	XtextResource xtresource;
	ICompositeNode rootNode;
	IParseResult parseResult;
	
	override generate(Resource resource, IDiagramState state, CancelIndicator cancelIndicator) {
		val stateInfo = state.getOptions();
		val stateURI = stateInfo.get('sourceUri');
		val modelElementPath = stateURI.substring(stateURI.lastIndexOf("#") + 1);
		val sections = modelElementPath.substring(modelElementPath.lastIndexOf(".") + 1);
		xtresource = resource as XtextResource;
		if(xtresource !== null) {
			parseResult = xtresource.getParseResult();
			if(parseResult !== null) {
				rootNode = parseResult.getRootNode();
				for (abstractNode : rootNode.getChildren()) {
					val content = abstractNode.semanticElement;
					if(content instanceof Actor) {
						if(sections.equals(content.name)) {
							println('generating actors')
							return generateDiagram(content)
						}
					}else if(content instanceof UCMmap){
						println('Generating map...');
						return generateDiagram(content);					
					}
				}
			}
			return null
		}
	}
	
	def SModelRoot generateDiagram(UCMmap map){
		val SGraph diagramRoot = new SGraph => [
			type = 'graph'
			id = 'turn'
			children = new ArrayList<SModelElement>
			layoutOptions = new LayoutOptions [
				HAlign = 'left'
				HGap = 0.0
				VGap = 10.0
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
		]
		for(path : map.paths){
			generatePath(diagramRoot, path);
		}
		return diagramRoot;
	}
	
	protected def SModelElement generatePath(SModelElement root, Path path){
		
		val startPoint = configSElement(TURNNode, path.startPoint.name, 'startpoint');
		startPoint.layout = 'vbox';
		startPoint.layoutOptions = new LayoutOptions [
			paddingTop = 0.0
			paddingBottom = 5.0
			paddingLeft = 0.0
			paddingRight = 0.0
			resizeContainer = true
		];
		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, startPoint.id + '-heading', 'comp');
		moduleHeadingCompartment.layout = 'hbox';
		startPoint.children.add(moduleHeadingCompartment);
		val SLabel labelModule = configSElement(SLabel, startPoint.id + '-label', 'heading');
		labelModule.text = path.startPoint.name;
		moduleHeadingCompartment.children.add(labelModule);
		root.children.add(startPoint);
		return startPoint;
		
	}

	def SModelRoot generateDiagram(Actor actor) {
		val SGraph diagramRoot = new SGraph => [
			type = 'graph'
			id = 'turn'
			children = new ArrayList<SModelElement>
			layoutOptions = new LayoutOptions [
				HAlign = 'left'
				HGap = 0.0
				VGap = 10.0
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
		]
		for (ie : actor.elems) {
			var ieType = ie.type.toString
			generateIntentionalElement(diagramRoot, ie, ieType)
		}
		for (ie : actor.elems) {
			for (link : ie.linksSrc) {
				generateElementLink(diagramRoot, link)
			}
		}
		return diagramRoot
	}

	protected def SModelElement generateIntentionalElement(SModelElement parent, IntentionalElement ie, String ieType) {
		val existingIEModule = ieIndex.get(ie)
		if(existingIEModule !== null) {
			return existingIEModule
		}
		val id = ie.longName.longname
		val ieModule = generateDetailedIntentionalElement(id, ie, ieType)
		ieIndex.put(ie, ieModule)
		parent.children.add(ieModule)
		return ieModule
	}

	protected def TURNNode generateDetailedIntentionalElement(String longName, IntentionalElement ie, String ieType) {
		val ieModule = configSElement(TURNNode, longName, ieType)
		ieModule.layout = 'hbox'
		ieModule.layoutOptions = new LayoutOptions [
			paddingTop = 10.0
			paddingBottom = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			resizeContainer = true
		]
		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, ieModule.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		ieModule.children.add(moduleHeadingCompartment)
		var importance = '' + ie.importanceQuantitative
		if(ie.importance.value == 'none' || ie.importanceQuantitative == 0) {
			importance = '' + ie.importance
		}
		val SLabel moduleLabel = configSElement(SLabel, ieModule.id + '-label', 'heading')
		moduleLabel.text = longName + ' ' + '(' + importance + ')'
		moduleHeadingCompartment.children.add(moduleLabel)
		return ieModule
	}

	protected def dispatch generateElementLink(SModelElement parent, Contribution contribution) {
		val sourceGoal = ieIndex.get(contribution.eContainer)
		val destinationGoal = ieIndex.get(contribution.dest)
		if(sourceGoal !== null || destinationGoal !== null) {
			var contributionType = CONTRIBUTE_EDGE_TYPE
			if(contribution.correlation) {
				contributionType = CORRELATION_EDGE_TYPE
			}
			val SEdge contributionModule = createEdge(destinationGoal, sourceGoal, contributionType)
			var contributionValue = '' + contribution.quantitativeContribution
			if(contribution.contribution.value == 'undefined' || contribution.quantitativeContribution == 0) {
				contributionValue = '' + contribution.contribution
			}
			val SLabel labelModule = configSElement(SLabel, contributionModule.id + '-label', 'heading')
			labelModule.text = contributionValue
			contributionModule.children.add(labelModule)
			parent.children.add(contributionModule)
			return contributionModule
		}
	}

	protected def dispatch generateElementLink(SModelElement parent, Decomposition decomposition) {
		val sourceGoal = ieIndex.get(decomposition.eContainer)
		val destinationGoal = ieIndex.get(decomposition.dest)
		if(sourceGoal !== null || destinationGoal !== null) {
			val SEdge decompositionModule = createEdge(destinationGoal, sourceGoal, DECOMPOSITION_EDGE_TYPE)
			val SLabel labelModule = configSElement(SLabel, decompositionModule.id + '-label', 'heading')
			labelModule.text = decomposition.decompositionType.getName
			decompositionModule.children.add(labelModule)
			parent.children.add(decompositionModule)
			return decompositionModule
		}
	}

	protected def dispatch generateElementLink(SModelElement parent, Dependency dependency) {
		var sourceGoal = ieIndex.get(dependency.eContainer)
		var destinationGoal = ieIndex.get(dependency.dest)
		if(sourceGoal !== null) {
			if(destinationGoal === null) {
				var actor = dependency.dest.eContainer as Actor
				val actorModule = generateActor(parent, actor)
				var ie = dependency.dest
				var ieType = ie.type.toString
				destinationGoal = generateIntentionalElement(actorModule, ie, ieType)
			}
			val SEdge dependencyModule = createEdge(sourceGoal, destinationGoal, DEPENDENCY_EDGE_TYPE)
			parent.children.add(dependencyModule)
			return dependencyModule
		}
	}

	protected def SModelElement generateActor(SModelElement parent, Actor actor) {
		val existingActorModule = actorIndex.get(actor)
		if(existingActorModule !== null) {
			return existingActorModule
		}
		val id = actor.longName.longname
		val actorModule = generateDetailedActor(id)
		actorIndex.put(actor, actorModule)
		parent.children.add(actorModule)
		return actorModule
	}

	protected def TURNNode generateDetailedActor(String longName) {
		val actorModule = configSElement(TURNNode, longName, 'actor')
		actorModule.layout = 'vbox'
		actorModule.layoutOptions = new LayoutOptions [
			paddingTop = 0.0
			paddingBottom = 20.0
			paddingLeft = 0.0
			paddingRight = 0.0
			resizeContainer = true
		]
		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, actorModule.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		actorModule.children.add(moduleHeadingCompartment)
		val SLabel labelModule = configSElement(SLabel, actorModule.id + '-label', 'heading')
		labelModule.text = longName
		moduleHeadingCompartment.children.add(labelModule)
		return actorModule
	}

	protected def SEdge createEdge(SModelElement fromElement, SModelElement toElement, String edgeType) {
		val SEdge edge = configSElement(SEdge, fromElement.id + '2' + toElement.id + 'importance', edgeType)
		edge.sourceId = fromElement.id
		edge.targetId = toElement.id
		return edge
	}

	protected def <E extends SModelElement> E configSElement(Class<E> elementClass, String idStr, String typeStr) {
		elementClass.constructor.newInstance => [
			id = idStr
			type = findType(it) + ':' + typeStr
			children = new ArrayList<SModelElement>
		]
	}

	protected def String findType(SModelElement element) {
		switch element {
			TURNNode: 'turnnode'
			TURNLabel: 'turnlabel'
			SLabel: 'label'
			SCompartment: 'comp'
			SEdge: 'edge'
			SButton: 'button'
			default: 'dontknow'
		}
	}
}