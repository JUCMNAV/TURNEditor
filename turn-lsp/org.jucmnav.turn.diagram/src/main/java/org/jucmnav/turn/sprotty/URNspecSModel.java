package org.jucmnav.turn.sprotty;

import java.util.List;

import org.jucmnav.turn.turn.URNmodelElement;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SGraph;
import io.typefox.sprotty.api.SModelElement;

public class URNspecSModel implements TurnSModel {

	private static final String TYPE = "graph";
	private static final String ID = "turn";
	
	private URNmodelElement rootElement;

	public URNspecSModel(URNmodelElement urnModelElement) {
		this.rootElement = urnModelElement;
	}
	
	@Override
	public SModelElement generate() {
		SGraph graph = new SGraph();
		graph.setType(TYPE);
		graph.setId(ID);
		graph.setLayoutOptions(getRootLayoutOptions());
		graph.setChildren(generateChildren());
		return graph;
	}

	@Override
	public List<SModelElement> generateChildren() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private LayoutOptions getRootLayoutOptions() {
		return new LayoutOptions(options -> {
			options.setHAlign("left");
			options.setHGap(0.0);
			options.setVGap(10.0);
			options.setPaddingLeft(0.0);
			options.setPaddingRight(0.0);
			options.setPaddingTop(0.0);
			options.setPaddingBottom(0.0);
		});
	}

}
