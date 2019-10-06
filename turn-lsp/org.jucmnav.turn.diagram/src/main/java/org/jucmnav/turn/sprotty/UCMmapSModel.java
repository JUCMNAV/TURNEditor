package org.jucmnav.turn.sprotty;

import java.util.List;

import org.jucmnav.turn.turn.UCMmap;

import io.typefox.sprotty.api.SModelElement;

public class UCMmapSModel implements TurnSModel {

	private UCMmap ucmMap;
	
	public UCMmapSModel(UCMmap ucmMap) {
		this.ucmMap = ucmMap;
	}
	
	@Override
	public SModelElement generate() {
		return null;
	}

	@Override
	public List<SModelElement> generateChildren() {
		return null;
	}

}
