package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;
import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.OrFork;
import org.jucmnav.turn.turn.RegularOrFork;
import io.typefox.sprotty.api.SEdge;
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
		});
	}

	@Override
	public List<SModelElement> generateChildren() {
		return null;
	}

	@Override
	public List<SModelElement> generateChildrenForSGraph() {
		
		List<SModelElement> graphChildren = new ArrayList<>();
		for(RegularOrFork rof : orFork.getBody().getRegularBody()) {
			PathBodySModel pathBodySModel = new PathBodySModel(orFork, rof.getPathBody());
			graphChildren.addAll(pathBodySModel.generateChildrenForSGraph());
		}
		
		if(orFork.getConnectingOrBody() != null) {
			PathBodySModel pathBodySModel = new PathBodySModel(orFork.getConnectingOrBody(), orFork.getConnectingOrBody());
			graphChildren.addAll(pathBodySModel.generateChildrenForSGraph());
			graphChildren.addAll(createEdgeFromForkToJoin());//TODO: analyze if needed when else body present on orFork element
		}
		if(orFork.getBody().getElseBody() != null) {
			//TODO
		}
		
		return graphChildren;
	}
	
	private List<SModelElement> createEdgeFromForkToJoin() {
		
		List<SModelElement> edgeElements = new ArrayList<>();
		
		String sourceId = Integer.toHexString(orFork.hashCode());
		String targetId = String.format("join-%s", Integer.toHexString(orFork.getConnectingOrBody().hashCode()));
		
		TURNNode emptyNode = new TURNNode(n -> {
			n.setType("turnnode:empty");
			n.setId(String.format("empty-%s", sourceId));
		});
		
		edgeElements.add(emptyNode);
		
		edgeElements.add(new SEdge(e -> {
			e.setType("edge:connection");
			e.setId(String.format("%s-to-%s", sourceId, emptyNode.getId()));
			e.setSourceId(sourceId);
			e.setTargetId(emptyNode.getId());
		}));
		
		edgeElements.add(new SEdge(e -> {
			e.setType("edge:connection");
			e.setId(String.format("%s-to-%s", emptyNode.getId(), targetId));
			e.setSourceId(emptyNode.getId());
			e.setTargetId(targetId);
		}));
		
		return edgeElements;
		
	}
	

}
