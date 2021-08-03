package org.xtext.tColab.turn.diagram

import org.eclipse.sprotty.Action
import org.eclipse.sprotty.IDiagramExpansionListener
import org.eclipse.sprotty.IDiagramServer
import org.eclipse.sprotty.xtext.LanguageAwareDiagramServer

class TurnDiagramExpansionListener implements IDiagramExpansionListener {
	
	override expansionChanged(Action action, IDiagramServer server) {
		if (server instanceof LanguageAwareDiagramServer) {
			server.diagramLanguageServer.diagramUpdater.updateDiagram(server)
		}
	}

}