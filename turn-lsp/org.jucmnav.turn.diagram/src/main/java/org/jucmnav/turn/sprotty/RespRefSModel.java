package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import io.typefox.sprotty.api.SCompartment;
import io.typefox.sprotty.api.SLabel;
import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.RespRef;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;

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
		List<SModelElement> compartments = new ArrayList<>();
		List<SModelElement> labels = new ArrayList<>();
		SLabel label = new SLabel();
		label.setText(respRef.getName());
		label.setId(Integer.toHexString(label.hashCode()));
		label.setType("label:heading");
		labels.add(label);
		SCompartment compartment = new SCompartment();
		compartment.setLayout("hbox");
		compartment.setId(Integer.toHexString(compartment.hashCode()));
		compartment.setType("comp:comp");
		compartment.setChildren(labels);
		compartments.add(compartment);
		return compartments;
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
