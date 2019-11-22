/*

* Copyright (C) 2017 TypeFox and others.

*

* Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.

* You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

*/

package org.xtext.project.turn.tcolab.diagram

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
import org.xtext.project.turn.turn.Actor
import org.xtext.project.turn.turn.Contribution
import org.xtext.project.turn.turn.Decomposition
import org.xtext.project.turn.turn.Dependency
import org.xtext.project.turn.turn.IntentionalElement
import org.xtext.project.turn.turn.URNspec
import org.xtext.project.turn.turn.EvaluationStrategy
import java.util.Arrays
import java.util.List

class TURNDiagramGenerator implements IDiagramGenerator {

	static val CONTRIBUTE_EDGE_TYPE = 'contribute'
	static val CORRELATION_EDGE_TYPE = 'correlated'
	static val DECOMPOSITION_EDGE_TYPE = 'decomposition'
	static val DEPENDENCY_EDGE_TYPE = 'dependency'

	var Map<Actor, SModelElement> actorIndex = new HashMap
	var Map<IntentionalElement, SModelElement> ieIndex = new HashMap

	XtextResource xtresource
	IParseResult parseResult
	TURNEvaluationManager evalManager;

	override generate(Resource resource, IDiagramState state, CancelIndicator cancelIndicator) {
		xtresource = resource as XtextResource
		if (xtresource !== null) {
			parseResult = xtresource.getParseResult();
			if (parseResult !== null) {
				var urnSpec = parseResult.getRootNode().semanticElement as URNspec;
				val stateInfo = state.getOptions();
				val stateURI = stateInfo.get('sourceUri')
				var node = stateURI.substring(stateURI.lastIndexOf("#") + 1)
				var listElements = Arrays.asList(node.split("%2C"));

				var ArrayList<Actor> actorList = new ArrayList<Actor>();
				var ArrayList<EvaluationStrategy> strategyList = new ArrayList<EvaluationStrategy>();
				for (element : listElements) {
					val elemenName = element.substring(element.lastIndexOf(".") + 1)
					for (actor : urnSpec.actors) {
						if (elemenName == actor.name) {
							actorList.add(actor)
						}
					}
					for (strategy : urnSpec.strategies) {
						if (elemenName == strategy.name) {
							strategyList.add(strategy)
						}
					}
				}

				if (actorList.size() > 1) {
					var ArrayList<String> actorNames = new ArrayList<String>();
					for (actor : actorList) {
						actorNames.add(actor.name)
					}
					return generateErrorDiagram(actorNames)
				}
				if (strategyList.size() > 1) {
					var ArrayList<String> strategyNames = new ArrayList<String>();
					for (strategy : strategyList) {
						strategyNames.add(strategy.name)
					}
					return generateErrorDiagram(strategyNames)
				}

				var Actor actor
				if (actorList.size() == 0) {
					if (urnSpec.actors.size == 0) {
						return generateEmptyDiagram()
					}
					actor = urnSpec.actors.head
				} else {
					actor = actorList.get(0)
				}
				if (strategyList.size() == 1) {
					evalManager = new TURNEvaluationManager(strategyList.get(0));

				}
				return generateDiagram(actor)
			}
		}
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

	def SModelRoot generateErrorDiagram(List<String> string) {
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
		var error = generateDetailedErrorDiagram(string)
		diagramRoot.children.add(error)
		return diagramRoot
	}

	def SModelRoot generateEmptyDiagram() {
		val SGraph diagramRoot = new SGraph => [
			type = 'graph'
			id = 'turn'
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

		return diagramRoot
	}

	protected def TURNNode generateDetailedErrorDiagram(List<String> string) {
		val errorModule = configSElement(TURNNode, 'string', 'error')
		errorModule.layout = 'hbox'
		errorModule.layoutOptions = new LayoutOptions [
			paddingTop = 10.0
			paddingBottom = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			resizeContainer = true
		]

		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, errorModule.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		errorModule.children.add(moduleHeadingCompartment)

		val SLabel moduleLabel = configSElement(SLabel, errorModule.id + '-label', 'heading')
		moduleLabel.text = string + " selected. Please select only one."
		moduleHeadingCompartment.children.add(moduleLabel)

		return errorModule
	}

	protected def SModelElement generateIntentionalElement(SModelElement parent, IntentionalElement ie, String ieType) {
		val existingIEModule = ieIndex.get(ie)
		if (existingIEModule !== null) {
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
		if (ie.importance.value == 'none' || ie.importanceQuantitative == 0) {
			importance = '' + ie.importance
		}

		var textDisplay = longName + ' ' + '(' + importance + ')'
		if (evalManager !== null) {
			var ieEvalval = evalManager.getEvaluation(ie);
			textDisplay = textDisplay + ' ' + '[' + ieEvalval + '*' + ']'
		}

		val SLabel moduleLabel = configSElement(SLabel, ieModule.id + '-label', 'heading')
		moduleLabel.text = textDisplay
		moduleHeadingCompartment.children.add(moduleLabel)
		return ieModule
	}

	protected def dispatch generateElementLink(SModelElement parent, Contribution contribution) {
		val sourceGoal = ieIndex.get(contribution.eContainer)
		val destinationGoal = ieIndex.get(contribution.dest)

		if (sourceGoal !== null || destinationGoal !== null) {
			var contributionType = CONTRIBUTE_EDGE_TYPE
			if (contribution.correlation) {
				contributionType = CORRELATION_EDGE_TYPE
			}

			val SEdge contributionModule = createEdge(destinationGoal, sourceGoal, contributionType)

			var contributionValue = '' + contribution.quantitativeContribution
			if (contribution.contribution.value == 'undefined' || contribution.quantitativeContribution == 0) {
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

		if (sourceGoal !== null || destinationGoal !== null) {
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
		if (sourceGoal !== null) {
			if (destinationGoal === null) {
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
		if (existingActorModule !== null) {
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
			default: 'dontknow'
		}
	}

}
