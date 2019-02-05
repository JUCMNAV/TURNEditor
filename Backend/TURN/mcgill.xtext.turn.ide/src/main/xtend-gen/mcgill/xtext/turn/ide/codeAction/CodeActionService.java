package mcgill.xtext.turn.ide.codeAction;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mcgill.xtext.turn.validation.IssueCodes;
import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CodeActionService implements ICodeActionService {
  private final static String COMMAND_ID = "yang.apply.workspaceEdit";
  
  @Override
  public List<Either<Command, CodeAction>> getCodeActions(final Document document, final XtextResource resource, final CodeActionParams params, final CancelIndicator indicator) {
    final ArrayList<Command> result = CollectionLiterals.<Command>newArrayList();
    List<Diagnostic> _diagnostics = params.getContext().getDiagnostics();
    for (final Diagnostic d : _diagnostics) {
      String _code = d.getCode();
      boolean _equals = Objects.equal(_code, IssueCodes.INCORRECT_VERSION);
      if (_equals) {
        URI _uRI = resource.getURI();
        TextEdit _textEdit = new TextEdit();
        final Procedure1<TextEdit> _function = (TextEdit it) -> {
          it.setNewText("1.1");
          it.setRange(d.getRange());
        };
        TextEdit _doubleArrow = ObjectExtensions.<TextEdit>operator_doubleArrow(_textEdit, _function);
        Command _createFix = this.createFix("Change to \"1.1\".", _uRI, _doubleArrow);
        result.add(_createFix);
      }
    }
    final Function1<Command, Either<Command, CodeAction>> _function_1 = (Command it) -> {
      return Either.<Command, CodeAction>forLeft(it);
    };
    return ListExtensions.<Command, Either<Command, CodeAction>>map(result, _function_1);
  }
  
  private Command createFix(final String title, final URI uri, final TextEdit... edits) {
    final List<TextEdit> textEdits = IterableExtensions.<TextEdit>toList(((Iterable<TextEdit>)Conversions.doWrapArray(edits)));
    WorkspaceEdit _workspaceEdit = new WorkspaceEdit();
    final Procedure1<WorkspaceEdit> _function = (WorkspaceEdit it) -> {
      it.getChanges().put(uri.toString(), textEdits);
    };
    final WorkspaceEdit edit = ObjectExtensions.<WorkspaceEdit>operator_doubleArrow(_workspaceEdit, _function);
    Command _command = new Command();
    final Procedure1<Command> _function_1 = (Command it) -> {
      it.setCommand(CodeActionService.COMMAND_ID);
      it.setTitle(title);
      it.setArguments(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(edit)));
    };
    final Command result = ObjectExtensions.<Command>operator_doubleArrow(_command, _function_1);
    return result;
  }
}
