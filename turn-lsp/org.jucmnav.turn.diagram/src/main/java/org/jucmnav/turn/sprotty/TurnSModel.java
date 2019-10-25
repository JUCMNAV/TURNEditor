package org.jucmnav.turn.sprotty;

import java.util.List;
import io.typefox.sprotty.api.SModelElement;

public interface TurnSModel {

	SModelElement generate();
	List<SModelElement> generateChildren();
	
}
