package org.jucmnav.turn.sprotty;

import java.util.List;

import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.OrJoin;

import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;

public class OrJoinSModel implements TurnSModel {

	private static final String TYPE = "turnnode:orJoin";
	private OrJoin orJoin;
	
	public OrJoinSModel(OrJoin orJoin) {
		this.orJoin = orJoin;
	}
	
	@Override
	public SModelElement generate() {
		return new TURNNode(join -> {
			join.setType(TYPE);
			join.setId(orJoin.getLongName().getLongname());
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
