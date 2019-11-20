package org.jucmnav.turn.diagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.jucmnav.turn.sprotty.PathPair;
import org.jucmnav.turn.turn.URNmodelElement;
import io.typefox.sprotty.api.SModelElement;

public class ModelElementManager {
	
	private static Logger LOGGER = Logger.getLogger(ModelElementManager.class);
	
	private MapNavigator mapNavigator;
	private HashMap<URNmodelElement, SModelElement> turnNodes;
	private HashMap<PathPair, SModelElement> turnEdges;
	
	public ModelElementManager(MapNavigator mapNavigator) {
		this.mapNavigator = mapNavigator;
		this.turnNodes = new HashMap<>();
		this.turnEdges = new HashMap<>();
	}
	
	public List<SModelElement> createSModelElements() {
		
		mapNavigator.populatePathPairs();
		
		while(mapNavigator.hasNext()) {
			
			PathPair pathPair = mapNavigator.next();
			
			LOGGER.info(String.format("Creating SModelElements for path pair %s", pathPair.toString()));
			
			URNmodelElement source = pathPair.getSource();
			URNmodelElement target = pathPair.getTarget();
			
			if(!turnNodes.containsKey(source)) {
				turnNodes.put(source, ModelElementGenerator.createTurnNode(source));
			}
						
			if(target != null) {		
				if(!turnNodes.containsKey(target)) {
					turnNodes.put(target, ModelElementGenerator.createTurnNode(target));
				}
				if(!turnEdges.containsKey(pathPair)) {
					turnEdges.put(pathPair, ModelElementGenerator.createTurnEdge(turnNodes.get(source), turnNodes.get(target)));
				}
			}			
		}
		
		List<SModelElement> elements = new ArrayList<>();
		elements.addAll(turnNodes.values());
		elements.addAll(turnEdges.values());		
		return elements;
		
	}

}
