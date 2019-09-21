package org.jucmnav.turn.ide.extensions;

import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.services.LanguageClient;

@SuppressWarnings("all")
public interface ICommandExtension {
  public abstract List<String> getCommands();
  
  public abstract void executeCommand(final String command, final Resource resource, final LanguageClient client);
}
