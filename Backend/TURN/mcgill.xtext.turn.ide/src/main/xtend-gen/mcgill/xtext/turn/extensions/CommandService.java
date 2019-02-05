package mcgill.xtext.turn.extensions;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import mcgill.xtext.turn.extensions.ICommandExtension;
import mcgill.xtext.turn.settings.PreferenceValuesProvider;
import mcgill.xtext.turn.utils.ExtensionProvider;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IDisposable;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@Log
@SuppressWarnings("all")
public class CommandService implements IExecutableCommandService {
  private final static PreferenceKey KEY = new PreferenceKey("extension.commands", "");
  
  @Inject
  private ExtensionProvider extensionProvider;
  
  private Function1<? super String, ? extends IDisposable> register;
  
  private List<IDisposable> registeredCommands = CollectionLiterals.<IDisposable>newArrayList();
  
  private ExecutorService service = Executors.newSingleThreadExecutor();
  
  @Inject
  public void registerPreferenceChangeListener(final IPreferenceValuesProvider provider) {
    if ((provider instanceof PreferenceValuesProvider)) {
      final Procedure2<IPreferenceValues, Resource> _function = (IPreferenceValues $0, Resource $1) -> {
        if (((this.extensionProvider == null) || (this.register == null))) {
          return;
        }
        final Runnable _function_1 = () -> {
          try {
            Thread.sleep(1000);
            final List<ICommandExtension> extensions = this.extensionProvider.<ICommandExtension>getExtensions(CommandService.KEY, $1, ICommandExtension.class);
            try {
              final Consumer<IDisposable> _function_2 = (IDisposable it) -> {
                it.dispose();
              };
              this.registeredCommands.forEach(_function_2);
            } catch (final Throwable _t) {
              if (_t instanceof Exception) {
                final Exception e = (Exception)_t;
                String _message = e.getMessage();
                String _plus = ("Error unregistering commands : " + _message);
                CommandService.LOG.warn(_plus);
                this.dispose();
                return;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            this.registeredCommands = CollectionLiterals.<IDisposable>newArrayList();
            for (final ICommandExtension ext : extensions) {
              List<String> _commands = ext.getCommands();
              for (final String c : _commands) {
                try {
                  final IDisposable apply = this.register.apply(c);
                  this.registeredCommands.add(apply);
                } catch (final Throwable _t_1) {
                  if (_t_1 instanceof Exception) {
                    final Exception e_1 = (Exception)_t_1;
                    String _message_1 = e_1.getMessage();
                    String _plus_1 = ("Error registering commands : " + _message_1);
                    CommandService.LOG.warn(_plus_1);
                    this.dispose();
                    return;
                  } else {
                    throw Exceptions.sneakyThrow(_t_1);
                  }
                }
              }
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        };
        this.service.submit(_function_1);
      };
      ((PreferenceValuesProvider)provider).registerChangeListener(_function);
    }
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
    try {
      Object _xblockexpression = null;
      {
        Object _head = IterableExtensions.<Object>head(params.getArguments());
        final String uri = ((String) _head);
        Object _xifexpression = null;
        if ((uri != null)) {
          final Function<ILanguageServerAccess.Context, Object> _function = (ILanguageServerAccess.Context it) -> {
            final List<ICommandExtension> commands = this.extensionProvider.<ICommandExtension>getExtensions(CommandService.KEY, it.getResource(), ICommandExtension.class);
            for (final ICommandExtension c : commands) {
              boolean _contains = c.getCommands().contains(params.getCommand());
              if (_contains) {
                try {
                  c.executeCommand(params.getCommand(), it.getResource(), access.getLanguageClient());
                } catch (final Throwable _t) {
                  if (_t instanceof Exception) {
                    final Exception e = (Exception)_t;
                    LanguageClient _languageClient = access.getLanguageClient();
                    MessageParams _messageParams = new MessageParams();
                    final Procedure1<MessageParams> _function_1 = (MessageParams it_1) -> {
                      StringConcatenation _builder = new StringConcatenation();
                      _builder.append("Couldn\'t execute command \'");
                      _builder.append(c);
                      _builder.append("\'.");
                      _builder.newLineIfNotEmpty();
                      _builder.newLine();
                      _builder.append("Error : ");
                      String _message = e.getMessage();
                      _builder.append(_message);
                      _builder.newLineIfNotEmpty();
                      _builder.append("Stack Trace : ");
                      _builder.newLine();
                      {
                        StackTraceElement[] _stackTrace = e.getStackTrace();
                        for(final StackTraceElement traceElement : _stackTrace) {
                          _builder.append("\t");
                          String _string = traceElement.toString();
                          _builder.append(_string, "\t");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      it_1.setMessage(_builder.toString());
                    };
                    MessageParams _doubleArrow = ObjectExtensions.<MessageParams>operator_doubleArrow(_messageParams, _function_1);
                    _languageClient.showMessage(_doubleArrow);
                  } else {
                    throw Exceptions.sneakyThrow(_t);
                  }
                }
              }
            }
            return null;
          };
          _xifexpression = access.<Object>doRead(uri, _function).get();
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public List<String> initialize() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
  }
  
  @Override
  public void initializeDynamicRegistration(final Function1<? super String, ? extends IDisposable> register) {
    this.register = register;
  }
  
  private final static Logger LOG = Logger.getLogger(CommandService.class);
}
