package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;
import org.jucmnav.turn.mapping.TurnSModelMapper;
import org.jucmnav.turn.turn.EndpointWithConnect;
import org.jucmnav.turn.turn.PathBody;
import org.jucmnav.turn.turn.PathBodyNode;
import org.jucmnav.turn.turn.PathBodyNodes;
import org.jucmnav.turn.turn.URNmodelElement;

import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SModelElement;

public class PathBodySModel implements TurnSModel {
	
	private URNmodelElement startElement;
	private PathBody pathBody;
	
	public PathBodySModel(URNmodelElement startElement, PathBody pathBody) {
		this.startElement = startElement;
		this.pathBody = pathBody;
	}

	@Override
	public SModelElement generate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SModelElement> generateChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SModelElement> generateChildrenForSGraph() {
		List<SModelElement> pathChildren = new ArrayList<>();
		List<SModelElement> graphChildren = new ArrayList<>();
		
		TurnSModel startElementSModel = TurnSModelMapper.mapURNmodelElementToSModel(startElement);
		SModelElement startPointSModelElement = startElementSModel.generate();
		pathChildren.add(startPointSModelElement);
		
		List<PathBodyNode> pathBodyNodes = ((PathBodyNodes)pathBody).getPathNodes();
		for(PathBodyNode node : pathBodyNodes) {
			TurnSModel turnSModel = TurnSModelMapper.mapURNmodelElementToSModel((URNmodelElement)node);
			pathChildren.add(turnSModel.generate());
		}
		
		TurnSModel regularEndSModel = getURNSModel();
		pathChildren.add(regularEndSModel.generate());
		List<SModelElement> regularEndGraphChildren = regularEndSModel.generateChildrenForSGraph();
		if(regularEndGraphChildren != null && !regularEndGraphChildren.isEmpty()) {
			graphChildren.addAll(regularEndGraphChildren);
		}
		
		graphChildren.addAll(generateNodeConnections(pathChildren));
		
		return graphChildren;
	}
	
	private List<SModelElement> generateNodeConnections(List<SModelElement> children) {
		
		List<SModelElement> nodeConnections = new ArrayList<>();
		
		SModelElement source;
		SModelElement target;
		
		for(int i = 0; i < children.size()-1; i++) {
			source = children.get(i);
			target = children.get(i+1);
			SEdge edge = new SEdge();
			edge.setType("edge:connection");
			edge.setId(String.format("%s-to-%s", source.getId(), target.getId()));
			edge.setSourceId(source.getId());
			edge.setTargetId(target.getId());
			nodeConnections.add(edge);
		}
		
		children.addAll(nodeConnections);
		
		return children;
	}

	//TODO: rename this method
	private TurnSModel getURNSModel() {
		
		URNmodelElement endPathModelElement = null;
		
		if(pathBody.getPathEnd() != null) {
			//TODO: Issue #13 - EndpointWithConnect and EndPoint not a URNmodelElement
			if(pathBody.getPathEnd() instanceof EndpointWithConnect) {
				return new EndPointSModel(((EndpointWithConnect) pathBody.getPathEnd()).getRegularEnd());
			}else {
				endPathModelElement = (URNmodelElement) pathBody.getPathEnd();
			}		
		}else if(pathBody.getReferencedEnd() != null) {
			endPathModelElement = (URNmodelElement) pathBody.getReferencedEnd();
		}else if(pathBody.getReferencedStub() != null) {
			endPathModelElement = (URNmodelElement) pathBody.getReferencedStub();
		}
		
		return TurnSModelMapper.mapURNmodelElementToSModel(endPathModelElement);
	}

}
