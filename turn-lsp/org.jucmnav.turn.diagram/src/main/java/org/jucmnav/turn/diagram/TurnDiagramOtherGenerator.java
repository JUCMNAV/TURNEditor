package org.jucmnav.turn.diagram;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.jucmnav.turn.mapping.TurnSModelMapper;
import org.jucmnav.turn.sprotty.TurnSModel;
import io.typefox.sprotty.api.IDiagramState;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.server.xtext.IDiagramGenerator;

//TODO: change class name once tested
public class TurnDiagramOtherGenerator implements IDiagramGenerator {

	@Override
	public SModelRoot generate(Resource resource, IDiagramState state, CancelIndicator cancelIndicator) {		
		TurnResourceHandler turnResourceHandler = new TurnResourceHandler((XtextResource) resource);
		TurnDiagramStateHandler turnDiagramStateHandler = new TurnDiagramStateHandler(state);
		TurnSModelMapper turnSModelMapper = new TurnSModelMapper(turnResourceHandler, turnDiagramStateHandler);
		TurnSModel turnSModel = turnSModelMapper.mapTurnSourceToSModel();
		return (SModelRoot) turnSModel.generate();
	}

}
