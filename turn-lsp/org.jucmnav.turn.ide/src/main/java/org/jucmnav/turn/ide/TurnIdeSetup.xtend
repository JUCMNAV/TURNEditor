package org.jucmnav.turn.ide;

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.jucmnav.turn.TurnStandaloneSetup
import org.jucmnav.turn.TurnRuntimeModule
import com.google.inject.Module

class TurnIdeSetup extends TurnStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new TurnRuntimeModule as Module, new TurnIdeModule));
	}
	
}