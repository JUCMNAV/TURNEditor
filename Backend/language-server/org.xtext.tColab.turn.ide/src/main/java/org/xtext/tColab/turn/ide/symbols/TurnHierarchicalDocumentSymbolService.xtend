package org.xtext.tColab.turn.ide.symbols

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.ide.server.symbol.HierarchicalDocumentSymbolService

import static extension com.google.common.collect.Iterators.*
import org.xtext.tColab.turn.turn.Actor

class TurnHierarchicalDocumentSymbolService extends HierarchicalDocumentSymbolService {

	override protected getAllContents(Resource resource) {
		val module = resource.contents.head;
		if (module instanceof Actor) {
			val allStatements = EcoreUtil.getAllProperContents(module, true).filter(Actor);
			return allStatements.filter(Object);
		}
		return emptyList.iterator;
	}

}
