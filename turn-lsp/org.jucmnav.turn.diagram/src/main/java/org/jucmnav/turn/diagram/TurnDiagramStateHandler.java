package org.jucmnav.turn.diagram;

import io.typefox.sprotty.api.IDiagramState;

public class TurnDiagramStateHandler {

	private static final String SOURCE_URI = "sourceUri";
	
	private IDiagramState diagramState;
	private String sourceUri;
	
	public TurnDiagramStateHandler(IDiagramState diagramState) {
		this.diagramState = diagramState;
		this.sourceUri = diagramState.getOptions().get(SOURCE_URI);
	}
	
	public String getSourceName() {
		String modelElementPath = sourceUri.substring(sourceUri.lastIndexOf("#") + 1);
		String sourceName = modelElementPath.substring(modelElementPath.lastIndexOf(".") + 1);
		return sourceName;
	}
	
}
