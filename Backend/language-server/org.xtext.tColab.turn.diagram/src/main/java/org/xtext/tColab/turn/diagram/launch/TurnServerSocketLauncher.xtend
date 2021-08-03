package org.xtext.tColab.turn.diagram.launch

import org.eclipse.sprotty.xtext.launch.DiagramServerSocketLauncher


class TurnServerSocketLauncher extends DiagramServerSocketLauncher {

	override createSetup() {
		new TurnLanguageServerSetup
	}

	def static void main(String... args) {
		new TurnServerSocketLauncher().run(args)
	}
}
