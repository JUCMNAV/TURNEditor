package org.jucmnav.turn.sprotty;

import java.util.List;
import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.AndFork;
import org.jucmnav.turn.turn.OrFork;
import org.jucmnav.turn.turn.PathBody;
import org.jucmnav.turn.turn.Stub;

import io.typefox.sprotty.api.SModelElement;

public class ConnectingBodySModel implements TurnSModel {
	
	private PathBody connectingBody;
	
	public ConnectingBodySModel(PathBody connectingBody) {
		this.connectingBody = connectingBody;
	}

	@Override
	public SModelElement generate() {
		SModelElement join = new TURNNode(j -> {
			j.setType(getImplicitJoinType());
			j.setId(String.format("join-%s", Integer.toHexString(connectingBody.hashCode())));
		});
		return join;
	}
	
	private String getImplicitJoinType() {
		String type = "";
		if(connectingBody.eContainer() instanceof OrFork) {
			type = OrJoinSModel.TYPE;
		}else if(connectingBody.eContainer() instanceof AndFork) {
			type = AndJoinSModel.TYPE;
		}else if(connectingBody.eContainer() instanceof Stub) {
			type = "turnnode:stub";
		}
		return type;
	}

	@Override
	public List<SModelElement> generateChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SModelElement> generateChildrenForSGraph() {
		// TODO Auto-generated method stub
		return null;
	}

}
