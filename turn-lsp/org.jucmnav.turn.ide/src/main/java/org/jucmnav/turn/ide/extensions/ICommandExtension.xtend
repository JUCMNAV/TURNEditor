package org.jucmnav.turn.ide.extensions;

import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.lsp4j.services.LanguageClient

interface ICommandExtension {
	
	def List<String> getCommands();
	
	def void executeCommand(String command, Resource resource, LanguageClient client);
	
}