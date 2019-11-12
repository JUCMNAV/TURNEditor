package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import io.typefox.sprotty.api.Point;
import org.jucmnav.turn.diagram.TURNLabel;
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
			end.setId(Integer.toHexString(endPoint.hashCode()));
			end.setLayoutOptions(getLayoutOptions());
			end.setChildren(generateChildren());
		});
	}

	@Override
	public List<SModelElement> generateChildren() {
		List<SModelElement> labels = new ArrayList<>();
		TURNLabel label = new TURNLabel();
		label.setText(endPoint.getName());
		label.setId(endPoint.getName());
		label.setType("turnlabel:text");
		label.setPosition(new Point(0d, 52d));
		labels.add(label);
		return labels;
	}
	
	private LayoutOptions getLayoutOptions() {
		return new LayoutOptions(options -> {
		});
	}
	@Override
	public List<SModelElement> generateChildrenForSGraph() {
		// TODO Auto-generated method stub
		return null;
	}

}
