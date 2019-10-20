package org.jucmnav.turn.sprotty;

import java.util.List;

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
			s.setId(startPoint.getLongName().getLongname());
			s.setLayoutOptions(getLayoutOptions());
			s.setChildren(generateChildren());
		});
	}

	@Override
	public List<SModelElement> generateChildren() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private LayoutOptions getLayoutOptions() {
		return new LayoutOptions(options ->{
			//TODO: set layoutOptions
		});
	}

}
