package org.jucmnav.turn.diagram;

import org.apache.log4j.Logger;
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
	
	private static Logger LOGGER = Logger.getLogger(TurnDiagramOtherGenerator.class);

	@Override
	public SModelRoot generate(Resource resource, IDiagramState state, CancelIndicator cancelIndicator) {		
		TurnResourceHandler turnResourceHandler = new TurnResourceHandler((XtextResource) resource);
		TurnDiagramStateHandler turnDiagramStateHandler = new TurnDiagramStateHandler(state);
		TurnSModelMapper turnSModelMapper = new TurnSModelMapper(turnResourceHandler, turnDiagramStateHandler);
		TurnSModel turnSModel;
		SModelRoot sModelRoot = null;
		try {
			turnSModel = turnSModelMapper.mapTurnSourceToSModel();
			sModelRoot = (SModelRoot) turnSModel.generate();
		}catch(IllegalArgumentException e) {
			LOGGER.warn(e);
		}		
		return sModelRoot;
	}

}
