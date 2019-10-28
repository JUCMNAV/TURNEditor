package org.jucmnav.turn.sprotty;

import java.util.List;
import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.RespRef;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SPort;

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
		return null;
	}
	
	private LayoutOptions getLayoutOptions() {
		return new LayoutOptions(options ->{
			//TODO: set layoutOptions
		});
	}

}
