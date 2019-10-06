package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

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
	
	//TODO: from previous TurnDiagramGenerator this is the diagram root,
	// therefore it must be placed elsewhere (not in the ActorSModel class),
	// thinking it must go somewhere in URNspecSModel (top level of TURN)
	// and from there, determine root element (Actor, UCMmap, ScenarioDef, etc.)
	// OR
	// create ActorSModelRoot class (eventually UCMmapSModelRoot class) (MAYBE)
	@Override
	public SModelElement generate() {
		SGraph graph = new SGraph();
		//graph.setType(TYPE);
		//graph.setId(ID);
		//graph.setLayoutOptions(getRootLayoutOptions());
		//graph.setChildren(generateChildren());
		return graph;
	}
	
	@Override
	public List<SModelElement> generateChildren(){		
		List<SModelElement> children = new ArrayList<>();		
		for(IntentionalElement ie : actor.getElems()) {
			IntentionalElementSModel ieSModel = new IntentionalElementSModel(ie);
			children.add(ieSModel.generate());
			for(ElementLink elementLink : ie.getLinksSrc()) {
				TurnSModel elementLinkSModel = TurnSModelMapper.mapURNmodelElementToSModel((URNmodelElement) elementLink);
				children.add(elementLinkSModel.generate());
			}
		}		
		return children;
	}
	

}
