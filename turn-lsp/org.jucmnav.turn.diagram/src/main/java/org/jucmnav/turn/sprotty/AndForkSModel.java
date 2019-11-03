package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.AndFork;
import org.jucmnav.turn.turn.PathBody;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SEdge;
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
		
		for(PathBody pb : andFork.getPathbody() ) {
			PathBodySModel pathBodySModel = new PathBodySModel(andFork, pb);
			graphChildren.addAll(pathBodySModel.generateChildrenForSGraph());
		}
		
		if(andFork.getConnectingAndBody() != null) {
			PathBodySModel pathBodySModel = new PathBodySModel(andFork.getConnectingAndBody(), andFork.getConnectingAndBody());
			graphChildren.addAll(pathBodySModel.generateChildrenForSGraph());
			graphChildren.addAll(createEdgeFromForkToJoin());
		}
		
		return graphChildren;
	}
	
	private List<SModelElement> createEdgeFromForkToJoin(){
		List<SModelElement> edgeElements = new ArrayList<>();
		
		String sourceId = Integer.toHexString(andFork.hashCode());
		String targetId = String.format("join-%s", Integer.toHexString(andFork.getConnectingAndBody().hashCode()));
		
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
