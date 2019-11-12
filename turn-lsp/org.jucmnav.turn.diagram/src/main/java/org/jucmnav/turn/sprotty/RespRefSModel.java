package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import io.typefox.sprotty.api.*;
import org.jucmnav.turn.diagram.TURNLabel;
import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.RespRef;

public class RespRefSModel implements TurnSModel {

	private static final String TYPE = "turnnode:responsibility";
	private RespRef respRef;
	
	public RespRefSModel(RespRef respRef) {
		this.respRef = respRef;
	}
	
	@Override
	public SModelElement generate() {
		return new TURNNode(r -> {
			r.setType(TYPE);
			r.setId(Integer.toHexString(respRef.hashCode()));
			r.setLayoutOptions(getLayoutOptions());
			r.setChildren(generateChildren());
		});
	}

	@Override
	public List<SModelElement> generateChildren() {
		List<SModelElement> labels = new ArrayList<>();
        TURNLabel label = new TURNLabel();
        label.setText(respRef.getName());
        label.setId(respRef.getName());
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
