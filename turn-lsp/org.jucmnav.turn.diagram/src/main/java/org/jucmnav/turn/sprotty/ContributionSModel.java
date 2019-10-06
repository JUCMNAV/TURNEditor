package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;

import org.jucmnav.turn.turn.Contribution;
import org.jucmnav.turn.turn.ContributionType;
import org.jucmnav.turn.turn.IntentionalElement;

import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SLabel;
import io.typefox.sprotty.api.SModelElement;

public class ContributionSModel implements TurnSModel {

	private static String CONTRIBUTE_EDGE_TYPE = "contribute";
	private static String CORRELATION_EDGE_TYPE = "correlated";
	
	private Contribution contribution;
	
	public ContributionSModel(Contribution contribution) {
		this.contribution = contribution;
	}
	
	@Override
	public SModelElement generate() {
		
		String sourceId = ((IntentionalElement) contribution.eContainer()).getLongName().getLongname();
		String targetId = contribution.getDest().getLongName().getLongname();
		String edgeType = "edge:" + (contribution.isCorrelation() ? CORRELATION_EDGE_TYPE : CONTRIBUTE_EDGE_TYPE);
		String id = sourceId + "2" + targetId + "importance";
		
		List<SModelElement> contributionChildren = new ArrayList<>();
		
		new SLabel(l -> {
			l.setId(id + "-label");
			l.setType("label:heading");
			l.setText(createContributionLabelString());
			contributionChildren.add(l);
		});
		
		SEdge contributionEdge = new SEdge(e -> {
			e.setId(id);
			e.setType(edgeType);
			e.setSourceId(sourceId);
			e.setTargetId(targetId);
			e.setChildren(contributionChildren);
		});
		
		return contributionEdge;
	}

	@Override
	public List<SModelElement> generateChildren() {
		return new ArrayList<SModelElement>();
	}
	
	private String createContributionLabelString() {
		String contributionLabel = "" + contribution.getQuantitativeContribution();
		if(contributionLabel == "0" || contribution.getContribution().getValue() == ContributionType.UNKNOWN_VALUE) {
			contributionLabel = contribution.getContribution().toString();
		}
		return contributionLabel;
	}

}
