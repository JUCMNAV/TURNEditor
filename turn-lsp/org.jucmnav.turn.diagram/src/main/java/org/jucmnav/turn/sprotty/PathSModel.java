package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;
import org.jucmnav.turn.mapping.TurnSModelMapper;
import org.jucmnav.turn.turn.EndpointWithConnect;
import org.jucmnav.turn.turn.Path;
import org.jucmnav.turn.turn.PathBody;
import org.jucmnav.turn.turn.PathBodyNode;
import org.jucmnav.turn.turn.PathBodyNodes;
import org.jucmnav.turn.turn.URNmodelElement;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SNode;

public class PathSModel implements TurnSModel {
	
	private static final String TYPE = "pathbox";
	private Path path;
	
	public PathSModel(Path path) {
		this.path = path;
	}

	@Override
	public SModelElement generate() {
		return new SNode(p -> {
			p.setType(TYPE);
			p.setId(Integer.toHexString(path.hashCode()));
			p.setLayoutOptions(getLayoutOptions());
			p.setChildren(generateChildren());
		});
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
	
	//TODO: adjust this!
	private LayoutOptions getLayoutOptions() {
		return new LayoutOptions(options -> {
			options.setHAlign("center");
			options.setHGap(0.0);
			options.setVGap(10.0);
			options.setPaddingLeft(0.0);
			options.setPaddingRight(0.0);
			options.setPaddingTop(0.0);
			options.setPaddingBottom(0.0);
		});
	}

}
