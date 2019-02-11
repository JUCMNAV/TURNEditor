package org.xtext.project.turn.tcolab.diagram

import io.typefox.sprotty.api.Action
import io.typefox.sprotty.api.IDiagramExpansionListener
import io.typefox.sprotty.api.IDiagramServer
import io.typefox.sprotty.server.xtext.LanguageAwareDiagramServer
import org.apache.log4j.Logger

class TurnDiagramExpansionListener implements IDiagramExpansionListener {
	static val LOG = Logger.getLogger(TurnDiagramExpansionListener)
	
	override expansionChanged(Action action, IDiagramServer server) {
		LOG.info("I am outside TURNDiagramExpansionListener")
		if (server instanceof LanguageAwareDiagramServer) {
			LOG.info("I am inside TURNDiagramExpansionListener" + server.sourceUri + "root" + server.model)
			val languageServerExtension = server.languageServerExtension
			languageServerExtension.updateDiagram(server)
		}
	}
}