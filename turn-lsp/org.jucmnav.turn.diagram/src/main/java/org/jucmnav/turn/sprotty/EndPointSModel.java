package org.jucmnav.turn.sprotty;

import java.util.List;
import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.EndPoint;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;

public class EndPointSModel implements TurnSModel {

	private static final String TYPE = "turnnode:endpoint";
	private EndPoint endPoint;
	
	public EndPointSModel(EndPoint endPoint) {
		this.endPoint = endPoint;
	}
	@Override
	public SModelElement generate() {
		return new TURNNode(end -> {
			end.setType(TYPE);
			end.setId(endPoint.getLongName().getLongname());
			end.setLayoutOptions(getLayoutOptions());
			end.setChildren(generateChildren());
		});
	}

	@Override
	public List<SModelElement> generateChildren() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private LayoutOptions getLayoutOptions() {
		return new LayoutOptions(options -> {
			//TODO: set layoutOptions
		});
	}

}
