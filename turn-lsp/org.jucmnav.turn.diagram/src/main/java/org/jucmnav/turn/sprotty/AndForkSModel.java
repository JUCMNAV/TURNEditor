package org.jucmnav.turn.sprotty;

import java.util.List;

import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.AndFork;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;

public class AndForkSModel implements TurnSModel {

	private static final String TYPE = "turnnode:andFork";
	private AndFork andFork;
	
	public AndForkSModel(AndFork andFork) {
		this.andFork = andFork;
	}
	@Override
	public SModelElement generate() {
		return new TURNNode(fork ->{
			fork.setType(TYPE);
			fork.setId(andFork.getLongName().getLongname());//TODO: is this really what we want?
			fork.setLayoutOptions(getLayoutOptions());
			fork.setChildren(generateChildren());
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
