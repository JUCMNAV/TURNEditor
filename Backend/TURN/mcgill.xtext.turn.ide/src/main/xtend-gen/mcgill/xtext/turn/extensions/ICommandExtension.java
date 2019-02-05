package mcgill.xtext.turn.extensions;

import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.services.LanguageClient;

@SuppressWarnings("all")
public interface ICommandExtension {
  /**
   * Returns the commands that are contributed by this extension.
   */
  public abstract List<String> getCommands();
  
  /**
   * Executes the given command.
   */
  public abstract void executeCommand(final String command, final Resource resource, final LanguageClient client);
}
