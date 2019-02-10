package mcgill.xtext.turn.diagram.test

import com.google.inject.Guice
import mcgill.xtext.turn.TURNRuntimeModule
import mcgill.xtext.turn.TURNStandaloneSetup
import mcgill.xtext.turn.diagram.TURNDiagramModule
import mcgill.xtext.turn.ide.TURNIdeModule

import org.eclipse.xtext.util.Modules2
import org.xtext.example.mydsl.tests.TURNInjectorProvider

class TURNDiagramInjectorProvider extends TURNInjectorProvider {
	
	override protected internalCreateInjector() {
		return new TURNStandaloneSetup {
			override createInjector() {
				Guice.createInjector(Modules2.mixin(new TURNRuntimeModule, new TURNIdeModule, new TURNDiagramModule)) 
			}}.createInjectorAndDoEMFRegistration
	}
}