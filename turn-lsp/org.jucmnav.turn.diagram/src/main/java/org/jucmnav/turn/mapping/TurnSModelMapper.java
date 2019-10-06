package org.jucmnav.turn.mapping;

import org.jucmnav.turn.diagram.TurnDiagramStateHandler;
import org.jucmnav.turn.diagram.TurnResourceHandler;
import org.jucmnav.turn.sprotty.ActorSModel;
import org.jucmnav.turn.sprotty.ContributionSModel;
import org.jucmnav.turn.sprotty.DecompositionSModel;
import org.jucmnav.turn.sprotty.DependencySModel;
import org.jucmnav.turn.sprotty.TurnSModel;
import org.jucmnav.turn.sprotty.UCMmapSModel;
import org.jucmnav.turn.turn.Actor;
import org.jucmnav.turn.turn.Contribution;
import org.jucmnav.turn.turn.Decomposition;
import org.jucmnav.turn.turn.Dependency;
import org.jucmnav.turn.turn.UCMmap;
import org.jucmnav.turn.turn.URNmodelElement;

public class TurnSModelMapper {
	
	private TurnResourceHandler turnResourceHandler;
	private TurnDiagramStateHandler turnDiagramStateHandler;
	
	public TurnSModelMapper(TurnResourceHandler turnResourceHandler, TurnDiagramStateHandler turnDiagramStateHandler) {
		this.turnResourceHandler = turnResourceHandler;
		this.turnDiagramStateHandler = turnDiagramStateHandler;
	}
	
	public TurnSModel mapTurnSourceToSModel() {
		String sourceName = turnDiagramStateHandler.getSourceName();
		URNmodelElement urnModelElement = turnResourceHandler.getTurnElementFromName(sourceName);
		return mapURNmodelElementToSModel(urnModelElement);
	}
	
	public static TurnSModel mapURNmodelElementToSModel(URNmodelElement urnModelElement) {
		TurnSModel turnSModel = null;
		if(urnModelElement instanceof Actor) {
			turnSModel = new ActorSModel((Actor) urnModelElement);
		}else if(urnModelElement instanceof UCMmap) {
			turnSModel = new UCMmapSModel((UCMmap) urnModelElement);
		}else if(urnModelElement instanceof Contribution) {
			turnSModel = new ContributionSModel((Contribution) urnModelElement);
		}else if(urnModelElement instanceof Dependency) {
			turnSModel = new DependencySModel((Dependency) urnModelElement);
		}else if(urnModelElement instanceof Decomposition) {
			turnSModel = new DecompositionSModel((Decomposition) urnModelElement);
		}
		return turnSModel;
	}
}
