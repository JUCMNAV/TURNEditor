package org.xtext.tColab.turn.diagram.launch

import com.google.inject.Guice
import org.xtext.tColab.turn.TurnRuntimeModule
import org.xtext.tColab.turn.diagram.TurnDiagramModule
import org.xtext.tColab.turn.ide.TurnIdeModule
import org.xtext.tColab.turn.ide.TurnIdeSetup
import org.xtext.tColab.turn.ide.server.TurnProjectManager
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider
import org.eclipse.elk.core.util.persistence.ElkGraphResourceFactory
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.sprotty.layout.ElkLayoutEngine
import org.eclipse.sprotty.xtext.launch.DiagramLanguageServerSetup
import org.eclipse.sprotty.xtext.ls.SyncDiagramServerModule
import org.eclipse.xtext.ide.server.ProjectManager
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.Modules2

class TurnLanguageServerSetup extends DiagramLanguageServerSetup {
	
	override setupLanguages() {
		// Initialize ELK
		ElkLayoutEngine.initialize(new LayeredMetaDataProvider)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put('elkg', new ElkGraphResourceFactory)
		
		// Do a manual setup that includes the Yang diagram module
		new TurnIdeSetup {
			override createInjector() {
				Guice.createInjector(Modules2.mixin(new TurnRuntimeModule, new TurnIdeModule, new TurnDiagramModule))
			}
		}.createInjectorAndDoEMFRegistration()
	}

	override getLanguageServerModule() {
		Modules2.mixin(
			new ServerModule,
			new SyncDiagramServerModule,
			[
				bind(IResourceServiceProvider.Registry).toProvider(IResourceServiceProvider.Registry.RegistryProvider)
				bind(ProjectManager).to(TurnProjectManager)
			]
		) 
	}
	
}