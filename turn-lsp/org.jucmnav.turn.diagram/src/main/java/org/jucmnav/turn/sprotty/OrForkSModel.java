package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.OrFork;
import org.jucmnav.turn.turn.RegularOrFork;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;

public class OrForkSModel implements TurnSModel {

	private static final String TYPE = "turnnode:orFork";
	private OrFork orFork;
	
	public OrForkSModel(OrFork orFork) {
		this.orFork = orFork;
	}
	
	@Override
	public SModelElement generate() {
		return new TURNNode(fork -> {
			fork.setType(TYPE);
			fork.setId(Integer.toHexString(orFork.hashCode()));
			fork.setLayoutOptions(getLayoutOptions());
			fork.setChildren(generateChildren());
		});
	}

	@Override
	public List<SModelElement> generateChildren() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private LayoutOptions getLayoutOptions() {
		return new LayoutOptions(options ->{
			//TODO: set layoutOptions
		});
	}

	@Override
	public List<SModelElement> generateChildrenForSGraph() {
		List<SModelElement> graphChildren = new ArrayList<>();
		for(RegularOrFork rof : orFork.getBody().getRegularBody()) {
			PathBodySModel pathBodySModel = new PathBodySModel(orFork, rof.getPathBody());
			graphChildren.addAll(pathBodySModel.generateChildrenForSGraph());
		}
		return graphChildren;
	}

}
