package org.xtext.project.turn.tcolab.ide.codeAction;

import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CodeActionService implements ICodeActionService {
  private final static String COMMAND_ID = "yang.apply.workspaceEdit";
  
  @Override
  public List<Either<Command, CodeAction>> getCodeActions(final Document document, final XtextResource resource, final CodeActionParams params, final CancelIndicator indicator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field IssueCodes is undefined"
      + "\nINCORRECT_VERSION cannot be resolved");
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
