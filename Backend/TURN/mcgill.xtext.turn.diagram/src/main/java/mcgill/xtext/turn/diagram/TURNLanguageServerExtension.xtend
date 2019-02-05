/*
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package mcgill.xtext.turn.diagram

import com.google.inject.Singleton
import io.typefox.sprotty.api.IDiagramServer
import io.typefox.sprotty.server.xtext.LanguageAwareDiagramServer
import io.typefox.sprotty.server.xtext.ide.IdeLanguageServerExtension
import java.util.Collection
import org.eclipse.emf.common.util.URI
import java.util.List
import io.typefox.sprotty.server.xtext.ILanguageAwareDiagramServer
import java.util.concurrent.CompletableFuture
import com.google.inject.Inject
import com.google.inject.Provider
import io.typefox.sprotty.server.xtext.IDiagramGenerator
import static io.typefox.sprotty.api.ServerStatus.Severity.*
import io.typefox.sprotty.api.SModelRoot
import java.util.Map
import java.util.HashMap
import io.typefox.sprotty.api.DefaultDiagramServer
import io.typefox.sprotty.api.ActionMessage
import io.typefox.sprotty.api.UpdateModelAction
import io.typefox.sprotty.api.Action
import io.typefox.sprotty.api.RequestModelAction
import io.typefox.sprotty.api.SetModelAction
import io.typefox.sprotty.api.LayoutUtil
import io.typefox.sprotty.api.ILayoutEngine
import io.typefox.sprotty.api.SGraph
import io.typefox.sprotty.api.RequestBoundsAction
import io.typefox.sprotty.api.Dimension

@Singleton
class TURNLanguageServerExtension extends IdeLanguageServerExtension {


	@Inject Provider<IDiagramGenerator> diagramGeneratorProvider
	var Map<IDiagramServer, SModelRoot> elementIE = new HashMap
	ILayoutEngine layoutEngine = getLayoutEngine();
	SModelRoot cm
	var localK = null
	boolean flag = false
	Dimension nodeSZ = null
	
	protected def ILayoutEngine getLayoutEngine() {
		return layoutEngine;
	}

	override protected initializeDiagramServer(IDiagramServer server) {
		super.initializeDiagramServer(server)
		val languageAware = server as LanguageAwareDiagramServer
		languageAware.needsServerLayout = true
		languageAware.needsClientLayout = true

		LOG.info("Created diagram server for " + server.clientId)
	}

	override protected doUpdateDiagrams(Collection<? extends URI> uris) {
		for (uri : uris) {
			for (d : diagramServers.values) {
				val stateInfo = d.options;
				val stateURI = stateInfo.get('sourceUri')
				val path = stateURI
				val root = d.model
				LOG.info("so now i am in doUpdateDiagrams with ROOT " + root)

				val diagramServers = findDiagramServersByUri(path)

				LOG.info("RECCCCO" + diagramServers.size)
				val first = diagramServers.get(0)
				LOG.info("so now i am in doUpdateDiagrams with path " + path + "DIAGRAMSERVER" + diagramServers)
				doUpdateDiagrams(path, diagramServers)
			}
		}
	}

	override List<? extends ILanguageAwareDiagramServer> findDiagramServersByUri(String uri) {
		synchronized (diagramServers) {
			LOG.info("Inside ILanguageAwareDiagramServer URI" + uri)
			diagramServers.values.filter(ILanguageAwareDiagramServer).filter[sourceUri == uri].toList

		}

	}

	override protected def CompletableFuture<Void> doUpdateDiagrams(String path,
		List<? extends ILanguageAwareDiagramServer> diagramServers) {
		if (diagramServers.empty) {
			return CompletableFuture.completedFuture(null)
		}
		return path.doRead [ context |
			val status = context.resource.shouldGenerate(context.cancelChecker)
			return diagramServers.map [ server |
				server -> {
					server.status = status
					if (status.severity !== ERROR) {
						val diagramGenerator = diagramGeneratorProvider.get
						diagramGenerator.generate(context.resource, server.diagramState, context.cancelChecker)
					} else {
						null
					}
				}
			]
		].thenAccept [ resultList |
			resultList.filter[value !== null].forEach [


			
	
		
			val state = key.diagramState
			val currentM = state.getCurrentModel()
						LOG.info("URIIIII" + currentM + "Bahu" + value)
					
//						if(!elementIE.empty && localK !== null)
//						{
//							LOG.info("URz" + elementIE)
//							val lastModel = elementIE.get(localK)
//							key.model = localK as SModelRoot
//							LOG.info("UR" + localK)
//							key.model = localK as SModelRoot
//							key.model = value
//						}

		val x = key.diagramState.currentModel
		key.model = x	
		key.setModel(value)
						
							val currentM2 = state.getCurrentModel()
						LOG.info("URIIIII2" + currentM2 + "Bahu2" + value)	
						elementIE.put(key,currentM2)
						localK = currentM2
						
					


			]
		].exceptionally [ throwable |
			LOG.error('Error while processing build results', throwable)
			return null
		]
	}

	override didClose(String clientId) {
		super.didClose(clientId)
		LOG.info("Removed diagram server for " + clientId)
	}
}
