package mcgill.xtext.turn.ide.symbols

import com.google.inject.Inject

import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.lsp4j.SymbolInformation
import org.eclipse.lsp4j.SymbolKind
import org.eclipse.xtext.findReferences.IReferenceFinder.IResourceAccess
import org.eclipse.xtext.ide.server.DocumentExtensions
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.TextRegion


class TURNDocumentSymbolService extends DocumentSymbolService {
	
	@Inject extension DocumentExtensions 
	@Inject EObjectAtOffsetHelper helper
	@Inject ILocationInFileProvider locationProvider
	
	override getDefinitions(XtextResource resource, int offset, IResourceAccess resourceAccess, CancelIndicator cancelIndicator) {
		val node = helper.getCrossReferenceNode(resource, new TextRegion(offset,0))
		if (node !== null) {
			val element = helper.getCrossReferencedElement(node)
			if (element !== null) {
				return #[element.symbolFullLocation]
			}
		}
		return emptyList
	}
	

	
	protected def getSymbolFullLocation(EObject object) {
		val resource = object.eResource
		val fullRegion = locationProvider.getFullTextRegion(object)
		resource.newLocation(fullRegion)
	}
	
}