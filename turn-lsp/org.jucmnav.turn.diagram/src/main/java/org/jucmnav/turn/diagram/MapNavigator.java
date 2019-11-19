package org.jucmnav.turn.diagram;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.apache.log4j.Logger;
import org.jucmnav.turn.sprotty.PathPair;
import org.jucmnav.turn.turn.AndFork;
import org.jucmnav.turn.turn.EndpointWithConnect;
import org.jucmnav.turn.turn.OrFork;
import org.jucmnav.turn.turn.Path;
import org.jucmnav.turn.turn.PathBody;
import org.jucmnav.turn.turn.PathBodyNode;
import org.jucmnav.turn.turn.PathBodyNodes;
import org.jucmnav.turn.turn.RegularOrFork;
import org.jucmnav.turn.turn.Stub;
import org.jucmnav.turn.turn.UCMmap;
import org.jucmnav.turn.turn.URNmodelElement;

public class MapNavigator implements Iterator<PathPair> {
	
	private static Logger LOGGER = Logger.getLogger(MapNavigator.class);
	
	private UCMmap ucmMap;
	private ListIterator<PathPair> pathPairs;
	
	public MapNavigator(UCMmap ucmMap) {
		this.ucmMap = ucmMap;
		this.pathPairs = new ArrayList<PathPair>().listIterator();
	}
	
	public void populatePathPairs() {
		for(Path path : ucmMap.getPaths()) {
			navigatePath(path.getStartPoint(), path.getPathBody());
		}
	}

	@Override
	public boolean hasNext() {
		return pathPairs.hasPrevious();
	}

	@Override
	public PathPair next() {
		return pathPairs.previous();
	}
	
	private void navigatePath(URNmodelElement startingElement, PathBody pathBody) {
		
		URNmodelElement currentElement = startingElement;
		URNmodelElement nextElement;
		
		ListIterator<PathBodyNode> pathBodyNode = ((PathBodyNodes) pathBody).getPathNodes().listIterator();
		while(pathBodyNode.hasNext()) {
			nextElement = (URNmodelElement) pathBodyNode.next();
			pathPairs.add(new PathPair(currentElement, nextElement));
			currentElement = nextElement;
			nextElement = null;
		}
		
		nextElement = getPathEndElement(pathBody, startingElement);
		pathPairs.add(new PathPair(currentElement, nextElement));
		
		if(nextElement instanceof OrFork) {
			if(((OrFork) nextElement).getBody().getRegularBody().size() == 1) {
				pathPairs.add(new PathPair(nextElement, ((OrFork) nextElement).getConnectingOrBody()));
			}
			for(RegularOrFork rof : ((OrFork) nextElement).getBody().getRegularBody()) {
				navigatePath(nextElement, rof.getPathBody());
			}
			if(((OrFork) nextElement).getBody().getElseBody() != null) {
				navigatePath(nextElement, ((OrFork) nextElement).getBody().getElseBody());
			}
			
		}else if(nextElement instanceof AndFork) {
			for(PathBody pb : ((AndFork) nextElement).getPathbody() ) {
				navigatePath(nextElement, pb);
			}
		}else if(nextElement instanceof PathBody) {
			navigatePath((URNmodelElement) nextElement, (PathBody) nextElement);
		}
		
	}

	private URNmodelElement getPathEndElement(PathBody pathBody, URNmodelElement startingElement) {
		URNmodelElement endPathElement = null;
		if(pathBody.getPathEnd() != null) {
			//TODO: Issue #13 - EndpointWithConnect and EndPoint not a URNmodelElement
			if(pathBody.getPathEnd() instanceof EndpointWithConnect) {
				endPathElement = (URNmodelElement) ((EndpointWithConnect) pathBody.getPathEnd()).getRegularEnd();
			}else {
				endPathElement = (URNmodelElement) pathBody.getPathEnd();
			}		
		}else if(pathBody.getReferencedEnd() != null) {
			endPathElement = (URNmodelElement) pathBody.getReferencedEnd();
		}else if(pathBody.getReferencedStub() != null) {
			endPathElement = (URNmodelElement) pathBody.getReferencedStub();
		}else {
			if(startingElement instanceof OrFork) {
				endPathElement = ((OrFork) startingElement).getConnectingOrBody();
			}else if(startingElement instanceof AndFork) {
				endPathElement = ((AndFork) startingElement).getConnectingAndBody();
			}else if (startingElement instanceof Stub) {
				endPathElement = ((Stub) startingElement).getConnectingStubBody();
			}
		}
		return endPathElement;
	}

}
