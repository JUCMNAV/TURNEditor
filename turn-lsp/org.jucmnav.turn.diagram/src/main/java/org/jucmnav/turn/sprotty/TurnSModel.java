package org.jucmnav.turn.sprotty;

import java.util.List;
import io.typefox.sprotty.api.SModelElement;

public interface TurnSModel {

	/* Generates the TURN SModelElement */
	SModelElement generate();
	/* Generates the direct children of the TURN SModelElement (labels, headers) */
	List<SModelElement> generateChildren();
	/* Generates the children SModelElements that should be direct children of the SGraph*/
	List<SModelElement> generateChildrenForSGraph();
	
}
