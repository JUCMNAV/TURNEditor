package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import org.jucmnav.turn.diagram.TurnDiagramGenerator;
import org.jucmnav.turn.mapping.TurnSModelMapper;
import org.jucmnav.turn.turn.Actor;
import org.jucmnav.turn.turn.ElementLink;
import org.jucmnav.turn.turn.IntentionalElement;
import org.jucmnav.turn.turn.URNmodelElement;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SGraph;
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
