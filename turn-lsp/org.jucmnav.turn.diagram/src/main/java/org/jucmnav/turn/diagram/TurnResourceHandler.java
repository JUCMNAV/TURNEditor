package org.jucmnav.turn.diagram;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.resource.XtextResource;
import org.jucmnav.turn.turn.URNmodelElement;
import org.jucmnav.turn.turn.URNspec;

public class TurnResourceHandler {
	
	private static Logger LOGGER = Logger.getLogger(TurnResourceHandler.class);
	
	private XtextResource turnResource;

	public TurnResourceHandler(XtextResource turnResource) {
		this.turnResource = turnResource;
	}
	
	public URNmodelElement getTurnElementFromName(String name){		
		URNspec urnSpec = (URNspec) turnResource.getParseResult().getRootNode().getSemanticElement();	
		return findTurnElement(urnSpec, name);
	}
	
	private URNmodelElement findTurnElement(URNspec urnSpec, String name) {
		URNmodelElement turnElement = null;
		for(EObject obj : urnSpec.eContents()) {
			EStructuralFeature nameFeature = obj.eClass().getEStructuralFeature("Name");
			String objName = Objects.toString(obj.eGet(nameFeature), "");
			if(name.equals(objName)){
				turnElement = (URNmodelElement) obj;
				break;
			}		
		}
		return turnElement;
	}
	
}
