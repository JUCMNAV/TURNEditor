package org.xtext.tColab.turn.ide.symbols

import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolKindProvider
import org.eclipse.emf.ecore.EClass


import static org.eclipse.lsp4j.SymbolKind.*
import org.xtext.tColab.turn.turn.Actor
import org.xtext.tColab.turn.turn.IntentionalElement

class TurnDocumentSymbolKindProvider extends DocumentSymbolKindProvider {

	override protected getSymbolKind(EClass clazz) {
		return switch (clazz) {
			case Actor: Module
			case IntentionalElement: Module
			default: Field
		}
	}

}
