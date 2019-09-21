package org.jucmnav.turn.diagram

import io.typefox.sprotty.api.Action
import io.typefox.sprotty.api.IDiagramExpansionListener
import io.typefox.sprotty.api.IDiagramServer
import io.typefox.sprotty.server.xtext.LanguageAwareDiagramServer
import org.apache.log4j.Logger

class TurnDiagramExpansionListener implements IDiagramExpansionListener {
	
	static val LOG = Logger.getLogger(TurnDiagramExpansionListener)
	
	override expansionChanged(Action action, IDiagramServer server) {
		LOG.info("expansionChanged(action, server) with server instance " + server.class.name);
		if (server instanceof LanguageAwareDiagramServer) {
			val languageServerExtension = server.languageServerExtension;
			languageServerExtension.updateDiagram(server);
		}
	}
}