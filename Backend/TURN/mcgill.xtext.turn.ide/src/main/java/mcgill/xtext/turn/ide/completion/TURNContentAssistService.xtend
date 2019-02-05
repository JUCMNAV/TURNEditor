package mcgill.xtext.turn.ide.completion

import org.eclipse.lsp4j.CompletionItemKind
import org.eclipse.lsp4j.InsertTextFormat
import org.eclipse.lsp4j.Position
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService

/**
 * Content assist service for YANG that supports templates too.
 * 
 * @author akos.kitta
 */
class TURNContentAssistService extends ContentAssistService {
	
	override protected toCompletionItem(ContentAssistEntry entry, int caretOffset, Position caretPosition, Document document) {
		val item = super.toCompletionItem(entry, caretOffset, caretPosition, document);
		if (item.kind === CompletionItemKind.Snippet) {
			item.insertTextFormat = InsertTextFormat.Snippet;
		}
		return item;
	}
	
}