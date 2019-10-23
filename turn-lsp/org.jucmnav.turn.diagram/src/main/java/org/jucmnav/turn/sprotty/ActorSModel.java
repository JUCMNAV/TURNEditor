package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import org.jucmnav.turn.diagram.TurnDiagramGenerator;
import org.jucmnav.turn.turn.Actor;
import io.typefox.sprotty.api.SModelElement;

public class ActorSModel implements TurnSModel {
	
	private Actor actor;
	
	public ActorSModel(Actor actor) {
		this.actor = actor;
	}
	
	@Override
	public SModelElement generate() {
		TurnDiagramGenerator diagramGenerator = new TurnDiagramGenerator();
		return diagramGenerator.generateDiagram(actor);
	}
	
	@Override
	public List<SModelElement> generateChildren(){		
		List<SModelElement> children = new ArrayList<>();		
		return children;
	}
	

}
