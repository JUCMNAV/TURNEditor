package org.jucmnav.turn.sprotty;

import java.util.List;

import org.jucmnav.turn.mapping.TurnSModelMapper;
import org.jucmnav.turn.turn.Actor;
import org.jucmnav.turn.turn.Dependency;
import org.jucmnav.turn.turn.IntentionalElement;

import io.typefox.sprotty.api.SModelElement;

public class DependencySModel implements TurnSModel {

	private static String DEPENDENCY_EDGE_TYPE = "dependency";
	
	private Dependency dependency;
	
	public DependencySModel(Dependency dependency) {
		this.dependency = dependency;
	}
	
	@Override
	public SModelElement generate() {
		
		IntentionalElement source = (IntentionalElement) dependency.eContainer();
		String sourceId = source.getLongName().getLongname();
		String targetId = "";
		Actor sourceActor = (Actor) source.eContainer();
		if(sourceActor.getElems().contains(dependency.getDest())) {
			targetId = dependency.getDest().getLongName().getLongname();
		}else {
			TurnSModel actorSModel = TurnSModelMapper.mapURNmodelElementToSModel((Actor) dependency.getDest().eContainer());
			//TODO: finish this
		}
		
		
		return null;
	}

	@Override
	public List<SModelElement> generateChildren() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String defineTargetId() {
		return null;
	}

}
