package org.xtext.tColab.turn.diagram

import org.eclipse.sprotty.xtext.DiagramServerFactory

class TurnDiagramServerFactory extends DiagramServerFactory {

	override getDiagramTypes() {
		#['turn-diagram']
	}
}