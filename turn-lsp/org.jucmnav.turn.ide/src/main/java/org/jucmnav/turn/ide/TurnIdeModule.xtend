package org.jucmnav.turn.ide

import java.util.List
import org.eclipse.lsp4j.CodeLens
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import org.eclipse.xtext.ide.server.codelens.ICodeLensResolver
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2
import org.eclipse.xtext.ide.server.formatting.FormattingService
import org.jucmnav.turn.ide.AbstractTurnIdeModule
import org.jucmnav.turn.ide.codeaction.CodeActionService
import org.jucmnav.turn.ide.symbols.TurnDocumentSymbolService
import org.jucmnav.turn.ide.completion.TurnContentAssistService
import org.jucmnav.turn.ide.completion.TurnContentProposalCreator
import org.jucmnav.turn.ide.rename.TurnRenameStrategy
import org.jucmnav.turn.ide.formatting.TurnFormattingService

class TurnIdeModule extends AbstractTurnIdeModule {

	def Class<? extends DocumentSymbolService> bindDocumentSymbolService() {
		return TurnDocumentSymbolService;
	}

	def Class<? extends ICodeLensResolver> bindICodeLensResolver() {
		return NoOpCodeLensResolver;
	}

	def Class<? extends ContentAssistService> bindContentAssistService() {
		return TurnContentAssistService;
	}

	def Class<? extends IdeContentProposalCreator> bindIdeContentProposalCreator() {
		return TurnContentProposalCreator;
	}

	def Class<? extends ICodeActionService2> bindICodeActionService() {
		return CodeActionService;
	}

	override Class<? extends IRenameStrategy2> bindIRenameStrategy2() {
		return TurnRenameStrategy
	}

	static class NoOpCodeLensResolver implements ICodeLensResolver {

		override resolveCodeLens(Document document, XtextResource resource, CodeLens codeLens,
			CancelIndicator indicator) {
			// HACKY fix for https://github.com/TypeFox/monaco-languageclient/pull/6
			if (codeLens?.command?.arguments?.head instanceof List<?>) {
				codeLens.command.arguments = codeLens.command.arguments.head as List<Object>
			}
			return codeLens
		}

	}

	def Class<? extends FormattingService> bindFormattingService() {
		TurnFormattingService
	}
}