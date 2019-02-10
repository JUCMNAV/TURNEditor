package org.xtext.project.turn.tcolab.ide.extensions;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IDisposable;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/* @Log */@SuppressWarnings("all")
public class CommandService implements IExecutableCommandService {
  private final static PreferenceKey KEY = new PreferenceKey("extension.commands", "");
  
  @Inject
  private /* ExtensionProvider */Object extensionProvider;
  
  private Function1<? super String, ? extends IDisposable> register;
  
  private List<IDisposable> registeredCommands = CollectionLiterals.<IDisposable>newArrayList();
  
  private ExecutorService service = Executors.newSingleThreadExecutor();
  
  @Inject
  public void registerPreferenceChangeListener(final IPreferenceValuesProvider provider) {
    throw new Error("Unresolved compilation problems:"
      + "\nPreferenceValuesProvider cannot be resolved to a type."
      + "\nThe method registerChangeListener((Object)=>void) is undefined for the type IPreferenceValuesProvider"
      + "\nThe method or field $1 is undefined"
      + "\nThe method or field LOG is undefined"
      + "\nThe method or field LOG is undefined"
      + "\nThe field CommandService.extensionProvider refers to the missing type ExtensionProvider"
      + "\nThe field CommandService.extensionProvider refers to the missing type ExtensionProvider"
      + "\nThe field CommandService.extensionProvider refers to the missing type ExtensionProvider"
      + "\nThe field CommandService.extensionProvider refers to the missing type ExtensionProvider"
      + "\nThe field CommandService.extensionProvider refers to the missing type ExtensionProvider"
      + "\nThe field CommandService.extensionProvider refers to the missing type ExtensionProvider"
      + "\n=== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\ngetExtensions cannot be resolved"
      + "\nwarn cannot be resolved"
      + "\ncommands cannot be resolved"
      + "\nwarn cannot be resolved");
  }
  
  public Function1<? super String, ? extends IDisposable> dispose() {
    Function1<? super String, ? extends IDisposable> _xblockexpression = null;
    {
      this.registeredCommands.clear();
      _xblockexpression = this.register = null;
    }
    return _xblockexpression;
  }
  
  @Override
  public Object execute(final ExecuteCommandParams params, final ILanguageServerAccess access, final CancelIndicator cancelIndicator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field CommandService.extensionProvider refers to the missing type ExtensionProvider"
      + "\nThe field CommandService.extensionProvider refers to the missing type ExtensionProvider"
      + "\ngetExtensions cannot be resolved"
      + "\ncommands cannot be resolved"
      + "\ncontains cannot be resolved"
      + "\nexecuteCommand cannot be resolved");
  }
  
  @Override
  public List<String> initialize() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
  }
  
  @Override
  public void initializeDynamicRegistration(final Function1<? super String, ? extends IDisposable> register) {
    this.register = register;
  }
}
