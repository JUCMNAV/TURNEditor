package org.jucmnav.turn.sprotty;

import java.util.List;

import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.ComponentRef;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;

public class ComponentRefSModel implements TurnSModel {
	
	private static final String TYPE = "turnnode:componentRef";
	private ComponentRef compRef;
	
	public ComponentRefSModel(ComponentRef compRef) {
		this.compRef = compRef;
	}

	@Override
	public SModelElement generate() {
		return new TURNNode(comp ->{
			comp.setType(TYPE);
			comp.setId(compRef.getLongName().getLongname());
			comp.setLayoutOptions(getLayoutOptions());
			comp.setChildren(generateChildren());
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
