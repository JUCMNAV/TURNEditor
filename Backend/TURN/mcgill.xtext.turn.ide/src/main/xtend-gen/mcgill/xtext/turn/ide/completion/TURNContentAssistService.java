package mcgill.xtext.turn.ide.completion;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.InsertTextFormat;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService;

/**
 * Content assist service for YANG that supports templates too.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class TURNContentAssistService extends ContentAssistService {
  @Override
  protected CompletionItem toCompletionItem(final ContentAssistEntry entry, final int caretOffset, final Position caretPosition, final Document document) {
    final CompletionItem item = super.toCompletionItem(entry, caretOffset, caretPosition, document);
    CompletionItemKind _kind = item.getKind();
    boolean _tripleEquals = (_kind == CompletionItemKind.Snippet);
    if (_tripleEquals) {
      item.setInsertTextFormat(InsertTextFormat.Snippet);
    }
    return item;
  }
}
