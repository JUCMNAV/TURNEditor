/*
 * generated by Xtext 2.16.0
 */
package org.xtext.tColab.turn.ide

import com.google.inject.Guice
import org.xtext.tColab.turn.TurnRuntimeModule
import org.xtext.tColab.turn.TurnStandaloneSetup
import org.eclipse.xtext.util.Modules2


/**
 * Initialization support for running Xtext languages as language servers.
 */
class TurnIdeSetup extends TurnStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new TurnRuntimeModule, new TurnIdeModule))
	}
	
}
