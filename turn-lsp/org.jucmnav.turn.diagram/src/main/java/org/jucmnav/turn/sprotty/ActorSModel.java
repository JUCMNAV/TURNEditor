package org.jucmnav.turn.sprotty;

import org.jucmnav.turn.diagram.TGRLDiagramGenerator;
import org.jucmnav.turn.turn.Actor;
import io.typefox.sprotty.api.SModelElement;

public class ActorSModel implements TurnSModel {
	
	private Actor actor;
	
	public ActorSModel(Actor actor) {
		this.actor = actor;
	}
	
	@Override
	public SModelElement generate() {
		TGRLDiagramGenerator diagramGenerator = new TGRLDiagramGenerator();
		return diagramGenerator.generateDiagram(actor);
	}

}
