/*
 * Copyright (C) 2017 TypeFox and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package mcgill.xtext.turn.diagram

import io.typefox.sprotty.server.xtext.IDiagramGenerator
import io.typefox.sprotty.server.xtext.ide.IdeDiagramModule
import io.typefox.sprotty.server.xtext.ide.IdeLanguageServerExtension

class TURNDiagramModule extends IdeDiagramModule {
	
	def Class<? extends IdeLanguageServerExtension> bindIdeLanguageServerExtension() {
		TURNLanguageServerExtension
	}
	
	override bindILayoutEngine() {
		TURNLayoutEngine
	}
	
	def Class<? extends IDiagramGenerator> bindIDiagramGenerator() {
		TURNDiagramGenerator
	}
	
	override bindIPopupModelFactory() {
		TURNPopupModelFactory
	}
	
	override bindIDiagramExpansionListener() {
		TURNDiagramExpansionListener
	}
	
}
