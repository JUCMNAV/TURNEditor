package org.xtext.tColab.turn.ide.symbols

import com.google.common.collect.Lists
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper.DocumentSymbolNameProvider
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.xtext.tColab.turn.turn.Actor
import org.xtext.tColab.turn.turn.IntentionalElement

class TurnDocumentSymbolNameProvider extends DocumentSymbolNameProvider {

	override getName(EObject object) {
		if (object instanceof Actor) {
			return object.getName();
		} else if (object instanceof IntentionalElement) {
			return object.getName();
		} 
		return super.getName(object);
	}


}
