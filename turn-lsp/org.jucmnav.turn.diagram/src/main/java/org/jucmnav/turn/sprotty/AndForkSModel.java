package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.AndFork;
import org.jucmnav.turn.turn.PathBody;
import io.typefox.sprotty.api.SModelElement;

public class AndForkSModel implements TurnSModel {

	private static final String TYPE = "turnnode:andFork";
	private AndFork andFork;
	
	public AndForkSModel(AndFork andFork) {
		this.andFork = andFork;
	}
	@Override
	public SModelElement generate() {
		return new TURNNode(fork ->{
			fork.setType(TYPE);
			fork.setId(Integer.toHexString(andFork.hashCode()));
			fork.setChildren(generateChildren());
		});
	}

	@Override
	public List<SModelElement> generateChildren() {
		return null;
	}
	
	@Override
	public List<SModelElement> generateChildrenForSGraph() {
		List<SModelElement> graphChildren = new ArrayList<>();
		
		for(PathBody pb : andFork.getPathbody() ) {
			PathBodySModel pathBodySModel = new PathBodySModel(andFork, pb);
			graphChildren.addAll(pathBodySModel.generateChildrenForSGraph());
		}
		
		if(andFork.getConnectingAndBody() != null) {
			PathBodySModel pathBodySModel = new PathBodySModel(andFork.getConnectingAndBody(), andFork.getConnectingAndBody());
			graphChildren.addAll(pathBodySModel.generateChildrenForSGraph());
		}
		
		return graphChildren;
	}

}
