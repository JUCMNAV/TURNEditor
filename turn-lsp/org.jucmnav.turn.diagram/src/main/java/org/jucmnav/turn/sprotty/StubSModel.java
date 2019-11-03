package org.jucmnav.turn.sprotty;

import java.util.List;

import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.Stub;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;

public class StubSModel implements TurnSModel {

	private static final String TYPE = "turnnode:stub";
	private Stub stub;
	
	public StubSModel(Stub stub) {
		this.stub = stub;
	}
	@Override
	public SModelElement generate() {
		return new TURNNode(s -> {
			s.setType(TYPE);
			s.setId(stub.getLongName().getLongname());
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
	@Override
	public List<SModelElement> generateChildrenForSGraph() {
		// TODO Auto-generated method stub
		return null;
	}

}
