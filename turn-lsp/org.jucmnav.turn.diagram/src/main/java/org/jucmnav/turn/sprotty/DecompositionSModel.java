package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;
import org.jucmnav.turn.turn.Decomposition;
import org.jucmnav.turn.turn.IntentionalElement;

import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SLabel;
import io.typefox.sprotty.api.SModelElement;

public class DecompositionSModel implements TurnSModel {

	private static String DECOMPOSITION_EDGE_TYPE = "decomposition";
	
	private Decomposition decomposition;
	
	public DecompositionSModel(Decomposition decomposition) {
		this.decomposition = decomposition;
	}
	
	@Override
	public SModelElement generate() {
		
		String sourceId = ((IntentionalElement) decomposition.eContainer()).getLongName().getLongname();
		String targetId = decomposition.getDest().getLongName().getLongname();
		String edgeType = "edge:" + DECOMPOSITION_EDGE_TYPE;
		String id = sourceId + "2" + targetId + "importance";
		
		List<SModelElement> decompositionChildren = new ArrayList<>();
		
		new SLabel(l -> {
			l.setId(id + "-label");
			l.setType("label:heading");
			l.setText(decomposition.getDecompositionType().getName());
			decompositionChildren.add(l);
		});
		
		SEdge decompositionEdge = new SEdge(e -> {
			e.setId(id);
			e.setType(edgeType);
			e.setSourceId(sourceId);
			e.setTargetId(targetId);
			e.setChildren(decompositionChildren);
		});
		
		return decompositionEdge;
	}

	@Override
	public List<SModelElement> generateChildren() {
		return new ArrayList<SModelElement>();
	}

}
