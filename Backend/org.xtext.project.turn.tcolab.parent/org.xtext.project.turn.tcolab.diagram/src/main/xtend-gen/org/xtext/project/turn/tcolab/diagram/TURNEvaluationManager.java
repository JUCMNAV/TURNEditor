package org.xtext.project.turn.tcolab.diagram;

import java.util.*;
import java.util.Map.Entry;
import org.xtext.project.turn.turn.Actor;
import org.xtext.project.turn.turn.Contribution;
import org.xtext.project.turn.turn.Decomposition;
import org.xtext.project.turn.turn.DecompositionType;
import org.xtext.project.turn.turn.Dependency;
import org.xtext.project.turn.turn.ElementLink;
import org.xtext.project.turn.turn.IntentionalElement;
import org.xtext.project.turn.turn.Evaluation;
import org.xtext.project.turn.turn.EvaluationStrategy;
import org.xtext.project.turn.turn.URNspec;
import org.xtext.project.turn.turn.EvaluationStrategy;
import org.xtext.project.turn.turn.ImportanceType;
import java.util.Arrays;
import java.util.List;

public class TURNEvaluationManager {

	private EvaluationStrategy strategy;
	private HashMap<IntentionalElement, Integer> evaluations = new HashMap<IntentionalElement, Integer>();
	private List<IntentionalElement> evalReady = new ArrayList<IntentionalElement>();
	private HashMap<IntentionalElement, Integer> counts = new HashMap<IntentionalElement, Integer>();
	private HashMap<IntentionalElement, List<ElementLink>> incomingLinks = new HashMap<IntentionalElement, List<ElementLink>>();

	TURNEvaluationManager(EvaluationStrategy strategy) {
		this.strategy = strategy;
		init();
		evaluateModel();
	}

	private void evaluateModel() {
		while (!evalReady.isEmpty()) {
			IntentionalElement ie = evalReady.remove(0);
			Integer evalValue = evaluations.get(ie);
			if (evalValue == null) {
				int result = calculate(ie, strategy);
				evaluations.put(ie, result);
			}
			for (ElementLink link : ie.getLinksSrc()) {
				if (link instanceof Contribution) {
					IntentionalElement dest = ((Contribution) link).getDest();
					int count = counts.get(dest) - 1;
					counts.put(dest, count);
					if (count == 0) {
						evalReady.add(dest);
					}
				}
				if (link instanceof Decomposition) {
					IntentionalElement dest = ((Decomposition) link).getDest();
					int count = counts.get(dest) - 1;
					counts.put(dest, count);
					if (count == 0) {
						evalReady.add(dest);
					}
				}
				if (link instanceof Dependency) {
					IntentionalElement dest = ((Dependency) link).getDest();
					int count = counts.get(dest) - 1;
					counts.put(dest, count);
					if (count == 0) {
						evalReady.add(dest);
					}
				}
			}
		}
	}

	public int getEvaluation(IntentionalElement ie) {
		Integer eval = evaluations.get(ie);
		return eval;
	}

	public void init() {
		for (Actor actor : ((URNspec) strategy.eContainer()).getActors()) {
			for (IntentionalElement ie : actor.getElems()) {
				counts.put(ie, 0);
				incomingLinks.put(ie, new ArrayList<ElementLink>());
			}
		}
		for (Actor actor : ((URNspec) strategy.eContainer()).getActors()) {
			for (IntentionalElement ie : actor.getElems()) {
				for (ElementLink link : ie.getLinksSrc()) {
					if (link instanceof Contribution) {
						IntentionalElement dest = ((Contribution) link).getDest();
						counts.put(dest, counts.get(dest) + 1);
						List<ElementLink> listl = incomingLinks.get(dest);
						listl.add(link);
						incomingLinks.put(dest, listl);
					}
					if (link instanceof Decomposition) {
						IntentionalElement dest = ((Decomposition) link).getDest();
						counts.put(dest, counts.get(dest) + 1);
						List<ElementLink> listl = incomingLinks.get(dest);
						listl.add(link);
						incomingLinks.put(dest, listl);
					}
					if (link instanceof Dependency) {
						IntentionalElement dest = ((Dependency) link).getDest();
						counts.put(dest, counts.get(dest) + 1);
						List<ElementLink> listl = incomingLinks.get(dest);
						listl.add(link);
						incomingLinks.put(dest, listl);
					}
				}
			}
		}
		for (Entry<IntentionalElement, Integer> e : counts.entrySet()) {
			if ((Integer) e.getValue() == 0) {
				evalReady.add((IntentionalElement) e.getKey());
				evaluations.put((IntentionalElement) e.getKey(), 0);
			}
		}
		for (Evaluation eval : strategy.getEvaluations()) {
			evaluations.put(eval.getIntElement(), eval.getEvaluation());
		}
	}

	private int calculate(IntentionalElement ie, EvaluationStrategy strategy) {
		int decompVal = -999;
		for (ElementLink link : incomingLinks.get(ie)) {
			if (link instanceof Decomposition) {
				IntentionalElement sourceElement = (IntentionalElement) link.eContainer();
				Integer evalVal = evaluations.get(sourceElement);
				if (((Decomposition) ie).getDecompositionType() == DecompositionType.AND) {
					if (decompVal != -999)
						decompVal = Math.min(evalVal, decompVal);
					else
						decompVal = evalVal;
				} else if (((Decomposition) ie).getDecompositionType() == DecompositionType.OR
						|| ((Decomposition) ie).getDecompositionType() == DecompositionType.XOR) {
					decompVal = Math.max(evalVal, decompVal);
				}
			}
		}

		int totalContrib = 0;
		for (ElementLink link : incomingLinks.get(ie)) {
			if (link instanceof Contribution) {
				Integer quantContri = ((Contribution) link).getQuantitativeContribution();
				IntentionalElement sourceElement = (IntentionalElement) link.eContainer();
				Integer evalVal = evaluations.get(sourceElement);

				int contribValue = evalVal * quantContri;
				totalContrib += contribValue;
			}
		}
		if (decompVal != -999) {
			totalContrib += decompVal;
		}
		int dependVal = totalContrib / 100;

		for (ElementLink link : ie.getLinksSrc()) {
			if (link instanceof Dependency) {
				IntentionalElement destElement = ((Dependency) link).getDest();
				Integer evalDVal = evaluations.get(destElement);
				dependVal = Math.min(evalDVal, dependVal);
			}
		}
		return dependVal;
	}

}
