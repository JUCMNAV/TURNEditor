package org.xtext.tColab.turn.diagram

import org.eclipse.sprotty.xtext.DefaultDiagramModule
import org.eclipse.sprotty.xtext.IDiagramGenerator

class TurnDiagramModule extends DefaultDiagramModule {
	
override bindIDiagramServerFactory() {
		TurnDiagramServerFactory
	}
	
	def Class<? extends IDiagramGenerator> bindIDiagramGenerator() {
		TurnDiagramGenerator
	}
	
	override bindILayoutEngine() {
		TurnLayoutEngine
	}
	
	override bindIPopupModelFactory() {
		TurnPopupModelFactory
	}
	
	override bindIDiagramExpansionListener() {
		TurnDiagramExpansionListener
	}
	
}