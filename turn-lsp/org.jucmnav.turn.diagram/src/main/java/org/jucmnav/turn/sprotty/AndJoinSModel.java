package org.jucmnav.turn.sprotty;

import java.util.List;

import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.AndJoin;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;

public class AndJoinSModel implements TurnSModel {

	private static final String TYPE = "turnnode:andJoin";
	private AndJoin andJoin;
	
	public AndJoinSModel(AndJoin andJoin) {
		this.andJoin = andJoin;
	}
	@Override
	public SModelElement generate() {
		return new TURNNode(join -> {
			join.setType(TYPE);
			join.setId(andJoin.getLongName().getLongname());//TODO: is this really what we want?
			join.setLayoutOptions(getLayoutOptions());
			join.setChildren(generateChildren());
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
