package mcgill.xtext.turn.diagram

import com.google.inject.Inject
import io.typefox.sprotty.api.HtmlRoot
import io.typefox.sprotty.api.IDiagramServer
import io.typefox.sprotty.api.IPopupModelFactory
import io.typefox.sprotty.api.PreRenderedElement
import io.typefox.sprotty.api.RequestPopupModelAction
import io.typefox.sprotty.api.SModelElement
import io.typefox.sprotty.server.xtext.tracing.ITraceProvider
import io.typefox.sprotty.server.xtext.tracing.Traceable
import org.xtext.example.mydsl.tURN.Actor

import java.util.ArrayList
import io.typefox.sprotty.server.xtext.ILanguageAwareDiagramServer
import org.xtext.example.mydsl.tURN.URNspec

class TURNPopupModelFactory implements IPopupModelFactory {

	@Inject extension ITraceProvider

	override createPopupModel(SModelElement element, RequestPopupModelAction request, IDiagramServer server) {
		if (element instanceof Traceable) {
			val future = element.withSource(server as ILanguageAwareDiagramServer) [ actor, context |
				if (actor instanceof URNspec) 
					createPopup(actor, element, request)
				else
					null
			]
			future.get
		} else {
			null
		}
	}

	protected def createPopup(URNspec desc, SModelElement element, RequestPopupModelAction request) {
		val popupId = element.id + '-popup'
		val infos = new ArrayList<Pair<String, String>>

	
			val info1 = createHtml(desc)
			if(info1 !== null) infos.add(info1)
	
		if (!infos.empty)
			new HtmlRoot [
				type = 'html'
				id = popupId
				children = #[
					new PreRenderedElement [
						type = 'pre-rendered'
						id = popupId + '-body'
						code = '''
							<div class="infoBlock">
								«FOR info : infos»
									<div class="sprotty-infoRow">
										<div class="sprotty-infoTitle">«info.key»:</div>
										<div class="sprotty-infoText">«info.value»</div>
									</div>
								«ENDFOR»
							</div>
						'''
					]
				]
				canvasBounds = request.bounds
			]
			
	}

	

	protected def dispatch Pair<String, String> createHtml(URNspec descriptionStmt) {
		'actor' -> descriptionStmt.name
	}

}
