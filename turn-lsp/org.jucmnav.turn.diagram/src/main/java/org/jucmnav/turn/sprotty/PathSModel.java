package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jucmnav.turn.mapping.TurnSModelMapper;
import org.jucmnav.turn.turn.EndpointWithConnect;
import org.jucmnav.turn.turn.Path;
import org.jucmnav.turn.turn.PathBody;
import org.jucmnav.turn.turn.PathBodyNode;
import org.jucmnav.turn.turn.PathBodyNodes;
import org.jucmnav.turn.turn.URNmodelElement;

import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SModelElement;

public class PathSModel implements TurnSModel {

	private Path path;
	
	public PathSModel(Path path) {
		this.path = path;
	}

	@Override
	public List<SModelElement> generateChildren() {
		
		List<SModelElement> children = new ArrayList<>();
		PathBody pathBody = path.getPathBody();
		
		StartPointSModel startPointSModel = new StartPointSModel(path.getStartPoint());
		children.add(startPointSModel.generate());
		
		List<PathBodyNode> pathBodyNodes = ((PathBodyNodes)pathBody).getPathNodes();
		for(PathBodyNode node : pathBodyNodes) {
			TurnSModel turnSModel = TurnSModelMapper.mapURNmodelElementToSModel((URNmodelElement)node);
			children.add(turnSModel.generate());
		}

		children.add(generateEndPathElementSModelElement());
		
		children = generateNodeConnections(children);
		
		return children;
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

	private SModelElement generateEndPathElementSModelElement() {
		
		URNmodelElement endPathModelElement = null;
		PathBody pathBody = path.getPathBody();
		
		if(pathBody.getPathEnd() != null) {
			//TODO: Issue #13 - EndpointWithConnect and EndPoint not a URNmodelElement
			if(pathBody.getPathEnd() instanceof EndpointWithConnect) {
				EndPointSModel endpointSModel = new EndPointSModel(((EndpointWithConnect) pathBody.getPathEnd()).getRegularEnd());
				return endpointSModel.generate();
			}else {
				endPathModelElement = (URNmodelElement) pathBody.getPathEnd();
			}		
		}else if(pathBody.getReferencedEnd() != null) {
			endPathModelElement = (URNmodelElement) pathBody.getReferencedEnd();
		}else if(pathBody.getReferencedStub() != null) {
			endPathModelElement = (URNmodelElement) pathBody.getReferencedStub();
		}
		
		TurnSModel turnSModel = TurnSModelMapper.mapURNmodelElementToSModel(endPathModelElement);
		return turnSModel.generate();
	}

	@Override
	public SModelElement generate() {
		// TODO Auto-generated method stub
		return null;
	}

}
