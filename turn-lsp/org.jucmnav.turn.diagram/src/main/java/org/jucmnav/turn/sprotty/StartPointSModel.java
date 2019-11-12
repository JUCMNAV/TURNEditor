package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import io.typefox.sprotty.api.Point;
import org.jucmnav.turn.diagram.TURNLabel;
import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.StartPoint;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;

public class StartPointSModel implements TurnSModel {
	
	private static final String TYPE = "turnnode:startpoint";
	private StartPoint startPoint;
	
	public StartPointSModel(StartPoint startPoint) {
		this.startPoint = startPoint;
	}

	@Override
	public SModelElement generate() {
		return new TURNNode(s -> {
			s.setType(TYPE);
			s.setId(Integer.toHexString(startPoint.hashCode()));
			s.setLayoutOptions(getLayoutOptions());
			s.setChildren(generateChildren());
		});
	}

	@Override
	public List<SModelElement> generateChildren() {
		List<SModelElement> labels = new ArrayList<>();
		TURNLabel label = new TURNLabel();
		label.setText(startPoint.getName());
		label.setId(startPoint.getName());
		label.setType("turnlabel:text");
		label.setPosition(new Point(0d, 52d));
		labels.add(label);
		return labels;
	}
	
	private LayoutOptions getLayoutOptions() {
		return new LayoutOptions(options ->{
			//TODO: set layoutOptions
		});
	}

	@Override
	public List<SModelElement> generateChildrenForSGraph() {
		// TODO Auto-generated method stub
		return null;
	}

}
